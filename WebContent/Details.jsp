<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="commande.Commande" %>
<%@ page import="java.util.*, java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details de la commande</title>
</head>
<body>
<%String id = (String) request.getParameter("id") ;
int pos = Integer.parseInt(id);
ArrayList<Commande> listeCommandesApp =(ArrayList<Commande>) application.getAttribute("listeCommandes");%>
<%Commande c =listeCommandesApp.get(pos); %>
Nom : <%=c.getNom() %><br>
Prenom : <%=c.getPrenom() %><br>
Adresse : <%=c.getAdresse() %><br>
Prix a payer:<%=c.getPrix() %><br>
liste des pizzas : <%=c.getListePizza() %><br>

<a href="http://localhost:8086/projetJEE/Commandes"><button>retour</button></a>
</body>
</html>