package fr.afcepf.al32.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.afcepf.al32.delegate.WsBlagueDelegate;
import fr.afcepf.al32.dto.Blague;
import fr.afcepf.al32.itf.IWsBlague;

/*
 * IT : Integration Test ne fonctionnant que si le serveur est
 * préalablement démarré
 */
public class AppelWsViaDelegateIT {
	
	private IWsBlague wsBlague; //à tester

	@Before
	public void init() {
		wsBlague = new WsBlagueDelegate();
	}
	
	@Test
	public void testListeBlagues() {
		List<Blague> listeBlagues = wsBlague.rechercherBlagues(null);
		                         // wsBlague.rechercherBlagues(2.0); //avec noteMini
		Assert.assertNotNull(listeBlagues);
		for(Blague b : listeBlagues) {
			System.out.println("\t"+b);
		}
	}
}
