package controleur;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
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
import utilitaire.Filtre;
import utilitaire.MethodeAide;
import utilitaire.ModeleArtiste;
import vues.VueModifier;
import vues.frmAfficher;

public class ControleurArtiste extends MouseAdapter implements ActionListener, ListSelectionListener {

	private frmAfficher frm;
	private JButton[] btns;
	private JLabel[] imgs;
	private JTextField[] texts;
	private GestionArtistes gestion = new GestionArtistes();
	private JTable table;
	private JList<String> listeAlbums;
	private JCheckBox box;
	private VueModifier modif;
	private JButton[] buttonModif;
	private JTextField[] textModif;
	private Artiste artiste;
	private JCheckBox boxModif;

	private ImageIcon imgArtiste;
	private ImageIcon imgAlbum;

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
			texts[1].setText("" + (gestion.getDernierNumero() + 1));
			texts[2].setText("");
			box.setSelected(false);

		} else if (e.getSource() == btns[3]) {
			if (!texts[1].getText().isEmpty() && !texts[2].getText().isEmpty()) {
				Artiste artiste = new Artiste(Integer.parseInt(texts[1].getText()), texts[2].getText(),
						box.isSelected(), "defaut.png");
				boolean reussi = gestion.ajouterArtiste(artiste);
				if (reussi) {
					model.addArtiste(artiste);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Les champs numero et nom de l'artiste ne peut �tre vide.",
						"Erreur", JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == btns[4]) {
			loadVueModifier();
		} else if (e.getSource() == btns[5]) {
			try {
				int indice = table.getSelectedRow();
				int numero = (int) table.getValueAt(indice, 0);
				String nom = (String) table.getValueAt(indice, 1);
				boolean membre = (boolean) table.getValueAt(indice, 2);
				gestion.supprimerArtiste(new Artiste(numero, nom, membre, ""));
				model.deleteData(indice);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Il n'y a pas d'artiste choisi.", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == btns[6]) {

			try {
				if (table.getSelectedRow() == -1) {
					throw new Exception();
				}
				
				
				JFileChooser chooser = new JFileChooser();

				chooser.setAcceptAllFileFilterUsed(false);
				chooser.setCurrentDirectory(new File("img"));
				String[] ext = { "jpg", "gif", "png", "bmp", "jpeg" };
				Filtre filtreImg = new Filtre(ext, "Les fichier images (*.jpg), (*.gif), (*.png), (*.bmp), (*.jpeg)");
				chooser.addChoosableFileFilter(filtreImg);

				if (chooser.showOpenDialog(frm) == JFileChooser.APPROVE_OPTION) {
					try {
						File img = chooser.getSelectedFile();

						if (!chooser.getCurrentDirectory().getPath()
								.equals((System.getProperty("user.dir") + "\\img"))) {

							throw new Exception();
						} else {
							String[] temp = img.getPath().split("\\\\");
							String photo = temp[temp.length - 1];

							int indice = table.getSelectedRow();

							int numero = (int) table.getValueAt(indice, 0);

							String nom = (String) table.getValueAt(indice, 1);

							boolean membre = (boolean) table.getValueAt(indice, 2);

							gestion.modifierArtiste(new Artiste(numero, nom, membre, photo));
							imgArtiste = new ImageIcon(
									resizeImage("img/" + photo, imgs[0].getWidth(), imgs[0].getHeight()));
							imgs[0].setIcon(imgArtiste);

						}

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,
								"Le fichier n'est pas supporter ou n'est pas dans le dossier img", "Erreur",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			} catch (Exception e3) {
				JOptionPane.showMessageDialog(null, "Il n'y a pas d'artiste choisi.", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == btns[7]) {
			new MethodeAide();
		}
		
		else if (e.getSource() == buttonModif[0]) {

			int indice = table.getSelectedRow();
			int num;
			String nom;
			boolean memb;
			num = Integer.parseInt((textModif[0].getText()));
			nom = textModif[1].getText();
			memb = boxModif.isSelected();
			gestion.modifierArtisteReg(num, nom, memb);
			artiste = new Artiste(num, nom, memb);
			model.modifierData(indice, artiste);
			modif.dispose();

		} else if (e.getSource() == buttonModif[1]) {
			modif.dispose();
		} 

	}

	private void loadJTable() {
		ArrayList<Artiste> liste = gestion.getListeArtiste();
		model.refresh(liste);
		table.setModel(model);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			loadVueModifier();

		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		int indice = table.getSelectedRow();
		int numero = (int) table.getValueAt(indice, 0);
		String nom = (String) table.getValueAt(indice, 1);
		boolean membre = (boolean) table.getValueAt(indice, 2);

		if (e.getSource() == table.getSelectionModel()) {

			Artiste artiste = gestion.getArtisteSpecifique(numero);

			imgAlbum = new ImageIcon(resizeImage("img/" + artiste.getPhoto(), imgs[0].getWidth(), imgs[0].getHeight()));

			imgs[0].setIcon(imgAlbum);

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

	private Image resizeImage(String chemin, int width, int height) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(chemin));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image dimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

		return dimg;
	}

	private void loadVueModifier() {
		try {
			int indice = table.getSelectedRow();
			int numero = (int) table.getValueAt(indice, 0);
			String nom = (String) table.getValueAt(indice, 1);
			boolean membre = (boolean) table.getValueAt(indice, 2);
			modif = new VueModifier(numero, nom, membre, this);
			modif.setVisible(true);
			textModif = modif.getText();
			buttonModif = modif.getButton();
			boxModif = modif.getBox();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Il n'y a pas d'artiste choisi.", "Erreur", JOptionPane.ERROR_MESSAGE);
		}

	}

}
