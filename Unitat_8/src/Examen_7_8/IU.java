package Examen_7_8;


public class IU {

	//////////////////////////
	//						//
	//		   MENÚS		//
	//						//
	//////////////////////////

	// Mètode per mostrar les opcions d'un menú de manera flexible.
	protected static void opcionsMenu(String... opcions) {
		int i = 1;

		System.out.println();
		for(String opcio : opcions) {
			System.out.println(" (" + i + ") " + opcio.trim());
			i++;
		}
	}

	//////////////////////
	//					//
	//	   MISSATGES	//
	//					//
	//////////////////////

	// Sortida de String sense sangrat.
	protected static void sortida(String m) {
		System.out.println("\n" + m);
	}

	// Missatge per defecte.
	protected static void missatge(String m) {
		System.out.println("\n " + m);
	}

	// Missatge d'èxit.
	protected static void missatgeExit(String m) {
		System.out.println("\n ✔️ Èxit: " + m + "!");
	}

	// Missatge d'adverència.
	protected static void missatgeAdvertencia(String m) {
		System.out.println("\n ⚠️ Advertència: " + m + ".");
	}

	// Missatge d'error.
	protected static void missatgeError(String m) {
		System.out.println("\n ❌ Error: " + m + "!");
	}

	// Missatge d'error crític, per avisar d'errors d'execució del codi.
	protected static void missatgeErrorCritic(String m) {
		System.out.println("\n ❗ Error Crític: " + m + ".");
	}

	// Títol acompanyat d'un subtítol (en cas que s'especifiqui).
	protected static void titol(String t, String s) {
		String mostrarSubtitol = s != null && !s.trim().isEmpty() ? ": " + s : "";

		System.out.println("\n\n " + t.toUpperCase() + mostrarSubtitol);
	}

	//////////////////////
	//					//
	//		LLISTA		//
	//					//
	//////////////////////

	// Llista ordenada o desordenada.
	protected static String llista(boolean ordenada, String... elements) {
		StringBuilder llista = new StringBuilder();

		if (elements.length == 0) {
			return "";
		}

		for (int i = 0; i < elements.length; i++) {
			if (ordenada) {
				llista.append(" " + (i + 1) + ". " + elements[i] + "\n");
			} else {
				llista.append(" ▪ " + elements[i] + "\n");
			}
		}

		return llista.toString();
	}

}
