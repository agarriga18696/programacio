package Exercici_8_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GestioExcepcions {

	private static String comanda = null;

	public static void main(String[] args) {
		iniciar_joc();
		Entrada.premerTecla("començar la partida");
		excepcio_1();
		Entrada.premerTecla("poder passar a la següent excepció");
		excepcio_2();
		Entrada.premerTecla("acabar la partida");
		fiJoc();
	}

	private static void iniciar_joc() {
		IU.titol("Joc de les Excepcions", "Part II");
	}

	// IOException.
	private static void excepcio_1() {
		IU.titol("Excepció 1", "IOException");
		Missatge.simple("Aquesta excepció es llança al trobar un error al llegir o escriure.\n"
				+ " En aquest exemple intentarem llegir un arxiu que no existeix.");

		do {
			Missatge.simple("Escriu 'LLEGIR' per intentar llegir l'arxiu.");
			comanda = Entrada.cadena("Comanda");
		} while(!comanda.equalsIgnoreCase("LLEGIR"));

		// Intentar llegir l'arxiu inexistent.
		try {
			FileInputStream in = new FileInputStream("fitxer.txt");

		} catch (FileNotFoundException e) {
			Missatge.errorGreu("No s'ha pogut trobar l'arxiu.");

		} finally {
			IU.saltLinia();
			Missatge.simple("Com pots comprovar s'ha llançat l'excepció amb el misatge d'error.");
			Missatge.simple("Aquest tipus d'excepció requereix d'un bloc try-catch o un throws.");
		}
	}

	// NullPointerException.
	private static void excepcio_2() {
		IU.titol("Excepció 2", "NullPointerException");
		Missatge.simple("Aquesta excepció es llança al intentar utilitzar una referència d'un objecte\n"
				+ " que té un valor 'null'.\n\n"
				+ " En aquest exemple tenim un objecte de tipus 'String' amb un valor null, i l'intentarem\n"
				+ " convertir a una variable primitiva de tipus 'char' amb un cast.");

		do {
			Missatge.simple("Escriu 'CONVERTIR' per realitzar el cast.");
			comanda = Entrada.cadena("Comanda");
		} while(!comanda.equalsIgnoreCase("CONVERTIR"));

		// Realitzar el cast.
		try {
			String cadena = null;
			char caracter = cadena.charAt(0);

		} catch (NullPointerException e) {
			Missatge.errorGreu("No s'ha pogut realitzar el cast a 'char' ja que el valor és null.");

		} finally {
			IU.saltLinia();
			Missatge.simple("Com pots comprovar s'ha llançat l'excepció amb el misatge d'error.");
			Missatge.simple("Aquest tipus d'excepció NO requereix d'un bloc try-catch o un throws, per\n"
					+ " lo que hi ha que anar més en compte, ja que se ens pot passar per alt i provocar\n"
					+ " que el nostre programa no funcioni correctament.");
		}

	}

	// Mètode per sortir del joc.
	private static void fiJoc() {
		// Tancar el búfer d'entrada.
		Entrada.tancar();
		
		IU.titol("Fi del joc", null);
		Missatge.exit("Ja has arribat al final del joc! Enhorabona! Gràcies per jugar");
		IU.saltLinia();
		System.exit(0);
	}

}
