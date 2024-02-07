package Paraules;

import Utilitat.Aleatori;

public class Paraules {

	public static String generarParaula() {
		String[] paraules = {
				"Casa",
				"Escola",
				"Java",
				"Examen"
		};

		return paraules[Aleatori.Int(0, paraules.length - 1)];
	}
}
