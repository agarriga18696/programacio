package Exercici_9_2;

import java.util.Scanner;

public class Entrada {

	private static Scanner in = new Scanner(System.in);

	// Mètode per netejar el buffer d'entrada.
	protected static void netejar() {
		in.nextLine();
	}

	// Mètode per tancar l'entrada.
	protected static void tancar() {
		in.close();
	}

	// Mètode per introduir un valor de tipus enter.
	protected static int enter(String opcio) {
		while(true) {
			System.out.print("\n " + opcio.trim() + ": ");

			try {
				String nombre = in.nextLine().trim();
				if(nombre.length() > 0 && Character.isDigit(nombre.charAt(0))) {
					return Integer.parseInt(nombre);

				} else {
					if(nombre.length() == 0) {
						Missatge.error("L'entrada no pot estar buida");
					} else {
						Missatge.error("El valor introduït no és un nombre vàlid");
					}
				}

			} catch(Exception e) {
				Missatge.error("El valor introduït no és vàlid");
			}
		}
	}

	// Mètode per introduir una cadena.
	protected static String cadena(String opcio) {
		while(true) {
			System.out.print("\n " + opcio.trim() + ": ");

			try {
				String cadena = in.nextLine().trim();
				if(cadena.length() > 0) {
					return cadena.toUpperCase();

				} else {
					Missatge.error("L'entrada no pot estar buida");
				}

			} catch(Exception e) {
				Missatge.error("El caracter introduït no és vàlid");
			}
		}
	}

	// Mètode per introduir una cadena en format DNI.
	protected static String dni() {
		while(true) {
			System.out.print("\n DNI: ");

			try {
				String dni = in.nextLine().trim();
				if(dni.length() != 0) {
					// Comprovar que els primers 8 caracters siguin nombres, i que el darrer sigui una lletra.
					if(dni.substring(0, 8).matches("[0-9]+") && dni.substring(8).matches("[a-zA-Z]+")) {
						return dni.toUpperCase();

					} else {
						Missatge.error("El format de DNI no és vàlid");
					}
				} else {
					Missatge.error("L'entrada no pot estar buida");
				}

			} catch(Exception e) {
				Missatge.error("El caracter introduït no és vàlid");
			}
		}
	}

}
