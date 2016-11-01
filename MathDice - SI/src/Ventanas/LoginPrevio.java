package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Jugador.Jugador;
import Modelo.conexionActiveDirectory;
import Modelo.usuarioBBDD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPrevio extends JFrame {

	//DEFINICIÓN OBJETOS Y VARIABLES
	private JPanel contentPane;
	private JLabel label_user;
	private JLabel label_pass;
	private JTextField texto_user;
	private JTextField texto_pass;
	private JButton btn_aws;
	private JButton btn_ad;
	private LoginPrevio logprevref;
	private VentanaMenu vMenu;
	private Registro vReg;
	private usuarioBBDD userbd;
	private conexionActiveDirectory cAD;
	
	//CONSTRUCTOR
	public LoginPrevio() {
		
		//Referencia interna
		logprevref = this;
		
		//Conexion a BBDD
		userbd = new usuarioBBDD();
		
		//JFrame+JPanel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Label usuario
		label_user = new JLabel("Usuario:");
		label_user.setBounds(10, 11, 75, 14);
		contentPane.add(label_user);
		
		//Label contraseña
		label_pass = new JLabel("Contrase\u00F1a:");
		label_pass.setBounds(10, 41, 75, 14);
		contentPane.add(label_pass);
		
		//JTextField usuario
		texto_user = new JTextField();
		texto_user.setBounds(95, 8, 287, 20);
		contentPane.add(texto_user);
		texto_user.setColumns(10);
		
		//JTextField contraseña
		texto_pass = new JTextField();
		texto_pass.setColumns(10);
		texto_pass.setBounds(95, 38, 287, 20);
		contentPane.add(texto_pass);
		
		//Boton Amazon
		btn_aws = new JButton("Entrar por Amazon Web Services");
		btn_aws.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(texto_user.getText().length()>0 && texto_pass.getText().length()>0){
					
					Jugador jugador = userbd.loginAWS(texto_user.getText(), texto_pass.getText());
					if(jugador != null && jugador.getNombre() != null){
						vMenu = new VentanaMenu();
						vMenu.setJugador(jugador);	
						vMenu.setVisible(true);			
						logprevref.setVisible(false);	
					}else{
						JOptionPane.showMessageDialog(contentPane,"Usuario o password incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(contentPane,"Debes introducir usuario y contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btn_aws.setBounds(10, 82, 414, 32);
		contentPane.add(btn_aws);
		
		//Boton Windows
		btn_ad = new JButton("Entrar por Active Directory Windows Server");
		btn_ad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(texto_user.getText().length()>0 && texto_pass.getText().length()>0){
					
					cAD = new conexionActiveDirectory();
					boolean existe = cAD.comprobarAD(texto_user.getText(), texto_pass.getText());
					
					if(existe){
						Jugador jugador = userbd.loginAWS(texto_user.getText(), texto_pass.getText());
						if(jugador != null && jugador.getNombre() != null){
							vMenu = new VentanaMenu();
							vMenu.setJugador(jugador);	
							vMenu.setVisible(true);			
							logprevref.setVisible(false);	
						}else{
							vReg = new Registro();
							vReg.setUserPass(texto_user.getText(), texto_pass.getText());
							vReg.setVisible(true);
							logprevref.setVisible(false);							
						}
					}else{
						JOptionPane.showMessageDialog(contentPane,"Usuario o password incorrecto en AD", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(contentPane,"Debes introducir usuario y contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_ad.setBounds(10, 125, 414, 32);
		contentPane.add(btn_ad);
		
		
	}
}
