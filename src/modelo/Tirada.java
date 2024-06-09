package modelo;

import java.io.Serializable;

public class Tirada implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos.
	private Integer[] combinacionIntentada;
	private Integer[] resultadoTirada;
	private int puntuacionTirada;
	private int idTirada;
	private static int numTirada = 1;

	// Constructor.
	public Tirada() {
		this.combinacionIntentada = new Integer[Partida.NUM_FICHAS];
		this.resultadoTirada = new Integer[Partida.NUM_FICHAS];
		this.puntuacionTirada = 0;
		this.idTirada = numTirada++;
	}

	// Getters y setters
	public Integer[] getCombinacionIntentada() {
		return combinacionIntentada;
	}

	public void setCombinacionIntentada(Integer[] combinacionIntentada) {
		this.combinacionIntentada = combinacionIntentada;
	}

	public Integer[] getResultadoTirada() {
		return resultadoTirada;
	}

	public void setResultadoTirada(Integer[] resultadoTirada) {
		this.resultadoTirada = resultadoTirada;
	}

	public int getPuntuacionTirada() {
		return puntuacionTirada;
	}

	public void setPuntuacionTirada(int puntuacionTirada) {
		this.puntuacionTirada = puntuacionTirada;
	}

	public int getIdTirada() {
		return idTirada;
	}
	
	public static void reiniciarNumTirada() {
		numTirada = 1;
	}

}
