package fr.afcepf.al32.devise.serveur;

import java.net.InetAddress;

import javax.xml.ws.Endpoint;

import fr.afcepf.al32.devise.impl.ServiceDeviseImpl;
import fr.afcepf.al32.devise.itf.IServiceDevise;

public class ServSoapApp {

	public static void main(String[] args) {
		//String urlWs="http://localhost:8080/servSoap/serviceDevise";
		//String urlWs="http://192.168.102.131:8080/servSoap/serviceDevise";
		try {
			String localHostName = InetAddress.getLocalHost().getHostName();
		    String urlWs="http://"+localHostName+":8080/servSoap/serviceDevise";
		
			IServiceDevise serviceDevise = new ServiceDeviseImpl();
	        Endpoint.publish(urlWs, serviceDevise);
	        System.out.println("web service démarré en attente des requetes");
	        System.out.println("URL description wsdl : " + urlWs + "?wsdl");
	        System.out.println("penser à arrêter le serveur , bouton rouge console eclipse ou ...");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
