package fr.afcepf.al32.devise.serveur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import fr.afcepf.al32.devise.impl.ServiceDeviseImpl;

public class RmiServApp {

	public static void main(String[] args) {
		//classe de démarrage de l'application "servRmi"
		System.out.println("démarrage de l'application servRmi ...");
        try {
        	//instancier l'objet de traitement accessible à distance via rmi
			ServiceDeviseImpl serviceDeviseImpl  = new ServiceDeviseImpl();
			
			//initialiser le serveur de noms logiques rmi avec le numero de port 1099 ou  autre
			Registry rmiRegistry = LocateRegistry.createRegistry(1099);
			
			//enregistrer l'implémentation dans le serveur des noms logiques avec le nom "serviceDevise"
			rmiRegistry.rebind("serviceDevise", serviceDeviseImpl);
			
			System.out.println("serveur démarré en attente des requêtes sur le port 1099");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//Fin de main()
        //le programme serveur continue tout de même à tourner 
        //car Thread démarré en tâche de fond qui attend les requêtes
	}

}
