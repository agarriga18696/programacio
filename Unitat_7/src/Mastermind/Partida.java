package Mastermind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Partida {

	// Constants.
	protected static final int MAX_COLORS = 9;
	protected static final char VERMELL = 'R';
	protected static final char BLAU = 'B';
	protected static final char VERD = 'G';
	protected static final char MAGENTA = 'M';
	protected static final char GROC = 'Y';
	protected static final char CIAN = 'C';
	protected static final char ROSA = 'P';
	protected static final char NEGRE_K = 'K';
	protected static final char NEGRE = 'B';
	protected static final char BLANC = 'W';
	
	protected static int maxCombColors = 4;
	private static int sasdf = 5;

	// Atributs.
	private String nomJugador;
	private Character[] combinacioSecreta;
	protected List<Tirada> llistaTirades;
	private int puntuacio;
	private String dificultat;

	// Constructor.
	public Partida() {
		this.nomJugador = null;
		this.combinacioSecreta = null;
		this.llistaTirades = new ArrayList<>();
		this.puntuacio = 0;
		this.dificultat = null;
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

	public String getDificultat() {
		return dificultat;
	}

	public void setDificultat(String dificultat) {
		this.dificultat = dificultat;
	}


	//////////////////////////
	//						//
	//		 MÈTODES		//
	//						//
	//////////////////////////
	
	// Mètode per crear una combinació de colors aleatoriament.
	protected void crearCombinacio() {
		Character[] combinacioColors = new Character[maxCombColors];
		Character[] colors;
		Random random = new Random();

		// En cas de que la dificultat sigui 'Expert' afegir nous colors adicionals.
		if(dificultat.equalsIgnoreCase("Expert")) {
			colors = new Character[]{VERMELL, BLAU, VERD, MAGENTA, GROC, CIAN, ROSA, NEGRE_K, BLANC};
			
		} else {
			colors = new Character[]{VERMELL, BLAU, VERD, MAGENTA, GROC, CIAN};
		}
		
		for(int i = 0; i < maxCombColors; i++) {
			combinacioColors[i] = colors[random.nextInt(colors.length - 1)];
		}

		combinacioSecreta = combinacioColors;
	}

	// Mètode per comprovar tirada.
	protected Character[] comprovarTirada(Tirada tirada) {
		int[] cont_combinacioSecreta = new int[MAX_COLORS];
		/* 
		 * El contador de colors servirà per controlar el número de colors que conté la combinació secreta.
		 * Quan s'inicialitzi el contador, recorrerà l'array de la combinació secreta i contarà quants colors hi ha
		 * de cada tipus.
		 * Al començar la partida, quan el jugador introdueixi la combinació intentada, s'anirà restant del contador cada
		 * color introduït per l'usuari (en el cas de que la combinació secreta el contingui). 
		 * En cas de que algun contador contingui un valor 0 deixarà de contar el color, d'aquesta manera s'aconsegueix que
		 * el jugador pugui interpretar de manera exacta quants colors ha endevinat (indiferentment de la seva posició).
		 * 
		 * 
		 * Valors de cada índex del contador de colors:
		 * [0] : (R) Red
		 * [1] : (B) Blue
		 * [2] : (G) Green
		 * [3] : (M) Magenta
		 * [4] : (Y) Yellow
		 * [5] : (C) Cyan
		 * [6] : (P) Pink
		 * [7] : (K) Black
		 * [8] : (W) White
		 * 
		 */

		// Incrementar el contador de cada color segons la quantitat de colors de la combinació secreta.
		for(int i = 0; i < maxCombColors; i++) {
			if(combinacioSecreta[i] == VERMELL) {
				cont_combinacioSecreta[0]++;
				
			} else if(combinacioSecreta[i] == BLAU) {
				cont_combinacioSecreta[1]++;
				
			} else if(combinacioSecreta[i] == VERD) {
				cont_combinacioSecreta[2]++;
				
			} else if(combinacioSecreta[i] == MAGENTA) {
				cont_combinacioSecreta[3]++;
				
			} else if(combinacioSecreta[i] == GROC) {
				cont_combinacioSecreta[4]++;
				
			} else if(combinacioSecreta[i] == CIAN) {
				cont_combinacioSecreta[5]++;
				
			} else if(combinacioSecreta[i] == ROSA) {
				cont_combinacioSecreta[6]++;
				
			} else if(combinacioSecreta[i] == NEGRE_K) {
				cont_combinacioSecreta[7]++;
				
			} else if(combinacioSecreta[i] == BLANC) {
				cont_combinacioSecreta[8]++;
				
			}
		}


		// Comparar la tirada del jugador amb la combinació secreta.
		Character[] combinacioIntentada = tirada.getCombinacioIntentada();
		Character[] resultatTirada = new Character[maxCombColors];

		for(int i = 0; i < maxCombColors; i++) {
			// Comprovar si coincideix el mateix color a la mateixa posició (NEGRE).
			if(combinacioSecreta[i].equals(combinacioIntentada[i])) {
				// Switch 1
				switch(combinacioSecreta[i]) {
				case VERMELL:
					if(cont_combinacioSecreta[0] > 0) {
						resultatTirada[i] = NEGRE;
						cont_combinacioSecreta[0]--;
					}
					break;
				case BLAU:
					if(cont_combinacioSecreta[1] > 0) {
						resultatTirada[i] = NEGRE;
						cont_combinacioSecreta[1]--;
					}
					break;
				case VERD:
					if(cont_combinacioSecreta[2] > 0) {
						resultatTirada[i] = NEGRE;
						cont_combinacioSecreta[2]--;
					}
					break;
				case MAGENTA:
					if(cont_combinacioSecreta[3] > 0) {
						resultatTirada[i] = NEGRE;
						cont_combinacioSecreta[3]--;
					}
					break;
				case GROC:
					if(cont_combinacioSecreta[4] > 0) {
						resultatTirada[i] = NEGRE;
						cont_combinacioSecreta[4]--;
					}
					break;
				case CIAN:
					if(cont_combinacioSecreta[5] > 0) {
						resultatTirada[i] = NEGRE;
						cont_combinacioSecreta[5]--;
					}
					break;
				case ROSA:
					if(cont_combinacioSecreta[6] > 0) {
						resultatTirada[i] = NEGRE;
						cont_combinacioSecreta[6]--;
					}
					break;
				case NEGRE_K:
					if(cont_combinacioSecreta[7] > 0) {
						resultatTirada[i] = NEGRE;
						cont_combinacioSecreta[7]--;
					}
					break;
				case BLANC:
					if(cont_combinacioSecreta[8] > 0) {
						resultatTirada[i] = NEGRE;
						cont_combinacioSecreta[8]--;
					}
					break;
				default:
					IU.missatgeErrorCritic("Error en el mètode 'comprovarTirada' de la classe 'Partida' al intentar "
							+ "iterar sobre un valor desconegut en el 'switch 1'.");
					break;
				}

			} else {
				// Comprovar si coincideix el mateix color a una posició diferent (BLANC).
				for(int j = 0; j < maxCombColors; j++) {
					if(i != j && combinacioIntentada[i].equals(combinacioSecreta[j])) {
						switch(combinacioSecreta[j]) {
						case VERMELL:
							if(cont_combinacioSecreta[0] > 0) {
								resultatTirada[i] = BLANC;
								cont_combinacioSecreta[0]--;
							}
							break;
						case BLAU:
							if(cont_combinacioSecreta[1] > 0) {
								resultatTirada[i] = BLANC;
								cont_combinacioSecreta[1]--;
							}
							break;
						case VERD:
							if(cont_combinacioSecreta[2] > 0) {
								resultatTirada[i] = BLANC;
								cont_combinacioSecreta[2]--;
							}
							break;
						case MAGENTA:
							if(cont_combinacioSecreta[3] > 0) {
								resultatTirada[i] = BLANC;
								cont_combinacioSecreta[3]--;
							}
							break;
						case GROC:
							if(cont_combinacioSecreta[4] > 0) {
								resultatTirada[i] = BLANC;
								cont_combinacioSecreta[4]--;
							}
							break;
						case CIAN:
							if(cont_combinacioSecreta[5] > 0) {
								resultatTirada[i] = BLANC;
								cont_combinacioSecreta[5]--;
							}
							break;
						case ROSA:
							if(cont_combinacioSecreta[6] > 0) {
								resultatTirada[i] = BLANC;
								cont_combinacioSecreta[6]--;
							}
							break;
						case NEGRE_K:
							if(cont_combinacioSecreta[7] > 0) {
								resultatTirada[i] = BLANC;
								cont_combinacioSecreta[7]--;
							}
							break;
						case BLANC:
							if(cont_combinacioSecreta[8] > 0) {
								resultatTirada[i] = BLANC;
								cont_combinacioSecreta[8]--;
							}
							break;
						default:
							IU.missatgeErrorCritic("Error en el mètode 'comprovarTirada' de la classe 'Partida' al intentar "
									+ "iterar sobre un valor desconegut en el 'switch 2'.");
							break;
						}

						break;
					}
				}
			}
		}

		// Desordenar el resultat en cas de dificultat avançada.
		if(dificultat.equalsIgnoreCase("Avançat") || dificultat.equalsIgnoreCase("Expert")) {
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
			for (int i = 0; i < maxCombColors; i++) {
				resultatTirada[i] = resultatDesordenat.get(i);
			}
		}

		return resultatTirada;
	}

}
