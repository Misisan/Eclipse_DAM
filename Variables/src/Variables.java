import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Variables extends JFrame {

	private JPanel contentPane;
	private JTextField cajaTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Variables frame = new Variables();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Variables() {
		String cadenaTexto="wanchipanchi";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cajaTexto = new JTextField();
		cajaTexto.setBounds(10, 39, 147, 20);
		contentPane.add(cajaTexto);
		cajaTexto.setColumns(10);
		
		cajaTexto.setText(cadenaTexto);
	}
}
