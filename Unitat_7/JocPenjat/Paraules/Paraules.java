package Paraules;

import java.util.ArrayList;
import java.util.List;

import IU.Missatge;

public class Paraules {

	public static List<Paraula> llistaParaules = new ArrayList<>();
	public static List<Paraula> llistaParaulesEncertades = new ArrayList<>();
	public static List<String> llistaLletresFallades = new ArrayList<>();

	// Paraules per defecte.
	protected static final Paraula PARAULA_01 = new Paraula("casa");
	protected static final Paraula PARAULA_02 = new Paraula("gós");
	protected static final Paraula PARAULA_03 = new Paraula("escola");
	protected static final Paraula PARAULA_04 = new Paraula("java");
	protected static final Paraula PARAULA_05 = new Paraula("tsunoda");
	protected static final Paraula PARAULA_06 = new Paraula("alonso");

	// Afegir paraula encertada a la llista de paraules encertades.
	public static void afegirParaulaEncertada(Paraula paraula) {
		if(paraula != null && paraula.isEncertada()) {
			llistaParaulesEncertades.add(paraula);

		} else {
			Missatge.ErrorFatal("No s'ha pogut afegir la paraula encertada a la llista");
		}
	}

}
