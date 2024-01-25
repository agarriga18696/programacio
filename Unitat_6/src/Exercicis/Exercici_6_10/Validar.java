package Exercicis.Exercici_6_10;

import java.util.Scanner;

public class Validar {

	// Mètode per validar un int.
	public static int Int(Scanner cin, String missatge) {
		int nombre = 0;

		while(true) {
			System.out.print("\n " + missatge + ": ");

			if(cin.hasNextInt()) {
				nombre = cin.nextInt();
				cin.nextLine();
				return nombre;
			} else {
				IU.mostrarMissatgeError("El valor introduït no és vàlid");
				cin.nextLine();
			}
		}
	}

	// Mètode per validar un double.
	public static double Double(Scanner cin, String missatge) {
		double nombre = 0;

		while(true) {
			System.out.print("\n " + missatge + ": ");

			if(cin.hasNextDouble()) {
				nombre = cin.nextDouble();
				cin.nextLine();
				return nombre;
			} else {
				IU.mostrarMissatgeError("El valor introduït no és vàlid");
				cin.nextLine();
			}
		}
	}

	// Mètode per validar una cadena.
	public static String String(Scanner cin, String missatge) {
		String cadena = null;

		while(true) {
			System.out.print("\n " + missatge + ": ");

			if(cin.hasNextLine()) {
				cadena = cin.nextLine();
				return cadena.toUpperCase(); // retornar en majúscules (per no tenir problemes al comparar amb llista enum)
			} else {
				IU.mostrarMissatgeError("El caracter introduït no és vàlid");
				cin.nextLine();
			}
		}
	}

}
