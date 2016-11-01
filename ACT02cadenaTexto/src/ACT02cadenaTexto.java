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

/*Miguel Ángel Simeón Sansebastián
 * Actividad 02 - Cadena de texto */
	
	private JPanel contentPane;		//Se define el panel gráfico
	
	private JLabel etiquetaTitulo;	//Se define la etiqueta del título
	private JLabel etiquetaInstr;	//Se define la etiqueta de las instrucciones
	private JTextField cajaTexto1;	//Se define la Caja de Texto 1 - Izquierda
	private JTextField cajaTexto2;	//Se define la Caja de Texto 2 - Derecha
	private JButton boton1;			//Se define el Boton 1 - Hacia la izquierda
	private JButton boton2;			//Se define el Boton 2 - Hacia la derecha
	private JButton boton3;			//Se define el Boton 3 - Intercambio	

	
	
//ENTRADA A LA APLICACIÓN
	
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

	
//CONSTRUCTOR - CONFIGURACIÓN
	
	public ACT02cadenaTexto() {
		
		//Panel gráfico
		setTitle("ACTIVIDAD 02");							//Título del Panel gráfico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 173);						//Tamaño Panel gráfico
		
		//Contenedor
		contentPane = new JPanel();							//Se define el Contenedor
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);						//Se añade el Contenedor al Panel gráfico
		contentPane.setLayout(null);						//Colocación libre dentro del Contenedor
		
		//Etiqueta del Título
		etiquetaTitulo = new JLabel("CADENA DE TEXTO");					//Se crea la etiqueta con su texto
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);	//Alineación del texto
		etiquetaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));		//Tipografía y tamaño del texto
		etiquetaTitulo.setBounds(10, 11, 414, 27);						//Posición y tamaño de la etiqueta
		contentPane.add(etiquetaTitulo);								//Se añade la etiqueta al Contenedor
		
		//Etiqueta de las instrucciones
		etiquetaInstr = new JLabel("Presiona los botones para mover el texto de un lado a otro seg\u00FAn las felchas");	//Se crea la etiqueta con su texto
		etiquetaInstr.setHorizontalAlignment(SwingConstants.CENTER);	//Alineación del texto
		etiquetaInstr.setBounds(10, 38, 414, 14);						//Posición y tamaño de la etiqueta
		contentPane.add(etiquetaInstr);									//Se añade la etiqueta al Contenedor
		
		//Caja de Texto 1 - Izquierda
		cajaTexto1 = new JTextField();								//Se crea la Caja de Texto
		cajaTexto1.setHorizontalAlignment(SwingConstants.CENTER);	//Alineación del texto
		cajaTexto1.setText("Izquierda");							//Texto
		cajaTexto1.setBounds(10, 77, 143, 20);						//Posición y tamaño
		contentPane.add(cajaTexto1);								//Se añade la Caja de Texto al Contenedor
		cajaTexto1.setColumns(10);
		
		//Caja de Texto 2 - Derecha
		cajaTexto2 = new JTextField();								//Se crea la Caja de Texto	
		cajaTexto2.setHorizontalAlignment(SwingConstants.CENTER);	//Alineación del texto
		cajaTexto2.setText("Derecha");								//Texto
		cajaTexto2.setColumns(10);
		cajaTexto2.setBounds(281, 77, 143, 20);						//Posición y tamaño
		contentPane.add(cajaTexto2);								//Se añade la Caja de Texto al Contenedor
		
		//Boton 1 - Hacia la izquierda
		boton1 = new JButton("<-");								//Se crea el botón con su texto
			//Listener - botón a la espera
			boton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				//Acción del botón
					cajaTexto1.setText(cajaTexto2.getText());	//Coloca en la Caja de Texto 1 el texto de la Caja de Texto 2
				}
			});
		boton1.setBounds(163, 76, 50, 23);						//Posición y tamaño
		contentPane.add(boton1);								//Se añade el botón al Contenedor
		
		
		//Boton 2 - Hacia la derecha
		boton2 = new JButton("->");								//Se crea el botón con su texto
			//Listener - botón a la espera
			boton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Acción del botón
					cajaTexto2.setText(cajaTexto1.getText());	//Coloca en la Caja de Texto 2 el texto de la Caja de Texto 1
				}
			});
		boton2.setBounds(223, 76, 50, 23);						//Posición y tamaño
		contentPane.add(boton2);								//Se añade el botón al Contenedor
		
		
		//Boton 3 - Intercambio
		boton3 = new JButton("<- ->");							//Se crea el botón con su texto
			//Listener - botón a la espera
			boton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Acción del botón
					String intercambio=cajaTexto1.getText();	//Variable intercambio con el valor del texto de la Caja de Texto 1
					cajaTexto1.setText(cajaTexto2.getText());	//Coloca en la Caja de Texto 1 el texto de la Caja de Texto 2
					cajaTexto2.setText(intercambio);			//Coloca el valor de la variable intercambio el texto de la Caja de Texto 2
				}
			});
		boton3.setBounds(163, 100, 110, 23);					//Posición y tamaño
		contentPane.add(boton3);								//Se añade el botón al Contenedor
		
		
		
			
			
	}
}
