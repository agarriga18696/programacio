package exercici_11_9.vista;

import javax.swing.JOptionPane;

public class Msg {

	// Missatge d'èxit.
	public static void exit(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Èxit", JOptionPane.INFORMATION_MESSAGE);
	}

	// Missatge d'error.
	public static void error(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}

	// Missatge d'advertencia.
	public static void advertencia(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Advertència", JOptionPane.WARNING_MESSAGE);
	}

	// Missatge simple.
	public static void simple(String titol, String msg) {
		JOptionPane.showMessageDialog(null, msg, titol, JOptionPane.PLAIN_MESSAGE);
	}

}
