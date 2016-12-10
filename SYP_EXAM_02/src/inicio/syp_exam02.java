package inicio;

import java.util.Scanner;

public class syp_exam02 {
	
	public static void main(String[] args) {
		
		int n;
		int sum=0;
		int c=0;
		Scanner lectorTecla = new Scanner(System.in);
		boolean entero = false;
		boolean terminar = false;
				
		while(terminar==false){
			
			System.out.println("Ingresa un número:");
			String tecla=lectorTecla.next();
			
			while(entero==false){
				
				try{
					n=Integer.valueOf(tecla);
					entero=true;
					sum=sum+n;
					c=c+1;
				}catch(Exception e){
					entero=false;
				}
			}
			
			System.out.println("Vas a ingresar otro número? (y/n)");
			String tecla2=lectorTecla.next();
			
			switch(tecla2){
				case "y":
					terminar=false;					
					break;
				case "n":
					terminar=true;
					break;
				default:
					terminar=true;
					System.out.println("Por equivocarte vasmo a terminar.");
			}
			entero=false;
		}
		
		System.out.println("Has introducido un total de "+c+" elementos,"+"\n"+"con una suma total de "+sum);
		
	}

}
