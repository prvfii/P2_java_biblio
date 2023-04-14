package Emprunt;



import java.util.Date;

import Livres.Livre;
import Membres.Membre;

public class Emprunt {

	// GETTERS
		private int id;
		private Livre idLivre;
		private Membre idMembre;
		private Date dateEmprunt;
		
		
		//SETTERS

		public Emprunt(int id, Livre idLivre, Membre idMembre, Date dateEmprunt) {
			this.id = id;
			this.idLivre = idLivre; 
			this.idMembre = idMembre;
			this.dateEmprunt = dateEmprunt;
		}
		
	
		public Livre getLivreEmprunter() {
			return idLivre;
			
		}
		
		public Membre getMembreEmprunt() {
			return idMembre;
			
		}
		
		public int getId() {
			return id;
			
		}
		
		public Date getDateEmprunt() {
			return dateEmprunt;
			
		}
		
		public void setDateEmprunt(Date dateEmprunt) {
			this.dateEmprunt = dateEmprunt;
		}
		
		
}
