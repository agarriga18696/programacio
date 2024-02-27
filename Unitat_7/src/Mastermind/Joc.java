package Mastermind;

import java.util.Arrays;

public class Joc {

	private static final int INTENTS_MAX = 16;
	private static int intentsRestants = INTENTS_MAX;
	private static boolean combinacioEndevinada = false;

	public static void main(String[] args) {
		menuPrincipal();
	}

	// Mètode per mostrar el menú.
	private static void menuPrincipal() {

		while(true) {
			IU.separador();
			IU.titol("Mastermind");
			IU.menu("Nova Partida", "Sortir");
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
		}
	}

	// Mètode per iniciar una nova pa rtida.
	private static void novaPartida() {
		boolean partidaValida = false;
		String nom = null; 

		// Demanar el nom del jugador.
		do {
			nom = Entrada.cadena("Nom Jugador").trim().toUpperCase();

			if(nom.isEmpty() || nom == null) {
				IU.missatgeError("El nom del Jugador no pot estar en blanc");
			} else {
				partidaValida = true;
			}

		} while(!partidaValida);

		// Crear objecte partida.
		Partida partida = new Partida(nom);

		IU.separador();
		IU.titol("Nova Partida");

		//IU.missatge("Combinació secreta: " + Arrays.toString(partida.getCombinacioSecreta()));

		// Condicions per acabar la partida:
		// -> Haver endevinat la combinació secreta (victòria).
		// -> No tenir més intents (derrota).
		boolean partidaFinalitzada = false;
		while(!partidaFinalitzada) {
			
			IU.missatge("Intents restants: " + intentsRestants);

			// Anar demanant al Jugador que introdueixi els colors.
			Character[] combinacioIntentada = demanarColors();

			IU.saltLinia();
			IU.missatge("Combinació intentada:\n " + imprimirColors(combinacioIntentada, 0));

			// Crear nova tirada.
			Tirada tirada = new Tirada(combinacioIntentada);
			
			// Afegir la tirada a la llista de tirades.
			partida.getLlistaTirades().add(tirada);
			intentsRestants--;

			// Comprovar la tirada i mostrar el resultat.
			Character[] resultatTirada = partida.comprovarTirada(tirada);
			IU.missatge("\n Resultat tirada:\n " + imprimirColors(resultatTirada, 1));
			IU.saltLinia();
			
			// Comprovar si s'ha endevinat la combinació secreta.
			combinacioEndevinada = comprovarResultat(resultatTirada);
			
			// Comprovar les condicions de victoria i derrota.
			if(combinacioEndevinada) partidaFinalitzada = true;
			if(intentsRestants <= 0) partidaFinalitzada = true;

		}
		
		// Mostrar missatge de victoria o derrota.
		if(partidaFinalitzada && combinacioEndevinada) {
			IU.missatge("🏆 Has guanyat! Has endivinat la combinació!");
			
		} else if(partidaFinalitzada && intentsRestants <= 0){
			IU.missatge("💔 Has perdut... T'has quedat sense intents.");
			IU.missatge("La combinació secreta era:\n " + imprimirColors(partida.getCombinacioSecreta(), 0));
		}

	}
	
	// Mètode per imprimir els cercles de colors per pantalla.
	private static String imprimirColors(Character[] combinacio, int opcio) {
		String[] colors = new String[4];
		
		// Colors de la combinació.
		if(opcio == 0) {
			for(int i = 0; i < 4; i++) {
				if(combinacio[i] != null) {
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
					default:
						System.err.println(" Error al iterar sobre un valor desconegut.");
						break;
					}
				}
				
				// Valor null = espai en blanc.
				if(combinacio[i] == null) {
					colors[i] = Character.toString(IU.BUIT);
				}
			}
			
		} else if(opcio == 1) { // Colors Tirada.
			for(int i = 0; i < combinacio.length; i++) {
				if(combinacio[i] != null) {
					switch(combinacio[i]) {
					case Partida.NEGRE:
						colors[i] = IU.TEXT_NEGRE + IU.CERCLE + IU.TEXT_RESET;
						break;
					case Partida.BLANC:
						colors[i] = IU.TEXT_BLANC + IU.CERCLE + IU.TEXT_RESET;
						break;
					default:
						System.err.println(" Error al iterar sobre un valor desconegut.");
						break;
					}
				}
				
				// Valor null = espai en blanc.
				if(combinacio[i] == null) {
					colors[i] = Character.toString(IU.BUIT);
				}
			}
		}
		
		return Arrays.toString(colors);
	}

	// Mètode per comprovar el resultat de la tirada.
	private static boolean comprovarResultat(Character[] resultatTirada) {
		
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
	private static Character[] demanarColors() {
		Character[] combinacioIntentada = new Character[4];

		for(int i = 0; i < 4; i++) {
			boolean colorCorrecte = false;

			while(!colorCorrecte) {
				combinacioIntentada[i] = Entrada.cadena("Color " + (i + 1)).toUpperCase().charAt(0);
				
				colorCorrecte = validarColorEntrada(combinacioIntentada[i]);

				if(!colorCorrecte) {
					IU.missatgeError("El color introduït no és vàlid");
					IU.missatge("Els colors vàlids son:");
					IU.missatge(IU.TEXT_VERMELL + IU.CERCLE + IU.TEXT_RESET + ": " + Partida.VERMELL);
					IU.missatge(IU.TEXT_BLAU + IU.CERCLE + IU.TEXT_RESET + ": " + Partida.BLAU);
					IU.missatge(IU.TEXT_VERD + IU.CERCLE + IU.TEXT_RESET + ": " + Partida.VERD);
					IU.missatge(IU.TEXT_GROC + IU.CERCLE + IU.TEXT_RESET + ": " + Partida.GROC);
					IU.missatge(IU.TEXT_MAGENTA + IU.CERCLE + IU.TEXT_RESET + ": " + Partida.MAGENTA);
					IU.missatge(IU.TEXT_CIAN + IU.CERCLE + IU.TEXT_RESET + ": " + Partida.CIAN);

				} else {
					break;
				}
			}
		}
		
		return combinacioIntentada;

	}

	// Mètode per validar que el color (char) introduït pel jugador sigui vàlid.
	private static boolean validarColorEntrada(Character c) {
		char color = Character.toUpperCase(c);

		// Comprovar si el color introduït és un color vàlid.
		if (color == Partida.VERMELL || color == Partida.BLAU || color == Partida.VERD ||
				color == Partida.GROC || color == Partida.MAGENTA || color == Partida.CIAN) {
			return true;
		} else {
			return false;
		}

	}

	// Mètode per sortir del joc.
	private static void sortir() {
		IU.separador();
		IU.missatge("Fins una altra! 👋");
		IU.saltLinia();
		System.exit(0);
	}


}
