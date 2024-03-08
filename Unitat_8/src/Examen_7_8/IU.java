package Examen_7_8;

import java.util.InputMismatchException;

public class IU {

	protected static void missatge(String m) {
		System.out.println("\n " + m);
	}

	protected static void missatgeErrorCritic(String m) {
		System.out.println("\n 🛑 Error Crític: " + m);
	}

	protected static void titol(String t, String s) {
		String mostrarSubtitol = s != null && !s.trim().isEmpty() ? ": " + s : "";

		System.out.println("\n " + t.toUpperCase() + mostrarSubtitol);
	}

	//////////////////////
	//					//
	//		LLISTA		//
	//					//
	//////////////////////

	protected static String llista(Character tipus, String... def) {
		// Tipus de llistes:
		// -> Tipus O: llista numèrica ordenada.
		// -> Tipus D: llista no numèrica desordenada.

		StringBuilder llista = new StringBuilder();

		try {
			if(tipus != null) {
				switch(tipus) {
				case 'O':
					for(int i = 0; i < def.length; i++) {
						llista.append(" " + (i+1) + ". " + def[i] + "\n");
					}
					break;
				case 'D':
					for(int i = 0; i < def.length; i++) {
						llista.append(" ▪ " + def[i] + "\n");
					}
					break;
				default:
					missatgeErrorCritic("No es troba el tipus de llista " + tipus + ".");
					break;
				}
			}
			
		} catch(InputMismatchException e) {
			missatgeErrorCritic("El valor no és vàlid pel tipus de variable Character.");
		}

		return llista.toString();

	}

}
