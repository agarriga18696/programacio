package Exercici_7_1_Penjat;

public class JocPenjat {

	public static Paraula paraulaActual = null;
	public static String paraulaActualNormalitzada = null;
	public static String paraulaAmagada = null;
	public static int videsJugador = 6;
	private static Jugador jugador;
	private static boolean partidaFinalitzada;

	public static void main(String[] args) {
		// Inicialitzar jugador.
		jugador = new Jugador(videsJugador);

		// Inicialitzar paraules per defecte.
		Paraules.inicialitzarParaulesPerDefecte();

		Menu.menuPrincipal();
	}


	//////////////////////
	//					//
	//		JUGAR		//
	//					//
	//////////////////////

	public static void jugar() {
		partidaFinalitzada = false;

		Element.saltLinia();
		Element.titolAmbMarc("PARTIDA");

		// Seleccionar una paraula al atzar de la llista de paraules.
		paraulaActual = Paraules.llistaParaules.get(Aleatori.Int(0, Paraules.llistaParaules.size() - 1));
		// Llevar accents de la paraula ja que si no el jugador també els haurà de posar quan el joc
		// demani la lletra.
		paraulaActualNormalitzada = Normalitzar.llevarAccents(paraulaActual.getParaula()).toUpperCase();
		// Amagar la paraula, substituir les lletres per caracters especials.
		paraulaAmagada = Logica.amagarParaula(paraulaActualNormalitzada);

		///////////////
		//			 //
		//  PARTIDA  //
		//			 //
		while(!partidaFinalitzada) {
			// Mostrar la taula de puntuació.
			Element.taulaPuntuacio(jugador);

			// Mostrar el penjat.
			Dibuixar.penjat(jugador);

			// Mostrar la paraula amagada.
			System.out.println("\n " + Logica.mostrarParaulaAmbEspais(paraulaAmagada));
			Element.saltLinia();

			// Comprovar si la partida ha finalitzat.
			partidaFinalitzada = Logica.comprovarVictoriaDerrota(paraulaAmagada, jugador);

			// Mentre no hagi finalitzat la partida anirà demanant una lletra al jugador.
			if(!partidaFinalitzada) {
				Logica.demanarLletra(jugador);
			}
		}
	}

	// Mètode per actualitzar l'estat de la lletra amagada.
	public static void actualitzarLletraAmagada(String paraula) {
		paraulaAmagada = paraula;
	}


	//////////////////////
	//					//
	//	ALTRES MÈTODES	//
	//					//
	//////////////////////

	// Mètode per afegir una paraula nova al joc.
	public static void afegirParaula() {
		Element.titol("AFEGIR NOVA PARAULA");

		String nomNovaParaula = null;
		boolean paraulaValida = false;

		do {
			nomNovaParaula = Entrada.cadena("Paraula");

			// Comprovar que la paraula no estigui buida o sigui null.
			boolean paraulaBuida = false;
			if(nomNovaParaula == null || nomNovaParaula.isEmpty()) {
				paraulaBuida = true;
			}

			// Comprovar que la mida de la paraula sigui vàlida.
			boolean midaValida = false;
			if(nomNovaParaula.length() >= 3) {
				midaValida = true;
			}

			// Comprovar que la paraula sigui una paraula.
			boolean esParaula = true;
			for(int i = 0; i < nomNovaParaula.length(); i++) {
				if(!Character.isAlphabetic(nomNovaParaula.charAt(i))) {
					esParaula = false;
					break;
				}
			}

			// Comprovar que la paraula no estigui repetida a la llista.
			boolean existeixParaula = false;
			for(Paraula paraulaLlista : Paraules.llistaParaules) {
				if(nomNovaParaula.equalsIgnoreCase(paraulaLlista.getParaula())) {
					existeixParaula = true;
					break;
				}
			}

			if(paraulaBuida) {
				Missatge.Error("Introdueix una paraula vàlida");
			} else if(!midaValida) {
				Missatge.Error("La paraula ha de tenir com a mínim 3 lletres");
			} else if(existeixParaula) {
				Missatge.Error("La paraula '" + nomNovaParaula + "' ja existeix al joc");
			} else if(!esParaula) {
				Missatge.Error("La paraula '" + nomNovaParaula + "' no és vàlida");
			} else {
				paraulaValida = true;
			}

		} while(!paraulaValida);

		// Crear la paraula.
		Paraula novaParaula = new Paraula(nomNovaParaula);

		// Afegir la paraula a la llista.
		Paraules.afegirParaula(novaParaula);

		Missatge.Exit("Paraula '" + nomNovaParaula + "' afegida al joc");

	}

	// Mètode per sortir del joc.
	public static void sortir() {
		Element.saltLinia();
		System.out.println("Fins un altre cop!");
		System.exit(0);
	}

}
