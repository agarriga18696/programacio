package Joc;

import IU.Elements;
import IU.Missatge;
import Paraules.Paraules;
import Utilitat.Aleatori;
import Utilitat.Normalitzar;
import Utilitat.Validar;

public class JocPenjat {

	private static String paraulaActual = null;
	public static String paraulaActualNormalitzada = null;
	public static String paraulaAmagada = null;

	public static void main(String[] args) {
		menu();
		/*System.out.println("Paraules per defecte:\n");
		for(Paraula paraula : LlistaParaules.llistaParaules) {
			System.out.println(paraula);
		}*/
	}

	private static void opcionsMenu() {
		Elements.saltLinia();
		Elements.separador();
		System.out.println(" JOC DEL PENJAT\n");
		System.out.println(" (1) Jugar");
		System.out.println(" (2) Afegir paraules personalitzades");
		System.out.println(" (3) Configuració del jugador");
		System.out.println(" (4) Sortir");
	}

	private static void menu() {
		int opcio = 0;

		do {
			opcionsMenu();
			opcio = Validar.enter("Opció");

			switch(opcio) {
			case 1:
				jugar();
				break;
			case 2:
				paraulaPersonalitzada();
				break;
			case 3:
				configuracio();
				break;
			case 4:
				sortir();
				break;
			default:
				Missatge.Error("Opció no vàlida");
				break;
			}
		} while(opcio != 4);
	}

	private static void jugar() {
		Elements.saltLinia();
		Elements.separador();
		System.out.println(" JUGAR");

		// Seleccionar una paraula al atzar.
		paraulaActual = Paraules.llistaParaules.get(Aleatori.Int(0, Paraules.llistaParaules.size() - 1)).getParaula();
		paraulaActualNormalitzada = Normalitzar.llevarAccents(paraulaActual);
		paraulaAmagada = Paraules.amagarParaula(paraulaActualNormalitzada);

		boolean paraulaEndevinada = false;
		
		while(!paraulaEndevinada) {
			System.out.println("\n " + paraulaAmagada);
			demanarLletra();
			paraulaEndevinada = Paraules.paraulaEndevinada(paraulaAmagada);
			
			if(paraulaEndevinada) {
				Missatge.Exit("Enhorabona! Has encertat la paraula!");
				break;
			}
		}

	}

	private static void demanarLletra() {
		String lletra = null;

		lletra = Normalitzar.llevarAccents(Validar.lletra("Lletra"));

		System.out.println(Paraules.comprovarSiParauleConteLletra(lletra) == true ? "\n 👍 Has endevinat la lletra" : "\n 👎 No has endevinat la lletra");

	}
	
	public static void actualitzarLletraAmagada(String paraula) {
		paraulaAmagada = paraula;
		System.out.println("paraula actualitzada");
	}

	private static void paraulaPersonalitzada() {
		// TODO Auto-generated method stub

	}

	private static void configuracio() {
		// TODO Auto-generated method stub

	}

	private static void sortir() {
		Elements.saltLinia();
		Elements.separador();
		System.out.println("Fins un altre cop!");
		System.exit(0);
	}

}
