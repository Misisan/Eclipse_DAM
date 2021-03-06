package inicio;

import java.util.ArrayList;
import java.util.List;

public class Festival {
	
	private int id;
	private String nombre;
	private String lugar;
	private String fecha;
	private List<Grupo> grupos = new ArrayList<Grupo>();
	
	public Festival(){}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	public List<Grupo> getGrupos() {
		return grupos;
	}
	
	public void addGrupo(Grupo g){
		g.setFestival(this);
		this.grupos.add(g);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}