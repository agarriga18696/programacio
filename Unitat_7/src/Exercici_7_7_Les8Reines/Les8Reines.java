package Exercici_7_7_Les8Reines;

public class Les8Reines {

	private static final int MIDA_TAULER = 8;
	private static CharSequence tauler[][] = new CharSequence[MIDA_TAULER][MIDA_TAULER];
	private static final String RESET = "\033[0m";
	private static final String REINA = "\033[0;33m" + "♕" + RESET; //♕
	private static final String NEGRE = "\033[0;30m" + "■" + RESET;
	private static final String BLANC = "\033[0;37m" + "■" + RESET;
	private static int contador = 0;

	public static void main(String[] args) {

		inicialitzarTauler();
		check(0);

	}

	// Mètode per inicialitzar el tauler.
	public static void inicialitzarTauler() {
		
		// Inicialitzar el tauler amb el caracter BUIT.
		for (int i = 0; i < MIDA_TAULER; i++) {
			for (int j = 0; j < MIDA_TAULER; j++) {	
				pintarCaselles(i, j);
			}
		}

	}

	private static void pintarCaselles(int fila, int columna) {
		if(fila % 2 == 0) {
			if(columna % 2 != 0) {
				tauler[fila][columna] = NEGRE;
			} else {
				tauler[fila][columna] = BLANC;
			}
		}
		
		if(fila % 2 != 0) {
			if(columna % 2 == 0) {
				tauler[fila][columna] = NEGRE;
			} else {
				tauler[fila][columna] = BLANC;
			}
		}
	}

	// Mètode Check.
	public static void check(int columna) {

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
				pintarCaselles(fila, columna);
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
	public static void imprimirTauler() {
		
		System.out.println("\n   POSSIBILITAT " + (contador+1));

		System.out.print("\n   A B C D E F G H\n");
		for(int i = 0; i < MIDA_TAULER; i++) {
			System.out.print(" " + (i+1) + " ");
			for(int j = 0; j < MIDA_TAULER; j++) {
				System.out.print(tauler[i][j] + " ");
			}

			System.out.println();
		}
		
		contador++;

		System.out.println();

	}

}
