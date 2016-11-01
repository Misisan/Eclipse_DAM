package Inicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login extends JFrame {
	//VERSIÓN
	/**
	 * Miguel Ángel Simeón Sansebastián
	 * TPV v1
	 * 28/06/2016
	 */
	private static final long serialVersionUID = 1L;
	//VERSIÓN - FINAL
	
	//DEFINICIONES
	private JPanel JPanel_base;
	private JPanel JPanel_sup;
	private JPanel JPanel_login;
	
	private JButton btn_ESP;
	private JButton btn_VAL;
	private JButton btn_ENG;
	private JLabel lblTexto;
	
	
	//DEFINICIONES - FINAL
	
	//CONSTRUCTOR
	public Login() {
		setTitle("TPV v1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 400, 300);
		
		//JPanel de Base
		JPanel_base = new JPanel();
		JPanel_base.setBackground(Color.RED);
		JPanel_base.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JPanel_base);
		GridBagLayout gbl_JPanel_base = new GridBagLayout();
		JPanel_base.setLayout(gbl_JPanel_base);
		
		//JPanel superior
		JPanel_sup = new JPanel();
		JPanel_sup.setBackground(Color.WHITE);
		GridBagConstraints gbc_JPanel_sup = new GridBagConstraints();
		gbc_JPanel_sup.weightx = 0.85;
		gbc_JPanel_sup.weighty = 0.03;
		gbc_JPanel_sup.insets = new Insets(0, 0, 5, 0);
		gbc_JPanel_sup.fill = GridBagConstraints.BOTH;
		gbc_JPanel_sup.gridx = 0;
		gbc_JPanel_sup.gridy = 0;
		JPanel_base.add(JPanel_sup, gbc_JPanel_sup);
		GridBagLayout gbl_JPanel_sup = new GridBagLayout();
		JPanel_sup.setLayout(gbl_JPanel_sup);
		
		//Label texto superior
		lblTexto = new JLabel("TPV v1");
		lblTexto.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblTexto = new GridBagConstraints();
		gbc_lblTexto.anchor = GridBagConstraints.WEST;
		gbc_lblTexto.weightx = 0.91;
		gbc_lblTexto.insets = new Insets(0, 5, 0, 0);
		gbc_lblTexto.gridx = 0;
		gbc_lblTexto.gridy = 0;
		JPanel_sup.add(lblTexto, gbc_lblTexto);
		
		//Botón idioma ESP
		btn_ESP = new JButton("ESP");
		GridBagConstraints gbc_btn_ESP = new GridBagConstraints();
		gbc_btn_ESP.fill = GridBagConstraints.BOTH;
		gbc_btn_ESP.insets = new Insets(0, 5, 0, 0);
		gbc_btn_ESP.weightx = 0.03;
		gbc_btn_ESP.gridx = 1;
		gbc_btn_ESP.gridy = 0;
		JPanel_sup.add(btn_ESP, gbc_btn_ESP);
		
		//Botón idioma CAT-VAL
		btn_VAL = new JButton("VAL");
		GridBagConstraints gbc_btn_VAL = new GridBagConstraints();
		gbc_btn_VAL.fill = GridBagConstraints.BOTH;
		gbc_btn_VAL.weightx = 0.03;
		gbc_btn_VAL.gridx = 2;
		gbc_btn_VAL.gridy = 0;
		JPanel_sup.add(btn_VAL, gbc_btn_VAL);
		
		//Botón idioma ENG
		btn_ENG = new JButton("ENG");
		GridBagConstraints gbc_btn_ENG = new GridBagConstraints();
		gbc_btn_ENG.fill = GridBagConstraints.BOTH;
		gbc_btn_ENG.weightx = 0.03;
		gbc_btn_ENG.gridx = 3;
		gbc_btn_ENG.gridy = 0;
		JPanel_sup.add(btn_ENG, gbc_btn_ENG);
		
		//JPanel inferior - zona login
		JPanel_login = new JPanel();
		JPanel_login.setBackground(Color.WHITE);
		GridBagConstraints gbc_JPanel_login = new GridBagConstraints();
		gbc_JPanel_login.insets = new Insets(50, 0, 0, 0);
		gbc_JPanel_login.weightx = 1.0;
		gbc_JPanel_login.weighty = 0.97;
		gbc_JPanel_login.fill = GridBagConstraints.BOTH;
		gbc_JPanel_login.gridx = 0;
		gbc_JPanel_login.gridy = 1;
		JPanel_base.add(JPanel_login, gbc_JPanel_login);
		
		
		
		//
		
	}
}
