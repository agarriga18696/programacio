package IU;

public class Missatge {

	public static void Error(String missatge) {
		System.err.println("\n Error: " + missatge + ".");
	}
	
	public static void Advertencia(String missatge) {
		System.err.println("\n Advertència: " + missatge + ".");
	}
	
	public static void Exit(String missatge) {
		System.err.println("\n Èxit: " + missatge + ".");
	}
	
}
