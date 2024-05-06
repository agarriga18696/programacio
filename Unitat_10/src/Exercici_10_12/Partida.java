package Exercici_10_12;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Partida implements Serializable {

	private static final long serialVersionUID = 1L;

	// Constants.
	protected static final int MAX_INTENTS = 16;

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
	private int puntuacio;
	private boolean puntuacioRecord;
	private Dificultats dificultat;
	private int maxCombinacioColors;
	private String resultatPartida;
	private int intentsRestants;
	private LocalDate data;
	private LocalTime hora_inici;
	private LocalTime hora_fi;

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

		// Guardar la data i la hora en que s'ha jugat la partida.
		this.data = LocalDate.now();
		this.hora_inici = LocalTime.now();
		this.hora_fi = null; // No guardar la hora fins que no acaba la partida.
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

	public LocalDate getData() {
		return data;
	}

	public LocalTime getHora_fi() {
		return hora_fi;
	}

	public void setHora_fi(LocalTime hora_fi) {
		this.hora_fi = hora_fi;
	}

	public LocalTime getHora_inici() {
		return hora_inici;
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
			colors = new Character[]{IU.VERMELL, IU.VERD, IU.BLAU, IU.MAGENTA, IU.GROC, IU.CIAN, IU.ROSA, IU.NEGRE, IU.BLANC};

		} else {
			colors = new Character[]{IU.VERMELL, IU.VERD, IU.BLAU, IU.MAGENTA, IU.GROC, IU.CIAN};
		}

		for(int i = 0; i < maxCombinacioColors; i++) {
			combinacioColors[i] = colors[random.nextInt(colors.length - 1)];
		}

		combinacioSecreta = combinacioColors;
	}

	// Mètode per comprovar tirada.
	protected Character[] comprovarTirada(Tirada tirada) {
		cont_combinacioSecreta = new int[IU.MAX_COLORS];
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

		// INICIALITZAR CONTADOR DE COLORS DE LA COMBINACIÓ SECRETA.
		// Incrementar el contador de cada color segons la quantitat de colors de la combinació secreta.
		try {
			for(int i = 0; i < maxCombinacioColors; i++) {
				if(combinacioSecreta[i] == IU.VERMELL) {
					cont_combinacioSecreta[0]++;

				} else if(combinacioSecreta[i] == IU.BLAU) {
					cont_combinacioSecreta[1]++;

				} else if(combinacioSecreta[i] == IU.VERD) {
					cont_combinacioSecreta[2]++;

				} else if(combinacioSecreta[i] == IU.MAGENTA) {
					cont_combinacioSecreta[3]++;

				} else if(combinacioSecreta[i] == IU.GROC) {
					cont_combinacioSecreta[4]++;

				} else if(combinacioSecreta[i] == IU.CIAN) {
					cont_combinacioSecreta[5]++;

				} else if(combinacioSecreta[i] == IU.ROSA) {
					cont_combinacioSecreta[6]++;

				} else if(combinacioSecreta[i] == IU.NEGRE) {
					cont_combinacioSecreta[7]++;

				} else if(combinacioSecreta[i] == IU.BLANC) {
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
					reduirContadorCombinacioSecreta(combinacioSecreta[i], i, IU.NEGRE);

				} else {
					// Comprovar si coincideix el mateix color a una posició diferent (BLANC).
					for(int j = 0; j < maxCombinacioColors; j++) {
						if(i != j && combinacioIntentada[i].equals(combinacioSecreta[j])) {
							reduirContadorCombinacioSecreta(combinacioSecreta[j], i, IU.BLANC);
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
		case IU.VERMELL:
			if(cont_combinacioSecreta[0] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[0]--;
			}
			break;
		case IU.BLAU:
			if(cont_combinacioSecreta[1] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[1]--;
			}
			break;
		case IU.VERD:
			if(cont_combinacioSecreta[2] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[2]--;
			}
			break;
		case IU.MAGENTA:
			if(cont_combinacioSecreta[3] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[3]--;
			}
			break;
		case IU.GROC:
			if(cont_combinacioSecreta[4] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[4]--;
			}
			break;
		case IU.CIAN:
			if(cont_combinacioSecreta[5] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[5]--;
			}
			break;
		case IU.ROSA:
			if(cont_combinacioSecreta[6] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[6]--;
			}
			break;
		case IU.NEGRE:
			if(cont_combinacioSecreta[7] > 0) {
				resultatTirada[indexResultatTirada] = color;
				cont_combinacioSecreta[7]--;
			}
			break;
		case IU.BLANC:
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
