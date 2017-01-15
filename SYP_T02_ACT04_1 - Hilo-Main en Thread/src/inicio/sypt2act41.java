package inicio;

public class sypt2act41 {

	public static void main(String[] args) {
		//Creamos a los corredores
		Animal t = new Animal("Ambrosio", "tortuga");
		Animal l = new Animal("Hermenegildo", "liebre");
		Animal g = new Animal ("Edelmira", "guepardo");
		Animal c = new Animal ("Anselmo", "caracol");
		
		//Los ponemos en sus carriles para la carrera de 10m
		Thread h1 = new Thread(new run_hilo(t));
		Thread h2 = new Thread(new run_hilo(l));
		Thread h3 = new Thread(new run_hilo(g));
		Thread h4 = new Thread(new run_hilo(c));
		
		//Trucamos la carrera para poder apostar por el ganador
			/*h1.setPriority(5);
			h2.setPriority(4);
			h3.setPriority(10);*/
		h1.setPriority(Thread.NORM_PRIORITY);
		h2.setPriority(Thread.NORM_PRIORITY);
		h3.setPriority(Thread.MAX_PRIORITY);
		h4.setPriority(Thread.MIN_PRIORITY);
		
		//Iniciamos la carrera
		h1.start();
		h2.start();
		h3.start();
		h4.start();

	}
	
	//Clase runnable a ejecutar por los threads
	static class run_hilo implements Runnable{
		
		private Animal a;
		
		public run_hilo(Animal a){
			this.a=a;
		}
		
		public void run(){
			for (int i = 0; i<10; i++){
				try {
					System.out.println(a.getNombre()+" el/la "+a.getTipo()+" ya lleva "+i+"m");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("\n"+"El/La "+a.getTipo()+" "+a.getNombre()+" ha llegado a la meta!"+"\n");
		}
		
	}
}
