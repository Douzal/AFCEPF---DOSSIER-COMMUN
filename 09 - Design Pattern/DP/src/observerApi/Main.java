package observerApi;



public class Main {
	public static void main(String[] args) {
		
		LibData lib = new LibData("toto");
		AffichageCourant af = new AffichageCourant();
		
		lib.addObserver(af);
		lib.dataChange("ouou");
	}
}
