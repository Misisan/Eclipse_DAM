package inicio;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class sypt2act43 {
	
	private static int suma=0;
	private static int cont=0;
	private static double media;
	private static double[] valores = new double[3];
	
	public static void main(String[] args) {
		//Definimos y creamos el hilo runnable
		Thread h1 = new Thread(new run_hilo(1));
		Thread h2 = new Thread(new run_hilo(2));
		Thread h3 = new Thread(new run_hilo(3));
		
		//Ejecutamos los hilo
		h1.start();
		h2.start();
		h3.start();

	}
	
	//M�todo de c�lculo com�n para todos los hilos
	public synchronized static void nuevoValor(Integer i) throws Exception{
		suma = suma+ i;
		cont++;
		media = (double) suma/cont;
		
		System.out.println(cont+" | num. introducido: "+i+" | Sumatorio: "+suma+" | Media :"+media);
	}
	
	public static double[] getValores(){
		valores[0]=(double)suma;
		valores[1]=(double)cont;
		valores[2]=media;
		return valores;
		
	}
	
	//----------------------------------------------------------------------------------------------------------------inner class
	//Clase runnable a ejecutar por un nuevo hilo
	static class run_hilo implements Runnable{
		
		private int hilo;
		
		public run_hilo(int i){this.hilo=i;}
		
		public void run(){
			
			for (int i = 0; i<10; i++){
				try {
					sypt2act43.nuevoValor(new Random().nextInt(100));
					Thread.sleep(100);
				} catch ( Exception e) {
					e.printStackTrace();
				}
			}
			double[] valores = sypt2act43.getValores();
			System.out.println("Al terminar el hilo "+hilo+" los valores son:"+"\n"+
								"    Sumatorio: "+(int)valores[0]+"\n"+
								"    Num. de operaciones: "+(int)valores[1]+"\n"+
								"    Media: "+valores[2]);
		}
		
	}

}
