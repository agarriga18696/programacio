package Mastermind;

import java.util.ArrayList;
import java.util.List;

public class Partida {

	// Atributs.
	private String nomJugador;
	private List<Character> combinacioSecreta;
	private List<Tirada> llistaTirades;
	private int puntuacio;
	private boolean victoria;
	
	// Constructor.
	public Partida(String nomJugador, List<Character> combinacioSecreta) {
		this.nomJugador = nomJugador;
		this.combinacioSecreta = new ArrayList<>(combinacioSecreta);
		this.llistaTirades = new ArrayList<>();
		this.puntuacio = 0;
		this.victoria = false;
	}

	// Mètodes.
	private int[] comprovarTirada(Tirada tirada) {
		int[] solucio = new int[8];
		
		return solucio;
		
	}
	
	
}
