package IU;

public class Missatge {
	
	public static void ErrorFatal(String missatge) {
		System.err.println("\n 🚫 Error Fatal: " + missatge + "!\n");
	}

	public static void Error(String missatge) {
		System.out.println("\n ❌ Error: " + missatge + ".\n");
	}
	
	public static void Advertencia(String missatge) {
		System.out.println("\n ⚠️ Advertència: " + missatge + ".\n");
	}
	
	public static void Exit(String missatge) {
		System.out.println("\n ✔️ Èxit: " + missatge + "!\n");
	}
	
	public static void Personalitzat(String emoji, String titol, String missatge) {
		System.out.println("\n " + emoji + " " + titol + ": " + missatge + ".\n");
	}
	
}
