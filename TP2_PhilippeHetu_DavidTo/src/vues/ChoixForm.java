package vues;

import javax.swing.JButton;
import javax.swing.JFrame;


import controleur.ControleurMenu;
import java.awt.Button;

public class ChoixForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnArtiste;
	private JButton btnAlbums;
	private JButton btnQuitter;
	private JButton btnAide;
	
	public ChoixForm(){
		super( "Choix Artistes/Albums" );
		setResizable( false );
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ControleurMenu controlMenu = new ControleurMenu(this);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnArtiste());
		getContentPane().add(getBtnAlbums());
		getContentPane().add(getBtnQuitter());
		getContentPane().add(getBtnAide());
		btnArtiste.addActionListener(controlMenu);
		btnQuitter.addActionListener(controlMenu);
		
		
	}

	public JButton getBtnArtiste() {
		if (btnArtiste == null) {
			btnArtiste = new JButton("Artistes");
			btnArtiste.setBounds(72, 46, 291, 48);
		}
		return btnArtiste;
	}
	public JButton getBtnAlbums() {
		if (btnAlbums == null) {
			btnAlbums = new JButton("Albums");
			btnAlbums.setBounds(72, 105, 291, 48);
		}
		return btnAlbums;
	}
	public JButton getBtnQuitter() {
		if (btnQuitter == null) {
			btnQuitter = new JButton("Quitter");
			btnQuitter.setBounds(72, 164, 291, 48);
		}
		return btnQuitter;
	}
	private JButton getBtnAide() {
		if (btnAide == null) {
			btnAide = new JButton("Aide");
			btnAide.setBounds(10, 238, 89, 23);
		}
		return btnAide;
	}
}
