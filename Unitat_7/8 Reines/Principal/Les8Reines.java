package Principal;

import java.util.Random;

public class Les8Reines {

	private static final int TOTAL_REINES = 8;
	private static CharSequence tauler[][] = new CharSequence[TOTAL_REINES][TOTAL_REINES];
	private static final CharSequence REINA = "Q";

	public static void main(String[] args) {

		inicialitzarTauler();
		check(0);

	}

	public static void inicialitzarTauler() {
		Random random = new Random();

		// Afegir la primera reina a una posició aleatoria de la taula.
		tauler[random.nextInt(TOTAL_REINES)][random.nextInt(TOTAL_REINES)] = REINA;
	}

	public static void check(int n) {

		if(n == TOTAL_REINES) {
			imprimirTauler();
			return;
		}

		for(int r = 0; r < TOTAL_REINES; r++) {
			// Ubicar la reina actual a la fila de l'array.
			for(int i = 0; i < tauler.length; i++) {
				for(int j = 0; j < tauler.length; j++) {
					if(tauler[i][j] == null) {
						tauler[i][j] = REINA;
					}
					jutge(n);
					if(jutge(n)) {
						check(n+1);
					}
				}
			}


		}

	}

	private static boolean jutge(int n) {

		// Comprovar si hi ha conflicte.
		

		return true;
	}

	public static void imprimirTauler() {
		for(int i = 0; i < tauler.length; i++) {
			for(int j = 0; j < tauler.length; j++) {
				if(tauler[i][j] == null) {
					tauler[i][j] = "*";
				}
				System.out.print(tauler[i][j] + " ");
			}
			System.out.println();
		}
	}

}
