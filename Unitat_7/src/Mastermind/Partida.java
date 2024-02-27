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
	public Integer[] comprovarTirada(Tirada tirada) {
		Integer[] solucio = new Integer[4];

		/* Resposta ordinador.
		 * 
		 * -> Negre (b): color correcte en la posició correcta.
		 * -> Blanc (w): color correcte en una posició incorrecta.
		 * -> Buit (null): color incorrecte.
		 * 
		 * Format de sortida:
		 * 
		 * [b][w]
		 * [w][b]
		 * 
		 * -> w: 0
		 * -> b: 1
		 * 
		 */

		// Comparar la tirada del jugador amb la combinació secreta.
		Character[] combinacioIntentada = tirada.getCombinacioIntentada();

		for(int i = 0; i < 4; i++) {
			// Quant coincideix el mateix color a la mateixa posició.
			if(combinacioSecreta[i].equals(combinacioIntentada[i])) {
				solucio[i] = 1; //b

			} else {
				boolean colorTrobat = false;
				for(int j = 0; j < 4; j++) {
					if(i != j && combinacioIntentada[i].equals(combinacioSecreta[j])) {
						// Quant coincideix el mateix color a una posició diferent.
						solucio[i] = 0; //w
						colorTrobat = true;
						break;
					}
				}
				
				// El color és incorrecte.
				if(!colorTrobat) {
					solucio[i] = null;
				}
			}
		}

		return solucio;

	}


}
