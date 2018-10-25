package observateur;

public class Main {
	public static void main(String[] args) {
		LibData lib = new LibData();
		AffichageCourant aff = new AffichageCourant(lib);
		
		lib.dataChanged(12, 16);
	}
}
