package Exercici_9_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {

	private static ArrayList<String> colors = new ArrayList<>();
	private static ArrayList<String> colors2 = new ArrayList<>();

	public static void main(String[] args) {

		// Inicialitzar la llista de colors amb els colors inicials.
		Missatge.simple("Inicialitzar la llista de colors amb els colors inicials.");
		afegirColor("Vermell", "Verd", "Blau", "Groc", "Magenta");
		mostrarColors(colors);
		Entrada.premerTecla("poder continuar.");
		
		// Inserir un element a la ArrayList a la primera posició.
		Missatge.simple("Inserir un element a la ArrayList a la primera posició.");
		afegirColorIndex(0, "Rosa");
		Missatge.simple("Afegit color 'rosa': " + colors);
		Entrada.premerTecla("poder continuar.");
		
		// Recuperar un element (en un índex especificat) d'una ArrayList determinada.
		Missatge.simple("Recuperar un element (en un índex especificat) d'una ArrayList determinada.");
		Missatge.simple("Index 4: " + colors.get(4));
		Entrada.premerTecla("poder continuar.");
		
		// Actualitzar un element de matriu específic per un altra element donat.
		Missatge.simple("Actualitzar un element de matriu específic per un altra element donat.");
		colors.set(1, "Blanc");
		Missatge.simple("Actualitzar 'vermell' per 'blanc': " + colors);
		Entrada.premerTecla("poder continuar.");
		
		// Eliminar el tercer element d'una ArrayList.
		Missatge.simple("Eliminar el tercer element d'una ArrayList.");
		colors.remove(2);
		mostrarColors(colors);
		Entrada.premerTecla("poder continuar.");
		
		// Cercar un element en una ArrayList.
		Missatge.simple("Cercar un element en una ArrayList.");
		Missatge.simple("Cercar color 'groc': " + (colors.contains("Groc") ? "s'ha trobat" : "no s'ha trobat"));
		Entrada.premerTecla("poder continuar.");
		
		// Ordenar una ArrayList determinada.
		Missatge.simple("Ordenar una ArrayList determinada.");
		Collections.sort(colors);
		mostrarColors(colors);
		Entrada.premerTecla("poder continuar.");
		
		// Copiar una ArrayList en una altra. Canviar de posició automàticament (barrejar) elements
		// d'una ArrayList.
		Missatge.simple("Copiar una ArrayList en una altra. Canviar de posició automàticament (barrejar) elements d'una ArrayList.");
		colors2 = new ArrayList<>(colors);
		Collections.shuffle(colors2);
		Missatge.simple("Llista clonada i barrejada: " + colors2);
		Entrada.premerTecla("poder continuar.");
		
		// Invertir els elements d'una ArrayList.
		Missatge.simple("Invertir els elements d'una ArrayList.");
		Collections.reverse(colors);
		mostrarColors(colors);
		Entrada.premerTecla("poder continuar.");
		
		// Extreure una part d'una ArrayList.
		Missatge.simple("Extreure una part d'una ArrayList.");
		Missatge.simple("" + colors.subList(0, 3));
		Entrada.premerTecla("poder continuar.");
		
		// Comparar dues ArrayLists.
		Missatge.simple("Comparar dues ArrayLists.");
		Missatge.simple("colors == colors2? " + (colors.equals(colors2) ? "Si" : "No"));
		Entrada.premerTecla("poder continuar.");
		
		// Intercanviau dos elements en una ArrayList.
		Missatge.simple("Intercanviau dos elements en una ArrayList.");
		Collections.swap(colors, 0, 1);
		Missatge.simple("Element 0 per element 1: " + colors);
		Entrada.premerTecla("poder continuar.");
		
		// Unir dues ArrayLists.
		Missatge.simple("Unir dues ArrayLists");
		colors2.addAll(colors);
		Missatge.simple("Colors2: " + colors2);
		Entrada.premerTecla("poder continuar.");
		
		// Clonar una ArrayList en una altra ArrayList.
		Missatge.simple("Clonar una ArrayList en una altra ArrayList.");
		colors2 = (ArrayList<String>) colors.clone();
		Missatge.simple("Clonada 'colors' a 'colors2': " + colors2);
		Entrada.premerTecla("poder continuar.");
		
		// Buidar una ArrayList.
		Missatge.simple("Buidar una ArrayList.");
		colors.clear();
		Missatge.simple("Buidat 'colors': " + colors);
		Entrada.premerTecla("poder continuar.");
		
		// Comprovar si una ArrayList està buida o no.
		Missatge.simple("Comprovar si una ArrayList està buida o no.");
		Missatge.simple("Està buida 'colors'? " + (colors.isEmpty() ? "Si" : "No"));
		Entrada.premerTecla("poder continuar.");
		
		// Retallar la capacitat d'una ArrayList a la mida de la llista actual.
		Missatge.simple("Retallar la capacitat d'una ArrayList a la mida de la llista actual.");
		Missatge.simple("Mida actual 'colors2': " + colors2.size());
		colors2.trimToSize();
		Missatge.simple("Mida actual 'colors2' després del retall: " + colors2.size());
		Entrada.premerTecla("poder continuar.");
		
		// Augmentar la mida d'una ArrayList.
		Missatge.simple("Augmentar la mida d'una ArrayList.");
		ArrayList<String> colors3 = new ArrayList<>(colors2.size() + 3);
		Entrada.premerTecla("poder continuar.");
		
		// Substituir el segon element d'una ArrayList per l'element especificat.
		Missatge.simple("Substituir el segon element d'una ArrayList per l'element especificat.");
		Collections.swap(colors2, 1, 3);
		mostrarColors(colors2);
		Entrada.premerTecla("poder continuar.");
		
		// Imprimir tots els elements d'una ArrayList utilitzant la posició dels elements.
		Missatge.simple("Imprimir tots els elements d'una ArrayList utilitzant la posició dels elements.");
		for(int i = 0; i < colors2.size(); i++) {
			Missatge.simple(i + ": " + colors2.get(i));
		}
		
		Entrada.premerTecla("poder finalitzar el programa.");
		
	}

	// Mètode per afegir els colors a la llista.
	private static void afegirColor(String... color) {
		for(String c : color) {
			colors.add(c);
		}
	}

	// Mètode per afegir els colors a la llista.
	private static void afegirColorIndex(int index, String color) {
		colors.add(index, color);
	}

	// Mètode per mostrar la llista de colors.
	private static void mostrarColors(List<String> llista) {
		Missatge.simple("" + llista);
	}

}
