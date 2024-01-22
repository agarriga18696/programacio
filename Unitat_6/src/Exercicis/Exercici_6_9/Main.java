package Exercicis.Exercici_6_9;

import java.util.Scanner;

public class Main {

	private static Scanner cin = new Scanner(System.in);

	// Codis de color i estil pel text.
	public static final String TEXT_GROC = "\u001B[33m";
	private static final String TEXT_VERD = "\u001B[32m";
	public static final String TEXT_NEGRETA = "\u001B[1m";
	private static final String TEXT_PER_DEFECTE = "\u001B[0m";

	// Array per guardar tots els Empleats.
	// [0][i] -> Obrer
	// [1][i] -> Qualificat
	// [2][i] -> Cap de Departament
	private static Empleat empleats[][] = new Empleat[3][50]; 

	public static void main(String[] args) {

		System.out.println(System.lineSeparator());
		System.out.println(TEXT_NEGRETA + " BENVINGUT/DA AL SISTEMA" + TEXT_PER_DEFECTE);

		while(true) {
			mostrarMenu();
		}

	}

	// Mètode per mostrar menú.
	public static void mostrarMenu() {

		mostrarSeparador();
		System.out.println(TEXT_NEGRETA + " MENÚ PRINCIPAL\n" + TEXT_PER_DEFECTE);
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
			mostrarMissatgeError("L'opció introduïda no és vàlida");
			break;
		}

	}

	// Mètode per validar un int.
	private static int validarInt(String missatge) {
		int nombre = 0;

		while(true) {
			System.out.print("\n " + missatge + ": ");

			if(cin.hasNextInt()) {
				nombre = cin.nextInt();
				cin.nextLine();
				return nombre;
			} else {
				mostrarMissatgeError("El valor introduït no és vàlid");
				cin.nextLine();
			}
		}
	}

	// Mètode per validar un double.
	private static double validarDouble(String missatge) {
		double nombre = 0;

		while(true) {
			System.out.print("\n " + missatge + ": ");

			if(cin.hasNextDouble()) {
				nombre = cin.nextDouble();
				cin.nextLine();
				return nombre;
			} else {
				mostrarMissatgeError("El valor introduït no és vàlid");
				cin.nextLine();
			}
		}
	}

	// Mètode per validar una cadena.
	private static String validarCadena(String missatge) {
		String cadena = null;

		while(true) {
			System.out.print("\n " + missatge + ": ");

			if(cin.hasNextLine()) {
				cadena = cin.nextLine();
				return cadena.toUpperCase(); // retornar en majúscules (maníes meves)
			} else {
				mostrarMissatgeError("El caracter introduït no és vàlid");
				cin.nextLine();
			}
		}
	}

	// Mètode per mostrar un missatge d'error personalitzat.
	private static void mostrarMissatgeError(String missatge) {
		System.out.println(System.lineSeparator());
		System.err.println(" ❎ Error: " + missatge + ".");
	}

	// Mètode per mostrar un missatge d'advertència personalitzat.
	private static void mostrarMissatgeAdvertencia(String missatge) {
		System.out.println(System.lineSeparator());
		System.out.println(TEXT_GROC + " ⚠️ Atenció: " + missatge + "." + TEXT_PER_DEFECTE);
	}

	// Mètode per mostrar un missatge d'èxit personalitzat.
	private static void mostrarMissatgeExit(String missatge) {
		System.out.println(System.lineSeparator());
		System.out.println(TEXT_VERD + " ✅ Èxit: " + missatge + "." + TEXT_PER_DEFECTE);
	}

	// Mètode per crear un nou empleat.
	private static void nouEmpleat() {

		mostrarSeparador();
		System.out.println(TEXT_NEGRETA + " NOU EMPLEAT\n" + TEXT_PER_DEFECTE);
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
			return;
		default:
			mostrarMissatgeError("L'opció introduïda no és vàlida");
			break;
		}

	}

	// Mètode per crear un nou Obrer.
	private static void nouObrer() {
		String nom = null, cognoms = null, dni = null, desti = null;
		double souBase = 0, horesExtra = 0, preuHoresExtra = 0;
		boolean objecteCorrecte = false;

		while(!objecteCorrecte) {

			mostrarSeparador();
			System.out.println(TEXT_NEGRETA + " 🛠️ NOU OBRER\n" + TEXT_PER_DEFECTE);

			// Esperar un temps de control per evitar la superposició del missatge d'error al repetir el bucle.
			esperarTemps(20);

			// Introduïr les dades del nou Empleat.
			nom = validarCadena("Nom");
			cognoms = validarCadena("Cognoms");
			dni = validarCadena("DNI");
			desti = validarCadena("Destí");
			souBase = validarDouble("Sou base");
			horesExtra = validarDouble("Hores extra");
			preuHoresExtra = validarDouble("Preu hores extra");

			// Verificar si s'ha deixat algun camp buit o un valor negatiu.
			if(nom.isBlank() || cognoms.isBlank() || dni.isBlank() || desti.isBlank() || souBase < 0 || horesExtra < 0 || preuHoresExtra < 0) {

				// Determinar el missatge d'error.
				if(nom.isBlank()) {
					mostrarMissatgeError("El camp 'Nom' no pot estar buit");
				}
				if(cognoms.isBlank()) {
					mostrarMissatgeError("El camp 'Cognoms' no pot estar buit");
				}
				if(dni.isBlank()) {
					mostrarMissatgeError("El camp 'DNI' no pot estar buit");
				}
				if(desti.isBlank()) {
					mostrarMissatgeError("El camp 'Destí' no pot estar buit");
				}
				if(souBase < 0) {
					mostrarMissatgeError("El camp 'Sou base' no pot contenir valors negatius");
				}
				if(horesExtra < 0) {
					mostrarMissatgeError("El camp 'Hores extra' no pot contenir valors negatius");
				}
				if(preuHoresExtra < 0) {
					mostrarMissatgeError("El camp 'Preu hores extra' no pot contenir valors negatius");
				}

			} else {
				objecteCorrecte = true;
				break;
			}
		}

		// Afegir Obrer al array d'empleats.
		empleats[0][Obrer.getNombreObrers()] = new Obrer(nom, cognoms, dni, souBase, desti, horesExtra, preuHoresExtra);

		// Mostrar missatge d'èxit.
		mostrarMissatgeExit("L'empleat " + nom + " " + cognoms + " s'ha creat correctament");

	}

	// Mètode per crear un nou Qualificat.
	private static void nouQualificat() {
		String nom = null, cognoms = null, dni = null, titulacio = null, departament = null;
		double souBase = 0, plus = 0;
		boolean objecteCorrecte = false;

		while(!objecteCorrecte) {

			mostrarSeparador();
			System.out.println(TEXT_NEGRETA + " 🎓 NOU QUALIFICAT\n" + TEXT_PER_DEFECTE);

			// Esperar un temps de control per evitar la superposició del missatge d'error al repetir el bucle.
			esperarTemps(20);

			// Introduïr les dades del nou Empleat.
			nom = validarCadena("Nom");
			cognoms = validarCadena("Cognoms");
			dni = validarCadena("DNI");
			titulacio = validarCadena("Destí");
			departament = validarCadena("Departament");
			souBase = validarDouble("Sou base");
			plus = validarDouble("Plus");

			// Verificar si s'ha deixat algun camp buit o un valor negatiu.
			if(nom.isBlank() || cognoms.isBlank() || dni.isBlank() || titulacio.isBlank() || departament.isBlank() || souBase < 0 || plus < 0) {

				// Determinar el missatge d'error.
				if(nom.isBlank()) {
					mostrarMissatgeError("El camp 'Nom' no pot estar buit");
				}
				if(cognoms.isBlank()) {
					mostrarMissatgeError("El camp 'Cognoms' no pot estar buit");
				}
				if(dni.isBlank()) {
					mostrarMissatgeError("El camp 'DNI' no pot estar buit");
				}
				if(titulacio.isBlank()) {
					mostrarMissatgeError("El camp 'Titulació' no pot estar buit");
				}
				if(departament.isBlank()) {
					mostrarMissatgeError("El camp 'Departament' no pot estar buit");
				}
				if(souBase < 0) {
					mostrarMissatgeError("El camp 'Sou base' no pot contenir valors negatius");
				}
				if(plus < 0) {
					mostrarMissatgeError("El camp 'Plus' no pot contenir valors negatius");
				}

			} else {
				objecteCorrecte = true;
				break;
			}
		}

		// Afegir Obrer al array d'empleats.
		empleats[1][Qualificat.getNombreQualificats()] = new Qualificat(nom, cognoms, dni, souBase, titulacio, departament, plus);

		// Mostrar missatge d'èxit.
		mostrarMissatgeExit("L'empleat " + nom + " " + cognoms + " s'ha creat correctament");

	}

	// Mètode per crear un nou Cap de Departament.
	private static void nouCapDepartament() {
		String nom = null, cognoms = null, dni = null;
		double souBase = 0, plus = 0;
		int treballadorsACarrec = 0, projectes = 0;
		boolean objecteCorrecte = false;

		while(!objecteCorrecte) {

			mostrarSeparador();
			System.out.println(TEXT_NEGRETA + " 💼 NOU CAP DE DEPARTAMENT\n" + TEXT_PER_DEFECTE);

			// Esperar un temps de control per evitar la superposició del missatge d'error al repetir el bucle.
			esperarTemps(20);

			// Introduïr les dades del nou Empleat.
			nom = validarCadena("Nom");
			cognoms = validarCadena("Cognoms");
			dni = validarCadena("DNI");
			souBase = validarDouble("Sou base");
			treballadorsACarrec = validarInt("Treballadors a càrrec");
			projectes = validarInt("Projectes");
			plus = validarDouble("Plus");

			// Verificar si s'ha deixat algun camp buit o un valor negatiu.
			if(nom.isBlank() || cognoms.isBlank() || dni.isBlank() || souBase < 0 || plus < 0 || treballadorsACarrec < 0 || projectes < 0) {

				// Determinar el missatge d'error.
				if(nom.isBlank()) {
					mostrarMissatgeError("El camp 'Nom' no pot estar buit");
				}
				if(cognoms.isBlank()) {
					mostrarMissatgeError("El camp 'Cognoms' no pot estar buit");
				}
				if(dni.isBlank()) {
					mostrarMissatgeError("El camp 'DNI' no pot estar buit");
				}
				if(souBase < 0) {
					mostrarMissatgeError("El camp 'Sou base' no pot contenir valors negatius");
				}
				if(plus < 0) {
					mostrarMissatgeError("El camp 'Plus' no pot contenir valors negatius");
				}
				if(treballadorsACarrec < 0) {
					mostrarMissatgeError("El camp 'Treballadors a càrrec' no pot contenir valors negatius");
				}
				if(projectes < 0) {
					mostrarMissatgeError("El camp 'Projectes' no pot contenir valors negatius");
				}

			} else {
				objecteCorrecte = true;
				break;
			}
		}

		// Afegir Obrer al array d'empleats.
		empleats[2][CapDepartament.getNombreCapsDepartaments()] = new CapDepartament(nom, cognoms, dni, souBase, treballadorsACarrec, projectes, plus);

		// Mostrar missatge d'èxit.
		mostrarMissatgeExit("L'empleat " + nom + " " + cognoms + " s'ha creat correctament");

	}

	// Mètode per veure un empleat.
	private static void veureEmpleat() {

		// Obrers
		mostrarSeparador();
		System.out.println(TEXT_NEGRETA + " 🛠️ OBRERS" + TEXT_PER_DEFECTE);
		System.out.println(System.lineSeparator());

		// Mostrar els objectes Obrer creats per l'usuari.
		if(Obrer.getNombreObrers() <= 0) {

			mostrarMissatgeAdvertencia("Encara no s'ha creat cap Obrer");

		} else {
			for(int i = 0; i < Obrer.getNombreObrers(); i++) {
				System.out.println(empleats[0][i].toString());
			}
		}

		// Qualificats
		mostrarSeparador();
		System.out.println(TEXT_NEGRETA + " 🎓 QUALIFICATS" + TEXT_PER_DEFECTE);
		System.out.println(System.lineSeparator());

		// Mostrar els objectes Obrer creats per l'usuari.
		if(Qualificat.getNombreQualificats() <= 0) {

			mostrarMissatgeAdvertencia("Encara no s'ha creat cap Qualificat");

		} else {
			for(int i = 0; i < Qualificat.getNombreQualificats(); i++) {
				System.out.println(empleats[1][i].toString());
			}
		}

		// Caps de Departament
		mostrarSeparador();
		System.out.println(TEXT_NEGRETA + " 💼 CAPS DE DEPARTAMENT" + TEXT_PER_DEFECTE);
		System.out.println(System.lineSeparator());

		// Mostrar els objectes Obrer creats per l'usuari.
		if(CapDepartament.getNombreCapsDepartaments() <= 0) {

			mostrarMissatgeAdvertencia("Encara no s'ha creat cap Cap de Departament");

		} else {
			for(int i = 0; i < CapDepartament.getNombreCapsDepartaments(); i++) {
				System.out.println(empleats[2][i].toString());
			}
		}

	}

	// Mètode per esperar temps.
	private static void esperarTemps(long temps) {

		try {
			Thread.sleep(temps);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}

	// Mètode per mostrar una línea separatoria.
	private static void mostrarSeparador() {
		System.out.println(System.lineSeparator());
		System.out.println("----------------------------------------------------------------------------");
		System.out.println(System.lineSeparator());
	}

	// Mètode per sortir del programa.
	private static void sortir() {

		System.out.println("\n 👋 Fins una altra!");
		System.out.println(System.lineSeparator());
		System.exit(0);

	}



}
