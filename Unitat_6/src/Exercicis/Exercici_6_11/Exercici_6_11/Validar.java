package Exercicis.Exercici_6_11;

import java.util.Scanner;

public class Validar {

	// Mètode per validar un int.
	public static int Int(Scanner cin, String missatge) {
		int nombre = 0;

		while(true) {
			System.out.print("\n " + missatge.trim() + ": ");

			if(cin.hasNextInt()) {
				nombre = cin.nextInt();
				cin.nextLine();
				return nombre;
			} else {
				IU.MissatgeError("El valor introduït no és vàlid");
				cin.nextLine();
			}
		}
	}

	// Mètode per validar un double.
	public static double Double(Scanner cin, String missatge) {
		double nombre = 0;

		while(true) {
			System.out.print("\n " + missatge.trim() + ": ");

			if(cin.hasNextDouble()) {
				nombre = cin.nextDouble();
				cin.nextLine();
				return nombre;
			} else {
				IU.MissatgeError("El valor introduït no és vàlid");
				cin.nextLine();
			}
		}
	}

	// Mètode per validar una cadena.
	public static String String(Scanner cin, String missatge) {
		String cadena = null;

		while(true) {
			System.out.print("\n " + missatge.trim() + ": ");

			if(cin.hasNextLine()) {
				cadena = cin.nextLine();
				return cadena.trim();
			} else {
				IU.MissatgeError("El caracter introduït no és vàlid");
				cin.nextLine();
			}
		}
	}

}
