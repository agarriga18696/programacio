package Exercici_7_5_Ordenacio;

import java.util.Scanner;

public class Entrada {

	private static Scanner in = new Scanner(System.in);

	// Validar int
	public static int enter(String mensaje) {
		int numero = 0;
		while(true) {
			System.out.print("\n " + mensaje + ": ");
			if(in.hasNextInt()) {
				numero = in.nextInt();
				in.nextLine();
				return numero;
			} else {
				Missatge.error("El valor no es válido");
				in.nextLine();
			}
		}
	}

	// Validar String
	public static String cadena(String mensaje) {
		String cadena = null;
		while(true) {
			System.out.print("\n " + mensaje + ": ");
			if(in.hasNextLine()) {
				cadena = in.nextLine();
				return cadena.trim().toUpperCase();
			} else {
				Missatge.error("El valor no es válido");
				in.nextLine();
			}
		}
	}
	
}
