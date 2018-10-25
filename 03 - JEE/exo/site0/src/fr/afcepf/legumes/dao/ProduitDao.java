package fr.afcepf.legumes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.afcepf.legumes.entity.Produit;

public class ProduitDao implements Dao{
	
	
	
	public ProduitDao() {
		
	}

	
	public  ArrayList<Produit> findAll() {
		ArrayList<Produit> lesProduits = new ArrayList<Produit>();
		try {
			Statement canal = ConnexinoBd.con.createStatement();
			ResultSet res = canal.executeQuery("select * from produits");
			while( res.next() ) {
				Produit p  = new Produit();
				p.setId( res.getInt("id"));
				p.setLibelle(res.getString("libelle"));
				p.setDescription(res.getString("description"));
				p.setPrix(res.getDouble("prix"));
				lesProduits.add(p);
			}
			if( lesProduits.size()== 0 ) return null;
			return lesProduits;
		} catch (SQLException e) {}
		return lesProduits;
	}

	
	public  boolean delete(Produit p) {
			return delete(p.getId());
	}


	public  boolean delete(int id) {
		try {
			Statement canal = ConnexinoBd.con.createStatement();
			canal.executeUpdate("delete from produits where id='"+id+"'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public  int ajouteProduit(Produit p) {
		try {
			Statement canal = ConnexinoBd.con.createStatement();
			String sql = "insert into produits values( ....)";
			canal.executeUpdate(sql);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1 ;
	}

	public  boolean isLoggable(String login) {
		try {
			Statement canal = ConnexinoBd.con.createStatement();
			ResultSet res = canal.executeQuery("select * from login");
			while( res.next() ) {
				if( res.getString("nom_login").equals(login) )
					return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
