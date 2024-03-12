package Mastermind_v2;

public class Tirada {

	// Atributs.
	private Character[] combinacioIntentada;
	private Character[] resultatTirada;
	private int puntuacioTirada;
	private int idTirada;
	protected static int numTirada = 1;
	
	// Constructor.
	public Tirada() {
		this.combinacioIntentada = new Character[4];
		this.resultatTirada = new Character[4];
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

	public Character[] getResultatTirada() {
		return resultatTirada;
	}

	public void setResultatTirada(Character[] resultatTirada) {
		this.resultatTirada = resultatTirada;
	}

	public int getPuntuacioTirada() {
		return puntuacioTirada;
	}

	public int getIdTirada() {
		return idTirada;
	}
	
}
