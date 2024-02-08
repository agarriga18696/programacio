package Paraules;

import java.util.ArrayList;
import java.util.List;

import IU.Missatge;
import Joc.JocPenjat;

public class Paraules {
	
	public static List<Paraula> llistaParaules = new ArrayList<>();
	public static List<Paraula> llistaParaulesEncertades = new ArrayList<>();
	
	// Paraules per defecte.
	protected static final Paraula PARAULA_01 = new Paraula("Casa");
	protected static final Paraula PARAULA_02 = new Paraula("Gós");
	protected static final Paraula PARAULA_03 = new Paraula("Escola");
	protected static final Paraula PARAULA_04 = new Paraula("Java");
	
	// Afegir paraula encertada a la llista de paraules encertades.
	public static void afegirParaulaEncertada(Paraula paraula) {
		if(paraula != null && paraula.isEncertada()) {
			llistaParaulesEncertades.add(paraula);
			
		} else {
			Missatge.ErrorFatal("No s'ha pogut afegir la paraula encertada a la llista");
		}
	}
	
	// Mètode per comprovar si la paraula conté la lletra que l'usuari ha introduït.
	public static boolean comprovarSiParauleConteLletra(String lletraString) {
		String paraulaEndevinar = JocPenjat.paraulaActualNormalitzada;
		String lletra = lletraString;
		boolean lletraEncertada = false;
		
		// Comparar la lletra amb la paraula a encertar.
		for(int i = 0; i < paraulaEndevinar.length(); i++) {
			
			System.out.println(paraulaEndevinar.charAt(i));
			
			if(paraulaEndevinar.charAt(i) == lletra.charAt(0)) {
				// Reemplaçar els guions '_' per la lletra endevinada.
				reemplacarLletra(lletra);
				lletraEncertada = true;
				break;
			}
		}
		
		return lletraEncertada;
	}
	
	// Mètode per reemplaçar el guió '_' per la lletra encertada.
	private static void reemplacarLletra(String lletra) {
		
		String paraulaEndevinar = JocPenjat.paraulaActualNormalitzada;
		String paraulaAmagada = JocPenjat.paraulaAmagada;
		
		for(int i = 0; i < paraulaEndevinar.length(); i++) {
			if(paraulaEndevinar.contains(lletra)) {
				char posicioLletra = paraulaEndevinar.charAt(i);
				paraulaAmagada.replace(posicioLletra, lletra.charAt(0));
				JocPenjat.actualitzarLletraAmagada(paraulaAmagada);
				break;
			}
		}
	}

	// Mètode per convertir la paraula a '_'.
	public static String amagarParaula(String paraula) {
		String paraulaAmagada = "";
		
		if(paraula != null && !paraula.isEmpty()) {
			for(int i = 0; i < paraula.length(); i++) {
				paraulaAmagada = paraulaAmagada + "_ ";
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
