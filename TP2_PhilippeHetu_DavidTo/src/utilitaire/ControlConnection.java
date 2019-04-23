package utilitaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ControlConnection {

	/**
	 * L'int�r�t d'une connexion statique est de disposer d'une connexion unique
	 * durant toute une session.
	 */
	private static Connection laConnexion;
	private static String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=c:/bd/employes.accdb";

	/**
	 * �tablit la connexion � la BDD si elle n'existe pas. Attention, la
	 * connexion ne doit pas �tre ferm�e
	 */
	public static void connecter() {
		try {
			if (laConnexion == null || laConnexion.isClosed()) {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				laConnexion = DriverManager.getConnection(url);
				JOptionPane.showMessageDialog(null, "Connect\u00E9 � laBD", "ALERTE", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (ClassNotFoundException e) {

		} catch (SQLException sqle) {

		}
	}

	public static void fermerSession() {
		try {
			if (laConnexion != null && !laConnexion.isClosed()) {

			}
			// fermer la connexion
		} catch (SQLException sqle) {

		}

	}
	public static Connection getLaConnexion() {
		return null;
		}
}
