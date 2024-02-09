package Joc;

import IU.Element;
import IU.Missatge;
import Paraules.Paraules;
import Utilitat.Aleatori;
import Utilitat.Normalitzar;
import Utilitat.Validar;

public class JocPenjat {

	private static String paraulaActual = null;
	public static String paraulaActualNormalitzada = null;
	public static String paraulaAmagada = null;
	private static int videsJugador = 3;
	private static Jugador jugador;
	private static boolean partidaFinalitzada;

	public static void main(String[] args) {
		menu();
	}

	//////////////////////
	//					//
	//		 MENÚ		//
	//					//
	//////////////////////

	private static void opcionsMenu() {
		Element.saltLinia();
		Element.titolAmbMarc("PENJAT");
		System.out.println(" (1) Jugar");
		System.out.println(" (2) Opcions");
		System.out.println(" (3) Sortir");
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
				configuracio();
				break;
			case 3:
				sortir();
				break;
			default:
				Missatge.Error("Opció no vàlida");
				break;
			}
		} while(opcio != 3);
	}

	//////////////////////
	//					//
	//		JUGAR		//
	//					//
	//////////////////////

	private static void jugar() {
		// Inicialitzar la variable com a false per poder jugar.
		partidaFinalitzada = false;
		
		Element.saltLinia();
		Element.titolAmbMarc("PARTIDA");

		// Inicialitzar jugador.
		jugador = new Jugador(videsJugador);

		// Seleccionar una paraula al atzar de la llista de paraules.
		paraulaActual = Paraules.llistaParaules.get(Aleatori.Int(0, Paraules.llistaParaules.size() - 1)).getParaula();
		paraulaActualNormalitzada = Normalitzar.llevarAccents(paraulaActual).toUpperCase();
		paraulaAmagada = Paraules.amagarParaula(paraulaActualNormalitzada);

		boolean paraulaEndevinada = false;

		while(!partidaFinalitzada) {
			// Mostrar la puntuació.
			Element.taulaPuntuacio(jugador);

			// Mostrar paraula amagada.
			System.out.println("\n " + Paraules.mostrarParaulaAmbEspais(paraulaAmagada));
			Element.saltLinia();

			// Comprovar si s'ha endevinat la paraula.
	        if (Paraules.paraulaEndevinada(paraulaAmagada)) {
	            Missatge.Personalitzat("🏆", "Victoria", "Has encertat la paraula");
	            partidaFinalitzada = true;
	            break;
	        }

	        // Comprovar si s'ha quedat sense vides.
	        if (jugador.getVides() <= 0) {
	            Missatge.Personalitzat("💔", "Derrota", "T'has quedat sense vides");
	            partidaFinalitzada = true;
	            break;
	        }
			
			demanarLletra();
		}
	}

	// Mètode per demanar una lletra al jugador.
	private static void demanarLletra() {
		String lletra = null;

		lletra = Normalitzar.llevarAccents(Validar.lletra("Lletra")).toUpperCase();

		boolean lletraEncertada = Paraules.comprovarSiParauleConteLletra(lletra);

		if (lletraEncertada) {
			Missatge.Personalitzat("👍", "Acert", "'" + lletra + "' s'ha trobat a la paraula");
			// Sumar punts.
			jugador.sumarPunts();
		} else {
			Missatge.Personalitzat("👎", "Fall", "'" + lletra + "' no s'ha trobat a la paraula");
			jugador.restarVides();
		}
	}

	// Mètode per actualitzar l'estat de la lletra amagada.
	public static void actualitzarLletraAmagada(String paraula) {
		paraulaAmagada = paraula;
	}


	//////////////////////
	//					//
	//	 CONFIGURACIÓ	//
	//					//
	//////////////////////

	private static void configuracio() {
		Element.saltLinia();
		Element.titolAmbMarc("OPCIONS");

	}

	private static void paraulaPersonalitzada() {


	}

	// Mètode per sortir del joc.
	private static void sortir() {
		Element.saltLinia();
		System.out.println("Fins un altre cop!");
		System.exit(0);
	}

}
