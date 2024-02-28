package Mastermind;

public class IU {

	//////////////////////////
	//						//
	//	  ESTIL DE TEXT		//
	//						//
	//////////////////////////

	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_VERMELL = "\u001B[31m";
	public static final String TEXT_BLAU = "\u001B[34m";
	public static final String TEXT_VERD = "\u001B[32m";
	public static final String TEXT_MAGENTA = "\u001B[35m";
	public static final String TEXT_GROC = "\u001B[33m";
	public static final String TEXT_CIAN = "\u001B[36m";
	public static final String TEXT_ROSA = "\u001B[95m";
	public static final String TEXT_NEGRE = "\u001B[30m";
	public static final String TEXT_BLANC = "\u001B[37m";


	//////////////////////////
	//						//
	//	 ELEMENTS VISUALS	//
	//						//
	//////////////////////////
	
	protected static final char CERCLE = '⚫'; //⚫
	protected static final char CREU = '✖'; //⚪

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

	// Mètode per mostrar les opcions d'un menú.
	protected static void opcionsMenu(String... opcions) {
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

	public static void titol(String title) {
		System.out.println(" " + title.toUpperCase() + "\n");
	}

	public static void missatge(String missatge) {
		System.out.println("\n " + missatge);
	}

	public static void missatgeError(String missatge) {
		System.out.println("\n ❌ Error: " + missatge + ".\n");
	}
	
	public static void missatgeErrorCritic(String missatge) {
		System.err.println("\n ❌ Error crític: " + missatge + ".\n");
	}

	public static void missatgeAdvertencia(String missatge) {
		System.out.println("\n ⚠️ Advertència: " + missatge + ".\n");
	}

	public static void missatgeExit(String missatge) {
		System.out.println("\n ✔️ Èxit: " + missatge + ".\n");
	}

	protected static void resultatPartida(boolean partidaFinalitzada, boolean combinacioEndevinada, Partida partida) {
		if(partidaFinalitzada && combinacioEndevinada) {
			missatge("🏆 Has guanyat! Has endivinat la combinació!\n");

		} else if(partidaFinalitzada && Joc.intentsRestants <= 0){
			missatge("💔 Has perdut... T'has quedat sense intents.");
			missatge("La combinació secreta era:\n " + Logica.imprimirColors(partida.getCombinacioSecreta(), 0) + "\n");
		}
	}


	//////////////////////////
	//						//
	//	  ALTRES MÈTODES	//
	//						//
	//////////////////////////


	// Mètode per mostrar la llista de tirades de tota la partida.
	protected static void historialTirades(Partida partida) {
		for (Tirada tirada : partida.getLlistaTirades()) {
			missatge("TIRADA " + tirada.getIdTirada());
			missatge("Combinació:	" + Logica.imprimirColors(tirada.getCombinacioIntentada(), 0));
			missatge("Resultat:	" + Logica.imprimirColors(tirada.getRespostaOrdinador(), 1) + "\n");
		}
	}

}
