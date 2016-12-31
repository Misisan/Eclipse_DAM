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
		
		//Compruebo el estado de la conexión de la web a parsear.
		try {
			Response response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
		    } catch (IOException ex) {
		    	System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
	    	}
	  
		//Realizo la conexión con la web guardándola en la variable tipo Document
		try {
		    	htmlFile = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
		    } catch (IOException ex) {
		    	System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
		    }
			
		//Dentro de la web busco los elementos (nodo) según la class que tengan
        Elements entradas = htmlFile.getElementsByClass("tarjeta-articulo__elementos-basicos");
        
        //Dentro de los elementos recorro cada elemento individual obteniendo los datos que necesitamos
        for (Element entrada : entradas){
        	String articulo = entrada.getElementsByTag("h3").text();
        	String precio = entrada.getElementsByClass("tarjeta-articulo__precio-actual").text();
        	
        	System.out.println("Contenido: " + articulo + " | Precio: " + precio);
        }
        
        //Saco por pantalla la cantidad de artículos mostrados
        System.out.println("\n"+"Número de artículos en oferta: "+entradas.size());

	}

}
