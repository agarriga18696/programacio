package exercici_11_9.vista;

import javax.swing.JOptionPane;

public class Msg {
	
	// MOSTRAR FINESTRES DE DIÀLEGS PELS DIFERENTS TIPUS DE MISSATGE.
	
	// Missatge d'èxit.
	protected static void exit(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Èxit", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Missatge d'error.
	protected static void error(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
}
