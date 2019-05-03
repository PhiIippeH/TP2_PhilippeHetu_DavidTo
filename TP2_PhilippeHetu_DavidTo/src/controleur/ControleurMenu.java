package controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utilitaire.ControlConnection;
import utilitaire.MethodeAide;
import vues.ChoixForm;
import vues.frmAfficher;

public class ControleurMenu implements ActionListener {
	public ChoixForm vue;

	public ControleurMenu(ChoixForm form) {
		vue = form;
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vue.getBtnArtiste()) {
			
			ControlConnection.connecter();
			frmAfficher id2 = new frmAfficher();
			id2.setVisible( true );
			vue.dispose();
		} else if (e.getSource() == vue.getBtnQuitter()) {
			
			new Quitter();
		} else if (e.getSource() == vue.getBtnAide()) {
			new MethodeAide();
		}
		
	}

}
