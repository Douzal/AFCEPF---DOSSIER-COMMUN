package decorateur;

public class AvecCarte extends ClientAvecReductions{
	Client client;
		
	public AvecCarte(Client client) {
		super();
		this.client = client;
	}

	@Override
	public String getIntitulé() {
		return client.getIntitulé() + " réduction carte";
	}

	@Override
	public String getNom() {
		return client.getNom();
	}

	@Override
	public int getCoutBillet() {
		return client.getCoutBillet()-20;
	}

}
