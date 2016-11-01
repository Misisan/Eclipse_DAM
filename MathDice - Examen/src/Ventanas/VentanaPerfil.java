package Ventanas;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Jugador.Jugador;
import Modelo.usuarioBBDD;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import java.awt.Dimension;

public class VentanaPerfil extends JPanel {
	
//DEFINICIÓN DE OBJETOS*********************************************************************************DEFINICIÓN OBJETOS
	
	//Paneles ventana
	private JPanel panel_01;
	private JPanel panel_02;
	private JPanel panel_03;
	private JPanel panel_04;
	private JPanel panel_05;
	
	//JLabel - Datos
	private JLabel labelNombre;
	private JLabel labelApellido1;
	private JLabel labelApellido2;
	private JLabel labelPuntos;
	private JLabel labelEdad;
	
	//RigidArea y su tamaño
	private int w = 0;
	private int h = 10;
	private int h2 = 6;
	private Component rigidArea_1;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private Component rigidArea_4;
	private Component rigidArea_5;
	private Component rigidArea_6;
	private Component rigidArea_7;
	private Component rigidArea_8;
	private Component rigidArea_9;
	private Component rigidArea_10;
	
	//JTextField - Datos
	private JTextField textoNombre;
	private JTextField textoApellido1;
	private JTextField textoApellido2;
	private JTextField textoEdad;
	private JTextField textoPuntos;
	private JTextField mensaje;
	
	//JLabel - Foto
	private JLabel labelFoto;
	private ImageIcon fotoPerfil = new ImageIcon(getClass().getResource("/img/cabeza.png"));
	
	//BBDD
	private usuarioBBDD userbd;
	
	//Jugador
	private Jugador player1;
	
	//Botón Actualizar datos
	private JButton btn_save;
	private JButton btn_mod;
	
	//Ventana Juego
	private VentanaJuego vJuego;
	private VentanaCambio vCambio;

//FIN DEFINICIÓN OBJETOS--------------------------------------------------------------------------------DEFINICIÓN OBJETOS

//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	
	public VentanaPerfil() {
		
		//JPanel principal
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		//JPanel secundario - Panel01 - FOTO
		panel_01 = new JPanel();
		GridBagConstraints gbc_panel_01 = new GridBagConstraints();
		gbc_panel_01.insets = new Insets(0, 0, 5, 5);
		gbc_panel_01.fill = GridBagConstraints.BOTH;
		gbc_panel_01.weighty = 0.8;
		gbc_panel_01.weightx = 0.3;
		gbc_panel_01.gridx = 0;
		gbc_panel_01.gridy = 0;
		add(panel_01, gbc_panel_01);
		panel_01.setLayout(new BoxLayout(panel_01, BoxLayout.Y_AXIS));
		
		//JPanel secundario - Panel02 - ETIQUETAS DATOS
		panel_02 = new JPanel();
		GridBagConstraints gbc_panel_02 = new GridBagConstraints();
		gbc_panel_02.insets = new Insets(0, 0, 5, 5);
		gbc_panel_02.anchor = GridBagConstraints.NORTH;
		gbc_panel_02.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_02.weighty = 0.8;
		gbc_panel_02.weightx = 0.3;
		gbc_panel_02.gridx = 1;
		gbc_panel_02.gridy = 0;
		add(panel_02, gbc_panel_02);
		panel_02.setLayout(new BoxLayout(panel_02, BoxLayout.Y_AXIS));
		
		//JPanel secundario - Panel03 - TEXTO DATOS
		panel_03 = new JPanel();
		GridBagConstraints gbc_panel_03 = new GridBagConstraints();
		gbc_panel_03.insets = new Insets(0, 0, 5, 0);
		gbc_panel_03.anchor = GridBagConstraints.NORTH;
		gbc_panel_03.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_03.weighty = 0.8;
		gbc_panel_03.weightx = 0.4;
		gbc_panel_03.gridx = 2;
		gbc_panel_03.gridy = 0;
		add(panel_03, gbc_panel_03);
		panel_03.setLayout(new BoxLayout(panel_03, BoxLayout.Y_AXIS));
		
		//JPanel secundario - Panel04 - CUADRO MENSAJE
		panel_04 = new JPanel();
		GridBagConstraints gbc_panel_04 = new GridBagConstraints();
		gbc_panel_04.insets = new Insets(0, 0, 5, 0);
		gbc_panel_04.weighty = 0.2;
		gbc_panel_04.weightx = 0.95;
		gbc_panel_04.gridwidth = 2;
		gbc_panel_04.fill = GridBagConstraints.BOTH;
		gbc_panel_04.gridx = 0;
		gbc_panel_04.gridy = 1;
		add(panel_04, gbc_panel_04);
		panel_04.setLayout(new BoxLayout(panel_04, BoxLayout.X_AXIS));
	
		//JPanel secundario - Panel05 - BOTONES
		panel_05 = new JPanel();
		GridBagConstraints gbc_panel_05 = new GridBagConstraints();
		gbc_panel_05.anchor = GridBagConstraints.EAST;
		gbc_panel_05.insets = new Insets(0, 0, 5, 0);
		gbc_panel_05.weighty = 0.2;
		gbc_panel_05.weightx = 0.05;
		gbc_panel_05.gridwidth = 1;
		gbc_panel_05.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_05.gridx = 2;
		gbc_panel_05.gridy = 1;
		add(panel_05, gbc_panel_05);
		panel_05.setLayout(new BoxLayout(panel_05, BoxLayout.Y_AXIS));
		
		
		//ETIQUETAS Y CUADROS DE TEXTO
		
		//JLabel para la foto
		labelFoto = new JLabel();
		labelFoto.setBounds(10, 11, 150, 159);
		panel_01.add(labelFoto);		
		
		rigidArea_1 = Box.createRigidArea(new Dimension(w, h));
		panel_02.add(rigidArea_1);

		//JLabel - NOMBRE
		labelNombre = new JLabel("NOMBRE:");
		labelNombre.setBounds(180, 45, 69, 14);
		panel_02.add(labelNombre);
		
		rigidArea_2 = Box.createRigidArea(new Dimension(w, h));
		panel_02.add(rigidArea_2);
		
		//JLabel - APELLIDO1
		labelApellido1 = new JLabel("1\u00BA APELLIDO:");
		labelApellido1.setBounds(180, 73, 92, 14);
		panel_02.add(labelApellido1);
		
		rigidArea_3 = Box.createRigidArea(new Dimension(w, h));
		panel_02.add(rigidArea_3);
		
		//JLabel - APELLIDO2
		labelApellido2 = new JLabel("2\u00BA APELLIDO:");
		labelApellido2.setBounds(180, 104, 92, 14);
		panel_02.add(labelApellido2);
		
		rigidArea_4 = Box.createRigidArea(new Dimension(w, h));
		panel_02.add(rigidArea_4);
		
		//JLabel - EDAD
		labelEdad = new JLabel("EDAD:");
		labelEdad.setBounds(180, 163, 92, 14);
		panel_02.add(labelEdad);
		
		rigidArea_5 = Box.createRigidArea(new Dimension(w, h));
		panel_02.add(rigidArea_5);
		
		//JLabel - PUNTOS
		labelPuntos = new JLabel("PUNTOS:");
		labelPuntos.setBounds(180, 135, 46, 14);
		panel_02.add(labelPuntos);
		
		rigidArea_6 = Box.createRigidArea(new Dimension(w, h2));
		panel_03.add(rigidArea_6);
		
		//JTextField - NOMBRE
		textoNombre = new JTextField();
		textoNombre.setEditable(false);
		textoNombre.setBounds(282, 42, 168, 20);
		panel_03.add(textoNombre);
		textoNombre.setColumns(10);
		
		rigidArea_7 = Box.createRigidArea(new Dimension(w, h2));
		panel_03.add(rigidArea_7);
		
		//JTextField - APELLIDO1		
		textoApellido1 = new JTextField();
		textoApellido1.setEditable(false);
		textoApellido1.setColumns(10);
		textoApellido1.setBounds(282, 70, 168, 20);
		panel_03.add(textoApellido1);
		
		rigidArea_8 = Box.createRigidArea(new Dimension(w, h2));
		panel_03.add(rigidArea_8);
		
		//JTextField - APELLIDO2		
		textoApellido2 = new JTextField();
		textoApellido2.setEditable(false);
		textoApellido2.setColumns(10);
		textoApellido2.setBounds(282, 101, 168, 20);
		panel_03.add(textoApellido2);
		
		rigidArea_9 = Box.createRigidArea(new Dimension(w, h2));
		panel_03.add(rigidArea_9);
		
		//JTextField - EDAD
		textoEdad = new JTextField();
		textoEdad.setEditable(false);
		textoEdad.setColumns(10);
		textoEdad.setBounds(282, 132, 168, 20);
		panel_03.add(textoEdad);
		
		rigidArea_10 = Box.createRigidArea(new Dimension(w, h2));
		panel_03.add(rigidArea_10);
		
		//JTextField - PUNTOS
		textoPuntos = new JTextField();
		textoPuntos.setEditable(false);
		textoPuntos.setColumns(10);
		textoPuntos.setBounds(282, 160, 168, 20);
		panel_03.add(textoPuntos);
		
		//JTextField - MENSAJE
		mensaje = new JTextField();
		mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		mensaje.setEditable(false);
		panel_04.add(mensaje);
		
		//JButton - MODIFICAR DATOS
		btn_mod = new JButton("MODIFICAR");
		btn_mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Activamos los JTextField de los datos
				textoNombre.setEditable(true);
				textoApellido1.setEditable(true);
				textoApellido2.setEditable(true);
				textoEdad.setEditable(true);
				mensaje.setText("Modificación de datos activada.");
				
				btn_save.setEnabled(true);
				btn_mod.setEnabled(false);
			}
		});
		btn_mod.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_05.add(btn_mod);
		
		//JButton - ACTUALIZAR/GUARDAR DATOS
		btn_save = new JButton("GUARDAR");
		btn_save.setEnabled(false);
		btn_save.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_save.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_save.setBounds(359, 220, 157, 23);
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Actualizamo info del jugadotr
				player1.setNombre(textoNombre.getText());
				player1.setApellido1(textoApellido1.getText());
				player1.setApellido2(textoApellido2.getText());
				player1.setEdad(Integer.valueOf(textoEdad.getText()));
				
				//Actualizamos la info de la ventana Juego
				vJuego.setNombre(player1.getNombre());
				
				//Actualizamos la info BBDD
				String texto = userbd.actJugador(player1);
				mensaje.setText(texto);
				
				//Desactivamos los JTextField de los datos
				textoNombre.setEditable(false);
				textoApellido1.setEditable(false);
				textoApellido2.setEditable(false);
				textoEdad.setEditable(false);
				
				btn_save.setEnabled(false);
				btn_mod.setEnabled(true);
				
			}
		});
		panel_05.add(btn_save);
		
		//Objeto clase Jugador
		player1 = new Jugador();
		
		//Objeto BBDD
		userbd = new usuarioBBDD();
		
		//Sin conexion ocultamos los ítems que no utilizamos
		labelApellido1.setVisible(userbd.isConexion_ok());
		textoApellido1.setVisible(userbd.isConexion_ok());
		labelApellido2.setVisible(userbd.isConexion_ok());
		textoApellido2.setVisible(userbd.isConexion_ok());
		labelEdad.setVisible(userbd.isConexion_ok());
		textoEdad.setVisible(userbd.isConexion_ok());
		rigidArea_3.setVisible(userbd.isConexion_ok());
		btn_mod.setEnabled(userbd.isConexion_ok());
		if(!userbd.isConexion_ok()){
			mensaje.setText("Está en modo off-line, sus datos se perderán al cerrar.");
		}
		
		
	}
	
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR

//MÉTODOS**********************************************************************************************************MÉTODOS

	//Método que recibe el objeto Jugador y la ventana Juego creada en la ventana Menú
	//También colocamos los datos en sus JTextField's
	public void setJugador(Jugador player1, VentanaJuego vJuego, VentanaCambio vCambio) {
		this.player1=player1;
		textoNombre.setText(player1.getNombre());
		textoApellido1.setText(player1.getApellido1());
		textoApellido2.setText(player1.getApellido2());
		textoEdad.setText(String.valueOf(player1.getEdad()));
		textoPuntos.setText(String.valueOf(player1.getPuntos()));
				
		if(player1.getFoto()!= null){
			labelFoto.setIcon(player1.getFoto());
		}else{
			labelFoto.setIcon(fotoPerfil);
		}
		
		this.vJuego=vJuego;
		this.vCambio=vCambio;
	}
	
	//Método para recibir la actualización de la puntuación de la ventana Juego y reflejarla aquí
	public void setPuntos(int puntos){
		player1.setPuntos(puntos);
		textoPuntos.setText(String.valueOf(player1.getPuntos()));
	}
	
	//Método para machacar a Jugador
		public void setJugador(Jugador player){
			this.player1=player;
			
			textoNombre.setText(player1.getNombre());
			textoApellido1.setText(player1.getApellido1());
			textoApellido2.setText(player1.getApellido2());
			textoEdad.setText(String.valueOf(player1.getEdad()));
			textoPuntos.setText(String.valueOf(player1.getPuntos()));
					
			if(player1.getFoto()!= null){
				labelFoto.setIcon(player1.getFoto());
			}else{
				labelFoto.setIcon(fotoPerfil);
			}
			
		}
	
//FIN MÉTODOS**************************************************************************************************FIN MÉTODOS
}