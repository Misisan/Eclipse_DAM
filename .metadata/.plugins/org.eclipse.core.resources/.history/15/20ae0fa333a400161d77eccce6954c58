package inicio;

import java.io.Serializable;


public class libro implements Serializable {
	
	//Variables
	private String titulo;
	private String autor;
	private int anyoPub;
	private String editor;
	private int numPag;
	
	public libro() {
		
	}
	
	public void crearLibro(String titulo, String autor, int anyoPub, String editor, int numPag){
		this.titulo = titulo;
		this.autor = autor;
		this.anyoPub = anyoPub;
		this.editor = editor;
		this.numPag = numPag;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}
	
	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}

	public void setAutor(String autor) {
		this.autor=autor;
	}

	public int getAnyoPub() {
		return anyoPub;
	}

	public String getEditor() {
		return editor;
	}

	public int getNumPag() {
		return numPag;
	}

	public void print(){
		//System.out.println(toString());
		System.out.println("TIT: "+titulo+"\n"+
							"AUT: "+autor+"\n"+
							"EDIT: "+editor+"\n"+
							"ANY: "+anyoPub+"\n"+
							"PAG: "+numPag+"\n");
	}
	
	public String toString(){
		return titulo+" de "+autor;
	}
}
