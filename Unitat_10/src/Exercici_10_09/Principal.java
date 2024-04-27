package Exercici_10_09;

import java.io.*;

public class Principal {
	public static void main(String[] args) {
		String nomFitxer = "src/Exercici_10_09/fitxer.txt";

		// Crear i escriure al fitxer.
		escriureFitxer(nomFitxer);

		// Recuperar un caràcter en una posició específica del fitxer.
		int posicio = 5;
		char caracter = obtenirCaracterEnPosicio(nomFitxer, posicio);
		Msg.simple("El caràcter a la posició " + posicio + " és: " + caracter);
	}

	// Mètode per escriure al fitxer.
	public static void escriureFitxer(String nomFitxer) {
		try(PrintWriter escriptor = new PrintWriter(new FileWriter(nomFitxer))) {
			// Escriure algunes línies al fitxer.
			escriptor.println("Holaaaaaaaa");
			escriptor.println("Açò és un exempleee");
		} catch(IOException e) {
			Msg.error("No s'ha pogut escriure al fitxer: " + e.getMessage());
		}
	}

	// Mètode per obtenir un caràcter en una posició específica del fitxer.
	public static char obtenirCaracterEnPosicio(String nomFitxer, int posicio) {
		try(RandomAccessFile fitxer = new RandomAccessFile(nomFitxer, "r")) {
			// Anar a la posició específica al fitxer.
			fitxer.seek(posicio);
			// Llegir el caràcter en aquella posició.
			return (char) fitxer.read();

		} catch(IOException e) {
			System.err.println("Error en obtenir el caràcter a la posició " + posicio + ": " + e.getMessage());
			return '\0'; // Caràcter null en cas d'error.
		}
	}
}
