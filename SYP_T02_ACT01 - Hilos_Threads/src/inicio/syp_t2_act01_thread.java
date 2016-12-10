package inicio;

public class syp_t2_act01_thread extends Thread{
	
	private String txt;
	
	public static void main(String[] args) {
		//Definimos e inicializamos (construimos) los hilos
		syp_t2_act01_thread hilo1 = new syp_t2_act01_thread("bienvenido, soy el hilo 1", "hilo 1");
		syp_t2_act01_thread hilo2 = new syp_t2_act01_thread("soy el hilo 2 y es mi ciclo número", "hilo 2");
		
		//Iniciamos los hilos
		hilo1.start();
		hilo2.start();
		
		System.out.println("\n"+"Main terminado");
	}
	
	//Constructor de la clase
	public syp_t2_act01_thread(String n, String n2) {
		txt=n;
		setName(n2);
	}

	//Método que se iniciliza al iniciarse el hilo
	public void run(){
		for (int i=0; i<10; i++){
			System.out.println(txt+" "+i);
		}
		System.out.println("Finaliza el "+getName());
	}

}
