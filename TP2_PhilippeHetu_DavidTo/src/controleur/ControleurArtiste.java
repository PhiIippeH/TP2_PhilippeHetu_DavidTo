package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modeles.Artiste;
import modeles.GestionArtistes;
import utilitaire.Rendu;
import vues.frmAfficher;


public class ControleurArtiste extends MouseAdapter implements ActionListener, ListSelectionListener{
	
	private frmAfficher frm;
	private JButton[] btns;
	private JLabel[] imgs;
	private JTextField[] texts;
	private GestionArtistes gestion = new GestionArtistes();
	private JTable table;
	private JList liste;
	private JCheckBox box;
	
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
		
		ArrayList<Artiste> listeArtiste = gestion.getListeArtiste();
		
		
		
		for (int i = 0; i < listeArtiste.size(); i++) {
			Artiste artiste = listeArtiste.get(i);
			int num = artiste.getNumero();
			String nom = artiste.getNom();
			boolean membre = artiste.getMembre();
			String photo = artiste.getPhoto();
		
			
			model.addRow(new Object[]{num,nom,membre});
			
		}
		table.setModel(model);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btns[0]) {
			
			
			
		} else if (e.getSource() == btns[1]) {
			new Quitter();

		} else if (e.getSource() == btns[2]) {
			texts[1].setText("");
			texts[2].setText("");
			box.setSelected(false);

		} else if (e.getSource() == btns[3]) {

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
	
	}
	
	

}
