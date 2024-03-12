package Mastermind_v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Mastermind_v2.Partida.Dificultats;

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
		IU.menuPrincipal();

		// Tancar entrada.
		Entrada.in.close();
	}

	// Mètode per iniciar una nova partida.
	protected static void novaPartida() {
		// Crear objecte partida.
		Partida partida = new Partida();
		// Reiniciar variables per pròximes partides.
		Tirada.numTirada = 1; // contador de tirades.
		partida.setIntentsRestants(Partida.MAX_INTENTS);
		partida.setPuntuacio(0);

		// Seleccionar la dificultat del joc.
		IU.menuDificultat(partida);

		// Crear la combinació de colors secreta.
		partida.crearCombinacio();

		// Demanar el nom del jugador.
		partida.setNomJugador(Logica.definirJugador());

		IU.titol("Nova Partida (Jugador: " + partida.getNomJugador() + " | " + "Dificultat: " + partida.getDificultat() + ")", null);

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
	protected static void sortir() {
		IU.separador();
		IU.missatge("Fins a una altra! 👋");
		IU.saltLinia();
		System.exit(0);
	}

}
