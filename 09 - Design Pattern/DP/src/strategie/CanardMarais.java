package strategie;

public class CanardMarais extends Canard {

	CanardMarais(){
		comportementDeVol = new VolAvecAiles();
		comportementDeCoincoin = new CouineBeaucoup();
	}
	
	@Override
	void affiche() {
		// TODO Auto-generated method stub
		
	}
	
		
}
