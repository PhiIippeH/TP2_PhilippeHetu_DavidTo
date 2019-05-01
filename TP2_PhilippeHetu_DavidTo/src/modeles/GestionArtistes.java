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
	 * Structure de données pour chercher la liste des employés de la BD
	 */

	public GestionArtistes() {

		listeArtistes = obtenirListeArtiste();
	}

	public ArrayList<Artiste> getListeArtiste() {
		return listeArtistes;
	}

	public ArrayList<Artiste> obtenirListeArtiste() {
		ArrayList<Artiste> liste = new ArrayList<Artiste>();
		String requete = "SELECT * FROM artiste ORDER BY numero";
		
		int numero = 0;
		String nom = null;
		String photo = null;
		boolean membre = false;
		
		ControlConnection.connecter();
		
		try (Statement statement = connection.createStatement();
			ResultSet jeuResultat = statement.executeQuery( requete );){
			
			while ( jeuResultat.next() ) {
				numero = jeuResultat.getInt( "numero" );
				nom = jeuResultat.getString( "nom" );
				photo = jeuResultat.getString( "photo" );
				membre = jeuResultat.getBoolean( "membre" );
				
				liste.add( new Artiste( numero, nom, membre, photo ) );
			}
		} catch ( SQLException sqle ) {
			JOptionPane.showMessageDialog( null, "Problème rencontr\u00E8 : " + sqle.getMessage(), "Résultat",
					JOptionPane.ERROR_MESSAGE );
		}
		
		return liste;
	}

	public ArrayList<Artiste> rechercheArtiste( String mot ) {
	
		
		ArrayList<Artiste> liste = new ArrayList<>();

		String requete = "SELECT * FROM artiste where nom like '%" + mot + "%'";
		try {
			Statement statement = connection.createStatement();
			ResultSet jeuResultat = statement.executeQuery( requete );
			while (jeuResultat.next()) {
				liste.add(new Artiste(jeuResultat.getInt("numero"), jeuResultat.getString("nom"),
						jeuResultat.getBoolean("membre"), jeuResultat.getString("photo")));
				
			}

		} catch ( SQLException sqle ) {
			JOptionPane.showMessageDialog( null, "Problème rencontr\u00E8 : " + sqle.getMessage(), "Résultat",
					JOptionPane.ERROR_MESSAGE );
		}

		return liste;

	}

	// La méthode d'ajout d'un employé retourne vrai si l'ajout dans la BD a
	// réusi, faux si non
	public void ajouterArtiste( Artiste artiste ) {

		int var;
		if ( artiste.getMembre() ) {
			var = 1;
		} else {
			var = 0;
		}
		String requete = "insert into artiste (numero, nom, membre, photo) values (" + artiste.getNumero() + ",'"
				+ artiste.getNom() + "'," + var + ",'" + artiste.getPhoto() + "')";

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate( requete );

		} catch ( SQLException sqle ) {
			JOptionPane.showMessageDialog( null,
					"Probl\u00E8me rencontr\u00E9 lors de l'enregistrement de l'artiste: " + sqle.getMessage(),
					"Résultat", JOptionPane.ERROR_MESSAGE );
		}

	}

	public boolean supprimerArtiste( Artiste artiste ) {
		boolean boolSup = false;
		String requete = "delete from artiste where numero=" + artiste.getNumero() + ";";

		try {
			Statement st = connection.createStatement();
			st.executeUpdate( requete );
			boolSup = true;
		} catch ( SQLException sqle ) {
			JOptionPane.showMessageDialog( null,
					"Probl\u00E8me rencontr\u00E9 lors de la suppression de l'artiste: " + sqle.getMessage(),
					"Résultat", JOptionPane.ERROR_MESSAGE );
		}

		return boolSup;

	}

	public ArrayList<Albums> getAlbumDeArtiste( int numero ) {

		String requete = "SELECT * FROM albums WHERE numero_artiste = " + numero;
		ArrayList<Albums> listeAlbums = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet jeuResultat = statement.executeQuery( requete );

			while ( jeuResultat.next() ) {
				listeAlbums.add( new Albums( jeuResultat.getInt( "numero" ), jeuResultat.getString( "titre" ),
						jeuResultat.getString( "genre" ), jeuResultat.getInt( "annee" ),
						jeuResultat.getString( "image" ), jeuResultat.getInt( "numero_artiste" ) ) );
			}

		} catch ( SQLException sqle ) {
			JOptionPane.showMessageDialog( null, "Problème rencontr\u00E8 : " + sqle.getMessage(), "Résultat",
					JOptionPane.ERROR_MESSAGE );
		}

		return listeAlbums;

	}

}
