package Mastermind;

import java.util.Arrays;

import Mastermind.Joc.Dificultats;

public class Logica {

	//////////////////////////
	//						//
	//		  PARTIDA		//
	//						//
	//////////////////////////

	// Mètode per comprovar el resultat de la tirada.
	protected static boolean comprovarResultat(Character[] resultatTirada) {
		for(Character i : resultatTirada) {
			if(i != null && !i.equals(Partida.NEGRE)) {
				return false;

			} else if(i == null) {
				return false;
			}
		}

		return true;
	}

	// Mètode per demanar l'entrada de colors al jugador.
	protected static Character[] demanarColors(Partida partida) {
		Character[] combinacioIntentada = new Character[partida.getMaxCombColors()];

		for(int i = 0; i < partida.getMaxCombColors(); i++) {
			boolean colorCorrecte = false;

			while(!colorCorrecte) {
				combinacioIntentada[i] = Entrada.cadena("Color " + (i + 1)).toUpperCase().charAt(0);

				colorCorrecte = validarColorEntrada(combinacioIntentada[i], partida);

				if(!colorCorrecte) {
					IU.missatgeError("El color introduït no és vàlid");
					IU.missatge("Els colors vàlids son:");
					IU.llistaColors(partida);
				} else {
					break;
				}
			}
		}

		return combinacioIntentada;
	}

	// Mètode per validar que el color (char) introduït pel jugador sigui vàlid.
	protected static boolean validarColorEntrada(Character c, Partida partida) {
		char color = Character.toUpperCase(c);

		if(!partida.getDificultat().equals(Dificultats.EXPERT) && (color == Partida.VERMELL || color == Partida.BLAU || color == Partida.VERD ||
				color == Partida.GROC || color == Partida.MAGENTA || color == Partida.CIAN)) {
			return true;

		} else if(partida.getDificultat().equals(Dificultats.EXPERT) && (color == Partida.VERMELL || color == Partida.BLAU || color == Partida.VERD ||
				color == Partida.GROC || color == Partida.MAGENTA || color == Partida.CIAN || color == Partida.ROSA || 
				color == Partida.NEGRE || color == Partida.BLANC)) {
			return true;

		} else {
			return false;
		}
	}

	// Mètode per mostrar el missatge de victoria o derrota.
	protected static void resultatPartida(boolean partidaFinalitzada, boolean combinacioEndevinada, Partida partida) {
		if(partidaFinalitzada && combinacioEndevinada) {
			IU.missatge("🏆 Has guanyat! Has endivinat la combinació!");
			partida.setResultatPartida("Victòria");

		} else if(partidaFinalitzada && partida.getIntentsRestants() <= 0){
			IU.missatge("💔 Has perdut... T'has quedat sense intents.");
			IU.missatge("La combinació era: " + Logica.imprimirColors(partida.getCombinacioSecreta(), 0, partida));
			partida.setResultatPartida("Derrota");
		}

		IU.saltLinia();
	}

	// Mètode per mostrar l'historial de partides.
	protected static void historialPartides() {	
		int i = 0;

		// Mostrar l'historial de tirades.
		if(Joc.llistaPartides.size() > 0) { // Comprovar si existeixen partides.
			for(Partida partida : Joc.llistaPartides) {
				IU.separador();
				IU.titol("Resum de la partida " + (i + 1) + ":");
				IU.historialTirades(partida);
				IU.saltLinia();
				i++;
			}
		} else {
			IU.missatgeAdvertencia("No s'ha trobat cap partida registrada");
		}
	}


	//////////////////////////
	//						//
	//	  COLORS CERCLES	//
	//						//
	//////////////////////////

	// Mètode per imprimir els cercles de colors per pantalla.
	protected static String imprimirColors(Character[] combinacio, int opcio, Partida partida) {
		String[] colors = new String[partida.getMaxCombColors()];

		// Colors de la combinació de la tirada.
		if(opcio == 0) {
			for(int i = 0; i < partida.getMaxCombColors(); i++) {
				if(combinacio[i] != null) {
					// Switch 1
					// Imprimir els cercles segons el color.
					switch(combinacio[i]) {
					case Partida.VERMELL:
						colors[i] = IU.TEXT_VERMELL + IU.CERCLE + IU.TEXT_RESET;
						break;
					case Partida.BLAU:
						colors[i] = IU.TEXT_BLAU + IU.CERCLE + IU.TEXT_RESET;
						break;
					case Partida.VERD:
						colors[i] = IU.TEXT_VERD + IU.CERCLE + IU.TEXT_RESET;
						break;
					case Partida.MAGENTA:
						colors[i] = IU.TEXT_MAGENTA + IU.CERCLE + IU.TEXT_RESET;
						break;
					case Partida.GROC:
						colors[i] = IU.TEXT_GROC + IU.CERCLE + IU.TEXT_RESET;
						break;
					case Partida.CIAN:
						colors[i] = IU.TEXT_CIAN + IU.CERCLE + IU.TEXT_RESET;
						break;
					case Partida.ROSA:
						colors[i] = IU.TEXT_ROSA + IU.CERCLE + IU.TEXT_RESET;
						break;
					case Partida.NEGRE:
						colors[i] = IU.TEXT_NEGRE + IU.CERCLE + IU.TEXT_RESET;
						break;
					case Partida.BLANC:
						colors[i] = IU.TEXT_BLANC + IU.CERCLE + IU.TEXT_RESET;
						break;
					default:
						IU.missatgeErrorCritic("Error en el mètode 'imprimirColors' de la classe 'Logica' al intentar "
								+ "iterar sobre un valor desconegut en el 'switch 1'.");
						break;
					}

				} else {
					// Si el valor és null (color incorrecte) imprimirà una creu.
					colors[i] = Character.toString(IU.CREU);
				}
			}

		} else if(opcio == 1) { // Colors del resultat de la tirada.
			for(int i = 0; i < combinacio.length; i++) {
				if(combinacio[i] != null) {
					// Switch 2
					// Imprimir els cercles segons el color.
					switch(combinacio[i]) {
					case Partida.NEGRE:
						colors[i] = IU.TEXT_NEGRE + IU.CERCLE + IU.TEXT_RESET;
						break;
					case Partida.BLANC:
						colors[i] = IU.TEXT_BLANC + IU.CERCLE + IU.TEXT_RESET;
						break;
					default:
						IU.missatgeErrorCritic("Error en el mètode 'imprimirColors' de la classe 'Logica' al intentar "
								+ "iterar sobre un valor desconegut en el 'switch 2'.");
						break;
					}

				} else {
					// Si el valor és null (color incorrecte) imprimirà una creu.
					colors[i] = Character.toString(IU.CREU);
				}
			}
		}

		return Arrays.toString(colors);
	}


}
