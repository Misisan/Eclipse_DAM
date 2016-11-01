import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SwingObjects extends JFrame { //La clase SwingObjects es del tipo JFrame

	

	
	//LANZADOR DE LA APLICACIÓN main
	
	public static void main(String[] args) {
		System.out.println("Bienvenidos a mi programa de ventanas");
		VentanaPrincipal ventana = new VentanaPrincipal(); // Crear objeto "ventana" de clase "VentanaPrincipal"
		ventana.setVisible(true);// Hacer visible el objeto "ventana"
	}

	
	//CONSTRUCTOR
	
	public SwingObjects() {
		
	}

}
