package Exercicis.Exercici_6_10;

import java.util.Scanner;

public class ClaseDeMates {

	private static Scanner cin = new Scanner(System.in);

	private static int opcioMenuPrincipal = 0;

	// Array per guardar les figures geomètriques creades.
	// [0][i] -> rectangles.
	// [1][i] -> quadrats.
	// [2][i] -> rombes.
	// [3][i] -> cercles.
	private static FiguraGeometrica[][] arrayFigures = new FiguraGeometrica[4][20]; // límit de 20 figures.

	// Array per guardar els contadors de les figures geomètriques creades.
	// [0][i] -> rectangles.
	// [1][i] -> quadrats.
	// [2][i] -> rombes.
	// [3][i] -> cercles.
	private static int contFigura[][] = new int[4][1];

	// Classe main.
	public static void main(String[] args) {

		System.out.println(System.lineSeparator());
		System.out.println(IU.TEXT_NEGRETA + " BENVINGUT/DA A CLASSE DE MATEMÀTIQUES" + IU.TEXT_PER_DEFECTE);

		while(opcioMenuPrincipal != 3) {
			mostrarMenu();
		}

	}

	// Mètode per mostrar menú.
	public static void mostrarMenu() {

		IU.mostrarSeparador();
		System.out.println(IU.TEXT_NEGRETA + " MENÚ PRINCIPAL\n" + IU.TEXT_PER_DEFECTE);
		System.out.println(" (1) Nova Figura Geomètrica");
		System.out.println(" (2) Mostrar figures");
		System.out.println(" (3) Sortir");

		opcioMenuPrincipal = Validar.Int(cin, "Opció");

		switch(opcioMenuPrincipal) {
		case 1:
			novaFigura();
			break;
		case 2:
			mostrarFigures();
			break;
		case 3:
			sortir();
			break;
		default:
			IU.mostrarMissatgeError("L'opció introduïda no és vàlida");
			break;
		}

	}

	// Llista de figures geomètriques disponibles.
	private enum Figures {
		RECTANGLE,
		QUADRAT,
		ROMBE,
		CERCLE;
	}

	private static void novaFigura() {
		String nom = null, tipus = null;
		double x = 0, y = 0, costatA = 0, costatB = 0, diagonalA = 0, diagonalB = 0, centre = 0, radi = 0, diametre = 0;

		System.out.println(System.lineSeparator());
		System.out.println(IU.TEXT_NEGRETA + " NOVA FIGURA GEOMÈTRICA" + IU.TEXT_PER_DEFECTE);

		// Assignar valors a cada variable.
		tipus = Validar.String(cin, "Tipus de figura (rectangle, quadrat, rombe, cercle)");
		Figures figura = Figures.valueOf(tipus);

		switch(figura) {
		case RECTANGLE:
			nouRectangle(nom, x, y, costatA, costatB);
			break;
		case QUADRAT:
			nouQuadrat(nom, x, y, costatA);
			break;
		case ROMBE:
			nouRombe(nom, x, y, costatA, diagonalA, diagonalB);
			break;
		case CERCLE:
			nouCercle(nom, x, y, centre, radi, diametre);
			break;
		default:
			break;
		}

	}

	private static void nouRectangle(String nom, double x, double y, double costatA, double costatB) {
		boolean figuraCorrecta = false;

		while(!figuraCorrecta) {
			nom = Validar.String(cin, "Nom de la figura");
			x = Validar.Double(cin, "Coordenada X");
			y = Validar.Double(cin, "Coordenada Y");
			costatA = Validar.Double(cin, "Costat A");
			costatB = Validar.Double(cin, "Costat B");

			// Comprovar que les dades son vàlides.
			if(nom.isBlank() || costatA <= 0 || costatB <= 0) {

				// Mostrar missatge d'error segons el tipus d'error.
				if(nom.isBlank()) {
					IU.mostrarMissatgeError("El camp 'Nom' no pot estar buit");
				}
				if(costatA <= 0) {
					IU.mostrarMissatgeError("El camp 'Costat A' no pot contenir valors negatius ni ser zero");
				}
				if(costatB <= 0) {
					IU.mostrarMissatgeError("El camp 'Costat B' no pot contenir valors negatius ni ser zero");
				}

			} else {
				figuraCorrecta = true;
				break; // sortir del bucle while.
			}
		}

		IU.mostrarMissatgeExit("La figura " + nom + " s'ha creat correctament" );

		arrayFigures[0][contFigura[0][0]] = new Rectangle(nom, x, y, costatA, costatB);

		contFigura[0][0]++;
	}

	private static void nouQuadrat(String nom, double x, double y, double costat) {
		boolean figuraCorrecta = false;

		while(!figuraCorrecta) {

			nom = Validar.String(cin, "Nom de la figura");
			x = Validar.Double(cin, "Coordenada X");
			y = Validar.Double(cin, "Coordenada X");
			costat = Validar.Double(cin, "Costat");

			// Comprovar que les dades son vàlides.
			if(nom.isBlank() || costat <= 0) {

				// Mostrar missatge d'error segons el tipus d'error.
				if(nom.isBlank()) {
					IU.mostrarMissatgeError("El camp 'Nom' no pot estar buit");
				}
				if(costat <= 0) {
					IU.mostrarMissatgeError("El camp 'Costat' no pot contenir valors negatius ni ser zero");
				}

			} else {
				figuraCorrecta = true;
				break; // sortir del bucle while.
			}

		}

		IU.mostrarMissatgeExit("La figura " + nom + " s'ha creat correctament" );

		arrayFigures[1][contFigura[1][0]] = new Quadrat(nom, x, y, costat);

		contFigura[1][0]++;
	}

	private static void nouRombe(String nom, double x, double y, double costat, double diagonalA, double diagonalB) {
		boolean figuraCorrecta = false;

		while(!figuraCorrecta) {

			nom = Validar.String(cin, "Nom de la figura");
			x = Validar.Double(cin, "Coordenada X");
			y = Validar.Double(cin, "Coordenada X");
			costat = Validar.Double(cin, "Costat");
			diagonalA = Validar.Double(cin, "Diagonal A");
			diagonalB = Validar.Double(cin, "Diagonal B");

			// Comprovar que les dades son vàlides.
			if(nom.isBlank() || costat <= 0 || diagonalA <= 0 || diagonalB <= 0) {

				// Mostrar missatge d'error segons el tipus d'error.
				if(nom.isBlank()) {
					IU.mostrarMissatgeError("El camp 'Nom' no pot estar buit");
				}
				if(costat <= 0) {
					IU.mostrarMissatgeError("El camp 'Costat' no pot contenir valors negatius ni ser zero");
				}
				if(diagonalA <= 0) {
					IU.mostrarMissatgeError("El camp 'Diagonal A' no pot contenir valors negatius ni ser zero");
				}
				if(diagonalB <= 0) {
					IU.mostrarMissatgeError("El camp 'Diagonal B' no pot contenir valors negatius ni ser zero");
				}

			} else {
				figuraCorrecta = true;
				break; // sortir del bucle while.
			}

		}

		IU.mostrarMissatgeExit("La figura " + nom + " s'ha creat correctament" );

		arrayFigures[2][contFigura[2][0]] = new Rombe(nom, x, y, costat, diagonalA, diagonalB);

		contFigura[2][0]++;

	}

	private static void nouCercle(String nom, double x, double y, double centre, double radi, double diametre) {
		boolean figuraCorrecta = false;

		while(!figuraCorrecta) {

			nom = Validar.String(cin, "Nom de la figura");
			x = Validar.Double(cin, "Coordenada X");
			y = Validar.Double(cin, "Coordenada X");
			centre = Validar.Double(cin, "Centre");
			radi = Validar.Double(cin, "Radi");
			diametre = Validar.Double(cin, "Diàmetre");

			// Comprovar que les dades son vàlides.
			if(nom.isBlank() || centre <= 0 || radi <= 0 || diametre <= 0) {

				// Mostrar missatge d'error segons el tipus d'error.
				if(nom.isBlank()) {
					IU.mostrarMissatgeError("El camp 'Nom' no pot estar buit");
				}
				if(centre <= 0) {
					IU.mostrarMissatgeError("El camp 'Centre' no pot contenir valors negatius ni ser zero");
				}
				if(radi <= 0) {
					IU.mostrarMissatgeError("El camp 'Radi' no pot contenir valors negatius ni ser zero");
				}
				if(diametre <= 0) {
					IU.mostrarMissatgeError("El camp 'Diametre' no pot contenir valors negatius ni ser zero");
				}

			} else {
				figuraCorrecta = true;
				break; // sortir del bucle while.
			}
		}

		IU.mostrarMissatgeExit("La figura " + nom + " s'ha creat correctament" );

		arrayFigures[3][contFigura[3][0]] = new Rombe(nom, x, y, centre, radi, diametre);

		contFigura[3][0]++;

	}

	private static void mostrarFigures() {

		IU.mostrarSeparador();
		System.out.println(IU.TEXT_NEGRETA + " LLISTAT DE FIGURES" + IU.TEXT_PER_DEFECTE);

		// Mostrar Rectangles.
		IU.mostrarSeparador();
		System.out.println(IU.TEXT_NEGRETA + " RECTANGLES\n" + IU.TEXT_PER_DEFECTE);

		for(int i = 0; i < contFigura[0].length; i++) {
			arrayFigures[0][i].mostrarInfoFigura();
		}

		// Mostrar Quadrats.
		IU.mostrarSeparador();
		System.out.println(IU.TEXT_NEGRETA + " QUADRATS\n" + IU.TEXT_PER_DEFECTE);

		for(int i = 0; i < contFigura[1].length; i++) {
			arrayFigures[1][i].mostrarInfoFigura();
		}

		// Mostrar Rombes.
		IU.mostrarSeparador();
		System.out.println(IU.TEXT_NEGRETA + " ROMBES\n" + IU.TEXT_PER_DEFECTE);

		for(int i = 0; i < contFigura[2].length; i++) {
			arrayFigures[2][i].mostrarInfoFigura();
		}

		// Mostrar Cercles.
		IU.mostrarSeparador();
		System.out.println(IU.TEXT_NEGRETA + " CERCLES\n" + IU.TEXT_PER_DEFECTE);

		for(int i = 0; i < contFigura[3].length; i++) {
			arrayFigures[3][i].mostrarInfoFigura();
		}


	}

	// Mètode per sortir del programa.
	private static void sortir() {

		System.out.println("\n 👋 Fins una altra!");
		System.out.println(System.lineSeparator());
		System.exit(0);

	}


}
