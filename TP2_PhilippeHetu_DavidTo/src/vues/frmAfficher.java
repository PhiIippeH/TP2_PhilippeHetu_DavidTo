package vues;




import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

import controleur.ControleurArtiste;
import utilitaire.ControlConnection;
import utilitaire.Rendu;

import javax.swing.ListSelectionModel;

public class frmAfficher extends JFrame{

	private static final long serialVersionUID = 1L;
	public JTextField champRecherche;
	public JTextField champNumero;
	public JTextField champNom;
	
	private JButton btnRecherche = new JButton("Recherche");
	private JButton btnQuitter = new JButton("Quitter");
	private JButton btnNouveau = new JButton("Nouveau");
	private JButton btnAjouter = new JButton("Ajouter");
	private JButton btnModifier = new JButton("Modifier");
	private JButton btnSupprimer = new JButton("Supprimer");
	private JButton btnRemplacer = new JButton("Remplacer");
	
	private JLabel lblArtistes = new JLabel("Artistes");
	private JLabel lblInfo = new JLabel("Informations");
	private JLabel lblNumero = new JLabel("Num\u00E9ro");
	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblMembre = new JLabel("Membre");
	private JLabel lblImageGauche = new JLabel("Image");
	private JLabel lblDroite = new JLabel("Image");
	
	private JCheckBox checkMembre = new JCheckBox("");
	
	private JList<String> listAlbums;
	private ControleurArtiste control;
	
	private JButton[] btnGroup = {btnRecherche,btnQuitter,btnNouveau, btnAjouter,btnModifier,btnSupprimer,btnRemplacer};
	private JLabel[] imgGroupe = {lblImageGauche,lblDroite};
	private JTextField[] texteGroupe = {null,null,null};
	
	private DefaultTableModel model;
	
	private JScrollPane scrollPane = new JScrollPane();
	private JTable table = new JTable();
	

	private Rendu renderer = new Rendu();
	
	public frmAfficher(){
		
		super( "Gestion des Artistes" );
		
		setResizable( false );
		setBounds( 100, 100, 750, 525 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recherche un artiste");
		lblNewLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		lblNewLabel.setBounds(22, 11, 159, 26);
		getContentPane().add(lblNewLabel);
		
		champRecherche = new JTextField();
		champRecherche.setBounds(22, 39, 450, 30);
		getContentPane().add(champRecherche);
		champRecherche.setColumns(10);
		
		btnRecherche.setBounds(477, 39, 100, 30);
		getContentPane().add(btnRecherche);
		
		btnQuitter.setBounds(613, 39, 100, 30);
		getContentPane().add(btnQuitter);
		
		btnNouveau.setBounds(613, 129, 100, 30);
		getContentPane().add(btnNouveau);
		
		btnAjouter.setBounds(613, 163, 100, 30);
		getContentPane().add(btnAjouter);
		
		btnModifier.setBounds(613, 198, 100, 30);
		getContentPane().add(btnModifier);
		
		btnSupprimer.setBounds(613, 233, 100, 30);
		getContentPane().add(btnSupprimer);
		
		lblArtistes.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblArtistes.setBounds(22, 75, 85, 47);
		getContentPane().add(lblArtistes);

		btnRemplacer.setBounds(22, 233, 100, 30);
		getContentPane().add(btnRemplacer);
		
		lblInfo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblInfo.setBounds(22, 283, 136, 30);
		getContentPane().add(lblInfo);
		
		lblNumero.setFont(new Font("Arial", Font.ITALIC, 14));
		lblNumero.setBounds(22, 324, 50, 26);
		getContentPane().add(lblNumero);
		
		lblNom.setFont(new Font("Arial", Font.ITALIC, 14));
		lblNom.setBounds(22, 356, 50, 26);
		getContentPane().add(lblNom);
		
		lblMembre.setFont(new Font("Arial", Font.ITALIC, 14));
		lblMembre.setBounds(22, 393, 59, 26);
		getContentPane().add(lblMembre);
		
		champNumero = new JTextField();
		champNumero.setEditable(false);
		champNumero.setColumns(10);
		champNumero.setBounds(82, 320, 190, 30);
		getContentPane().add(champNumero);
		
		champNom = new JTextField();
		champNom.setEditable(false);
		champNom.setColumns(10);
		champNom.setBounds(82, 355, 190, 30);
		getContentPane().add(champNom);
		
		checkMembre.setBounds(82, 396, 21, 21);
		getContentPane().add(checkMembre);
		
		listAlbums = new JList<String>();
		listAlbums.setBounds(282, 320, 218, 153);
		getContentPane().add(listAlbums);
		
		lblImageGauche.setBounds(22, 119, 100, 109);
		getContentPane().add(lblImageGauche);
		
		lblDroite.setBounds(527, 320, 186, 153);
		getContentPane().add(lblDroite);
	
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane = new JScrollPane(table);
		
		scrollPane.setBounds(136, 80, 458, 187);
		getContentPane().add(scrollPane);	
		
		control = new ControleurArtiste(this);
		
		for (int i = 0; i < btnGroup.length; i++) {
			btnGroup[i].addActionListener(control);
		}
		
		texteGroupe[0] = champRecherche;
		texteGroupe[1] = champNumero;
		texteGroupe[2] = champNom;
		
		table.getColumnModel().getColumn(0).setCellRenderer(renderer);
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e)
		    {
				ControlConnection.fermerSession();
				
		    }

		});
	}
	
	public JButton[] getBtn(){
		return btnGroup;
	}
	
	public JLabel[] getImg(){
		return imgGroupe;
	}
	
	public JTextField[] getTextes(){
		return texteGroupe;
	}
	
	public JTable getTable(){
		return table;
	}
	public JList<String> getListe(){
		return listAlbums;
	}
	
	public DefaultTableModel getModel(){
		return model;
	}

	public JCheckBox getCheckMembre(){
		return checkMembre;
	}
	
}
