package inicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document dom = null;
	private ArrayList<libro> libros = null;
	
	//CONSTRUCTOR
	//Aquí simplemente inicializamos el ArrayList donde almacenaremos los libros que rescatemos del XML
	public Parser() {
		libros = new ArrayList<libro>();
	}
	
	//MÉTODO para obtener la estructura DOM del archivo XML
	public void parseFicheroXML(String f){

		//Creamos la factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try{
			//Creamos el Builder
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			//Parseamos el XML para obtener el DOM
			dom = builder.parse(f);
			
		}catch (ParserConfigurationException pce){
			pce.printStackTrace();
		}catch (SAXException se){
			se.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	//MÉTODO para parsear el documento
	public void parseDocument(){
		
		//Definimos el elemento raíz para el DOM
		Element eleRaiz = dom.getDocumentElement();
		
		//Definimos el que nodo es el que separará cada ítem
		NodeList nodos = eleRaiz.getElementsByTagName("libro");
		
		//Solo entramos en los nodos con datos y subnodos dentro (que no están vacíos)
		if(nodos != null && nodos.getLength()>0){
			
			//Recorremos los diferentes nodos/ítems indicados antes
			//para obtener un objeto LIBRO de cada uno de ellos
			for(int i=0; i<nodos.getLength(); i++){
				
				//Casteamos el nodo actual a ELEMENT para trabajar con él
				Element el = (Element) nodos.item(i);
				
				//Utilizo un Try-Catch para controlar los errores de la creación de dios
				try{
					//Creamos el objeto libro que lo almacenará y llamamos al método que lo rellena
					libro lib = getLibro(el);
					//Con el objeto libro creado e inicializado lo añadimos al ArrayList
					libros.add(lib);
				}catch(Exception e){
					System.out.println("Error al generar un libro");
				}
				
			}
		}
	}
	
	//Inicializamos (obtenemos datos) el objeto LIBRO para poder guardarlo en el ArrayList
	private libro getLibro(Element l)throws Exception{
		
		//Rescatamos las variables del elemento y llamamos a los métodos que obtendran sus valores según el caso
		String titulo = getTextValue(l, "titulo");
		String autor = getTextValueLvl2(l, "nombre");
		String editor = getTextValue(l, "editor");
		int anyoPub = getIntValueAtt(l, "titulo", "anyo");
		int numPag = getIntValue(l, "paginas");
		
		//Creamos el libro
		libro lib = new libro();
		lib.crearLibro(titulo, autor, anyoPub, editor, numPag);
		
		//Y con el objeto LIBRO lleno y encuadernado lo devolvemos para que lo pueda guardar el ArrayList
		return lib;
	}
	
	//Obtenemos el valor de un nodo
	private String getTextValue(Element l, String tag){
		
		//Definimos el String donde guardaremos el valor obtenido
		String txt = null;
		
		//Definimos el nodo con el que trabajaremos según su nombre de etiqueta TAG
		NodeList nodos = l.getElementsByTagName(tag);
		
		//En el caso de que el nodo tenga datos y además dentro del árbol de nodos no sea la raíz (0)
		//Básicamente le decimos que pille los nodos 1 (siendo la raíz 0) pq los de nivel 2 no los pilla
		if(nodos != null && nodos.getLength() > 0){
			
			//Casteamos el nodo a ELEMENT para poder trabajar con él
			Element l2 = (Element) nodos.item(0);
			//Obtenemos su valor y lo guardamos en la variable que retornaremos
			txt = l2.getFirstChild().getNodeValue();
		}
		
		return txt;		
	}
	
	//Obtenemos el valor de un nodo de 2º nivel
	private String getTextValueLvl2(Element l, String tagChild){
		
		//Realmente no obtenemos de 2º nivel, nos olvidamos completamente de la etiqueta "editor"
		//y vamos a por sus hijos que son los que tiene los datos,
		//si hubiera otros ítems con sub-ítems del mismo nombre
		//me ahorco con una soga el viernes para que encuentren mni cuerpo al lunes siguiente
		String txt = null;
		NodeList nodos = l.getElementsByTagName(tagChild);

		if(nodos != null && nodos.getLength() > 0){
			txt=null;
			//Como hay más de un nodo con la información que necesitamos los recorremos todos y vamos concatenando los datos
			for (int i=0; i<nodos.getLength();i++){
				Element l2 = (Element) nodos.item(i);
				//Aquí simplemente diferenciamos el primer nombre del resto, por los espacios a incluir entre ellos
				if(i==0){
					txt = l2.getFirstChild().getNodeValue();
				}else{
					txt = txt+" "+l2.getFirstChild().getNodeValue();
				}
			}
			
		}
		return txt;		
	}
	
	//Aquí obtenemos el valor para el ítem que es un atributo dentro de un nodo
	private int getIntValueAtt(Element l, String tag, String tagAtt){
		String txt = null;
		//Indicamos que nodo es con el que trabajamos
		NodeList nodos = l.getElementsByTagName(tag);
		//Si el nodo tiene datos
		if(nodos != null && nodos.getLength() > 0){
			
			//Lo pcasteamos a un ELEMENT para poder trabajar con él
			Element l2 = (Element) nodos.item(0);
			//obtenemos el valor del atributo por su nombre
			txt = l2.getAttribute(tagAtt);
		}
		
		//Parseo aquí simplemente por no crear otro método para 2 palabras, un punto y 2 paréntesis
		return Integer.parseInt(txt);

	}
	
	//Pasamos el String a Integer
	private int getIntValue(Element l, String tag){
		return Integer.parseInt(getTextValue(l, tag));		
	}
	
	//Para imprimir recorremos el ArrayList con el ITERATOR
	//así nos aseguramos que todo se a guardado correctamente
	public void print(){
		Iterator it = libros.iterator();
		while(it.hasNext()){
			libro lib = (libro) it.next();
			lib.print();
		}
	}

}
