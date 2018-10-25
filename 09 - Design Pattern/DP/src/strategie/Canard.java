package strategie;

public abstract class Canard {
	ComportementDeVol comportementDeVol;
	ComportementDeCoincoin comportementDeCoincoin;
		
	public void voler() {
		comportementDeVol.vol();
	}
	
	public void coiner() {
		comportementDeCoincoin.coincoin();
	}
	abstract void affiche();
	
	public void setComportementDeVol(ComportementDeVol comportementDeVol) {
		this.comportementDeVol = comportementDeVol;
	}

	public void setComportementDeCoincoin(ComportementDeCoincoin comportementDeCoincoin) {
		this.comportementDeCoincoin = comportementDeCoincoin;
	}
	
	
}
