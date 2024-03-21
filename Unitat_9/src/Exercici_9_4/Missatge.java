package Exercici_9_4;

public class Missatge {

	// Sortida de text sense espaiat.
	protected static void sortida(String m) {
		System.out.println("\n" + m);
	}

	// Missatge simple.
	protected static void simple(String m) {
		System.out.println("\n " + m);
	}

	// Missatge d'èxit.
	protected static void exit(String m) {
		System.out.println("\n ✔️ Èxit: " + m);
	}

	// Missatge d'advertència.
	protected static void advertencia(String m) {
		System.out.println("\n ⚠️ Advertència: " + m);
	}

	// Missatge d'error.
	protected static void error(String m) {
		System.out.println("\n ❌ Error: " + m);
	}

	// Missatge d'error greu.
	protected static void errorGreu(String m) {
		System.out.println("\n ❗ Error greu: " + m);
	}

}
