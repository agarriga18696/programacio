package Exercici_8_1;

public class IU {

	protected static void Separador() {
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < 90; i++) {
			s.append("-");
		}
		
		System.out.println(" " + s + "\n");
	}
	
	protected static void SaltLinia() {
		System.out.println(System.lineSeparator());
	}
	
	protected static void Titol(String t, String s) {
		Separador();
		String mostrar_s = s != null ? ": " + s : "";
		System.out.println(" " + t.toUpperCase() + mostrar_s + "\n");
	}
	
	protected static void Missatge(String m) {
		System.out.println("\n " + m + ".");
	}
	
	protected static void MissatgeExit(String m) {
		System.out.println("\n ✔️ Èxit: " + m + ".");
	}
	
	protected static void MissatgeFall(String m) {
		System.out.println("\n ❌ Fall: " + m + ".");
	}
	
	protected static void MissatgeEntrada(String m) {
		System.out.print("\n " + m + ": ");
	}
	
}
