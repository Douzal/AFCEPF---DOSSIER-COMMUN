package compositeEnonce;

public class Main {

	public static void main(String[] args) {

		Personne alain = new Personne("Alain");
		Personne beatrice = new Personne("Béatrice");
		Personne colette = new Personne("Colette");
		Personne didier = new Personne("Didier");
		Personne edgar = new Personne("Edgar");
		Personne fabrice = new Personne("Fabrice");

		Personne invite = new Personne("Guest");

		Groupe groupeAdmin = new Groupe("Admin");
		groupeAdmin.ajouterMembre(alain);
		groupeAdmin.ajouterMembre(beatrice);

		Groupe groupeUtilisateur = new Groupe("Utilisateurs");
		groupeUtilisateur.ajouterMembre(colette);
		groupeUtilisateur.ajouterMembre(didier);
		groupeUtilisateur.ajouterMembre(edgar);

		Groupe groupeDBA = new Groupe("DBA");
		groupeDBA.ajouterMembre(fabrice);

		/*
		 * restructurer le code afin de simplifier la constitution des
		 * destinaires. On souhaite permettre d'organiser des groupes tels que
		 * "exploitation" (contient les admin et les dba) ou "tous" contenant
		 * tout le monde. On souhaite aussi simplifier le code de l'envoi de
		 * message dans la classe Message
		 */

		// envoi d'un message à tout le monde
		Message msg = new Message("Redémarrage du système à 18h");
		msg.addGroupe(groupeUtilisateur);
		msg.addGroupe(groupeAdmin);
		msg.addGroupe(groupeDBA);
		msg.addPersonne(invite);
		msg.envoyer();

	}

}
