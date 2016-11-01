import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class probaLayout extends JFrame {

	private JPanel panelPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		probaLayout frame = new probaLayout();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public probaLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[] {3};
		gbl_panelPrincipal.rowHeights = new int[] {0};
		gbl_panelPrincipal.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelPrincipal.rowWeights = new double[]{1.0};
		panelPrincipal.setLayout(gbl_panelPrincipal);
		
		JPanel panel1 = new JPanel();
		GridBagConstraints gbc_panel1 = new GridBagConstraints();
		gbc_panel1.insets = new Insets(0, 0, 5, 0);
		gbc_panel1.fill = GridBagConstraints.BOTH;
		gbc_panel1.gridx = 0;
		gbc_panel1.gridy = 0;
		panelPrincipal.add(panel1, gbc_panel1);
		panel1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel2 = new JPanel();
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.insets = new Insets(0, 0, 5, 0);
		gbc_panel2.fill = GridBagConstraints.BOTH;
		gbc_panel2.gridx = 1;
		gbc_panel2.gridy = 0;
		panelPrincipal.add(panel2, gbc_panel2);
		panel2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel3 = new JPanel();
		GridBagConstraints gbc_panel3 = new GridBagConstraints();
		gbc_panel3.fill = GridBagConstraints.BOTH;
		gbc_panel3.gridx = 2;
		gbc_panel3.gridy = 0;
		panelPrincipal.add(panel3, gbc_panel3);
		panel3.setLayout(new GridLayout(1, 0, 0, 0));
	}

}
