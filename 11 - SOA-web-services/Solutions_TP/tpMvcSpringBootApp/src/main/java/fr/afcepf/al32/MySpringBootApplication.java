package fr.afcepf.al32;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//NB: @SpringBootApplication est un equivalent 
//    de @Configuration + @EnableAutoConfiguration 
//    + @ComponentScan/current package.
//    En mode @EnableAutoConfiguration le fichier application.properties
//    est automatiquement analysé et pris en compte

@SpringBootApplication
public class MySpringBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
    	//démarrage automatique d'un 
    	//"équivalent de tomcat embarqué/imbriqué dans l'application"
        SpringApplication.run(MySpringBootApplication.class, args);
        //afficher l'URL pour effectuer un test via un navigateur.
        System.out.println("http://localhost:8080/tpMvcSpringBootApp");
    }

}