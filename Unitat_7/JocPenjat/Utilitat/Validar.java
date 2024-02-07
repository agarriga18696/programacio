package Utilitat;

import IU.Missatge;

public class Validar extends Entrada {

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

		return cadena;
	}

}
