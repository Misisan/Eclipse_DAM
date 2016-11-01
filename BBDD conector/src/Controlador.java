
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
* <h1>Controlador</h1>
* Esta clase nos demuestra el uso y 
* <p>
* Aprendemos como:
*  - Usar el JComBoBox
*  - Introducir eventos
*  - Manejar objetos
*
* @author  Paco Gómez
* @version 1.0
* @since   2016-04-19 
* @see <a href="">Java. JComboBox</a>
*/
public class Controlador {
	
	private static Connection connect = null;
	private static Controlador INSTANCE = null;
	private int hora,minutos,segundos,dia;

	private Controlador() {
		
		try {
		      // Cargamos en ejecución 
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://"+"Localhost"+"/"+"mathdice", "usermd", "mathdice");
					System.out.println("Conexion OK con "+"Localhost");
		      //Mensaje de conexion realizada
		      System.out.println("Conexion realizada");
	    } catch (Exception e) {
	        System.out.println(e);
	    } 
		Calendar calendario = new GregorianCalendar();
		dia =calendario.get(Calendar.DAY_OF_MONTH);
		hora =calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
	}
	
	//Este es el método que 
    public static Controlador getControlador() {
        if (INSTANCE == null){
        	INSTANCE = new Controlador();
        }
        return INSTANCE;
    }
    
    //Imprimimos la fecha de creación
    public String toString(){
    	return "DIA: "+dia+" HORA: "+hora+" MINUTOS: "+minutos+" SEGUNDOS: "+segundos;
    }

}