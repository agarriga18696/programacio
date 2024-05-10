package Exercici_11_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora {

	private static final String FONT = "Segoe UI Variable";

	private static final Color COLOR_FONS = Color.decode("#ecf6f8");
	private static final Color COLOR_BOTONS_1 = Color.decode("#acc3c8");
	private static final Color COLOR_BOTONS_2 = Color.decode("#c3dadf");
	private static final Color COLOR_ENFASIS = Color.decode("#55a9dd");
	private static final Color COLOR_TEXT = Color.decode("#2d363e");

	/*private static final Color COLOR_1 = Color.decode("#36404a");
	private static final Color COLOR_2 = Color.decode("#4b5763");
	private static final Color COLOR_3 = Color.decode("#606e7b");
	private static final Color COLOR_4 = Color.decode("#e3e8ee");
	private static final Color COLOR_5 = Color.decode("#48afdb");*/

	public static void main(String[] args) {
		// FRAME
		JFrame frame = new JFrame("Calculadora");

		// PANELL PRINCIPAL
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new GridLayout(2,1));

		// DISPLAY (on es mostra el resultat)
		JTextField display = new JTextField("0");
		display.setBackground(Color.WHITE);
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		int p = 10; // padding text
		display.setBorder(BorderFactory.createEmptyBorder(p,p,p,p));
		display.setEditable(false);

		// BOTONS
		JPanel panelBotons = new JPanel();
		panelBotons.setLayout(new GridLayout(4,4,4,4));
		List<JButton> llistaBotons = crearBotons("7", "8", "9", "+", "4", "5", "6", "-", "3", "2", "1", "×", "0", "C", "=", "/");
		panelBotons = afegirBotons(panelBotons, llistaBotons);

		// Afegir el contingut al panel.
		panel.add(display);
		panel.add(panelBotons);

		// ESTIL I COLOR
		display.setBackground(COLOR_FONS);
		display.setFont(new Font(FONT, Font.BOLD, 44));
		display.setForeground(COLOR_TEXT);
		panel.setBackground(COLOR_FONS);
		panelBotons.setBackground(COLOR_FONS);

		// Configurar el frame (resolució, visible...).
		configurarFrame(frame);

	}

	// Mètode per crear botons personalitzats.
	private static List<JButton> crearBotons(String... continguts) {
		List<JButton> botons = new ArrayList<>();

		for(int i = 0; i < continguts.length; i++) {
			JButton boto = new JButton(continguts[i]);
			boto.setFont(new Font(FONT, Font.PLAIN, 18));
			boto.setHorizontalAlignment(JButton.CENTER);
			boto.setVerticalAlignment(JButton.CENTER);
			boto.setForeground(COLOR_TEXT);

			// Assignar un color diferent segons el tipus de tecla.
			if(boto.getText().charAt(0) >= 48 && boto.getText().charAt(0) <= 57) {
				// Tecles numèriques.
				boto.setBackground(COLOR_BOTONS_2);

			} else if(boto.getText().equals("=")) {
				// Tecla de resultat (igual).
				boto.setBackground(COLOR_ENFASIS);
				boto.setFont(new Font(FONT, Font.PLAIN, 24));
				boto.setForeground(COLOR_FONS);

			} else if(boto.getText().equalsIgnoreCase("c")) {
				boto.setBackground(COLOR_BOTONS_1);
				boto.setFont(new Font(FONT, Font.PLAIN, 18));

			} else {
				// Resta de tecles.
				boto.setBackground(COLOR_BOTONS_1);
				boto.setFont(new Font(FONT, Font.PLAIN, 24));
			}

			boto.setBorderPainted(false);
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
		// Afegir un Listener a la finestra per què quan es tanqui també tanqui el procés.
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		frame.setSize(330, 535);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(true);
	}

}
