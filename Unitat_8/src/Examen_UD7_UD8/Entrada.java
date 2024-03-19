package Examen_UD7_UD8;

import java.util.Scanner;

public class Entrada {

	protected static Scanner in = new Scanner(System.in);

	// Int
	public static int enter(String opcio) {
		String nombre = null;

		while(true) {
			System.out.print("\n " + opcio.trim() + ": ");

			try {
				nombre = in.nextLine().trim();
				if(nombre.length() > 0 && Character.isDigit(nombre.charAt(0))) {
					return Integer.parseInt(nombre);

				} else {
					if(nombre.length() == 0) {
						IU.missatgeError("L'entrada no pot estar buida");
					} else {
						IU.missatgeError("El valor introduït no és un nombre vàlid");
					}
				}

			} catch(Exception e) {
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

			try {
				cadena = in.nextLine();
				if(cadena.length() > 0) {
					return cadena.trim().toUpperCase();

				} else {
					IU.missatgeError("L'entrada no pot estar buida");
				}

			} catch(Exception e) {
				IU.missatgeError("El caracter introduït no és vàlid");
				in.nextLine();
			}
		}
	}

}
