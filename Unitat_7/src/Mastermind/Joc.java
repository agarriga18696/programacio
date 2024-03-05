package Mastermind;

import java.util.Arrays;

/**
 * 
 * MASTERMIND
 * 
 * @author Andreu Garriga
 * 
 */

public class Joc {

	private static final int INTENTS_MAX = 16;
	public static int intentsRestants = INTENTS_MAX;

	public static void main(String[] args) {
		menuPrincipal();
	}

	// Mètode per mostrar el menú principal.
	private static void menuPrincipal() {

		do {
			IU.separador();
			IU.titol("Mastermind");
			IU.opcionsMenu("Nova Partida", "Sortir");
			int opcio = Entrada.enter("Opció");

			switch(opcio) {
			case 1:
				novaPartida();
				return;
			case 2:
				sortir();
				return;
			default:
				IU.missatgeError("Opció no vàlida");
				break;
			}

		} while(true);
	}

	// Mètode per seleccionar la dificultat del joc.
	private static void seleccionarDificultat(Partida partida) {
		/*
		 * Característiques de les dificultats:
		 * 
		 * -> PRINCIPIANT: el resultat de cada tirada, mostrarà els acerts (cercle blanc o negre) i els falls (creu)
		 * en el mateix ordre que la combinació introduïda pel jugador, és a dir, cada índex correspondrà a la mateixa posició.
		 * D'aquesta manera el joc és més intuitiu i senzill.
		 * 
		 * -> AVANÇAT: el resultat de la tirada no es mostrarà de manera ordenada, per tant, els índexs no coincidiràn.
		 * 
		 * -> EXPERT: el mateix que l'avançat, amb l'afegit que hi ha 3 colors adicionals i que la combinació és de 6 colors enlloc de 4.
		 * 
		 */

		boolean dificultatValida = false;

		do {
			IU.separador();
			IU.titol("DIFICULTAT");
			IU.opcionsMenu("Principiant", "Avançat", "Expert");
			int opcio = Entrada.enter("Opció");

			switch(opcio) {
			case 1:
				partida.setDificultat("Principiant");
				return;
			case 2:
				partida.setDificultat("Avançat");
				return;
			case 3:
				partida.setDificultat("Expert");
				partida.setMaxCombColors(6); // les combinacions seràn de 6 colors.
				return;
			default:
				IU.missatgeError("Dificultat no vàlida");
				break;
			}

		} while(!dificultatValida);

	}

	// Mètode per iniciar una nova partida.
	private static void novaPartida() {
		// Crear objecte partida.
		Partida partida = new Partida();

		// Seleccionar la dificultat del joc.
		seleccionarDificultat(partida);

		// Crear la combinació de colors secreta.
		partida.crearCombinacio();

		// Demanar el nom del jugador.
		boolean jugadorValid = false;
		String nomJugador = null;
		do {
			IU.separador();
			IU.titol("JUGADOR");
			nomJugador = Entrada.cadena("Nom").trim().toUpperCase();

			if(nomJugador.isEmpty() || nomJugador == null) {
				IU.missatgeError("El nom del Jugador no pot estar en blanc");
			} else {
				jugadorValid = true;
			}

		} while(!jugadorValid);

		partida.setNomJugador(nomJugador);

		IU.separador();
		IU.titol("Nova Partida (Jugador: " + partida.getNomJugador() + " | " + "Dificultat: " + partida.getDificultat() + ")");

		// Mostrar la combinació secreta (només per proves).
		//IU.missatge("Combinació secreta: " + Arrays.toString(partida.getCombinacioSecreta()));

		/*
		 * Condicions per acabar la partida:
		 * -> Haver endevinat la combinació secreta (victòria).
		 * -> No tenir més intents (derrota).
		 *
		 */
		boolean partidaFinalitzada = false, combinacioEndevinada = false;

		while(!partidaFinalitzada) {
			// Crear una nova tirada.
			Tirada tirada = new Tirada();

			// Mostrar els colors disponibles.
			IU.missatge("Colors disponibles:");
			IU.llistaColors(partida);

			IU.missatge("TIRADA " + tirada.getIdTirada() + " (intents restants: " + intentsRestants + ")");

			// Anar demanant al Jugador que introdueixi els colors.
			Character[] combinacioIntentada = Logica.demanarColors(partida);
			// Afegir la combinació intentada a la tirada.
			tirada.setCombinacioIntentada(combinacioIntentada);

			IU.missatge("Combinació:\t" + Logica.imprimirColors(combinacioIntentada, 0, partida));

			// Afegir la tirada a la llista de tirades.
			partida.getLlistaTirades().add(tirada);
			intentsRestants--;

			// Comprovar la tirada i mostrar el resultat.
			tirada.setRespostaOrdinador(partida.comprovarTirada(tirada));
			IU.missatge("Resultat:\t" + Logica.imprimirColors(tirada.getRespostaOrdinador(), 1, partida));
			IU.saltLinia();

			// Comprovar si s'ha endevinat la combinació secreta.
			combinacioEndevinada = Logica.comprovarResultat(tirada.getRespostaOrdinador());

			// Comprovar les condicions de victoria i derrota.
			if(combinacioEndevinada) partidaFinalitzada = true;
			if(intentsRestants <= 0) partidaFinalitzada = true;
		}

		// Mostrar l'historial de tirades.
		IU.titol("Resum de la partida:");
		IU.historialTirades(partida);

		// Mostrar missatge de victoria o derrota.
		resultatPartida(partidaFinalitzada, combinacioEndevinada, partida);
	}

	// Mètode per mostrar el missatge de victoria o derrota.
	private static void resultatPartida(boolean partidaFinalitzada, boolean combinacioEndevinada, Partida partida) {
		if(partidaFinalitzada && combinacioEndevinada) {
			IU.missatge("🏆 Has guanyat! Has endivinat la combinació!");

		} else if(partidaFinalitzada && Joc.intentsRestants <= 0){
			IU.missatge("💔 Has perdut... T'has quedat sense intents.");
			IU.missatge("La combinació era: " + Logica.imprimirColors(partida.getCombinacioSecreta(), 0, partida));
		}

		IU.saltLinia();
	}

	// Mètode per sortir del joc.
	private static void sortir() {
		IU.separador();
		IU.missatge("Fins una altra! 👋");
		IU.saltLinia();
		System.exit(0);
	}


}
