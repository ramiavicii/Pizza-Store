package commande;

import java.util.ArrayList;

import pizza.Pizza;

public class Commande {
	private String id;
	private String nom;
	private String prenom;
	private String adresse;
	private int prix;
	private ArrayList<Pizza> listePizza;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Commande [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", prix=" + prix
				+ ", listePizza=" + listePizza + "]";
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public ArrayList<Pizza> getListePizza() {
		return listePizza;
	}

	public void setListePizza(ArrayList<Pizza> listePizza) {
		this.listePizza = listePizza;
	}

	

}
