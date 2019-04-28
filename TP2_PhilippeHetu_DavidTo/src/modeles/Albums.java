package modeles;

public class Albums {

	public int numero, numeroArtistes, annee;
	public String titre, genre, image;

	public Albums( int _numero, String _titre, String _genre, int _annee, String _image, int _numero_artistes ) {
		this.numero = _numero;
		this.numeroArtistes = _numero_artistes;
		this.titre = _titre;
		this.genre = _genre;
		this.annee = _annee;
		this.image = _image;

	}
	
	@Override
	public String toString(){
		return annee + " " + titre;
	}

}
