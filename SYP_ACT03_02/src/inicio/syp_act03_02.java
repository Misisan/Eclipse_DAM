package inicio;

import java.util.Scanner;

public class syp_act03_02 {

	public static void main(String[] args) {
		//Variables
		Scanner lectorTecla = new Scanner(System.in);
		String num;
		int numint = 0;
		boolean entero = false;
		
		//Recogemos la opci�n del usuario
		System.out.println("Miguel A. Sime�n"+"\n"+"PROGRAMACI�N DE SERVICIOS Y PROCESOS - 2� DAM SEMIPRESENCIAL"+"\n"+"\n"+"Actividad 03 - 02 - D�as de la semana"+"\n");
		System.out.println("Dime el n�mero de d�a:");
		num=lectorTecla.next();
		
		//Comprobamos que el n�mero es entero y no letras
		while(entero==false){
			try{
				numint=Integer.valueOf(num);
				
				//Comprobamos si el n�mero est� entre el 1 y el 7
				if(numint>0 && numint<8){
					entero=true;
					System.out.println("D�a correcto");
				}else{
					System.out.println("Debes introducir un n�mero de d�a entre 1 y 7:");
					num=lectorTecla.next();
				}
			}catch(Exception e){
				System.out.println("Debes introducir un n�mero de d�a correcto:");
				num=lectorTecla.next();
			}
		}
		
		//Analizamos la respuesta
		switch(numint){
			case 1:
				System.out.println("El d�a n� "+numint+" es el Lunes.");
				break;
			case 2:
				System.out.println("El d�a n� "+numint+" es el Martes.");
				break;
			case 3:
				System.out.println("El d�a n� "+numint+" es el Mi�rcoles.");
				break;
			case 4:
				System.out.println("El d�a n� "+numint+" es el Jueves.");
				break;
			case 5:
				System.out.println("El d�a n� "+numint+" es el Viernes.");
				break;
			case 6:
				System.out.println("El d�a n� "+numint+" es el S�bado.");
				break;
			case 7:
				System.out.println("El d�a n� "+numint+" es el Domingo.");
				break;
			default:
				
		}

	}

}
