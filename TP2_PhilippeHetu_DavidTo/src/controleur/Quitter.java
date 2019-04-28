package controleur;



import javax.swing.JOptionPane;

import utilitaire.ControlConnection;

public class Quitter {

	public Quitter() {
		int conf = JOptionPane.showConfirmDialog( null,
				"Voulez-vous vraiment quitter le programme ?", "Quitter le programme",
				JOptionPane.YES_NO_OPTION );
		if ( conf == JOptionPane.YES_OPTION ) {
	
					ControlConnection.fermerSession();
			
			
			System.exit(0);
		} else {
			
		}
	} 
	


}
