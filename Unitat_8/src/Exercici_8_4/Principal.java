package Exercici_8_4;

public class Principal {

	public static void main(String[] args) {
		IU.titol("Excepció Personalitzada", null);
		Entrada.premerTecla("iniciar el programa");
		demanarDni();
		Entrada.premerTecla("sortir del programa");
		finalitzar();
	}

	// Mètode per demanar el DNI.
	private static void demanarDni() {
		IU.titol("Nou DNI", "Introdueix un DNI no vàlid per provar l'excepció");
		String dni = Entrada.dni();
		Missatge.exit("El DNI '" + dni + "' és correcte");
	}
	
	// Mètode per finalitzar el programa.
	private static void finalitzar() {
		Entrada.tancar(); // tancar entrada.
		
		IU.saltLinia();
		IU.titol("Finalitzar programa", null);
		Missatge.simple("Fins una altra! 👋");
	}

}
