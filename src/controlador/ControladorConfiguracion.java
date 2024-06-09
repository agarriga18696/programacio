package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;

import modelo.Sonido;
import vista.Mensaje;
import vista.VentanaPortal;

public class ControladorConfiguracion {

	// Atributos.
	public String[] modosPantalla = new String[]{
			"Ventana", "Pantalla completa"};

	public String[] resoluciones = new String[]{
		    "2560x1440", "1920x1080", "1680x1050", "1600x900", "1440x900", "1366x900", "1280x864", "1152x864"};

	private VentanaPortal ventanaPortal;
	private String resolucionActual;
	private String modoVentanaActual;
	private float volumenMusicaActual;
	private float volumenEfectosActual;

	private final String ruta = "data/config";

	// Constructor.
	public ControladorConfiguracion(VentanaPortal ventanaPortal) {
		this.ventanaPortal = ventanaPortal;
		this.resolucionActual = resoluciones[4];
		this.modoVentanaActual = modosPantalla[0];
		this.volumenMusicaActual = 3.0f;
		this.volumenEfectosActual = 10.0f;

		cargarConfiguracionFichero();
	}

	// Getters y setters.
	public String getResolucionActual() {
		return resolucionActual;
	}

	public void setResolucionActual(String resolucionActual) {
		this.resolucionActual = resolucionActual;
	}

	public String getModoVentanaActual() {
		return modoVentanaActual;
	}

	public void setModoVentanaActual(String modoVentanaActual) {
		this.modoVentanaActual = modoVentanaActual;
	}

	public float getVolumenMusicaActual() {
		return volumenMusicaActual;
	}

	public void setVolumenMusicaActual(float volumenMusicaActual) {
		this.volumenMusicaActual = volumenMusicaActual;
	}

	public float getVolumenEfectosActual() {
		return volumenEfectosActual;
	}

	public void setVolumenEfectosActual(float volumenEfectosActual) {
		this.volumenEfectosActual = volumenEfectosActual;
	}

	// Método para aplicar los cambios de la configuración al juego.
	public void aplicarCambiosConfiguracion(String resolucion, String modoVentana, float volumenMusica, float volumenEfectos) {
		// Aplicar la configuración de resolución.
		if(resolucion != null) {
			aplicarResolucion(resolucion);
			setResolucionActual(resolucion);
		}

		// Aplicar la configuración de modo de ventana.
		aplicarModoVentana(modoVentana);
		setModoVentanaActual(modoVentana);

		// Aplicar la configuración de volumen de sonido.
		Sonido.setVolumenMusica(volumenMusica);
		Sonido.setVolumenEfectos(volumenEfectos);
		setVolumenMusicaActual(volumenMusica);
		setVolumenEfectosActual(volumenEfectos);
	}

	public void aplicarResolucion(String resolucion) {
		// Separar la resolución en anchura y altura.
		String[] partes = resolucion.split("x");
		int ancho = Integer.parseInt(partes[0]);
		int alto = Integer.parseInt(partes[1]);

		// Aplicar la resolución a la ventana.
		ventanaPortal.setSize(ancho, alto);
		// Centrar la ventana en la pantalla.
		ventanaPortal.setLocationRelativeTo(null);
	}

	public void aplicarModoVentana(String modoVentana) {   
		// Aplicar el modo de ventana.
		if (modoVentana.equalsIgnoreCase(modosPantalla[0])) {
			ventanaPortal.setExtendedState(JFrame.NORMAL);

		} else if (modoVentana.equalsIgnoreCase(modosPantalla[1])) {
			ventanaPortal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
	}

	// Método para guardar la configuración en un fichero.
	public void guardarConfiguracionFichero() {
		String fichero = "config_" + ventanaPortal.getUsuario().getNombre().toLowerCase() + ".dat";
		String rutaCompleta = ruta + File.separator + fichero;

		comprobarDirectorio(ruta);

		// Crear un objeto Properties para almacenar la configuración.
		Properties configuracion = new Properties();

		// Guardar la configuración actual en el objeto Properties.
		configuracion.setProperty("resolucion", getResolucionActual());
		configuracion.setProperty("modoVentana", getModoVentanaActual());
		
		// Multiplicar por 10 antes de convertir a entero y luego a String
		int volumenMusicaInt = Math.round(getVolumenMusicaActual() * 10);
		int volumenEfectosInt = Math.round(getVolumenEfectosActual() * 10);
		configuracion.setProperty("volumenMusica", String.valueOf(volumenMusicaInt));
		configuracion.setProperty("volumenEfectos", String.valueOf(volumenEfectosInt));

		// Escribir el objeto Properties en un fichero.
		try (FileOutputStream salida = new FileOutputStream(rutaCompleta)) {
			configuracion.store(salida, "Configuración del usuario " + ventanaPortal.getUsuario().getNombre());

		} catch (IOException e) {
			Mensaje.error(null, "Error al guardar la configuración:\n" + e);
		}
	}

	// Método para cargar la configuración desde un fichero.
	public void cargarConfiguracionFichero() {
		String fichero = "config_" + ventanaPortal.getUsuario().getNombre().toLowerCase() + ".dat";
		String rutaCompleta = ruta + File.separator + fichero;

		// Crear un objeto Properties para cargar la configuración.
		Properties configuracion = new Properties();

		try (FileInputStream entrada = new FileInputStream(rutaCompleta)) {
			// Intentar cargar la configuración desde el archivo existente.
			configuracion.load(entrada);

		} catch (IOException e) {
			// Si el archivo no existe se cargarán los valores predeterminados y se guardará la configuración en un nuevo archivo.
			aplicarCambiosConfiguracion(resolucionActual, modoVentanaActual, volumenMusicaActual, volumenEfectosActual);
			guardarConfiguracionFichero(); // Guardar la configuración predeterminada en un nuevo archivo.

			String[] partes = resolucionActual.split("x");
			int ancho = Integer.parseInt(partes[0]);
			int alto = Integer.parseInt(partes[1]);

			// Actualizar los atributos de ancho y alto de la ventana.
			ventanaPortal.setAncho_ventana(ancho);
			ventanaPortal.setAlto_ventana(alto);

			return; // Salir del método después de guardar la configuración predeterminada.
		}

		// Leer y aplicar la configuración desde el objeto Properties si se cargó correctamente.
		String resolucion = configuracion.getProperty("resolucion", resolucionActual);
		String modoVentana = configuracion.getProperty("modoVentana", modoVentanaActual);
		float volumenMusica = Float.parseFloat(configuracion.getProperty("volumenMusica", String.valueOf(volumenMusicaActual)));
		float volumenEfectos = Float.parseFloat(configuracion.getProperty("volumenEfectos", String.valueOf(volumenEfectosActual)));
		int anchoVentana = Integer.parseInt(resolucion.split("x")[0]); // Extraer el ancho de la resolución.
		int altoVentana = Integer.parseInt(resolucion.split("x")[1]); // Extraer el alto de la resolución.

		aplicarCambiosConfiguracion(resolucion, modoVentana, volumenMusica, volumenEfectos);

		// Actualizar los atributos de ancho y alto de la ventana.
		ventanaPortal.setAncho_ventana(anchoVentana);
		ventanaPortal.setAlto_ventana(altoVentana);
	}

	// Método para verificar si el directorio existe.
	private void comprobarDirectorio(String rutaDirectorio) {
		// Si el directorio no existe, crear uno nuevo.
		File directorio = new File(rutaDirectorio);
		if(!directorio.exists()) {
			directorio.mkdirs();
		}
	}

}
