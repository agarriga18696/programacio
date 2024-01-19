package Exercicis.Exercici_6_6;

import java.util.Scanner;

public class Main {

	private static Scanner cin = new Scanner(System.in);

	// Array per emmagatzemar els objectes:
	// [0][i] -> planetes
	// [1][i] -> satèl·lits
	// [2][i] -> estrelles
	private static ObjecteAstronomic[][] objectesAstronomics = new ObjecteAstronomic[3][20];

	// Variables contadors.
	private static int contPlanetes = 0, contSatelits = 0, contEstrelles;

	public static void main(String[] args) {
		
		mostrarSeparador();
		System.out.println("BENVINGUT AL OBSERVATORI");
		menuPrincipal();

	}

	// Funció per mostrar el menú principal.
	public static void menuPrincipal() {
		int opcio;

		while(true) {
			mostrarSeparador();
			System.out.println("MENÚ PRINCIPAL");
			System.out.println("(1) Registrar nou Cos Celestial");
			System.out.println("(2) Veure llista de Cossos Celestials");
			System.out.println("(3) Sortir");
			System.out.print("Opció: ");

			if(cin.hasNextInt()) {
				opcio = cin.nextInt();
				cin.nextLine();
				if(opcio < 0) {
					opcio = 0;
				} 
			} else {
				System.out.println("Valor no vàlid. Tria una opció del menú\n");
				cin.nextLine();
				continue; // repetir bucle.
			}

			switch(opcio) {
			case 1:
				registrarObjecte();
				break;
			case 2:
				mostrarObjectes();
				break;
			case 3:
				sortirPrograma();
				break;
			default:
				System.out.println("Opció no vàlida. Tria una opció del menú.\n");
				break;
			}

		}
	}

	// Funció per afegir objectes nous.
	public static void registrarObjecte() {
		int opcio;

		while(true) {
			mostrarSeparador();
			System.out.println("REGISTRAR NOU COS CELESTIAL");
			System.out.println("(1) Planeta");
			System.out.println("(2) Satèl·lit");
			System.out.println("(3) Estrella");
			System.out.println("(4) Tornar enrere");
			System.out.print("Opció: ");

			if(cin.hasNextInt()) {
				opcio = cin.nextInt();
				cin.nextLine();
				if(opcio < 0) {
					opcio = 0;
				} 
			} else {
				System.out.println("Valor no vàlid. Tria una opció del menú.\n");
				cin.nextLine();
				continue; // repetir bucle.
			}

			switch(opcio) {
			case 1:
				nouPlaneta();
				break;
			case 2:
				nouSatelit();
				break;
			case 3:
				nouEstrella();
				break;
			case 4:
				menuPrincipal();
				break;
			default:
				System.out.println("Opció no vàlida. Tria una opció del menú.\n");
				break;
			}

		}

	}

	private static void nouPlaneta() {
		String nom, tipus, orbita, habitable;
		boolean esHabitable = false, teAnells = false;
		int nombreLlunes;

		while(true) {
			mostrarSeparador();
			System.out.println("NOU PLANETA [" +  + (contPlanetes + 1) + "]");

			nom = demanarString("Nom");
			tipus = demanarString("Tipus (p.ex: gasós)");
			orbita = demanarString("Òrbita (p.ex: Sol)");
			nombreLlunes = demanarEnterPositiu("Núm. llunes");
			habitable = demanarString("Habitable (s/n)").toUpperCase();
			teAnells = demanarBoolean("Anells (s/n)");

			if (nom.isBlank() || tipus.isBlank() || orbita.isBlank() || habitable.isBlank()) {
				System.out.println("\nERROR! S'han d'omplir tots els camps!");
			} else {
				esHabitable = habitable.equals("S");
				break; // sortir del bucle while.
			}

		}

		System.out.println("\nPlaneta afegit amb èxit!");

		// Crear objecte PLANETA.
		objectesAstronomics[0][contPlanetes] = new Planeta(nom, orbita, tipus, nombreLlunes, esHabitable, teAnells);

		// Incrementar contador de planetes.
		contPlanetes++;

	}

	private static void nouSatelit() {
		String nom, orbita;
		boolean atmosfera = false;

		while(true) {
			mostrarSeparador();
			System.out.println("NOU SATÈL·LIT [" + (contSatelits + 1) + "]");

			nom = demanarString("Nom");
			orbita = demanarString("Òrbita (p.ex: Terra)");
			atmosfera = demanarBoolean("Atmosfera (s/n)");

			if (nom.isBlank() || orbita.isBlank()) {
				System.out.println("\nERROR! S'han d'omplir tots els camps!");
			} else {
				break; // sortir del bucle while.
			}

		}

		System.out.println("\nSatèl·lit afegit amb èxit!");

		// Crear objecte SATÈL·LIT.
		objectesAstronomics[1][contSatelits] = new Satelit(nom, orbita, atmosfera);

		// Incrementar contador de satèl·lits.
		contSatelits++;

	}

	private static void nouEstrella() {
		String nom, etapa, ubicacioGalactica;
		int temperatura;

		while(true) {
			mostrarSeparador();
			System.out.println("NOVA ESTRELLA [" + (contEstrelles + 1) + "]");

			nom = demanarString("Nom");
			etapa = demanarString("Etapa (p.ex: Supernova)");
			temperatura = demanarEnterPositiu("Temperatura en Celsius (p.ex: 5000)");
			ubicacioGalactica = demanarString("Ubicació Galàctica (p.ex: Cinturó d'Orió)");

			if (nom.isBlank() || etapa.isBlank() || ubicacioGalactica.isBlank()) {
				System.out.println("\nERROR! S'han d'omplir tots els camps!");
			} else {
				break; // sortir del bucle while.
			}

		}

		System.out.println("\nEstrella afegida amb èxit!");

		// Crear objecte ESTRELLA.
		objectesAstronomics[2][contEstrelles] = new Estrella(nom, etapa, temperatura, ubicacioGalactica);

		// Incrementar contador d'estrelles.
		contEstrelles++;

	}

	// Funcions per demanar entrades de diferents tipus.
	private static String demanarString(String missatge) {

		System.out.print(missatge + ": ");

		return cin.nextLine().toUpperCase();
	}

	private static int demanarEnterPositiu(String missatge) {

		int nombre;

		while (true) {
			System.out.print(missatge + ": ");

			if (cin.hasNextInt()) {
				nombre = cin.nextInt();
				cin.nextLine();
				if (nombre >= 0) {
					break;
				}
			} else {
				System.out.println("Valor no vàlid.\n");
				cin.nextLine();
			}
		}

		return nombre;
	}
	
	private static boolean demanarBoolean(String missatge) {

		String resposta;

		while (true) {
			System.out.print(missatge + ": ");

			resposta = cin.nextLine().toUpperCase();

			if (resposta.equals("S") || resposta.equals("N")) { // resposta permesa.
				break;
			} else {
				System.out.println("Valor no vàlid. Introdueix 's' o 'n'.\n");
			}
		}

		return resposta.equals("S"); // retorna true
	}
	
	private static void mostrarSeparador() {
		System.out.println("=====================================================");
	}

	// Funció per mostrar el llistat de tots els objectes.
	private static void mostrarObjectes() {
		mostrarSeparador();
		System.out.println("REGISTRE DE COSSOS CELESTIALS");

		// Comprovació en cas que no hi hagi objectes registrats.
		if (contPlanetes == 0 && contSatelits == 0 && contEstrelles == 0) {
			System.out.println("\nNo hi ha cap Cos Celestial per mostrar.");
			return;
		}

		// Mostrar informació dels planetes.
		if(contPlanetes > 0) {
			mostrarSeparador();
			System.out.println("Llistat de Planetes:");
			System.out.println("-----------------------------------------------------");
			for (int i = 0; i < contPlanetes; i++) {
				System.out.println("PLANETA [" + (i+1) + "]");
				((Planeta) objectesAstronomics[0][i]).mostrarDades();
			}
		} else {
			System.out.println("\nNo s'ha registrat cap Planeta.");
		}

		// Mostrar informació dels satèl·lits.
		if(contSatelits > 0) {
			mostrarSeparador();
			System.out.println("Llistat de Satèl·lits:");
			System.out.println("-----------------------------------------------------");
			for (int i = 0; i < contSatelits; i++) {
				System.out.println("SATÈL·LIT [" + (i+1) + "]");
				((Satelit) objectesAstronomics[1][i]).mostrarDades();
			}
		} else {
			System.out.println("\nNo s'ha registrat cap Satèl·lit.");
		}

		// Mostrar informació de les estrelles.
		if(contEstrelles > 0) {
			mostrarSeparador();
			System.out.println("Llistat de Estrelles:");
			System.out.println("-----------------------------------------------------");
			for (int i = 0; i < contEstrelles; i++) {
				System.out.println("ESTRELLA [" + (i+1) + "]");
				((Estrella) objectesAstronomics[2][i]).mostrarDades();
			}
		} else {
			System.out.println("\nNo s'ha registrat cap Estrella.");
		}

		System.out.println();
	}

	// Funció per sortir del programa.
	private static void sortirPrograma() {
		mostrarSeparador();
		System.out.println("\nA l'infinit... i més enllà!");
		System.exit(0);
	}


}
