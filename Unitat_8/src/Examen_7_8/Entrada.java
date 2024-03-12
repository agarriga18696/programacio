package Examen_7_8;

import java.util.Scanner;

public class Entrada {

	protected static Scanner in = new Scanner(System.in);

	// Entrada de variable tipus int.
	public static int enter(String opcio) {
		while(true) {
			System.out.print("\n " + opcio.trim() + ": ");

			try {
				String entrada = in.nextLine().trim();

				if(entrada.isEmpty()) {
					IU.missatgeError("L'entrada no pot estar buida");
				} else {
					int nombre = Integer.parseInt(entrada.trim());
					return nombre;
				}

			} catch(NumberFormatException e) {
				IU.missatgeError("El valor introduït no és un nombre vàlid");
			}
		}
	}

	// Entrada de variable tipus int.
	public static String cadena(String opcio) {
		while(true) {
			System.out.print("\n " + opcio.trim() + ": ");

			if(in.hasNextLine()) {
				String entrada = in.nextLine().trim();

				if(entrada.isEmpty()) {
					IU.missatgeError("La cadena no pot estar buida");
				} else {
					return entrada.toUpperCase();
				}

			} else {
				IU.missatgeError("El valor introduït no és una cadena vàlida");
			}
		}
	}

	// Entrada de variable tipus int.
	public static String dni() {
		while(true) {
			System.out.print("\n DNI: ");

			if(in.hasNextLine()) {
				String dni = in.nextLine().trim();

				if(dni.isEmpty()) {
					IU.missatgeError("La cadena no pot estar buida");
					
				} else {
					if(dni.substring(0, 8).matches("[0-9]+") && dni.substring(8).matches("[a-zA-Z]+")) {
						return dni.toUpperCase();
						
					} else {
						IU.missatgeError("Format de DNI incorrecte. Assegura't que tingui 8 caràcters numèrics seguits d'una lletra");
					}
				}

			} else {
				IU.missatgeError("El valor introduït no és una cadena vàlida");
			}
		}
	}

	// Tancar l'entrada.
	protected static void tancarEntrada() {
		in.close();
	}

}
