package inicio;

public class Grupo {
	
	private String nombre;
	private String estilo;
	private int miembros;	
	private Festival festival;
	private Actuacion actuacion;
	private String actu;
	
	public Grupo(){}
	
	public String getActu() {
		return actu;
	}
	public void setActu(String actu) {
		this.actu = actu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public int getMiembros() {
		return miembros;
	}
	public void setMiembros(int miembros) {
		this.miembros = miembros;
	}
	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival fest) {
		this.festival = fest;
	}
	
	public Actuacion getActuacion() {
		return actuacion;
	}

	public void setActuacion(Actuacion act) {
		act.setGrupo(this);
		this.actu=act.getEscenario();
		this.actuacion = act;
	}
}