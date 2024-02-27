package Mastermind;

public class IU {

	//////////////////////////
	//						//
	//		ELEMENTS		//
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
