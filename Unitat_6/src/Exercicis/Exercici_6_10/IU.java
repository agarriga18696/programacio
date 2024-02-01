package Exercicis.Exercici_6_10;

public class IU {

	// INTERFÍCIE D'USUARI (consola).

	// Codis de color i estil pel text.
	public static final String TEXT_GROC = "\u001B[33m";
	public static final String TEXT_VERD = "\u001B[32m";
	public static final String TEXT_NEGRETA = "\u001B[1m";
	public static final String TEXT_PER_DEFECTE = "\u001B[0m";

	// Mètode per mostrar un missatge d'error personalitzat.
	public static void mostrarMissatgeError(String missatge) {
		System.out.println(System.lineSeparator());
		System.err.println(" ❎ Error: " + missatge + "!");
	}

	// Mètode per mostrar un missatge d'advertència personalitzat.
	public static void mostrarMissatgeAdvertencia(String missatge) {
		System.out.println(System.lineSeparator());
		System.out.println(TEXT_GROC + " ⚠️ Alerta: " + missatge + "." + TEXT_PER_DEFECTE);
	}

	// Mètode per mostrar un missatge d'èxit personalitzat.
	public static void mostrarMissatgeExit(String missatge) {
		System.out.println(System.lineSeparator());
		System.out.println(TEXT_VERD + " ✅ Èxit: " + missatge + "!" + TEXT_PER_DEFECTE);
	}

	// Mètode per mostrar una línea separatoria.
	public static void mostrarSeparador() {
		System.out.println(System.lineSeparator());
		System.out.println("----------------------------------------------------------------------------");
		System.out.println(System.lineSeparator());
	}

	// Mètode per esperar temps.
	public static void esperarTemps(long temps) {

		try {
			Thread.sleep(temps);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}

}
