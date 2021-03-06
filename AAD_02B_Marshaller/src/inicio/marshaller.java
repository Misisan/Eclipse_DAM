package inicio;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class marshaller {

	private static Document dom = null;
	private ArrayList<libro> libros = null;
	
	public marshaller(ArrayList<libro> libs) throws Exception{
		libros=libs;
	}
	
	public void crearDocumento() throws Exception{
		//Creamos la factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try{
			
			//Creamos el Builder
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			//Creamos el documento para el DOM
			dom=builder.newDocument();
			
		}catch(ParserConfigurationException pce){
			pce.printStackTrace();
		}
	}
	
	//Creamos la estructura DOM del XML resultante
	public void crearArbolDOM() throws Exception{

		//Creamos un elemento ra�z llamado LIBROS
		Element elementoRa�z = dom.createElement("libros");
		dom.appendChild(elementoRa�z);
		
		Iterator iteratorLibs = libros.iterator();
		//Recorremos con el iteratoe el ArrayList para extraer la informaci�n e insertarla en el XML
		while (iteratorLibs.hasNext()) {
			//Sacamos cada libro que encuentre dentro del ArrayList
			libro lib = (libro) iteratorLibs.next();
			//Lo enviamos al m�todo que procesa la informaci�n y la prepara para el XML
			Element elementoLibro = crearLibro(lib);
			//Introducimos el elemento devuelto a continuaci�n de la ra�z en el �rbol XML
			elementoRa�z.appendChild(elementoLibro);
		}

	}
	
	//Procesamos la informaci�n de cada libro rescatado del ArrayList a DOM/XML
	private Element crearLibro(libro lib) throws Exception {

		//Definimos la etiqueta principal que englobar� a cada LIBRO
		Element elementoLibro = dom.createElement("libro");
		
		//NODO T�TULO-----------------------------------------------------------------------------------------------
		
			//Creamos el elemento TITULO
			Element elementoTitulo = dom.createElement("titulo");
			
			//Creamos el nodo en el DOM que pilla la informaci�n de LIBRO
			Text titulo = dom.createTextNode(lib.getTitulo());
			
			//Metemos la info obtenido dentro del elemento TITULO (pq es un TEXT se a�ade como dato y no como etiqueta hijo)
			elementoTitulo.appendChild(titulo);
			
			//A�adimos el elemento T�tulo como hijo de LIBRO (pq es un elemento)
			elementoLibro.appendChild(elementoTitulo);
		
		//NODO AUTOR-----------------------------------------------------------------------------------------------
			Element elementoAutor = dom.createElement("autor");
			Element elementoAutorNombre = dom.createElement("nombre");
			
			//Dividimos el nombre en partes, y seg�n el n�mero de partes a�adimos 1 nodo o 2
			String[] autorNombres = lib.getAutor().split(" ");
			switch (autorNombres.length) {
			case 2:
				Element elementoAutorNombre2 = dom.createElement("nombre");
				
				Text autor1 = dom.createTextNode(autorNombres[0]);
				Text autor2 = dom.createTextNode(autorNombres[1]);
				elementoAutorNombre.appendChild(autor1);
				elementoAutorNombre2.appendChild(autor2);
				elementoAutor.appendChild(elementoAutorNombre);
				elementoAutor.appendChild(elementoAutorNombre2);
				break;
			default:
				Text autor = dom.createTextNode(lib.getAutor());
				elementoAutorNombre.appendChild(autor);
				elementoAutor.appendChild(elementoAutorNombre);
			}

			elementoLibro.appendChild(elementoAutor);
			
		//NODO EDITOR----------------------------------------------------------------------------------------------
			Element elementoEditor = dom.createElement("editor");
			Text editor = dom.createTextNode(lib.getEditor());
			elementoEditor.appendChild(editor);
			elementoLibro.appendChild(elementoEditor);
			
		//NODO A�O DE PUBLICACI�N (ATRIBUTO)-------------------------------------------------------------------------
			Attr elementoAnyoPub = dom.createAttribute("anyo");
			elementoAnyoPub.setValue(String.valueOf(lib.getAnyoPub()));
			elementoTitulo.setAttributeNode(elementoAnyoPub);
			
		//NODO NUM. DE P�GINAS-------------------------------------------------------------------------------------
			Element elementoNumPags = dom.createElement("edad");
			Text edad = dom.createTextNode(Integer.toString(lib.getNumPag()));
			elementoNumPags.appendChild(edad);
			elementoLibro.appendChild(elementoNumPags);
		
		return elementoLibro;
	}
	
	//M�todo para convertir el objeto DOM a XML
	public static void DOMtoXML(File f) throws TransformerException {
		
		//TRANSFORMER es una clase abstracta para realizar la conversi�n DOM-XML
		
		//Creamos la factory+builder(transformer en este caso) de TRANSFORMER
		Transformer factoryTransform = TransformerFactory.newInstance().newTransformer();
		//Indicamos que el XML creado est� en varias lineas
		factoryTransform.setOutputProperty(OutputKeys.INDENT, "yes");

		// especificamos d�nde escribimos y la fuente de datos
		//Cargamos el fichero resultante donde escribir los datos
		StreamResult destinoFichero = new StreamResult(f);
		//Cargamos el DOM utilizado
		DOMSource origenDOM = new DOMSource(dom);
		//Con los datos de arriba realizamos la conversi�n DOM-XML
		factoryTransform.transform(origenDOM, destinoFichero);

	}
	
}
