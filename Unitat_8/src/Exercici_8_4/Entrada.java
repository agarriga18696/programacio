package Exercici_8_4;

import java.util.Scanner;

public class Entrada {

	private static Scanner in = new Scanner(System.in);

	// Mètode per tancar l'entrada.
	protected static void tancar() {
		in.close();
	}

	// Mètode per introduir una cadena en format DNI.
	protected static String dni() {
		while(true) {
			System.out.print("\n DNI: ");

			try {
				String dni = in.nextLine().trim();
				if(dni.length() != 0) {
					// Comprovar que els primers 8 caracters siguin nombres, i que el darrer sigui una lletra.
					if(dni.length() == 9 && dni.substring(0, 8).matches("[0-9]+") && dni.substring(8).matches("[a-zA-Z]+")) {
						return dni.toUpperCase();
					} else {
						throw ExcepcioDni.dniIncorrecte();
					}
				} else {
					throw new ExcepcioDni("El DNI no pot estar buit.");
				}

			} catch(ExcepcioDni e) {
				Missatge.excepcio(e.getMessage());
			}
		}
	}

	// Mètode per haver de prémer una tecla per poder continuar.
	protected static void premerTecla(String m) {
		IU.saltLinia();
		Missatge.simple("🕹️ Prem la tecla 'ENTER' per " + m);
		
		in.nextLine();
	}

}
