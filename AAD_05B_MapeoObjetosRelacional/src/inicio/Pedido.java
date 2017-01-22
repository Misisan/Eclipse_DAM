package inicio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Pedido {


	private Integer id;
	private Date fecha;
	private List<Item> item;
	
	public Pedido(Date fecha) {
		this.fecha=fecha;
		item = new ArrayList<Item>();
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
	
	public void setItem(List<Item> item){
		this.item=item;
	}
	
	public List<Item> getItem(){
		return item;
	}

}
