package Mastermind;

public class Tirada {

	// Atributs.
	private Character[] combinacioIntentada;
	private Integer[] respostaOrdinador;
	private int puntuacioTirada;
	
	// Constructor.
	public Tirada(Character[] combinacioIntentada) {
		this.combinacioIntentada = combinacioIntentada;
		this.respostaOrdinador = new Integer[4];
		this.puntuacioTirada = 0;
	}
	
	// Getters i setters.
	public Character[] getCombinacioIntentada() {
		return combinacioIntentada;
	}

	public Integer[] getRespostaOrdinador() {
		return respostaOrdinador;
	}

	public int getPuntuacioTirada() {
		return puntuacioTirada;
	}
	
}
