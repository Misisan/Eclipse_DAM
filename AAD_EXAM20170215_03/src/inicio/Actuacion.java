package inicio;

public class Actuacion {
	
	private int id;
	private String hora;
	private String escenario;
	private Grupo grupo;
	
	public Actuacion(){}
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getEscenario() {
		return escenario;
	}
	public void setEscenario(String escenario) {
		this.escenario = escenario;
	}
	
	public void setGrupo(Grupo g){
		this.grupo=g;
	}
	
	public Grupo getGrupo(){
		return grupo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}