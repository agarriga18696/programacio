package Exercici_10_12;

import java.util.Scanner;

public class Entrada {

	protected static Scanner in = new Scanner(System.in);

	// Int
	protected static int enter(String opcio) {
		while(true) {
			IU.missatgeSeguit("\n " + opcio.trim() + ": ");

			try {
				String nombre = in.nextLine().trim();
				if(nombre.length() > 0 && Character.isDigit(nombre.charAt(0))) {
					return Integer.parseInt(nombre.trim());

				} else {
					if(nombre.length() == 0) {
						IU.missatgeError("L'entrada no pot estar buida");
					} else {
						IU.missatgeError("El valor introduït no és vàlid");
					}
				}

			} catch(Exception e) {
				IU.missatgeError("El valor introduït no és vàlid");
				in.nextLine();
			}
		}
	}

	// String
	protected static String cadena(String opcio) {
		while(true) {
			IU.missatgeSeguit("\n " + opcio.trim() + ": ");

			try {
				String cadena = in.nextLine();
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

	// String
	protected static String lletra(String opcio) {
		while(true) {
			IU.missatgeSeguit("\n " + opcio.trim() + ": ");

			try {
				String lletra = in.nextLine();
				if(lletra.length() == 1 && Character.isAlphabetic(lletra.charAt(0))) {
					return lletra.trim().toUpperCase();

				} else {
					if(lletra.length() != 1) {
						IU.missatgeError("Introdueix únicament una lletra");
						
					} else if(!Character.isAlphabetic(lletra.charAt(0))) {
						IU.missatgeError("No has introduït una lletra");
					}
				}

			} catch(Exception e) {
				IU.missatgeError("El caracter introduït no és vàlid");
				in.nextLine();
			}
		}
	}

}
