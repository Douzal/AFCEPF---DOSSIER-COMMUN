package observerApi;

import java.util.Observable;

public class LibData extends Observable{

	String valeurObservée;

	public LibData(String valeurObservée) {
		this.valeurObservée = valeurObservée;
	}
	
	void dataChange( String nouvelleString) { // si la donnée a changé, notifier les abonnées
		if( !valeurObservée.equals(nouvelleString)) {
			valeurObservée = nouvelleString;
			setChanged();
			notifyObservers();
		}
	}
	
	
}
