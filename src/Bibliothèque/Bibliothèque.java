package Bibliothèque;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Emprunt.Emprunt;
import Livres.Livre;
import Membres.Membre;

public class Bibliothèque {

	private ArrayList<Livre> livres;
	private ArrayList<Membre> membres;
	private ArrayList<Emprunt> emprunts;
	private int prochainIdEmprunt = 0;
	private Livre livre;
	private Bibliothèque bibliothèque;
	
	
	public Bibliothèque() {
		this.bibliothèque = bibliothèque;
		this.livres = livres;
		livres = new ArrayList<Livre>();
		membres = new ArrayList<Membre>();
		emprunts = new ArrayList<Emprunt>();
		
	}
	
	public void addLivre(Livre livre) {
		
		
		livres.add(livre);
		System.out.println(livres);
	}
	
	public void removeLivre(Livre livre) {
		
		
		livres.remove(livre);
	}
	
	public void addMembre(Membre membre) {
		
		membres.add(membre);
	}
	
	public void removeMembre(Membre membre) {
		
		membres.remove(membre);
	}
	
	public void addEmprunt(Emprunt emprunt) {
		
		emprunts.add(emprunt);
	}
	
	public void creerLivres() {
		Livre livre0 = new Livre(0, "Harry Potter", "inconnu", false);
        Livre livre1 = new Livre(1, "Geronimo Stilton", "Adem", true);
        Livre livre2 = new Livre(2, "Drare in de nacht", "Yousra", true);
        livres.add(livre0);
        livres.add(livre1);
        livres.add(livre2);
	};
	
		
	public ArrayList<Livre> getLivres() {
	    return livres;
	}
	
	public int getLivres(int idLivre) {
	    return idLivre;
	}
	
	public ArrayList<Membre> getLesMembres() {
	    return membres;
	}
	
	
	
	
	
	/*public boolean emprunterLivre(int idLivre) {
	    Livre livre = trouverLivre(idLivre);
	    if (livre == null || !livre.getDisponible()) {
	    
	        return true; // emprunt échoué
	    }
	    livre.emprunter();
	    return false; // emprunt réussi
	}public Emprunt emprunterLivre(int idLivre, Membre membre) {
	
		 Livre livre = trouverLivre(idLivre);
				 System.out.println(livre);
	    if (livre == null || !livre.getDisponible()) {
	    	
	        return null; // impossible d'emprunter le livre
	    }
	   
	    Date dateEmprunt = new Date();
	    Emprunt emprunt = new Emprunt(prochainIdEmprunt++, livre, membre, dateEmprunt);
	    emprunts.add(emprunt);
	    livre.setDisponible(false);
	    return emprunt; // emprunt réussi
	}


	public Livre trouverLivre(int idLivre) {
		 System.out.println(livre);
	    for (Livre livre : livres) {
	        if (livre.getId() == idLivre) {
	            return livre;
	        }
	    }
	    System.out.println("LE LIVRE EST NULL");
	    return null; // le livre n'est pas trouvé
	}
*/
	

	public List<Livre> rechercherLivres(String searchText) {
		// TODO Auto-generated method stub
	List<Livre> livresTrouves = new ArrayList<>();

	    for (Livre livre : livres) {
	        if (livre.getTitre().toLowerCase().contains(searchText)
	                || livre.getAuteur().toLowerCase().contains(searchText)
	                || Integer.toString(livre.getId()).contains(searchText)) {
	            livresTrouves.add(livre);
	        }
	    }

	    return livresTrouves;
	}

	public void creerMembres() {
		
			
		Membre admin = new Membre(0,"admin", "admin", "Rue Pierre", "0489013540", "ADMIN",  "admin", "admin@gmail.com", true);
		Membre membre1 = new Membre(1,"membre1", "membre1Nomdefamille", "Rue Jean", "0489056900", "MEMBRE1",  "MEMBRE1", "membre1@gmail.com" , false);
		
		membres.add(admin);
		membres.add(membre1);
	}


	
	



		public List<Membre> getMembres() {
		// TODO Auto-generated method stub
		return membres;
	}


		public void modifierLivre(int id, String titre, String auteur, boolean disponible) {
		    // Parcourir la liste des livres pour trouver le livre avec l'ID correspondant
		    for (Livre livre : livres) {
		        if (livre.getId() == id) {
		            // Mettre à jour les détails du livre
		       
		            livre.setTitre(titre);
		            livre.setAuteur(auteur);
		            livre.setDisponible(disponible);
		            break;
		        }
		    }
		}


	public static void main(String[] args) {
		
		
	
		
	
	
		//Livre livre1 = new Livre(1, "Geronimo Stilton", "Adem", true);
		//Livre livre2 = new Livre(2, "Drare in de nacht", "Yousra", true);
		
	//	Membre admin = new Membre(0,"admin", "admin", "Rue Pierre", "0489013540", "ADMIN",  "admin", "admin@gmail.com" );
	//	Membre membre1 = new Membre(1,"membre1", "membre1Nomdefamille", "Rue Jean", "0489056900", "MEMBRE1",  "MEMBRE1", "membre1@gmail.com" );
		
		//


		
	//	bibliothèque.addLivre(livre0);
	//	bibliothèque.addLivre(livre1);
	//	bibliothèque.addLivre(livre2);

		//bibliothèque.addMembre(admin);
	//	bibliothèque.addMembre(membre1);
		
	//	System.out.println(admin.getId());
	//	System.out.println(admin.getEmail());
	//	System.out.println(admin.getAdresse());
	
		
		
	}

	

	


	  


}
