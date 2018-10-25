package decorateur;

public class AvecReductionJeune extends ClientAvecReductions{
	Client client;
		
	public AvecReductionJeune(Client client) {
		super();
		this.client = client;
	}

	@Override
	public String getIntitulé() {
		return client.getIntitulé() + " réduction jeune";
	}

	@Override
	public String getNom() {
		return client.getNom();
	}

	@Override
	public int getCoutBillet() {
		return client.getCoutBillet()-10;
	}
}
