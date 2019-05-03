package modeles;

public class Artiste {
	
	int numero;
	String nom,photo;
	boolean membre;


	public Artiste(int numero,String nom,boolean membre,String photo){
		this.numero = numero;
		this.nom = nom;
		this.photo = photo;
		this.membre = membre;
		
		
	}


	public Artiste(int num, String nom, boolean memb) {
		numero = num;
		this.nom = nom;
		membre = memb;
	}


	public int getNumero() {
		
		return this.numero;
	}


	public String getNom() {
		
		return this.nom;
	}


	public boolean getMembre() {
		
		return this.membre;
	}
	
	public String getPhoto(){
		return photo;
	}
	
	
	
	
	
}
