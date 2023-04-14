package Livres;

import java.util.ArrayList;
import java.util.Date;

import Emprunt.Emprunt;
import Membres.Membre;

public class Livre {
	

	private int id;
	private String titre;
	private String auteur;
	private boolean disponible = true;
	
	
	

	public Livre(int id, String titre, String auteur, boolean disponible) {
		
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.disponible = disponible;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public String getAuteur() {
		return auteur;
	}
	
	public boolean getDisponible() {
		return disponible;
	}
	
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
		
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setTitre(String titre) {
		// TODO Auto-generated method stub
		this.titre = titre;
	}

	public void setAuteur(String auteur) {
		// TODO Auto-generated method stub
		this.auteur = auteur;
	}
}
	
	


	

	






