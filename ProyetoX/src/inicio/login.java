package inicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JLabel labelPass;

	public login() {
		setTitle("PROYECTO X");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JTextField - USUARIO
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setBounds(96, 43, 304, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		//JTextField - CONTRASEÑA
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBounds(96, 83, 304, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		//Labels
		JLabel labelUser = new JLabel("USUARIO");
		labelUser.setHorizontalAlignment(SwingConstants.LEFT);
		labelUser.setBounds(10, 48, 76, 14);
		contentPane.add(labelUser);
		
		labelPass = new JLabel("CONTRASE\u00D1A");
		labelPass.setHorizontalAlignment(SwingConstants.LEFT);
		labelPass.setBounds(10, 88, 76, 14);
		contentPane.add(labelPass);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(351, 11, 49, 20);
		contentPane.add(comboBox);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(311, 135, 89, 23);
		contentPane.add(btnEntrar);
		
		
		
		
	}
}
