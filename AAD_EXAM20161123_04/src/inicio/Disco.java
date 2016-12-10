package inicio;
public class Disco {

	private String titulo;
	private String grupo;
	private String nacionalidad;
	private String lider;
	private int anyo;

	public Disco(String t, String g, String n, String l, int a) {
		titulo = t;
		grupo = g;
		nacionalidad = n;
		lider = l;
		anyo = a;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public void print() {
		System.out.println("Título: " + getTitulo() + ", del grupo "
				+ getGrupo() + " (" + getNacionalidad() + "), con lider "
				+ getLider() + " y anyo " + getAnyo());
	}

}
