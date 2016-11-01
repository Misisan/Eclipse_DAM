package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import Jugador.Jugador;

public class usuarioBBDD {

//DEFINICI�N DE OBJETOS**********************************************************************************DEFINICI�N OBJETOS
	
	//Conexion con BBDD
	private Connection conexion;
	private Statement orden = null;	

	private boolean conexion_ok;
	
//FIN DEFINICI�N OBJETOS--------------------------------------------------------------------------------DEFINICI�N OBJETOS	
	
//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR

	//Recibimos la conexi�n de conexionBBDD a trav�s del objeto de la class Registro
	public usuarioBBDD() {
		
		//Enlazamos nuestra CONEXION con la que hemos recibido a trav�s del constructor
		//this.conexion=conexBBDDviaRegistro;
		conexion = conexionBBDD.getConexion();
		if(conexion != null){
			System.out.println("Conexi�n con la base de datos establecida.");
			conexion_ok = true;
		}else{
			System.out.println("Ha habido alg�n problema con la conexi�n.");
			conexion_ok = false;			
		}
		
	}
	
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR
	
//M�TODOS**********************************************************************************************************M�TODOS
	
	//M�todo para insertar usuarios en la BBDD y despu�s utilizarlo en el juego
	public void insertUsuario(Jugador player){
		
		//Primero insertamos los datos del jugador en la BBDD
		try {			
			orden = conexion.createStatement();
			String comandoSQL = "insert into usuarios (nombre, apellido1, apellido2, edad, puntos) values ('"+player.getNombre()+"', '"+player.getApellido1()+"', '"+player.getApellido2()+"', "+player.getEdad()+", 0)";
			
			orden.executeUpdate(comandoSQL);
			
		} catch (SQLException e) {	//Error en la consulta
			e.printStackTrace();
		} catch (Exception e2) {	//Cualquier otro error
			e2.printStackTrace();
		}
		
		//Despu�s los recuperamos para poder obtener la ID del jugador creado
		ResultSet resultado;
		try{
			orden = conexion.createStatement();
			String comandoSQL = "select * from usuarios order by id desc limit 1";
			resultado=orden.executeQuery(comandoSQL);
						
			//Recorremos el resultado obtenido (por el limit 1 s� que solo es uno).
			//Rescatamos todos los datos de la BBDD porque as� si ha habido alg�n fallo
			//se reflejar� autom�ticamente en la VentanaPerfil al mostrat toda la info.
			while(resultado.next()){
				player.setId(resultado.getInt("Id"));
				player.setNombre(resultado.getString("nombre"));
				player.setApellido1(resultado.getString("apellido1"));
				player.setApellido2(resultado.getString("apellido2"));
				player.setEdad(resultado.getInt("edad"));
				player.setPuntos(resultado.getInt("puntos"));
			}
			
		} catch (SQLException e) {	//Error en la consulta
			e.printStackTrace();
		} catch (Exception e2) {	//Cualquier otro error
			e2.printStackTrace();
		}
	}
	
	//M�todo para rellenar el JComboBox con los usuarios de la BBDD
	public void setUsuariosJCombo(JComboBox combo){
		
		//Variable donde almacenaremos el resultado de la consulta SQL
		ResultSet resultado;
		
		try {
			
			orden = conexion.createStatement();
			String comandoSQL = "select id, nombre, apellido1, apellido2, edad, puntos from usuarios";
			resultado=orden.executeQuery(comandoSQL);
			
			//Recorremos los resultados obtenidos
			while(resultado.next()){
				
				//A�adimos cada fila obtenida en un objeto Jugador
				Jugador player = new Jugador();
				player.setId(resultado.getInt("Id"));
				player.setNombre(resultado.getString("nombre"));
				player.setApellido1(resultado.getString("apellido1"));
				player.setApellido2(resultado.getString("apellido2"));
				player.setEdad(resultado.getInt("edad"));
				player.setPuntos(resultado.getInt("puntos"));
				
				//A�adimos el objeto creado como un �tem del JComboBox
				combo.addItem(player);
			}
			
		} catch (SQLException e) {	//Error en la consulta
			e.printStackTrace();
		} catch (Exception e2) {	//Cualquier otro error
			e2.printStackTrace();
		}
	}
	
	//Buscar usuario en la BBDD
	public Jugador buscarUsuario(Jugador player){
		
		ResultSet resultado;
		
		try{
			orden = conexion.createStatement();
			String comandoSQL = "select nombre, apellido1, apellido2, edad, puntos from usuarios where id="+player.getId();
			resultado=orden.executeQuery(comandoSQL);
			
			while(resultado.next()){
				player.setNombre(resultado.getString("nombre"));
				player.setApellido1(resultado.getString("apellido1"));
				player.setApellido2(resultado.getString("apellido2"));
				player.setEdad(resultado.getInt("edad"));
				player.setPuntos(resultado.getInt("puntos"));
			}
			 	
			return player;
			
		}catch(SQLException se){
			      //Se produce un error con la consulta
			      se.printStackTrace();
			      return player;
		}catch(Exception e){
			      //Se produce cualquier otro error
			      e.printStackTrace();
			      return player;
		}
	}
	
	//M�todo para actualizar los puntos en la BBDD
	public void actPuntos(Jugador player){
		
		try {			
			orden = conexion.createStatement();
			String comandoActSQL = "update usuarios set puntos = ? where id = "+player.getId();
			
			//Montamos el comando SQL a partir del objeto Jugador recibido
			 PreparedStatement prepararSQL = conexion.prepareStatement(comandoActSQL);
			 	prepararSQL.setInt(1, player.getPuntos());
			
		 	//Ejecutamos el comando SQL
		 	prepararSQL.executeUpdate();
		 				
		} catch (SQLException e) {	//Error en la consulta
			e.printStackTrace();
		} catch (Exception e2) {	//Cualquier otro error
			e2.printStackTrace();
		} 
		
	}
	
	//M�todo para actualizar los datos del Jugador
	public String actJugador(Jugador player){
		
		try {			
			orden = conexion.createStatement();
			String comandoActSQL = "update usuarios set nombre = ?, apellido1 = ?, apellido2 = ?, edad = ? where id = "+player.getId();
			
			//Montamos el comando SQL a partir del objeto Jugador recibido
			 PreparedStatement prepararSQL = conexion.prepareStatement(comandoActSQL);
			 	prepararSQL.setString(1, player.getNombre());
			 	prepararSQL.setString(2, player.getApellido1());
			 	prepararSQL.setString(3, player.getApellido2());
			 	prepararSQL.setInt(4, player.getEdad());
			 	
		 	//Ejecutamos el comando SQL
		 	prepararSQL.executeUpdate();
		 	return "Actualizaci�n de datos realizada con �xito.";
			
		} catch (SQLException e) {	//Error en la consulta
			e.printStackTrace();
			return "Ha ocurrido un error inesperado en la consulta. Datos no guardados.";
		} catch (Exception e2) {	//Cualquier otro error
			e2.printStackTrace();
			return "Ha ocurrido un error inesperado. Datos no guardados.";
		} 
		
	}
	
	//Bandera de conexi�n correcta true o false
	public boolean isConexion_ok() {
		return conexion_ok;
	}
	
//FIN M�TODOS------------------------------------------------------------------------------------------------------M�TODOS
}