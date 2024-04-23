package Exercici_9_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Llibreria {

	private static List<String> llibres = new ArrayList<>();
	private static HashSet<String> clients = new HashSet<>();
	private static HashMap<String, Integer> inventari = new HashMap<>();

	public static void main(String[] args) {
		// Inicialitzar llibres.
		inicialitzarLlibres();

		menu();
	}

	// Mètode per mostrar el menú.
	private static void menu() {
		int opcio = 0;

		while(opcio != 4) {
			Msg.titol("Llibreria", "de tot i més.");
			Msg.simple("1. 🔎 Mostrar Inventari");
			Msg.simple("2. 👤 Registrar Client");
			Msg.simple("3. 🛒 Comprar Llibre");
			Msg.simple("4. 👋 Sortir");

			opcio = Entrada.enter("Opció");

			switch(opcio) {
			case 1:
				mostrarInventari();
				break;
			case 2:
				String client = nouClient();
				clients.add(client);
				IU.saltLinia();
				Msg.exit("Client registrat correctament.");
				break;
			case 3:
				comprarLlibre();
				break;
			case 4:
				Msg.simple("Fins un altre cop!");
				System.exit(0);
				return;
			default:
				Msg.error("Opció no vàlida");
				break;
			}
		}
	}

	// Mètode per inicialitzar els llibres.
	private static void inicialitzarLlibres() {
		llibres.add("harry potter");
		llibres.add("el hobbit");
		llibres.add("el principito");

		// Afegir els llibres a l'inventari amb les quantitats aleatories.
		for (String llibre : llibres) {
			inventari.put(llibre, new Random().nextInt(10) + 1); // entre 1 i 10.
		}
	}

	// Mètode per mostrar l'inventari de llibres disponibles.
	private static void mostrarInventari() {
		Msg.simple("INVENTARI:");

		for (Map.Entry<String, Integer> entry : inventari.entrySet()) {
			Msg.simple(entry.getKey() + ": " + entry.getValue() + " exemplars.");
		}

		IU.saltLinia();
	}

	// Mètode per registrar un client.
	private static String nouClient() {
		Msg.simple("REGISTRAR CLIENT:");

		return Entrada.cadena("Nom");
	}

	// Mètode per realizar una compra.
	private static void comprarLlibre() {
		Msg.simple("COMPRAR LLIBRE:");

		// Verificar si el client està registrat.
		if(!clients.contains(Entrada.cadena("Client"))) {
			IU.saltLinia();
			Msg.advertencia("El client no està registrat. Per favor, registra'l primer.");
			return;
		}

		String llibre = Entrada.cadena("Llibre").toLowerCase();
		// Verificar si el llibre està disponible a l'inventari.
		if(!inventari.containsKey(llibre)) {
			IU.saltLinia();
			Msg.advertencia("El llibre no està disponible.");
			return;
		}

		int quantitatDesitjada = Entrada.enter("Quantitat");
		// Comprovar que hi hagi prou llibres a l'inventari.
		int quantitatDisponible = inventari.get(llibre);
		if(quantitatDisponible < quantitatDesitjada) {
			IU.saltLinia();
			Msg.advertencia("No hi ha suficients unitats disponibles d'aquest llibre.");
			return;
		}

		// Realitzar la compra i actualizar l'inventari.
		inventari.put(llibre, quantitatDisponible - quantitatDesitjada);
		IU.saltLinia();
		Msg.exit("Compra realitzada correctament!");

		// Mostrar l'inventari actualitzat després de la compra.
		mostrarInventari();
	}

}
