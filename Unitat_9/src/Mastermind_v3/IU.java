package Mastermind_v3;

import Mastermind_v3.Partida.Dificultats;

public class IU {

	//////////////////////////
	//						//
	//	  ESTIL DE TEXT		//
	//						//
	//////////////////////////

	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_VERMELL = "\u001B[31m";
	public static final String TEXT_VERD = "\u001B[32m";
	public static final String TEXT_BLAU = "\u001B[34m";
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

	protected static void saltLinia() {
		System.out.println(System.lineSeparator());
	}

	protected static void separador() {
		StringBuilder s = new StringBuilder();
		s.append("\n ");

		for(int i = 0; i < 60; i++) {
			s.append("-");
		}

		System.out.println(" " + s + "\n");
	}


	//////////////////////////
	//						//
	//		   MENÚS		//
	//						//
	//////////////////////////

	// Mètode per mostrar les opcions d'un menú de manera flexible.
	protected static void opcionsMenu(String... opcions) {
		int i = 1;

		for(String opcio : opcions) {
			System.out.println(" (" + i + ") " + opcio.trim());
			i++;
		}
	}

	// Mètode per mostrar el menú principal.
	protected static void menuPrincipal() {
		int opcio = 0;

		do {
			IU.titol("Mastermind", "v2.0");
			IU.opcionsMenu("Nova Partida", "Historial Partides", "Instruccions", "Sortir");
			opcio = Entrada.enter("Opció");

			switch(opcio) {
			case 1:
				Joc.novaPartida();
				break;
			case 2:
				Logica.historialPartides();
				break;
			case 3:
				menuInstruccions();
				break;
			case 4:
				Joc.sortir();
				return;
			default:
				missatgeError("Opció no vàlida");
				break;
			}

		} while(opcio != 4);
	}

	// Mètode per mostrar el menú de dificultat del joc.
	protected static void menuDificultat(Partida partida) {
		/* 
		 * Dificultats del joc:
		 * -> Principiant: el resultat de cada tirada mostrarà els acerts (cercle blanc o negre) i els falls (creu)
		 * en el mateix ordre que la combinació introduïda pel jugador, és a dir, cada índex correspondrà a la mateixa posició.
		 * -> Avançat: el resultat de la tirada no es mostrarà de manera ordenada, per tant, els índexs no coincidiràn.
		 * -> Expert: el mateix que l'avançat, amb l'afegit que hi ha 3 colors adicionals, la combinació és de 6 colors 
		 * en lloc de 4, i es tindrà un màxim de 10 intents en lloc de 16.
		 * 
		 */
		while(true) {
			titol("Dificultat", "");
			opcionsMenu("Principiant", "Avançat", "Expert");
			int opcio = Entrada.enter("Opció");

			switch(opcio) {
			case 1:
				partida.setDificultat(Dificultats.PRINCIPIANT);
				return;
			case 2:
				partida.setDificultat(Dificultats.AVANCAT);
				return;
			case 3:
				partida.setDificultat(Dificultats.EXPERT);
				partida.setMaxCombinacioColors(6);
				partida.setIntentsRestants(10);
				return;
			default:
				missatgeError("Dificultat no vàlida");
				break;
			}
		}
	}

	// Mètode per mostrar el menú d'instruccions.
	protected static void menuInstruccions() {
		int opcio = 0;

		do {
			titol("Instruccions", "");
			opcionsMenu("Objectiu", "Tirades", "Colors", "Resultat", "Puntuació", "Rècord de punts", "Guanyar o perdre", "Dificultat", "Tornar enrere");
			opcio = Entrada.enter("Opció");

			switch(opcio) {
			case 1:
				missatge("OBJECTIU: L'objectiu del joc és endevinar la combinació de"
						+ "\n colors secreta (generada de manera aleatòria per la màquina)"
						+ "\n dins d'un rang d'intents (per defecte son 16 intents).");
				break;
			case 2:
				missatge("TIRADES: El joc es desenvolupa en una sèrie de tirades. En"
						+ "\n cada tirada hauràs d'intentar endevinar la combinació secreta"
						+ "\n de colors.");
				break;
			case 3:
				missatge("COLORS: Principalment, les combinacions de colors constaran"
						+ "\n de 4 colors, on es podran repetir. Els colors disponibles es"
						+ "\n mostraran a l'inici de cada partida, amb la seva respectiva"
						+ "\n lletra, i depenent de la dificultat triada, podran variar en"
						+ "\n número.");
				break;
			case 4:
				missatge("RESULTAT: Després de cada intent, la màquina proporcionarà"
						+ "\n un resultat segons la precisió de l'intent del jugador.\n"
						+ "\n Aquest resultat constarà dels següents símbols:"
						+ "\n ▪ Un cercle blanc indicarà que hi ha un color correcte, però"
						+ "\n   en una posició incorrecta."
						+ "\n ▪ Un cercle negre indicarà que hi ha un color correcte en"
						+ "\n   una posició correcta."
						+ "\n ▪ Una creu indicarà que el color no està en la combinació"
						+ "\n   secreta.");
				break;
			case 5:
				missatge("PUNTUACIÓ: Després de cada tirada, el jugador podrà guanyar"
						+ "\n punts en funció de la precisió del seu intent. Els punts"
						+ "\n acumulats es mantindran al llarg de la partida.\n"
						+ "\n La puntuació es determinarà de la següent manera:"
						+ "\n ▪ Per cada cercle blanc, el jugador obtindrà 1 punt."
						+ "\n ▪ Per cada cercle negre, el jugador aconseguirà 2 punts."
						+ "\n ▪ Les creus no sumaran ni restaran punts.\n"
						+ "\n Al final de la partida, es sumarà el total de punts.\n"
						+ "\n Si el jugador aconsegueix endevinar la combinació secreta"
						+ "\n dins del nombre d'intents especificat, conservarà els punts"
						+ "\n acumulats. No obstant això, si esgota tots els intents sense"
						+ "\n endevinar la combinació, perdrà tots els punts acumulats.");
				
				break;
			case 6:
				missatge("RÈCORD DE PUNTS: Els jugadors podran intentar batre el rècord"
						+ "\n de punts. Per fer-ho hauran d'obtenir la quantitat més gran"
						+ "\n possible de punts en una partida.");
				break;
			case 7:
				missatge("GUANYAR O PERDRE: Si el jugador aconsegueix endevinar la"
						+ "\n combinació secreta dins del nombre d'intents especificat,"
						+ "\n guanyarà la partida. En canvi, si esgota tots els intents"
						+ "\n sense endevinar la combinació, perdrà tant la partida com"
						+ "\n tots els punts acumulats fins el moment.");
				break;
			case 8:
				missatge("PRINCIPIANT: És la dificultat més senzilla. Després de cada"
						+ "\n tirada, veuràs els encerts i els errors en el mateix ordre"
						+ "\n que la combinació intentada. Això significa que cada índex"
						+ "\n correspondrà a la mateixa posició en la qual has col·locat"
						+ "\n els colors. Aquesta opció és ideal per jugar de manera més"
						+ "\n intuïtiva.");

				missatge("AVANÇAT: És el mode original del joc. Aquí, el resultat"
						+ "\n de cada tirada no es mostrarà en el mateix ordre que"
						+ "\n introdueixis els colors. Els índexs no coincidiran amb les"
						+ "\n posicions de la teva combinació, la qual cosa afegeix un"
						+ "\n desafiament addicional al joc.");

				missatge("EXPERT: És la màxima dificultat. És similar al mode avançat"
						+ "\n però amb algunes diferències a destacar. A més que el"
						+ "\n resultat no es mostrarà en ordre, s'agregaran tres colors"
						+ "\n addicionals, la combinació passarà a ser de 6 colors en"
						+ "\n lloc de 4 i es redueixen els intents a 10 en lloc de 16."
						+ "\n En aquest mode podràs demostrar la teva habilitat com a"
						+ "\n vertader professional del Mastermind.");
				break;
			case 9:
				return;
			default:
				missatgeError("Opció no vàlida");
				break;
			}

		} while(opcio != 9);
	}


	//////////////////////////
	//						//
	//	 SORTIDES DE TEXT	//
	//						//
	//////////////////////////

	protected static void titol(String t, String s) {
		separador();
		String mostrar_s = s != null && !s.trim().isEmpty() ? ": " + s : "";
		System.out.println(" " + t.toUpperCase() + mostrar_s + "\n");
	}

	public static void missatge(String missatge) {
		System.out.println("\n " + missatge);
	}

	public static void missatgeSeguit(String missatge) {
		System.out.print(" " + missatge);
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


	//////////////////////////
	//						//
	//	  ALTRES MÈTODES	//
	//						//
	//////////////////////////

	// Mètode per mostrar la llista de tirades de tota la partida.
	protected static void historialTirades(Partida partida) {
		missatge("👤 Jugador: " + partida.getNomJugador());
		missatge("📊 Dificultat: " + partida.getDificultat());
		missatge("🏆 Resultat: " + partida.getResultatPartida());
		missatge("🎲 Intents: " + partida.getLlistaTirades().size());
		missatge("🏅 Punts: " + partida.getPuntuacio() + (partida.isPuntuacioRecord()? " (rècord)" : "") + "\n");

		for (Tirada tirada : partida.getLlistaTirades()) {
			missatge("TIRADA " + tirada.getIdTirada());
			missatge("Combinació:	" + Logica.imprimirColors(tirada.getCombinacioIntentada(), 0, partida));
			missatge("Resultat:	" + Logica.imprimirColors(tirada.getResultatTirada(), 1, partida));
			missatge("Puntuació:\t" + tirada.getPuntuacioTirada() + "\n");
		}
	}

	// Mètode per mostrar la llista de colors disponibles (depenent de la dificultat).
	protected static void llistaColors(Partida partida) {
		System.out.println();
		missatgeSeguit(Partida.VERMELL + ": " + TEXT_VERMELL + CERCLE + TEXT_RESET + " ");
		missatgeSeguit(Partida.VERD + ": " + TEXT_VERD + CERCLE + TEXT_RESET + " ");
		missatgeSeguit(Partida.BLAU + ": " + TEXT_BLAU + CERCLE + TEXT_RESET + " ");
		missatgeSeguit(Partida.GROC + ": " + TEXT_GROC + CERCLE + TEXT_RESET + " ");
		missatgeSeguit(Partida.MAGENTA + ": " + TEXT_MAGENTA + CERCLE + TEXT_RESET + " ");
		missatgeSeguit(Partida.CIAN + ": " + TEXT_CIAN + CERCLE + TEXT_RESET + " ");

		if(partida.getDificultat().equals(Dificultats.EXPERT)) {
			missatgeSeguit(Partida.ROSA + ": " + TEXT_ROSA + CERCLE + TEXT_RESET + " ");
			missatgeSeguit(Partida.NEGRE + ": " + TEXT_NEGRE + CERCLE + TEXT_RESET + " ");
			missatgeSeguit(Partida.BLANC + ": " + TEXT_BLANC + CERCLE + TEXT_RESET + " ");
		}

		System.out.println();
	}

}
