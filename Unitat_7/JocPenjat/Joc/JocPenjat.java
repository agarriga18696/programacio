package Joc;

import IU.Element;
import IU.Menu;
import IU.Missatge;
import Paraules.Paraules;
import Utilitat.Aleatori;
import Utilitat.Normalitzar;
import Utilitat.Validar;

public class JocPenjat {

	private static String paraulaActual = null;
	public static String paraulaActualNormalitzada = null;
	public static String paraulaAmagada = null;
	public static int videsJugador = 8;
	private static Jugador jugador;
	private static boolean partidaFinalitzada;

	public static void main(String[] args) {
		// Inicialitzar jugador.
		jugador = new Jugador(videsJugador);
		
		Menu.menu();
	}
	

	//////////////////////
	//					//
	//		JUGAR		//
	//					//
	//////////////////////

	public static void jugar() {
		// Inicialitzar la variable com a false per poder jugar.
		partidaFinalitzada = false;

		Element.saltLinia();
		Element.titolAmbMarc("PARTIDA");

		// Seleccionar una paraula al atzar de la llista de paraules.
		paraulaActual = Paraules.llistaParaules.get(Aleatori.Int(0, Paraules.llistaParaules.size() - 1)).getParaula();
		paraulaActualNormalitzada = Normalitzar.llevarAccents(paraulaActual).toUpperCase();
		paraulaAmagada = Logica.amagarParaula(paraulaActualNormalitzada);

		// Partida.
		do {
			Element.taulaPuntuacio(jugador);
			
			// Mostrar el penjat.
			Dibuixar.penjat(jugador);

			// Mostrar paraula amagada.
			System.out.println("\n " + Logica.mostrarParaulaAmbEspais(paraulaAmagada));
			Element.saltLinia();

			partidaFinalitzada = Logica.comprovarVictoriaDerrota(paraulaAmagada, jugador);

			if(!partidaFinalitzada) {
				Logica.demanarLletra(jugador);
			}
			
		} while(!partidaFinalitzada);
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

	public static void configuracio() {
		Element.saltLinia();
		Element.titolAmbMarc("OPCIONS");


	}

	public static void paraulaPersonalitzada() {


	}

	// Mètode per sortir del joc.
	public static void sortir() {
		Element.saltLinia();
		System.out.println("Fins un altre cop!");
		System.exit(0);
	}

}
