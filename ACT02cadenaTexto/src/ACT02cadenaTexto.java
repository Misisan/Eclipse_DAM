import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ACT02cadenaTexto extends JFrame {

/*Miguel �ngel Sime�n Sansebasti�n
 * Actividad 02 - Cadena de texto */
	
	private JPanel contentPane;		//Se define el panel gr�fico
	
	private JLabel etiquetaTitulo;	//Se define la etiqueta del t�tulo
	private JLabel etiquetaInstr;	//Se define la etiqueta de las instrucciones
	private JTextField cajaTexto1;	//Se define la Caja de Texto 1 - Izquierda
	private JTextField cajaTexto2;	//Se define la Caja de Texto 2 - Derecha
	private JButton boton1;			//Se define el Boton 1 - Hacia la izquierda
	private JButton boton2;			//Se define el Boton 2 - Hacia la derecha
	private JButton boton3;			//Se define el Boton 3 - Intercambio	

	
	
//ENTRADA A LA APLICACI�N
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ACT02cadenaTexto frame = new ACT02cadenaTexto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
//CONSTRUCTOR - CONFIGURACI�N
	
	public ACT02cadenaTexto() {
		
		//Panel gr�fico
		setTitle("ACTIVIDAD 02");							//T�tulo del Panel gr�fico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 173);						//Tama�o Panel gr�fico
		
		//Contenedor
		contentPane = new JPanel();							//Se define el Contenedor
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);						//Se a�ade el Contenedor al Panel gr�fico
		contentPane.setLayout(null);						//Colocaci�n libre dentro del Contenedor
		
		//Etiqueta del T�tulo
		etiquetaTitulo = new JLabel("CADENA DE TEXTO");					//Se crea la etiqueta con su texto
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);	//Alineaci�n del texto
		etiquetaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));		//Tipograf�a y tama�o del texto
		etiquetaTitulo.setBounds(10, 11, 414, 27);						//Posici�n y tama�o de la etiqueta
		contentPane.add(etiquetaTitulo);								//Se a�ade la etiqueta al Contenedor
		
		//Etiqueta de las instrucciones
		etiquetaInstr = new JLabel("Presiona los botones para mover el texto de un lado a otro seg\u00FAn las felchas");	//Se crea la etiqueta con su texto
		etiquetaInstr.setHorizontalAlignment(SwingConstants.CENTER);	//Alineaci�n del texto
		etiquetaInstr.setBounds(10, 38, 414, 14);						//Posici�n y tama�o de la etiqueta
		contentPane.add(etiquetaInstr);									//Se a�ade la etiqueta al Contenedor
		
		//Caja de Texto 1 - Izquierda
		cajaTexto1 = new JTextField();								//Se crea la Caja de Texto
		cajaTexto1.setHorizontalAlignment(SwingConstants.CENTER);	//Alineaci�n del texto
		cajaTexto1.setText("Izquierda");							//Texto
		cajaTexto1.setBounds(10, 77, 143, 20);						//Posici�n y tama�o
		contentPane.add(cajaTexto1);								//Se a�ade la Caja de Texto al Contenedor
		cajaTexto1.setColumns(10);
		
		//Caja de Texto 2 - Derecha
		cajaTexto2 = new JTextField();								//Se crea la Caja de Texto	
		cajaTexto2.setHorizontalAlignment(SwingConstants.CENTER);	//Alineaci�n del texto
		cajaTexto2.setText("Derecha");								//Texto
		cajaTexto2.setColumns(10);
		cajaTexto2.setBounds(281, 77, 143, 20);						//Posici�n y tama�o
		contentPane.add(cajaTexto2);								//Se a�ade la Caja de Texto al Contenedor
		
		//Boton 1 - Hacia la izquierda
		boton1 = new JButton("<-");								//Se crea el bot�n con su texto
			//Listener - bot�n a la espera
			boton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				//Acci�n del bot�n
					cajaTexto1.setText(cajaTexto2.getText());	//Coloca en la Caja de Texto 1 el texto de la Caja de Texto 2
				}
			});
		boton1.setBounds(163, 76, 50, 23);						//Posici�n y tama�o
		contentPane.add(boton1);								//Se a�ade el bot�n al Contenedor
		
		
		//Boton 2 - Hacia la derecha
		boton2 = new JButton("->");								//Se crea el bot�n con su texto
			//Listener - bot�n a la espera
			boton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Acci�n del bot�n
					cajaTexto2.setText(cajaTexto1.getText());	//Coloca en la Caja de Texto 2 el texto de la Caja de Texto 1
				}
			});
		boton2.setBounds(223, 76, 50, 23);						//Posici�n y tama�o
		contentPane.add(boton2);								//Se a�ade el bot�n al Contenedor
		
		
		//Boton 3 - Intercambio
		boton3 = new JButton("<- ->");							//Se crea el bot�n con su texto
			//Listener - bot�n a la espera
			boton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Acci�n del bot�n
					String intercambio=cajaTexto1.getText();	//Variable intercambio con el valor del texto de la Caja de Texto 1
					cajaTexto1.setText(cajaTexto2.getText());	//Coloca en la Caja de Texto 1 el texto de la Caja de Texto 2
					cajaTexto2.setText(intercambio);			//Coloca el valor de la variable intercambio el texto de la Caja de Texto 2
				}
			});
		boton3.setBounds(163, 100, 110, 23);					//Posici�n y tama�o
		contentPane.add(boton3);								//Se a�ade el bot�n al Contenedor
		
		
		
			
			
	}
}
