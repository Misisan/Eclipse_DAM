package inicio;

public class aad_exam04 {

	public static void main(String[] args) {
		
		Parser parser = new Parser();
		parser.parseFicheroXML("discos.xml");
		parser.parseDocument();
		
		parser.print();
	}

}
