package Exercici_10_07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

	private static final String RUTA = "src/Exercici_10_07/fitxer.txt";

	public static void main(String[] args) throws Exception {
		Msg.titol("Lectura de fitxers", null);
		llegir();
	}

	// Mètode per llegir el fitxer línia a línia.
	private static void llegir() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(RUTA));
			int numLinia = 1;
			String linia;

			Msg.info("Lectura del fitxer '" + extreureNomFitxer(RUTA) + "' línia a línia:");
			
			while ((linia = br.readLine()) != null) {
				// Imprimir el número de línia seguit de la línia llegida.
				Msg.simple("Línia " + numLinia + ": " + linia);
				// Incrementar el número de línia per la següent iteració.
				numLinia++;
			}

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
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
