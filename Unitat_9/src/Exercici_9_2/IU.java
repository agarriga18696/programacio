package Exercici_9_2;

public class IU {

	//////////////////////////
	//						//
	//		 ELEMENTS		//
	//						//
	//////////////////////////

	// Mètode per mostrar un títol amb un subtítol opcional.
	protected static void titol(String t, String s) {
		String mostrarSubtitol = s != null && !s.trim().isEmpty() ? ": " + s : "";

		System.out.println("\n " + t.toUpperCase() + mostrarSubtitol);
	}

	//////////////////////////
	//						//
	//		   MENU			//
	//						//
	//////////////////////////

	// Mètode per mostrar les opcions d'un menú.
	protected static void opcions(String... opcions) {
		int i = 1;

		System.out.println();

		for(String opcio : opcions) {
			System.out.println(" (" + i + ") " + opcio.trim());
			i++;
		}
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
			Missatge.errorGreu("L'índex s'ha sortit de l'array");
		}

		return llista.toString();
	}

}
