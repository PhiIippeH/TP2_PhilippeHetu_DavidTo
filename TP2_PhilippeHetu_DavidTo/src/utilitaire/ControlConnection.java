package utilitaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ControlConnection {

	/**
	 * L'intérêt d'une connexion statique est de disposer d'une connexion unique
	 * durant toute une session.
	 */
	private static Connection laConnexion;
	private static String url = "jdbc:sqlite:src/bd/davidtophilippehetu_albums.db";

	/**
	 * Établit la connexion à la BDD si elle n'existe pas. Attention, la
	 * connexion ne doit pas être fermée
	 */
	public static void connecter() {
		try {
			if (laConnexion == null || laConnexion.isClosed()) {
				Class.forName("org.sqlite.JDBC");
				laConnexion = DriverManager.getConnection(url);
				JOptionPane.showMessageDialog(null, "Connect\u00E9 à laBD", "ALERTE", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (ClassNotFoundException e) {

		} catch (SQLException sqle) {

		}
	}

	public static void fermerSession() {
		String sql = "SELECT numero, nom, prenom FROM Employes";
		try {
			if (laConnexion != null && !laConnexion.isClosed()) {

			}
			// fermer la connexion
		} catch (SQLException sqle) {

		}

	}
	
	public ResultSet getArtiste() {
		String sql = "SELECT numero, nom, membre FROM artiste";
		ResultSet result = null;
		 try (Connection conn = laConnexion;
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            result = rs;
	            // loop through the result set
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		 return result;

	}
	
	public static void getAlbums() {
		

	}
	
	public static Connection getLaConnexion() {
		return null;
		}
}
