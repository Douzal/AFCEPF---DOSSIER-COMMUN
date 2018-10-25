package composite;

import java.util.ArrayList;
import java.util.List;

public class Message {
	private String contenu;
	private List<Destinataire> destinataires = new ArrayList<Destinataire>();
	
	public Message(String msg) {
		this.contenu = msg;
	}

	public List<Destinataire> getDestinataires() {
		return destinataires;
	}
	
	public void addDestinataire(Destinataire destinaire) {
		destinataires.add(destinaire);
	}
	
	public void envoyer() {
		for (Destinataire each : destinataires) {
			each.envoyer(contenu);
		}
	}
}
