package fr.afcepf.al32.devise.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import fr.afcepf.al32.devise.dto.Devise;
import fr.afcepf.al32.devise.itf.IServiceDevise;

//UnicastRemoteObject est une classe prédéfinie de Rmi qu'il faut utiliser coté serveur
//via un héritage
public class ServiceDeviseImpl extends UnicastRemoteObject implements IServiceDevise {
	
	
	private Map<String,Devise> mapDevises = new HashMap<String,Devise>();

	public ServiceDeviseImpl() throws RemoteException {
		super(); //super() déclenche ici le constructeur de la classe héritée UnicastRemoteObject
		         //ce constructeur exporte l'objet de traitement pour qu'il soit accessible à distance
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
