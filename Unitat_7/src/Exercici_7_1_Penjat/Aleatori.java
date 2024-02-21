package Exercici_7_1_Penjat;

import java.util.Random;

public class Aleatori {

	private static final Random random = new Random();

	// Generar Int aleatori.
	public static int Int(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

	// Generar Double aleatori.
	public static double Double(double min, double max) {
		return min + (max - min) * random.nextDouble();
	}

	// Generar Boolean aleatori.
	public static boolean Boolean() {
		
		return random.nextBoolean();
	}

}
