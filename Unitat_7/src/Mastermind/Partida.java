package Mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partida {

	// Constants.
	protected static final char VERMELL = 'R';
	protected static final char BLAU = 'B';
	protected static final char VERD = 'G';
	protected static final char MAGENTA = 'M';
	protected static final char GROC = 'Y';
	protected static final char CIAN = 'C';
	protected static final char NEGRE = 'B';
	protected static final char BLANC = 'W';

	// Atributs.
	private String nomJugador;
	private Character[] combinacioSecreta;
	private List<Tirada> llistaTirades;
	private int puntuacio;
	private boolean victoria;

	// Constructor.
	public Partida(String nomJugador) {
		this.nomJugador = nomJugador;
		this.combinacioSecreta = crearCombinacio();
		this.llistaTirades = new ArrayList<>();
		this.puntuacio = 0;
		this.victoria = false;
	}

	// Getters i setters.
	public String nomJugador() {
		return nomJugador;
	}

	public Character[] getCombinacioSecreta() {
		return combinacioSecreta;
	}

	public List<Tirada> getLlistaTirades() {
		return llistaTirades;
	}

	public int getPuntuacio() {
		return puntuacio;
	}

	public boolean isVictoria() {
		return victoria;
	}

	// Mètode per crear una combinació de manera aleatoria.
	private Character[] crearCombinacio() {
		char[] colors = {VERMELL, BLAU, VERD, MAGENTA, GROC, CIAN};
		Character[] combinacioColors = new Character[4];
		Random random = new Random();

		for(int i = 0; i < 4; i++) {
			combinacioColors[i] = colors[random.nextInt(colors.length - 1)];
		}

		return combinacioColors;
	}
	

	//////////////////////////
	//						//
	//		 MÈTODES		//
	//						//
	//////////////////////////

	// Mètode per comprovar tirada.
	public Character[] comprovarTirada(Tirada tirada) {
		Character[] solucio = new Character[4];
		int[] cont_combinacioSecreta = new int[6];
		/*
		 * [0] : R
		 * [1] : B
		 * [2] : G
		 * [3] : M
		 * [4] : Y
		 * [5] : C
		 * 
		 */

		// Incrementar el contador de colors segons la combinació secreta.
		// D'aquesta manera, per exemple, si la combinació secreta conté 3 vermells i el jugador
		// en posa 4, només contarà els 3 primers, el quart no. Així amb tots els colors.
		for(int i = 0; i < 4; i++) {
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
			}
		}

		// Comparar la tirada del jugador amb la combinació secreta.
		Character[] combinacioIntentada = tirada.getCombinacioIntentada();
		
		/* Resposta ordinador:
		 * -> Negre: color correcte en la posició correcta.
		 * -> Blanc: color correcte en una posició incorrecta.
		 * -> Buit (null): color incorrecte.
		 * 
		 */

		for(int i = 0; i < 4; i++) {
			// Comprovar si coincideix el mateix color a la mateixa posició.
			if(combinacioSecreta[i].equals(combinacioIntentada[i])) {
				switch(combinacioSecreta[i]) {
				case VERMELL:
					if(cont_combinacioSecreta[0] > 0) {
						solucio[i] = NEGRE;
						cont_combinacioSecreta[0]--;
					}
					break;
				case BLAU:
					if(cont_combinacioSecreta[1] > 0) {
						solucio[i] = NEGRE;
						cont_combinacioSecreta[1]--;
					}
					break;
				case VERD:
					if(cont_combinacioSecreta[2] > 0) {
						solucio[i] = NEGRE;
						cont_combinacioSecreta[2]--;
					}
					break;
				case MAGENTA:
					if(cont_combinacioSecreta[3] > 0) {
						solucio[i] = NEGRE;
						cont_combinacioSecreta[3]--;
					}
					break;
				case GROC:
					if(cont_combinacioSecreta[4] > 0) {
						solucio[i] = NEGRE;
						cont_combinacioSecreta[4]--;
					}
					break;
				case CIAN:
					if(cont_combinacioSecreta[5] > 0) {
						solucio[i] = NEGRE;
						cont_combinacioSecreta[5]--;
					}
					break;
				default:
					System.err.println(" Error al iterar sobre un valor desconegut.");
					break;
				}

			} else {
				// Comprovar si coincideix el mateix color a una posició diferent.
				boolean colorTrobat = false;
				for(int j = 0; j < 4; j++) {
					if(i != j && combinacioIntentada[i].equals(combinacioSecreta[j])) {
						switch(combinacioSecreta[j]) {
						case VERMELL:
							if(cont_combinacioSecreta[0] > 0) {
								solucio[i] = BLANC;
								cont_combinacioSecreta[0]--;
								colorTrobat = true;
							}
							break;
						case BLAU:
							if(cont_combinacioSecreta[1] > 0) {
								solucio[i] = BLANC;
								cont_combinacioSecreta[1]--;
								colorTrobat = true;
							}
							break;
						case VERD:
							if(cont_combinacioSecreta[2] > 0) {
								solucio[i] = BLANC;
								cont_combinacioSecreta[2]--;
								colorTrobat = true;
							}
							break;
						case MAGENTA:
							if(cont_combinacioSecreta[3] > 0) {
								solucio[i] = BLANC;
								cont_combinacioSecreta[3]--;
								colorTrobat = true;
							}
							break;
						case GROC:
							if(cont_combinacioSecreta[4] > 0) {
								solucio[i] = BLANC;
								cont_combinacioSecreta[4]--;
								colorTrobat = true;
							}
							break;
						case CIAN:
							if(cont_combinacioSecreta[5] > 0) {
								solucio[i] = BLANC;
								cont_combinacioSecreta[5]--;
								colorTrobat = true;
							}
							break;
						default:
							System.err.println(" Error al iterar sobre un valor desconegut.");
							break;
						}

						break;
					}
				}

				// Comprovar si no coincideix el color.
				if(!colorTrobat) {
					solucio[i] = null;
				}
			}
		}

		return solucio;

	}


}
