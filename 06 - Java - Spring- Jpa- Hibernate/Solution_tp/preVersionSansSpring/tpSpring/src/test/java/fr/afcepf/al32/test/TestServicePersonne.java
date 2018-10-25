package fr.afcepf.al32.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.afcepf.al32.entity.Personne;
import fr.afcepf.al32.service.IServicePersonne;
import fr.afcepf.al32.service.ServicePersonneImpl;

public class TestServicePersonne {
	
	private Logger logger = LoggerFactory.getLogger(TestServicePersonne.class);

	private IServicePersonne servicePersonne; //à tester
	
	@Before
	public void init() {
		//v1 pas bien sans spring:
		servicePersonne= new ServicePersonneImpl();
	}
	
	@Test
	public void testRechercheParNum() {
		Personne p =servicePersonne.rechercherPersonneParNumero(2L);
		Assert.assertTrue(p.getNumero()==2L);
		logger.debug("p="+p.toString());
	}
	

}
