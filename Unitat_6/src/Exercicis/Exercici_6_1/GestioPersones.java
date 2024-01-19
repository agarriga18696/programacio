package Exercicis.Exercici_6_1;

public class GestioPersones {

	public static void main(String[] args) {

		// Declarar i inicialitzar objectes.
		Persona p1 = new Persona();
		Persona p2 = new Persona();

		// Definir valors de p1.
		p1.setDni("12345678E");
		p1.setNom("Joan Martínez");
		p1.setEdat((short) 33);

		// Definir valors de p2.
		p2.setDni("87654321N");
		p2.setNom("María Serra");
		p2.setEdat((short) 28);

		p1.mostrarDades();
		p2.mostrarDades();

	}

}
