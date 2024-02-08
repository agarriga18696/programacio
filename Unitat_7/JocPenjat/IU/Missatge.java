package IU;

public class Missatge {
	
	public static void ErrorFatal(String missatge) {
		System.err.println("\n 🚫 Error Fatal: " + missatge + "!");
	}

	public static void Error(String missatge) {
		System.out.println("\n ❌ Error: " + missatge + ".");
	}
	
	public static void Advertencia(String missatge) {
		System.out.println("\n ⚠️ Advertència: " + missatge + ".");
	}
	
	public static void Exit(String missatge) {
		System.out.println("\n ✔️ Èxit: " + missatge + ".");
	}
	
}
