package fr.afcepf.legumes.entity;

public class Login {
	
	private int id;
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Login(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Login() {		
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", nom=" + nom + "]";
	}

}
