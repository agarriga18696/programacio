package IU;

import Joc.Jugador;
import Paraules.Paraules;

public class Element {

	public static void separador() {
		System.out.println(" ─────────────────────────────────────────");
	}
	
	public static void saltLinia() {
		System.out.println(System.lineSeparator());
	}
	
	public static void titolAmbMarc(String titol) {
		System.out.println(" +───────────────────────────────────────+");
		System.out.println(" │					 │");
		System.out.println(" │		  " + titol.toUpperCase() + " 		 │");
		System.out.println(" │					 │");
		System.out.println(" +───────────────────────────────────────+");
		System.out.println("");
	}
	
	// Mètode per mostrar la puntuació.
	public static void taulaPuntuacio(Jugador jugador) {
		System.out.println("\n ❤️ Vides: " + jugador.getVides() + "\t     │\t      🌟 Punts: " + jugador.getPunts());
		Element.separador();
		System.out.print(" ❕ Falls: ");
		for(String lletra : Paraules.llistaLletresFallades) {
			System.out.print(lletra + " ");
		}
		saltLinia();
	}
	
}
