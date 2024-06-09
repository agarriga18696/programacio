package modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.sound.sampled.*;

import vista.Mensaje;

public class Sonido {

	private static Clip cancion;
	private static List<String> listaMusica = new ArrayList<>();
	private static List<Clip> listaSonidos = new ArrayList<>();
	private static List<String> listaSonidosFichas = new ArrayList<>();
	private static Random random = new Random();
	private static boolean seguirReproduciendo = true;
	private static float volumenMusica = 0;
	private static float volumenEfectos = 0;

	// Método para cargar la música desde el directorio.
	private static void cargarMusica() {
		try {
			Files.walk(Paths.get("resources/sound/music"))
			.filter(Files::isRegularFile)
			.forEach(path -> listaMusica.add(path.toString()));
			
		} catch (IOException e) {
			Mensaje.error(null, "Error al intentar cargar la música del directorio:\n" + e);
		}
	}

	// Método para cargar los sonidos de ficha.
	private static void cargarSonidosFicha() {
		try {
			Files.walk(Paths.get("resources/sound/sounds"))
			.filter(Files::isRegularFile)
			.filter(path -> path.getFileName().toString().startsWith("ficha_0"))
			.forEach(path -> listaSonidosFichas.add(path.toString()));
			
		} catch (IOException e) {
			Mensaje.error(null, "Error al intentar cargar los sonidos de ficha:\n" + e);
		}
	}

	// Método para cargar todos los sonidos.
	public static void cargarTodosLosSonidos() {
		cargarMusica();
		cargarSonidosFicha();
	}

	// Método para reproducir una canción en bucle.
	// TODO sin uso de momento.
	public static void reproducirCancion(String soundFileName) {
		try {
			detenerClipActual();
			cancion = crearClip(soundFileName);
			cancion.loop(Clip.LOOP_CONTINUOUSLY);
			ajustarVolumen(cancion, volumenMusica);
			
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			Mensaje.error(null, "Error al intentar reproducir la música:\n" + e);
		}
	}

	// Método para reproducir música aleatoria en bucle.
	public static void reproducirMusicaAleatoria() {
		if(listaMusica.isEmpty()) {
			Mensaje.error(null, "La lista de música está vacía.");
			return;
		}

		seguirReproduciendo = true;
		reproducirCancionAleatoria();
	}

	private static void reproducirCancionAleatoria() {
		try {
			detenerClipActual();
			String soundFileName = listaMusica.get(random.nextInt(listaMusica.size()));
			cancion = crearClip(soundFileName);
			cancion.start();
			ajustarVolumen(cancion, volumenMusica);
			cancion.addLineListener(event -> {
				if(event.getType() == LineEvent.Type.STOP && seguirReproduciendo) {
					reproducirCancionAleatoria();
				}
			});
			
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			Mensaje.error(null, "Error al intentar reproducir la música:\n" + e);
		}
	}

	// Método para reproducir un efecto de sonido.
	public static void reproducirSonido(String soundFileName) {
		try {
			Clip clip = crearClip(soundFileName);
			clip.start();
			ajustarVolumen(clip, volumenEfectos);
			listaSonidos.add(clip);
			clip.addLineListener(event -> {
				if(event.getType() == LineEvent.Type.STOP) {
					clip.close();
					listaSonidos.remove(clip);
				}
			});
			
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			Mensaje.error(null, "Error al intentar reproducir el sonido:\n" + e);
		}
	}

	// Método para reproducir un sonido de ficha aleatorio.
	public static void reproducirSonidoFichaAleatorio() {
		if(listaSonidosFichas.isEmpty()) {
			System.err.println("La lista de sonidos de ficha está vacía.");
			return;
		}

		String soundFileName = listaSonidosFichas.get(random.nextInt(listaSonidosFichas.size()));
		reproducirSonido(soundFileName);
	}

	private static Clip crearClip(String soundFileName) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		File soundFile = new File(soundFileName);
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		return clip;
	}

	// Método para ajustar el volumen de un clip.
	private static void ajustarVolumen(Clip clip, float volume) {
		if(clip != null) {
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
			gainControl.setValue(dB);
		}
	}

	// Método para parar la música.
	public static void pararMusica() {
		seguirReproduciendo = false;
		detenerClipActual();
	}

	// Método para detener el clip actual.
	private static void detenerClipActual() {
		if(cancion != null && cancion.isRunning()) {
			cancion.stop();
			cancion.close();
			cancion = null;
		}
	}

	// Método para parar todos los sonidos.
	public static void pararTodosLosSonidos() {
		for(Clip clip : listaSonidos) {
			if(clip.isRunning()) {
				clip.stop();
				clip.close();
			}
		}
		listaSonidos.clear();
		pararMusica();
	}

	// Métodos para ajustar el volumen de la música.
	public static void setVolumenMusica(float volumen) {
		// Limitar el valor al rango permitido (0.0f - 1.0f)
		if(volumen < 0.0f) {
			volumen = 0.0f;

		} else if(volumen > 1.0f) {
			volumen = 1.0f;
		}

		volumenMusica = volumen;
		ajustarVolumen(cancion, volumenMusica);
	}

	// Método para ajustar el volumen de los efectos de sonido.
	public static void setVolumenEfectos(float volumen) {
		// Limitar el valor al rango permitido (0.0f - 1.0f)
		if(volumen < 0.0f) {
			volumen = 0.0f;

		} else if(volumen > 1.0f) {
			volumen = 1.0f;
		}

		volumenEfectos = volumen;
		for(Clip clip : listaSonidos) {
			ajustarVolumen(clip, volumenEfectos);
		}
	}
}
