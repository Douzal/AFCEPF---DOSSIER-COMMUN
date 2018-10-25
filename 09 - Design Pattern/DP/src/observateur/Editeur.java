package observateur;

public interface Editeur {
	void ajouteAbonne( Abonne ab);
	void supprimeAbonne( Abonne ab);
	void notifierAbonnes();
}
