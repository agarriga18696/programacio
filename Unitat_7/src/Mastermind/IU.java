package Mastermind;

public class IU {

	//////////////////////////
	//						//
	//		ESTIL TEXT		//
	//						//
	//////////////////////////
	
	public static final String RESET = "\u001B[0m";
	public static final String VERMELL = "\u001B[31m";
	public static final String BLAU = "\u001B[34m";
	public static final String VERD = "\u001B[32m";
	public static final String MAGENTA = "\u001B[35m";
	public static final String GROC = "\u001B[33m";
	public static final String CIAN = "\u001B[36m";
	public static final String NEGRE = "\u001B[30m";
	public static final String BLANC = "\u001B[37m";
	
	// Símbol per al cercle de color.
	public static final char CERCLE = '⬤';

	//////////////////////////
	//						//
	//		 ELEMENTS		//
	//						//
	//////////////////////////

	public static void saltLinia() {
		System.out.println(System.lineSeparator());
	}

	public static void separador() {
		System.out.println("\n ------------------------------------------------------\n");
	}

	//////////////////////////
	//						//
	//		   MENU			//
	//						//
	//////////////////////////

	public static void menu(String... opcions) {
		int i = 1;

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

	public static void title(String title) {
		System.out.println(" " + title.toUpperCase() + "\n");
	}

	public static void missatge(String missatge) {
		System.out.println(" " + missatge);
	}

	public static void missatgeError(String missatge) {
		System.out.println("\n ❌ Error: " + missatge + ".\n");
	}

	public static void missatgeAdvertencia(String missatge) {
		System.out.println("\n ⚠️ Advertència: " + missatge + ".\n");
	}

	public static void missatgeExit(String missatge) {
		System.out.println("\n ✔️ Èxit: " + missatge + ".\n");
	}

}
