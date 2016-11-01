import java.util.Calendar;

public class cuenta_plazo extends cuenta
{
   private int num_anos;
   
    //Constructor
    public cuenta_plazo(String num_cuenta, String titular, double saldo, Calendar fecha_apertura, int anos)
    {
        super(num_cuenta, titular, saldo, fecha_apertura, 5);//el 5 es el valor que le paso por el interés
        this.num_anos = anos;
    }
    
    //Getters y Setters
    
    public void set_num_anos(int a){
        this.num_anos=a;
    }
    
    public int get_num_anos(){
        return this.num_anos;
    }
}