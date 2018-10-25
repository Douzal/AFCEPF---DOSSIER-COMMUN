package fr.afcepf.legumes.controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.afcepf.legumes.dao.ProduitDao;
import fr.afcepf.legumes.entity.Produit;


@WebServlet("/CatalogueServ")
public class CatalogueServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProduitDao dao = new ProduitDao();
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Produit> listeProduits = dao.findAll();
		HttpSession session = request.getSession();
		session.setAttribute("listeProduits", listeProduits);
		getServletContext().getRequestDispatcher("/catalogue.jsp").forward(request, response);
	}
	
	 public CatalogueServ() {

	    }


		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}


}
