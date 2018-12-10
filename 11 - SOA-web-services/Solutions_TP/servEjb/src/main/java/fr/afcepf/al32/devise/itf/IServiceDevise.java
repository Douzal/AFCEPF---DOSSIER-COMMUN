package fr.afcepf.al32.devise.itf;

import javax.ejb.Remote;

import fr.afcepf.al32.devise.dto.Devise;

@Remote //(ejb) accessible à distance via rmi
public interface IServiceDevise {
	
	public Double convertir(Double montant,String monnaieSource, String monnaieCible) ;
    public Devise getDevise(String monnaie); //monnaie ="EUR" ou "USD" ou ...
}
