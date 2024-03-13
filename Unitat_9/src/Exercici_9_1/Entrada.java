package Exercici_9_1;

import java.util.Scanner;

public class Entrada {

	private static Scanner in = new Scanner(System.in);
	
	// Mètode per netejar el buffer d'entrada.
	protected static void netejar() {
		in.nextLine();
	}
	
	// Mètode per tancar l'entrada.
	protected static void tancar() {
		in.close();
	}
	
}
