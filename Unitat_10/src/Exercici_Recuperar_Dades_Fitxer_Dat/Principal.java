package Exercici_Recuperar_Dades_Fitxer_Dat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Principal {

	private static Random random = new Random();
	private static List<Persona> persones = new ArrayList<>();
	private static File fitxer = new File("src/Exercici_Recuperar_Dades_Fitxer_Dat/fitxer.dat");

	public static void main(String[] args) {

		// Generar persones a una llista i guardar-les al fitxer.
		crearPersona(50);
		Dades.guardarDades(persones, fitxer);
		
		// Recuperar les dades del fitxer.
		List<Persona> dadesRecuperades = Dades.carregarDades(fitxer.getAbsolutePath());
		
		// Imprimir el contingut recuperat.
		if(dadesRecuperades != null) {
			for(Persona persona : dadesRecuperades) {
				System.out.println(persona);
			}
		} else {
			System.out.println("No s'han pogut recuperar les dades.");
		}

	}

	// Mètode per crear persones.
	private static void crearPersona(int quantitat) {
		String[] noms = {"Miquel", "Andreu", "Maria", "Laura", "Bernat", "Josep", "Toni", "Júlia"};

		// Generar persones aleatoriament.
		for(int i = 0; i < quantitat; i++) {
			// Inicialitzar una persona amb valors per defecte.
			Persona persona = new Persona();

			// Generar un nom.
			persona.setNom(noms[random.nextInt(noms.length)]);

			// Generar un dni.
			// -> 9 caracters.
			// -> 8 digits + 1 lletra.
			String dni = Integer.toString(10000000 + random.nextInt(90000000));
			dni = dni + (char) (random.nextInt(26) + 65); // generar char (lletra maj.) ASCII.
			persona.setDni(dni);

			// Generar una edat.
			persona.setEdat(random.nextInt(53) + 18); // entre 18 i 70.

			// Afegir persona a la llista.
			persones.add(persona);
		}
	}

}
