package vues;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IdentificationUtilisateur extends JFrame {

	private static final long serialVersionUID = 1L;
	public Label lblco = new Label( "Connexion à l'application" );
	public Label lblnom = new Label( "Nom d'utilisateur " );
	public Label lblPwd = new Label( "Mot de passe " );
	public JTextField txtNom = new JTextField();
	public JTextField txtPwd = new JTextField();
	public JButton valider = new JButton( "Valider" );
	public JButton quitter = new JButton( "Quitter" );
	public JPanel mid = new JPanel();

	public IdentificationUtilisateur() {

		super( "Gestion des Albums" );
		setSize( 500, 300 );
		setResizable( false );
		setBounds( 100, 100, 450, 300 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		getContentPane().setLayout(null);
		
		
		lblco.setFont(new Font("Arial", Font.BOLD, 16));
		lblco.setBounds(10, 33, 200, 30);
		getContentPane().add(lblco);

		
		lblnom.setFont(new Font("Arial", Font.BOLD, 12));
		lblnom.setBounds(39, 76, 108, 27);
		getContentPane().add(lblnom);
		
		
		lblPwd.setFont(new Font("Arial", Font.BOLD, 12));
		lblPwd.setBounds(39, 109, 108, 27);
		getContentPane().add(lblPwd);
		
		
		txtNom.setBounds(153, 78, 240, 20);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		

		txtPwd.setBounds(153, 109, 240, 20);
		getContentPane().add(txtPwd);
		txtPwd.setColumns(10);
		
		
		valider.setBounds(39, 167, 174, 40);
		getContentPane().add(valider);
		

		quitter.setBounds(223, 167, 170, 40);
		getContentPane().add(quitter);
		
		

	}

}
