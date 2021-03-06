package inicio;

public class syp_exam {
	
	//M�todo Main para iniciar el programa
	public static void main(String[] args) {

		//Definimos y creamos el hilo runnable
		Thread hrun1 = new Thread(new run_hilo("hilo 1", "soy el hilo 1 y me estoy ejecutando"));
		Thread hrun2 = new Thread(new run_hilo("hilo 2", "soy el hilo 2 y tambi�n estoy ejecut�ndome"));
		Thread hrun3 = new Thread(new run_hilo("hilo 3", "Dejadme sitio a mi tambi�n"));
		
		//Damos prioridades
		hrun1.setPriority(10);
		hrun2.setPriority(1);
		hrun3.setPriority(2);
		
		//Ejecutamos los hilo
		hrun1.start();		
		hrun2.start();
		hrun3.start();
		
		//Paramos el c�digo hasta que terminen los hilos
		try {
			hrun1.join();
			hrun2.join();
			hrun3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("el hilo principal terminado");

	}
	
	//-----------------------------------------------------------------------------------------------------------------------------
	
	//Clase runnable a ejecutar por un nuevo hilo
	static class run_hilo implements Runnable{
		
		private String mensaje;
		private String nombre;
		
		public run_hilo(String n, String m){
			this.mensaje=m;
			this.nombre=n;
		}
		
		public void run(){
			
			//Inicicio del hilo
			for (int i = 0; i<5; i++){
				try {
					System.out.println(mensaje);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//Fin del hilo
			System.out.println("Finaliza el "+nombre);
		}
		
	}
}

