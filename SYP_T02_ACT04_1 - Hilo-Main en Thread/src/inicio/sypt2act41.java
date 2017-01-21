package inicio;

public class sypt2act41 extends Thread{

	//Método Main para iniciar el programa
	public static void main(String[] args) {

		//Definimos y creamos el hilo de esta clase (thread)
		sypt2act41 hthr = new sypt2act41();
		
		//Damos prioridades
		//hthr.setPriority(Thread.NORM_PRIORITY);
		
		//EJecutamos los hilo
		hthr.start();
		
		//Hilo del main
		for (int i = 0; i<10; i++){
			try { 
				System.out.println("Hilo del main en marcha...");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


	}
	
	//Constructor
	//En este caso no necesitamos que el constructor haga nada porque al extender el thread
	//con el start del main se ejecuta directamente el método run() de esta clase. Podemos quitarlo sin problema
	//public sypt2act41(){}
	
	//Método run que se inicializa con el start del thread
	public void run(){
		//Inicicio del hilo
		System.out.println("Inicio del hilo del thread...");
		for (int i = 0; i<10; i++){
			try { 
				System.out.println("Hilo del thread en marcha...");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Fin del hilo
		System.out.println("Fin del hilo del thread.");
	}
	
}
