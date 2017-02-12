package inicio;

public class Direccion {

	private String calle;
	private String pob;
	private int cp;
	private int id;
	private Empresa emp;

	public Direccion(){}
	
	public Direccion(String c, String p, int cp) {
		this.calle=c;
		this.pob=p;
		this.cp = cp;
	}
	
	public String getDirección(){
		return calle+", CP: "+String.valueOf(cp)+" ("+pob+")";
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPob() {
		return pob;
	}

	public void setPob(String pob) {
		this.pob = pob;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empresa getEmp() {
		return emp;
	}

	public void setEmp(Empresa emp) {
		this.emp = emp;
	}

}
