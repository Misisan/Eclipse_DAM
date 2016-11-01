package inicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class inicio {

	public static void main(String[] args){
		
		/*Recordar que al introducir el nombre de los archivos
		 * la ruta por defecto es la raíz del proyecto
		 */
		
		
		//Declaramos las variables y las inicializamos
		File f1=null;
		File f2=null;
		int orden=0;
		BufferedReader bfi = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader bfo = new BufferedReader(new InputStreamReader(System.in));
		
		//Realizamos la toma de datos del usuario
		try {
			//Capturamos el nombre del archivo origen y creamos un file para pasarle al método
			System.out.println("Nombre del archivo de origen: \n");
			f1 = new File(bfi.readLine());
			
			//Capturamos el nombre del archivo destino y creamos otro file para pasarle al método
			System.out.println("Nombre del archivo de destino: \n");
			f2 = new File(bff.readLine());
			
			//Capturamos el orden y si no es el correcto por defecto lo ponemos en 0
			System.out.println("Presione 0 para orden natural o 1 para orden inverso: \n");
			orden=Integer.valueOf(bfo.readLine());
			if(orden<0 || orden>1){
				System.out.println("El orden elegido no es correcto, por defecto se realizará natural");
				orden=0;
			}
			
		} catch (IOException e1) {
			System.out.println("Error en la toma de datos");
		}finally{//Cerramos todos los Buffered en el finally para asegurarnos que sí o sí se cierren
			try {
				bfi.close();
				bff.close();
				bfo.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar los Buffered");
			}
		}
		
		//Iniciamos el método con el control de errores
		try {
			inicio(f1, f2, orden);
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println("Error IO");
		}
			
	}

	private static void inicio(File f1, File f2, int orden) throws FileNotFoundException, IOException {
		
		//Las excepciones las controlamos con los throws
		
		//Definimos las variables
		String lineaLeida;
		BufferedReader bf1 = new BufferedReader(new FileReader(f1)); 
		PrintWriter pf2 = new PrintWriter(new FileWriter(f2));
		ArrayList<String> lista = new ArrayList<String>();
		
		//Recorremos el archivo origen linea a linea y dividimos esas lineas por espacios
		//para guardar cada resultado dentro de un ArrayList
		while((lineaLeida=bf1.readLine())!=null){
			//pf2.println(lineaLeida);
			//Recordar que el split se hace en cada espacio, si queremos que tenga en cuenta los signos
			//de puntuación habria que añadirlos dentro de los corchetes(p.e. .split("[ .,;:]+");)
			String[] lineaSep = lineaLeida.split("[ ]+");
			for(int i=0; i<lineaSep.length; i++){
				lista.add(lineaSep[i]);
			}
		}
		
		//Con el int de orden decidimos como ordenar el ArrayList
		if(orden==1){
			//Ordenamos de forma inversa
			Comparator<String> comparador = Collections.reverseOrder();
			Collections.sort(lista, comparador);
		}else{
			//Ordenamos de formal normal alfabéticamente
			Collections.sort(lista);
		}
		
		//Una vez definido el orden recorremos el ArrayList y guardamos cada resultado en el archivo de salida
		Iterator<String> iteratorLista = lista.iterator();
		int posicion = 1;
		while (iteratorLista.hasNext()) {
			pf2.println(iteratorLista.next());
			posicion++;
		}
		
		//Cerramos los Buffered y Printed y terminamos
		System.out.println("Proceso completado con éxito");
		bf1.close();
		pf2.close();
		
	}

}
