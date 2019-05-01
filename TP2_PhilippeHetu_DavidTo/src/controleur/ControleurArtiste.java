package controleur;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modeles.Albums;
import modeles.Artiste;
import modeles.GestionArtistes;
import utilitaire.ModeleArtiste;
import vues.frmAfficher;


public class ControleurArtiste extends MouseAdapter implements ActionListener, ListSelectionListener{
	
	private frmAfficher frm;
	private JButton[] btns;
	private JLabel[] imgs;
	private JTextField[] texts;
	private GestionArtistes gestion = new GestionArtistes();
	private JTable table;
	private JList<String> listeAlbums;
	private JCheckBox box;
	
	private ImageIcon imgArtiste;
	private ImageIcon  imgAlbum;
	
	private ModeleArtiste model = new ModeleArtiste(gestion.getListeArtiste());
		
	
	
	public ControleurArtiste(frmAfficher form) {
		frm = form;
		btns = frm.getBtn();
		imgs = frm.getImg();
		texts = frm.getTextes();
		table = frm.getTable();
		listeAlbums = frm.getListe();
		
		box = frm.getCheckMembre();

		table.setModel(model);
		
		

		imgArtiste = new ImageIcon(resizeImage("img/defaut.png", imgs[0].getWidth(), imgs[0].getHeight()));

		imgs[0].setIcon(imgArtiste);

		imgAlbum = new ImageIcon(resizeImage("img/defaut.png", imgs[1].getWidth(), imgs[1].getHeight()));

		imgs[1].setIcon(imgAlbum);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btns[0]) {
			if (btns[0].getText() != "") {
				ArrayList<Artiste> result = gestion.rechercheArtiste(texts[0].getText());
			  
				model.refresh(result);
				
				table.setModel(model);
				
			} else {
				loadJTable();
			}
			
			
			
		} else if (e.getSource() == btns[1]) {
			new Quitter();

		} else if (e.getSource() == btns[2]) {
		
			texts[2].setEditable(true);
			texts[1].setText(""+(gestion.getDernierNumero()+1));
			texts[2].setText("");
			box.setSelected(false);

		} else if (e.getSource() == btns[3]) {
			if ( !texts[1].getText().isEmpty() && !texts[2].getText().isEmpty() ) {
				Artiste artiste = new Artiste( Integer.parseInt( texts[1].getText() ), texts[2].getText(),
						box.isSelected(), "defaut.png" );
				gestion.ajouterArtiste( artiste );
				model.addArtiste(artiste);
			}else{
				JOptionPane.showMessageDialog( null, "Les champs numero et nom de l'artiste ne peut être vide.",
						"Erreur", JOptionPane.ERROR_MESSAGE );
			}
			
			texts[2].setEditable(false);
			
		}else if(e.getSource() == btns[5]){
			int indice = table.getSelectedRow();
			int numero =(int) table.getValueAt(indice, 0);
			String nom = (String) table.getValueAt(indice, 1);
			boolean membre = (boolean) table.getValueAt(indice, 2);
			gestion.supprimerArtiste( new Artiste( numero, nom, membre, "" ) );
			model.deleteData(indice);
			
			
		}

	}

	private void loadJTable() {
	    ArrayList<Artiste> liste = gestion.getListeArtiste();
	    model.refresh(liste);
	    table.setModel(model);
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int indice = table.getSelectedRow();
			int numero = (int) table.getValueAt(indice, 0);
			String nom = (String) table.getValueAt(indice, 1);
			boolean membre = (boolean) table.getValueAt(indice, 2);

		if (e.getSource() == table.getSelectionModel()) {
			
			
			imgAlbum = new ImageIcon(resizeImage("img/defaut.png", imgs[1].getWidth(), imgs[1].getHeight()));

			imgs[1].setIcon(imgAlbum);

			texts[1].setText("" + numero);
			texts[2].setText("" + nom);

			if (membre) {
				box.setSelected(true);
			} else {
				box.setSelected(false);
			}

			loadAlbums(numero);
		} else if (e.getSource() == listeAlbums) {
			ArrayList<Albums> listeAlbums = gestion.getAlbumDeArtiste(numero);
			try {
				int index = this.listeAlbums.getSelectedIndex();

				Albums album = listeAlbums.get(index);

				imgAlbum = new ImageIcon(resizeImage("img/" + album.image, imgs[1].getWidth(), imgs[1].getHeight()));

				imgs[1].setIcon(imgAlbum);
			} catch (Exception e2) {

			}

		}
		
		
		
	
	}
	
	private void loadAlbums(int numero) {
		
		ArrayList<Albums> listeAlbums = gestion.getAlbumDeArtiste(numero);
		
		DefaultListModel<String> modelAlbum = new DefaultListModel<String>();
		
		
		
		for (int i = 0; i < listeAlbums.size(); i++) {
			Albums album = listeAlbums.get(i);
			modelAlbum.addElement(album.toString());
		}
		
		this.listeAlbums.setModel(modelAlbum);
		
		
	}

	private Image resizeImage(String chemin, int width, int height){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(chemin));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(width, height,
		        Image.SCALE_SMOOTH);
		
		return dimg;
	}	
	

}
