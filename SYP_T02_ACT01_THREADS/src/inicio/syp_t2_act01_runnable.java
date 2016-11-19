package inicio;

public class syp_t2_act01_runnable implements Runnable{
	
	private String txt;
	
	public static void main(String[] args) {
		//Definimos e inicializamos (construimos) los runnables
		syp_t2_act01_runnable hilo1 = new syp_t2_act01_runnable("bienvenido, soy el hilo 1");
		syp_t2_act01_runnable hilo2 = new syp_t2_act01_runnable("soy el hilo 2 y es mi ciclo n�mero");
		
		//Asignamos los runnables a hilos nuevos
		Thread hilo1ok = new Thread (hilo1, "hilo 1");
		Thread hilo2ok = new Thread (hilo2, "hilo 2");
		
		//Iniciamos los hilos
		hilo1ok.start();
		hilo2ok.start();
		
		System.out.println("\n"+"Main terminado");
	}
	
	public syp_t2_act01_runnable(String t){
		txt=t;
	}

	//M�todo que se iniciliza al iniciarse el hilo
	public void run(){
		for (int i=0; i<10; i++){
			System.out.println(txt+" "+i);
		}
		System.out.println("Finaliza el hilo "+Thread.currentThread().getName());
	}

}