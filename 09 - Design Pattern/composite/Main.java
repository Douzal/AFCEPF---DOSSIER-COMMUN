package compositeSolution;

public class Main {
	
	public static void main(String[] args) {
		
		Personne alain = new Personne("Alain");
		Personne beatrice = new Personne("Béatrice");
		Personne colette = new Personne("Colette");
		Personne didier = new Personne("Didier");
		Personne edgar = new Personne("Edgar");
		Personne fabrice = new Personne("Fabrice");
		
		Personne invite = new Personne("Guest");
		
		Groupe groupeAdmin = new Groupe("admin");
		groupeAdmin.ajouterMembre(alain);
		groupeAdmin.ajouterMembre(beatrice);
		
		Groupe groupeUtilisateur = new Groupe("utilisateurs");
		groupeUtilisateur.ajouterMembre(colette);
		groupeUtilisateur.ajouterMembre(didier);
		groupeUtilisateur.ajouterMembre(edgar);
		
		Groupe groupeDBA = new Groupe("DBA");
		groupeDBA.ajouterMembre(fabrice);
		
		Groupe groupeExploitation = new Groupe("exploitation");
		groupeExploitation.ajouterMembre(groupeAdmin);
		groupeExploitation.ajouterMembre(groupeDBA);
		
		Groupe tous = new Groupe("tous");
		tous.ajouterMembre(invite);
		tous.ajouterMembre(groupeUtilisateur);
		tous.ajouterMembre(groupeExploitation);
		
		Message msg = new Message("Redémarrage du système à 18h");
		msg.addDestinataire(tous);
		msg.envoyer();
		
	}
	
}
