package Ventanas;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana2 extends JPanel {

//DEFINICI�N DE OBJETOS*********************************************************************************DEFINICI�N OBJETOS
	private JLabel label;
//FIN DEFINICI�N OBJETOS--------------------------------------------------------------------------------DEFINICI�N OBJETOS
	
//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	public Ventana2() {
		setLayout(null);
		
		label = new JLabel("Ventana 2");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(176, 121, 97, 42);
		add(label);

	}
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR
}
