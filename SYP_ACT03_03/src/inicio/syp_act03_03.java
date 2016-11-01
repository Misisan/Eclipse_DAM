package inicio;

import java.util.Scanner;

import javax.swing.Spring;

public class syp_act03_03 {

	public static void main(String[] args) {
		//Variables
		Scanner lectorTecla = new Scanner(System.in);
		String num;
		int numint = 0;
		boolean entero = false;
		String cadena=null;
		
		//Recogemos la opción del usuario
		System.out.println("Miguel A. Simeón"+"\n"+"PROGRAMACIÓN DE SERVICIOS Y PROCESOS - 2º DAM SEMIPRESENCIAL"+"\n"+"\n"+"Actividad 03 - 03 - Números naturales"+"\n");
		System.out.println("Dime el número final:");
		num=lectorTecla.next();
		
		//Comprobamos que el número es entero y no letras
		while(entero==false){
			try{
				numint=Integer.valueOf(num);
				
				//Comprobamos si el número es positivo o negativo
				if(numint>0){
					entero=true;
					System.out.println("Número correcto");
				}else{
					System.out.println("Debes introducir un número entero positivo:");
					num=lectorTecla.next();
				}
			}catch(Exception e){
				System.out.println("Debes introducir un número entero positivo:");
				num=lectorTecla.next();
			}
		}
		
		//Procesamos la respuesta
		for (int i=1; i<numint; i++){
			cadena=cadena+", "+i;
			if(i==1){cadena="La serie de números naturales es:"+"\n"+i;}
		}
		if (numint==1){
			System.out.println("La serie de números naturales es únicamente el "+numint);
		}else{
			cadena=cadena+" y "+numint;
			System.out.println(cadena);
		}
	}

}
