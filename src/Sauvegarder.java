

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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Servlet implementation class Sauvegarder
 */
@WebServlet("/Sauvegarder")
public class Sauvegarder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sauvegarder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		javax.servlet.ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		File file = new File("baseDonnees.txt");
		// créer le fichier s'il n'existe pas
		if (!file.exists()) {
		    file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		ArrayList<Commande> listeCommandesApp =(ArrayList<Commande>) application.getAttribute("listeCommandes");
		
		for (Commande c :listeCommandesApp ) {
			String data = c.toString();
			bw.write(data+"\n");
			bw.write("----------------------------------------------------\n");
			 
		}
		bw.close();
		application.removeAttribute("listeCommandes");
		session.invalidate();
		out.println("<h3>sauvegarde résussite</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
