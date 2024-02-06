package utilidad;

public class Mensaje {

	public static void error(String mensaje) {	
		System.out.println("\n ❌ Error: " + mensaje + ".");
	}
	
	public static void advertencia(String mensaje) {	
		System.out.println("\n ⚠️ Advertencia: " + mensaje + ".");
	}
	
	public static void exito(String mensaje) {	
		System.out.println("\n ✔️ Éxito: " + mensaje + ".");
	}
	
}
