package Exercici_9_2;

import java.util.*;

public class Institut {

	private static Hashtable<String, Persona> persones = new Hashtable<>();
	private static int contPersones = 0, contAlumnes = 0, contProfes = 0;

	public static void main(String[] args) {
		menu();
	}

	// Mètode pel menú principal.
	private static void menu() {
		int opcio = 0;

		do {
			IU.titol("Institut", null);
			IU.opcions(
					"Registrar alumne", 
					"Registrar professor", 
					"Veure total persones",
					"Veure alumnes",
					"Veure professors",
					"Sortir");
			opcio = Entrada.enter("Opció");

			switch(opcio) {
			case 1:
				registrar_alumne();
				break;
			case 2:
				registrar_profe();
				break;
			case 3:
				mostrar_persones();
				break;
			case 4:
				mostrar_alumnes();
				break;
			case 5:
				mostrar_profes();
				break;
			case 6:
				sortir();
				return;
			default:
				Missatge.error("Opció no vàlida");
				break;
			}

		} while(opcio != 6);
	}

	// Mètode per registrar un nou alumne.
	private static void registrar_alumne() {
		IU.titol("Nou Alumne", "(" + contAlumnes + " alumnes registrats)");

		String nom = Entrada.cadena("Nom");
		String dni = Entrada.dni();
		int edat = Entrada.enter("Edat");
		String estudis = validarEstudis();

		// Afegir nou alumne al vector.
		persones.put(dni, new Alumne(nom, edat, estudis));
		//persones.add(contPersones, new Alumne(nom, dni, edat, estudis));

		// Incrementar els comptadors de persones i alumnes.
		contPersones++;
		contAlumnes++;

		Missatge.exit("Alumne " + nom + " creat correctament");

		//Missatge.sortida(persones.get(0).toString());
	}

	// Mètode per validar que els estudis de l'alumne siguin vàlids.
	private static String validarEstudis() {
		while(true) {
			String estudis_s = Entrada.cadena("Estudis (ESO, BATXILLER, GRAU MITJÀ, GRAU SUPERIOR)");
			String estudis_n = Normalitzar.llevarAccents(estudis_s);

			if(estudis_n.equalsIgnoreCase("ESO") || 
					estudis_n.equalsIgnoreCase("BATXILLER") || 
					estudis_n.equalsIgnoreCase("GRAU MITJA") ||
					estudis_n.equalsIgnoreCase("GRAU SUPERIOR")) {

				return estudis_s;

			} else {
				Missatge.error("Els estudis introduïts no son vàlids");
			}
		}
	}

	private static void registrar_profe() {
		IU.titol("Nou Professor", "(" + contProfes + " professors registrats)");

		String nom = Entrada.cadena("Nom");
		String dni = Entrada.dni();
		int edat = Entrada.enter("Edat");
		String assignatura = validarAssignatura();

		// Afegir nou profe al vector.
		persones.put(dni, new Professor(nom, edat, assignatura));
		//persones.add(contPersones, new Professor(nom, dni, edat, assignatura));

		// Incrementar els comptadors de persones i profes.
		contPersones++;
		contProfes++;

		Missatge.exit("Professor " + nom + " creat correctament");

		//Missatge.sortida(persones.get(0).toString());

	}

	// Mètode per validar que l'assignatura del profe sigui vàlida.
	private static String validarAssignatura() {
		while(true) {
			String assignatura_s = Entrada.cadena("Assignatura (PROGRAMACIÓ, BASES DE DADES, SISTEMES, MARQUES)");
			String assignatura_n = Normalitzar.llevarAccents(assignatura_s);

			if(assignatura_n.equalsIgnoreCase("PROGRAMACIO") || 
					assignatura_n.equalsIgnoreCase("BASES DE DADES") || 
					assignatura_n.equalsIgnoreCase("SISTEMES") ||
					assignatura_n.equalsIgnoreCase("MARQUES")) {

				return assignatura_s;

			} else {
				Missatge.error("L'assignatura introduïda no son vàlids");
			}
		}
	}

	// Mètode per mostrar el total de persones registrades.
	private static void mostrar_persones() {
		IU.titol("Total Persones", "(" + contPersones + ")");

		if(contPersones > 0) {
			for(Map.Entry<String, Persona> p : persones.entrySet()) {
				Missatge.simple("" + p.getKey() + " " + p.getValue().getNom());
			}
		} else {
			Missatge.advertencia("Encara no s'ha registrat cap alumne o professor");
		}
	}

	private static void mostrar_alumnes() {
		IU.titol("Total Alumnes", "(" + contAlumnes + ")");

		if(contPersones > 0) {
			for(Map.Entry<String, Persona> p : persones.entrySet()) {
				Persona persona = p.getValue();
				if(persona instanceof Alumne) {
					Missatge.simple("" + p.getKey() + " " + p.getValue().getNom());
				}
			}
		} else {
			Missatge.advertencia("Encara no s'ha registrat cap alumne o professor");
		}
	}

	private static void mostrar_profes() {
		IU.titol("Total Professors", "(" + contProfes + ")");

		if(contPersones > 0) {
			for(Map.Entry<String, Persona> p : persones.entrySet()) {
				Persona persona = p.getValue();
				if(persona instanceof Professor) {
					Missatge.simple("" + p.getKey() + " " + p.getValue().getNom());
				}
			}
		} else {
			Missatge.advertencia("Encara no s'ha registrat cap alumne o professor");
		}
	}

	private static void sortir() {
		Missatge.simple("Fins a una altra! 👋");
		System.exit(0);
	}

}
