package Exercici_7_1_Penjat;

import java.util.ArrayList;
import java.util.List;

public class Paraules {

	public static List<Paraula> llistaParaules = new ArrayList<>();
	public static List<Paraula> llistaParaulesEncertades = new ArrayList<>();
	public static List<String> llistaLletresFallades = new ArrayList<>();

	// Paraules per defecte.
	private static final Paraula PARAULA_01 = new Paraula("casa");
	private static final Paraula PARAULA_02 = new Paraula("gós");
	private static final Paraula PARAULA_03 = new Paraula("escola");
	private static final Paraula PARAULA_04 = new Paraula("java");
	
	public static void inicialitzarParaulesPerDefecte() {
		Paraules.llistaParaules.add(PARAULA_01);
		Paraules.llistaParaules.add(PARAULA_02);
		Paraules.llistaParaules.add(PARAULA_03);
		Paraules.llistaParaules.add(PARAULA_04);
	}
	
	// Mètode per afegir paraula a la llista.
	public static void afegirParaula(Paraula paraula) {
		llistaParaules.add(paraula);
	}

}
