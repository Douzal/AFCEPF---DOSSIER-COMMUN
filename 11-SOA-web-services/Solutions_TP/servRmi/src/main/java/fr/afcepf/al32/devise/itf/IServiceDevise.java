package fr.afcepf.al32.devise.itf;

import java.rmi.RemoteException;

import fr.afcepf.al32.devise.dto.Devise;

public interface IServiceDevise extends java.rmi.Remote{
	
	public Double convertir(Double montant,String monnaieSource, String monnaieCible) throws RemoteException;
    public Devise getDevise(String monnaie) throws RemoteException;//monnaie ="EUR" ou "USD" ou ...
}
