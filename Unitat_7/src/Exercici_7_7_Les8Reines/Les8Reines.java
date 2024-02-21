package Exercici_7_7_Les8Reines;

public class Les8Reines {

	private static final int TOTAL_REINES = 8;
	private static CharSequence tauler[][] = new CharSequence[TOTAL_REINES][TOTAL_REINES];
	private static final CharSequence REINA = "Q";
	private static final CharSequence BUIT = "■";
	private static int contador = 0;

	public static void main(String[] args) {

		inicialitzarTauler();
		check(0);

	}

	// Mètode per inicialitzar el tauler.
	public static void inicialitzarTauler() {
		
		// Inicialitzar el tauler amb el caracter BUIT.
		for (int i = 0; i < TOTAL_REINES; i++) {
			for (int j = 0; j < TOTAL_REINES; j++) {
				tauler[i][j] = BUIT;
			}
		}

	}

	// Mètode Check.
	public static void check(int columna) {

		if(columna == TOTAL_REINES) {
			imprimirTauler();
			return;
		}

		// Assignar 
		for(int fila = 0; fila < TOTAL_REINES; fila++) {
			if(jutge(fila, columna)) {
				tauler[fila][columna] = REINA;
				check(columna + 1);
				tauler[fila][columna] = BUIT;
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

		// Comprovar la diagonal superior esquerra.
		for (int i = fila - 1; i >= 0; i--) {
		    int j = columna - (fila - i);
		    
		    if (j < 0) {
		    	break;
		    }
		    
		    if (tauler[i][j].equals(REINA)) {
		        return false;
		    }
		}

		// Comprovar la diagonal inferior esquerra.
		for (int i = fila + 1; i < TOTAL_REINES; i++) {
		    int j = columna - (i - fila);
		    
		    if (j < 0) {
		    	break;
		    }
		    
		    if (tauler[i][j].equals(REINA)) {
		        return false;
		    }
		}

		return true;
	}

	// Mètode per imprimir el tauler.
	public static void imprimirTauler() {
		
		System.out.println("\n   POSSIBILITAT " + (contador+1));

		System.out.print("\n   A B C D E F G H\n");
		for(int i = 0; i < TOTAL_REINES; i++) {
			System.out.print(" " + (i+1) + " ");
			for(int j = 0; j < TOTAL_REINES; j++) {
				System.out.print(tauler[i][j] + " ");
			}

			System.out.println();
		}
		
		contador++;

		System.out.println();

	}

}
