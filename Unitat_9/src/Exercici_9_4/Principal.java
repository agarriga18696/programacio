package Exercici_9_4;

import java.util.ArrayList;

public class Principal {

	// Declarar la llista.
	private static ArrayList<Persona> persones;

	public static void main(String[] args) {
		IU.titol("ArrayList Objectes", "Persones");

		// 1. Crear un ArrayList anomenat persones.
		Missatge.simple("1. Crear un ArrayList anomenat persones.");
		persones = new ArrayList<>();

		// 2. Afegir almenys tres objectes Persona a l'ArrayList, amb diferents noms, DNIs i edats.
		Missatge.simple("2. Afegir almenys tres objectes Persona a l'ArrayList, amb diferents noms, DNIs i edats.");
		afegirPersona("Andreu", "12345678A", 25);
		afegirPersona("Tomeu", "12345678B", 22);
		afegirPersona("Maria", "12345678C", 27);

		// 3. Mostrar per pantalla la llista original de persones amb els seus detalls (nom, DNI i edat).
		Missatge.simple("3. Mostrar per pantalla la llista original de persones amb els seus detalls (nom, DNI i edat).");
		mostrarPersones();

		// 4. Afegir una nova persona a l'ArrayList.
		Missatge.simple("4. Afegir una nova persona a l'ArrayList.");
		afegirPersona("Clara", "12345678D", 18);

		// 5. Mostrar per pantalla la llista actualitzada de persones després d'afegir la nova persona.
		Missatge.simple("5. Mostrar per pantalla la llista actualitzada de persones després d'afegir la nova persona.");
		mostrarPersones();

		// 6. Eliminar una persona de l'ArrayList utilitzant el seu DNI com a referència.
		Missatge.simple("6. Eliminar una persona de l'ArrayList utilitzant el seu DNI com a referència.");
		eliminarPersona(persones.get(2).getDni());
		
		// 7. Mostrar per pantalla la llista de persones després d'eliminar la persona especificada.
		Missatge.simple("7. Mostrar per pantalla la llista de persones després d'eliminar la persona especificada.");
		mostrarPersones();

	}

	// Mètode per afegir persones a la llista.
	private static void afegirPersona(String nom, String dni, int edat) {
		persones.add(new Persona(nom, dni, edat));
	}

	// Mètode per mostrar les persones.
	private static void mostrarPersones() {
		for(Persona p : persones) {
			Missatge.sortida("" + p);
		}
	}

	// Mètode per eliminar una persona amb el seu DNI.
	private static void eliminarPersona(String dni) {
		int pEliminar = 0;

		for(int i = 0; i < persones.size(); i++) {
			Persona p = persones.get(i);
			if(p.getDni().equalsIgnoreCase(dni)) {
				pEliminar = i;
				break;
			}
		}

		persones.remove(pEliminar);
	}

}
