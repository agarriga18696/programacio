package Exercici_11_04;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora {

	private static final String FONT = "Segoe UI Variable";

	// Colors clars.
	private static final Color COLOR_FONS_CLAR = Color.decode("#eff2f6");
	private static final Color COLOR_BOTONS_1_CLAR = Color.decode("#d8dbdf");
	private static final Color COLOR_BOTONS_2_CLAR = Color.decode("#e2e5e9");
	private static final Color COLOR_ENFASIS_CLAR = Color.decode("#0371b5");
	private static final Color COLOR_TEXT_CLAR = Color.decode("#2d363e");

	// Colors foscos.
	private static final Color COLOR_FONS_FOSC = Color.decode("#2d2d2d");
	private static final Color COLOR_BOTONS_1_FOSC = Color.decode("#3a3a3a");
	private static final Color COLOR_BOTONS_2_FOSC = Color.decode("#4a4a4a");
	private static final Color COLOR_ENFASIS_FOSC = Color.decode("#0371b5");
	private static final Color COLOR_TEXT_FOSC = Color.decode("#ffffff");

	private static Color colorFons = COLOR_FONS_CLAR;
	private static Color colorBotons1 = COLOR_BOTONS_1_CLAR;
	private static Color colorBotons2 = COLOR_BOTONS_2_CLAR;
	private static Color colorEnfasis = COLOR_ENFASIS_CLAR;
	private static Color colorText = COLOR_TEXT_CLAR;

	private static JTextField display;
	private static JPanel panell_principal;
	private static JPanel panellBotons;
	private static JMenuBar barra_menu;

	public static void main(String[] args) {
		// FRAME
		JFrame frame = new JFrame("Calculadora");

		// PANELL PRINCIPAL
		panell_principal = (JPanel) frame.getContentPane();
		panell_principal.setLayout(new GridLayout(2, 1));

		// BARRA DE MENÚ
		barra_menu = new JMenuBar();
		JMenu menu = new JMenu("Tema");
		menu.setFont(new Font(FONT, Font.BOLD, 14));
		List<JMenuItem> llistaElementsMenu = crearElementsMenu("Oscuro", "Claro");
		menu = afegirElementsMenu(menu, llistaElementsMenu);
		barra_menu.add(menu); // Afegir menú a la barra de menú.
		frame.setJMenuBar(barra_menu); // Assignar la barra de menú a la finestra.

		// DISPLAY (on es mostra el resultat)
		display = new JTextField("0");
		display.setFont(new Font(FONT, Font.BOLD, 44));
		display.setBackground(Color.WHITE);
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		int tp = 10; // padding del text
		display.setBorder(BorderFactory.createEmptyBorder(tp, tp, tp, tp));
		display.setEditable(false);

		// BOTONS
		panellBotons = new JPanel();
		panellBotons.setLayout(new GridLayout(4, 4, 4, 4));
		List<JButton> llistaBotons = crearBotons("7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "×", "C", "0", "=", "÷");
		panellBotons = afegirBotonsPanell(panellBotons, llistaBotons);

		// Afegir el contingut al panell.
		panell_principal.add(display);
		panell_principal.add(panellBotons);

		// ESTIL I COLOR
		actualitzarColors();

		// Configurar el frame (comportament, mida, visible...).
		configurarFrame(frame);
	}

	// Mètode per crear botons personalitzats.
	private static List<JButton> crearBotons(String... continguts) {
		List<JButton> botons = new ArrayList<>();

		for (int i = 0; i < continguts.length; i++) {
			JButton boto = new JButton(continguts[i]);
			boto.setFont(new Font(FONT, Font.PLAIN, 18));
			boto.setHorizontalAlignment(JButton.CENTER);
			boto.setVerticalAlignment(JButton.CENTER);
			boto.setForeground(colorText);

			// Assignar un color diferent segons el tipus de tecla.
			if (boto.getText().charAt(0) >= 48 && boto.getText().charAt(0) <= 57) {
				// Tecles numèriques.
				boto.setBackground(colorBotons2);

			} else if (boto.getText().equals("=")) {
				// Tecla de resultat (igual).
				boto.setBackground(colorEnfasis);
				boto.setFont(new Font(FONT, Font.PLAIN, 24));
				boto.setForeground(colorFons);

			} else if (boto.getText().equalsIgnoreCase("c")) {
				boto.setBackground(colorBotons1);
				boto.setFont(new Font(FONT, Font.PLAIN, 18));

			} else {
				// Resta de tecles.
				boto.setBackground(colorBotons1);
				boto.setFont(new Font(FONT, Font.PLAIN, 24));
			}

			boto.setBorderPainted(false);
			botons.add(boto);
		}

		return botons;
	}

	// Mètode per crear elements del menú personalitzats.
	private static List<JMenuItem> crearElementsMenu(String... elements) {
		List<JMenuItem> llista_elements = new ArrayList<>();

		for (int i = 0; i < elements.length; i++) {
			JMenuItem element = new JMenuItem(elements[i]);
			element.setFont(new Font(FONT, Font.PLAIN, 14));
			element.setBackground(colorFons);
			element.setForeground(colorText);

			// Afegir un action listener a cada botó per poder canviar el tema de la calculadora.
			element.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (element.getText().equalsIgnoreCase("Oscuro")) {
						colorFons = COLOR_FONS_FOSC;
						colorBotons1 = COLOR_BOTONS_1_FOSC;
						colorBotons2 = COLOR_BOTONS_2_FOSC;
						colorEnfasis = COLOR_ENFASIS_FOSC;
						colorText = COLOR_TEXT_FOSC;
					} else {
						colorFons = COLOR_FONS_CLAR;
						colorBotons1 = COLOR_BOTONS_1_CLAR;
						colorBotons2 = COLOR_BOTONS_2_CLAR;
						colorEnfasis = COLOR_ENFASIS_CLAR;
						colorText = COLOR_TEXT_CLAR;
					}
					actualitzarColors();
				}
			});

			llista_elements.add(element);
		}

		return llista_elements;
	}

	// Mètode per actualitzar els colors de la interfície.
	private static void actualitzarColors() {
		display.setBackground(colorFons);
		display.setForeground(colorText);

		panell_principal.setBackground(colorFons);
		panellBotons.setBackground(colorFons);

		for (int i = 0; i < panellBotons.getComponentCount(); i++) {
			JButton boto = (JButton) panellBotons.getComponent(i);
			if (boto.getText().charAt(0) >= 48 && boto.getText().charAt(0) <= 57) {
				// Tecles numèriques.
				boto.setBackground(colorBotons2);
			} else if (boto.getText().equals("=")) {
				// Tecla de resultat (igual).
				boto.setBackground(colorEnfasis);
				boto.setForeground(colorFons);
			} else if (boto.getText().equalsIgnoreCase("c")) {
				boto.setBackground(colorBotons1);
			} else {
				// Resta de tecles.
				boto.setBackground(colorBotons1);
			}
			boto.setForeground(colorText);
		}

		barra_menu.setBackground(colorFons);
		for (int i = 0; i < barra_menu.getMenuCount(); i++) {
			JMenu menu = barra_menu.getMenu(i);
			menu.setForeground(colorText);
			for (int j = 0; j < menu.getItemCount(); j++) {
				JMenuItem item = menu.getItem(j);
				item.setBackground(colorFons);
				item.setForeground(colorText);
			}
		}
	}

	// Mètode per afegir els botons al panell.
	private static JPanel afegirBotonsPanell(JPanel panell, List<JButton> botons) {
		for (JButton jb : botons) {
			panell.add(jb);
		}

		return panell;
	}

	// Mètode per afegir els elements al menú.
	private static JMenu afegirElementsMenu(JMenu menu, List<JMenuItem> elements) {
		for (JMenuItem element : elements) {
			menu.add(element);
		}

		return menu;
	}

	// Mètode per configurar el frame.
	private static void configurarFrame(JFrame frame) {
		// Comportament al tancar la finestra.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Configuració de la finestra.
		frame.setSize(330, 535);
		frame.setMinimumSize(new Dimension(330, 535));
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
	}
}