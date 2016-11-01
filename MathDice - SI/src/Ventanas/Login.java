package Ventanas;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Jugador.Jugador;
import Modelo.usuarioBBDD;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login extends JFrame {

//DECLARACIÓN DE VARIABLES***************************************************************************************VARIABLES
	
	//Elementos visibles de la ventana
	private JPanel contentPane;
	private JButton btn_entrar;
	private JButton btn_reg;
	private JComboBox listaUsers;
	private JComboBox listaServidor;
	private JLabel imgCabecera;
	private JLabel labelServ;
	private JLabel labelUser;
	
	//Ventanas con las que trabajamos
	private Login refVenLogin;
	private Registro vReg;
	private VentanaMenu vMenu;
	
	//Objetos para manejar la BBDD
	private usuarioBBDD userbbdd;
	private Jugador usuarioSeleccionado;
	
//FIN DECLARACIÓN VARIABLES--------------------------------------------------------------------------------------VARIABLES
	
//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	
	public Login() {
		
		//Referencias
		refVenLogin=this;
				
		//Creamos el objeto usuario desde donde nos conectamos a la BBDD
		userbbdd = new usuarioBBDD();
				
		//JFrame
		setTitle("MathDice - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 267);
		
		//JPanel - GridBagLayout
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		//JLabel - Imagen cabecera
		imgCabecera = new JLabel("");
		ImageIcon tituloImagen = new ImageIcon(getClass().getResource("/img/mathdice.jpg"));
		imgCabecera.setIcon(tituloImagen);
		GridBagConstraints gbc_imgCabecera = new GridBagConstraints();
		gbc_imgCabecera.gridwidth = 2;
		gbc_imgCabecera.weighty = 0.6;
		gbc_imgCabecera.weightx = 1.0;
		gbc_imgCabecera.insets = new Insets(0, 0, 5, 5);
		gbc_imgCabecera.gridx = 0;
		gbc_imgCabecera.gridy = 0;
		contentPane.add(imgCabecera, gbc_imgCabecera);		
		
		//JLabel usuario
		labelUser = new JLabel("Elige el usuario registrado para jugar:");
		GridBagConstraints gbc_labelUser = new GridBagConstraints();
		gbc_labelUser.anchor = GridBagConstraints.WEST;
		gbc_labelUser .gridwidth = 2;
		gbc_labelUser .weighty = 0.1;
		gbc_labelUser .weightx = 1.0;
		gbc_labelUser .insets = new Insets(0, 0, 5, 5);
		gbc_labelUser .gridx = 0;
		gbc_labelUser .gridy = 3;
		contentPane.add(labelUser, gbc_labelUser );
		
		//JComboBox - Lista de usuarios
		listaUsers = new JComboBox();
		GridBagConstraints gbc_listaUsers = new GridBagConstraints();
		gbc_listaUsers.weightx = 1.0;
		gbc_listaUsers.weighty = 0.1;
		gbc_listaUsers.gridwidth = 2;
		gbc_listaUsers.insets = new Insets(0, 0, 5, 0);
		gbc_listaUsers.fill = GridBagConstraints.HORIZONTAL;
		gbc_listaUsers.gridx = 0;
		gbc_listaUsers.gridy = 4;
		listaUsers.addItem("---- Selecciona un usuario ----");
		contentPane.add(listaUsers, gbc_listaUsers);
		userbbdd.setUsuariosJCombo(listaUsers);
		listaUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//El try-catch es para evitar el error al guardar el usuarioSeleccionado,
				//Ya que el primer item he puesto un String y no un obj Jugador
				try{
				usuarioSeleccionado = (Jugador)listaUsers.getSelectedItem();
				}catch(Exception e){
					System.out.println("No hay seleccionado ningún usuario");
				}
				System.out.println("Usuario seleccionado: "+usuarioSeleccionado);
			}
		});
		//Activa o Desactiva el JComboBox según si la conexion es true o false
		listaUsers.setEnabled(userbbdd.isConexion_ok());
				
		//JButton - ACCEDER
		btn_entrar = new JButton("ACCEDER");
		GridBagConstraints gbc_btn_entrar = new GridBagConstraints();
		gbc_btn_entrar.anchor = GridBagConstraints.EAST;
		gbc_btn_entrar.weightx = 0.5;
		gbc_btn_entrar.weighty = 0.1;
		gbc_btn_entrar.insets = new Insets(0, 0, 0, 5);
		gbc_btn_entrar.gridx = 0;
		gbc_btn_entrar.gridy = 5;
		contentPane.add(btn_entrar, gbc_btn_entrar);
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Nos aseguramos que hay un usuario seleccionado antes de continuar
				if(usuarioSeleccionado != null){
					vMenu = new VentanaMenu();
					vMenu.setJugador(usuarioSeleccionado);	
					vMenu.setVisible(true);			//Hago visible la VentanaMenu
					refVenLogin.setVisible(false);	//Hago invisible esta ventana
				}else{
					System.out.println("No hay seleccionado ningún usuario");
				}					
			}
		});
		//Hace visible o invisible el botón según si la conexión es true o false
		btn_entrar.setVisible(userbbdd.isConexion_ok());
		
		//JButton - REGISTRARSE
		btn_reg = new JButton("REGISTRARSE");
		GridBagConstraints gbc_btn_reg = new GridBagConstraints();
		gbc_btn_reg.anchor = GridBagConstraints.WEST;
		gbc_btn_reg.weighty = 0.1;
		gbc_btn_reg.weightx = 0.5;
		gbc_btn_reg.gridx = 1;
		gbc_btn_reg.gridy = 5;
		contentPane.add(btn_reg, gbc_btn_reg);
		btn_reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vReg = new Registro();
				vReg.setVisible(true);			//Hago visible la Ventana Registro
				refVenLogin.setVisible(false);	//Hago invisible esta ventana
										
			}
		});
		
		//Cambia el texto del botón según la conexión
		if(userbbdd.isConexion_ok()){
			btn_reg.setText("REGISTRARSE");
		}else{
			btn_reg.setText("ACCEDER SIN CONEXIÓN");
		}
						
	}
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR
}