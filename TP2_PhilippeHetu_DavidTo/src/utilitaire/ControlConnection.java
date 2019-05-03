package utilitaire;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

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

	public static Connection getLaConnexion() {
		return laConnexion;
	}
}
