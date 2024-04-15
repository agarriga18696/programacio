package Exercici_9_8;

import java.util.LinkedList;
import java.util.Scanner;

public class CuaAmbLinkedList {

	private static Scanner in = new Scanner(System.in);
	private static final int MIDA_CUA = 5;
	// Canvi a LinkedList.
	private static LinkedList<Persona> cua = new LinkedList<>();

	public static void main(String[] args) {
		// La cua es mostrarà sempre.
		while(true) {
			mostrarCua();
			menu();
		}
	}

	// Menu principal.
	private static void menu() {
		System.out.println(System.lineSeparator());
		System.out.println(" ----------------------------------------------------\n");
		System.out.println(" (1) Afegir persona.");
		System.out.println(" (2) Avançar cua.");
		System.out.println(" (3) Treure persona.");
		System.out.println(" (4) Sortir.");

		boolean opcioValida = false;

		while(!opcioValida) {
			int opcio = validarInt("Opció");

			switch(opcio) {
			case 1:
				afegirPersona();
				return;
			case 2:
				avancarCua();
				return;
			case 3:
				treurePersona();
				return;
			case 4:
				sortir();
				return;
			default:
				break;
			}
		}
	}

	// Afegir persona a la cua.
	private static void afegirPersona() {
		System.out.println(System.lineSeparator());
		System.out.println(" AFEGIR PERSONA");

		if(cua.size() >= MIDA_CUA) {
			System.out.println("\n La cua és plena! Treu a una persona de la cua per afegir-ne més.\n");

		} else {
			boolean pValida = false;
			String nom;

			do {
				nom = validarString("Nom");
				if(nom.isBlank() || nom.isEmpty()) {
					System.err.println("\n La persona ha de tenir un nom!");

				} else {
					pValida = true;

					for(Persona p : cua) {
						if(p != null && p.getNom().equalsIgnoreCase(nom)) {
							System.err.println("\n La persona " + nom + " ja és a la cua!");
							pValida = false;
							break;
						}
					}
				}

			} while(!pValida);

			System.out.println("\n '" + nom + "' s'ha afegit a la cua!\n");

			cua.add(new Persona(nom)); // Afegir la nova persona a la LinkedList.
		}
	}

	// Treure a la primera persona de la cua.
	private static void avancarCua() {
		System.out.println(System.lineSeparator());
		System.out.println(" AVANÇAR CUA\n");

		if(cua.isEmpty()) { // Utilitzo isEmpty per verificar si la LinkedList està buida.
			System.out.println(" No pots avançar la cua quan no hi ha ningú!\n");

		} else {
			// Treure a la primera persona de la cua.
			Persona p = cua.removeFirst(); // Utilizo removeFirst per eliminar i retornar la primera persona de la LinkedList.
			p.eliminar();

			System.out.println("\n " + p.getNom() + " ha abandonat la cua.\n");
		}
	}

	// Treure a una persona en concret de la cua.
	private static void treurePersona() {
		System.out.println(System.lineSeparator());
		System.out.println(" TREURE PERSONA\n");

		if(cua.isEmpty()) {
			System.out.println(" No pots treure a una persona quan la cua és buida!\n");

		} else {
			boolean pValida = false;
			String nom = validarString("Nom");

			// Verificar que existeix una persona amb el nom introduït.
			for(Persona p : cua) {
				if(p != null && nom.equalsIgnoreCase(p.getNom())) {
					// Eliminar a la persona.
					p.eliminar();
					System.out.println("\n Has tret a " + nom + " de la cua.\n");
					cua.remove(p); // Utilitzo remove per eliminar la persona de la cua.
					pValida = true;
					break;
				}
			}

			if(!pValida) {
				System.out.println("\n No s'ha trobat a la persona '" + nom + "' a la cua.\n");
			}
		}
	}

	// Mostrar les persones de la cua.
	private static void mostrarCua() {
		System.out.println(" ----------------------------------------------------");
		System.out.println(System.lineSeparator());
		System.out.println(" CUA AMB LINKEDLIST [espais disponibles " + (5 - cua.size()) + "]\n");

		// Mostrar les persones de la cua.
		if(cua.isEmpty()) {
			System.out.println(" La cuida és buida! Afegeix persones a la cua!");

		} else {
			int i = 1;
			for(Persona p : cua) {
				p.setPosicio(i);
				System.out.println(p.mostrar());
				i++;
			}
		}
	}

	// Sortir del programa.
	private static void sortir() {
		System.out.println(System.lineSeparator());
		System.out.println(" Fins un altre cop!");
		System.exit(0);
	}

	// Validar int.
	private static int validarInt(String m) {
		int n;

		while(true) {
			System.out.print("\n " + m + ": ");
			if(in.hasNextInt()) {
				n = in.nextInt();
				in.nextLine();
				return n;

			} else {
				System.err.println("\n Valor 'int' no vàlid.");
				in.nextLine();
			}
		}
	}

	// Validar String.
	private static String validarString(String m) {
		String s;

		while(true) {
			System.out.print("\n " + m + ": ");
			if(in.hasNextLine()) {
				s = in.nextLine();
				return s.toUpperCase().trim();

			} else {
				System.err.println("\n Valor 'String' no vàlid.");
				in.nextLine();
			}
		}
	}
}
