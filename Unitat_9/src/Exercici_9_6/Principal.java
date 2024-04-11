package Exercici_9_6;

import java.util.LinkedList;

public class Principal {

	private static LinkedList<String> llistaCiutats = new LinkedList<>();
	
	public static void main(String[] args) {
		// Afegir les següents ciutats a la llista: Barcelona, Madrid, València, Sevilla.
		afegir("Barcelona", "Madrid", "València", "Sevilla");
		
		// Mostrar per pantalla la llista original de ciutats.
		mostrarLlista();
		
		// Afegir la ciutat Bilbao al principi de la llista.
		llistaCiutats.addFirst("Bilbao");
		
		// Afegir la ciutat Màlaga al final de la llista.
		llistaCiutats.addLast("Màlaga");
		
		// Mostrar per pantalla el primer i l'últim element de la llista.
		Missatge.simple("Primer i últim element:");
		Missatge.simple("Primer: " + llistaCiutats.getFirst());
		Missatge.simple("Darrer: " + llistaCiutats.getLast());
		IU.saltLinia();
		
		// Eliminar primera i darrera ciutat.
		Missatge.simple("Eliminar primera i darrera ciutat de la llista.");
		IU.saltLinia();
		
		// Eliminar la primera ciutat de la llista.
		llistaCiutats.removeFirst();
		
		// Eliminar l'última ciutat de la llista.
		llistaCiutats.removeLast();
		
		// Mostrar per pantalla la llista de ciutats després de les modificacions.
		mostrarLlista();
	}
	
	// Mètode per afegir una o vàries ciutats.
	private static void afegir(String... ciutats) {
		try {
			for(String c : ciutats) {
				llistaCiutats.add(c);
			}
		} catch(NullPointerException e) {
			Missatge.errorGreu("S'ha intentat inserir un element null.");
		}
	}
	
	// Mètode per mostrar la llista.
	private static void mostrarLlista() {
		IU.titol("Llista", null);
		for(String s : llistaCiutats) {
			Missatge.simple(s);
		}
		IU.saltLinia();
	}

}
