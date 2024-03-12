package Examen_7_8;

import java.util.ArrayList;
import java.util.List;

public class Oficina {

	private static int MAX_PERSONES = 10;
	private static List<Persona> persones = new ArrayList<>(MAX_PERSONES);
	private static List<Persona> personesOrdreDni = null;
	private static int quantitatPersones = 0;
	private static int tornPersona = 0;


	public static void main(String[] args) {
		inicialitzarCuaPersones();
		menu();

		Entrada.tancarEntrada();
	}

	// Mètode per inicialitzar la cua de persones.
	private static void inicialitzarCuaPersones() {
		// Inicialitzar les llistes de persones amb la seva mida per defecte.
		persones = new ArrayList<>(MAX_PERSONES);
		personesOrdreDni = new ArrayList<>();
	}

	// Menú principal.
	private static void menu() {
		int opcio = 0;

		do {
			IU.titol("Oficina d'atenció al client", null);
			IU.opcionsMenu(
					"Veure cua de persones", 
					"Arribada d'una persona nova a l'oficina", 
					"Atenció de la primera persona de la cua",
					"Llista de les persones ateses correctament per ordre d'entrada",
					"Llista de persones que no s'han pogut atendre correctament per ordre d'entrada",
					"Llista de les persones ateses correctament per ordre de DNI",
					"Llista de persones que no s'han pogut atendre correctament per ordre de DNI",
					"Sortir del programa");

			opcio = Entrada.enter("Opció");

			switch(opcio) {
			case 1:
				veureCuaPersones();
				break;
			case 2:
				afegirNovaPersona();
				break;
			case 3:
				atencioPrimeraPersonaCua();
				break;
			case 4:
				llista_personesAteses_ordre_entrada(true);
				break;
			case 5:
				llista_personesAteses_ordre_entrada(false);
				break;
			case 6:
				llista_personesAteses_ordre_dni(true);
				break;
			case 7:
				llista_personesAteses_ordre_dni(false);
				break;
			case 8:
				IU.missatge("Fins a una altra! 👋");
				System.exit(0);
				return;
			default:
				IU.missatgeError("L'opció no és vàlida");
				break;
			}
		} while(opcio != 8);
	}

	// Mètode per veure la cua de persones.
	private static void veureCuaPersones() {
		IU.titol("Cua de persones", "(" + persones.size() + ")");

		if(quantitatPersones == 0) {
			IU.missatgeAdvertencia("Encara no s'ha afegit cap persona a la cua");
		} else {
			for(int i = tornPersona; i < quantitatPersones; i++) {
				IU.missatge(persones.get(i).getDni() + "\t" + persones.get(i).getNom() + "\t\t" + persones.get(i).getEdat());
			}
		}
	}

	private static void afegirNovaPersona() {
		if(quantitatPersones < MAX_PERSONES) {
			try {
				boolean personaValida = false;
				do {
					IU.titol("Afegir persona nova", null);
					String dni = Entrada.dni();
					String nom = Entrada.cadena("Nom");
					int edat = Entrada.enter("Edat");

					if(dni.length() != 9) {
						IU.missatgeError("La mida del DNI no és correcta. Ha de tenir 9 caracters (8 digits + 1 lletra)");
					} else {
						personaValida = true;
					}

					persones.add(new Persona(dni, nom, edat));
					quantitatPersones++;

				} while(!personaValida);

			} catch(Exception e) {
				IU.missatgeError("Error al ingresar les dades. Torna-ho a intentar");
			}

			IU.missatgeExit("Persona afegida correctament a la cua");

		} else {
			IU.missatgeAdvertencia("La cua està plena. No es poden afegir més persones");
		}
	}

	// Mètode per atendre a la primera persona de la cua.
	private static void atencioPrimeraPersonaCua() {
		if(quantitatPersones > tornPersona) {
			IU.titol("Atendre a la persona", "" + persones.get(tornPersona).getDni());
			Persona personaAtesa = persones.get(tornPersona);
			personaAtesa.atendre();

			IU.missatge("Persona atesa:");
			IU.sortida(personaAtesa.toString());

			IU.missatge(personaAtesa.isAtesCorrectament() ? "👍 Persona atesa correctament" : "👎 Persona no atesa correctament");
			
			tornPersona++;

		} else {
			IU.titol("Atendre a la persona", "(...)");
			IU.missatgeAdvertencia("No hi ha persones a la cua per atendre");
		}
	}

	private static void llista_personesAteses_ordre_entrada(boolean atesaCorrectament) {
		IU.titol(atesaCorrectament ? "Llista de persones ateses correctament per ordre d'entrada" : "Llista de persones no ateses correctament per ordre d'entrada", null);

		for(int i = 0; i < tornPersona; i++) {
			if(persones.get(i).isAtesCorrectament() == atesaCorrectament) {
				IU.sortida("" + persones.get(i));
			}
		}
	}

	private static void llista_personesAteses_ordre_dni(boolean atesaCorrectament) {
		// Copiar la llista de persones ateses a l'altra llista.
		personesOrdreDni = new ArrayList<>(persones);

		// Ordenació amb l'algorisme de la bombolla.
		for(int i = 0; i < tornPersona - 1; i++) {
			for(int j = 0; j < tornPersona - i - 1; j++) {
				if(personesOrdreDni.get(j).getDni().compareTo(personesOrdreDni.get(j + 1).getDni()) > 0) {
					Persona temp = personesOrdreDni.get(j);
					personesOrdreDni.set(j, personesOrdreDni.get(j + 1));
					personesOrdreDni.set(j + 1, temp);
				}
			}
		}

		// Mostrar la llista ordenada.
		IU.titol(atesaCorrectament ? "Llista de persones ateses correctament per ordre de dni" : "Llista de persones no ateses correctament per ordre de dni", null);

		for(int i = 0; i < tornPersona; i++) {
			if(personesOrdreDni.get(i).isAtesCorrectament() == atesaCorrectament) {
				IU.sortida("" + personesOrdreDni.get(i));
			}
		}
	}

}
