package Exercicis.Exercici_6_12;

import java.util.Scanner;

public class Cua {

	private static Scanner in = new Scanner(System.in);
	private static final int MIDA_CUA = 5;
	private static Persona[] cua = new Persona[MIDA_CUA];
	private static int contPersones = 0; 

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

		if(contPersones >= MIDA_CUA) {
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
			cua[contPersones] = new Persona(nom);
			contPersones++;
		}
	}

	// Treure a la primera persona de la cua.
	private static void avancarCua() {
		System.out.println(System.lineSeparator());
		System.out.println(" AVANÇAR CUA\n");

		if(contPersones <= 0) {
			System.out.println(" No pots avançar la cua quan no hi ha ningú!\n");

		} else {
			// Treure a la primera persona de la cua.
			Persona p = cua[0];
			p.eliminar();
			System.out.println("\n " + p.getNom() + " ha abandonat la cua.\n");

			// Reorganitzar l'array per no deixar el primer index null.
			for(int i = 0; i < contPersones - 1; i++) {
				cua[i] = cua[i+1];
			}

			cua[contPersones - 1] = null;
			contPersones--;
		}
	}

	// Treure a una persona en concret de la cua.
	private static void treurePersona() {
		System.out.println(System.lineSeparator());
		System.out.println(" TREURE PERSONA\n");

		if(contPersones <= 0) {
			System.out.println(" No pots treure a una persona quan la cua és buida!\n");

		} else {
			boolean pValida = false;
			String nom = validarString("Nom");

			// Verificar que existeix una persona amb el nom introduït.
			for(int i = 0; i < contPersones; i++) {
				Persona p = cua[i];

				if(p != null && nom.equalsIgnoreCase(p.getNom())) {
					// 'Eliminar' a la persona.
					p.eliminar();
					System.out.println("\n Has tret a " + nom + " de la cua.\n");

					// Reorganitzar l'array per no deixar index nulls entre mig.
					for(int j = i; j < contPersones - 1; j++) {
						cua[j] = cua[j+1];
					}

					cua[contPersones - 1] = null;
					contPersones--;
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
		System.out.println(" CUA [espais disponibles " + (5 - contPersones) + "]\n");

		// Mostrar les persones de la cua.
		if(contPersones <= 0) {
			System.out.println(" La cuida és buida! Afegeix persones a la cua!");

		} else {
			for(int i = 0; i < contPersones; i++) {
				Persona p = cua[i];

				// Verificar que no hi hagi una persona null a l'array.
				if(p != null) {
					p.setPosicio(i+1);
					System.out.println(p.mostrar());
				}
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
