package com.isamm.imedjaberi;

public class Livre {
	private int id , idE ; 
	private String Titre , Auteur , DateEmprunt , Edition ;
	
	
	// Here all the getters & setters for the Livre object .. 

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdE() {
		return idE;
	}
	
	public void setIdE(int idE) {
		this.idE = idE;
	}
	
	public String getTitre() {
		return Titre;
	}
	
	public void setTitre(String titre) {
		Titre = titre;
	}
	
	public String getAuteur() {
		return Auteur;
	}
	
	public void setAuteur(String auteur) {
		Auteur = auteur;
	}
	
	public String getDateEmprunt() {
		return DateEmprunt;
	}
	
	public void setDateEmprunt(String dateEmprunt) {
		DateEmprunt = dateEmprunt;
	}
	
	public String getEdition() {
		return Edition;
	}
	
	public void setEdition(String edition) {
		Edition = edition;
	}
	

}
