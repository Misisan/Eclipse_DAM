package inicio;

import java.util.Scanner;

public class syp_act03_01 {

	public static void main(String[] args) {
		
		//Variables
		Scanner lectorTecla = new Scanner(System.in);
		String num;
		int numint = 0;
		boolean entero = false;
		
		//Recogemos la opci�n del usuario
		System.out.println("Miguel A. Sime�n"+"\n"+"PROGRAMACI�N DE SERVICIOS Y PROCESOS - 2� DAM SEMIPRESENCIAL"+"\n"+"\n"+"Actividad 03 - 01 - N�mero par o impar"+"\n");
		System.out.println("Dime un n�mero:");
		num=lectorTecla.next();
		
		//Comprobamos que el n�mero es entero y no letras
		while(entero==false){
			try{
				numint=Integer.valueOf(num);
				
				//Comprobamos si el n�mero es positivo o negativo
				if(numint>0){
					entero=true;
					System.out.println("N�mero correcto");
				}else{
					System.out.println("Debes introducir un n�mero entero positivo:");
					num=lectorTecla.next();
				}
			}catch(Exception e){
				System.out.println("Debes introducir un n�mero entero positivo:");
				num=lectorTecla.next();
			}
		}
		
		//Analizamos el resultado
		if(numint==0){
			System.out.println("\n"+"El n�mero introducido es 0");
		}else if(numint%2==0){
			System.out.println("\n"+"El n�mero introducido ("+numint+") es par");
		}else{
			System.out.println("\n"+"El n�mero introducido ("+numint+") es impar");
		}		
	}

}
