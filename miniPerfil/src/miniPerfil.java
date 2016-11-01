import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* Miguel Ángel Simeón Sansebastián
 * Actividad 01 - mini Perfil */

public class miniPerfil extends JFrame {

	private JPanel contenedorPanel; //Se define el contenedor dentro del panel gráfico
	
	private JLabel etiqueta1;		//Se define la Etiqueta 1
	private JTextField cajaTexto1; 	//Se define la Caja de Texto 1
	
	private JLabel etiqueta2;		//Se define la Etiqueta 2
	private JTextField cajaTexto2; 	//Se define la Caja de Texto 2
	
	private JLabel etiqueta3;		//Se define la Etiqueta 3
	private JTextField cajaTexto3;	//Se define la Caja de Texto 3
	
	private JLabel etiqueta4;		//Se define la Etiqueta 4
	private JTextField cajaTexto4;	//Se define la Caja de Texto 4
	

	// ENTRADA A LA APLICACIÓN
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miniPerfil frame = new miniPerfil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//CONSTRUCTOR - CONFIGURACIÓN
	
	public miniPerfil() {
		
		//Variables
		String nombre="Miguel \u00C1ngel";					//Variable String para almacenar el nombre
		String apellidos="Sime\u00F3n Sansebasti\u00E1n";	//Variable String para almacenar los apellidos
		int edad=30;										//Variable int para almacenar la edad
		String correo="miguelsimeon@gmail.com";				//Variable String para el correo
		
		//Panel gráfico - características
		setTitle("mini PERFIL"); 						//Título del Panel gráfico
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 219);					//Posición y tamaño del Panel gráfico
		
		//Contenedor dentro del panel gráfico - características
		contenedorPanel = new JPanel();
		contenedorPanel.setBorder(new EmptyBorder(5, 5, 5, 5));	//Márgenes del Contenedor respecto al Panel gráfico
		setContentPane(contenedorPanel);
		contenedorPanel.setLayout(null); 						//activo la colocación libre de objetos en el Contenedor
		
		//Etiqueta 1 - Nombre
		etiqueta1 = new JLabel("Nombre");					//Texto de la etiqueta
		etiqueta1.setBounds(23, 11, 102, 14);				//Posición y tamaño
		contenedorPanel.add(etiqueta1);						//Se añade el elemento etiqueta1 al Contenedor
		
		//Caja de Texto 1
		cajaTexto1 = new JTextField();
		cajaTexto1.setEditable(false);						//Edición de la caja deshabilitada
		cajaTexto1.setText(nombre);							//Texto de la Caja de Texto 1
		cajaTexto1.setBounds(23, 36, 116, 20);				//Posición y tamaño
		contenedorPanel.add(cajaTexto1);					//Se añade la Caja de Texto al Contenedor
		cajaTexto1.setColumns(10);
		
		//Etiqueta 2 - Apellidos
		etiqueta2 = new JLabel("Apellidos");				//Texto de la etiqueta
		etiqueta2.setBounds(149, 11, 102, 14);				//Posición y tamaño
		contenedorPanel.add(etiqueta2);						//Se añade la Etiqueta al Contenedor
		
		//Caja de Texto 2
		cajaTexto2 = new JTextField();
		cajaTexto2.setEditable(false);						//Edición de la caja deshabilitada
		cajaTexto2.setText(apellidos);						//Texto de la Caja de Texto 2
		cajaTexto2.setColumns(10);
		cajaTexto2.setBounds(149, 36, 169, 20);				//Posición y tamaño
		contenedorPanel.add(cajaTexto2);					//Se añade al Contenedor
		
		//Etiqueta 3 - Edad
		etiqueta3 = new JLabel("Edad");						//Texto
		etiqueta3.setBounds(23, 67, 60, 14);				//Posición y tamaño
		contenedorPanel.add(etiqueta3);						//Se añade al Contenedor
		
		//Caja de Texto 3
		cajaTexto3 = new JTextField();
		cajaTexto3.setEditable(false);						//Edición de la caja deshabilitada
		cajaTexto3.setText(String.valueOf(edad));			//Texto de la Caja de Texto 3 con un String.ValueOf para convertir la variable de tipo int en String
		cajaTexto3.setColumns(10);
		cajaTexto3.setBounds(23, 92, 26, 20);				//Posición y tamaño
		contenedorPanel.add(cajaTexto3);					//Se añade al Contenedor
		
		//Etiqueta 4 - Correo
		etiqueta4 = new JLabel("Correo electr\u00F3nico");	//Texto
		etiqueta4.setBounds(23, 123, 195, 14);				//Posición y tamaño
		contenedorPanel.add(etiqueta4);						//Se añade al Contenedor
		
		//Caja de Texto 4
		cajaTexto4 = new JTextField();
		cajaTexto4.setEditable(false);						//Edición de la caja deshabilitada
		cajaTexto4.setText(correo);							//Texto de la Caja de Texto 4
		cajaTexto4.setColumns(10);
		cajaTexto4.setBounds(23, 148, 183, 20);				//Posición y tamaño
		contenedorPanel.add(cajaTexto4);					//Se añade al Contenedor
		
				
	}

	private String StringOfValue(int edad) {
		// TODO Auto-generated method stub
		return null;
	}

}
