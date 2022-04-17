
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizza.Pizza;

/**
 * Servlet implementation class Ajouter
 */
@WebServlet("/Ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ajouter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Integer> pizzas = new HashMap<String, Integer>();
		pizzas.put("MARGHERITA", 10);
		pizzas.put("SALMON", 12);
		pizzas.put("NAPOLITAINE", 12);
		pizzas.put("FORMAGGI", 12);
		pizzas.put("BOLOGNAISE", 13);
		pizzas.put("TONO", 14);
		pizzas.put("FRUTTI DI MARE", 14);

		//HttpSession session = request.getSession();

		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		
		String direction = request.getParameter("submit");
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();

		//session.setAttribute("pizzas", pizzaList);
		//ArrayList<Pizza> pizzaListSession = (ArrayList<Pizza>) session.getAttribute("pizzas");
		HttpSession session = request.getSession();
		
		String[] pizza = request.getParameterValues("pizza[]");

		 if (direction.equals("Ajouter au panier") && (pizza!=null)) {
			 
			 
			for (String elem : pizza) {
				String nom = elem;
				Integer prix = pizzas.get(nom);
				Pizza p = new Pizza();
				p.setNom(nom);
				p.setPrix(prix);
				//pizzaListSession.add(p);
				pizzaList.add(p);
			}
			
			if(session.getAttribute("pizzas") != null) {
				ArrayList<Pizza> pizzaListSession = (ArrayList<Pizza>) session.getAttribute("pizzas");
				pizzaListSession.addAll((ArrayList<Pizza>)pizzaList);
			}else {
			session.setAttribute("pizzas", pizzaList);
			//ArrayList<Pizza> pizzaListSession = (ArrayList<Pizza>) session.getAttribute("pizzas");
			//pizzaListSession.addAll((ArrayList<Pizza>)pizzaList);
			}
			//ArrayList<Pizza> pizzaListSession = (ArrayList<Pizza>) session.getAttribute("pizzas");
			//pizzaListSession.addAll((ArrayList<Pizza>)pizzaListSession);
			/**
			 * for (String elem : pizza) { out.println(elem+" "+pizzas.get(elem)+"<br>
			 * "); }
			 * for(Pizza elem : pizzaListSession) { out.println(elem.toString()+"<br>
			 * "); }
			 **/

			response.sendRedirect("/projetJEE/Menu.html");
		}
		 else if (direction.equals("Ajouter au panier") && (pizza==null)) {
				//response.sendRedirect("/projetJEE/Menu.html");
			 	RequestDispatcher rd;
				rd = request.getRequestDispatcher("Menu.html");

				rd.forward(request, response);
			}
		 else {
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("Affiche.jsp");

			rd.forward(request, response);
		}

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
