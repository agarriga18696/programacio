package Examen_UD7_UD8;

public class IU {

	//////////////////////////
	//						//
	//		   MENU			//
	//						//
	//////////////////////////

	// Mètode per mostrar les opcions d'un menú.
	protected static void opcionsMenu(String... opcions) {
		int i = 1;

		System.out.println();
		
		for(String opcio : opcions) {
			System.out.println(" (" + i + ") " + opcio.trim());
			i++;
		}
	}

	//////////////////////////
	//						//
	//		 MISSATGES		//
	//						//
	//////////////////////////

	protected static void sortida(String m) {
		System.out.println("\n" + m);
	}

	protected static void missatge(String m) {
		System.out.println("\n " + m);
	}

	protected static void missatgeExit(String m) {
		System.out.println("\n ✔️ Èxit: " + m + "!");
	}
	
	protected static void missatgeAdvertencia(String m) {
		System.out.println("\n ⚠️ Advertència: " + m);
	}

	protected static void missatgeError(String m) {
		System.out.println("\n ❌ Error: " + m + "!");
	}

	protected static void missatgeErrorCritic(String m) {
		System.out.println("\n ‼️ Error Crític: " + m);
	}

	protected static void titol(String t, String s) {
		String mostrarSubtitol = s != null && !s.trim().isEmpty() ? ": " + s : "";

		System.out.println("\n\n " + t.toUpperCase() + mostrarSubtitol);
	}

	//////////////////////
	//					//
	//		LLISTA		//
	//					//
	//////////////////////

	protected static String llistaOrdenada(boolean tipus, String... def) {
		// Tipus de llistes:
		// -> Tipus true: llista numèrica ordenada.
		// -> Tipus false: llista no numèrica desordenada.

		StringBuilder llista = new StringBuilder();

		try {
			if(tipus) {
				for(int i = 0; i < def.length; i++) {
					llista.append(" " + (i+1) + ". " + def[i] + "\n");
				}
			} else {
				for(int i = 0; i < def.length; i++) {
					llista.append(" ▪ " + def[i] + "\n");
				}
			}

		} catch(IndexOutOfBoundsException e) {
			missatgeErrorCritic("L'índex s'ha sortit de l'array");
		}

		return llista.toString();
	}

}
