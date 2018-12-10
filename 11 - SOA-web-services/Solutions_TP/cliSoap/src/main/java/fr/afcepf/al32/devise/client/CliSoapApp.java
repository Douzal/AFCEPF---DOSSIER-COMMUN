package fr.afcepf.al32.devise.client;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

import fr.afcepf.al32.devise.impl.IServiceDevise;
import fr.afcepf.al32.devise.impl.ServiceDeviseImplService;
import fr.afcepf.al32.devise.itf.Devise;

public class CliSoapApp {

	public static void main(String[] args) {
		String localHostName=null;
		
		// appel du ws soap en s'appuyant sur le code généré par wsimport:
		String wsdlUrlAsString = "http://localhost:8080/servSoap/serviceDevise?wsdl";
		
		//il faudra peut être adapter l'URL coté serveur et le redémarrer (autre chose que localhost)
		URL wsdlUrl=null;
		try {
			localHostName = InetAddress.getLocalHost().getHostName();
			wsdlUrlAsString = "http://"+localHostName+":8080/servSoap/serviceDevise?wsdl";
			wsdlUrl = new URL(wsdlUrlAsString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// new (....Service).get....Port();
		IServiceDevise proxySoapServiceDevise = 
				(new ServiceDeviseImplService(wsdlUrl)).getServiceDeviseImplPort();
        Devise yenJaponnais = proxySoapServiceDevise.getDevise("JPY");
        System.out.println("change du yenJaponnais="+yenJaponnais.getChange());
	}

}
