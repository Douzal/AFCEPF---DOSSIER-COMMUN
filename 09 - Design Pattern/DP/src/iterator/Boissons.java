package iterator;

import java.util.Iterator;

public class Boissons  implements Iterable<String> {
	private String [] boissons = {"the", "cafe", "biere"};

	@Override
	public Iterator<String> iterator() {
		return new IteratorSurBoissons( this);
	}

	public String[] getBoissons() {
		return boissons;
	}

	public void setBoissons(String[] boissons) {
		this.boissons = boissons;
	}
	
	
	
}
