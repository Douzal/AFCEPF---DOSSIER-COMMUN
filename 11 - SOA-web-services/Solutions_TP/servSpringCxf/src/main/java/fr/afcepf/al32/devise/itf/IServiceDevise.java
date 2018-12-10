package fr.afcepf.al32.devise.itf;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al32.devise.dto.Devise;

@WebService //(java) accessible à distance via soap
//@SOAPBinding(style = SOAPBinding.Style.RPC)//DOCUMENT par defaut
public interface IServiceDevise {
	
	public Double convertir(@WebParam(name="montant") Double montant,
			                @WebParam(name="monnaieSource") String monnaieSource,
			                @WebParam(name="monnaieCible") String monnaieCible) ;
    public Devise getDevise(@WebParam(name="monnaie") String monnaie); //monnaie ="EUR" ou "USD" ou ...
}
