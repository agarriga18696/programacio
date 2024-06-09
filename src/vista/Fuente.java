package vista;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class Fuente {
	
	// Fuentes personalizadas del juego. 
	// Si no se pueden cargar por x motivos se asignará una por defecto en su lugar.

	private static final String FUENTE_POR_DEFECTO = "Helvetica";
	
	protected static final Font TITULO;
	protected static final Font SUBTITULO;
	protected static final Font TEXTO;
	protected static final Font BOTON;

	// Tamaños predefinidos para cada tipo de texto.
	protected static final int TAM_TEXTO = 16;
	protected static final int TAM_TITULO = 46;
	protected static final int TAM_SUBTITULO = 30;

	static {
		Font tituloFont = null;
		Font subtituloFont = null;
		Font textoFont = null;
		Font botonFont = null;

		try {
			// Cargar la fuente del título desde el archivo.
			Font tituloBase = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/ChangaOne.ttf"));
			// Derivar la fuente del título con el estilo y tamaño deseado.
			tituloFont = tituloBase.deriveFont(Font.BOLD, TAM_TITULO);
			// Registrar la fuente del título en el entorno gráfico.
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(tituloFont);

			subtituloFont = tituloBase.deriveFont(Font.BOLD, TAM_SUBTITULO);
			ge.registerFont(subtituloFont);

			// Cargar la fuente del texto desde el archivo.
			Font textoBase = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Changa.ttf"));
			// Derivar la fuente del texto con el estilo y tamaño deseado.
			textoFont = textoBase.deriveFont(Font.PLAIN, TAM_TEXTO);
			// Registrar la fuente del texto en el entorno gráfico.
			ge.registerFont(textoFont);

			// Cargar la fuente del texto desde el archivo.
			Font botonBase = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Changa.ttf"));
			// Derivar la fuente del texto con el estilo y tamaño deseado.
			botonFont = botonBase.deriveFont(Font.BOLD, TAM_TEXTO);
			// Registrar la fuente del texto en el entorno gráfico.
			ge.registerFont(botonFont);


		} catch (IOException | FontFormatException e) {
			// En caso de error, asignar una fuente por defecto.
			tituloFont = new Font(FUENTE_POR_DEFECTO, Font.BOLD, TAM_TITULO);
			subtituloFont = new Font(FUENTE_POR_DEFECTO, Font.BOLD, 24);
			textoFont = new Font(FUENTE_POR_DEFECTO, Font.PLAIN, TAM_TEXTO);
			botonFont = new Font(FUENTE_POR_DEFECTO, Font.BOLD, TAM_TEXTO);
		}

		TITULO = tituloFont;
		SUBTITULO = subtituloFont;
		TEXTO = textoFont;
		BOTON = botonFont;
	}

	// Método para utilizar una fuente personalizada.
	public static Font personalizada(String fuente, int tipo, int tamano) {
		// El parámetro 'tipo' corresponde al tipo de fuente, por ejemplo: 'Font.BOLD'.
		return new Font(fuente, tipo, tamano);
	}

}
