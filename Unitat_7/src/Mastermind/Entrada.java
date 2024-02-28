package Mastermind;

import java.util.Scanner;

public class Entrada {
	
	private static Scanner in = new Scanner(System.in);

	// Int
	public static int enter(String opcio) {
		String nombre = null;

		while(true) {
			IU.missatgeSeguit("\n " + opcio.trim() + ": ");

			if(in.hasNextLine()) {
				nombre = in.nextLine();
				if(nombre.length() > 0 && Character.isDigit(nombre.charAt(0))) {
					return Integer.parseInt(nombre.trim());
					
				} else {
					if(nombre.length() == 0) {
						IU.missatgeError("L'entrada no pot estar buida");
					} else {
						IU.missatgeError("El valor introduït no és vàlid");
					}
				}
				
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
			IU.missatgeSeguit("\n " + opcio.trim() + ": ");

			if(in.hasNextLine()) {
				cadena = in.nextLine();
				if(cadena.length() > 0) {
					return cadena.trim();
					
				} else {
					IU.missatgeError("L'entrada no pot estar buida");
				}
				
			} else {
				IU.missatgeError("El caracter introduït no és vàlid");
				in.nextLine();
			}
		}
	}
	
}
