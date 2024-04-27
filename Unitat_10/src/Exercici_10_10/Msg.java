package Exercici_10_10;

public class Msg {
	
	// Sortida de text en format títol.
	protected static void titol(String t, String msg) {
		System.out.println("\n " + t.toUpperCase() + ": " + (msg == null || msg.isEmpty() ? "" : msg));
		
		int mida_titol = (t.length() + (msg != null && !msg.isEmpty() ? msg.length() : -1)) + 2;
		for(int i = 0; i <= mida_titol; i++) {
			System.out.print((i == 0 ? " " : "-") + (i == mida_titol ? "\n" : ""));
		}
		
		IU.saltLinia();
	}

	// Sortida de missatge simple.
	protected static void simple(String msg) {
		System.out.println(" " + msg + "\n");
	}

	// Sortida de missatge d'información.
	protected static void info(String msg) {
		System.out.println(" ℹ️ INFO: " + msg + "\n");
	}

	// Sortida de missatge d'advertència.
	protected static void advertencia(String msg) {
		System.out.println(" ⚠️ ADVERTÈNCIA: " + msg + "\n");
	}

	// Sortida de missatge d'error.
	protected static void error(String msg) {
		System.out.println(" 🚫 ERROR: " + msg + "\n");
	}

	// Sortida de missatge d'èxit.
	protected static void exit(String msg) {
		System.out.println(" ✔️ ÈXIT: " + msg + "\n");
	}

}
