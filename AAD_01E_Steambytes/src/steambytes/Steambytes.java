package steambytes;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Steambytes {

	//Método para realizar la copia por bytes.
	public static void copiaBytes(FileInputStream in, FileOutputStream out) throws IOException {
		
		System.out.println("Se van a copiar: "+in.available()+" bytes"+"\n");
		
		//Definimos el buffer con el tamaño de los bytes del archivo de entrada
		byte[] Buffer = new byte[in.available()];
		
		//Leemos los bytes del Buffer de entrada y los escribimos en el de salida
		in.read(Buffer);
		out.write(Buffer);
		
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
		
		//Llamamos al método que realiza la copia
		copiaBytes(in, out);
		
		//Cerramos todo
		cerrar(in);
		cerrar(out);
	}
	
	//Inicio de la aplicación
	public static void main(String[] args) {
		
		try {
			
			System.out.println("Vamos a duplicar un archivo.");
			abrirFichero();
			System.out.println("Duplicado realizado con éxito");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
