package Ventanas;
import Jugador.Jugador;
import Modelo.usuarioBBDD;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Registro extends JFrame {// Indicamos que VentanaPlayer hereda los atributos de JFrame
	
//DEFINICIÓN DE OBJETOS**********************************************************************************DEFINICIÓN OBJETOS
	
	private JPanel Panel;
	private JLabel etiqNombre;
	private JTextField textNombre;
	private JLabel etiqApellido1;
	private JTextField textApellido1;
	private JLabel etiqApellido2;
	private JTextField textApellido2;
	private JLabel etiqEdad;
	private JTextField textEdad;
	private JTextField textConsola;
	private JButton botonCrear;
	private Jugador player;			//Definición clase Juegador para poder acceder a ella
	private VentanaMenu vMenu;		//Definición de VentanaMenu para crearla y visibilizarla
	private Registro refVenPl;		//Definición para esta ventana, para poder usar la referencia a ella y ocultarla
	private String error = ""; //Variable intorducida para poder mostrar el error de la BBDD en la ventana de registro
	
	//Definimos las class que manejan la BBDD para poder acceder a ellas
	private usuarioBBDD userbbdd;
	
	//Variables para user/pass
	private String user;
	private String pass;
	
//FIN DEFINICIÓN OBJETOS--------------------------------------------------------------------------------DEFINICIÓN OBJETOS
	
//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	
	public Registro() {
		
		//Objeto Player
		player = new Jugador();
		
		//Objeto Ventana de Menú
		vMenu = new VentanaMenu();
		
		//Referencias
		refVenPl=this;	//Enlazo el constructor con VentanaPlayer a través de su referencia
				
		//Nos conectamos a la base de datos a través de userBBDD
		userbbdd = new usuarioBBDD();
		
		//Propiedades de la ventana Jframe
		setTitle("MATH DICE - Crea a tu jugador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 244);
		Panel = new JPanel();
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		Panel.setLayout(null);
		
		// Etiqueta NOMBRE
		etiqNombre = new JLabel("NOMBRE:");
		etiqNombre.setBounds(10, 11, 69, 14);
		Panel.add(etiqNombre);
		
		//Texto NOMBRE
		textNombre = new JTextField();
		textNombre.setBounds(104, 8, 320, 20);
		Panel.add(textNombre);
		textNombre.setColumns(10);
		
		//Etiqueta 1er APELLIDO
		etiqApellido1 = new JLabel("1er APELLIDO:");
		etiqApellido1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		etiqApellido1.setBounds(10, 39, 79, 14);
		Panel.add(etiqApellido1);
		
		//Texto 1er APELLIDO
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(104, 36, 320, 20);
		Panel.add(textApellido1);
		
		//Etiqueta 2o APELLIDO
		etiqApellido2 = new JLabel("2o APELLIDO:");
		etiqApellido2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		etiqApellido2.setBounds(10, 64, 69, 14);
		Panel.add(etiqApellido2);
		
		//Texto 2o APELLIDO
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(104, 61, 320, 20);
		Panel.add(textApellido2);
		
		//Etiqueta EDAD
		etiqEdad = new JLabel("EDAD:");
		etiqEdad.setBounds(10, 89, 69, 14);
		Panel.add(etiqEdad);
		
		//Texto EDAD
		textEdad = new JTextField();
		textEdad.setColumns(2);
		textEdad.setBounds(104, 86, 35, 20);
		Panel.add(textEdad);
		
		//Texto CONSOLA
		textConsola = new JTextField();
		textConsola.setEditable(false);
		textConsola.setHorizontalAlignment(SwingConstants.CENTER);
		textConsola.setBounds(10, 148, 414, 49);
		Panel.add(textConsola);
		textConsola.setColumns(10);
		textConsola.setText(error);
		

		//Botón CREAR JUGADOR
		botonCrear = new JButton("CREAR JUGADOR");
		botonCrear.setBounds(10, 114, 414, 23);
		Panel.add(botonCrear);
		botonCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.setNombre(textNombre.getText());
				player.setApellido1(textApellido1.getText());
				player.setApellido2(textApellido2.getText());
				
				if(textEdad.getText().length()==0){
					player.setEdad(-1);
				}else{
					player.setEdad(Integer.valueOf(textEdad.getText()));
				}
				
				//Si la conexión existe hago la comprobación de los datos
				//Si la conexión no eciste accedo directamente con solo el nombre
				if(userbbdd.isConexion_ok()){
					
					//Comprobación de que estén todos los datos
					if(player.getFlag()==false){
						//Envío a VentanaMenu el objeto player de class Jugador
						//y ahí ya se reenviará a su destino final ( VentanaJuego y VentanaPerfil )
						vMenu.setJugador(player);
						
						userbbdd.insertUsuario(player, user, pass);
						
						vMenu.setVisible(true);		//Hago visible la VentanaMenu
						refVenPl.setVisible(false);	//Hago invisible pero no cierro esta ventana por si la necesito en un futuro
					}else{
						//Sino están todos saca un error
						textConsola.setText(player.getContestacion());
						player.setFlag(false);
					}		
				}else{
					//Si no hay conexión pasar solo con el nombre
					System.out.println("Juego sin conexión a BBDD");
					vMenu.setJugador(player);
					vMenu.setVisible(true);		//Hago visible la VentanaMenu
					refVenPl.setVisible(false);	//Hago invisible pero no cierro esta ventana por si la necesito en un futuro
				}
								
			}
		});
		
		//Mensaje texto
		if(userbbdd.isConexion_ok()){
			textConsola.setText("Bienvenido/a!");
		}else{
			textConsola.setText("Acceso offline. Tus datos no se guardarán.");	
			botonCrear.setText("JUGAR");
		}
		
		//Ocultar elementos sin conexión
		etiqApellido1.setVisible(userbbdd.isConexion_ok());
		textApellido1.setVisible(userbbdd.isConexion_ok());
		etiqApellido2.setVisible(userbbdd.isConexion_ok());
		textApellido2.setVisible(userbbdd.isConexion_ok());
		etiqEdad.setVisible(userbbdd.isConexion_ok());
		textEdad.setVisible(userbbdd.isConexion_ok());
					
	}
	
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR

	public void setUserPass(String user, String pass){
		this.user = user;
		this.pass = pass;
	}
	
}