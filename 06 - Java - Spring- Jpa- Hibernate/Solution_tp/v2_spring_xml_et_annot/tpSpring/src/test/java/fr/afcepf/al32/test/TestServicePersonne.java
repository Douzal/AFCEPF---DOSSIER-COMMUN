package fr.afcepf.al32.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afcepf.al32.entity.Personne;
import fr.afcepf.al32.service.IServicePersonne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/springConfAnnot.xml"})
public class TestServicePersonne {
	
	private Logger logger = LoggerFactory.getLogger(TestServicePersonne.class);

	@Autowired
	private IServicePersonne servicePersonne; //à tester
	
	
	@Test
	public void testRechercheParNum() {
		Personne p =servicePersonne.rechercherPersonneParNumero(2L);
		Assert.assertTrue(p.getNumero()==2L);
		logger.debug("p="+p.toString());
	}
	

}
