package Exercicis.Exercici_6_4;

import java.util.Scanner;

public class Main {

	private static Scanner in = new Scanner(System.in);
	private static int dia = 0, mes = 0, any = 0;
	private static String dataUsuari = null;

	public static void main(String[] args) {

		do {
			System.out.println("Introdueix una data amb el format (dd/mm/aaaa) en cas que sigui DC, o (dd/mm/-aaaa) en cas que sigui AC.");
			System.out.print("Data: ");

			if(in.hasNextLine()) {
				dataUsuari = in.nextLine().trim();
				// Eliminar caracters especials, menys la barra '/' i el guió '-', ja que es podràn introduïr dates negatives (AC).
				String dataCompleta = dataUsuari.replaceAll("[^0-9-]+", "");
				// Controlar que introdueixi un format de data vàlid, segons el length mínim i màxim.
				// Per què sigui un format vàlid haurà de tenir les següents característiques:
				// -> En cas que sigui una data positiva (DC):
				//		-> Tenir com a mínim 5 caracters (ddmma).
				// 		-> Tenir com a màxim 8 caracters (ddmmaaaa).
				// -> En cas que sigui una data negativa (AC):
				//		-> Tenir com a mínim 6 caracters (ddmm-a).
				// 		-> Tenir com a màxim 9 caracters (ddmm-aaaa).
				if (dataCompleta.length() >= 8 && ((dataCompleta.charAt(4) == '-' && dataCompleta.length() >= 6 && dataCompleta.length() <= 9) || (dataCompleta.charAt(4) != '-' && dataCompleta.length() >= 5 && dataCompleta.length() <= 8))) {
					// Assignar dia, mes i any a les variables numèriques.
					dia = Integer.parseInt(dataCompleta.substring(0, 2));
					mes = Integer.parseInt(dataCompleta.substring(2, 4));
					any = Integer.parseInt(dataCompleta.substring(4));
					break; // Sortir del bucle do-while.
				} else {
					System.out.println("Format de data no vàlid.");
				}
			} else {
				System.out.println("La data introduïda no és vàlida.");
			}

		} while(dataUsuari.length() < 7);
		
		// Crear Data amb els valors introduïts anteriorment.
		Data data = new Data(dia, mes, any);
		System.out.println("\nData introduïda: " + data.getDia() + "/" + data.getMes() + "/" + data.getAny());
		
		boolean dataValida = data.dataValida();
		// Es mostrarà la següent informació només si la data introduïda és correcta.
		if(dataValida) {
			data.easterEgg();
			data.anyTraspas(dia, mes, any);
			data.dema();

		} else {
			System.out.println("La data no existeix.");
		}

		in.close();

	}

}
