package decorateur;

public class Main {
	public static void main(String[] args) {
		Client c = new AvecCarte(new AvecReductionJeune( 
				new ClientOrdinaire("martin",200)));
		System.out.println(c.getNom() +" a acheté un " + c.getIntitulé() +
				" pour un montant de : "+ c.getCoutBillet());
	}
}
