

/**
* <h1>Principal</h1>
* Lanzazdera de nuestra aplicacion de prueba
* 
*
* @author  Paco G�mez
* @version 1.0
* @since   2016-04-11 
* @see <a href="">Java. Layout Managers</a>
*/
public class Principal {

	public static void main(String[] args) {
		VentanaPrincipal frame = new VentanaPrincipal();
		frame.setVisible(true);	
		//Comprobacion el controlador creado
		Controlador c=Controlador.getControlador();
		System.out.println(c);
	}

}