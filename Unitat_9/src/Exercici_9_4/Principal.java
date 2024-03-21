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
		afegirPersona("Andreu", "12345678A", 25);
		afegirPersona("Tomeu", "12345678B", 26);
		afegirPersona("Maria", "12345678C", 27);
		
		// 3. Mostrar per pantalla la llista original de persones amb els seus detalls (nom, DNI i edat).
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

}
