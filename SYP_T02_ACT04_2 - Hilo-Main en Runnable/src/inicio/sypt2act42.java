package inicio;

public class sypt2act42 {

	//Método Main para iniciar el programa
	public static void main(String[] args) {

		//Definimos y creamos el hilo runnable
		Thread hrun = new Thread(new run_hilo());
		
		//Damos prioridades
		//hrun.setPriority(Thread.NORM_PRIORITY);
		
		//EJecutamos los hilo
		hrun.start();
		
		//Hilo del main
		for (int i = 0; i<10; i++){
			try {
				System.out.println("Hilo main en marcha...");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	//-----------------------------------------------------------------------------------------------------------------------------
	
	//Clase runnable a ejecutar por un nuevo hilo
	static class run_hilo implements Runnable{
				
		//public run_hilo(){}//En este caso no lo necesitamos, se ejecuta directamente en run()
		
		public void run(){
			
			//Inicicio del hilo
			System.out.println("Inicio del hilo runnable...");
			for (int i = 0; i<10; i++){
				try {
					System.out.println("Hilo runnable en marcha...");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//Fin del hilo
			System.out.println("Fin del hilo runnable.");
		}
		
	}
}

