package Joc;

import IU.Missatge;
import Utilitat.Normalitzar;
import Utilitat.Validar;
import Paraules.Paraules;

public class Logica {

	// Mètode per demanar una lletra al jugador.
	protected static void demanarLletra(Jugador jugador) {
		String lletra = null;

		lletra = Normalitzar.llevarAccents(Validar.lletra("Lletra")).toUpperCase();

		boolean lletraEncertada = comprovarSiParauleConteLletra(lletra);

		if (lletraEncertada) {
			Missatge.Personalitzat("👍", "Acert", "'" + lletra + "' s'ha trobat a la paraula");
			// Sumar punts.
			jugador.sumarPunts();
		} else {
			Missatge.Personalitzat("👎", "Fall", "'" + lletra + "' no s'ha trobat a la paraula");
			jugador.restarVides();
			Paraules.llistaLletresFallades.add(lletra);
		}
	}

	// Mètode per comprovar les condicions de victoria i derrota.
	protected static boolean comprovarVictoriaDerrota(String paraulaAmagada, Jugador jugador) {
		// Comprovar si s'ha endevinat la paraula.
		if (paraulaEndevinada(paraulaAmagada)) {
			Missatge.Personalitzat("🏆", "Victoria", "Has encertat la paraula");
			return true;
		}

		// Comprovar si s'ha quedat sense vides.
		if (jugador.getVides() <= 0) {
			Missatge.Personalitzat("💔", "Derrota", "T'has quedat sense vides");
			return true;
		}

		return false;
	}

	// Mètode per mostrar la paraula amagada amb espais.
	protected static String mostrarParaulaAmbEspais(String paraulaAmagada) {
		StringBuilder paraulaAmagadaAmbEspais = new StringBuilder();

		for(int i = 0; i < paraulaAmagada.length(); i++) {
			paraulaAmagadaAmbEspais.append(paraulaAmagada.charAt(i) + " ");
		}

		return paraulaAmagadaAmbEspais.toString();

	}

	// Mètode per comprovar si la paraula conté la lletra que l'usuari ha introduït.
	protected static boolean comprovarSiParauleConteLletra(String lletraString) {
		String paraulaEndevinar = JocPenjat.paraulaActualNormalitzada;
		String lletra = lletraString;
		char lletraChar = lletra.charAt(0);
		boolean lletraEncertada = false;

		// Verificar que la lletra introduïda pel jugador hi sigui a la paraula a encertar.
		for(int i = 0; i < paraulaEndevinar.length(); i++) {
			if(paraulaEndevinar.charAt(i) == lletraChar) {
				// Reemplaçar els guions '_' per la lletra endevinada.
				reemplacarLletra(lletraChar, i);
				lletraEncertada = true;
			}
		}

		return lletraEncertada;
	}

	// Mètode per reemplaçar el guió '_' per la lletra encertada.
	private static void reemplacarLletra(char lletra, int posicio) {
		String paraulaAmagada = JocPenjat.paraulaAmagada;
		StringBuilder novaParaulaAmagada = new StringBuilder(paraulaAmagada);

		novaParaulaAmagada.setCharAt(posicio, lletra);

		// Actualitzar la paraula amagada amb la lletra revelada.
		JocPenjat.actualitzarLletraAmagada(novaParaulaAmagada.toString());
	}

	// Mètode per convertir la paraula a '_'.
	protected static String amagarParaula(String paraula) {
		String paraulaAmagada = "";

		if(paraula != null && !paraula.isEmpty()) {
			for(int i = 0; i < paraula.length(); i++) {
				paraulaAmagada = paraulaAmagada + "_";
			}
		}

		return paraulaAmagada;

	}

	// Validar si has endevinat la paraula.
	protected static boolean paraulaEndevinada(String paraulaAmagada) {
		boolean paraulaEndevinada = false;

		for(int i = 0; i < paraulaAmagada.length(); i++) {
			if(!paraulaAmagada.contains("_")) {
				paraulaEndevinada = true;
			}
		}

		return paraulaEndevinada;
	}

}
