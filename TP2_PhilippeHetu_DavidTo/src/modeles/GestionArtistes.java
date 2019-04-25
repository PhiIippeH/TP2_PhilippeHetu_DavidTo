package modeles;

import java.sql.ResultSet;

import utilitaire.ControlConnection;

public class GestionArtistes {
	public GestionArtistes(){
		ControlConnection.connecter();
	}
	
	public ResultSet getArtiste(){
		return ControlConnection.getArtiste();
		
	}

}
