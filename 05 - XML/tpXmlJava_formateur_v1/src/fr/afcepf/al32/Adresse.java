package fr.afcepf.al32;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="adresse")
@XmlAccessorType(XmlAccessType.FIELD) //pour paramétrages au dessus des private ...
public class Adresse {
	
	@XmlAttribute(name="type") 
	private String type;
	
	private String rue;
	
	private String cp;
	
	private String ville;
	

	public Adresse() {
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return "Adresse [type=" + type + ", rue=" + rue + ", cp=" + cp + ", ville=" + ville + "]";
	}


	

}
