package Exercici_7_1_Penjat;

import java.util.Scanner;

public class Validar extends Entrada {
	
	private static Scanner in = new Scanner(System.in);

	// Validar un nombre int.
	public static int enter(String missatge) {
		boolean esValid = false;
		int nombre = 0;

		while(!esValid) {
			System.out.print("\n " + missatge + ": ");
			if(in.hasNextInt()) {
				nombre = in.nextInt();
				in.nextLine();
				esValid = true;
				break;
			} else {
				Missatge.Error("El valor introduït no és vàlid pel tipus de dada 'int'");
				in.nextLine();
			}
		}

		return nombre;
	}

	// Validar un String.
	public static String cadena(String missatge) {
		boolean esValid = false;
		String cadena = null;

		while(!esValid) {
			System.out.print("\n " + missatge + ": ");
			if(in.hasNextLine()) {
				cadena = in.nextLine();
				esValid = true;
				break;
			} else {
				Missatge.Error("El valor introduït no és vàlid pel tipus de dada 'String'");
				in.nextLine();
			}
		}

		return cadena.trim();
	}
	
	// Validar la lletra del jugador.
	public static String lletra(String missatge) {
		String lletra = null;
		boolean esValida = false;
		
		do {
			lletra = Entrada.cadena("Lletra");
			
			if(lletra != null && !lletra.isEmpty() && lletra.length() == 1) {
				
				// Comprovar que el caracter sigui una lletra.
				if(Character.isAlphabetic(lletra.charAt(0))) {
					esValida = true;
					break;
					
				} else {
					Missatge.Error("'" + lletra + "' no és una lletra");
				}
				
			} else {
				if(lletra.length() > 1) {
					Missatge.Error("Escriu només una lletra");
					
				} else if(lletra.length() <= 0 || lletra == null && lletra.isEmpty()) {
					Missatge.Error("Has d'escriure una lletra");
					
				}
			}
			
		} while(!esValida);
		
		return lletra.trim();
	}

}
