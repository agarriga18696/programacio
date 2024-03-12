package Examen_UD7_UD8;

import java.util.ArrayList;
import java.util.List;

public class GestorPuntuacions {

	private static List<Puntuacio> puntuacions = new ArrayList<>();
	private static int contPuntuacions = 0;

	public static void main(String[] args) {
		menu();
	}

	// Mètode per mostrar el menú principal.
	private static void menu() {
		int opcio = 0;

		do {
			IU.titol("Gestor de Puntuacions", null);
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

			// Validar que el nom contingui únicament caracters alfabètics.
			if(nom.matches("[A-aZ-Z]+")) {
				puntuacions.add(new Puntuacio(nom, cognoms, punts));
				contPuntuacions++;
				puntuacioValida = true;

			} else {
				IU.missatgeError("El nom '" + nom + "' no és un nom vàlid");
			}

		} while(!puntuacioValida);

		IU.missatgeExit("S'ha afegit la puntuació correctament");
	}

	// Mètode per veure la llista de puntuacions per ordre d'arribada.
	private static void llistaPuntuacions_ordre_arribada() {
		if(contPuntuacions > 0) {
			IU.titol("Puntuacions en ordre d'arribada", null);

			int i = 1;
			for(Puntuacio p : puntuacions) {
				IU.missatge("PUNTUACIÓ (" + i + "):\n" + p);
				i++;
			}
		} else {
			IU.missatgeAdvertencia("No s'ha trobat cap puntuació registrada");
		}
	}

	// Mètode per veure la llista de puntuacions per odre descendent de punts.
	private static void llistaPuntuacions_ordre_descendent() {
		List<Puntuacio> puntuacions_ordre_descendent = new ArrayList<>(puntuacions);

		if(contPuntuacions > 0) {
			IU.titol("Puntuacions en ordre descendent de punts", null);

			// Ordenar amb el mètode de selecció directa.
			for (int i = 0; i < puntuacions_ordre_descendent.size() - 1; i++) {
				int indexMenor = i;
				for (int j = i + 1; j < puntuacions_ordre_descendent.size(); j++) {
					if (puntuacions_ordre_descendent.get(j).getPunts() > puntuacions_ordre_descendent.get(indexMenor).getPunts()) {
						indexMenor = j;
					}
				}

				Puntuacio temp = puntuacions_ordre_descendent.get(indexMenor);
				puntuacions_ordre_descendent.set(indexMenor, puntuacions_ordre_descendent.get(i));
				puntuacions_ordre_descendent.set(i, temp);
			}

			// Mostrar la llista.
			int i = 1;
			for(Puntuacio p : puntuacions_ordre_descendent) {
				IU.sortida(" PUNTUACIÓ (" + i + "):\n" + p);
				i++;
			}

		} else {
			IU.missatgeAdvertencia("No s'ha trobat cap puntuació registrada");
		}
	}

	// Mètode per veure la llista de puntuacions per odre alfabètic de cognoms.
	private static void llistaPuntuacions_ordre_alfabetic() {
		List<Puntuacio> puntuacions_ordre_alfabetic = new ArrayList<>(puntuacions);

		if(contPuntuacions > 0) {
			IU.titol("Puntuacions en ordre alfabètic de cognoms (a-z)", null);

			// Ordenar amb el mètode de la bombolla.
			for (int i = 0; i < puntuacions_ordre_alfabetic.size() - 1; i++) {
				for (int j = i + 1; j < puntuacions_ordre_alfabetic.size(); j++) {
					if (puntuacions_ordre_alfabetic.get(i).getCognoms().compareTo(puntuacions_ordre_alfabetic.get(j).getCognoms()) > 0) {
						Puntuacio temp = puntuacions_ordre_alfabetic.get(i);
						puntuacions_ordre_alfabetic.set(i, puntuacions_ordre_alfabetic.get(j));
						puntuacions_ordre_alfabetic.set(j, temp);
					}
				}
			}

			// Mostrar la llista.
			int i = 1;
			for(Puntuacio p : puntuacions_ordre_alfabetic) {
				IU.sortida(" PUNTUACIÓ (" + i + "):\n" + p);
				i++;
			}

		} else {
			IU.missatgeAdvertencia("No s'ha trobat cap puntuació registrada");
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
