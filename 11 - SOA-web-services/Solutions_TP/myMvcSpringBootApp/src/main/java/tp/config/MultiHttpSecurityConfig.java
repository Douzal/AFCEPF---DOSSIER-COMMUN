package tp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class MultiHttpSecurityConfig {

	private static Logger logger = LoggerFactory.getLogger(MultiHttpSecurityConfig.class);
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); 
    }
	
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication()
	  .withUser("user1").password(passwordEncoder.encode("pwd1")).roles("USER").and()
	  .withUser("admin1").password(passwordEncoder.encode("pwd1")).roles("ADMIN").and()
	  .withUser("user2").password(passwordEncoder.encode("pwd2")).roles("USER").and()
	  .withUser("admin2").password(passwordEncoder.encode("pwd2")).roles("ADMIN");
    }

	
	@Configuration
    @Order(1)  //first choice httpSecurity configuration (for "/api/**" or "/rest/**")                                                      
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
                    	
        	http.antMatcher("/rest/**") /* or "/api/**" */
 	 		 .authorizeRequests()
 	 		   //.antMatchers("/rest/**").permitAll()
 	 		   .anyRequest().permitAll()
 	 		   //.anyRequest().authenticated()
 	 		   //.anyRequest().hasRole("ADMIN")
 	 		   .and().csrf().disable();
 	 			//.and().httpBasic()
        	
        	logger.debug("configure(1) rest,  http:" + http.toString());
        }
    }

    @Configuration
    @Order(2) //second choice httpSecurity configuration (for all uri which don't match 
              // "/api/**" nor "/rest/**")
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                	.antMatchers("/",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js").permitAll()
                    .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and().csrf();
        	
        	logger.debug("configure(2) mvc,  http:" + http.toString());
        }
        
    }

}
