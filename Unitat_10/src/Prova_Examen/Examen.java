package Prova_Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;

public class Examen {

	private static final File FITXER = new File("src/Prova_Examen/temperatures.txt");
	private static HashMap<String, Double> dades = new HashMap<>();
	private static String[] nomMesos = null;

	public static void main(String[] args) throws IOException {
		llegirDades();
		imprimirDades();
	}

	// Mètode per llegir les dades i calcular la mitjana.
	private static void llegirDades() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(FITXER));

		// Emmagatzemar els noms dels mesos.
		nomMesos = br.readLine().split(",");

		String linia;
		int numLinies = 0;

		while((linia = br.readLine()) != null) {			
			// Emmagatzemar les temperatures.
			String[] temps = linia.split(",");

			// Calcular la mitjana.
			for(int i = 0; i < temps.length; i++) {
				String mes = nomMesos[i];
				double temperatura = Double.parseDouble(temps[i]);

				// sumar les dades de cada mes del mapa.
				if(dades.containsKey(mes)) {
					dades.put(mes, temperatura + dades.get(mes));

				} else {
					dades.put(mes, temperatura);
				}
			}

			numLinies++;
		}

		br.close(); // tancar el buffer.

		// Calcular la mitjana.
		calcularMitjana(numLinies);

	}

	// Mètode per calcular la mitjana.
	private static void calcularMitjana(int numLinies) {
		for(String s : dades.keySet()) {
			dades.put(s, dades.get(s) / numLinies);
		}
	}

	// Mètode per mostrar les dades.
	private static void imprimirDades() {
		// Imprimir les temperatures mitjanes en ordre.
		for(String mes : nomMesos) {
			System.out.println(mes + ": " + new DecimalFormat("#.00").format(dades.get(mes)));
		}
	}

}
