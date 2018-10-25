package fr.afcepf.al32.service;

import fr.afcepf.al32.dao.IPersonneDao;
import fr.afcepf.al32.dao.PersonneDaoSimulation;
import fr.afcepf.al32.entity.Personne;

public class ServicePersonneImpl implements IServicePersonne {


	@Override
	public Personne rechercherPersonneParNumero(Long num) {
		// v1 pas bien sans spring:
		IPersonneDao dao = new PersonneDaoSimulation();
		return dao.findOne(num);
	}

}
