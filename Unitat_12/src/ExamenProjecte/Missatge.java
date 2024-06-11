package ExamenProjecte;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Missatge {

	// Missatge d'èxit.
	public static void exit(Component parentComponent, String missatge) {
		Object[] opcions = {"D'acord"};

		JOptionPane.showOptionDialog(
				parentComponent, 
				missatge, 
				"Èxit", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, 
				null, 
				opcions, 
				opcions[0]);
	}

	// Missatge d'error.
	public static void error(Component parentComponent, String missatge) {
		Object[] opcions = {"D'acord"};

		JOptionPane.showOptionDialog(
				parentComponent, 
				missatge, 
				"Error", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.ERROR_MESSAGE, 
				null, 
				opcions, 
				opcions[0]);
	}

	// Missatge personalitzat.
	public static void personalitzat(Component parentComponent, String titol, String missatge) {
		Object[] opcions = {"D'acord"};

		JOptionPane.showOptionDialog(
				parentComponent, 
				missatge, 
				titol, 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, 
				null, 
				opcions, 
				opcions[0]);
	}

	// Missatge personalitzat amb opcions.
	public static int opcions(Component parentComponent, String titol, String missatge, int tipus) {
		Object[] opcions = {"Sí", "No"};

		return JOptionPane.showOptionDialog(
				parentComponent, 
				missatge, 
				titol, 
				JOptionPane.YES_NO_OPTION, 
				tipus, 
				null, 
				opcions, 
				opcions[0]);
	}

}
