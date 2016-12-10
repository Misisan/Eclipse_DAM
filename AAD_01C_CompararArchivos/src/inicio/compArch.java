package inicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JEditorPane;

public class compArch extends JFrame {
/*Al no estar especificada la forma de introducir los archivos, la actividad se ha planteada de la siguiente manera:
 * - para la 1a parte hay ya creados dos archivos que son los que se comparan (fichero01.txt y fichero02.txt)
 * - para la 2a parte hay ya creado un archivo que es en el que se busca (ficheroBuscar.txt)
 * - El CONSTRUCTOR tiene todo el entorno gráfico y los Listener
 * - Las funciones de buscar y comparar están tienen MÉTODOS propios 
 */
	//Definición de variables
	private JPanel contentPane;
	private JLabel txtNom;
	private JLabel txtTitulo;
	private JTextArea txtInfo;
	private JButton btnComp;
	private JButton btnBuscar;
	private JCheckBox checkAparicion;
	private File f1;
	private File f2;
	private File f3;
	private boolean primeraApar;
	private JTextField txtPalabra;
	private JLabel txtInfo1;
	private JLabel txtInfo2;

//LANZAMIENTO DE APP
	public static void main(String[] args) {
		compArch frame = new compArch();
		frame.setVisible(true);
	}

//CONSTRUCTOR
	public compArch() {
		setTitle("ACTIVIDAD 1C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Textos interfaz
		txtNom = new JLabel("Miguel \u00C1ngel Sime\u00F3n Sansebasti\u00E1n");
		txtNom.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNom.setBounds(211, 11, 213, 14);
		contentPane.add(txtNom);
		
		txtTitulo = new JLabel("Acceso a Datos | ACTIVIDAD 1C");
		txtTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		txtTitulo.setBounds(10, 11, 213, 14);
		contentPane.add(txtTitulo);
		
		txtInfo = new JTextArea();
		txtInfo.setEditable(false);
		txtInfo.setBounds(10, 171, 414, 50);
		contentPane.add(txtInfo);
		
		
		
		//Botones interfaz
		btnComp = new JButton("COMPARAR");		
		btnComp.setBounds(10, 80, 192, 80);
		contentPane.add(btnComp);
		btnComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean comparar=comparar(f1, f2);
					if(comparar){
						txtInfo.setText("Los dos archivos comparados son iguales");
					}else{
						txtInfo.setText("Los dos archivos comparados son diferentes");
					}
				} catch (IOException e) {
					txtInfo.setText("Ha ocurrido un error al comparar los ficheros.");
				}
			}
		});
		
		btnBuscar = new JButton("BUSCAR");		
		btnBuscar.setBounds(232, 137, 192, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Primero comprobamos si hay algo escrito en la casilla de busqueda
				 if(txtPalabra.getText().length()>0){
					 
					 //Si no hay nada ya empezamos con el Listener
					 try {
						int resBusqueda = buscar(f3, txtPalabra.getText(), primeraApar);
						if(resBusqueda==-1){
							txtInfo.setText("No se han encontrado resultados para tu búsqueda");
						}else{
							txtInfo.setText("Se ha encontrado tu búsqueda en la línea "+resBusqueda);
						}
					} catch (IOException e1) {
						txtInfo.setText("Ha ocurrido un error al buscar la palabra.");
					}
					
				 }else{
					 txtInfo.setText("Debes introducir una palabra a buscar.");
				 }
			}
		});
		
		//Checkbox para activar o no la 1a aparición
		checkAparicion = new JCheckBox("Primera aparici\u00F3n");
		checkAparicion.setSelected(true);
		primeraApar=true;
		checkAparicion.setBounds(232, 107, 196, 23);
		contentPane.add(checkAparicion);
		checkAparicion.addItemListener(new ItemListener(){
			 @Override
			 public void itemStateChanged(ItemEvent e){
				 if(e.getStateChange()==ItemEvent.SELECTED){
					  primeraApar=true;
				  }else{
					  primeraApar=false;
				  }
			}
		});
		
		//JTextField para la palabra a buscar
		txtPalabra = new JTextField();
		txtPalabra.setBounds(232, 80, 192, 20);
		contentPane.add(txtPalabra);
		txtPalabra.setColumns(10);
		
		txtInfo1 = new JLabel("Comparar archivos");
		txtInfo1.setHorizontalAlignment(SwingConstants.CENTER);
		txtInfo1.setBounds(10, 55, 192, 14);
		contentPane.add(txtInfo1);
		
		txtInfo2 = new JLabel("Buscar palabra en archivo");
		txtInfo2.setHorizontalAlignment(SwingConstants.CENTER);
		txtInfo2.setBounds(232, 55, 192, 14);
		contentPane.add(txtInfo2);
		
		//Archivos precargados
		f1 = new File("fichero01.txt");
		f2 = new File("fichero02.txt");
		f3 = new File("ficheroBuscar.txt");
				
	}

	
//MÉTODOS
	public boolean comparar (File f1, File f2) throws IOException{
		
		//Definimos las dos variables locales que vamos a utilizar
		String lin1=null;
		String lin2=null;
		
		//Comprobamos que existen los ficheros
		if(!f1.exists()){
			System.out.println("error f1 no existe");
			throw new IOException();			
		}
		if(!f2.exists()){
			System.out.println("error f2 no existe");
			throw new IOException();			
		}
		
		//Comprobamos si podemos leerlos		
		if(!f1.canRead()){
			throw new IOException("No se puede leer el archivo "+f1.getName());
		}
		
		if(!f2.canRead()){
			throw new IOException("No se puede leer el archivo "+f2.getName());
		}
		//Creamos los BufferedReader de cada archivo para recorrerlos linea por linea de forma más eficiente
		BufferedReader bf1 = new BufferedReader(new FileReader(f1));
		BufferedReader bf2 = new BufferedReader(new FileReader(f2));
		
		//Recorremos las lineas de los archivos
		while((lin1=bf1.readLine())!=null && (lin2=bf2.readLine())!=null){
			//Realizamos la comparación linea por linea hasta que encuentre una diferente
			if(!lin1.equals(lin2)){
				//Si la encuentra cerramos los Bufferedreader y salimos del método con un false
				bf1.close();
				bf2.close();
				return false;
			}
		}
		
		//Si no encuentra una linea diferente cerramos los BufferedReader y salimos con un true
		bf1.close();
		bf2.close();
		return true;
				
	}
	
	public int buscar (File f1, String palabra, boolean primera_aparicion) throws IOException{
				
		//Definimos las dos variables locales que vamos a utilizar
		String lin1=null;
		int cont=1;
		int posicion=-1;
		
		//Comprobamos que existe el ficheros
		if(!f1.exists()){
			System.out.println("error el archivo donde buscar no existe");
			throw new IOException();			
		}
		
		//Comprobamos que podemos leer el fichero
		//Esta comprobación no sería necesaria ya que la carpeta en la que están los archivos es la
		//de los recursos del propio proyecto java
		/*if(!f1.canRead()){
			throw new IOException("No se puede leer el archivo "+f1.getName());
		}*/
		
		//Creamos el BufferedReader del archivo para recorrerlo linea por linea de forma más eficiente
		BufferedReader bf1 = new BufferedReader(new FileReader(f1));
		
		//Recorremos las lineas del archivo para que aparezca el primer resultado
		while((lin1=bf1.readLine())!=null && primera_aparicion==true){
			//Realizamos la comparación de cada linea con la palabra para encontrar la que coincida
			if(lin1.matches(palabra+".*") ){
				//Si la encuentra cerramos los Bufferedreader y salimos del método con el num de linea que ha aparecido
				bf1.close();
				return cont;
			}
			cont=cont+1;
		}
		
		//Recorrdemos las lineas del archivo para que aparezca el último resultado
		while((lin1=bf1.readLine())!=null && primera_aparicion==false){
			//Realizamos la comparación de cada linea con la palabra para encontrar la que coincida
			if(lin1.matches(palabra+".*") ){
				//Nos guardamos la posición en la que aparece cada coincidencia
				posicion=cont+1;
			}
			cont=cont+1;
		}
		
		//Si no encuentra la palabra o está desactivada la primera aparición
		//cerramos el BufferedReader y salimos
		//Recordar que como POSICION está inicializada como -1 nos sirve para ambos casos
		bf1.close();
		return posicion;	
	}
}
