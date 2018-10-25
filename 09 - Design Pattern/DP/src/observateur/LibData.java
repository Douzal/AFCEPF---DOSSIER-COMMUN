package observateur;

import java.util.ArrayList;
import java.util.List;

public class LibData implements Editeur{
	List<Abonne> lesAbonnes = new ArrayList<Abonne>();
	int ca,  nbVente;
	
	public void ajouteAbonne(Abonne ab) {
		lesAbonnes.add(ab);
	}
	public void supprimeAbonne(Abonne ab) {
		lesAbonnes.remove(ab);
	}
	public void notifierAbonnes() {
		for( Abonne ab : lesAbonnes)
			ab.upDate(ca, nbVente);
	}
	void dataChanged( int ca, int nbVente) {
		this.ca= ca;
		this.nbVente = nbVente;
		notifierAbonnes();
	}
}
