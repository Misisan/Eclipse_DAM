package inicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aad_exam01 {

	private File carpetaDeTrabajo = null;
	
	public static void main(String[] args) {
		
		File f1=null;
		File f2=null;
		BufferedReader bf1 = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader bf2 = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.println("Nombre del directorio 1: \n");
			f1 = new File(bf1.readLine());
	
			System.out.println("Nombre del directorio 2: \n");
			f2 = new File(bf2.readLine());
			
			System.out.println(f1.getAbsolutePath());
			System.out.println(f2.getAbsolutePath());
			
			comparar(f1,f2);
			
		} catch (IOException e1) {
			System.out.println("Error en la toma de datos");
		}finally{
			try {
				bf1.close();
				bf2.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar los Buffered");
			}
		}
		
	}
	
	
	public static void comparar (File f1, File f2) throws IOException{
				
		//Comprobamos que existen los ficheros y sus permisos de lectura
		if(!f1.exists()){
			System.out.println("error f1 no existe");
			throw new IOException();			
		}else if(!f1.canRead()){
			throw new IOException("No se puede leer "+f1.getName());
		}
		
		if(!f2.exists()){
			System.out.println("error f2 no existe");
			throw new IOException();			
		}else if(!f2.canRead()){
			throw new IOException("No se puede leer "+f2.getName());
		}
					
		String[] resultado1 = f1.list();
		String[] resultado2 = f2.list();
		
		if(resultado1.length == resultado2.length){
			System.out.println("Los directorios contienen la misma cantidad de elementos, "+resultado1.length+".");
		}else{
			System.out.println("El directorio "+f1.getName()+" tiene "+resultado1.length+" elementos,");
			System.out.println("y el directorio "+f2.getName()+" tiene "+resultado2.length+" elementos, por lo que tienen números diferentes de elementos.");
		}		
	}

}
