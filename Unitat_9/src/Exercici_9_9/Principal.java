package Exercici_9_9;

import java.util.HashSet;
import java.util.Iterator;

public class Principal {

	private static HashSet<Integer> taula_hash = new HashSet<>();

	public static void main(String[] args) {
		Msg.titol("HashSet", "Estructura de dades.");
		
		// Afegir diferents elements al HashSet (per exemple números: 10, 20, 30, 40, 50).
		Msg.simple("1. Afegir diferents elements al HashSet (per exemple números: 10, 20, 30, 40, 50).");
		afegir(10, 20, 30, 40, 50);
		IU.saltLinia();

		// Mostrar els elements del HashSet utilitzant un iterador (Iterator). Fixeu-vos en l’ordre en que es mostren.
		Msg.simple("2. Mostrar els elements del HashSet utilitzant un iterador:");
		mostrar();
		Msg.info("Els elements no es mostren ordenats, ja que HashSet no manté l'ordre d'inserció.");
		IU.saltLinia();
		
		// Verificar si el nombre 20 o el 35 estan presents al HashSet.
		Msg.simple("3. Verificar si el nombre 20 o el 35 estan presents al HashSet:");
		Msg.simple("Nombre 20: " + (taula_hash.contains(20)));
		Msg.simple("Nombre 35: " + (taula_hash.contains(35)));
		IU.saltLinia();
		
		// Eliminar el nombre 40 del HashSet.
		Msg.simple("4. Eliminar el nombre 40 del HashSet.");
		taula_hash.remove(40);
		IU.saltLinia();
		
		// Mostrar els elements del HashSet després d'eliminar l’element.
		Msg.simple("5. Mostrar els elements del HashSet després d'eliminar l’element:");
		mostrar();
		IU.saltLinia();
		
		// Intentar introduir un nombre que ja existeix, per exemple el 50.
		Msg.simple("6. Intentar introduir un nombre que ja existeix, per exemple el 50.");
		taula_hash.add(50);
		IU.saltLinia();
		
		// Mostrar els elements del HashSet després d'introduir un element existent.
		Msg.simple("7. Mostrar els elements del HashSet després d'introduir un element existent:");
		mostrar();
		Msg.info("No es poden afegir objectes duplicats al tipus de col·lecció HashSet.");
		IU.saltLinia();
		
		// Obtenir la mida del HashSet.
		Msg.simple("8. Obtenir la mida del HashSet:");
		Msg.simple("Mida: " + taula_hash.size());
		IU.saltLinia();
		
		// Netejar el HashSet.
		Msg.simple("9. Netejar el HashSet.");
		taula_hash.clear();
		IU.saltLinia();
		
		// Verificar si el HashSet està buit.
		Msg.simple("10. Verificar si el HashSet està buit:");
		Msg.simple("Està buit? " + (taula_hash.isEmpty()));
		
	}

	// Mètode per afegir múltiples valors a la taula.
	private static void afegir(Integer... valors) {
		for(Integer e : valors) {
			taula_hash.add(e);
		}
	}
	
	// Mètode per mostrar els elements de la taula.
	private static void mostrar() {
		Iterator<Integer> iterator = taula_hash.iterator();
		while(iterator.hasNext()) {
			Msg.simple("" + iterator.next());
		}
	}

}
