package Exercici_7_1_Penjat;

public class Logica {

	// Mètode per demanar una lletra al jugador.
	protected static void demanarLletra(Jugador jugador) {
		String lletra = null;

		lletra = Normalitzar.llevarAccents(Validar.lletra("Lletra")).toUpperCase();

		boolean lletraEncertada = comprovarSiParauleConteLletra(lletra);

		if (lletraEncertada) {
			Missatge.Personalitzat("👍", "Acert", "'" + lletra + "' s'ha trobat a la paraula");
			// Sumar punts.
			jugador.sumarPunts();
		} else {
			Missatge.Personalitzat("👎", "Fall", "'" + lletra + "' no s'ha trobat a la paraula");
			jugador.restarVides();
			Paraules.llistaLletresFallades.add(lletra);
		}

	}

	// Mètode per comprovar les condicions de victoria / derrota.
	protected static boolean comprovarVictoriaDerrota(String paraulaAmagada, Jugador jugador) {
		// Comprovar si s'ha endevinat la paraula (victoria).
		if (paraulaEndevinada(paraulaAmagada)) {
			Missatge.Personalitzat("🏆", "Victoria", "Has encertat la paraula");
			System.out.println(" Paraules encertades:");
			for(Paraula paraula : Paraules.llistaParaulesEncertades) {
				System.out.println(" - " + paraula.getParaula().toUpperCase());
			}

			// Com que has guanyat es mantindrà la puntuació i la llista de paraules encertades.
			Logica.reiniciarPartida(jugador, "victoria");

			return true;
		}

		// Comprovar si s'ha quedat sense vides (derrota).
		if (jugador.getVides() <= 0) {
			Missatge.Personalitzat("💔", "Derrota", "T'has quedat sense vides");

			// Com que has perdut es perdrà la puntuació i la llista de paraules encertades.
			Logica.reiniciarPartida(jugador, "derrota");

			return true;
		}

		return false;
	}

	// Mètode per reiniciar la partida.
	protected static void reiniciarPartida(Jugador jugador, String condicio) {

		if(condicio.equalsIgnoreCase("victoria")) {
			// Reiniciar les vides.
			jugador.setVides(JocPenjat.videsJugador);
			// Reiniciar contador de paraules fallades.
			Paraules.llistaLletresFallades.clear();
		}

		if(condicio.equalsIgnoreCase("derrota")) {
			// Reiniciar les vides.
			jugador.setVides(JocPenjat.videsJugador);
			// Reiniciar els punts.
			jugador.setPunts(0);
			// Reiniciar contador de paraules fallades.
			Paraules.llistaLletresFallades.clear();
		}

	}

	// Mètode per mostrar la paraula amagada amb espais.
	protected static String mostrarParaulaAmbEspais(String paraulaAmagada) {
		StringBuilder paraulaAmagadaAmbEspais = new StringBuilder();

		for(int i = 0; i < paraulaAmagada.length(); i++) {
			paraulaAmagadaAmbEspais.append(paraulaAmagada.charAt(i) + " ");
		}

		return paraulaAmagadaAmbEspais.toString();

	}

	// Mètode per comprovar si la paraula conté la lletra que l'usuari ha introduït.
	protected static boolean comprovarSiParauleConteLletra(String lletraString) {
		String paraulaEndevinar = JocPenjat.paraulaActualNormalitzada;
		String lletra = lletraString;
		char lletraChar = lletra.charAt(0);
		boolean lletraEncertada = false;

		// Verificar que la lletra introduïda pel jugador hi sigui a la paraula a encertar.
		for(int i = 0; i < paraulaEndevinar.length(); i++) {
			if(paraulaEndevinar.charAt(i) == lletraChar) {
				// Reemplaçar els guions '_' per la lletra endevinada.
				reemplacarLletra(lletraChar, i);
				lletraEncertada = true;
			}
		}

		return lletraEncertada;
	}

	// Mètode per reemplaçar el guió '_' per la lletra encertada.
	private static void reemplacarLletra(char lletra, int posicio) {
		String paraulaAmagada = JocPenjat.paraulaAmagada;
		StringBuilder novaParaulaAmagada = new StringBuilder(paraulaAmagada);

		novaParaulaAmagada.setCharAt(posicio, lletra);

		// Actualitzar la paraula amagada amb la lletra revelada.
		JocPenjat.actualitzarLletraAmagada(novaParaulaAmagada.toString());
	}

	// Mètode per convertir la paraula a '_'.
	protected static String amagarParaula(String paraula) {
		String paraulaAmagada = "";

		if(paraula != null && !paraula.isEmpty()) {
			for(int i = 0; i < paraula.length(); i++) {
				paraulaAmagada = paraulaAmagada + "_";
			}
		}

		return paraulaAmagada;

	}

	// Validar si has endevinat la paraula.
	protected static boolean paraulaEndevinada(String paraulaAmagada) {
		boolean paraulaEndevinada = false;
		Paraula paraula = JocPenjat.paraulaActual;

		for(int i = 0; i < paraulaAmagada.length(); i++) {
			if(!paraulaAmagada.contains("_")) {
				paraulaEndevinada = true;
			}
		}

		// Afegir la paraula endevinada a la llista de paraules endevinades.
		if(paraulaEndevinada) {
			afegirParaulaEncertada(paraula);
		}

		return paraulaEndevinada;
	}

	// Mètode per afegir paraula encertada a la llista de paraules encertades.
	protected static void afegirParaulaEncertada(Paraula paraula) {
		if(paraula != null) {
			Paraules.llistaParaulesEncertades.add(paraula);

		} else {
			Missatge.ErrorFatal("No s'ha pogut afegir la paraula encertada a la llista");
		}
	}

}
