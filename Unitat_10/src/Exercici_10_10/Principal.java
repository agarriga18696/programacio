package Exercici_10_10;

import java.io.*;
import java.net.URL;

public class Principal {

	private static final String URL = "https://museu.iesjoanramis.org";
	private static String fitxerDesti = "src/Exercici_10_10/pagina_web.html";

	public static void main(String[] args) {

		guardarWeb(URL, fitxerDesti);

	}

	// Mètode per guardar la pàgina web.
	private static void guardarWeb(String url, String fitxer) {
		try {
			// Obtenir la connexió a la pàgina web.
			URL paginaWeb = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(paginaWeb.openStream()));

			// Crear el fitxer de destí.
			BufferedWriter out = new BufferedWriter(new FileWriter(fitxer));

			// Llegir la pàgina web línia per línia i escriure-la al fitxer de destí.
			String linia;
			while ((linia = in.readLine()) != null) {
				out.write(linia);
				out.newLine(); // Afegir un salt de línia per mantenir el format original.
			}

			// Tancar els fluxos.
			in.close();
			out.close();

			Msg.exit("La pàgina web s'ha emmagatzemat correctament al fitxer '" + extreureNomFitxer(fitxerDesti) + "'.");

		} catch (IOException e) {
			Msg.error("No s'ha pogut llegir o escriure la pàgina web: " + e.getMessage());
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

