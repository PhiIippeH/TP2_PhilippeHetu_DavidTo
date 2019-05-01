package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTable;

import modeles.GestionArtistes;
import vues.VueModifier;

public class ControleurModifier implements MouseListener, ActionListener {
	
	public VueModifier modif;
	JTable table = new JTable();
	int num; 
	String nom; 
	boolean memb;
	JButton modifier;
	JButton annuler;
	GestionArtistes artisteTemp;
	

	public ControleurModifier(JTable table){
		this.table = table;
	}
	
	public ControleurModifier(int num, String nom, boolean memb,JButton modifier, JButton annuler){
		this.num = num;
		this.nom = nom;
		this.memb = memb;
		this.modifier = modifier;
		this.annuler = annuler;
	}

	@Override
	public void mouseClicked( MouseEvent e ) {
		if(e.getClickCount() == 2){
			int indice = table.getSelectedRow();
			int numero = (int) table.getValueAt( indice, 0 );
			String nom = (String) table.getValueAt( indice, 1 );
			boolean membre = (boolean) table.getValueAt( indice, 2 );
			modif = new VueModifier( numero, nom, membre );
			modif.setVisible( true );
			
		}
		
	}

	@Override
	public void mouseEntered( MouseEvent arg0 ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited( MouseEvent arg0 ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed( MouseEvent arg0 ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased( MouseEvent arg0 ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed( ActionEvent e ) {
		if(e.getSource() == modifier){
			artisteTemp.modifierArtisteReg( num, nom, memb );
		}else if(e.getSource() == annuler){
			
		}
		
	}
	

}

