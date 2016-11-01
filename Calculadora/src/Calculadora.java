import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora extends JFrame {

//VARIABLES*************************************************************************VARIABLES
	
	private JPanel contentPane;
	private JButton btn_01;
	private JButton btn_02;
	private JButton btn_03;
	private JButton btn_04;
	private JButton btn_05;
	private JButton btn_06;
	private JButton btn_07;
	private JButton btn_08;
	private JButton btn_09;
	private JButton btn_00;
	private JTextField result;
	private JButton btn_suma;
	private JButton btn_resta;
	private JButton btn_mult;
	private JButton btn_div;
	private JButton btn_igual;
	private JButton btn_c;
	private JButton btn_Ult;
	private Operaciones op; 
	
	//Averiguar como va esto de abajo
	private final static int SUMA=0;
	private final static int RESTA=1;
	private final static int MULTIPLICA=2;
	private final static int DIVIDE=3;
	private int tipoOp=0;
	
//FIN VARIABLES--------------------------------------------------------------------VARIABLES
	
//CONSTRUCTOR********************************************************************CONSTRUCTOR
	public Calculadora() {
		
		//Objeto clase Operaciones
		Operaciones op = new Operaciones();
		
		//Panel
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Botón 1
		btn_01 = new JButton("1");
		btn_01.addActionListener(new miBotonAction());
		btn_01.setBounds(10, 125, 44, 46);
		contentPane.add(btn_01);
		
		//Botón 2
		btn_02 = new JButton("2");
		btn_02.setBounds(64, 125, 44, 46);
		contentPane.add(btn_02);
		btn_02.addActionListener(new miBotonAction());
		
		//Botón 3
		btn_03 = new JButton("3");
		btn_03.setBounds(118, 125, 44, 46);
		contentPane.add(btn_03);
		btn_03.addActionListener(new miBotonAction());
		
		//Botón 4
		btn_04 = new JButton("4");
		btn_04.setBounds(10, 174, 44, 46);
		contentPane.add(btn_04);
		btn_04.addActionListener(new miBotonAction());
		
		//Botón 5
		btn_05 = new JButton("5");
		btn_05.setBounds(64, 174, 44, 46);
		contentPane.add(btn_05);
		btn_05.addActionListener(new miBotonAction());
		
		//Botón 6
		btn_06 = new JButton("6");
		btn_06.setBounds(118, 174, 44, 46);
		contentPane.add(btn_06);
		btn_06.addActionListener(new miBotonAction());
		
		//Botón 7
		btn_07 = new JButton("7");
		btn_07.setBounds(10, 226, 44, 46);
		contentPane.add(btn_07);
		btn_07.addActionListener(new miBotonAction());
		
		//Botón 8
		btn_08 = new JButton("8");
		btn_08.setBounds(64, 226, 44, 46);
		contentPane.add(btn_08);
		btn_08.addActionListener(new miBotonAction());
		
		//Botón 9
		btn_09 = new JButton("9");
		btn_09.setBounds(118, 226, 44, 46);
		contentPane.add(btn_09);
		btn_09.addActionListener(new miBotonAction());
		
		//Botón 00
		btn_00 = new JButton("9");
		btn_00.setBounds(64, 278, 44, 46);
		contentPane.add(btn_00);
		btn_00.addActionListener(new miBotonAction());
		
		//JTextField
		result = new JTextField();
		result.setEditable(false);
		result.setBounds(10, 11, 286, 46);
		contentPane.add(result);
		result.setColumns(10);
		
		//Botón suma
		btn_suma = new JButton("+");
		btn_suma.setBounds(190, 125, 49, 46);
		contentPane.add(btn_suma);
		
		//Botón resta
		btn_resta = new JButton("-");
		btn_resta.setBounds(249, 125, 49, 46);
		contentPane.add(btn_resta);
		
		//Botón multiplicación
		btn_mult = new JButton("X");
		btn_mult.setBounds(190, 174, 49, 46);
		contentPane.add(btn_mult);
		
		//Botón división
		btn_div = new JButton("/");
		btn_div.setBounds(249, 174, 49, 46);
		contentPane.add(btn_div);
		
		//Botón de igual
		btn_igual = new JButton("=");
		btn_igual.setBounds(190, 278, 105, 46);
		contentPane.add(btn_igual);
		
		//Botón C para borrar
		btn_c = new JButton("C");
		btn_c.setBounds(247, 68, 49, 46);
		contentPane.add(btn_c);
		
		//Botón Ult para recuperar el último resultado
		btn_Ult = new JButton("Ult");
		btn_Ult.setBounds(190, 68, 49, 46);
		contentPane.add(btn_Ult);
		
	}
//FIN CONSTRUCTOR---------------------------------------------------------------CONSTRUCTOR
	
	
//MÉTODOS***************************************************************************MÉTODOS
	
//FIN MÉTODOS-----------------------------------------------------------------------MÉTODOS
	
//INNER CLASS*******************************************************************INNER CLASS
	
	//Inner class para el ActionListener personalizado
	private class miBotonAction implements ActionListener{
		//Acción de mi ActionListener
		@Override
		public void actionPerformed(ActionEvent e) {
			//e es el evento que llama al ActionListener
			//Como es un botón me creo un botón de referencia donde guardar temporalmente
			//las características del botón que activa el ActionListener, así p.e. podemos pillar el texto del botón
			//TipoDeElemento nombreElementoReferencia = (TipoDeElemento)e.getSource();
			JButton botonRef = (JButton)e.getSource();
			//Le digo que en result me coloque el texto que pille de result + que pille del texto del botón
			result.setText(result.getText()+(botonRef.getText()));
			
		}
		
	}
	
//FIN INNER CLASS---------------------------------------------------------------INNER CLASS
}
