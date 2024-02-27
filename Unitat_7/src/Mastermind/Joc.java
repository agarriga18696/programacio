package Mastermind;

import java.util.Arrays;

public class Joc {

	private static final int INTENTS_MAX = 16;
	private static int intentsRestants = INTENTS_MAX;
	private static boolean partidaFinalitzada = false;

	public static void main(String[] args) {

		menuPrincipal();

	}

	// Mètode per mostrar el menú.
	private static void menuPrincipal() {

		while(true) {

			IU.separador();
			IU.title("Mastermind");
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

	private static void novaPartida() {
		boolean partidaValida = false;
		String nom = null; 

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
		IU.title("Nova Partida");

		IU.missatge("Combinació secreta: " + Arrays.toString(partida.getCombinacioSecreta()));

		// Condicions per acabar la partida:
		// -> No tenir més intents (has perdut).
		// -> Haver endevinat la combinació de l'ordinador (has guanyat).
		while(intentsRestants > 1 && !partidaFinalitzada) {
			
			IU.missatge("Intents restants: " + intentsRestants);

			// Anar demanant al Jugador que introdueixi els colors.
			Character[] combinacioIntentada = demanarColors();

			IU.saltLinia();
			IU.missatge("Combinació intentada: " + imprimirColors(combinacioIntentada, 0));

			// Crear nova tirada.
			Tirada tirada = new Tirada(combinacioIntentada);
			
			// Afegir la tirada a la llista de tirades.
			partida.getLlistaTirades().add(tirada);
			intentsRestants--; // Restar 1 als intents.

			// Comprovar la tirada.
			Character[] resultatTirada = partida.comprovarTirada(tirada);
			
			IU.missatge("Tirada: " + imprimirColors(resultatTirada, 1));
			
			comprovarResultat(resultatTirada);

		}

	}
	
	private static String imprimirColors(Character[] combinacio, int opcio) {
		String[] colors = new String[4];
		
		// Colors de la combinació.
		if(opcio == 0) {
			for(int i = 0; i < combinacio.length; i++) {
				if(combinacio[i] != null) {
					switch(combinacio[i]) {
					case 'R':
						colors[i] = IU.VERMELL + IU.CERCLE + IU.RESET;
						break;
					case 'B':
						colors[i] = IU.BLAU + IU.CERCLE + IU.RESET;
						break;
					case 'G':
						colors[i] = IU.VERD + IU.CERCLE + IU.RESET;
						break;
					case 'M':
						colors[i] = IU.MAGENTA + IU.CERCLE + IU.RESET;
						break;
					case 'Y':
						colors[i] = IU.GROC + IU.CERCLE + IU.RESET;
						break;
					case 'C':
						colors[i] = IU.CIAN + IU.CERCLE + IU.RESET;
						break;
					default:
						System.err.println("Error al iterar sobre un valor desconegut.");
						break;
					}
				}
				
				if(combinacio[i] == null) {
					colors[i] = " ";
				}
			}
			
		} else if(opcio == 1) { // Colors Tirada B / W.
			for(int i = 0; i < combinacio.length; i++) {
				if(combinacio[i] != null) {
					switch(combinacio[i]) {
					case 'B':
						colors[i] = IU.NEGRE + IU.CERCLE + IU.RESET;
						break;
					case 'W':
						colors[i] = IU.BLANC + IU.CERCLE + IU.RESET;
						break;
					default:
						System.err.println("Error al iterar sobre un valor desconegut.");
						break;
					}
				}
				
				if(combinacio[i] == null) {
					colors[i] = " ";
				}
			}
		}
		
		return Arrays.toString(colors);
	}

	private static void comprovarResultat(Character[] resultatTirada) {
		
		boolean victoria = true;
		
		for(Character i : resultatTirada) {
			if(i != null && !i.equals('B')) {
				victoria = false;
				break;
				
			} else if(i == null) {
				victoria = false;
				break;
			}
		}
		
		if(victoria) {
			IU.missatge("\nHas guanyat! Has endivinat la combinació exacta!");
			partidaFinalitzada = true;
		}
		
	}

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
					IU.missatge("- Vermell: R");
					IU.missatge("- Verd:    G");
					IU.missatge("- Blau:    B");
					IU.missatge("- Groc:    Y");
					IU.missatge("- Magenta: M");
					IU.missatge("- Cian:    C");

				} else {
					break;
				}
			}
		}
		
		return combinacioIntentada;

	}

	private static boolean validarColorEntrada(Character c) {

		char color = Character.toUpperCase(c);

		// Comprovar si el color introduït és un color vàlid.
		if (color == 'R' || color == 'G' || color == 'B' ||
				color == 'Y' || color == 'M' || color == 'C') {
			return true;
		} else {
			return false;
		}

	}

	private static void sortir() {

		IU.separador();
		IU.missatge("Fins una altra! 👋");
		IU.saltLinia();

		System.exit(0);

	}


}
