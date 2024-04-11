package Exercici_9_7;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Principal {

	private static LinkedList<String> colors = new LinkedList<>();

	public static void main(String[] args) {
		// Inicialitzar la llista amb alguns colors.
		afegir(0, "vermell", "blau", "groc");

		// 1. Afegiu l'element especificat al final d'una LinkedList.
		colors.addLast("verd");

		// 2. Recorre tots els elements d'una LinkedList.
		mostrarLlista(0); // aquest mètode recorre tota la llista.

		// 3. Recorre tots els elements d'una LinkedList començant per la posició especificada.
		mostrarLlista(2);
		
		// 4. Itera una LinkedList en ordre invers.
		Missatge.simple("Iterar en ordre invers:");
		Iterator<String> it = colors.iterator();
		
		Collections.reverse(colors); // invertir l'ordre de la llista.
		while(it.hasNext()) {
			Missatge.simple(it.next());
		}
		Collections.reverse(colors); // tornar a l'ordre original.
		
		// 5. Inseriu l'element especificat a la posició especificada de la LinkedList.
		colors.add(3, "rosa");
		
		// 6. Inseriu elements a la LinkedList a la primera i a l'última posició.
		afegir(0, "negre"); // primera posició.
		afegir(colors.size(), "blanc"); // darrera posició.

		// 7. Inseriu l'element especificat al capdavant d'una LinkedList.
		colors.addFirst("lila");
		
		// 8. Inseriu l'element especificat al final d'una LinkedList.
		colors.addLast("taronja");
		
		// 9. Inseriu alguns elements a la posició especificada en una LinkedList.
		afegir(5, "marró", "cian", "magenta");
		
		// 10. Obteniu la primera i l'última ocurrència dels elements especificats en una LinkedList.
		Missatge.simple("Obtenir la primera i última ocurrència:");
		//Missatge.sortida(IU.llistaOrdenada(false, colors));
		
	}

	// Mètode per afegir un o varis elements a la posició especificada.
	private static void afegir(int p, String... elements) {
		try {
			for(String e : elements) {
				colors.add(p, e);
			}
		} catch(NullPointerException e) {
			Missatge.errorGreu("S'ha intentat inserir un element null.");
		}
	}

	// Mètode per mostrar la llista. Es pot especificar la posició inicial.
	private static void mostrarLlista(int p) {
		IU.titol("Llista", null);

		try {
			if(p > 0 && p <= colors.size()) {
				for(int i = p - 1; i < colors.size(); i++) {
					Missatge.simple(colors.get(i));
				}

			} else {
				for(String e : colors) {
					Missatge.simple(e);
				}
			}
		} catch(IndexOutOfBoundsException e) {
			Missatge.errorGreu("S'ha intentat accedir a un element fora de la llista.");
		}

		IU.saltLinia();
	}

}
