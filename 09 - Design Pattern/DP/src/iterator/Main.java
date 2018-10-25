package iterator;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Boissons b = new Boissons();
		
		for(String s : b)
			System.out.println(s);
		
		Iterator<String> it = b.iterator();
		while( it.hasNext())
			System.out.println(it.next());
		
	}
}
