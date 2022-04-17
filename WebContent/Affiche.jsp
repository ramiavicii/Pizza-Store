<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pizza.Pizza" %>
<%@ page import="java.util.*, java.net.*" %>
<%@ page import="java.lang.String" %>
<!DOCTYPE html>
<html>
<style>
table, th, td {
  border:1px solid black;
}
input[type=button], input[type=submit], input[type=reset],Button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>afficher pizzas </title>
</head>

<body>

<fieldset style="border-width:2px">
<% ArrayList<Pizza> pizzaListSession = (ArrayList<Pizza>) session.getAttribute("pizzas"); %>
<h1>SOUHAITER-VOUS COMMANDER ?</h1>
<%=pizzaListSession.size()%>
<%int s=0; %>
<table style="width:100%">
  <tr>
    <th>Pizzas</th>
    <th>Prix</th>
  </tr>
  <%for (Pizza pizza:pizzaListSession ){ %>
  	<tr>
  	<td><%=pizza.getNom() %> <% out.println("<a href=\"http://localhost:8086/projetJEE/Supprimer?id="+pizzaListSession.indexOf(pizza)+"\">supprimer</a>"); %></td>
  	<td><%=pizza.getPrix() %><% s+=pizza.getPrix();%></td>
    </tr>
    <%} %>
 <%session.setAttribute("prixTotal",s);%>
</table>
<h3><b>Le prix total à payer :</b><%=s%></h3>

<a href="Formulaire.html"><input type="submit" name="submit" value="Valider"></a>
<!--  <form action="Menu.html" method=GET ><input type="submit" name="afficherMenu" value="Afficher menu"></form>-->
<a href="Menu.html"><button>Afficher Menu</button></a>



</fieldset>
</body>
</html>