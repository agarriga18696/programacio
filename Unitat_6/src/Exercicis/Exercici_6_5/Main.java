package Exercicis.Exercici_6_5;

import java.util.Scanner;

public class Main {

	private static Scanner cin = new Scanner(System.in);

	// Array per emmagatzemar alumnes.
	private static Alumne[] alumnes = new Alumne[200];
	// Array per emmagatzemar professors.
	private static Professor[] professors = new Professor[20];

	// Comptador de alumnes i professors (també ens ajudarà a recórrer l'array).
	private static int contAlumnes = 0, contProfessors = 0;

	public static void main(String[] args) {
		short quantPersones = 0;

		System.out.print("Quants alumnes vols registrar? ");
		quantPersones = quantitatPersones();
		for(int i = 0; i < quantPersones; i++) {
			nouAlumne();
		}

		System.out.print("\nQuants professors vols registrar? ");
		quantPersones = quantitatPersones();
		for(int i = 0; i < quantPersones; i++) {
			nouProfessor();
		}

		mostrarLlistatAlumnes();
		mostrarLlistatProfessors();
		
		System.out.println("\nFi del programa.");

		cin.close();

	}

	public static short quantitatPersones() {
		short nombrePersones = 0;

		do {
			if(cin.hasNextShort()) {
				nombrePersones = cin.nextShort();
				cin.nextLine();
				break;
			} else {
				System.out.println("\nValor no vàlid.");
				System.out.print("Quantitat: ");
				cin.nextLine();
			}
		} while(true);

		return nombrePersones;

	}

	// Classe per crear nous alumnes.
	public static void nouAlumne() {

		String nom = null, dni = null, nivellEstudis = null;
		byte edat = 0;

		do {
			// Assignar les dades al nou alumne.
			System.out.println("\nEscriu les dades de l'alumne [" + (contAlumnes+1) + "]");
			System.out.print("Nom: ");
			nom = cin.nextLine().toUpperCase();
			System.out.print("DNI: ");
			dni = verificarDNI();
			System.out.print("Edat: ");
			edat = verificarEdat();
			System.out.print("Nivell d'estudis: ");
			nivellEstudis = cin.nextLine().toUpperCase();

			// Crear alumne.
			alumnes[contAlumnes] = new Alumne(nom, dni, edat, nivellEstudis);

			// Control de valors no vàlids.
			if(
					alumnes[contAlumnes].getNom().isEmpty() ||
					alumnes[contAlumnes].getDNI().isEmpty() ||
					alumnes[contAlumnes].getNivellEstudis().isEmpty()
					) {
				System.out.println("\nERROR! Algun camp és buit. Torna a introduïr les dades.\n");
			} else {
				break;
			}
		} while(true);

		System.out.println("\nAlumne creat amb èxit!");
		contAlumnes++;

	}

	// Classe per crear nous professors.
	public static void nouProfessor() {

		String nom = null, dni = null, assignatura = null;
		byte edat = 0;

		do {
			// Assignar les dades al nou professor.
			System.out.println("\nEscriu les dades del professor [" + (contProfessors+1) + "]");
			System.out.print("Nom: ");
			nom = cin.nextLine().toUpperCase();
			System.out.print("DNI: ");
			dni = verificarDNI();
			System.out.print("Edat: ");
			edat = verificarEdat();
			System.out.print("Assignatura: ");
			assignatura = cin.nextLine().toUpperCase();

			// Crear professor.
			professors[contProfessors] = new Professor(nom, dni, edat, assignatura);

			// Control de valors no vàlids.
			if(
					professors[contProfessors].getNom().isEmpty() ||
					professors[contProfessors].getDNI().isEmpty() ||
					professors[contProfessors].getAssignatura().isEmpty()
					) {
				System.out.println("\nERROR! Algun camp és buit. Torna a introduïr les dades.\n");			
			} else {
				break;
			}
		} while(true);

		System.out.println("\nProfessor creat amb èxit!");
		contProfessors++;

	}

	// Classe per verificar el DNI.
	public static String verificarDNI() {

		String dni = null;
		int digits = 0;
		String taulaCodisDNI[] = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

		// Un DNI té les següents característiques:
		// -> ha de tenir 8 caracters numèrics a l'inici.
		// -> inclou una lletra al final.
		do {
			// Verificar que tingui 8 digits.
			dni = cin.nextLine().trim().toUpperCase();
			// Comprovar mida del DNI.
			if(dni.length() == 9) {
				// Guardar els 8 digits a una variable tipus int.
				digits = Integer.parseInt(dni.substring(0, 8));
				// Verificar que els 8 dígits concordin amb la lletra correcta.
				// Per saber-ho hi ha que calcular els 8 dígits pel mòdul 23 i comparar 
				// el resultat (resta) amb la taula de codis, on servirà d'índex.
				byte resultatModul23 = (byte) (digits % 23);
				if(dni.substring(8,9).equals(taulaCodisDNI[resultatModul23])) {
					break; // és correcte.
				} else {
					System.out.println("\nDNI no vàlid. La lletra no és correcta.");
					System.out.print("DNI: ");
				}

			} else {
				System.out.println("\nDNI no vàlid.");
				System.out.print("DNI: ");
			}

		} while(true);

		return dni;

	}

	// Classe per verificar l'edat.
	public static byte verificarEdat() {

		byte edat = 0;

		do {
			// Comprovar que el valor introduït sigui un nombre.
			if(cin.hasNextByte()) {
				edat = cin.nextByte();
				cin.nextLine();
				break;
			} else {
				System.out.println("\nEdat no vàlida.");
				System.out.print("Edat: ");
				cin.nextLine();
			}

		} while(true);

		return edat;

	}

	// Classe per mostrar el llistat d'alumnes creats.
	public static void mostrarLlistatAlumnes() {
		
		System.out.println("\nLLISTAT ALUMNES:\n");
		
		if(contAlumnes > 0) {
			for(int i = 0; i < contAlumnes; i++) {
				System.out.println("ALUMNE [" + (i+1) + "]");
				alumnes[i].mostrarDades();
			}
		} else {
			System.out.println("No s'ha registrat cap alumne.");
		}

	}

	// Classe per mostrar el llistat de professors creats.
	public static void mostrarLlistatProfessors() {

		System.out.println("\nLLISTAT PROFESSORS:\n");
		
		if(contProfessors > 0) {
			for(int i = 0; i < contProfessors; i++) {
				System.out.println("PROFESSOR [" + (i+1) + "]");
				professors[i].mostrarDades();
			}
		} else {
			System.out.println("No s'ha registrat cap professor.");
		}

	}

}
