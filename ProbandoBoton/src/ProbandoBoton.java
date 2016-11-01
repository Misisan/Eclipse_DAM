import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ProbandoBoton extends JFrame {

	private JPanel contentPane;
	private JTextField texto1;
	private JButton boton2;
	private JTextField texto2;

	// Punto de entrada main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProbandoBoton frame = new ProbandoBoton();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor - Configuración de la ventana
	public ProbandoBoton() {
		
		//Marco y contenido
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Boton 1
		JButton boton1 = new JButton("DAME M\u00C1S !!");
			//Listener + evento, estamos a la espera de que ocurra algo
		boton1.addActionListener(new ActionListener() { //Esta parte del código aparece al hacerle doble click al botón en el editor gráfico
			public void actionPerformed(ActionEvent arg0) { 
				//Acción a desarrollar
				System.out.println("Mensaje en una botella");
				texto1.setText("Mensaje de texto"); //en la caja "texto1" escribe "Mensaje de texto"
			}
			
		});
		boton1.setBounds(10, 11, 122, 23);
		contentPane.add(boton1);
		
		//Caja de texto 1
		texto1 = new JTextField();
		texto1.setBounds(10, 46, 424, 20);
		contentPane.add(texto1);
		texto1.setColumns(10);
		
		//Boton 2
		boton2 = new JButton("SIGUE M\u00C1S !!");
			
			//Listener + evento
			boton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					texto2.setText(texto1.getText()); //En el texto2 posa el text (setText) que agarres (getText) del texto1
				}
		});
		boton2.setBounds(10, 112, 122, 23);
		contentPane.add(boton2);
		
		
		//Caja de texto 2
		texto2 = new JTextField();
		texto2.setColumns(10);
		texto2.setBounds(10, 154, 424, 20);
		contentPane.add(texto2);
		
		
	}
}
