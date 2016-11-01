
// DEFINICIÓN DE LA CLASE CON LA PALABRA "Carta" PQ ES EL NOMBRE DEL FICHERO
// public class NombreClase
public class Carta {
	
	//PROPIEDADES
	private int numero; //Cuando es privada colo se puede acceder desde el propio documento donde está
	private String palo;
	
	//CONSTANTES
	public static final String BASTOS = "Bastos"; // Con "static" y "final" hacemos que la variable sea estática de la clase "Carta" (con esto no hace falta definir el objeto, puede ir directo) y que no se pueda modificar
	public static final String OROS = "Oros";
	public static final String COPAS = "Copas";
	public static final String ESPADAS = "Espadas";
	
	
	//CONTRSUCTOR - único elemento con el mismo nombre que la clase
	//Punto de entrada que se ejecuta al crear un objeto "Carta"
	public Carta() {
		System.out.println("Creo un objeto de tipo carta");
	}

	//MÉTODOS - Forma de acceder externamente a una variable privada
	// public/private SALIDA método (ENTRADA){}, de forma que estamos diciéndole que obtenga un numero Entrada y que no salga nada
	public void setNumero(int numero){ //Método público o variable vacía "void" donde obtendremos un número de entrada 
		if (numero<1){
			this.numero = 1;
		}else if(numero>12){
			this.numero = 12;
		}else{
		this.numero = numero;// Ese número de entrada se asignará a la variable privada número
		//Con "This" hacemos referencia a la duplicidad de nombres el decimos que ese "Palo" del String es el "Palo" de la clase Carta
		}
	}
	
	public int getNumero(){ //En este caso le decimos que queremos un número "int" de salida pero que no entre nada o no pida nada
		return numero;//Le decimos que nos devuelva el valor de la variable "numero"
	}

	public String getPalo() { // Con esta retornamos el valor "Palo" en un String
		return palo;
	}

	public void setPalo(String palo) { // Con esta obtenemos "Palo"
		switch (palo){ //Condicionamos en número de opciones, es un "Según"
		case Carta.OROS:
			this.palo = Carta.OROS;
			break; //Con break rompemos el switch y salimos
		case Carta.BASTOS:
			this.palo = Carta.BASTOS;
			break;
		case Carta.COPAS:
			this.palo = Carta.COPAS;
			break;
		case Carta.ESPADAS:	
			this.palo = Carta.ESPADAS;
			break;
		default: //Opción por defecto por si introducimos cualquier otra cosa
			this.palo = Carta.BASTOS;
			//no utilizamos "break" pq es la última opción
		}
	}
}
