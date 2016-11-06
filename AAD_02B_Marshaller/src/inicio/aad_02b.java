package inicio;

import java.io.File;
import java.util.ArrayList;

import javax.xml.transform.TransformerException;

public class aad_02b {

	public static void main(String[] args) {

		//Introducimos los datos de los libros a guardar en XML
		ArrayList<libro> libros = new ArrayList<libro>();
		libros.add(new libro("La historia m�s larga jam�s contada", "Paquito Jackson", 2031, "autoedici�n", 5));
		libros.add(new libro("Verdad verdadera de la verdad", "An�nimo", 1974, "Francisco O'Donell", 561));
		try{
		marshaller marshaller = new marshaller(libros);
		//Creamos el DOM y todo su contenido
		marshaller.crearDocumento();
		marshaller.crearArbolDOM();
		}catch (Exception e){
			e.printStackTrace();
		}
		//Creamos el XML donde guardar la informaci�n
		File f = new File("libros.xml");
		
		//Realizamos la conversi�n DOM-XML
		try {
			marshaller.DOMtoXML(f);
			System.out.println("Fichero XML creado con �xito.");
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
