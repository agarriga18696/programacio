package Mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Mastermind.Partida.Dificultats;

/**
 * 
 * MASTERMIND v1.0
 * 
 * @author Andreu Garriga
 * 
 */

public class Joc {

	// Variables globals.
	protected static List<Partida> llistaPartides = new ArrayList<>();
	protected static int puntuacioRecord = 0;

	// Mètode main.
	public static void main(String[] args) {
		menuPrincipal();

		// Tancar entrada.
		Entrada.in.close();
	}

	// Mètode per mostrar el menú principal.
	private static void menuPrincipal() {
		int opcio = 0;

		do {
			IU.titol("Mastermind", "v1.0");
			IU.opcionsMenu("Nova Partida", "Historial Partides", "Instruccions", "Sortir");
			opcio = Entrada.enter("Opció");

			switch(opcio) {
			case 1:
				novaPartida();
				break;
			case 2:
				Logica.historialPartides();
				break;
			case 3:
				IU.instruccions();
				break;
			case 4:
				sortir();
				return;
			default:
				IU.missatgeError("Opció no vàlida");
				break;
			}

		} while(opcio != 4);
	}

	// Mètode per seleccionar la dificultat del joc.
	private static void seleccionarDificultat(Partida partida) {
		/* 
		 * Dificultats del joc:
		 * -> Principiant: el resultat de cada tirada mostrarà els acerts (cercle blanc o negre) i els falls (creu)
		 * en el mateix ordre que la combinació introduïda pel jugador, és a dir, cada índex correspondrà a la mateixa posició.
		 * -> Avançat: el resultat de la tirada no es mostrarà de manera ordenada, per tant, els índexs no coincidiràn.
		 * -> Expert: el mateix que l'avançat, amb l'afegit que hi ha 3 colors adicionals, la combinació és de 6 colors 
		 * en lloc de 4, i es tindrà un màxim de 10 intents en lloc de 16.
		 * 
		 */
		boolean dificultatValida = false;
		do {
			IU.titol("Dificultat", "");
			IU.opcionsMenu("Principiant", "Avançat", "Expert");
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
				IU.missatgeError("Dificultat no vàlida");
				break;
			}

		} while(!dificultatValida);
	}

	// Mètode per iniciar una nova partida.
	private static void novaPartida() {
		// Crear objecte partida.
		Partida partida = new Partida();
		// Reiniciar variables per pròximes partides.
		Tirada.numTirada = 1; // contador de tirades.
		partida.setIntentsRestants(Partida.MAX_INTENTS);
		partida.setPuntuacio(0);

		// Seleccionar la dificultat del joc.
		seleccionarDificultat(partida);

		// Crear la combinació de colors secreta.
		partida.crearCombinacio();

		// Demanar el nom del jugador.
		partida.setNomJugador(Logica.definirJugador());

		IU.titol("Nova Partida (Jugador: " + partida.getNomJugador() + " | " + "Dificultat: " + partida.getDificultat() + ")", "");

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
			IU.llistaColors(partida);

			IU.missatge("TIRADA " + tirada.getIdTirada() + " (intents restants: " + partida.getIntentsRestants() 
			+ " | punts: " + partida.getPuntuacio() + ")");

			// Anar demanant al Jugador que introdueixi els colors.
			Character[] combinacioIntentada = Logica.demanarColors(partida);
			// Afegir la combinació intentada a la tirada.
			tirada.setCombinacioIntentada(combinacioIntentada);

			IU.missatge("Combinació:\t" + Logica.imprimirColors(combinacioIntentada, 0, partida));

			// Comprovar la tirada i mostrar el resultat.
			tirada.setResultatTirada(partida.comprovarTirada(tirada));
			IU.missatge("Resultat:\t" + Logica.imprimirColors(tirada.getResultatTirada(), 1, partida));
			IU.saltLinia();

			// Comprovar si s'ha endevinat la combinació secreta.
			combinacioEndevinada = Logica.comprovarResultat(tirada.getResultatTirada(), partida);

			// Assignar la puntuació segons el resultat de la tirada.
			Logica.assignarPunts(tirada.getResultatTirada(), partida);

			// Afegir la tirada a la llista de tirades.
			partida.getLlistaTirades().add(tirada);
			// Reduir en 1 els intents restants.
			partida.setIntentsRestants(partida.getIntentsRestants() - 1);

			// Comprovar les condicions de victoria i derrota.
			if(combinacioEndevinada) partidaFinalitzada = true;
			if(partida.getIntentsRestants() <= 0) partidaFinalitzada = true;
		}

		// Emmagatzemar la partida dins de la llista de partides.
		llistaPartides.add(partida);

		// Mostrar missatge de victoria o derrota.
		Logica.resultatPartida(partidaFinalitzada, combinacioEndevinada, partida);
	}

	// Mètode per sortir del joc.
	private static void sortir() {
		IU.separador();
		IU.missatge("Fins una altra! 👋");
		IU.saltLinia();
		System.exit(0);
	}


}
