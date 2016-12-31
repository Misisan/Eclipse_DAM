package inicio;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*** AAD - 02c - Parser de HTML ***/
public class inicio {

	public static void main(String[] args) {
		
		Document htmlFile = null;
		String url = "https://www.pccomponentes.com/ofertas-especiales";
		
		//Compruebo el estado de la conexi�n de la web a parsear.
		try {
			Response response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
		    } catch (IOException ex) {
		    	System.out.println("Excepci�n al obtener el Status Code: " + ex.getMessage());
	    	}
	  
		//Realizo la conexi�n con la web guard�ndola en la variable tipo Document
		try {
		    	htmlFile = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
		    } catch (IOException ex) {
		    	System.out.println("Excepci�n al obtener el HTML de la p�gina" + ex.getMessage());
		    }
			
		//Dentro de la web busco los elementos (nodo) seg�n la class que tengan
        Elements entradas = htmlFile.getElementsByClass("tarjeta-articulo__elementos-basicos");
        
        //Dentro de los elementos recorro cada elemento individual obteniendo los datos que necesitamos
        for (Element entrada : entradas){
        	String articulo = entrada.getElementsByTag("h3").text();
        	String precio = entrada.getElementsByClass("tarjeta-articulo__precio-actual").text();
        	
        	System.out.println("Contenido: " + articulo + " | Precio: " + precio);
        }
        
        //Saco por pantalla la cantidad de art�culos mostrados
        System.out.println("\n"+"N�mero de art�culos en oferta: "+entradas.size());

	}

}
