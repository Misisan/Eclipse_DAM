import Ventanas.Login;
import Ventanas.ventanaPrincipal;

public class Principal {

	
	//LANZADOR DE APLICACI�N
	
	public static void main(String[] args) {
		
		//Todas las ventanas a utilizar
		ventanaPrincipal vPrincipal = new ventanaPrincipal();// Lo creamos antes para poder meterle despu�s la referencia
		
		Login login = new Login(vPrincipal); //As� le pasamos la referencia a Login de vPrincipal para poder acceder a ventanaPrincipal
		login.setVisible(true);
		
		
	}
}
