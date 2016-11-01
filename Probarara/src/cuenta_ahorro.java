import java.util.Calendar;

public class cuenta_ahorro extends cuenta
{
   private String num_tarjetacredito;
    //Constructor
    
    public cuenta_ahorro(String num_cuenta, String titular, double saldo, Calendar fecha_apertura, String tcredit)
    {
        super(num_cuenta, titular, saldo, fecha_apertura, 2);//el 2 es el valor que le paso por el interés
        this.num_tarjetacredito = tcredit;
    }

    //Getters y Setters
    
    public void set_num_tarjetacredito(String t){
        this.num_tarjetacredito=t;
    }
    
    public String get_num_tarjetacredito(){
        return this.num_tarjetacredito;
    }
}