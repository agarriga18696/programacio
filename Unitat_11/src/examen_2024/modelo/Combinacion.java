package examen_2024.modelo;

import java.util.Arrays;
import java.util.Random;

public class Combinacion {

	// Atributos.
	private int[] combinacion;

	// Constructor.
	public Combinacion() {
		this.combinacion = generarCombinacion();
	}

	// Getters y setters.
	public int[] getCombinacion() {
		return combinacion;
	}
	
	public void setCombinacion(int[] combinacion) {
		this.combinacion = combinacion;
	}

	public String toString() {
		return Arrays.toString(combinacion);
	}

	// Método para generar aleatoriamente una combinación.
	private int[] generarCombinacion() {
		Random random = new Random();
		int[] comb = new int[6];

		// Generar combinación aleatoria.
		for(int i = 0; i < comb.length; i++) {
			comb[i] = 1 + random.nextInt(50);
		}

		// Comprobar que no haya números repetidos.
		for(int i = 0; i < comb.length; i++) {
			for(int j = i + 1; j <= comb.length - 1; j++) {
				if(comb[j] == comb[i]) {
					comb[j] = 1 + random.nextInt(50);
				}
			}
		}

		return comb;
	}

}
