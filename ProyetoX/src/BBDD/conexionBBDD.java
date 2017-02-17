package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBBDD {
	
	// Conector para el driver de la BBDD
	private static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";


	//Variables para los datos de la BBDD
	private String host;
	private String bbdd;
	private String user;
	private String pass;
	private String alias;
	
	//Objeto para poder interactuar con la BBDD
	private static Connection conexion = null;
	private static conexionBBDD INSTANCE = null;

	//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR	
	private conexionBBDD(String host, String bbdd, String user, String pass, String alias){
		//Datos de la BBDD
		this.host = host;
		this.bbdd = bbdd;
		this.user = user;
		this.pass = pass;
		this.alias = alias;
		
		//Conexi�n
		try{
			//Cargar el controlador MYSQL para poder conectar con la BBDD
			Class.forName(CONTROLADOR_MYSQL);
			
			//Conectar a la BBDD
			conexion = DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bbdd, this.user, this.pass);
			if(conexion != null){
				System.out.println("Conexion OK con "+this.alias);
			}
			
		}catch( SQLException excepcionSQL ){ //Cath para la conexi�n a la BBDD
			//Imprimir en pantalla el error
			excepcionSQL.printStackTrace();
		}catch( ClassNotFoundException noEncontroClase){ //Catch para el controlador
			noEncontroClase.printStackTrace();
		}
	}
		
	//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR

	//M�TODOS**********************************************************************************************************M�TODOS

	//M�todo getter para que las otras class puedan utilizar la conexi�n
	public static Connection getConexion(String host, String bbdd, String user, String pass, String alias){
		
		//Condici�n para que si la conexi�n no existe la cree
		//pero si ya fue creada que devuelva el mismo objeto conexion
		if(conexion==null){
			INSTANCE = new conexionBBDD(host, bbdd, user, pass, alias);			
		}
		return conexion;
	}

	public String toString(){
		return alias;
	}	
	//FIN M�TODOS------------------------------------------------------------------------------------------------------M�TODOS

}
