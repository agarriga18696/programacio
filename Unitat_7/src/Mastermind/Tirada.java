package Mastermind;

public class Tirada {

	// Atributs.
	private char[] combinacioIntentada;
	private int[] respostaOrdinador;
	private int puntuacioTirada;
	
	// Constructor.
	public Tirada(char[] combinacioIntentada, int[] respostaOrdinador, int puntuacioTirada) {
		this.combinacioIntentada = combinacioIntentada;
		this.respostaOrdinador = respostaOrdinador;
		this.puntuacioTirada = puntuacioTirada;
	}
	
}
