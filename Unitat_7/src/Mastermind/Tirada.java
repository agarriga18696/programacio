package Mastermind;

public class Tirada {

	// Atributs.
	private Character[] combinacioIntentada;
	private Character[] respostaOrdinador;
	private int puntuacioTirada;
	private int idTirada;
	private static int numTirada = 1;
	
	// Constructor.
	public Tirada() {
		this.combinacioIntentada = new Character[4];
		this.respostaOrdinador = new Character[4];
		this.puntuacioTirada = 0;
		this.idTirada = numTirada++;
	}
	
	// Getters i setters.
	public Character[] getCombinacioIntentada() {
		return combinacioIntentada;
	}

	public void setCombinacioIntentada(Character[] combinacioIntentada) {
		this.combinacioIntentada = combinacioIntentada;
	}

	public Character[] getRespostaOrdinador() {
		return respostaOrdinador;
	}

	public void setRespostaOrdinador(Character[] respostaOrdinador) {
		this.respostaOrdinador = respostaOrdinador;
	}

	public int getPuntuacioTirada() {
		return puntuacioTirada;
	}

	public int getIdTirada() {
		return idTirada;
	}
	
}
