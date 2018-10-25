package fr.afcepf.legumes.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexinoBd {
	public static Connection con = null;
	public ConnexinoBd() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/exoLegumes", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
