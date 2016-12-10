import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Ejercicio2 {

	public static void main(String[] args) {
		
		File f = new File("fichero_prefijos.txt");		
		
		try {
			prefijos("x",f);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void prefijos(String string, File f1) throws IOException {
		
		String lin1=null;
		int encontrado=0;
		
		if(!f1.exists()){
			System.out.println("error el archivo donde buscar no existe");
			throw new IOException();			
		}
		
		BufferedReader bf1 = new BufferedReader(new FileReader(f1));
						
		while((lin1=bf1.readLine())!=null){
			
			if(lin1.matches(string+".*") ){
				encontrado++;
				System.out.println(lin1);
			}
		}
		
		bf1.close();
		
		if(encontrado==0){
			System.out.println("No se ha encontrado ninguna coincidencia");
		}
		
	}

}
