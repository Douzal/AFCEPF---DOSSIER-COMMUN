package decorateur;

public abstract class Client {
	protected String nom;
	protected int prixBillet;
	protected String intitulé ="Billet :";
	
	public abstract int getCoutBillet();
	// ne pourra être calculé qu'après avoir appliqué le reductions

	
	// setters et constructeurs
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	
	public int getPrixBillet() {
		return prixBillet;
	}


	public void setPrixBillet(int prixBillet) {
		this.prixBillet = prixBillet;
	}


	public String getIntitulé() {
		return intitulé;
	}

	public void setIntitulé(String intitulé) {
		this.intitulé = intitulé;
	}
	

	public Client(String nom, int prixBillet) {
		super();
		this.nom = nom;
		this.prixBillet = prixBillet;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
