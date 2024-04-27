package Exercici_10_11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		Msg.titol("Números parells i imparells", null);

		// Generar l'array amb 1000 números aleatoris.
		int[] numeros = generarNumerosAleatoris(1000);
		
		Msg.simple("Array números:");
		Msg.simple("" + Arrays.toString(numeros));

		// Separar els números parells i imparells en dos fitxers diferents.
		separarNumerosParellsImparells(numeros);

	}

	// Mètode per generar un array amb n números aleatoris entre 1 i 1000.
	public static int[] generarNumerosAleatoris(int n) {
		int[] numeros = new int[n];
		Random random = new Random();

		for(int i = 0; i < n; i++) {
			numeros[i] = random.nextInt(1000) + 1; // Generar un número aleatori entre 1 i 1000.
		}

		return numeros;
	}

	// Mètode per separar els números parells i imparells en dos fitxers diferents.
	public static void separarNumerosParellsImparells(int[] numeros) {
		String fitxerParells = "src/Exercici_10_11/numeros_parells.txt";
		String fitxerImparells = "src/Exercici_10_11/numeros_imparells.txt";

		try(BufferedWriter parellsWriter = new BufferedWriter(new FileWriter(fitxerParells));
				BufferedWriter imparellsWriter = new BufferedWriter(new FileWriter(fitxerImparells))) {

			for(int numero : numeros) {
				// Números parells.
				if(numero % 2 == 0) {
					parellsWriter.write(Integer.toString(numero));
					parellsWriter.newLine();

				} else {
					// Números imparells.
					imparellsWriter.write(Integer.toString(numero));
					imparellsWriter.newLine();
				}
			}

			IU.saltLinia();
			Msg.simple("Fitxer números parells: " + extreureNomFitxer(fitxerParells));
			Msg.simple("Fitxer números imparells: " + extreureNomFitxer(fitxerImparells));

		} catch(IOException e) {
			Msg.error("No s'han pogut escriure els fitxers: " + e.getMessage());
		}
	}

	// Mètode per extreure el nom del fitxer de la ruta String.
	private static String extreureNomFitxer(String ruta) {
		String nomFitxer = "";

		for(int i = ruta.length() - 1; i >= 0; i--) {
			if(!ruta.substring(i, i + 1).equals("/")) {
				nomFitxer = ruta.charAt(i) + nomFitxer;
			} else {
				break;
			}
		}

		return nomFitxer;
	}
}

