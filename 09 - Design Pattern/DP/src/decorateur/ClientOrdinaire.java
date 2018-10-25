package decorateur;

public class ClientOrdinaire extends Client {

	public ClientOrdinaire(String nom, int prixBillet) {
		super(nom, prixBillet);
		super.intitulé += "Client ordinaire ";
	}

	@Override
	public int getCoutBillet() {
		return prixBillet;
	}

}
