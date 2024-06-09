package vista;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Mensaje {

	// Mensaje de éxito
	public static void exito(Component parentComponent, String mensaje) {
		Object[] opciones = {"Aceptar"};

		JOptionPane.showOptionDialog(parentComponent, mensaje, "Éxito", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
	}

	// Mensaje de error
	public static void error(Component parentComponent, String mensaje) {
		Object[] opciones = {"Aceptar"};

		JOptionPane.showOptionDialog(parentComponent, mensaje, "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, opciones, opciones[0]);
	}

	// Mensaje de advertencia
	public static void advertencia(Component parentComponent, String mensaje) {
		Object[] opciones = {"Aceptar"};

		JOptionPane.showOptionDialog(parentComponent, mensaje, "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[0]);
	}

	// Mensaje personalizado
	public static void personalizado(Component parentComponent, String titulo, String mensaje) {
		Object[] opciones = {"Aceptar"};

		JOptionPane.showOptionDialog(parentComponent, mensaje, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
	}

	// Mensaje personalizado con opciones
	public static int opciones(Component parentComponent, String titulo, String mensaje, int tipoMensaje) {
		Object[] opciones = {"Sí", "No"};
		
		return JOptionPane.showOptionDialog(
				parentComponent, 
				mensaje, 
				titulo, 
				JOptionPane.YES_NO_OPTION, 
				tipoMensaje, 
				null, 
				opciones, 
				opciones[0]);
	}

}
