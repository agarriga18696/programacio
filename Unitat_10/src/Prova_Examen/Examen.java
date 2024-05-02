package Prova_Examen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Examen {

	private static final String FITXER = "src/Prova_Examen/temperatures.txt";
	private static HashMap<String, Double> dades = new HashMap<>();
	private static String[] nomMesos = null;

	public static void main(String[] args) {
		llegirDades();
		imprimirDades();
	}

	private static void llegirDades() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(FITXER));
			
			// Emmagatzemar els noms dels mesos.
			nomMesos = br.readLine().split(",");

			String linia;
			
			while((linia = br.readLine()) != null) {
				String[] temps = linia.split(",");
				
				for(int i = 0; i < temps.length; i++) {
					String mes = nomMesos[i];
					double temperatura = Double.parseDouble(temps[i]);
					
					if(dades.containsKey(mes)) {
						double mitjana = dades.get(mes);
						mitjana = (mitjana + temperatura) / 2;
						dades.put(mes, mitjana);
						
					} else {
						dades.put(mes, temperatura);
					}
				}
			}

			br.close();

		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void imprimirDades() {
		// Imprimir les temperatures mitjanes en ordre
        for (String mes : nomMesos) {
            System.out.println(mes + ": " + dades.get(mes));
        }
	}

}
