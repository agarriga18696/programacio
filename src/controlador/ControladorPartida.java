package controlador;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.Colores;
import modelo.Partida;
import modelo.Sonido;
import modelo.Tirada;
import vista.GUIColor;
import vista.Mensaje;
import vista.VentanaPortal;

public class ControladorPartida {

	// Atributos.
	private Partida partida;
	private Tirada tirada;
	private boolean partidaFinalizada;
	private List<Partida> partidas;
	private int puntos;
	private VentanaPortal ventanaPortal;

	private final String ruta = "data/savegames";

	// Constructor.
	public ControladorPartida(VentanaPortal ventanaPortal) {
		this.ventanaPortal = ventanaPortal;
		this.partidaFinalizada = false;
		this.partidas = cargarPartidasFichero();
		this.tirada = null;
		this.puntos = 0;
	}

	public Partida getPartida() {
		return partida;
	}

	public Tirada getTirada() {
		return tirada;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public boolean isPartidaFinalizada() {
		return partidaFinalizada;
	}

	// Método para iniciar una nueva partida.
	public void nuevaPartida() {
		partida = new Partida(ventanaPortal.getUsuario().getNombre());

		// Reiniciar variables.
		partida.setIntentosRestantes(Partida.NUM_INTENTOS);
		partida.setPuntuacion(0);

		ventanaPortal.getLblPuntuacion().setText("Puntos:   " + 0);
		ventanaPortal.getLblIntentos().setText("Intentos:   " + 0);

		// Activar botón de comprobar tirada.
		ventanaPortal.getBtnTirar().setEnabled(true);

		// Reiniciar el contador de tiradas.
		Tirada.reiniciarNumTirada();	
	}

	// Método para crear una nueva tirada.
	public void nuevaTirada() {
		tirada = new Tirada();

		Integer[] combIntentada = convertirCombinacion(ventanaPortal.getTablero().getCombinacionIntentada());
		tirada.setCombinacionIntentada(combIntentada);

		Integer[] resultadoTirada = partida.comprobarTirada(tirada);
		tirada.setResultadoTirada(resultadoTirada);

		// Mostrar la combinación intentada y el resultado en el tablero.
		mostrarIntentoYResultadoTablero(combIntentada, resultadoTirada);

		// Comprobar si se ha adivinado la combinación secreta.
		boolean combinacionAdivinada = comprobarResultado(resultadoTirada);

		// Asignar la puntuación de la tirada.
		// Si se ha adivinado la combinación en el primer intento se aplicará la puntuación máxima especial.
		if(combinacionAdivinada && tirada.getIdTirada() == 1) {
			puntos = 100;

		} else {
			puntos += calcularPuntos(resultadoTirada);
		}

		tirada.setPuntuacionTirada(puntos);
		partida.setPuntuacion(puntos);
		ventanaPortal.getLblPuntuacion().setText("Puntos:   " + puntos);

		// Guardar la tirada en la lista de tiradas de la partida.
		partida.guardarTirada(tirada);

		// Reducir intentos restantes.
		partida.setIntentosRestantes(partida.getIntentosRestantes() - 1);
		ventanaPortal.getLblIntentos().setText("Intentos:   " + partida.getIntentosRestantes());

		// Comprobar condiciones de victoria y derrota.
		comprobarVictoriaDerrota(combinacionAdivinada);
	}

	// Método para calcular los puntos de la tirada.
	private int calcularPuntos(Integer[] resultadoTirada) {
		int puntos = 0;

		for(Integer resultado : resultadoTirada) {
			if(resultado != null && resultado == 0) {
				puntos += 2; // puntos por cada ficha negra.

			} else if(resultado != null && resultado == 1) {
				puntos += 1; // puntos por cada ficha blanca.
			}
		}

		return puntos;
	}

	// Método para mostrar la combinación intentada y el resultado en el tablero.
	private void mostrarIntentoYResultadoTablero(Integer[] combIntentada, Integer[] resultadoTirada) {
		// Guardar la combinación intentada en la fila de intentos correspondiente del tablero.
		Map<Integer, Color> mapaColor = Map.of(
				0, GUIColor.FICHA_ROJO,
				1, GUIColor.FICHA_AZUL,
				2, GUIColor.FICHA_VERDE,
				3, GUIColor.FICHA_MAGENTA,
				4, GUIColor.FICHA_AMARILLO, 
				5, GUIColor.FICHA_CIAN,
				6, GUIColor.FICHA_BLANCO,
				7, GUIColor.FICHA_NEGRO);

		int intentosRestantes = partida.getIntentosRestantes() - 1;

		// Actualizar colores de las fichas de intento del jugador.
		for(int i = 0; i < Partida.NUM_FICHAS; i++) {
			Color color = mapaColor.getOrDefault(combIntentada[i], GUIColor.FICHA_NEUTRAL);
			ventanaPortal.getTablero().getFichasIntentoJugador()[intentosRestantes][i].setBackground(color);
		}

		// Actualizar colores de las fichas de resultado de la tirada.
		for(int i = 0; i < Partida.NUM_FICHAS; i++) {
			if(resultadoTirada[i] != null) {
				Color color;

				switch(resultadoTirada[i]) {
				case 0:
					color = GUIColor.FICHA_NEGRO;
					break;
				case 1:
					color = GUIColor.FICHA_BLANCO;
					break;
				default:
					color = GUIColor.FICHA_NEUTRAL;
					break;
				}

				ventanaPortal.getTablero().getFichasResultadoJugador()[intentosRestantes][i].setBackground(color);

			} else {
				ventanaPortal.getTablero().getFichasResultadoJugador()[intentosRestantes][i].setBackground(GUIColor.FICHA_NEUTRAL);
			}
		}

	}

	// Método para comprobar si ha adivinado la combinación secreta.
	private boolean comprobarResultado(Integer[] resultadoTirada) {
		for(Integer i : resultadoTirada) {
			if(i != null && !i.equals(0)) {
				return false;

			} else if(i == null) {
				return false;
			}
		}

		return true;
	}

	// Método para verificar si se ha introducido una combinación váida.
	public boolean esCombinacionValida() {
		for(int i = 0; i < Partida.NUM_FICHAS; i++) {
			if(ventanaPortal.getTablero().getCombinacionIntentada()[i] == null) {
				return false;
			}
		}

		return true;
	}

	// Método para convertir la combinación de String[] a Integer[].
	private Integer[] convertirCombinacion(String[] combinacionString) {
		Integer[] combinacionIntentada = new Integer[Partida.NUM_FICHAS];

		List<String> listaColores = Colores.LISTA_COLORES;

		for(int i = 0; i < Partida.NUM_FICHAS; i++) {
			String indiceCombinacion = combinacionString[i].toLowerCase();
			int indice = listaColores.indexOf(indiceCombinacion.substring(0, 1).toUpperCase() + indiceCombinacion.substring(1));
			combinacionIntentada[i] = (indice != -1) ? indice : null;
		}

		return combinacionIntentada;
	}

	// Método para comprobar las condiciones de victoria y derrota.
	private void comprobarVictoriaDerrota(boolean combinacionAdivinada) {
		if(combinacionAdivinada || partida.getIntentosRestantes() <= 0) {
			partidaFinalizada = true;

			// Desactivar botón de tirar y cambiar su color.
			ventanaPortal.getBtnTirar().setEnabled(false);
			ventanaPortal.getBtnTirar().setBackground(GUIColor.NEUTRAL);
			// Cambiar el color del botón Terminar a un color positivo para dar a entender que se ha terminado la partida de manera válida.
			// Por lo tanto, indiferentemente de si se ha ganado o perdido, la partida será válida para ser guardada.
			// Por lo contrario, si la partida no ha terminado el botón será de un color negativo, por lo que al abandonar la partida
			// no se guardará el progreso.
			ventanaPortal.getBtnTerminar().setText("GUARDAR Y TERMINAR");
			ventanaPortal.getBtnTerminar().setBackground(GUIColor.POSITIVO);

			// Mostrar la combinación secreta.
			ventanaPortal.getTablero().mostrarCombinacionSecreta();

			// Desactivar los botones de las fichas del jugador.
			ventanaPortal.getTablero().fichasJugadorActivadas(false);

			Sonido.pararMusica();

			// Victoria.
			if(combinacionAdivinada) {
				Sonido.reproducirSonido("resources/sound/sounds/UI/Success/Success_8.wav");

				// Verificar si ha acertado la combinación en el primer intento o no.
				if(tirada.getIdTirada() == 1) {
					Mensaje.personalizado(null, "¡Victoria magistral!", "¡Enhorabuena! ¡Has acertado la combinación secreta a la primera!");

				} else {
					Mensaje.personalizado(null, "¡Victoria!", "¡Has ganado! ¡Has acertado la combinación secreta!");
				}
				
				// Incrementar el contador de partidas ganadas del usuario.
				ventanaPortal.getUsuario().setPartidasGanadas(ventanaPortal.getUsuario().getPartidasGanadas() + 1);
			}

			// Derrota.
			if(partida.getIntentosRestantes() <= 0 && !combinacionAdivinada) {
				Sonido.reproducirSonido("resources/sound/sounds/derrota.wav");

				Mensaje.personalizado(null, "¡Derrota!", "¡Has perdido! Te has quedado sin intentos.");
				
				// Incrementar el contador de partidas perdidas del usuario.
				ventanaPortal.getUsuario().setPartidasPerdidas(ventanaPortal.getUsuario().getPartidasPerdidas() + 1);
			}

			// Guardar la hora de fin de la partida.
			partida.setHora_fin(LocalTime.now());

			// Guardar la partida en la lista de partidas.
			agregarPartida(partida);

			// Actualizar la tabla del ranking.
			ventanaPortal.actualizarRanking(partida);
			
			// Actualizar las estadísticas del perfil del jugador.
			ventanaPortal.actualizarEstadisticasPerfil();
		}
	}

	// Método para guardar la partida en el fichero.
	public void guardarPartidaFichero() {
		String fichero = "partidas_" + ventanaPortal.getUsuario().getNombre().toLowerCase() + ".ser";
		String rutaCompleta = ruta + File.separator + fichero;

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaCompleta))){
			oos.writeObject(partidas);

		} catch (FileNotFoundException e) {
			// El archivo no existe.
		} catch (IOException e) {
			Mensaje.error(null, "Error al intentar guardar la partida en el fichero.");
		}
	}

	// Método para cargar las partidas del fichero.
	@SuppressWarnings("unchecked")
	private List<Partida> cargarPartidasFichero() {
		String fichero = "partidas_" + ventanaPortal.getUsuario().getNombre().toLowerCase() + ".ser";
		String rutaCompleta = ruta + File.separator + fichero;

		List<Partida> partidas = new ArrayList<>();

		comprobarDirectorio(ruta);

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaCompleta))) {
			// Verificar que el archivo contenga datos válidos.
			Object objeto = ois.readObject();
			if (objeto instanceof List) {
				partidas = (List<Partida>) objeto;
			} else {
				Mensaje.error(null, "El archivo de partidas no contiene una lista de partidas válida.");
			}

		} catch (FileNotFoundException e) {
			// El archivo no existe.
		} catch (IOException | ClassNotFoundException e) {
			Mensaje.error(null, "Error al cargar las partidas.");
		}

		return partidas;
	}

	// Método para verificar si el directorio existe.
	private void comprobarDirectorio(String rutaDirectorio) {
		// Si el directorio no existe, crear uno nuevo.
		File directorio = new File(rutaDirectorio);
		if(!directorio.exists()) {
			directorio.mkdirs();
		}
	}

	// Método para agregar una partida a la lista de partidas.
	private void agregarPartida(Partida partida) {
		partidas.add(partida);
	}

}
