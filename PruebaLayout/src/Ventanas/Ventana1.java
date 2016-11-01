package Ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Ventana1 extends JPanel {

//DEFINICIÓN DE OBJETOS*********************************************************************************DEFINICIÓN OBJETOS
	private JLabel label;
//FIN DEFINICIÓN OBJETOS--------------------------------------------------------------------------------DEFINICIÓN OBJETOS
	
//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	public Ventana1() {
		setBackground(Color.RED);
		setLayout(null);
		
		label = new JLabel("Ventana 1");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(176, 121, 97, 42);
		add(label);

	}
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR
}
