package examen_2024.modelo;

import java.util.ArrayList;
import java.util.List;

public class Logica {

	public static List<Combinacion> lista_combinaciones = new ArrayList<>();

	public static void agregarCombinacion(Combinacion combinacion) {
		lista_combinaciones.add(combinacion);
	}

	public static int compararResultado(Combinacion combUsuario, Combinacion combSecreta) {
		int[] usuario = combUsuario.getCombinacion();
		int[] secreta = combSecreta.getCombinacion();
		int aciertos = 0;

		for (int numUsuario : usuario) {
			for (int numSecreto : secreta) {
				if (numUsuario == numSecreto) {
					aciertos++;
				}
			}
		}

		return aciertos;
	}

}
