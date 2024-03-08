package Mastermind;

import Mastermind.Partida.Dificultats;

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
			missatge("Resultat:	" + Logica.imprimirColors(tirada.getResultatTirada(), 1, partida) + "\n");
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

	// Mètode per mostrar les instruccions del joc.
	protected static void instruccions() {
		titol("Instruccions", "Partida");
		missatge("OBJECTIU: L'objectiu principal del joc és endevinar la"
				+ "\n combinació de colors secreta generada de manera aleatoria"
				+ "\n per la màquina.");
		
		missatge("TIRADES: El joc es desenvolupa en una sèrie de tirades. En"
				+ "\n cada tirada hauràs d'intentar adivinar la combinació secreta"
				+ "\n de colors.");
		
		missatge("COLORS: Principalment, les combinacions de colors constaràn"
				+ "\n de 4 colors, on es poden repetir. Els colors disponibles es"
				+ "\n mostraràn a l'inici de cada partida, amb la seva respectiva"
				+ "\n lletra, i depenent de la dificultat triada podràn canviar.");
		
		missatge("RESULTAT: Desrpés de cada intent, la màquina proporcionarà"
				+ "\n un resultat segons la precisió de l'intent per part del."
				+ "\n jugador. Aquest resultat constarà dels següents símbols:"
				+ "\n Un cercle blanc indicarà que hi ha un color correcte, però"
				+ "\n en una posició incorrecta."
				+ "\n Un cercle negre indicarà que hi ha un color correcte en una"
				+ "\n posició correcta."
				+ "\n Una creu indicarà que el color no està en la combinació"
				+ "\n secreta.");
		
		missatge("PUNTUACIÓ: Després de cada tirada, el jugador acumularà"
				+ "\n punts en funció de la precisió del seu intent. La puntuació"
				+ "\n es determinarà de la següent manera:"
				+ "\n Per cada cercle blanc, el jugador obtindrà 1 punt."
				+ "\n Per cada cercle negre, el jugador obtindrà 3 punts."
				+ "\n Les creus no sumaran ni restaran punts."
				+ "\n Els punts acumulats es mantindràn al llarg de la partida."
				+ "\n Al final de la partida, es multiplicarà el total de punts"
				+ "\n pel nombre restant d'intents. D'aquesta manera, si el"
				+ "\n jugador encerta la combinació en pocs intents, podrà guanyar"
				+ "\n més punts que si l'encerta en molts intents."
				+ "\n Si el jugador aconsegueix endevinar la combinació secreta"
				+ "\n dins del nombre d'intents especificat, conservarà els punts"
				+ "\n acumulats. No obstant això, si esgota tots els intents sense"
				+ "\n endevinar la combinació, perdrà tots els punts acumulats.");
		
		missatge("GUANYAR O PERDRE: Si el jugador aconsegueix endevinar la"
				+ "\n combinació secreta dins del nombre d'intents especificat,"
				+ "\n guanyarà la partida. En canvi, si esgota tots els intents"
				+ "\n sense endevinar la combinació, perdrà.");
		
		missatge("RÈCORD DE PUNTS: Els jugadors podràn intentar batre el rècord"
				+ "\n de punts, intentant obtenir la major quantitat possible de"
				+ "\n punts en una partida.");
		
		titol("Instruccions", "Dificultat");
		missatge("PRINCIPIANT: És la dificultat més senzilla. Després de cada"
				+ "\n tirada, veuràs els acerts i els errors en el mateix ordre"
				+ "\n que la combinació intentada. Això significa que cada índex"
				+ "\n correspondrà a la mateixa posició en la que has colocat"
				+ "\n els colors. Aquesta opció és ideal per jugar de manera més"
				+ "\n intuitiva.");
		
		missatge("AVANÇAT: És el mode original del joc. Aquí, el resultat"
				+ "\n de cada tirada no es mostrarà en el mateix ordre que"
				+ "\n introdueixis els colors. Els índex no coincidiràn amb les"
				+ "\n posicions de la teva combinació, la qual cosa afegeix un"
				+ "\n desafiament addicional al joc.");
		
		missatge("EXPERT: És la màxima dificultat. És similar al mode avançat"
				+ "\n però amb algunes diferències a destacar. A més de que el"
				+ "\n resultat no es mostrarà en ordre, s'agreguen tres colors"
				+ "\n addicionals, la combinació passarà a ser de 6 colors en"
				+ "\n lloc de 4 i es redueixen els intents a 10 en lloc de 16."
				+ "\n En aquest mode podràs demostrar la teva habilitat com a"
				+ "\n vertader professional del Mastermind.");
	}

}
