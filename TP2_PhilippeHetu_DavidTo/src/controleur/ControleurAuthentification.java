package controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modeles.Authentification;
import utilitaire.MethodeAide;
import vues.ChoixForm;
import vues.IdentificationUtilisateur;



public class ControleurAuthentification implements ActionListener{
	private IdentificationUtilisateur vue;
	private JButton[] groupe;
	private JTextField[] textes;

	public ControleurAuthentification(IdentificationUtilisateur form) {
		vue = form;
		groupe = vue.getBtn();
		textes = vue.getTexte();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == groupe[0]) {
			Authentification auth = new Authentification(textes);
			
			if (auth.getVerif()) {
				new ChoixForm().setVisible(true);;
				vue.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Le nom ou le mot de passe entrer est invalide","Erreur",JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == groupe[1]) {
			new Quitter();
		}else if (e.getSource() == groupe[2]) {
			new MethodeAide();
		}
	}

}
