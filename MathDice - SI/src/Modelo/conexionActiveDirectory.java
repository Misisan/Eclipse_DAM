package Modelo;
import java.sql.Connection;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class conexionActiveDirectory {
	
	//Conexion BBDD
	private Connection conexion;

	//CONSTRUCTOR
	public conexionActiveDirectory() {
		
		//Conexion BBDD
		conexion = conexionBBDD.getConexion();
		if(conexion != null){
			System.out.println("AD: Conexión con la base de datos establecida.");
		}else{
			System.out.println("AD: Ha habido algún problema con la conexión.");		
		}
		
	}
	
	//MÉTODOS
	public boolean comprobarAD(String user, String pass){
		//Conexion Active Directory
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.PROVIDER_URL, "ldap://10.2.72.190"); //IP servidor
		
		//Rellenamos con el usuario/dominio y password
		env.put(Context.SECURITY_PRINCIPAL, user+"@siwin2012mas.com"); //user@dominio.com
		env.put(Context.SECURITY_CREDENTIALS, pass); //Password

		DirContext ctx;

		try {
			// Authenticate the login user
			ctx = new InitialDirContext(env);
			System.out.println("AD: El usuario se ha autenticado correctamente");			
			ctx.close();
			return true;

		} catch (NamingException ex) {
			System.out.println("AD: Ha habido un error en la autenticación");
			return false;
		}
	}

}
