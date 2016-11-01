package inicio;

import java.util.Scanner;

public class syp_act03_04 {

	public static void main(String[] args) {
		//Variables
		Integer numeros[] = new Integer[10];
		Scanner lectorTecla = new Scanner(System.in);
		boolean entero = false;
		String tecla;
		int numint = 0;
		
		System.out.println("Miguel A. Sime�n"+"\n"+"PROGRAMACI�N DE SERVICIOS Y PROCESOS - 2� DAM SEMIPRESENCIAL"+"\n"+"\n"+"Actividad 03 - 04 - 10 n�meros en un Array"+"\n");
		System.out.println("Dame 10 n�meros y te los repito:"+"\n");
		
		//Recogemos los datos
		for(int i=0;i<numeros.length;i++) {
			System.out.println("N�mero n� "+(i+1)+" : ");
			tecla=lectorTecla.next();
			entero=false;
					
			//Comprobamos que el n�mero es entero y no letras
			while(entero==false){
				try{
					numint=Integer.valueOf(tecla);
					
					//Comprobamos si el n�mero es positivo o negativo
					if(numint>0){
						entero=true;
						System.out.println("N�mero correcto");
					}else{
						System.out.println("Debes introducir un n�mero entero positivo:");
						tecla=lectorTecla.next();
						entero=false;
					}
				}catch(Exception e){
					System.out.println("Debes introducir un n�mero entero positivo:");
					tecla=lectorTecla.next();
					entero=false;
				}
			}
			
			//Guardamos el valor comprobado dentro del array
			numeros[i]=numint;
		}
		
		//Ahora recorremos el Array y lo mostramos en pantalla
		for(int i=0;i<numeros.length;i++) {
			System.out.println("El "+(i+1)+"� n�mero introducido fue: "+numeros[i]);
		}
	}
}