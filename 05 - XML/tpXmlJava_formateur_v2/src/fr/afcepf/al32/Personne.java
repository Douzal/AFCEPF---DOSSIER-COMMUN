package fr.afcepf.al32;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="personne")
@XmlAccessorType(XmlAccessType.FIELD) //pour paramétrages au dessus des private ...
public class Personne {
	
	@XmlAttribute(name="num") //pour chargement depuis l'attribut num
	                          //au lieu d'une sous balise <num>...</num> 
	                          //équivalent de @num de xpath
	private Integer num;
	private String nom;
	private String prenom;
	
	@XmlElement(name="adresse")//nom de la sous balise répétée <adresse> 
	private List<Adresse> adresses=new ArrayList<Adresse>(); //+get/set sur adresse

	public Personne() {
	}


	@Override
	public String toString() {
		return "Personne [num=" + num + ", nom=" + nom + ", prenom=" + prenom + "]";
	}



	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public List<Adresse> getAdresses() {
		return adresses;
	}


	public void setAdresses(List<Adresse> adresse) {
		this.adresses = adresse;
	}
	
	

}
