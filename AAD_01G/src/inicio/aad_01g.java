package inicio;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class aad_01g {
	
	private static File fileLista = new File("lista.libros");
	private static ArrayList<libro> libros = new ArrayList();
	private static Scanner lectorTecla = new Scanner(System.in);
	private static int tecla;
	
	public static void main(String[] args) {
		
		//Definici�n e inicializaci�n de variables
		Scanner lectorTecla = new Scanner(System.in);
		tecla=99;
		
		//Si el archivo que utilizamos como lista permanente no est� lo creamos
		if(fileLista.exists()){
			recuperarLista();
		}else{
			try {
				fileLista.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//EXAM----------------------------------------------------------------------------------------------
				ArrayList<String> librosExam = new ArrayList();
				librosExam.add("El_libro_mas_largo_del_mundo_de_Yo.libro");
				librosExam.add("Fito_de_Fitipaldi.libro");
				librosExam.add("Harry_Potter_de_JK_Rowrow.libro");				
		//----------------------------------------------------------------------------------------------------
		
		//Entramos en el men�
		while (tecla!=0){
			System.out.println("\n"+"Vamos a manejar libros!!"
					+ "\n"+"Recuerda escribir la informaci�n sin espacios"+"\n");
			System.out.println("1: Para ver la lista de libros cargada");
			System.out.println("2: Para modificar un libro de la lista");
			System.out.println("3: Para guardar nuevo libro");
			System.out.println("4: Para cargar libro externo");
			System.out.println("5: Para importar lista de libros");
			System.out.println("6: Para exportar lista de lisbros");
			System.out.println("7: Examen");
			System.out.println("0: Para salir");
			
			//Evitamos errores por no itroducir integers
			try{
				tecla=Integer.valueOf(lectorTecla.next());
			}catch(Exception e){
				tecla=99;
			}
			
			//Analizamos la respuesta
			switch(tecla){
				case 0:
					System.out.println("Hasta luego.");
					break;
				case 1:
					verLista();
					break;
				case 2:
					if(libros.size()!=0){
						modificar();
					}else{
						System.out.println("Lista vacia");
					}
					
					break;
				case 3:
					obtenerDatosGuardado();
					break;
				case 4:
					recuperarDatosGuardado();
					break;	
				case 5:
					importarLista();
					break;
				case 6:
					exportarLista();
					break;
				case 7:
					examen(librosExam);
					break;
				default:
					System.out.println("No has seleccionado una opci�n correcta");
			}
		}
		
	}
	
	public static void obtenerDatosGuardado(){
		
		//Definici�n e inicializaci�n de variables
		libro lib = new libro();

				
		//Recogemos los datos para el guardado
		try{
			System.out.println("Has elegido guardar."+"\n"+"Dime los datos del libro:");
			System.out.println("Dime el t�tulo:");
			String titulo = lectorTecla.next();
			System.out.println("Dime el autor:");
			String autor = lectorTecla.next();
			System.out.println("Dime el a�o de publicaci�n:");
			int anyo = lectorTecla.nextInt();
			while(String.valueOf(anyo).length()!=4){
				System.out.println("Introduce un a�o correcto con 4 cifras:");
				anyo = Integer.valueOf(lectorTecla.next());
			}
			System.out.println("Dime el editor:");
			String editor = lectorTecla.next();
			System.out.println("Dime el n�mero de p�ginas:");
			int numPag = lectorTecla.nextInt();
			
			//Rellenamos los datos del objeto LIBRO
			lib.crearLibro(titulo, autor, anyo, editor, numPag);
			lib.print();
			
			//Guardamos el archivo
			guardar(lib, titulo+"_de_"+autor+".libro");
			
			
		}catch (Exception e){
			System.out.println("Has introducido alg�n dato de forma incorrecta.");
		}
		
	}
	
	public static void guardar (libro lib, String f){
		
		//Creamos un objeto ObjectOutputStream para poder guardar en un archivo propio
		//Debemos crearlo fuera del try-catch para poder utilizarlo en el finally
		ObjectOutputStream guardar = null;
		
		try {
			guardar = new ObjectOutputStream (new FileOutputStream(f));
			
			//Guardamos el objeto LIBRO dentro del objeto-archivo propio
			guardar.writeObject(lib);
			
			guardarEnLista(lib);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//Pase lo que pase cerramos el objeto
			cerrarObjeto(guardar);
		}
		
	}
	
	public static void guardarEnLista(libro lib){
		String tecla2;
		
		System.out.println("�Deseas a�adirlo a la lista? (y/n)");
		tecla2=lectorTecla.next();
		switch(tecla2){
			case "y":
				libros.add(lib);
				guardar();
				break;
			default:
				System.out.println("Libro guardado en la lista.");
		}
	}
	
	public static void guardar (){

		ObjectOutputStream guardar = null;
		try {
			guardar = new ObjectOutputStream (new FileOutputStream(fileLista));
			guardar.writeObject(libros);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			cerrarObjeto(guardar);
		}
		
	}
	
	public static void exportarLista (){
		ObjectOutputStream guardar = null;
		System.out.println("Dime un nombre para el archivo:");
		
		File export= new File(lectorTecla.next());
		
		if(!export.exists()){
			try {
				guardar = new ObjectOutputStream (new FileOutputStream(export));
				guardar.writeObject(libros);
			} catch (FileNotFoundException e){} catch (IOException e) {
				e.printStackTrace();
			} finally {
				cerrarObjeto(guardar);
			}
		}else{
			System.out.println("Archivo a exportar no encontrado.");
		}
		
	}
	
	public static void recuperarDatosGuardado(){
		//Definici�n e inicializaci�n de variables
		Scanner lectorTecla = new Scanner(System.in);
		int tecla;
				
		//Recogemos los datos para recuperar
		System.out.println("Has elegido recuperar un libro guardado."+"\n"+"Dime los datos del libro:");
		System.out.println("Dime el t�tulo:");
		String titulo = lectorTecla.next();
		System.out.println("Dime el autor:");
		String autor = lectorTecla.next();
		
		//Recuperamos el libro
		recuperar(titulo+"_de_"+autor+".libro");
	}
	
	public static void recuperar (String f){
		
		//Creamos el objeto LIBRO para almacenar en �l el archivo recuperado
		libro lib = null;
		//Creamos el objeto para poder recuperar/leer del archivo
		ObjectInputStream recuperar = null;
		
		try {
			//Le decimos el archivo de donde recuperarlo
			recuperar = new ObjectInputStream (new FileInputStream(f));
			//Leemos del recuperado y lo guardamos en un objeto LIBRO
			lib = (libro) recuperar.readObject();
			
			System.out.println(lib.getTitulo()+" de "+lib.getAutor()+" recuperado correctamente."+"\n");
			guardarEnLista(lib);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Libro no encontrado para su recuperaci�n"+"\n"+"Asegurate de haber introducido los datos correctamente.");
		}
		
		
		
	}
	
	public static void recuperarLista(){
		
		//Creamos el objeto para poder recuperar/leer del archivo
		ObjectInputStream recuperar = null;
		
		try {
			//Le decimos el archivo de donde recuperarlo
			recuperar = new ObjectInputStream (new FileInputStream(fileLista));
			//Leemos del recuperado y lo guardamos en un objeto LIBRO
			libros = (ArrayList) recuperar.readObject();
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		}
		
	}
	
	public static void importarLista(){
				
		//Recogemos los datos para recuperar
		System.out.println("Has elegido importar una lista externa."+"\n"+"Recuerda que esto sobreescribir� la lista actual."
		+"\n"+"�Estas seguro? (y/n)");
		String tecla2=lectorTecla.next();
		
		switch(tecla2){
			case "y":
				System.out.println("Dime el nombre del fichero (no se admiten espacios):");
				recuperarLista(lectorTecla.next());
				break;
			default:
				System.out.println("Ninguna lista importada.");
		}
		
	}
	
	public static void recuperarLista(String f){
		
		//Creamos el objeto para poder recuperar/leer del archivo
		ObjectInputStream recuperar = null;
		
		try {
			//Le decimos el archivo de donde recuperarlo
			recuperar = new ObjectInputStream (new FileInputStream(f));
			//Leemos del recuperado y lo guardamos en un objeto LIBRO
			libros = (ArrayList) recuperar.readObject();
			guardar();
			System.out.println("Lista recuperada.");
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Lista no recuperada.");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Lista no recuperada.");
		}
		
	}
	
	public static void verLista (){
		int contador = 1;
		if(libros.size()!=0){
			Iterator it = libros.iterator();
			
			while(it.hasNext()){
				libro lib = (libro) it.next();
				System.out.println(contador+": "+lib.toString());
				contador++;
			}
		}else{
			System.out.println("Lista vacia");
		}
	}
	
  	public static void cerrarObjeto (Closeable obj){
		
		//Si el objeto existe se cierra, sino no hace nada
		try {
			if(obj != null){
				obj.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

  	public static void modificar(){
  		verLista();
  		System.out.println("Dime el n�mero del libro a modificar:");
  		try{
  			tecla=lectorTecla.nextInt();
  			Iterator it = libros.iterator();
  			int contador=1;
  			
			while(it.hasNext()){
				libro lib = (libro) it.next();
				
				if(contador==(tecla)){
					System.out.println("Modificar el libro "+lib.getTitulo()+"\n"+"Recuerda que no se pueden poner espacios.");
					System.out.println("Dime el nuevo t�tulo:");
					lib.setTitulo(lectorTecla.next());
					System.out.println("Dime el nuevo autor:");
					lib.setAutor(lectorTecla.next());
					System.out.println("El libro modificado resultante es:");
					lib.print();
					System.out.println("\n");
				}
				contador++;
			}
  			
  		}catch(Exception e){}
  		
  	}
  	
public static void examen(ArrayList<String> lib){
  		
  		int contador = 1;
  		
		if(lib.size()!=0){
			
			for(int i=0; i<lib.size(); i++) {
				 
				libro libEx = null;
				ObjectInputStream recuperar = null;
				
				try {
					
					recuperar = new ObjectInputStream (new FileInputStream(lib.get(i)));
					libEx = (libro) recuperar.readObject();
					System.out.println("Libro num "+(i+1)+": "+libEx.getAnyoPub());	
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				
				}
		}
		
		
		
		/*
		
		
		
		//Creamos el objeto LIBRO para almacenar en �l el archivo recuperado
				libro lib = null;
				//Creamos el objeto para poder recuperar/leer del archivo
				ObjectInputStream recuperar = null;
				
				try {
					//Le decimos el archivo de donde recuperarlo
					recuperar = new ObjectInputStream (new FileInputStream(f));
					//Leemos del recuperado y lo guardamos en un objeto LIBRO
					lib = (libro) recuperar.readObject();
					
					System.out.println(lib.getTitulo()+" de "+lib.getAutor()+" recuperado correctamente."+"\n");
					guardarEnLista(lib);
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("Libro no encontrado para su recuperaci�n"+"\n"+"Asegurate de haber introducido los datos correctamente.");
				}
		
		*/
  	}
}
