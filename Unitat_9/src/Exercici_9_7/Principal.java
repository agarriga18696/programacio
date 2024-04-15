package Exercici_9_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

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
		IU.saltLinia();
		Missatge.simple("Obtenir la primera i última ocurrència:");
		Missatge.simple("Primera ocurrència: " + colors.indexOf(colors.getFirst()));
		Missatge.simple("Darrera ocurrència: " + colors.indexOf(colors.getLast()));
		IU.saltLinia();

		// 11. Mostra els elements i les seves posicions en una LinkedList.
		ListIterator<String> iterator = colors.listIterator();
		int pos = 0;
		while (iterator.hasNext()) {
			String elemento = iterator.next();
			Missatge.simple("Element: " + elemento + " | Posició: " + pos);
			pos++;
		}

		// 12. Elimina un element especificat d'una LinkedList.
		colors.remove(2);

		// 13. Elimina el primer i l'últim element d'una LinkedList.
		colors.remove(colors.getFirst());
		colors.remove(colors.getLast());

		// 14. Elimina tots els elements d'una LinkedList.
		LinkedList<String> colors2 = new LinkedList<>(colors); // Fer una còpia de la llista abans de borrar-la.
		colors.clear(); // borrar llista original.

		// 15. Canvia dos elements en una LinkedList.
		colors2.set(0, "beix");
		colors2.set(1, "lima");
		IU.saltLinia();
		Missatge.simple("Canviar dos elements en una LinkedList:");
		Missatge.simple(colors2.get(0) + " - " + colors2.get(1));
		IU.saltLinia();

		// 16. Barreja els elements d'una LinkedList.
		Collections.shuffle(colors2);
		Missatge.simple("Barreja els elements d'una LinkedList:");
		Missatge.simple("" + colors2);
		IU.saltLinia();

		// 17. Uniu dues LinkedLists.
		LinkedList<String> colors3 = new LinkedList<>();
		colors3.add("turquesa");
		colors3.add("gris");
		Missatge.simple("Uniu dues LinkedLists:");
		colors2.addAll(colors2.size(), colors3); // unir a partir del darrer element de la llista 'colors2'.
		Missatge.simple("" + colors2);
		IU.saltLinia();

		// 18. Clona una LinkedList a una altra LinkedList.
		LinkedList<String> colors_clon = new LinkedList<>(colors2);

		// 19. Elimina i torna el primer element d'una LinkedList.
		Missatge.simple("Elimina i torna el primer element d'una LinkedList:");
		String primerElement = colors2.remove();
		Missatge.simple("Primer element eliminat: " + primerElement);
		Missatge.simple("Llista després d'eliminar el primer element:");
		Missatge.simple("" + colors2);
		IU.saltLinia();

		// 20. Recupera, però no elimina, el primer element d'una LinkedList.
		Missatge.simple("Recupera, però no elimina, el primer element d'una LinkedList:");
		primerElement = colors2.getFirst();
		Missatge.simple("Primer element recuperat: " + primerElement);
		Missatge.simple("Llista després de recuperar el primer element:");
		Missatge.simple("" + colors2);
		IU.saltLinia();

		// 21. Recupera, però no elimina, l'últim element d'una LinkedList.
		Missatge.simple("Recupera, però no elimina, l'últim element d'una LinkedList:");
		String darrerElement = colors2.getLast();
		Missatge.simple("Darrer element recuperat: " + darrerElement);

		// 22. Comproveu si un element concret existeix en una LinkedList.
		Missatge.simple("Llista després de recuperar el darrer element:");
		Missatge.simple("" + colors2);
		IU.saltLinia();

		// 23. Converteix una LinkedList en una ArrayList.
		ArrayList<String> colors2_arrayList = new ArrayList<>(colors2);

		// 24. Compara dues LinkedLists.
		if(colors2.equals(colors3)) {
			Missatge.simple("Les LinkedLists són iguals.");
		} else {
			Missatge.simple("Les LinkedLists són diferents.");
		}
		IU.saltLinia();

		// 25. Comprovar que una LinkedList està buida o no.
		if(colors.isEmpty()) {
			Missatge.simple("La LinkedList està buida.");
		} else {
			Missatge.simple("La LinkedList no està buida.");
		}
		IU.saltLinia();
		
		// 26. Substituïu un element d'una LinkedList.
		colors2.set(1, "fucsia");
		Missatge.simple("Element substituït: " + colors2.get(1));

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
