package proba_arrays;

import java.util.Random;

public class proba_arrays {



	public static void main(String[] args) {
		
	//private int[] p1 = new int[5];
	String[] p2 = new String[3];
	Random gen = new Random();
	
	int[] p1={1,2,3};
	
			for(int i=0; i<p1.length; i++){
			p1[i] = 1+i;
			p2[i]="Paco";
			System.out.println("Hola "+p1[i]);
		}
		System.out.println("Hola "+p2[2]);
	}

	public proba_arrays() {
	

		
	}
	
}
