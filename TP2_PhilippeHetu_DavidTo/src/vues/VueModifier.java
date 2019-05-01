package vues;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controleur.ControleurModifier;

public class VueModifier extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField textField,textField_1;
	JButton btnModifier = new JButton("Modifier");
	JButton btnNewButton = new JButton("Annuler");
	JCheckBox checkBox = new JCheckBox("");
	
	
	public VueModifier(int num, String nom, boolean memb) {	
		super("Modifier");
		setSize( 500, 300 );
		
		setBounds( 100, 100, 471, 300 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField = new JTextField();
		textField.setEditable( false );
		
		textField.setText( String.valueOf( num ));
		textField_1.setText( nom );
		checkBox.setSelected( memb );
		
		textField.setBounds(123, 76, 276, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Numero");
		lblNewLabel.setBounds(67, 79, 46, 14);
		getContentPane().add(lblNewLabel);
		
		
		textField_1.setColumns(10);
		textField_1.setBounds(123, 107, 276, 20);
		getContentPane().add(textField_1);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(67, 110, 46, 14);
		getContentPane().add(lblNom);
		
		JLabel lblMembre = new JLabel("Membre");
		lblMembre.setBounds(67, 141, 46, 14);
		getContentPane().add(lblMembre);
		
		checkBox.setBounds(123, 134, 97, 23);
		getContentPane().add(checkBox);
		
		JLabel lblNewLabel_1 = new JLabel("Modifier");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(67, 23, 153, 34);
		getContentPane().add(lblNewLabel_1);
		
		btnNewButton.setBounds(67, 166, 153, 23);
		getContentPane().add(btnNewButton);
		
		btnModifier.setBounds(246, 166, 153, 23);
		getContentPane().add(btnModifier);
		
		btnModifier.addActionListener( new ControleurModifier(num,nom,memb,btnModifier,btnNewButton) );
		
	}
	
	public void setNumero(int num){
		
	}
	
	public void setNom(String nom){
		
	}
	
	public void setMembre(boolean memb){
		
	}
	
	
	
}
