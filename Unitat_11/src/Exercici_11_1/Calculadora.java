package Exercici_11_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora {
	
	private static final String FONT = "Calibri";

	public static void main(String[] args) {
		// FRAME
		JFrame frame = new JFrame("Calculadora");
		
		// PANELL PRINCIPAL
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new GridLayout(2,1));

		// DISPLAY (on es mostra el resultat)
		JTextField display = new JTextField("0");
		display.setBackground(Color.WHITE);
		display.setHorizontalAlignment(SwingConstants.CENTER);
		display.setEditable(false);
		display.setFont(new Font(FONT, Font.BOLD, 30));

		// BOTONS
		JPanel panelBotons = new JPanel();
		panelBotons.setLayout(new GridLayout(4,4,4,4));
		List<JButton> llistaBotons = crearBotons("7", "8", "9", "+", "4", "5", "6", "-", "3", "2", "1", "x", "0", "C", "=", "/");
		panelBotons = afegirBotons(panelBotons, llistaBotons);
		
		// Afegir el contingut al panel.
		panel.add(display);
		panel.add(panelBotons);

		// Configurar el frame (resolució, visible...).
		configurarFrame(frame);

	}

	// Mètode per crear botons personalitzats.
	private static List<JButton> crearBotons(String... continguts) {
		List<JButton> botons = new ArrayList<>();

		for(int i = 0; i < continguts.length; i++) {
			JButton boto = new JButton(continguts[i]);
			boto.setFont(new Font(FONT, Font.BOLD, 18));
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
		frame.setSize(330, 530);
		frame.setVisible(true);
		frame.setResizable(false);
	}

}
