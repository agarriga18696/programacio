package Exercici_9_11;

import java.util.Scanner;

public class Entrada {

	protected static Scanner in = new Scanner(System.in);

	// Entrada de variable tipus int.
	public static int enter(String titol) {
		while(true) {
			System.out.print("\n " + titol.trim() + ": ");

			try {
				String entrada = in.nextLine().trim();
				IU.saltLinia();

				if(entrada.isEmpty()) {
					Msg.error("L'entrada no pot estar buida");
				} else {
					int nombre = Integer.parseInt(entrada.trim());
					return nombre;
				}

			} catch(NumberFormatException e) {
				Msg.error("El valor introduït no és un nombre vàlid");
			}
		}
	}

	// Entrada de variable tipus cadena.
	public static String cadena(String titol) {
		while(true) {
			System.out.print("\n " + titol.trim() + ": ");

			if(in.hasNextLine()) {
				String entrada = in.nextLine().trim();

				if(entrada.isEmpty()) {
					IU.saltLinia();
					Msg.error("L'entrada no pot estar buida.");
				} else {
					return entrada;
				}

			} else {
				IU.saltLinia();
				Msg.error("El valor introduït no és una cadena vàlida.");
			}
		}
	}

	// Entrada de variable en format telèfon.
	public static int telefon() {
		while(true) {
			System.out.print("\n Telèfon mòvil: ");

			if(in.hasNextLine()) {
				String tlf = in.nextLine().trim();

				if(tlf.isEmpty()) {
					IU.saltLinia();
					Msg.error("L'entrada no pot estar buida.");

				} else {
					if(tlf.length() == 9 && tlf.matches("[0-9]+") && 
							(tlf.substring(0, 1).equals("6") || tlf.substring(0, 1).equals("7"))) {
						return Integer.parseInt(tlf);

					} else {
						IU.saltLinia();
						Msg.error("Format de telèfon incorrecte. Assegura't que tingui 9 dígits i comenci per 6 o 7");
					}
				}

			} else {
				IU.saltLinia();
				Msg.error("El valor introduït no és vàlid.");
			}
		}
	}

	// Tancar l'entrada.
	protected static void tancarEntrada() {
		in.close();
	}

}
