package inicio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Pedido {


	private Integer id;
	private Empresa emp;
	private Date fecha;

	
	public Pedido(Date fecha) {
		this.fecha=fecha;
	}
	
	public Pedido(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Empresa getEmp() {
		return emp;
	}

	public void setEmp(Empresa emp) {
		this.emp = emp;
	}
}
