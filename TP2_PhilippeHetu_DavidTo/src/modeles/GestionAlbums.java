package modeles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utilitaire.ControlConnection;

public class GestionAlbums {

	private Connection connection = ControlConnection.getLaConnexion();
	private ArrayList<Albums> listeAlbums;

	/**
	 * Structure de donn�es pour chercher la liste des employ�s de la BD
	 */

	public GestionAlbums() {
		listeAlbums = obtenirListeAlbums();
	}

	public ArrayList<Albums> getListeAlbums() {
		return listeAlbums;
	}

	public ArrayList<Albums> obtenirListeAlbums() {
		ArrayList<Albums> liste = new ArrayList<Albums>();
		String requete = "SELECT * FROM albums ORDER BY numero";
		try (Statement statement = connection.createStatement();
				ResultSet jeuResultat = statement.executeQuery( requete )) {
			while ( jeuResultat.next() ) {
				int numero = jeuResultat.getInt( "numero" );
				String titre = jeuResultat.getString( "titre" );
				String genre = jeuResultat.getString( "genre" );
				int annee = jeuResultat.getInt( "annee" );
				String image = jeuResultat.getString( "image" );
				int numeroArtiste = jeuResultat.getInt( "numero_artiste" );
				liste.add( new Albums( numero, titre, genre, annee, image, numeroArtiste ) );
			}
		} catch ( SQLException sqle ) {
			JOptionPane.showMessageDialog( null, "Probl�me rencontr\u00E8 : " + sqle.getMessage(), "R�sultat",
					JOptionPane.ERROR_MESSAGE );
		}
		return liste;
	}

	// La m�thode d'ajout d'un employ� retourne vrai si l'ajout dans la BD a
	// r�usi, faux si non
	public boolean ajouterAlbums( Albums album ) {
		boolean boolAjout = false;
		String requete = "";

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate( requete );
			boolAjout = true; // L'ajout r�ussi
		} catch ( SQLException sqle ) {
			JOptionPane.showMessageDialog( null,
					"Probl\u00E8me rencontr\u00E9 lors de l'enregistrement de l'employ\u00E9: " + sqle.getMessage(),
					"R�sultat", JOptionPane.ERROR_MESSAGE );
		}
		return boolAjout;
	}

	public boolean supprimerAlbums( Albums album ) {
		return false;

	}

}
