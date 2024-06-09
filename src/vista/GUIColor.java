package vista;

import java.awt.Color;

public class GUIColor {

	// Colores principales de la interfaz.
	public static final Color PRIMARIO = Color.decode("#22242a");
	public static final Color SECUNDARIO = Color.decode("#fefefe");

	// Colores complementarios.
	public static final Color DESTACADO = Color.decode("#4e73e4");
	public static final Color NEGATIVO = Color.decode("#d44957");
	public static final Color ADVERTENCIA = Color.decode("#d4b649");
	public static final Color POSITIVO = Color.decode("#3bba5b");
	public static final Color NEUTRAL = Color.decode("#8d8d8d");

	// Colores del tablero.
	public static final Color TABLERO_FONDO = Color.decode("#9B7451");
	public static final Color TABLERO_BORDE = new Color(SECUNDARIO.getRed(), SECUNDARIO.getGreen(), SECUNDARIO.getBlue(), 40);

	// Colores de las fichas.
	public static final Color FICHA_ROJO = Color.decode("#F75A63");
	public static final Color FICHA_AZUL = Color.decode("#719EE6");
	public static final Color FICHA_VERDE = Color.decode("#51D582");
	public static final Color FICHA_MAGENTA = Color.decode("#E27CF2");
	public static final Color FICHA_AMARILLO = Color.decode("#F3C44C");
	public static final Color FICHA_CIAN = Color.decode("#7CE4DE");
	public static final Color FICHA_BLANCO = Color.decode("#F5F5F5");
	public static final Color FICHA_NEGRO = Color.decode("#313131");
	public static final Color FICHA_NEUTRAL = Color.decode("#725134");
	
	// Colores para el podio del ranking.
	public static final Color ORO = Color.decode("#E7C137");
	public static final Color PLATA = Color.decode("#A8D7DE");
	public static final Color BRONCE = Color.decode("#B77334");

}
