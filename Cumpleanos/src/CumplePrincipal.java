import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CumplePrincipal extends JFrame {

	//DEFINICIONES
	private JPanel contentPane;
	private JLabel etiquetaNombre;
	private JTextField textoNombre;
	private JLabel etiquetaEdad;
	private JTextField textoEdad;
	private JLabel etiquetaDia;
	private JTextField textoDia;
	private JLabel etiquetaMes;
	private JTextField textoMes;
	private JLabel etiquetaAno;
	private JTextField textoAno;
	private JLabel etiquetaNac;
	private JButton botonGuardar;
	private JScrollPane scrollPane;
	private JTextArea textoMostrar;
	private Cumple cumplepersona;
	
	// CONSTRUCTOR
	
	public CumplePrincipal () {
		setTitle("Cumplea\u00F1os");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Etiqueta NOMBRE
		etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setBounds(10, 11, 414, 14);
		contentPane.add(etiquetaNombre);
		
		// Texto NOMBRE
		textoNombre = new JTextField("Nombre");
		textoNombre.setText("Nombre");
		textoNombre.setBounds(10, 27, 414, 20);
		contentPane.add(textoNombre);
		textoNombre.setColumns(10);
		
		// Etiqueta EDAD
		etiquetaEdad = new JLabel("Edad");
		etiquetaEdad.setBounds(10, 55, 46, 20);
		contentPane.add(etiquetaEdad);
		
		// Texto EDAD
		textoEdad = new JTextField();
		textoEdad.setBounds(44, 55, 23, 20);
		contentPane.add(textoEdad);
		textoEdad.setColumns(10);
		
		// Etiqueta DIA
		etiquetaDia = new JLabel("D\u00EDa");
		etiquetaDia.setBounds(207, 55, 46, 20);
		contentPane.add(etiquetaDia);
		
		// Texto DIA
		textoDia = new JTextField();
		textoDia.setColumns(10);
		textoDia.setBounds(241, 55, 23, 20);
		contentPane.add(textoDia);
		
		// Etiqueta MES
		etiquetaMes = new JLabel("Mes");
		etiquetaMes.setBounds(277, 55, 46, 20);
		contentPane.add(etiquetaMes);
		
		// Texto MES
		textoMes = new JTextField();
		textoMes.setColumns(10);
		textoMes.setBounds(311, 55, 23, 20);
		contentPane.add(textoMes);
		
		// Etiqueta AÑO
		etiquetaAno = new JLabel("Ano");
		etiquetaAno.setBounds(344, 55, 46, 20);
		contentPane.add(etiquetaAno);
		
		// Texto AÑO
		textoAno = new JTextField();
		textoAno.setColumns(10);
		textoAno.setBounds(378, 55, 46, 20);
		contentPane.add(textoAno);
		
		// Etiqueta Fechad e nacimiento
		etiquetaNac = new JLabel("Fecha de nacimiento:");
		etiquetaNac.setBounds(77, 58, 129, 14);
		contentPane.add(etiquetaNac);
		
		// Botón GUARDAR
		botonGuardar = new JButton("GUARDAR");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cumplepersona.setNombre(textoNombre.getText());
				int edad = Integer.valueOf(textoEdad.getText());
				cumplepersona.setEdad(edad);
				int ano = Integer.valueOf(textoAno.getText());
				cumplepersona.setAno(ano);
				int mes = Integer.valueOf(textoMes.getText());
				cumplepersona.setMes(mes);
				int dia = Integer.valueOf(textoDia.getText());
				cumplepersona.setDia(dia);
				
				System.out.println(cumplepersona.getNombre()+" tiene "+cumplepersona.getEdad()+" años, y los cumple el día "+cumplepersona.getDia()+" del "+cumplepersona.getMes()+" de "+cumplepersona.getAno()+".");
				textoMostrar.setText(cumplepersona.getNombre()+" tiene "+cumplepersona.getEdad()+" años, y los cumple el día "+cumplepersona.getDia()+".");
				}
		});
		botonGuardar.setBounds(287, 86, 137, 23);
		contentPane.add(botonGuardar);
		
		// Texto a mostrar - Panel de Scroll
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 414, 53);
		contentPane.add(scrollPane);
		
		// Texto a mostrar - Texto
		textoMostrar = new JTextArea();
		textoMostrar.setEditable(false);
		scrollPane.setViewportView(textoMostrar);
		
		// Objeto cumplepersona creado para almacenar datos
		cumplepersona = new Cumple();
		
	}
}
