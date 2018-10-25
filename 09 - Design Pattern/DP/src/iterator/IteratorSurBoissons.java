package iterator;

import java.util.Iterator;

public class IteratorSurBoissons implements Iterator<String> {

	private Boissons boissonsAParcourir;
	private int compteur = 0;
	
	public IteratorSurBoissons(Boissons boissonsAParcourir) {
		super();
		this.boissonsAParcourir = boissonsAParcourir;
	}

	@Override
	public boolean hasNext() {
		return compteur < boissonsAParcourir.getBoissons().length;
	}

	@Override
	public String next() {   // trouver la boisson suivante = celle affichée par le compteur
		
		String[] listeDesBoissons = boissonsAParcourir.getBoissons();
		String b = listeDesBoissons[compteur++];
		
		return b ;
	}

}
