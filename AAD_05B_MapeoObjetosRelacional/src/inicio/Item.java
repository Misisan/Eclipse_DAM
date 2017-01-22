package inicio;

public class Item {
	
	private String nombrei;
	private Integer cantidad;
	
	public Item(String nombre, Integer cantidad) {
		this.nombrei=nombre;
		this.cantidad=cantidad;
	}
	
	public Item(){}

	public String getNombre() {
		return nombrei;
	}

	public void setNombre(String nombre) {
		this.nombrei = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((nombrei == null) ? 0 : nombrei.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (nombrei == null) {
			if (other.nombrei != null)
				return false;
		} else if (!nombrei.equals(other.nombrei))
			return false;
		return true;
	}

	

}
