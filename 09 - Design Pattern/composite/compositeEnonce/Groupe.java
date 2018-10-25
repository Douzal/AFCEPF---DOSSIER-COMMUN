package compositeEnonce;

import java.util.ArrayList;
import java.util.List;

public class Groupe {
	private String nom;
	private List<Personne> membres = new ArrayList<Personne>();
	
	public Groupe(String nom) {
		this.nom = nom; 
	}

	public void ajouterMembre(Personne membre) {
		membres.add(membre);
	}
	
	public void supprimerMembre(Personne membre) {
		membres.remove(membre);
	}
	
	public List<Personne> getMembres() {
		return membres;
	}
	
	public String getNom() {
		return nom;
	}

}
