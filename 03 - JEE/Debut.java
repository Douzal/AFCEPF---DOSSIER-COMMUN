package pac;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Debut
 */
@WebServlet("/Debut")
public class Debut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<String> lesNoms = new ArrayList<String>();
		HttpSession session = request.getSession();
		session.setAttribute("lesNoms", lesNoms);
		
		getServletContext().getRequestDispatcher("/page1.html").forward(request, response);
	}

}
