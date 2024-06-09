package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import modelo.Partida;
import vista.Mensaje;

public class ControladorRanking {

	// Atributos.
	private List<Partida> partidas;
	private final String ruta = "data/savegames";

	// Constructor.
	public ControladorRanking() {
		this.partidas = new ArrayList<>();
	}

	// Getters y setters.
	public List<Partida> getPartidas() {
		return partidas;
	}

	// Método para agregar una partida a la lista de partidas.
	public void agregarPartida(Partida partida) {
		// Agregar las partidas y ordenarlas por puntuación de mayor a menor.
		partidas.add(partida);
		partidas.sort(Comparator.comparingInt(Partida::getPuntuacion).reversed());
	}

	// Método para cargar los datos del ranking de los ficheros de guardado de los usuarios.
	public void cargarRanking() {
		File directorio = new File(ruta);
		File[] archivos = directorio.listFiles();

		// Leer los archivos de guardado de cada usuario y extraer las partidas.
		if(archivos != null) {
			for(File archivo : archivos) {
				if(archivo.isFile() && archivo.getName().endsWith(".ser")) {
					try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))){
						@SuppressWarnings("unchecked")
						List<Partida> partidasGuardadas = (List<Partida>) ois.readObject();
						partidas.addAll(partidasGuardadas);

					} catch(IOException | ClassNotFoundException  e) {
						Mensaje.error(null, "Ha ocurrido un error:\n" + e);
					}
				}
			}
		}

		// Ordenar las partidas por puntuación.
		partidas.sort(Comparator.comparingInt(Partida::getPuntuacion).reversed());
	}

	// Método para obtener el ranking de las partidas.
	public List<Partida> obtenerRanking(){
		return partidas;
	}

	// Método para obtener los datos del ranking.
	public Object[][] obtenerDatosRanking(){
		Object[][] datos = new Object[partidas.size()][3];

		for(int i = 0; i < partidas.size(); i++) {
			Partida partida = partidas.get(i);
			// Solamente las partidas con puntuación mayor que zero.
			if(partida.getPuntuacion() > 0) {
				datos[i][0] = i + 1;
				datos[i][1] = partida.getJugador();
				datos[i][2] = partida.getPuntuacion();
			}
		}

		return datos;
	}

}
