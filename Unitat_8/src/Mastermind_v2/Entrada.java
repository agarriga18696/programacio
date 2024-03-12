package Mastermind_v2;

import java.util.Scanner;

public class Entrada {

	protected static Scanner in = new Scanner(System.in);

	// Int
	protected static int enter(String opcio) {
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
	protected static String cadena(String opcio) {
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

	// String
	protected static String lletra(String opcio) {
		String lletra = null;

		while(true) {
			IU.missatgeSeguit("\n " + opcio.trim() + ": ");

			if(in.hasNextLine()) {
				lletra = in.nextLine();
				if(lletra.length() == 1 && Character.isAlphabetic(lletra.charAt(0))) {
					return lletra.trim();

				} else {
					if(lletra.length() != 1) {
						IU.missatgeError("Introdueix únicament una lletra");
						
					} else if(!Character.isAlphabetic(lletra.charAt(0))) {
						IU.missatgeError("No has introduït una lletra");
					}
				}

			} else {
				IU.missatgeError("El caracter introduït no és vàlid");
				in.nextLine();
			}
		}
	}

}