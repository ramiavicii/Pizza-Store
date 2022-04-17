
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import commande.Commande;

/**
 * Servlet implementation class Commandes
 */
@WebServlet("/Commandes")
public class Commandes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Commandes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		
		javax.servlet.ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		
		ArrayList<Commande> listeCommandesApp =(ArrayList<Commande>) application.getAttribute("listeCommandes");
		
		out.println( "<html>\r\n"
				+ "<style>\r\n"
				+ "table, th, td {\r\n"
				+ "  border:1px solid black;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>commandes non tritées </title>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		if (listeCommandesApp!=null) {
		out.println("<fieldset style=\"border-width:2px\">");
		out.println("<h1>Commandes non traitées</h1>");
		out.println("<table style=\"width:100%\">\r\n"
				+ "  <tr>\r\n"
				+ "    <th>Nom</th>\r\n"
				+ "    <th>Prénom</th>\r\n"
				+ "    <th>Adresse</th>\r\n"
				+ "    <th>Prix total</th>\r\n"
				+ "  </tr>");
		for (Commande c : listeCommandesApp) {
			out.println("<tr>");
			out.println("<td>"+c.getNom()+"</td>");
			out.println("<td>"+c.getPrenom()+"</td>");
			out.println("<td>"+c.getAdresse()+"</td>");
			session.setAttribute("AffichCommande",c);
			out.println("<td>"+"<a href = \"http://localhost:8086/projetJEE/Details.jsp?id="+listeCommandesApp.indexOf(c)+"\" >"+c.getPrix()+"</td>");
			//out.println("<td><a href=\"Details.jsp\">"+c.getPrix()+"</a></td>");
			//session.removeAttribute("AffichCommande");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("<a href=\"http://localhost:8086/projetJEE/Sauvegarder\"><input type=\"submit\" name=\"sauvegarder\" value=\"sauvegarder\"></a>");
		out.println("</fieldset>");
		
		}else {
			out.println("<h3>pas de commandes pour le moment</h3>");
		}
		
		out.println("</body>\r\n"
				+ "</html>");
		
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
