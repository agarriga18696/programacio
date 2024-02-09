package Paraules;

import java.util.ArrayList;
import java.util.List;

import IU.Missatge;
import Joc.JocPenjat;

public class Paraules {

	public static List<Paraula> llistaParaules = new ArrayList<>();
	public static List<Paraula> llistaParaulesEncertades = new ArrayList<>();

	// Paraules per defecte.
	protected static final Paraula PARAULA_01 = new Paraula("casa");
	protected static final Paraula PARAULA_02 = new Paraula("gós");
	protected static final Paraula PARAULA_03 = new Paraula("escola");
	protected static final Paraula PARAULA_04 = new Paraula("java");

	// Afegir paraula encertada a la llista de paraules encertades.
	public static void afegirParaulaEncertada(Paraula paraula) {
		if(paraula != null && paraula.isEncertada()) {
			llistaParaulesEncertades.add(paraula);

		} else {
			Missatge.ErrorFatal("No s'ha pogut afegir la paraula encertada a la llista");
		}
	}
	
	// Mètode per mostrar la paraula amagada amb espais.
	public static String mostrarParaulaAmbEspais(String paraulaAmagada) {
		StringBuilder paraulaAmagadaAmbEspais = new StringBuilder();
		
		for(int i = 0; i < paraulaAmagada.length(); i++) {
			paraulaAmagadaAmbEspais.append(paraulaAmagada.charAt(i) + " ");
		}
		
		return paraulaAmagadaAmbEspais.toString();
		
	}

	// Mètode per comprovar si la paraula conté la lletra que l'usuari ha introduït.
	public static boolean comprovarSiParauleConteLletra(String lletraString) {
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
	public static String amagarParaula(String paraula) {
		String paraulaAmagada = "";

		if(paraula != null && !paraula.isEmpty()) {
			for(int i = 0; i < paraula.length(); i++) {
				paraulaAmagada = paraulaAmagada + "_";
			}
		}

		return paraulaAmagada;

	}

	// Validar si has endevinat la paraula.
	public static boolean paraulaEndevinada(String paraulaAmagada) {
		boolean paraulaEndevinada = false;

		for(int i = 0; i < paraulaAmagada.length(); i++) {
			if(!paraulaAmagada.contains("_")) {
				paraulaEndevinada = true;
			}
		}

		return paraulaEndevinada;
	}

}
