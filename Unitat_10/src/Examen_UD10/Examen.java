package Examen_UD10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Examen {

	private static ArrayList<Factura> factures = new ArrayList<>();

	private static final File FITXER_1 = new File("src/Examen_UD10/compra1.csv");
	private static final File FITXER_2 = new File("src/Examen_UD10/compra2.csv");

	public static void main(String[] args) {

		// Crear els objectes Factura:
		Factura factura1 = crearFactura(FITXER_1);
		Factura factura2 = crearFactura(FITXER_2);

		// Afegir les factures a l'ArrayList de factures:
		factures.add(factura1);
		factures.add(factura2);

		// Emmagatzemar a fitxer .dat:
		guardarFactura(factures, "src/Examen_UD10/factures.dat");

		// Llegir el fitxer i imprimir el contingut per pantalla:
		llegirFactura("src/Examen_UD10/factures.dat");

	}

	// Mètode per llegir les dades del fitxer i crear la factura.
	private static Factura crearFactura(File fitxer) {
		// Llegir linia a linia el fitxer.
		// -> Ignorar la primera línia (capçalera)
		// -> Guardar cada linia del fitxer com un nou objecte.

		// Crear ArrayList temporal per després copiar-lo al del objecte Factura.
		ArrayList<LiniaDeFactura> arraylist_temp = new ArrayList<>();

		// Variable per el preu total de la factura (quantitat x preuUnitari de cada linia).
		double totalFactura = 0;

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fitxer));

			// Ignorar la primera linia del fitxer, ja que és la capçalera amb els títols.
			br.readLine();

			String linia;
			while((linia = br.readLine()) != null) {
				// Split amb ';' ja que el CSV ho separa així.
				String[] linies = linia.split(";");

				// Emmagatzemar cada linia com un objecte independent.
				String descripcio = linies[0].trim();
				double quantitat = Double.parseDouble(linies[1]);
				double preuUnitari = Double.parseDouble(linies[2]);

				// Anar calculant el total de cada linia i autosumar.
				totalFactura += quantitat * preuUnitari;

				LiniaDeFactura ldf = new LiniaDeFactura(descripcio, quantitat, preuUnitari);

				// Afegir l'objecte a l'ArrayList temporal.
				arraylist_temp.add(ldf);
			}

			br.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return new Factura(totalFactura, arraylist_temp);

	}

	// Mètode per carregar les dades del fitxer.
	@SuppressWarnings("unchecked")
	protected static void llegirFactura(String fitxer) {
		ArrayList<Factura> factures_recuperades = new ArrayList<>();

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fitxer))) {
			factures_recuperades = (ArrayList<Factura>) in.readObject();

			System.out.println("\n Factures carregades correctament des de: " + fitxer);

			// Mostrar el contingut de cada factura.
			for(int i = 0; i < factures_recuperades.size(); i++) {
				Factura f = factures_recuperades.get(i);
				System.out.println("\n\n FACTURA " + (i + 1));
				System.out.println(f);
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Mètode per guardar la factura a un fitxer.
	private static void guardarFactura(ArrayList<Factura> factures, String fitxer) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fitxer))) {
			out.writeObject(factures);
			System.out.println("\n ArrayList de Factures guardat correctament a: " + fitxer);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
