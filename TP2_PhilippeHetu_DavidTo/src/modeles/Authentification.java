package modeles;

import javax.swing.JTextField;

public class Authentification {
	private String id;
	private String pass;
	public Authentification(JTextField[] groupe) {
		id = groupe[0].getText();
		pass = groupe[1].getText();
		
	}
	
	public boolean getVerif(){
		boolean rep = false;
		
		if (id.equals("root") ) {
			
			if (pass.equals("root")) {
				rep = true;
				
			}
			
		} 
		
		return rep;
	}

}
