
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import commande.Commande;
import pizza.Pizza;

/**
 * Servlet implementation class Commander
 */
@WebServlet("/Commander")
public class Commander extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Commander() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	int s = 0;
	ArrayList<Commande> listeCommandes = new ArrayList<Commande>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		out.println("<style> \r\n"
				+ "input[type=button], input[type=submit], input[type=reset] {\r\n"
				+ "  background-color: #4CAF50;\r\n"
				+ "  border: none;\r\n"
				+ "  color: white;\r\n"
				+ "  padding: 16px 32px;\r\n"
				+ "  text-decoration: none;\r\n"
				+ "  margin: 4px 2px;\r\n"
				+ "  cursor: pointer;\r\n"
				+ "}\r\n"
				+ "</style>");
		
		javax.servlet.ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		String id = session.getId();
		

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		int prixTotal = (int) session.getAttribute("prixTotal");
		ArrayList<Pizza> pizzaListSession = (ArrayList<Pizza>) session.getAttribute("pizzas");
		
		Commande c = new Commande();
		c.setId(id);
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setAdresse(adresse);
		c.setPrix(prixTotal);
		c.setListePizza(pizzaListSession);
		
		//listecommandes.add(c);
		application.setAttribute("listeCommandes", listeCommandes);
		
		ArrayList<Commande> listeCommandesApp =(ArrayList<Commande>) application.getAttribute("listeCommandes");
		listeCommandesApp.add(c);
		
		/**
		 * if (application.getattribute("commandes") == null){
		 * ArrayList<Commaande) listeCommandes = new ArrayList<Commande>();
		 * 
		 * }
		 */
		
		out.println(c);
		/**for(Commande elem : listeCommandesApp) {
			out.println(elem);
		}**/
		//session.removeAttribute("pizzas");
		//session.removeAttribute("prixTotal");
		session.invalidate();
		out.println("<br><br>");
		out.println("<a href=\"dernierPageClient.html\"><input type=\"submit\" name=\"valider\" value=\"Valider\"></a>");
		//out.println("<a href=\"Menu.html\"><input type=\"submit\" name=\"retour\" value=\"Retour au menu\"></a>");
		
		/**RequestDispatcher rd;
		rd = request.getRequestDispatcher("AdministrateurAcceuil.html");

		rd.forward(request, response);**/
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
