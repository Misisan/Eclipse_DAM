import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanasYvariables extends JFrame {

	private JPanel contentPane; //Definimos el contenedor grande
	private JTextField caja1; //Definimos la caja de texto
	private JLabel etiqueta2;
	private JTextField caja2;

	// main es el principi de l'aplicació, sols pot hi haure un
	//Lanzar ventana
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanasYvariables frame = new VentanasYvariables();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Configurar ventana
	public VentanasYvariables() {
		String nombre="Paco";
		int numeroAlumnos=25;
		
		//Configuración de mi contenedor grande
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
		//Contenedor xicotet
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
		
			//Caja texto 1
			caja1 = new JTextField();
			caja1.setText("Supercalifragilisticuespialidoso");
			caja1.setBounds(10, 54, 206, 20);
			contentPane.add(caja1);
			caja1.setColumns(10);
		
		
			//Etiqueta 1
			JLabel etiqueta1 = new JLabel("Super Etiqueta");
			etiqueta1.setBounds(10, 22, 155, 14);
			contentPane.add(etiqueta1);
		
			//Etiqueta 2
			etiqueta2 = new JLabel("Super Etiqueta");
			etiqueta2.setBounds(10, 96, 155, 14);
			contentPane.add(etiqueta2);
			
			//Caja texto 2
			caja2 = new JTextField();
			caja2.setText(String.valueOf(numeroAlumnos));
			caja2.setColumns(10);
			caja2.setBounds(10, 128, 206, 20);
			contentPane.add(caja2);
	}
}
