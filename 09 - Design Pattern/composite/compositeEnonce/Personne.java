package compositeEnonce;

public class Personne {
	private String nom;

	public void envoyer(String msg) {
		System.out.println(nom + " reçoit ["+msg+']');
	}
	
	public Personne(String nom) {
		this.nom = nom;
	}
	
}
