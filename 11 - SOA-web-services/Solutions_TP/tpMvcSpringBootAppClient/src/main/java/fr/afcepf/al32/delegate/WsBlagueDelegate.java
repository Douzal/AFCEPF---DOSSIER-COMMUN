package fr.afcepf.al32.delegate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.web.client.RestTemplate;

import fr.afcepf.al32.dto.Blague;
import fr.afcepf.al32.itf.IWsBlague;

public class WsBlagueDelegate implements IWsBlague{
	
	//Le code interne de cette classe va déléguer les appels à travers le réseau
	//en s'appuyant sur une certaine techno "SOAP" ou "REST" ou ...
	//et une certaine api "Spring/RestTemplate" ou ...
	
	private RestTemplate restTemplate;
	
	//NB: en v2, la valeur de base_url sera récupérée dans un fichier 
	//ws_blague.properties
	private String  base_url= null; //"http://localhost:8080/tpMvcSpringBootApp";
	
	
	public WsBlagueDelegate() {
		restTemplate = new RestTemplate();
		try {
			Properties props = new Properties();
			InputStream is = Thread.currentThread().getContextClassLoader()
					               .getResourceAsStream("ws_blague.properties");
			props.load(is);
			is.close();
			this.base_url = props.getProperty("ws_blague.base_url");
			System.out.println("base_url="+base_url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Blague getBlagueById(Long idBlague) {
		String url = base_url + "/rest/blagues/" + idBlague;
		return restTemplate.getForObject(url, Blague.class);
	}

	@Override
	public Blague ajouterBlague(Blague b) {
		String url = base_url + "/rest/blagues";
		return restTemplate.postForObject(url, b, Blague.class);
	}

	@Override
	public List<Blague> rechercherBlagues(Double noteMini) {
		String url = base_url + "/rest/blagues" ;
		if(noteMini!=null) {
			url += ("?noteMini=" + noteMini); 
		}
		Blague[] tabBlagues = restTemplate.getForObject(url, Blague[].class);
		return Arrays.asList(tabBlagues);
	}

}
