package Ventanas;
import Jugador.Jugador;
import Modelo.usuarioBBDD;

import java.util.Random;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;

public class VentanaJuego extends JPanel {
	
//DEFINICIÓN DE OBJETOS**********************************************************************************DEFINICIÓN OBJETOS
	
	//Carteles informativos
	private JLabel infoJug;
	private JLabel puntuacion;
	private JLabel labelPuntos;
	private JLabel tablero;
	private JLabel cartel;
	private JLabel cartelPuntos;
	private JLabel cartel2;
	
	//Objeto clase Jugador
	private Jugador p1;
	
	//Dados
	private ImageIcon[] dado03 = new ImageIcon[3];
	private ImageIcon[] dado06 = new ImageIcon[6];
	private ImageIcon[] dado12 = new ImageIcon[12];
	private JLabel labelDado03_01;
	private JLabel labelDado03_02;
	private JLabel labelDado03_03;
	private JLabel labelDado06_01;
	private JLabel labelDado06_02;
	private JLabel labelDado12;
	
	//Tirada
	private Random tirada = new Random();
	
	//Botones
	private JButton sumar;
	private JButton restar;
	private JTextField operaciones;
	private JButton mathdice;
	private JButton repetir;
	
	//BBDD
	private usuarioBBDD userbd;
	
	//Ventana perfil
	private VentanaPerfil vPerfil;
	private VentanaCambio vCambio;
	
//FIN DEFINICIÓN OBJETOS---------------------------------------------------------------------------------DEFINICIÓN OBJETOS
	
//DECLARACIÓN DE VARIABLES********************************************************************************VARIABLES
	
	private String sumatorio_texto="";	//Texto que aparece en el JTextField OPERACIONES
	private int sumatorio=0;			//Sumatorio interno de las operaciones realizadas
	private boolean edit_num=true;		//Posibilidad de introducir números
	private boolean edit_sign=false;	//Posibilidad de introducir signos + y -
	private boolean operacion=true;		//Operación matemática: suma(true)/resta(false)
	private int puntos;					//Variable donde se acumulan los puntos durante la partida
	
//FIN DECLARACIÓN VARIABLES-------------------------------------------------------------------------------VARIABLES	
	
//CONSTRUCTOR*******************************************************************************************CONSTRUCTOR
	
	public VentanaJuego() {

		//JPanel
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		//JLabel INFORMACIÓN DEL JUGADOR
		infoJug = new JLabel();
		infoJug.setFont(new Font("Tahoma", Font.PLAIN, 14));
		infoJug.setHorizontalAlignment(SwingConstants.CENTER);
		infoJug.setBounds(349, 11, 325, 46);
		add(infoJug);
		
		//JLabel PUNTOS
		puntuacion = new JLabel();
		puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		puntuacion.setFont(new Font("Tahoma", Font.BOLD, 25));
		puntuacion.setBounds(349, 57, 325, 33);
		add(puntuacion);
		
		//JLabel texto PUNTUACIÓN
		labelPuntos = new JLabel("puntos acumulados");
		labelPuntos.setVerticalAlignment(SwingConstants.TOP);
		labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		labelPuntos.setBounds(349, 90, 325, 21);
		add(labelPuntos);
		
		//JLabel IMAGEN DEL TABLERO
		tablero = new JLabel();
		ImageIcon tituloImagen = new ImageIcon(getClass().getResource("/img/mathdice.jpg"));
		tablero.setIcon(tituloImagen);
		tablero.setBounds(0, 0, 350, 121);
		add(tablero);
		
		
		//INICIALIZACIÓN DE ARRAYS		
		for(int i=0;i<dado03.length;i++){
			dado03[i]= new ImageIcon(getClass().getResource("/img/dado03_"+(i+1)+".png"));
		}
		
		for(int i=0;i<dado06.length;i++){
			dado06[i]= new ImageIcon(getClass().getResource("/img/dado06_"+(i+1)+".png"));
		}
		
		for(int i=0;i<dado12.length;i++){
			dado12[i]= new ImageIcon(getClass().getResource("/img/dado12_"+(i+1)+".png"));
		}
			
		//DADOS
		
		labelDado03_01 = new JLabel("");
		labelDado03_01.setBounds(39, 153, 80, 80);
		labelDado03_01.setIcon(dado03[tirada.nextInt(3)]);
		add(labelDado03_01);
		
		labelDado03_02 = new JLabel("");
		labelDado03_02.setBounds(139, 153, 80, 80);
		labelDado03_02.setIcon(dado03[tirada.nextInt(3)]);
		add(labelDado03_02);
				
		labelDado03_03 = new JLabel("");
		labelDado03_03.setBounds(239, 153, 80, 80);
		labelDado03_03.setIcon(dado03[tirada.nextInt(3)]);
		add(labelDado03_03);
				
		labelDado06_01 = new JLabel("");
		labelDado06_01.setBounds(39, 239, 80, 80);
		labelDado06_01.setIcon(dado06[tirada.nextInt(6)]);
		add(labelDado06_01);
				
		labelDado06_02 = new JLabel("");
		labelDado06_02.setBounds(139, 239, 80, 80);
		labelDado06_02.setIcon(dado06[tirada.nextInt(6)]);
		add(labelDado06_02);
			
		labelDado12 = new JLabel("");
		labelDado12.setBounds(39, 325, 80, 80);
		//contentPane.add(labelDado12);
		labelDado12.setIcon(dado12[tirada.nextInt(12)]);
		add(labelDado12);
		
		//BOTÓN SUMAR +
		sumar = new JButton("+");
		sumar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sumar.setBounds(359, 132, 70, 33);
		add(sumar);
		
		//BOTÓN RESTAR -
		restar = new JButton("-");
		restar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		restar.setBounds(604, 132, 70, 33);
		add(restar);
			
		//JTEXTAREA TEXTO ENTRE BOTONES
		JTextArea texto_botones = new JTextArea();
		texto_botones.setBackground(Color.WHITE);
		texto_botones.setEditable(false);
		texto_botones.setFont(new Font("Tahoma", Font.PLAIN, 10));
		texto_botones.setText("Suma con el bot\u00F3n \"+\"\r\nResta con el bot\u00F3n  \"-\"");
		texto_botones.setBounds(462, 132, 107, 33);
		add(texto_botones);
		
		//JTEXTFIELD DE OPERACIONES
		operaciones = new JTextField();
		operaciones.setForeground(Color.BLACK);
		operaciones.setBackground(Color.WHITE);
		operaciones.setEditable(false);
		operaciones.setHorizontalAlignment(SwingConstants.CENTER);
		operaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		operaciones.setBounds(359, 176, 315, 33);
		operaciones.setColumns(10);
		add(operaciones);
		
		//BOTÓN MATHDICE
		mathdice = new JButton("MathDice");
		mathdice.setBounds(359, 220, 157, 23);
		mathdice.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/btn_mathdice.jpg")));
		add(mathdice);
		
		//BOTÓN VOLVER A INTENTAR
		repetir = new JButton("Volver a probar");
		repetir.setBounds(517, 220, 157, 23);
		add(repetir);
		
		//JLABEL CARTEL DE RESPUESTA AL JUGADOR
		cartel = new JLabel("");
		cartel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cartel.setHorizontalAlignment(SwingConstants.CENTER);
		cartel.setBounds(359, 254, 315, 80);
		add(cartel);
		
		//JLABEL CARTEL DE RESPUESTA DE PUNTOS
		cartelPuntos = new JLabel("");
		cartelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		cartelPuntos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cartelPuntos.setBounds(359, 345, 315, 35);
		add(cartelPuntos);
		
		//JLABEL CARTEL DE INFO VOLVER A JUGAR
		cartel2 = new JLabel("Para volver a jugar haz click en \"Volver a probar\"");
		cartel2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cartel2.setHorizontalAlignment(SwingConstants.CENTER);
		cartel2.setBounds(359, 376, 315, 29);
		cartel2.setVisible(false);
		add(cartel2);
		
		//LISTENERS DE LOS BOTONES
		labelDado03_01.addMouseListener(new botonDado03());
		labelDado03_02.addMouseListener(new botonDado03());
		labelDado03_03.addMouseListener(new botonDado03());
		labelDado06_01.addMouseListener(new botonDado06());
		labelDado06_02.addMouseListener(new botonDado06());
		
		//Listener SUMAR
		sumar.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if(edit_sign==true){
					sumatorio_texto = sumatorio_texto+"+";
					operaciones.setText(sumatorio_texto);
					operacion=true;
					edit_sign=false;
					edit_num=true;
				}
			}
		});
		
		//Listener RESTAR
		restar.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if(edit_sign==true){
					sumatorio_texto = sumatorio_texto+"-";
					operaciones.setText(sumatorio_texto);
					operacion=false;
					edit_sign=false;
					edit_num=true;
				}
			}
		});
		userbd = new usuarioBBDD();
		//Listener MATHDICE
		mathdice.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				if(edit_sign==true && operaciones.getText().length()>2){
					for(int i=0;i<dado12.length;i++){
						if(dado12[i]==labelDado12.getIcon()){					
							if((i+1)==sumatorio){
								cartel.setText("Perfecto");
								cartelPuntos.setText("Has ganado "+String.valueOf(puntos)+" puntos");
								
								//Primero actualizamos el objeto Jugador p1
								p1.setPuntos(p1.getPuntos()+puntos);
								
								//Después pasamos el objeto a la función que conectará y actualizará la BBDD								
								userbd.actPuntos(p1);
								
								//Actualizamos la info de los puntos de ventana Perfil
								vPerfil.setPuntos(p1.getPuntos());							
								
							}else{
								cartel.setText("Has fallado, "+sumatorio+" no es igual a "+(i+1));
							}
						}
						//break;
					}
					edit_sign=false;//Este evita poner el "+" y el "-" después de MathDice y antes de Repetir juego
					cartel2.setVisible(true);
				}
			}
		});
		
		//Listener REPETIR
		repetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repetir();
			}		
		});
		
	}	
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR
	
//MÉTODOS**********************************************************************************************************MÉTODOS

	//Método que recibe el objeto Jugador y la ventana Perfil creada en la ventana Menú
	public void setJugador(Jugador p1, VentanaPerfil vPerfil, VentanaCambio vCambio) {
		this.p1=p1;
		infoJug.setText("Bienvenido/a al juego "+p1.getNombre());
		puntuacion.setText(String.valueOf(p1.getPuntos()));
		
		this.vPerfil=vPerfil;
		this.vCambio=vCambio;
	}
	
	//Método para recibir la actualización del nombre de la ventana Perfil si se modifica
	public void setNombre(String nombre){
		p1.setNombre(nombre);
		infoJug.setText("Bienvenido/a al juego "+nombre);
	}
	
	//Método para machacar a Jugador
	public void setJugador(Jugador player){
		this.p1=player;
		infoJug.setText("Bienvenido/a al juego "+p1.getNombre());
		puntuacion.setText(String.valueOf(p1.getPuntos()));
		
		repetir();
		
	}
	
	private void repetir(){
		//Reinicio el sumatorio, dejo en blanco el JTextField de las operaciones y oculto el cartel de info
		sumatorio_texto="";
		sumatorio=0;
		operaciones.setText(sumatorio_texto);
		cartel.setText("");
		cartel2.setVisible(false);
		cartelPuntos.setText("");
		puntos=0;
		
		//Reinicio datos BBDD
		userbd.buscarUsuario(p1);
		puntuacion.setText(String.valueOf(p1.getPuntos()));
		infoJug.setText("Bienvenido/a al juego "+p1.getNombre());
		
		//Reinicio insertar datos
		edit_num=true;
		edit_sign=false;
		operacion=true;
		
		//Reinicio las tiradas
		labelDado03_01.setIcon(dado03[tirada.nextInt(3)]);
		labelDado03_02.setIcon(dado03[tirada.nextInt(3)]);
		labelDado03_03.setIcon(dado03[tirada.nextInt(3)]);
		labelDado06_01.setIcon(dado06[tirada.nextInt(6)]);
		labelDado06_02.setIcon(dado06[tirada.nextInt(6)]);
		labelDado12.setIcon(dado12[tirada.nextInt(12)]);
		
		//Reinicio los Listeners
		labelDado03_01.addMouseListener(new botonDado03());
		labelDado03_02.addMouseListener(new botonDado03());
		labelDado03_03.addMouseListener(new botonDado03());
		labelDado06_01.addMouseListener(new botonDado06());
		labelDado06_02.addMouseListener(new botonDado06());
							
	}
	
//FIN MÉTODOS------------------------------------------------------------------------------------------------------MÉTODOS
	
//INNER CLASS**************************************************************************************************INNER CLASS
	
	//Inner class para los dados de 3 números
	private class botonDado03 implements MouseListener{
		
			public void mouseClicked(MouseEvent e) {
				
				JLabel botonRefDado03 = (JLabel)e.getSource();
				if(edit_num==true){
					for(int i=0;i<dado03.length;i++){
						if(dado03[i]==botonRefDado03.getIcon()){
							sumatorio_texto = sumatorio_texto+String.valueOf((i+1));
							operaciones.setText(sumatorio_texto);
							if(operacion==true){
								sumatorio = sumatorio+(i+1);
							}else{
								sumatorio = sumatorio-(i+1);
							}
							//Añadimos los puntos de la jugada
							puntos=puntos+5;
	
						}
						//break;
					}
					botonRefDado03.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dado_selec.png")));
					edit_num=false;
					edit_sign=true;
					botonRefDado03.removeMouseListener(this);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}		
	}
	
	//Inner class para los dados de 6 números
	private class botonDado06 implements MouseListener{
		
		public void mouseClicked(MouseEvent e) {
			
			JLabel botonRefDado06 = (JLabel)e.getSource();
			if(edit_num==true){
				for(int i=0;i<dado06.length;i++){
					if(dado06[i]==botonRefDado06.getIcon()){
						sumatorio_texto = sumatorio_texto+String.valueOf((i+1));
						operaciones.setText(sumatorio_texto);
						if(operacion==true){
							sumatorio = sumatorio+(i+1);
						}else{
							sumatorio = sumatorio-(i+1);
						}
						//Añadimos los puntos de la jugada
						puntos=puntos+5;
					}
					//break;
				}
				botonRefDado06.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dado_selec.png")));
				edit_num=false;
				edit_sign=true;
				botonRefDado06.removeMouseListener(this);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}	
}

	
}