package modeles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utilitaire.ControlConnection;

public class GestionArtistes {

	private Connection connection = ControlConnection.getLaConnexion();
	private ArrayList<Artiste> listeArtistes;

	public ResultSet getArtiste() {
		return ControlConnection.getArtiste();

	}

	/**
	 * Structure de donn�es pour chercher la liste des employ�s de la BD
	 */

	public GestionArtistes() {
		ControlConnection.connecter();
		listeArtistes = obtenirListeAlbums();
	}

	public ArrayList<Artiste> getListeArtiste() {
		return listeArtistes;
	}

	private ArrayList<Artiste> obtenirListeAlbums() {
		ArrayList<Artiste> liste = new ArrayList<Artiste>();
		String requete = "SELECT * FROM artiste ORDER BY numero";
		try (Statement statement = connection.createStatement();
				ResultSet jeuResultat = statement.executeQuery( requete )) {
			while ( jeuResultat.next() ) {
				int numero = jeuResultat.getInt( "numero" );
				String nom = jeuResultat.getString( "nom" );
				String photo = jeuResultat.getString( "photo" );
				boolean membre = jeuResultat.getBoolean( "membre" );
				liste.add( new Artiste( numero, nom, membre, photo ) );
			}
		} catch ( SQLException sqle ) {
			JOptionPane.showMessageDialog( null, "Probl�me rencontr\u00E8 : " + sqle.getMessage(), "R�sultat",
					JOptionPane.ERROR_MESSAGE );
		}
		return liste;
	}

	// La m�thode d'ajout d'un employ� retourne vrai si l'ajout dans la BD a
	// r�usi, faux si non
	public boolean ajouterArtiste( Artiste artiste ) {
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

	public boolean supprimerArtiste( Artiste artiste ) {
		return false;

	}

}
