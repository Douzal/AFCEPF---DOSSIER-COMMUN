package fr.afcepf.al32.itf;

import java.util.List;

import fr.afcepf.al32.dto.Blague;

/* interface java pour appels externes "RPC" */
public interface IWsBlague {
	Blague getBlagueById(Long idBlague);
	Blague ajouterBlague(Blague b);
	List<Blague> rechercherBlagues(Double noteMini);
	//...
}
