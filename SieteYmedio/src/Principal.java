import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {
	//Variables o propiedades
	private JPanel contentPane;

	//Entrada a la aplicación por el método main
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();//Crea el constructor
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//CONSTRUCTOR - CONFIGURACIÓN
	
	public Principal() {
		
		//Propiedades de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//A partir de aquí nuestro código
		// tipoDeClase nombreVariable= new tipoDeClase();
		Carta sieteBastos= new Carta();
			sieteBastos.setNumero(56);//Obtenemos un número para la variable privada numero a través del método setNumero, esto es para obtener el número no para mostrarlo
			sieteBastos.setPalo("oros");
			System.out.println("Tengo una carta que es el "+sieteBastos.getNumero()+" de "+sieteBastos.getPalo());
		Carta unoOros= new Carta();
			unoOros.setNumero(-5);
			unoOros.setPalo(Carta.OROS);
			System.out.println("Tengo una carta que es el "+unoOros.getNumero()+" de "+unoOros.getPalo());
	}

}
