package Exercici_8_1;

public class IU {

	protected static void Separador() {
		for(int i = 0; i < 40; i++) {
			System.out.print("-");
		}
		System.out.println("\n");
	}
	
	protected static void SaltLinia() {
		System.out.println(System.lineSeparator());
	}
	
	protected static void Titol(String t, String s) {
		Separador();
		System.out.println(t.toUpperCase() + ": " + s + ".");
	}
	
	protected static void Missatge(String m) {
		System.out.println("\n" + m);
	}
	
	protected static void MissatgeEntrada(String m) {
		System.out.print("\n" + m + ": ");
	}
	
}
