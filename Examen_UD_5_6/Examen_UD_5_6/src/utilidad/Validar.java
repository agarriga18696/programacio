package utilidad;

import java.util.Scanner;

public class Validar {

	private static Scanner in = new Scanner(System.in);

	// Validar int
	public static int entero(String mensaje) {
		int numero = 0;
		while(true) {
			System.out.print("\n " + mensaje + ": ");
			if(in.hasNextInt()) {
				numero = in.nextInt();
				in.nextLine();
				return numero;
			} else {
				Mensaje.error("El valor no es válido");
				in.nextLine();
			}
		}
	}

	// Validar String
	public static String cadena(String mensaje) {
		String cadena = null;
		while(true) {
			System.out.print("\n " + mensaje + ": ");
			if(in.hasNextLine()) {
				cadena = in.nextLine();
				return cadena.trim().toUpperCase(); // Eliminar espacios del principio y el final y pasar a mayúscula.
			} else {
				Mensaje.error("El valor no es válido");
				in.nextLine();
			}
		}
	}

	// Validar boolean
	public static boolean booleano(String mensaje) {
		boolean booleano = false;
		while(true) {
			System.out.print("\n " + mensaje + ": ");
			if(in.hasNextBoolean()) {
				booleano = in.nextBoolean();
				in.nextLine();
				return booleano;
			} else {
				Mensaje.error("El valor no es válido");
				in.nextLine();
			}
		}
	}

}
