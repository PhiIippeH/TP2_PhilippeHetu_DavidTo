package vues;




import java.awt.Font;

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
	private JLabel lblArtistes = new JLabel("Artistes");
	private JButton btnRemplacer = new JButton("Remplacer");
	private JLabel lblArtiste = new JLabel("Artistes");
	private JLabel lblNumero = new JLabel("Num\u00E9ro");
	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblMembre = new JLabel("Membre");
	private JCheckBox checkMembre = new JCheckBox("");
	private JLabel lblImageGauche = new JLabel("Image");
	private JLabel lblDroite = new JLabel("Image");
	private JList listAlbums;
	private ControleurArtiste control;
	
	private JButton[] btnGroup = {btnRecherche,btnQuitter,btnNouveau, btnAjouter,btnModifier,btnSupprimer,btnRemplacer};
	private JLabel[] imgGroupe = {lblImageGauche,lblDroite};
	private JTextField[] texteGroupe = {champRecherche,champNumero,champNom};
	
	private DefaultTableModel model;
	
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	
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
		
		lblArtiste.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblArtiste.setBounds(22, 283, 85, 30);
		getContentPane().add(lblArtiste);
		
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
		champNumero.setColumns(10);
		champNumero.setBounds(82, 320, 190, 30);
		getContentPane().add(champNumero);
		
		champNom = new JTextField();
		champNom.setColumns(10);
		champNom.setBounds(82, 355, 190, 30);
		getContentPane().add(champNom);
		
		checkMembre.setBounds(82, 396, 21, 21);
		getContentPane().add(checkMembre);
		
		listAlbums = new JList();
		listAlbums.setBounds(282, 320, 218, 153);
		getContentPane().add(listAlbums);
		
		lblImageGauche.setBounds(22, 119, 100, 109);
		getContentPane().add(lblImageGauche);
		
		lblDroite.setBounds(527, 320, 186, 153);
		getContentPane().add(lblDroite);
		scrollPane.setBounds(136, 80, 458, 187);
		
		getContentPane().add(scrollPane);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setModel( model = new DefaultTableModel(
			null,
			new String[] {
				"Num\u00E9ro d'artiste", "Nom", "Membre"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		
		table.getColumnModel().getColumn(0).setCellRenderer(new Rendu());
		
		scrollPane.setViewportView(table);	
		
		control = new ControleurArtiste(this);
		
		for (int i = 0; i < btnGroup.length; i++) {
			btnGroup[i].addActionListener(control);
		}
		
		
			
		
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
	public JList getListe(){
		return listAlbums;
	}
	
	public DefaultTableModel getModel(){
		return model;
	}
	
	
}
