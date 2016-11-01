import java.util.Calendar;

public abstract class cuenta {

	 //Variables
	 private String cuenta;
	 private String titular;
	 private double saldo;
	 private Calendar fecha_apertura;
	 private double interes; //Sin getters ni setters pq su valor lo da el tipo de cuenta
	
	 //Constructor
	 public cuenta(String cuenta, String titular, double saldo, Calendar fecha, double interes){
	    this.cuenta=cuenta;
	    this.titular=titular;
	    this.saldo=saldo;
	    this.fecha_apertura=fecha;
	    this.interes=interes;
	 }
	 
	    //Método del interés
	    protected double calcula_interes(double cantidad){
	        return cantidad*interes;
	    }
	    
	    //Getters y Seters
	    public void setCuenta(String c){
	        this.cuenta=c;
	    }
	    
	    public String getCuenta(){
	        return this.cuenta;
	    }
	    
	    public void set_titular(String t){
	        this.titular=t;
	    }
	    
	    public String get_titular(){
	        return this.titular;
	    }
	    
	    public void set_saldo(double s){
	        this.saldo=s;
	    }
	    
	    public double get_saldo(){
	        return this.saldo;
	    }
	    
	    public void set_fecha_apertura(Calendar c){
	        this.fecha_apertura=c;
	    }
	    
	    public Calendar get_fecha_apertura(){
	        return this.fecha_apertura;
	    }

}
