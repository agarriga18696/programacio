package Exercici_9_11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Principal {

	private static HashMap<String, Integer> mapa = new HashMap<>();
	private static Random random = new Random();

	public static void main(String[] args) {
		// Inicialitzar la llista de contactes.
		afegir("Gerard", "Paula", "Marc", "Isabel", "Mamà");

		menu();
	}

	// Mètode per mostrar el menú.
	private static void menu() {
		int opcio = 0;

		while(opcio != 4) {
			Msg.titol("HashMap", "Llista de contactes.");
			Msg.simple("1. Nou contacte");
			Msg.simple("2. Mostrar llista de contactes");
			Msg.simple("3. Cercar contacte");
			Msg.simple("4. Sortir");

			opcio = Entrada.enter("Opció");

			switch(opcio) {
			case 1:
				nouContacte();
				break;
			case 2:
				mostrarLlista();
				break;
			case 3:
				cercarContacte();
				break;
			case 4:
				Msg.simple("Fins un altre cop! 👋");
				System.exit(0);
				return;
			default:
				Msg.error("L'opció introduïda no és vàlida.");
				break;
			}
		}
	}

	// Mètode per crear un nou contacte personalitzat.
	private static void nouContacte() {
		boolean contacteCorrecte = false;
		String nom = null;
		Integer tlf = null;

		while(!contacteCorrecte) {
			Msg.simple("Nou Contacte:");
			nom = Entrada.cadena("Nom");
			tlf = Entrada.telefon();

			// Verificar que la clau (nom) no es repeteixi, ja que a HashMap les claus són úniques.
			if(mapa.containsKey(nom)) {
				IU.saltLinia();
				Msg.error("Ja existeix un contacte amb aquest nom.");
				continue;

			} else {
				contacteCorrecte = true;
			}
		}

		// Afegir el contacte al mapa.
		mapa.put(nom, tlf);

		IU.saltLinia();
		Msg.exit("El contacte (" + nom + ") s'ha afegit correctament!");
	}

	// Mètode per mostrar la llista de contactes.
	private static void mostrarLlista() {
		Iterator<String> iterator = mapa.keySet().iterator();
		int i = 1;

		while(iterator.hasNext()) {
			String k = iterator.next();
			int v = mapa.get(k);
			Msg.simple("Contacte (" + i + "): " + k + " | Telèfon: " + v);
			i++;
		}
	}

	// Mètode per cercar un contacte per nom i mostrar el seu número de telèfon.
	private static void cercarContacte() {
		boolean contacteTrobat = false;
		String nom = null;
		Integer tlf = null;

		while(!contacteTrobat) {
			Msg.simple("Cercar Contacte:");
			nom = Entrada.cadena("Nom");

			// Verificar que la clau (nom) no es repeteixi, ja que a HashMap les claus són úniques.
			if(!mapa.containsKey(nom)) {
				IU.saltLinia();
				Msg.error("No s'ha trobat cap contacte amb aquest nom.");
				continue;

			} else {
				tlf = mapa.get(nom);
				contacteTrobat = true;
			}
		}
		
		IU.saltLinia();
		Msg.exit("Contacte (" + nom + ") trobat!");
		Msg.simple("El telèfon és: " + tlf);
	}

	// Mètode per afegir múltiples valors a la taula i generar el valor de manera aleatòria.
	private static void afegir(String... valors) {
		for(String e : valors) {
			// El valor serà el nombre de telèfon que es genera amb Random.
			int v = generarTelefon();
			mapa.put(e, v);
		}
	}

	// Mètode per crear nombres de telèfon aleatoris.
	private static int generarTelefon() {
		// A Espanya els números de telèfon mòvil tenen les següents característiques:
		// - Tenen 9 dígits.
		// - Començen per 6 o 7.
		return 600000000 + random.nextInt(200000000); // Número entre 600.000.000 (inclòs) i 800.000.000 (no inclòs).
	}

}
