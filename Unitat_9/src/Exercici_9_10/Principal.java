package Exercici_9_10;

import java.util.Iterator;
import java.util.TreeSet;

public class Principal {

	private static TreeSet<String> taula_tree = new TreeSet<>();

	public static void main(String[] args) {
		Msg.titol("TreeSet", "Estructura de dades.");
		
		// Afegir cadenes de text al TreeSet (noms, ciutats, animals, etc).
		Msg.simple("1. Afegir cadenes de text al TreeSet (noms, ciutats, animals, etc).");
		afegir("Arbre", "Ocell", "Gallina", "Casa", "Martell", "Júpiter");
		IU.saltLinia();
		
		// Mostrar els elements del TreeSet emprant un iterador. En quin ordre es mostren?
		Msg.simple("2. Mostrar els elements del TreeSet emprant un iterador:");
		mostrar();
		Msg.info("Al TreeSet, els elements es mostren en ordre ascendent (A-Z).");
		IU.saltLinia();
		
		// Verificar si una cadena de text específica està present al TreeSet.
		Msg.simple("3. Verificar si una cadena de text específica està present al TreeSet:");
		Msg.simple("La cadena 'Arbre' existeix? " + (taula_tree.contains("Arbre")));
		Msg.simple("La cadena 'arbre' existeix? " + (taula_tree.contains("arbre")));
		Msg.info("Únicament compara objectes idèntics, i per tant, la cadena 'Arbre' no és igual que 'arbre'.");
		IU.saltLinia();
		
		// Intentar afegir un element ja existent. Que ha passat?
		Msg.simple("4. Intentar afegir un element ja existent (Martell).");
		taula_tree.add("Martell");
		mostrar();
		Msg.info("TreeSet no permet guardar objectes duplicats.");
		IU.saltLinia();
		
		// Eliminar una cadena de text del TreeSet.
		Msg.simple("5. Eliminar una cadena de text del TreeSet (Júpiter).");
		taula_tree.remove("Júpiter");
		IU.saltLinia();
		
		// Mostrar els elements del TreeSet després d'eliminar una cadena de text.
		Msg.simple("6. Mostrar els elements del TreeSet després d'eliminar una cadena de text:");
		mostrar();
		
	}

	// Mètode per afegir múltiples valors a la taula.
	private static void afegir(String... valors) {
		for(String e : valors) {
			taula_tree.add(e);
		}
	}
	
	// Mètode per mostrar els elements de la taula.
	private static void mostrar() {
		Iterator<String> iterator = taula_tree.iterator();
		while(iterator.hasNext()) {
			Msg.simple("" + iterator.next());
		}
	}

}
