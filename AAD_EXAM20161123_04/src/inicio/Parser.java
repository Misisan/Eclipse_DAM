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
	private ArrayList<Disco> discos=null;
	
	
	public Parser() {
		discos = new ArrayList<Disco>();
	}
	
	
	public void parseFicheroXML(String f){

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try{
		
			DocumentBuilder builder = factory.newDocumentBuilder();
			dom = builder.parse(f);
			
		}catch (ParserConfigurationException pce){
			pce.printStackTrace();
		}catch (SAXException se){
			se.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	
	public void parseDocument(){
		
		Element eleRaiz = dom.getDocumentElement();
		
		NodeList nodos = eleRaiz.getElementsByTagName("disco");
		
		//Solo entramos en los nodos con datos y subnodos dentro (que no están vacíos)
		if(nodos != null && nodos.getLength()>0){
			
			//Recorremos los diferentes nodos/ítems 
			for(int i=0; i<nodos.getLength(); i++){
				
				//Casteamos el nodo actual a ELEMENT para trabajar con él
				Element el = (Element) nodos.item(i);
				
				try{
					Disco disc = getDisco(el);
					discos.add(disc);
					
				}catch(Exception e){
					System.out.println("Error al generar un disco");
				}
				
			}
		}
	}
	
	
	private Disco getDisco(Element l)throws Exception{
		
		//Rescatamos las variables del elemento y llamamos a los métodos que obtendran sus valores según el caso
		String titulo = getTextValue(l, "titulo");
		String grupo = getTextValue(l, "grupo");
		String nacionalidad = getTextValue(l, "nacionalidad");
		String lider = getTextValue(l, "lider");
		int anyo = getIntValue(l, "anyo");
		
		//Creamos el disco
		Disco superdisc = new Disco(titulo, grupo, nacionalidad, lider, anyo);

		return superdisc;
	}
	
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
	
	private int getIntValue(Element l, String tag){
		return Integer.parseInt(getTextValue(l, tag));		
	}
	
	public void print(){
		Iterator it = discos.iterator();
		while(it.hasNext()){
			Disco disc = (Disco) it.next();
			disc.print();
		}
	}
}
