package vues;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ChoixForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnArtiste;
	private JButton btnAlbums;
	private JButton btnQuitter;
	
	public ChoixForm(){
		super( "Choix Artistes/Albums" );
		setResizable( false );
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnArtiste());
		getContentPane().add(getBtnAlbums());
		getContentPane().add(getBtnQuitter());
	}

	private JButton getBtnArtiste() {
		if (btnArtiste == null) {
			btnArtiste = new JButton("Artistes");
			btnArtiste.setBounds(72, 46, 291, 48);
		}
		return btnArtiste;
	}
	private JButton getBtnAlbums() {
		if (btnAlbums == null) {
			btnAlbums = new JButton("Albums");
			btnAlbums.setBounds(72, 105, 291, 48);
		}
		return btnAlbums;
	}
	private JButton getBtnQuitter() {
		if (btnQuitter == null) {
			btnQuitter = new JButton("Quitter");
			btnQuitter.setBounds(72, 164, 291, 48);
		}
		return btnQuitter;
	}
	
	
	
	
}
