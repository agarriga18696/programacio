package Mastermind_v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Partida {

	// Constants.
	protected static final int MAX_INTENTS = 16;
	protected static final int MAX_COLORS = 9;
	protected static final char VERMELL = 'R';
	protected static final char VERD = 'G';
	protected static final char BLAU = 'B';
	protected static final char MAGENTA = 'M';
	protected static final char GROC = 'Y';
	protected static final char CIAN = 'C';
	protected static final char ROSA = 'P';
	protected static final char NEGRE = 'K';
	protected static final char BLANC = 'W';

	// Variables globals.
	private static Character[] resultatTirada;
	private static int[] cont_combinacioSecreta;

	// Llista de dificultats del joc.
	protected enum Dificultats {
		PRINCIPIANT,
		AVANCAT,
		EXPERT
	}

	// Atributs de la classe.
	private String nomJugador;
	private Character[] combinacioSecreta;
	protected List<Tirada> llistaTirades;
	private int puntuacio; // fitxa negre: 3 pts | fitxa blanca: 1 pt
	private boolean puntuacioRecord;
	private Dificultats dificultat;
	private int maxCombinacioColors;
	private String resultatPartida; // victoria | derrota
	private int intentsRestants;

	// Constructor.
	public Partida() {
		this.nomJugador = null;
		this.combinacioSecreta = null;
		this.llistaTirades = new ArrayList<>();
		this.puntuacio = 0;
		this.puntuacioRecord = false;
		this.dificultat = null;
		this.maxCombinacioColors = 4;
		this.resultatPartida = null;
		this.intentsRestants = MAX_INTENTS;
	}

	// Getters i setters.
	public String getNomJugador() {
		return nomJugador;
	}

	public void setNomJugador(String nomJugador) {
		this.nomJugador = nomJugador;
	}

	public Character[] getCombinacioSecreta() {
		return combinacioSecreta;
	}

	public void setCombinacioSecreta(Character[] combinacioSecreta) {
		this.combinacioSecreta = combinacioSecreta;
	}

	public List<Tirada> getLlistaTirades() {
		return llistaTirades;
	}

	public int getPuntuacio() {
		return puntuacio;
	}

	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}

	public boolean isPuntuacioRecord() {
		return puntuacioRecord;
	}

	public void setPuntuacioRecord(boolean puntuacioRecord) {
		this.puntuacioRecord = puntuacioRecord;
	}

	public Dificultats getDificultat() {
		return dificultat;
	}

	public void setDificultat(Dificultats dificultat) {
		this.dificultat = dificultat;
	}

	public int getMaxCombinacioColors() {
		return maxCombinacioColors;
	}

	public void setMaxCombinacioColors(int maxCombinacioColors) {
		this.maxCombinacioColors = maxCombinacioColors;
	}

	public String getResultatPartida() {
		return resultatPartida.toUpperCase();
	}

	public void setResultatPartida(String resultatPartida) {
		this.resultatPartida = resultatPartida;
	}

	public int getIntentsRestants() {
		return intentsRestants;
	}

	public void setIntentsRestants(int intentsRestants) {
		this.intentsRestants = intentsRestants;
	}


	//////////////////////////
	//						//
	//		 MÈTODES		//
	//						//
	//////////////////////////

	// Mètode per crear una combinació de colors aleatoriament.
	protected void crearCombinacio() {
		Character[] combinacioColors = new Character[maxCombinacioColors];
		Character[] colors;
		Random random = new Random();

		// En cas de que la dificultat sigui 'Expert' afegir nous colors adicionals.
		if(dificultat.equals(Dificultats.EXPERT)) {
			colors = new Character[]{VERMELL, VERD, BLAU, MAGENTA, GROC, CIAN, ROSA, NEGRE, BLANC};

		} else {
			colors = new Character[]{VERMELL, VERD, BLAU, MAGENTA, GROC, CIAN};
		}

		for(int i = 0; i < maxCombinacioColors; i++) {
			combinacioColors[i] = colors[random.nextInt(colors.length - 1)];
		}

		combinacioSecreta = combinacioColors;
	}

	// Mètode per comprovar tirada.
	protected Character[] comprovarTirada(Tirada tirada) {
		cont_combinacioSecreta = new int[MAX_COLORS];
		/* 
		 * El contador de colors servirà per controlar la quantitat de colors que conté la combinació secreta.
		 * 
		 * Quan s'inicialitzi el contador, recorrerà l'array de la combinació secreta i contarà quants colors hi ha i 
		 * assignarà els nombres a cada índex que representa cada color.
		 * 
		 * Al començar la partida, quan el jugador introdueixi la combinació intentada, s'anirà restant del contador cada
		 * color introduït per l'usuari (en el cas de que la combinació secreta el contingui). 
		 * En cas que algun contador contingui un valor 0 deixarà de contar el color, d'aquesta manera s'aconsegueix que
		 * el jugador pugui interpretar de manera exacta quants colors ha endevinat (indiferentment de la seva posició).
		 * 
		 * 
		 * Valors de cada índex del contador de colors:
		 * [0] : (R) Red
		 * [1] : (G) Green
		 * [2] : (B) Blue
		 * [3] : (M) Magenta
		 * [4] : (Y) Yellow
		 * [5] : (C) Cyan
		 * [6] : (P) Pink
		 * [7] : (K) Black
		 * [8] : (W) White
		 * 
		 */

		// INICIALITZAR CONTADOR DE COLORS DE LA COMBINACIÓ SECRETA.
		// Incrementar el contador de cada color segons la quantitat de colors de la combinació secreta.
		try {
			for(int i = 0; i < maxCombinacioColors; i++) {
				if(combinacioSecreta[i] == VERMELL) {
					cont_combinacioSecreta[0]++;

				} else if(combinacioSecreta[i] == VERD) {
					cont_combinacioSecreta[2]++;

				} else if(combinacioSecreta[i] == BLAU) {
					cont_combinacioSecreta[1]++;

				} else if(combinacioSecreta[i] == MAGENTA) {
					cont_combinacioSecreta[3]++;

				} else if(combinacioSecreta[i] == GROC) {
					cont_combinacioSecreta[4]++;

				} else if(combinacioSecreta[i] == CIAN) {
					cont_combinacioSecreta[5]++;

				} else if(combinacioSecreta[i] == ROSA) {
					cont_combinacioSecreta[6]++;

				} else if(combinacioSecreta[i] == NEGRE) {
					cont_combinacioSecreta[7]++;

				} else if(combinacioSecreta[i] == BLANC) {
					cont_combinacioSecreta[8]++;

				}
			}

		} catch(IndexOutOfBoundsException e) {
			IU.missatgeErrorCritic("S'ha intentat iterar sobre un índex que sobrepassa els límits de la mida de l'array");
		}


		// Comparar la tirada del jugador amb la combinació secreta.
		Character[] combinacioIntentada = tirada.getCombinacioIntentada();
		resultatTirada = new Character[maxCombinacioColors];

		try {
			for(int i = 0; i < maxCombinacioColors; i++) {
				// Comprovar si coincideix el mateix color a la mateixa posició (NEGRE).
				if(combinacioSecreta[i].equals(combinacioIntentada[i])) {
					reduirContadorCombinacioSecreta(combinacioSecreta[i], i, NEGRE);

				} else {
					// Comprovar si coincideix el mateix color a una posició diferent (BLANC).
					for(int j = 0; j < maxCombinacioColors; j++) {
						if(i != j && combinacioIntentada[i].equals(combinacioSecreta[j])) {
							reduirContadorCombinacioSecreta(combinacioSecreta[j], i, BLANC);
							break;
						}
					}
				}
			}
		} catch(IndexOutOfBoundsException e) {
			IU.missatgeErrorCritic("S'ha intentat iterar sobre un índex que sobrepassa els límits de la mida de l'array");
		}

		// Desordenar el resultat en cas de dificultat avançada o experta.
		if(dificultat.equals(Dificultats.AVANCAT) || dificultat.equals(Dificultats.EXPERT)) {
			// Crear una nova llista per emmagatzemar el resultat desordenat.
			List<Character> resultatDesordenat = new ArrayList<>();

			// Afegir el resultat inicial (ordenat) a la llista desordenada.
			for(Character resultat : resultatTirada) {
				resultatDesordenat.add(resultat);
			}

			// Desordenar la llista.
			Collections.shuffle(resultatDesordenat);

			// Els valors null sempre aniràn al final de la llista.
			// Per això haurem d'eliminar tots els elements de la llista que siguin null.
			resultatDesordenat.removeAll(Collections.singleton(null));
			// Llavors s'afegiràn al final de la llista.
			// L'operació 'resultatTirada.length - resultatDesordenat.size()' definirà quants elements null hi haurà 
			// que afegir per completar la llista.
			resultatDesordenat.addAll(Collections.nCopies(resultatTirada.length - resultatDesordenat.size(), null));

			// Copiar la llista desordenada a l'array del resultat.
			for (int i = 0; i < maxCombinacioColors; i++) {
				resultatTirada[i] = resultatDesordenat.get(i);
			}
		}

		return resultatTirada;
	}

	// Mètode per reduir el contador de colors de la combinació secreta.
	private void reduirContadorCombinacioSecreta(int indexCombSecreta, int indexResultatTirada, char color) {
		switch(indexCombSecreta) {
		case VERMELL:
			if(cont_combinacioSecreta[0] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[0]--;
			}
			break;
		case VERD:
			if(cont_combinacioSecreta[2] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[2]--;
			}
			break;
		case BLAU:
			if(cont_combinacioSecreta[1] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[1]--;
			}
			break;
		case MAGENTA:
			if(cont_combinacioSecreta[3] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[3]--;
			}
			break;
		case GROC:
			if(cont_combinacioSecreta[4] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[4]--;
			}
			break;
		case CIAN:
			if(cont_combinacioSecreta[5] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[5]--;
			}
			break;
		case ROSA:
			if(cont_combinacioSecreta[6] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[6]--;
			}
			break;
		case NEGRE:
			if(cont_combinacioSecreta[7] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[7]--;
			}
			break;
		case BLANC:
			if(cont_combinacioSecreta[8] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[8]--;
			}
			break;
		default:
			IU.missatgeErrorCritic("Error en el mètode 'reduirContadorCombinacioSecreta' de la classe 'Partida' al intentar "
					+ "iterar sobre un valor desconegut.");
			break;
		}
	}

}
