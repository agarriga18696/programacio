package Exercici_8_4;

public class IU {
	
	// Mètode per mostrar un salt de linia.
	protected static void saltLinia() {
		System.out.println();
	}

	// Mètode per mostrar un títol amb un subtítol opcional.
	protected static void titol(String t, String s) {
		String mostrarSubtitol = s != null && !s.trim().isEmpty() ? ": " + s : "";

		System.out.println("\n\n " + t.toUpperCase() + mostrarSubtitol);
	}

}
