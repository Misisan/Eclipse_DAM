package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Principal extends JFrame {

//DEFINICIÓN DE OBJETOS*********************************************************************************DEFINICIÓN OBJETOS
	private JPanel contentPane;
	private JButton btnNewButton;
	private General ventana_General;	//Definició para poder visibilizar la nueva ventana
	private Principal ref_propia;		//Referencia para poder ocultar o cerrar esta ventana
//FIN DEFINICIÓN OBJETOS--------------------------------------------------------------------------------DEFINICIÓN OBJETOS
	
//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	public Principal() {
			
		//Referencias
		ref_propia=this;	//Enlace de: Constructor --> Referencia --> Esta ventana
							/*																*
							 * La idea seria que se crea un objeto de esta ventana y después*
							 * le decimos al código que ese objeto es la ventana abierta,	*
							 * así podemos manejarla a través de dicho objeto				*
							 */
		
		//Objeto Ventana de Juego
		ventana_General = new General();	//Objeto de la nueva ventana para poder visibilizarla
		
		//JFrame
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
				
		//JPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Botón
		btnNewButton = new JButton("Iniciar");
		contentPane.add(btnNewButton);
		
		//Botón - Listener
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Llamar a la siguiente ventana
				ventana_General.setVisible(true);		//Se hace visible la ventana General.java
				ref_propia.setVisible(false);			//Se hace invisible esta ventana
			}
		});
		
	}
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR
}
