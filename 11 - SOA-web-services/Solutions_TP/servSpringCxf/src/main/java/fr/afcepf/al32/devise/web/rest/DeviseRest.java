package fr.afcepf.al32.devise.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.devise.dto.Devise;
import fr.afcepf.al32.devise.dto.ResConversion;
import fr.afcepf.al32.devise.itf.IServiceDevise;

/* classe java d'implémentation d'un WS REST avec l'api officielle JAX-RS
 * (JAX-RS est dans ce projet géré par CXF)
 * ==> pas de "RPC" vu de l'extérieur , juste un paquets d'URL
 */
@Path("/devise")
@Produces("application/json") //pour que les valeurs de retour "java" soit 
                              //automatiquement converties en "json"
@Component //de Spring
public class DeviseRest {
	
	@Autowired
	private IServiceDevise serviceDevise; //business service interne vers lequel déléguer
	                                      //certains traitements
	
	
	//URL = http://localhost:8080/servSpringCxf/services/rest/devise/EUR
	//où /services est le url-pattern de CxfServlet dans web.xml
    //   /rest est associé à la partie "REST" de beans.xml
	//   /devise/EUR est la concatenation des @Path() de cette classe java
	@GET
	@Path("/{codeMonnaie}")
	public Devise getDeviseByMonnaie(@PathParam("codeMonnaie")String monnaie) {
		return serviceDevise.getDevise(monnaie);
	}
	
	//URL = http://localhost:8080/servSpringCxf
	//             /services/rest/devise/convert?montant=200&source=EUR&cible=JPY
	@GET
	@Path("/convert")
	//@Produces("text/plain")//si return Double
	//ou bien @Produces("application/json")//si return Double intégré dans grand Objet java
	public ResConversion getResConv(@QueryParam("montant")Double montant,
							@QueryParam("source")String mSource,
							@QueryParam("cible")String mCible) {
		Double res= serviceDevise.convertir(montant,mSource,mCible);
		ResConversion resConversion = new ResConversion();
		resConversion.setMontant(montant);
		resConversion.setMonnaieSource(mSource);
		resConversion.setMonnaieCible(mCible);
		resConversion.setMontantConverti(res);
		return resConversion;
	}
	
	//URL = http://localhost:8080/servSpringCxf/services/rest/devise
	//avec dans la partie invisible "body" de la requête HTTP
	//     { "monnaie" : "nouvelleMonnaie" , "change" : 1.67 }
	//---> sera appelé par java , jascript/ajax ou postman 
	@POST
	@Path("")
	@Consumes("application/json") //pour convertir param d'entrée de json en java
	public Devise saveOrUpdateDevise(Devise d) {
		System.out.println("saveOrUpdateDevise avec d="+d);
		//idéalement déléguer saveOrUpdate à "businessService + DAO"
		return d;//avec quelquefois clef primaire autoincrémentée
	}
	

}
