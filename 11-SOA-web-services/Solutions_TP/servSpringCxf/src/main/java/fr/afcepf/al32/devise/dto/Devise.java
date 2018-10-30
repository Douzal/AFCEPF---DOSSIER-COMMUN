package fr.afcepf.al32.devise.dto;

import java.io.Serializable;

public class Devise implements Serializable {
	private String monnaie; //ex: "EUR" , "USD" , "GBP" , "JPY"
	private double change; //change pour 1 euro
	
	public Devise() {
		
	}
	
	public Devise(String monnaie, double change) {
		this.monnaie = monnaie;
		this.change = change;
	}
	
	
	@Override
	public String toString() {
		return "Devise [monnaie=" + monnaie + ", change=" + change + "]";
	}

	public String getMonnaie() {
		return monnaie;
	}
	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
	
	
}
