package fr.afcepf.al32.devise.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import fr.afcepf.al32.devise.dto.Devise;
import fr.afcepf.al32.devise.itf.IServiceDevise;

public class RmiClientApp {

	public static void main(String[] args) {

		try {
			//1 se connecter à RmiRegistry (localhost ou .... , 1099)
			Registry rmiRegistry = LocateRegistry.getRegistry("localhost", 1099);
			//Registry rmiRegistry = LocateRegistry.getRegistry("FORM284", 1099);
			//Registry rmiRegistry = LocateRegistry.getRegistry("192.168.102.131", 1099);
			
			//2 récupérer le "proxy Rmi" de 'l'objet distant qui a le nom logique "serviceDevise"
			IServiceDevise proxyServiceDevise = (IServiceDevise) rmiRegistry.lookup("serviceDevise");
			
			//3 appeler des méthodes distantes:
			Devise d = proxyServiceDevise.getDevise("USD");
			System.out.println("change de USD =" + d.getChange() + " pour 1 euro");
			
			Double sommeConvertie = proxyServiceDevise.convertir(20.0, "EUR", "USD");
			System.out.println("20 euros convertis en dollar :" + sommeConvertie);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
