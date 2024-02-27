package Mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partida {

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
		char[] colors = {'R', 'B', 'G', 'M', 'Y', 'C'};
		Character[] combinacioColors = new Character[4];
		Random random = new Random();

		for(int i = 0; i < combinacioColors.length; i++) {
			combinacioColors[i] = colors[random.nextInt(colors.length - 1)];
		}

		return combinacioColors;
	}

	// Mètode per comprovar tirada.
	public Character[] comprovarTirada(Tirada tirada) {
		Character[] solucio = new Character[4];
		int[] cont_combinacioSecreta = new int[6];
		/*
		 * cont_colors[0] : R
		 * cont_colors[1] : B
		 * cont_colors[2] : G
		 * cont_colors[3] : M
		 * cont_colors[4] : Y
		 * cont_colors[5] : C
		 * 
		 */

		/* Resposta ordinador:
		 * -> Negre (b): color correcte en la posició correcta.
		 * -> Blanc (w): color correcte en una posició incorrecta.
		 * -> Buit (null): color incorrecte.
		 * 
		 * 
		 * Format de sortida:
		 * [b][w]
		 * [w][b]
		 * 
		 * 
		 * Crear un array contador de 6 posicions que correspondràn als 6 colors del joc.
		 * -> Incrementar el valor dels contadors en funció dels colors de la combinació secreta.
		 * -> Comparar quants colors endevinats hi ha a la combinació introduïda pel jugador amb la combinació secreta.
		 * 
		 */

		// Incrementar el contador de colors segons la combinació secreta.
		for(int i = 0; i < 4; i++) {
			if(combinacioSecreta[i] == 'R') {
				cont_combinacioSecreta[0]++;
			} else if(combinacioSecreta[i] == 'B') {
				cont_combinacioSecreta[1]++;
			} else if(combinacioSecreta[i] == 'G') {
				cont_combinacioSecreta[2]++;
			} else if(combinacioSecreta[i] == 'M') {
				cont_combinacioSecreta[3]++;
			} else if(combinacioSecreta[i] == 'Y') {
				cont_combinacioSecreta[4]++;
			} else if(combinacioSecreta[i] == 'C') {
				cont_combinacioSecreta[5]++;
			}
		}

		/*for(int i = 0; i < cont_combinacioSecreta.length; i++) {
			if(cont_combinacioSecreta[i] > 0) {
				if(i == 0) {
					System.out.println("\n R: " + cont_combinacioSecreta[i]);
				} else if(i == 1) {
					System.out.println(" B: " + cont_combinacioSecreta[i]);
				} else if(i == 2) {
					System.out.println(" G: " + cont_combinacioSecreta[i]);
				} else if(i == 3) {
					System.out.println(" M: " + cont_combinacioSecreta[i]);
				} else if(i == 4) {
					System.out.println(" Y: " + cont_combinacioSecreta[i]);
				} else if(i == 5) {
					System.out.println(" C: " + cont_combinacioSecreta[i]);
				}
			}
		}

		System.out.println();*/



		// Comparar la tirada del jugador amb la combinació secreta.
		Character[] combinacioIntentada = tirada.getCombinacioIntentada();

		for(int i = 0; i < 4; i++) {
			// Comprovar si coincideix el mateix color a la mateixa posició.
			if(combinacioSecreta[i].equals(combinacioIntentada[i])) {
				switch(combinacioSecreta[i]) {
				case 'R':
					if(cont_combinacioSecreta[0] > 0) {
						solucio[i] = 'B';
						cont_combinacioSecreta[0]--;
					}
					break;
				case 'B':
					if(cont_combinacioSecreta[1] > 0) {
						solucio[i] = 'B';
						cont_combinacioSecreta[1]--;
					}
					break;
				case 'G':
					if(cont_combinacioSecreta[2] > 0) {
						solucio[i] = 'B';
						cont_combinacioSecreta[2]--;
					}
					break;
				case 'M':
					if(cont_combinacioSecreta[3] > 0) {
						solucio[i] = 'B';
						cont_combinacioSecreta[3]--;
					}
					break;
				case 'Y':
					if(cont_combinacioSecreta[4] > 0) {
						solucio[i] = 'B';
						cont_combinacioSecreta[4]--;
					}
					break;
				case 'C':
					if(cont_combinacioSecreta[5] > 0) {
						solucio[i] = 'B';
						cont_combinacioSecreta[5]--;
					}
					break;
				default:
					System.err.println("Error al iterar sobre un valor desconegut.");
					break;
				}
				//solucio[i] = 'B';

			} else {
				// Comprovar si coincideix el mateix color a una posició diferent.
				boolean colorTrobat = false;
				for(int j = 0; j < 4; j++) {
					if(i != j && combinacioIntentada[i].equals(combinacioSecreta[j])) {
						switch(combinacioSecreta[j]) {
						case 'R':
							if(cont_combinacioSecreta[0] > 0) {
								solucio[i] = 'W';
								cont_combinacioSecreta[0]--;
								colorTrobat = true;
							}
							break;
						case 'B':
							if(cont_combinacioSecreta[1] > 0) {
								solucio[i] = 'W';
								cont_combinacioSecreta[1]--;
								colorTrobat = true;
							}
							break;
						case 'G':
							if(cont_combinacioSecreta[2] > 0) {
								solucio[i] = 'W';
								cont_combinacioSecreta[2]--;
								colorTrobat = true;
							}
							break;
						case 'M':
							if(cont_combinacioSecreta[3] > 0) {
								solucio[i] = 'W';
								cont_combinacioSecreta[3]--;
								colorTrobat = true;
							}
							break;
						case 'Y':
							if(cont_combinacioSecreta[4] > 0) {
								solucio[i] = 'W';
								cont_combinacioSecreta[4]--;
								colorTrobat = true;
							}
							break;
						case 'C':
							if(cont_combinacioSecreta[5] > 0) {
								solucio[i] = 'W';
								cont_combinacioSecreta[5]--;
								colorTrobat = true;
							}
							break;
						default:
							System.err.println("Error al iterar sobre un valor desconegut.");
							break;
						}
						
						//solucio[i] = 'W';
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
