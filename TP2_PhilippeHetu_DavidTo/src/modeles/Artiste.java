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


	public int getNumero() {
		// TODO Auto-generated method stub
		return this.numero;
	}


	public String getNom() {
		// TODO Auto-generated method stub
		return this.nom;
	}


	public boolean getMembre() {
		// TODO Auto-generated method stub
		return this.membre;
	}
	
	
	
	
	
}
