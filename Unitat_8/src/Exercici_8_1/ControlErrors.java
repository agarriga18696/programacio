package Exercici_8_1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlErrors {

	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Error_1();
		Error_2();
		Error_3();

	}
	
	// Error 1: InputMismatchException
	private static void Error_1() {
		boolean esNombre;
		
		IU.Titol("Error 1", "InputMismatchException");
		
		do {
			try {
				IU.MissatgeEntrada("Introdueix un nombre");
				int n = in.nextInt();
				esNombre = true;
				
			} catch(InputMismatchException e) {
				IU.Missatge("No has introduït un nombre.");
				esNombre = false;
			}
			
			in.nextLine();
			
		} while(!esNombre);
		
		IU.Missatge("Has introduït un nombre.");
		IU.SaltLinia();
		
	}
	
	// Error 2: IndexOutOfBoundsException.
	private static void Error_2() {
		int[] array = {0, 1, 2, 3, 4, 5};
		int i = 0;
		
		IU.Titol("Error 2", "IndexOutOfBoundsException");
		
		do {
			try {
				IU.Missatge("Array: " + Arrays.toString(array));
				IU.MissatgeEntrada("Selecciona un índex de l'array");
				i = in.nextInt();
				
				IU.Missatge("Has seleccionat: " + array[i]);
				
			} catch(IndexOutOfBoundsException e) {
				IU.Missatge("T'has passat tres pobles.");
			}
			
			in.nextLine();
			
		} while(i >= array.length);
		
		IU.Missatge("L'índex és correcte.");
		IU.SaltLinia();
		
	}
	
	// Error 3: ArithmeticException.
	private static void Error_3() {
		int n = 0, r = 0;
		
		IU.Titol("Error 3", "ArithmeticException");
		
		do {
			try {
				IU.MissatgeEntrada("Per quin nombre vols dividir 10?");
				n = in.nextInt();
				r = 10 / n;
								
			} catch(ArithmeticException e) {
				IU.Missatge("No pots dividir per zero!");
			}
			
			in.nextLine();
			
		} while(n == 0);
		
		IU.Missatge("Operació correcta! 10 / " + n + " = " + r);
		IU.SaltLinia();
		
	}

}
