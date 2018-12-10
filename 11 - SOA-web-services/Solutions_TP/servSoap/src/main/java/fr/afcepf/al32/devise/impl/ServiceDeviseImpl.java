package fr.afcepf.al32.devise.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import fr.afcepf.al32.devise.dto.Devise;
import fr.afcepf.al32.devise.itf.IServiceDevise;

@WebService(endpointInterface="fr.afcepf.al32.devise.itf.IServiceDevise") //à la fois coté classe et coté interface IServiceDevise
public class ServiceDeviseImpl  implements IServiceDevise  {
	
	
	private Map<String,Devise> mapDevises = new HashMap<String,Devise>();

	public ServiceDeviseImpl()  {
		mapDevises.put("EUR", new Devise("EUR",1.0));
		mapDevises.put("USD", new Devise("USD",1.3));
		mapDevises.put("GBP", new Devise("GBP",1.15));
		mapDevises.put("JPY", new Devise("JPY",1120));
	}

	public Double convertir(Double montant, String monnaieSource, String monnaieCible) {
		Devise dSource = mapDevises.get(monnaieSource);
		Devise dCible = mapDevises.get(monnaieCible);
		return montant * dCible.getChange() / dSource.getChange();//à peu près
	}

	public Devise getDevise(String monnaie) {
		return mapDevises.get(monnaie);
	}

}
