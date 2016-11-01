import Ventanas.Login;
import Ventanas.ventanaPrincipal;

public class Principal {

	
	//LANZADOR DE APLICACIÓN
	
	public static void main(String[] args) {
		
		//Todas las ventanas a utilizar
		ventanaPrincipal vPrincipal = new ventanaPrincipal();// Lo creamos antes para poder meterle después la referencia
		
		Login login = new Login(vPrincipal); //Así le pasamos la referencia a Login de vPrincipal para poder acceder a ventanaPrincipal
		login.setVisible(true);
		
		
	}
}
