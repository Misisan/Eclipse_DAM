import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame {


	private JPanel contentPane; //Layout
	
	
	//CONSTRUCTOR
	
	public VentanaPrincipal() {
		//Propiedades necesarias para lanzar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//El EXIT_ON_CLOSE es el comportamiento de la x de cerrar de windows
		setBounds(100, 100, 450, 300);//Tamaño
		//Añadimos un contenedor layout "JPanel"
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//Añadimos el JPanel al JFrame
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JLabel
		JLabel etiquetaNueva = new JLabel("Texto al crear objeto JLabel");
		etiquetaNueva.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaNueva.setBounds(10, 11, 414, 29);
		etiquetaNueva.setText("Texto del setText");
		contentPane.add(etiquetaNueva);
		
		
	}
}
