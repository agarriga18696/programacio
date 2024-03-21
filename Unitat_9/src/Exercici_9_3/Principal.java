package Exercici_9_3;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	// Declaració de la llista.
	private static ArrayList<Integer> numeros;

	public static void main(String[] args) {
		// 1. Crear un ArrayList anomenat numeros.
		Missatge.simple("1. Crear un ArrayList anomenat numeros.");
		numeros = new ArrayList<>();
		Entrada.premerTecla("continuar amb el següent pas.");

		// 2. Afegir els següents números a l'ArrayList: 10, 20, 30, 40, 50.
		Missatge.simple("2. Afegir els següents números a l'ArrayList: 10, 20, 30, 40, 50.");
		inicialitzarLlista(10, 20, 30, 40, 50);
		Entrada.premerTecla("continuar amb el següent pas.");

		// 3. Imprimir la llista original.
		Missatge.simple("3. Imprimir la llista original.");
		Missatge.simple(imprimirLlista(null, numeros));
		Entrada.premerTecla("continuar amb el següent pas.");

		// 4. Afegir el número 60 a l'ArrayList.
		Missatge.simple("4. Afegir el número 60 a l'ArrayList.");
		numeros.add(60);
		Entrada.premerTecla("continuar amb el següent pas.");

		// 5. Imprimir la llista després d'afegir el número 60.
		Missatge.simple("5. Imprimir la llista després d'afegir el número 60.");
		Missatge.simple(imprimirLlista(null, numeros));
		Entrada.premerTecla("continuar amb el següent pas.");

		// 6. Eliminar el número 30 de l'ArrayList.
		Missatge.simple("6. Eliminar el número 30 de l'ArrayList.");
		Integer nEliminar = 30;
		numeros.remove(nEliminar);
		Entrada.premerTecla("continuar amb el següent pas.");

		// 7. Imprimir la llista després d'eliminar el número 30.
		Missatge.simple("7. Imprimir la llista després d'eliminar el número 30.");
		Missatge.simple(imprimirLlista(null, numeros));
		Entrada.premerTecla("continuar amb el següent pas.");

		// 8. Accedir al primer element de l'ArrayList i mostrar-lo per pantalla.
		Missatge.simple("8. Accedir al primer element de l'ArrayList i mostrar-lo per pantalla.");
		Missatge.simple("Primer element: " + imprimirLlista(0, numeros));
		Entrada.premerTecla("continuar amb el següent pas.");

		// 9. Modificar el segon element de l'ArrayList canviant-lo per 25.
		Missatge.simple("9. Modificar el segon element de l'ArrayList canviant-lo per 25.");
		numeros.set(1, 25);
		Entrada.premerTecla("continuar amb el següent pas.");

		// 10. Imprimir la llista després de modificar el segon element.
		Missatge.simple("10. Imprimir la llista després de modificar el segon element.");
		Missatge.simple(imprimirLlista(null, numeros));
		Entrada.premerTecla("continuar amb el següent pas.");

		// 11. Mostrar per pantalla la quantitat d'elements que té l'ArrayList.
		Missatge.simple("11. Mostrar per pantalla la quantitat d'elements que té l'ArrayList.");
		Missatge.simple("Elements de l'ArrayList: " + numeros.size());
		Entrada.premerTecla("continuar amb el següent pas.");

		// 12. Verificar si el número 40 està present a l'ArrayList i imprimir el resultat.
		Missatge.simple("12. Verificar si el número 40 està present a l'ArrayList i imprimir el resultat.");
		Missatge.simple(numeros.contains(40) ? "Si" : "No");
		Entrada.premerTecla("continuar amb el següent pas.");

		// 13. Eliminar tots els elements de l'ArrayList.
		Missatge.simple("13. Eliminar tots els elements de l'ArrayList.");
		numeros.clear();
		Entrada.premerTecla("continuar amb el següent pas.");

		// 14. Verificar si l'ArrayList està buit i imprimir el resultat.
		Missatge.simple("Està buit? " + (numeros.isEmpty() ? "Si" : "No"));
		Missatge.simple(imprimirLlista(null, numeros));
		Entrada.premerTecla("finalitzar el programa.");

		// Sortir del programa.
		sortir();
	}

	// Mètode per afegir valors a la llista.
	private static void inicialitzarLlista(int... numero) {
		for(int n : numero) {
			numeros.add(n);
		}
	}

	// Mètode per imprimir la llista.
	private static String imprimirLlista(Integer index, List<Integer> llista) {
		// Imprimir llista sense especificar índex (llista completa).
		if(index == null) {
			return String.valueOf(llista);
			
		} else { // Imprimir llista especificant l'índex (només un valor).
			return String.valueOf(numeros.get(index));
		}
	}

	// Mètode per sortir del programa.
	private static void sortir() {
		System.out.println(System.lineSeparator());
		Missatge.simple("Fins una altra! 👋");
		System.exit(0);
	}

}
