package inicio;

public class aad_02a {
	
	
	public static void main(String[] args) {
		
		//Creamos el nuevo objeto class Parser
		Parser parser = new Parser();
		
		//Parseamos el Fichero XML para obtener la estructura DOM del archivo origen
		parser.parseFicheroXML("biblioteca.xml");
		
		//Parseamos el documento inticado anteriormente
		parser.parseDocument();
		
		//Imprimimos los datos parseados para ver su correcto funcionamiento
		parser.print();
	}
	
}
