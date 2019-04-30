package controleur;

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
import javax.swing.table.DefaultTableModel;



import modeles.Albums;
import modeles.Artiste;
import modeles.GestionArtistes;

import vues.frmAfficher;


public class ControleurArtiste extends MouseAdapter implements ActionListener, ListSelectionListener{
	
	private frmAfficher frm;
	private JButton[] btns;
	private JLabel[] imgs;
	private JTextField[] texts;
	private GestionArtistes gestion = new GestionArtistes();
	private JTable table;
	private JList<String> liste;
	private JCheckBox box;
	
	private ImageIcon imgArtiste;
	private ImageIcon  imgAlbum;
	
	private DefaultTableModel model;
		
	
	
	public ControleurArtiste(frmAfficher form) {
		frm = form;
		btns = frm.getBtn();
		imgs = frm.getImg();
		texts = frm.getTextes();
		table = frm.getTable();
		liste = frm.getListe();
		model = frm.getModel();
		box = frm.getCheckMembre();

		imgArtiste = new ImageIcon(resizeImage("img/defaut.png", imgs[0].getWidth(), imgs[0].getHeight()));

		imgs[0].setIcon(imgArtiste);

		imgAlbum = new ImageIcon(resizeImage("img/defaut.png", imgs[1].getWidth(), imgs[1].getHeight()));

		imgs[1].setIcon(imgAlbum);

		loadJTable();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btns[0]) {
			if (btns[0].getText() != "") {
				ResultSet result = gestion.rechercheArtiste(texts[0].getText());
			resetJTable();
				try {
					while (result.next()) {
						
						model.addRow(new Object[] { result.getInt("Numero"), result.getString("nom"), result.getBoolean("membre") });
						
					}
					table.setModel(model);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			} else {
				loadJTable();
			}
			
			
			
		} else if (e.getSource() == btns[1]) {
			new Quitter();

		} else if (e.getSource() == btns[2]) {
			texts[1].setEditable(true);
			texts[2].setEditable(true);
			texts[1].setText("");
			texts[2].setText("");
			box.setSelected(false);

		} else if (e.getSource() == btns[3]) {
			if ( !texts[1].getText().isEmpty() && !texts[2].getText().isEmpty() ) {
				gestion.ajouterArtiste( new Artiste( Integer.parseInt( texts[1].getText() ), texts[2].getText(),
						box.isSelected(), "img/defaut.png" ) );
			}else{
				JOptionPane.showMessageDialog( null, "Les champs numero et nom de l'artiste ne peut être vide.",
						"Erreur", JOptionPane.ERROR_MESSAGE );
			}
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int indice = table.getSelectedRow();
		int numero =(int) table.getValueAt(indice, 0);
		String nom = (String) table.getValueAt(indice, 1);
		boolean membre = (boolean) table.getValueAt(indice, 2);
		
		texts[1].setText("" + numero);
		texts[2].setText("" + nom);
		
		if (membre) {
			box.setSelected(true);
		} else {
			box.setSelected(false);
		}
		
		loadAlbums(numero);
			
		
	
	}
	
	private void loadAlbums(int numero) {
		
		ArrayList<Albums> listeAlbums = gestion.getAlbumDeArtiste(numero);
		
		DefaultListModel<String> modelAlbum = new DefaultListModel<String>();
		
		
		
		for (int i = 0; i < listeAlbums.size(); i++) {
			Albums album = listeAlbums.get(i);
			modelAlbum.addElement(album.toString());
		}
		
		liste.setModel(modelAlbum);
		
		
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
	
	private void loadJTable(){
		ArrayList<Artiste> listeArtiste = gestion.getListeArtiste();

		for (int i = 0; i < listeArtiste.size(); i++) {
			Artiste artiste = listeArtiste.get(i);
			int num = artiste.getNumero();
			String nom = artiste.getNom();
			boolean membre = artiste.getMembre();

			model.addRow(new Object[] { num, nom, membre });

		}
		table.setModel(model);
	}
	
	private void resetJTable(){
		int nb = model.getRowCount();
		for (int i = 0; i < nb; i++) {
			model.removeRow(nb-(i+1));
		}
	}

}
