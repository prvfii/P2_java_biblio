package Membres;

public class Membre {
	
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String numDeTel;
	private String username;
	private String password;
	private String email;
	private boolean isAdmin = false;

	public Membre(int id, String nom, String prenom, String adresse, String numDeTel, String username, String password, String email, boolean isAdmin) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.numDeTel = numDeTel;
		this.username = username;
		this.password = password;	
		this.email = email;
		this.isAdmin = isAdmin;
	}
	
	public int getId() {
		return id;
		
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	
	}
	
	public String getAdresse() {
		return adresse;
	}
	

	public String getNumTel() {
		return numDeTel;
	}
	

	public String getUsername() {
		return username;
	}
	

	public String getPassword() {
		return password;
	}
	
	

	public String getEmail() {
		return email;
	}
	
	public boolean isAdmin() {
	        return isAdmin;
	    }

	
	




}
