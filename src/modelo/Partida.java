package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import vista.Mensaje;

public class Partida implements Serializable {

	// Variables estáticas.
	private static final long serialVersionUID = 1L;
	public static final int NUM_INTENTOS = 10;
	public static final int NUM_FICHAS = 4;
	private static int[] contadorCombSecreta;
	private static Integer[] resultadoTirada;
	public static Integer[] combinacionColoresSecreta = new Integer[NUM_FICHAS];

	// Atributos.
	private Integer[] combinacionSecreta;
	private String jugador;
	private int puntuacion;
	private List<Tirada> tiradas;
	private int intentosRestantes;
	// TODO todavía no se ha implementado un uso para la fecha y hora.
	private LocalDate fecha;
	private LocalTime hora_inicio;
	private LocalTime hora_fin;

	// Constructor
	public Partida(String jugador) {
		this.combinacionSecreta = generarCombinacionSecreta();
		combinacionColoresSecreta = combinacionSecreta; // copiar la combinación secreta a la variable estática.
		this.jugador = jugador;
		this.puntuacion = 0;
		this.tiradas = new ArrayList<>();
		this.intentosRestantes = NUM_INTENTOS;
		this.fecha = LocalDate.now();
		this.hora_inicio = LocalTime.now();
		this.hora_fin = null;
	}

	// Getters y setters.
	public String getJugador() {
		return jugador;
	}

	public Integer[] getCombinacionSecreta() {
		return combinacionSecreta;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getIntentosRestantes() {
		return intentosRestantes;
	}

	public void setIntentosRestantes(int intentosRestantes) {
		this.intentosRestantes = intentosRestantes;
	}

	public List<Tirada> getTiradas() {
		return tiradas;
	}

	public void guardarTirada(Tirada tirada) {
		tiradas.add(tirada);
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalTime getHora_inicio() {
		return hora_inicio;
	}

	public LocalTime getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(LocalTime hora_fin) {
		this.hora_fin = hora_fin;
	}

	// Método para generar la combinación secreta.
	private Integer[] generarCombinacionSecreta() {
		Integer[] combSecreta = new Integer[NUM_FICHAS];
		Random random = new Random();

		for(int i = 0; i < NUM_FICHAS; i++) {
			combSecreta[i] = random.nextInt(Colores.LISTA_COLORES.size());
		}

		return combSecreta;
	}

	// Método para comprobar la tirada.
	public Integer[] comprobarTirada(Tirada tirada) {
		contadorCombSecreta = new int[Colores.LISTA_COLORES.size()];
		/*
		 * Índice de colores de la clase Colores:
		 * [0]: rojo
		 * [1]: azul
		 * [2]: verde
		 * [3]: magenta
		 * [4]: amarillo
		 * [5]: cian
		 * [6]: blanco
		 * [7]: negro
		 * 
		 */

		// Inicializar el contador de colores de la combinación secreta.
		for(int i = 0; i < NUM_FICHAS; i++) {
			int indiceColor = combinacionSecreta[i];

			if(indiceColor >= 0 && indiceColor < contadorCombSecreta.length) {
				contadorCombSecreta[indiceColor]++;

			} else {
				Mensaje.error(null, "Índice de color fuera de rango: " + indiceColor);
			}
		}

		// Comparar la tirada del jugador con la combinación secreta.
		Integer[] combinacionIntentada = tirada.getCombinacionIntentada();
		resultadoTirada = new Integer[NUM_FICHAS];

		for(int i = 0; i < NUM_FICHAS; i++) {
			// Comprobar si coincide el mismo color en la posición correcta (negro).
			if(combinacionSecreta[i] == combinacionIntentada[i]) {
				reducirContadorCombinacionSecreta(combinacionSecreta[i], i, 0); // 0 -> ficha negra
			} else {
				// Comprobar si coincide el mismo color en la posición incorrecta (blanco).
				for(int j = 0; j < NUM_FICHAS; j++) {
					if(i != j && combinacionIntentada[i] == combinacionSecreta[j]) {
						reducirContadorCombinacionSecreta(combinacionSecreta[j], i, 1); // 1 -> ficha blanca
					}
				}
			}
		}

		// Desordenar el resultado de la tirada.
		List<Integer> resultadoDesordenado = new ArrayList<>();

		// Añadir el resultado inicial ordenado a la lista desordenada.
		for(Integer resultado : resultadoTirada) {
			resultadoDesordenado.add(resultado);
		}

		// Desordenar la lista.
		Collections.shuffle(resultadoDesordenado);

		// Los valores null deberán ir siempre al final de la lista.
		resultadoDesordenado.removeAll(Collections.singleton(null));
		// Se añaden al final de la lista.
		resultadoDesordenado.addAll(Collections.nCopies(resultadoTirada.length - resultadoDesordenado.size(), null));

		// Copiar la lista desordenada al array del resultado.
		for(int i = 0; i < NUM_FICHAS; i++) {
			resultadoTirada[i] = resultadoDesordenado.get(i);
		}


		return resultadoTirada;
	}

	// Método para reducir el contador de la combinación secreta.
	private void reducirContadorCombinacionSecreta(int indiceCombSecreta, int indiceResultadoTirada, int color) {
		if(indiceCombSecreta >= 0 && indiceCombSecreta < contadorCombSecreta.length) {
			if(contadorCombSecreta[indiceCombSecreta] > 0) {
				resultadoTirada[indiceResultadoTirada] = color;
				contadorCombSecreta[indiceCombSecreta]--;
			}
		} else {
			Mensaje.error(null, "Error en la clase Partida: índice fuera de rango.");
		}
	}

	// TODO solo para pruebas.
	private void mostrarCombinacionSecretaPorConsola() {
		String[] coloresStr = new String[NUM_FICHAS];
		for(int i = 0; i < combinacionSecreta.length; i++) {
			switch(combinacionSecreta[i]) {
			case 0:
				coloresStr[i] = "Rojo";
				break;
			case 1:
				coloresStr[i] = "Azul";
				break;
			case 2:
				coloresStr[i] = "Verde";
				break;
			case 3:
				coloresStr[i] = "Magenta";
				break;
			case 4:
				coloresStr[i] = "Amarillo";
				break;
			case 5:
				coloresStr[i] = "Cian";
				break;
			case 6:
				coloresStr[i] = "Blanco";
				break;
			case 7:
				coloresStr[i] = "Negro";
				break;
			default:
				coloresStr[i] = null;
				break;
			}
		}

		System.out.println(Arrays.toString(coloresStr));
	}

}
