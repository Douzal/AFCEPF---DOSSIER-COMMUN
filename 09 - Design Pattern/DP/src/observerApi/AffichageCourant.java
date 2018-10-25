package observerApi;

import java.util.Observable;
import java.util.Observer;

public class AffichageCourant implements Observer{

	// appelée par l'editeur
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(" j'observe ");
	}

}
