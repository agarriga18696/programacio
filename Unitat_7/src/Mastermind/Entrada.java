package Mastermind;

import java.util.Scanner;

public class Entrada {
	
	private static Scanner in = new Scanner(System.in);

	// Int
	public static int enter(String opcio) {
		int nombre = 0;

		while(true) {
			System.out.print("\n " + opcio.trim() + ": ");

			if(in.hasNextInt()) {
				nombre = in.nextInt();
				in.nextLine();
				return nombre;
			} else {
				IU.missatgeError("El valor introduït no és vàlid");
				in.nextLine();
			}
		}
	}
	
	// String
	public static String cadena(String opcio) {
		String cadena = null;

		while(true) {
			System.out.print("\n " + opcio.trim() + ": ");

			if(in.hasNextLine()) {
				cadena = in.nextLine();
				return cadena.trim();
			} else {
				IU.missatgeError("El caracter introduït no és vàlid");
				in.nextLine();
			}
		}
	}
	
}
