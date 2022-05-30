package org.formation.rasolofoharison.zoo.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.formation.rasolofoharison.zoo.service.CagePOJO;


/**
 * Servlet implementation class InitServlet
 */
@WebServlet(
		description = "servlet qui récupère tout le zoo d'un coup", 
		urlPatterns = { 
				"/InitServlet", 
				"/init"
		})
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CagePOJO> infos = Zoo.getInstance().getPOJO();
//		for (CagePOJO cp : infos) {
//			
//		response.getWriter().print(String.join("", "<p>", cp.getPancarte(), "</p>"));
//		
//		}
		request.setAttribute("modele", infos);
		request.getRequestDispatcher("principal.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
