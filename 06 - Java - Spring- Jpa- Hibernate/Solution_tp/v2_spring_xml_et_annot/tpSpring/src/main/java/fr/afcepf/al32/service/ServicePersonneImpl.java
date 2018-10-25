package fr.afcepf.al32.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.dao.IPersonneDao;
import fr.afcepf.al32.entity.Personne;

@Component //ou bien @Service qui herite de @Component
public class ServicePersonneImpl implements IServicePersonne {
	
	@Autowired //sur le private ou bien sur le set...()
	//@Autowired demande à spring d'initialiser la référence "personneDao"
	//en pointant vers un composant spring existant compatible avec l'interface.
	private IPersonneDao personneDao=null;
	
	//pour injection de dépendance xml:
	public void setPersonneDao(IPersonneDao personneDao) {
		this.personneDao = personneDao;
	}


	@Override
	public Personne rechercherPersonneParNumero(Long num) {
		// v1 pas bien sans spring:
		//IPersonneDao dao = new PersonneDaoSimulation();
		//return dao.findOne(num);
		
		//V2 utilisant dao injecté par spring:
		return personneDao.findOne(num);
	}

}
