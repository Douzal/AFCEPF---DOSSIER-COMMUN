package composite;

public class Personne extends Destinataire {
	private String nom;

	public void envoyer(String msg) {
		System.out.println(nom + " re�oit ["+msg+']');
	}
	
	public Personne(String nom) {
		this.nom = nom;
	}
	
}
