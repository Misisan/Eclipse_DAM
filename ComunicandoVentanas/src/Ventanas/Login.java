package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	
	//DEFINICI�N DE VARIABLES
	
	private JPanel contentPane;
	private JButton boton;
	private JButton botonNueva;
	private Login refLogin; //Defino un objeto Login, igual a la ventana
	private ventanaPrincipal vPrincipal; //Defino el objeto que me enlaza con la ventanaPrincipal para que lo puedan utilizar los botones
										 //sino se hace as� el objeto, al quedar definido dentro del constructor no tiene un �mbito global
										 //por lo que puede darnos problemas al acceder a �l.

	
    //CONSTRUCTOR
	
	public Login(ventanaPrincipal vP) { // As� enlazo las dos ventanas a trav�s de Principal, donde est� el main
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		refLogin=this; //Hago la refencia, le digo que el refLogin del bot�n es el objeto definido en las variables
					   //pero no creo ning�n objeto, solo lo utilizo de enlace para llegar a la clase JFrame "Login"
		vPrincipal=vP; //As� conecto la referencia enviada a trav�s del constructor con el objeto definido a nivel global
		
		//Bot�n CERRAR
		boton = new JButton("Cerrar");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refLogin.dispose(); //Me cargo todos los procesos de refLogin, que est� enlazado a la clase Login, es decir, a la ventana en la que estamos
			}
		});
		boton.setBounds(159, 227, 89, 23);
		contentPane.add(boton);
		
		//Bot�n SIGUIENTE
		
		botonNueva = new JButton("Sig.");
		botonNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vPrincipal.setVisible(true);//Hago visible a ventanaPrincipal
				refLogin.setVisible(false);//Hago invisible a Login por si lo necesito m�s adelante
			}
		});
		botonNueva.setBounds(159, 193, 89, 23);
		contentPane.add(botonNueva);
		
		
	}
}
