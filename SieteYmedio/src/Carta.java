
// DEFINICI�N DE LA CLASE CON LA PALABRA "Carta" PQ ES EL NOMBRE DEL FICHERO
// public class NombreClase
public class Carta {
	
	//PROPIEDADES
	private int numero; //Cuando es privada colo se puede acceder desde el propio documento donde est�
	private String palo;
	
	//CONSTANTES
	public static final String BASTOS = "Bastos"; // Con "static" y "final" hacemos que la variable sea est�tica de la clase "Carta" (con esto no hace falta definir el objeto, puede ir directo) y que no se pueda modificar
	public static final String OROS = "Oros";
	public static final String COPAS = "Copas";
	public static final String ESPADAS = "Espadas";
	
	
	//CONTRSUCTOR - �nico elemento con el mismo nombre que la clase
	//Punto de entrada que se ejecuta al crear un objeto "Carta"
	public Carta() {
		System.out.println("Creo un objeto de tipo carta");
	}

	//M�TODOS - Forma de acceder externamente a una variable privada
	// public/private SALIDA m�todo (ENTRADA){}, de forma que estamos dici�ndole que obtenga un numero Entrada y que no salga nada
	public void setNumero(int numero){ //M�todo p�blico o variable vac�a "void" donde obtendremos un n�mero de entrada 
		if (numero<1){
			this.numero = 1;
		}else if(numero>12){
			this.numero = 12;
		}else{
		this.numero = numero;// Ese n�mero de entrada se asignar� a la variable privada n�mero
		//Con "This" hacemos referencia a la duplicidad de nombres el decimos que ese "Palo" del String es el "Palo" de la clase Carta
		}
	}
	
	public int getNumero(){ //En este caso le decimos que queremos un n�mero "int" de salida pero que no entre nada o no pida nada
		return numero;//Le decimos que nos devuelva el valor de la variable "numero"
	}

	public String getPalo() { // Con esta retornamos el valor "Palo" en un String
		return palo;
	}

	public void setPalo(String palo) { // Con esta obtenemos "Palo"
		switch (palo){ //Condicionamos en n�mero de opciones, es un "Seg�n"
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
		default: //Opci�n por defecto por si introducimos cualquier otra cosa
			this.palo = Carta.BASTOS;
			//no utilizamos "break" pq es la �ltima opci�n
		}
	}
}
