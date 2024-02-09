package Joc;

public class Dibuixar {

	public static void penjat(Jugador jugador) {
		int videsMaxJugador = JocPenjat.videsJugador;
		int videsActualsJugador = jugador.getVides();
		StringBuilder pal = new StringBuilder();
		String base = "┴─────";

		for(int i = 0; i < videsMaxJugador; i++) {
			if(videsActualsJugador < videsMaxJugador) {
				pal.append("│");
			}
		}

		System.out.println(" " + pal);
		System.out.println(" " + base);

	}

}
