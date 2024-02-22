package Exercici_7_7_Les8Reines;

import java.util.Arrays;

public class Les8Reines {

	private static final int MIDA_TAULER = 8;
	private static String tauler[][] = new String[MIDA_TAULER][MIDA_TAULER];
	private static final String REINA = "Q"; //♕
	private static final String BUIT = "■"; //■
	private static int contadorPossibilitats = 0;

	private static final String RESET = "\u001B[0m";
	private static final String NEGRE = "\u001B[30m";
	private static final String BLANC = "\u001B[37m";

	public static void main(String[] args) {

		pintarTauler();
		check(0);

	}

	private static void pintarTauler() {
		// Pintar els requadres blancs i negres com el tauler real.
		for(int i = 0; i < MIDA_TAULER; i++) {
			for (int j = 0; j < MIDA_TAULER; j++) {
				if(j % 2 == 0) {
					tauler[i][j] = BLANC + BUIT + RESET;
				} else {
					tauler[i][j] = NEGRE + BUIT + RESET;
				}
			}
		}
	}

	// Mètode Check.
	private static void check(int columna) {

		if(columna == MIDA_TAULER) {
			imprimirTauler();
			return;
		}

		// Assignar la reina a la fila.
		for(int fila = 0; fila < MIDA_TAULER; fila++) {
			// Comprovar que la reina no estigui en conflicte amb una altra.
			if(jutge(fila, columna)) {
				// Si no està en conflicte insereix la reina a l'índex de l'array.
				tauler[fila][columna] = REINA;
				check(columna + 1);
				tauler[fila][columna] = BLANC + BUIT + RESET;
			}
		}

	}

	// Mètode Jutge.
	private static boolean jutge(int fila, int columna) {

		// Comprovar si hi ha una reina a la mateixa fila.
		for(int i = 0; i < columna; i++) {
			if(tauler[fila][i].equals(REINA)) {
				return false;
			}
		}

		/* Comprovar diagonals.
		 * 
		 *    0 1 2 3 4 5 6 7
		 * 0: X X X X X X X X
		 * 1: X X X X X X X X
		 * 2: X X X X X X X X
		 * 3: X X X X X X X X
		 * 4: X X X X X X X X
		 * 5: X X X X X X X X
		 * 6: X X X X X X X X
		 * 7: X X X X X X X X
		 * 
		 */

		// Comprovar diagonal principal.
		for(int i = 0; i < MIDA_TAULER; i++) {
			for(int j = 0; j < MIDA_TAULER; j++) {

				if(i == fila && j == columna) continue;

				// Diagonal principal.
				if(i + j == fila + columna && tauler[i][j].equals(REINA)) {
					return false;
				}

				// Diagonal secundaria.
				if(i - j == fila - columna && tauler[i][j].equals(REINA)) {
					return false;
				}

			}
		}

		return true;
	}

	// Mètode per imprimir el tauler.
	private static void imprimirTauler() {

		System.out.println("\n   POSSIBILITAT " + (contadorPossibilitats+1));

		System.out.print("\n   A B C D E F G H\n");
		for(int i = 0; i < MIDA_TAULER; i++) {
			System.out.print(" " + (MIDA_TAULER - i) + " ");
			for(int j = 0; j < MIDA_TAULER; j++) {
				System.out.print(tauler[i][j] + " ");
			}

			System.out.println();
		}

		contadorPossibilitats++;

		System.out.println();

	}

}
