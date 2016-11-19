package inicio;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class add_01f {

	//Inicio de la aplicación
	public static void main(String[] args) {
		
		try {
			
			System.out.println("Vamos a duplicar un archivo de forma normal, girándolo 90º o con efecto espejo.");
			abrirFichero();
			System.out.println("Proceso terminado con éxito.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Método para realizar la copia por bytes.
	public static void copiaBytes(FileInputStream in, FileOutputStream out) throws IOException {
		
		System.out.println("Se van a copiar: "+in.available()+" bytes"+"\n");
		
		//Definimos el buffer con el tamaño de los bytes del archivo de entrada
		byte[] Buffer = new byte[in.available()];
		
		//Leemos los bytes del Buffer de entrada y los escribimos en el de salida
		in.read(Buffer);
		out.write(Buffer);
		
	}
	
	public static void giro(FileInputStream in, FileOutputStream out) throws IOException {
		
		
	}
	
	public static void espejo(FileInputStream in, FileOutputStream out) throws IOException {
		
	
		
	}
	
	//Método para abrir un fichero y definir el nombre de los archivos
	public static void abrirFichero() throws FileNotFoundException, IOException {
		
		//Definimos las variables a utilizar
		FileInputStream in = null;
		FileOutputStream out = null;
		File nombre_fileIn=null;
		File nombre_fileOut=null;
		//BufferedReader buffer_nombreIn = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader buffer_nombreOut = new BufferedReader(new InputStreamReader(System.in));
				
		//Capturamos el nombre del archivo origen
		System.out.println("Nombre del archivo de origen: \n");
		nombre_fileIn = new File(new BufferedReader(new InputStreamReader(System.in)).readLine());
		//Comprobamos que existe, y si no entramos en el while para conseguir un nombre que sí exista
		while(!nombre_fileIn.exists()){
			System.out.println("El archivo que ha introdudo no existe."+"\n"+"Por favor, vuelva a intentarlo:"+"\n");
			nombre_fileIn = new File(new BufferedReader(new InputStreamReader(System.in)).readLine());
		}
		//Una vez comprobado la existencia del archivo creamos el FileInputStream
		in = new FileInputStream(nombre_fileIn);
		
		//Capturamos el nombre del archivo destino
		System.out.println("Nombre del archivo de destino: \n");
		nombre_fileOut = new File(new BufferedReader(new InputStreamReader(System.in)).readLine());
		while(nombre_fileOut.exists()){
			System.out.println("El archivo que ha introdudo ya existe."+"\n"+"Por favor, introduzca un nombre que no exista:"+"\n");
			nombre_fileOut = new File(new BufferedReader(new InputStreamReader(System.in)).readLine());
		}
		out= new FileOutputStream(nombre_fileOut);
		
		//Llamamos al método para elegir tipo de copia
		menuRotacion(in, out);
		
		//Cerramos todo
		cerrar(in);
		cerrar(out);
	}
			
	public static void menuRotacion(FileInputStream in, FileOutputStream out) throws IOException{
		
		//Capturamos el nombre del archivo origen
		System.out.println("Dime que opción quieres: "+"\n"+
							"1: Duplicado normal."+"\n"+
							"2: Duplicar con giro de 90º."+"\n"+
							"3: Duplicar con efecto espejo (simetria vertical).");
		String tecla = new BufferedReader(new InputStreamReader(System.in)).readLine();
		 switch (tecla){
		 case "2":
			 System.out.println("Has elegido la opción de duplicado normal.");
			 giro(in, out);
			 break;
		 case "3":
			 System.out.println("Has elegido la opción de duplicado normal.");
			 espejo(in, out);
			 break; 
		 default:
			 System.out.println("Has elegido la opción de duplicado normal.");
			 copiaBytes(in, out);	 
		 }
		
	}
	
	//Método para cerrar
	public static void cerrar(Closeable a) {
		try {
			a.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
