package observateur;

public class AffichageCourant implements Abonne{
	Editeur editeur;
	
	public AffichageCourant(Editeur editeur) {
		super();
		this.editeur = editeur;
		editeur.ajouteAbonne(this);
	}

	@Override
	public void upDate(int ca, int vente) {
		System.out.println("affichage courant");
	}

}
