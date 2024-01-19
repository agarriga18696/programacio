package Exercicis.Exercici_6_9;

import java.util.Scanner;

public class Main {

	private static Scanner cin = new Scanner(System.in);

	public static void main(String[] args) {

		while(true) {
			mostrarMenu();
		}

	}

	// Mètode per mostrar menú.
	public static void mostrarMenu() {

		System.out.println(" MENÚ PRINCIPAL\n");
		System.out.println(" (1) Nou empleat");
		System.out.println(" (2) Veure empleat");
		System.out.println(" (3) Sortir");

		int opcio = validarInt("Opció");

		switch(opcio) {
		case 1:
			nouEmpleat();
			break;
		case 2:
			veureEmpleat();
			break;
		case 3:
			sortir();
			break;
		default:
			mostrarMissatgeError("Opció no vàlida");
			break;
		}

	}

	// Mètode per validar un int.
	private static int validarInt(String opcio) {
		int nombre = 0;

		while(true) {
			System.out.print("\n " + opcio + ": ");
			
			if(cin.hasNextInt()) {
				nombre = cin.nextInt();
				cin.nextLine();
				return nombre;
			} else {
				mostrarMissatgeError("Valor no vàlid");
				cin.nextLine();
			}
		}
	}

	// Mètode per validar un double.
	private static double validarDouble(String opcio) {
		double nombre = 0;

		while(true) {
			System.out.print("\n " + opcio + ": ");
			
			if(cin.hasNextDouble()) {
				nombre = cin.nextDouble();
				cin.nextLine();
				return nombre;
			} else {
				mostrarMissatgeError("Valor no vàlid");
				cin.nextLine();
			}
		}
	}

	// Mètode per validar una cadena.
	private static String validarCadena(String opcio) {
		String cadena = null;

		while(true) {
			System.out.print("\n " + opcio + ": ");
			
			if(cin.hasNextLine()) {
				cadena = cin.nextLine();
				return cadena;
			} else {
				mostrarMissatgeError("Caracter no vàlid");
				cin.nextLine();
			}
		}
	}
	
	// Mètode per mostrar un missatge d'error personalitzat.
	private static void mostrarMissatgeError(String missatge) {
		System.err.println("\n ⚠️ Error: " + missatge + ".\n");
	}
	
	// Mètode per mostrar un missatge d'èxit personalitzat.
	private static void mostrarMissatgeExit(String missatge) {
		System.err.println("\n ✔️ Èxit: " + missatge + ".\n");
	}
	
	// Mètode per crear un nou empleat.
	private static void nouEmpleat() {

		System.out.println(System.lineSeparator());
		System.out.println(" NOU EMPLEAT\n");
		System.out.println(" (1) Nou Obrer");
		System.out.println(" (2) Nou Qualificat");
		System.out.println(" (3) Nou Cap de Departament");
		System.out.println(" (4) Tornar enrere");

		int opcio = validarInt("Opció");

		switch(opcio) {
		case 1:
			nouObrer();
			break;
		case 2:
			nouQualificat();
			break;
		case 3:
			nouCapDepartament();
		case 4:
			System.out.println(System.lineSeparator());
			return;
		default:
			mostrarMissatgeError("Opció no vàlida");
			break;
		}

	}

	private static Obrer nouObrer() {
		String nom = null, cognoms = null, dni = null, desti = null;
		double souBase = 0, horesExtra = 0, preuHoresExtra = 0;
		boolean objecteCorrecte = false;

		while(!objecteCorrecte) {
			
			System.out.println(System.lineSeparator());
			System.out.println(" NOU OBRER\n");
			
			// Esperar un temps de control per evitar la superposició del missatge d'error al repetir el bucle.
			esperarTemps(10);
			
			System.out.print(" Nom: ");
			nom = validarCadena("Nom");
			System.out.print("\n Cognoms: ");
			cognoms = validarCadena("Cognoms");
			System.out.print("\n DNI: ");
			dni = validarCadena("DNI");
			System.out.print("\n Sou base: ");
			souBase = validarDouble("Sou base");
			System.out.print("\n Destí: ");
			desti = validarCadena("Destí");
			System.out.print("\n Hores extra: ");
			horesExtra = validarDouble("Hores extra");
			System.out.print("\n Preu hores extra: ");
			preuHoresExtra = validarDouble("Preu hores extra");
			
			// Verificar si s'ha deixat algun camp buit o un valor negatiu.
			if(nom.isBlank() || cognoms.isBlank() || dni.isBlank() || desti.isBlank() || souBase < 0 || horesExtra < 0 || preuHoresExtra < 0) {
				mostrarMissatgeError("Algun camp és buit o alguna dada no és vàlida");
			} else {
				objecteCorrecte = true;
				break;
			}
		}
		
		mostrarMissatgeExit("Empleat creat correctament");
		
		return new Obrer(nom, cognoms, souBase, dni, desti, horesExtra, preuHoresExtra);

	}

	private static void nouQualificat() {
		// TODO Auto-generated method stub

	}

	private static void nouCapDepartament() {
		// TODO Auto-generated method stub

	}

	private static void veureEmpleat() {
		// TODO Auto-generated method stub

	}
	
	private static void esperarTemps(long temps) {
		
		try {
			Thread.sleep(temps);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
	}

	private static void sortir() {

		System.out.println("\n 👋 Fins una altra!");
		System.out.println(System.lineSeparator());
		System.exit(0);

	}



}
