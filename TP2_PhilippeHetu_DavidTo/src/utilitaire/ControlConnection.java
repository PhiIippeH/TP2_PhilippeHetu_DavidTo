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
		
		try {
			if (laConnexion != null && !laConnexion.isClosed()) {
				laConnexion.close();

			}
			// fermer la connexion
		} catch (SQLException sqle) {

		}

	}
	
	public static ResultSet getArtiste() {
		String sql = "SELECT numero, nom, membre FROM artiste";
		ResultSet result = null;
		 try {
			 Connection conn = laConnexion;
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql);
	            result = rs;
	            //loop through the result set
	            /* while (rs.next()) {
	                System.out.println(rs.getString("numero") +  "\t" + 
	                                   rs.getString("nom") + "\t" +
	                                   rs.getString("membre"));
	            }*/
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return result;

	}
	
	public static ResultSet getAlbums() {
		String sql = "SELECT numero, titre, genre, annee FROM albums";
		ResultSet result = null;
		 try {
	            	 Connection conn = laConnexion;
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql);
	            result = rs;
	            //loop through the result set
	           /* while (rs.next()) {
	                System.out.println(rs.getString("numero") +  "\t" + 
	                                   rs.getString("titre") + "\t" +
	                                   rs.getString("genre")+ "\t" +
	                                   rs.getString("annee"));
	            }*/
	            
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return result;


	}
	
	public static Connection getLaConnexion() {
		return laConnexion;
	}
}
