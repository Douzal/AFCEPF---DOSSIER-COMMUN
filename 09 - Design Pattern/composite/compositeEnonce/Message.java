package compositeEnonce;

import java.util.ArrayList;
import java.util.List;

public class Message {
	private String contenu;
	
	private List<Personne> personnes = new ArrayList<Personne>();
	private List<Groupe> groupes = new ArrayList<Groupe>();
	
	public Message(String msg) {
		this.contenu = msg;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}
	
	public List<Personne> getPersonnes() {
		return personnes;
	}
	
	public void addPersonne(Personne personne) {
		personnes.add(personne);
	}
	
	public void addGroupe(Groupe groupe) {
		groupes.add(groupe);
	}
	
	public void envoyer() {
		for (Personne personne : personnes) {
			personne.envoyer(contenu);
		}
		for (Groupe groupe : groupes) {
			for (Personne personne : groupe.getMembres()) {
				personne.envoyer(contenu);
			}
		}
	}
}
