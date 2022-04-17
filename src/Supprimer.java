
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

import pizza.Pizza;

/**
 * Servlet implementation class Supprimer
 */
@WebServlet("/Supprimer")
public class Supprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Supprimer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ArrayList<Pizza> pizzaListSession = (ArrayList<Pizza>) session.getAttribute("pizzas");
		String id = (String) request.getParameter("id");
		int pos = Integer.parseInt(id);
		Pizza p = pizzaListSession.get(pos);

		 pizzaListSession.remove(p); 
		 
		 RequestDispatcher rd; 
		 rd =request.getRequestDispatcher("Affiche.jsp");
		  
		 rd.forward(request, response);
		 
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
