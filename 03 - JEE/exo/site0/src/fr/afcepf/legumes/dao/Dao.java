package fr.afcepf.legumes.dao;

import java.util.ArrayList;
import fr.afcepf.legumes.entity.*;

public interface Dao {
	
	ArrayList<Produit> findAll();
	boolean delete(Produit p);
	boolean delete(int id);
	int ajouteProduit( Produit p);
	boolean isLoggable( String login );
	
	
}
