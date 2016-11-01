package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class General extends JFrame {

//DEFINICIÓN DE OBJETOS*********************************************************************************DEFINICIÓN OBJETOS
	private JPanel contentPane;
	private JMenuBar menu_barra;
	private JMenu menu_opc1;
	private JMenuItem menu_item1_1;
	private JMenu menu_opc2;
	private JMenuItem menu_item2_1;
	private JTextField barra_info;
	private JPanel panel_interno; //CadLayout
		
	//Identificadores para las ventanas del CardLayout
	final static String VENTANA1 = "Ventana 1";
	final static String VENTANA2 = "Ventana 2";
	
	//Ventanas para el CardLayout
	Ventana1 v1 = new Ventana1();
	Ventana2 v2 = new Ventana2();
//FIN DEFINICIÓN OBJETOS--------------------------------------------------------------------------------DEFINICIÓN OBJETOS
	
//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	public General() {
		
		//JFrame
		setTitle("General");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		//JPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Menú
		//Barra general del menú
		menu_barra = new JMenuBar();
		setJMenuBar(menu_barra);
			
			//1a opción del menú
			menu_opc1 = new JMenu("Opci\u00F3n 1");
			menu_barra.add(menu_opc1);
			
				//Menú 1 - Ítem 1
				menu_item1_1 = new JMenuItem("\u00CDtem 1.1");
				menu_item1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						//Le decimos que pille el Layout o ventana a mostrar del CardLayout "panel_interno"
						CardLayout card = (CardLayout)(panel_interno.getLayout());
						//Mostramos en el CardLayout la ventana del identificador VENTANA1
						card.show(panel_interno, VENTANA1);
						
						//Mostramos texto info
						barra_info.setText("Has seleccionado la opción 1 del 1er menú");
					}
				});
				menu_opc1.add(menu_item1_1);
				
				//Separador dentro del menú
				menu_opc1.addSeparator();
			
			//2a opción del menú
			menu_opc2 = new JMenu("Opci\u00F3n 2");
			menu_barra.add(menu_opc2);
				
				//Menú 2 - Ítem 1
				menu_item2_1 = new JMenuItem("\u00CDtem 2.1");
				menu_opc2.add(menu_item2_1);
				menu_item2_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CardLayout card = (CardLayout)(panel_interno.getLayout());
						card.show(panel_interno, VENTANA2);
						barra_info.setText("Has seleccionado la opción 1 del 2o menú");
					}
				});
		
		
		
		//Panel interno - central | CardLayout
		panel_interno = new JPanel();
		contentPane.add(panel_interno, BorderLayout.CENTER);
		panel_interno.setLayout(new CardLayout(0, 0));
			//Añadimos las Ventanas al CardLayout
			panel_interno.add(v1, VENTANA1);
			panel_interno.add(v2, VENTANA2); //Por defecto se visualizará 1o la última introducida
		
		//Caja texto Info inferior
		barra_info = new JTextField();
		barra_info.setEnabled(false);
		barra_info.setEditable(false);
		barra_info.setColumns(10);
		contentPane.add(barra_info, BorderLayout.SOUTH);
	}
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR
}
