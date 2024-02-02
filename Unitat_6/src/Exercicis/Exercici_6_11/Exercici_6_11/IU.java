package Exercicis.Exercici_6_11;

import java.util.Scanner;

public class IU {

	// Text per defecte.
	private static final String RESET = "\033[0m";

	// Colors de text.
	private static final String VERMELL = "\033[0;31m";
	private static final String VERD = "\033[0;32m";
	private static final String GROC = "\033[0;33m";

	// Estils de text.
	private static final String NEGRETA = "\033[0;1m";

	public static void Separador() {
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println();
	}
	
	public static void SaltLinea() {
		System.out.println();
	}

	// Mètode per mostrar un missatge d'error personalitzat.
	public static void MissatgeError(String missatge) {
		System.out.println(System.lineSeparator());
		System.out.println(VERMELL + " ❎ Error: " + missatge.trim() + "." + RESET);
	}

	// Mètode per mostrar un missatge d'advertència personalitzat.
	public static void MissatgeAdvertencia(String missatge) {
		System.out.println(System.lineSeparator());
		System.out.println(GROC + " ⚠️ Alerta: " + missatge.trim() + "." + RESET);
	}

	// Mètode per mostrar un missatge d'èxit personalitzat.
	public static void MissatgeExit(String missatge) {
		System.out.println(System.lineSeparator());
		System.out.println(VERD + " ✅ Èxit: " + missatge.trim() + "." + RESET);
	}

	public static void Titol(String titol) {
		Separador();
		System.out.println(" " + NEGRETA + titol.toUpperCase().trim() + RESET);
		SaltLinea();
	}

	// Generar un menu switch personalitzat de manera automatitzada.
	public static void MenuOpcions(String... opcions) {
		Scanner opcioMenu = Entrada.input;

		for(int i = 0; i < opcions.length; i++) {

			System.out.println(" " + NEGRETA + (i + 1) + RESET + ". " + opcions[i].trim());

		}

	}

}
