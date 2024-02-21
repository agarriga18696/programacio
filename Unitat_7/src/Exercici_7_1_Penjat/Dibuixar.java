package Exercici_7_1_Penjat;

public class Dibuixar {

	public static void penjat(Jugador jugador) {
		//int videsMaxJugador = JocPenjat.videsJugador;
		int videsActualsJugador = jugador.getVides();

		switch(videsActualsJugador) {
		case 6:
			System.out.println(" ┌────┐");
			System.out.println(" │");
			System.out.println(" │");
			System.out.println(" │");
			System.out.println(" ┴─────");
			break;
		case 5:
			System.out.println(" ┌────┐");
			System.out.println(" │    O");
			System.out.println(" │");
			System.out.println(" │");
			System.out.println(" ┴─────");
			break;
		case 4:
			System.out.println(" ┌────┐");
			System.out.println(" │    O");
			System.out.println(" │    |");
			System.out.println(" │");
			System.out.println(" ┴─────");
			break;
		case 3:
			System.out.println(" ┌────┐");
			System.out.println(" │    O");
			System.out.println(" │   /|");
			System.out.println(" │");
			System.out.println(" ┴─────");
			break;
		case 2:
			System.out.println(" ┌────┐");
			System.out.println(" │    O");
			System.out.println(" │   /|\\");
			System.out.println(" │");
			System.out.println(" ┴─────");
			break;
		case 1:
			System.out.println(" ┌────┐");
			System.out.println(" │    O");
			System.out.println(" │   /|\\");
			System.out.println(" │   /");
			System.out.println(" ┴─────");
			break;
		case 0:
			System.out.println(" ┌────┐");
			System.out.println(" │    O");
			System.out.println(" │   /|\\");
			System.out.println(" │   / \\");
			System.out.println(" ┴─────");
			break;
		default:
			break;
		}
	}

}
