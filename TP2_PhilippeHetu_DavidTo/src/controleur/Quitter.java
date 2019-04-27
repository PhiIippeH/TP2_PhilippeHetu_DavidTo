package controleur;


import javax.swing.JOptionPane;

public class Quitter {

	public Quitter() {
		int conf = JOptionPane.showConfirmDialog( null,
				"Voulez-vous vraiment quitter le programme ?", "Quitter le programme",
				JOptionPane.YES_NO_OPTION );
		if ( conf == JOptionPane.YES_OPTION ) {

			System.exit(0);
		}
	}
	


}
