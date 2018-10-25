package composite;

import java.util.ArrayList;
import java.util.List;

public class Groupe extends Destinataire {
	private String nom;
	private List<Destinataire> membres = new ArrayList<Destinataire>();
	
	public Groupe(String nom) {
		this.nom = nom; 
	}

	public void ajouterMembre(Destinataire membre) {
		membres.add(membre);
	}
	
	public void supprimerMembre(Destinataire membre) {
		membres.remove(membre);
	}
	
	public List<Destinataire> getMembres() {
		return membres;
	}
	
	public String getNom() {
		return nom;
	}

	@Override
	public void envoyer(String message) {
		for (Destinataire each : membres) {
			each.envoyer(message);
		}
	}
}
