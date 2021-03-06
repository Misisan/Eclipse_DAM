package inicio;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private int cif;
	private String nombre;
	private Integer empleados;
	private String direccion;
	private Direccion direc;
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	public Empresa(){}
	
	public Empresa(String nombre, int cif, Integer empleados, String calle, String pob, int cp) {
		this.nombre=nombre;
		this.cif=cif;
		this.empleados=empleados;
		
		this.direc = new Direccion(calle, pob, cp);
		this.direccion=direc.getDirecci�n();
		
	}
		
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public String getNombre(){
		return nombre;
	}

	public Integer getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Integer empleados) {
		this.empleados = empleados;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCif() {
		return cif;
	}

	public void setCif(int cif) {
		this.cif = cif;
	}

	public Direccion getDirec() {
		return direc;
	}

	public void setDirec(Direccion direc) {
		direc.setEmp(this);
		this.direc = direc;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void addPedido(Pedido p){
		p.setEmp(this);
		this.pedidos.add(p);
	}
	
	
	
}
