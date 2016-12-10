package inicio;

public class syp_exam04 extends Thread{
	
	private String txt;
	
	/*Me falta la sincronización ;p*/

	public static void main(String[] args) {
		syp_exam04 hilo1 = new syp_exam04 ("hola", "hilo 1");
		syp_exam04 hilo2 = new syp_exam04 ("adiós", "hilo 2");
		
		hilo1.start();
		hilo2.start();
		
		System.out.println("El hilo principal terminado.");
	}
	
	public syp_exam04(String n, String n2){
		txt=n;
		setName(n2);
		
	}
	
	public void run(){
           		
		for (int i=0; i<5; i++){
			System.out.println(txt);
			try {
				Thread.sleep(100);
				 } catch (InterruptedException e) { } 
		}
		
		System.out.println("Finaliza el "+getName());
	
	}
}
