package fr.afcepf.al32.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al32.dto.Blague;

/* IT: Integration Test 
   on teste le comportement de l'ensemble de l'application avec 
   Web services déjà démarrés 
   */
public class RestBlagueIT {
	
	private static RestTemplate restTemplate;
	private static final String BASE_URL=
			"http://localhost:8080/tpMvcSpringBootApp";
	
	@BeforeClass
	public static void init() {
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void testPostBlague() {
		Blague nouvelleBlague = new Blague();
		nouvelleBlague.setTitre("preserver les arbres");
		nouvelleBlague.setTexte("sauvez un arbre , mangez un castor");
		String url=BASE_URL + "/rest/blagues";
		Blague blagueAjouteeCoteServeur = 
				 restTemplate.postForObject(url, nouvelleBlague, Blague.class);
		System.out.println("blagueAjouteeCoteServeur="+blagueAjouteeCoteServeur);
	}
	
	@Test
	public void testGetBlagues() {
		String url=BASE_URL + "/rest/blagues";
		String listeBlaguesAsJsonString = restTemplate.getForObject(url, String.class);
		System.out.println("listeBlaguesAsJsonString=" + listeBlaguesAsJsonString);
		Blague[] tabBlagues = restTemplate.getForObject(url, Blague[].class);
		Assert.assertNotNull(tabBlagues);
		//afficher le tableau resultat , qui codera , verra
		for(Blague b : tabBlagues) {
			System.out.println("\t" + b.toString());
		}
	}
	
}
