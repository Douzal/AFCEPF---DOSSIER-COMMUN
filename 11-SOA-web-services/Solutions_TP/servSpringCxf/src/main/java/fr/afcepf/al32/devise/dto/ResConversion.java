package fr.afcepf.al32.devise.dto;

public class ResConversion {
	private Double montant;
	private String monnaieSource;
	private String monnaieCible;
	private Double montantConverti;
	
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getMonnaieSource() {
		return monnaieSource;
	}
	public void setMonnaieSource(String monnaieSource) {
		this.monnaieSource = monnaieSource;
	}
	public String getMonnaieCible() {
		return monnaieCible;
	}
	public void setMonnaieCible(String monnaieCible) {
		this.monnaieCible = monnaieCible;
	}
	public Double getMontantConverti() {
		return montantConverti;
	}
	public void setMontantConverti(Double montantConverti) {
		this.montantConverti = montantConverti;
	}
	
	
	
}
