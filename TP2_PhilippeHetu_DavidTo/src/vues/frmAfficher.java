package vues;



import java.awt.Color;
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
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;

public class frmAfficher extends JFrame{

	private static final long serialVersionUID = 1L;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	JButton btnRecherche = new JButton("Recherche");
	JButton btnQuitter = new JButton("Quitter");
	JButton btnNouveau = new JButton("Nouveau");
	JButton btnAjouter = new JButton("Ajouter");
	JButton btnModifier = new JButton("Modifier");
	JButton btnSupprimer = new JButton("Supprimer");
	JLabel lblArtistes = new JLabel("Artistes");
	JButton btnRemplacer = new JButton("Remplacer");
	JLabel lblArtiste = new JLabel("Artistes");
	JLabel lblNumero = new JLabel("Num\u00E9ro");
	JLabel lblNom = new JLabel("Nom");
	JLabel lblMembre = new JLabel("Membre");
	JCheckBox checkBoxMembre = new JCheckBox("");
	JLabel lblImageGauche = new JLabel("Image");
	JLabel lblDroite = new JLabel("Image");
	JList list;
	
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
		
		textField = new JTextField();
		textField.setBounds(22, 39, 450, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 320, 190, 30);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(82, 355, 190, 30);
		getContentPane().add(textField_2);
		
		checkBoxMembre.setBounds(82, 396, 21, 21);
		getContentPane().add(checkBoxMembre);
		
		list = new JList();
		list.setBounds(282, 320, 218, 153);
		getContentPane().add(list);
		
		lblImageGauche.setBounds(22, 119, 100, 109);
		getContentPane().add(lblImageGauche);
		
		lblDroite.setBounds(527, 320, 186, 153);
		getContentPane().add(lblDroite);
		scrollPane.setBounds(136, 80, 458, 187);
		
		getContentPane().add(scrollPane);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "alfred", Boolean.TRUE},
				{"2", "alphred", null},
				{"3", "all fred", null},
				{"4", "alfe raide", Boolean.TRUE},
				{"5", "al fraide", Boolean.TRUE},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Num\u00E9ro d'artiste", "Nom", "Membre"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		
		scrollPane.setViewportView(table);		
			
		
	}
	
	
	
	
}
