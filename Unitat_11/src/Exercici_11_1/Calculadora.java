package Exercici_11_1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Calculadora {

	public static void main(String[] args) {
		JFrame calculadora = new JFrame("Calculadora");
		JPanel panel = (JPanel) calculadora.getContentPane();

		// DISPLAY
		JLabel display = new JLabel();
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(display);

		// BOTONS
		JPanel panelBotons = new JPanel();
		List<JButton> llistaBotons = crearBotons("0, 1, 2, 3, 4, 5, 6, 7, 8, 9, C, =, +, -, *, /");
		panelBotons = afegirBotons(panelBotons, llistaBotons);

		// Afegir el panell auxiliar al panell principal.
		panel.add(panelBotons);

		// Configurar el frame (resolució, visible...).
		configurarFrame(calculadora);

	}

	// Mètode per crear botons personalitzats.
	private static List<JButton> crearBotons(String... continguts) {
		List<JButton> botons = new ArrayList<>();

		for(int i = 0; i < continguts.length; i++) {
			JButton boto = new JButton(continguts[i]);
			botons.add(boto);
		}

		return botons;
	}

	// Mètode per afegir els botons al panell.
	private static JPanel afegirBotons(JPanel panel, List<JButton> botons) {
		for(JButton jb : botons) {
			panel.add(jb);
		}

		return panel;
	}

	// Mètode per configurar el frame.
	private static void configurarFrame(JFrame frame) {
		frame.setSize(400, 600);
		frame.setVisible(true);
	}

}
