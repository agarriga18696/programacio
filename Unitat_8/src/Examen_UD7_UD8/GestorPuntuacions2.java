package Examen_UD7_UD8;

import java.util.Arrays;

public class GestorPuntuacions2 {

	private static final int MAX_PUNTUACIONS = 10;
	private static Puntuacio[] puntuacions = new Puntuacio[MAX_PUNTUACIONS];
	private static int contPuntuacions = 0;

	public static void main(String[] args) {
		menu();
	}

	// Mètode per mostrar el menú principal.
	private static void menu() {
		int opcio = 0;

		do {
			IU.titol("Gestor de Puntuacions", "Array");
			IU.opcionsMenu(
					"Nova puntuació", 
					"Veure llista de puntuacions per ordre d'arribada",
					"Veure llista de puntuacions en ordre descendent de punts",
					"Veure llista de puntuacions em ordre alfabètic de cognom",
					"Sortir");

			opcio = Entrada.enter("Opció");

			switch(opcio) {
			case 1:
				novaPuntuacio();
				break;
			case 2:
				llistaPuntuacions_ordre_arribada();
				break;
			case 3:
				llistaPuntuacions_ordre_descendent();
				break;
			case 4:
				llistaPuntuacions_ordre_alfabetic();
				break;
			case 5:
				sortir();
				return;
			default:
				IU.missatgeError("Opció no vàlida");
				break;
			}

		} while(opcio != 5);
	}

	// Mètode per introduir una nova puntuació.
	private static void novaPuntuacio() {
		boolean puntuacioValida = false;

		do {
			IU.titol("Nova puntuació", null);

			// Demanar els atributs de l'objecte puntuació.
			// El try-catch es realitza a la classe 'Entrada'.
			String nom = Entrada.cadena("Nom");
			String cognoms = Entrada.cadena("Cognoms");
			int punts = Entrada.enter("Punts");

			try {
				// Validar que el nom contingui únicament caracters alfabètics.
				if(nom.matches("[a-zA-Z]+")) {
					if(contPuntuacions < puntuacions.length) {
						puntuacions[contPuntuacions] = new Puntuacio(nom, cognoms, punts);
						contPuntuacions++;
						puntuacioValida = true;

					} else {
						IU.missatgeAdvertencia("No es poden afegir més puntuacions a la llista, està plena");
					}

				} else {
					IU.missatgeError("El nom '" + nom + "' no és un nom vàlid");
				}
			} catch(IndexOutOfBoundsException e) {
				IU.missatgeErrorCritic("S'ha intentat accedir a un índex fora dels límits de l'array");
			}

		} while(!puntuacioValida);

		IU.missatgeExit("S'ha afegit la puntuació correctament");
	}

	// Mètode per veure la llista de puntuacions per ordre d'arribada.
	private static void llistaPuntuacions_ordre_arribada() {
		if(contPuntuacions > 0) {
			IU.titol("Puntuacions en ordre d'arribada", null);

			// Mostrar la llista.
			mostrarLlista(puntuacions);

		} else {
			IU.missatgeAdvertencia("No s'ha trobat cap puntuació registrada");
		}
	}

	// Mètode per veure la llista de puntuacions per odre descendent de punts.
	private static void llistaPuntuacions_ordre_descendent() {
		// Copiar l'array puntuacions a dins del nou array per ordenar-lo de manera diferent.
		Puntuacio[] puntuacions_ordre_descendent = Arrays.copyOf(puntuacions, contPuntuacions);

		if(contPuntuacions > 0) {
			IU.titol("Puntuacions en ordre descendent de punts", null);

			// Ordenar amb el mètode de selecció directa.
			for (int i = 0; i < contPuntuacions - 1; i++) {
				int indexMenor = i;
				for (int j = i + 1; j < contPuntuacions; j++) {
					if (puntuacions_ordre_descendent[j].getPunts() > puntuacions_ordre_descendent[indexMenor].getPunts()) {
						indexMenor = j;
					}
				}

				Puntuacio temp = puntuacions_ordre_descendent[indexMenor];
				puntuacions_ordre_descendent[indexMenor] = puntuacions_ordre_descendent[i];
				puntuacions_ordre_descendent[i] = temp;
			}

			// Mostrar la llista.
			mostrarLlista(puntuacions_ordre_descendent);

		} else {
			IU.missatgeAdvertencia("No s'ha trobat cap puntuació registrada");
		}
	}

	// Mètode per veure la llista de puntuacions per odre alfabètic de cognoms.
	private static void llistaPuntuacions_ordre_alfabetic() {
		// Copiar l'array puntuacions a dins del nou array per ordenar-lo de manera diferent.
		Puntuacio[] puntuacions_ordre_alfabetic = Arrays.copyOf(puntuacions, contPuntuacions);

		if(contPuntuacions > 0) {
			IU.titol("Puntuacions en ordre alfabètic de cognoms (a-z)", null);

			// Ordenar amb el mètode de la bombolla.
			for (int i = 0; i < contPuntuacions - 1; i++) {
				for (int j = i + 1; j < contPuntuacions; j++) {
					if (puntuacions_ordre_alfabetic[i].getCognoms().compareTo(puntuacions_ordre_alfabetic[j].getCognoms()) > 0) {
						Puntuacio temp = puntuacions_ordre_alfabetic[i];
						puntuacions_ordre_alfabetic[i] = puntuacions_ordre_alfabetic[j];
						puntuacions_ordre_alfabetic[j] = temp;
					}
				}
			}

			// Mostrar la llista.
			mostrarLlista(puntuacions_ordre_alfabetic);

		} else {
			IU.missatgeAdvertencia("No s'ha trobat cap puntuació registrada");
		}
	}

	// Mètode per mostrar la llista de puntuacions.
	private static void mostrarLlista(Puntuacio[] array) {
		int i = 1;
		for(Puntuacio p : array) {
			if(p != null) {
				IU.sortida(" PUNTUACIÓ (" + i + "):\n" + p);
				i++;
			}
		}
	}

	// Mètode per sortir del programa.
	private static void sortir() {
		IU.titol("Fi del programa", null);
		IU.missatge("Fins a una altra! 👋");
		System.exit(0);
		System.out.println(System.lineSeparator());
	}

}
