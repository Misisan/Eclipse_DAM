package inicio;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class act_1e {

	
	
	
	
	public static void main(String[] args) {

		//Definición de variables
		FileInputStream file_in = null;
		FileOutputStream file_out= null;
		DataOutputStream formato = null;
		
		//Inicialización de variables
		
		try {
			file_in = new FileInputStream("entrada");
			file_out = new FileOutputStream("salida");
			formato = new DataOutputStream(file_out);
			byte[] Buffer = new byte[1000];
			
			//Leemos los bytes del Buffer de entrada y los escribimos en el de salida
			file_in.read(Buffer);
			file_out.write(Buffer);
			//formato.write(55);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//Cerramos con un métodopara evitar que si salta una excepción en el primer close deje si cerrar el segundo
			cerrar(file_in);
			cerrar(file_out);
			//cerrar(formato);
		}
		
	}

	public static void cerrar(Closeable a) {
		try {
			a.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
