package Exercici_11_07;

import java.awt.Color;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IU {

	protected static final String FONT= "Segoe UI Variable";
	protected static final int MIDA_TEXT_TITOL= 20;
	protected static final int MIDA_TEXT_NORMAL = 14;

	// Colors clars.
	protected static final Color COLOR_FONS_CLAR = Color.decode("#eff2f6");
	protected static final Color COLOR_BOTO_CLAR = Color.decode("#d8dbdf");
	protected static final Color COLOR_ENFASIS_CLAR = Color.decode("#0371b5");
	protected static final Color COLOR_TEXT_CLAR = Color.decode("#2d363e");

	// Colors foscos.
	protected static final Color COLOR_FONS_FOSC = Color.decode("#2d2d2d");
	protected static final Color COLOR_BOTO_FOSC = Color.decode("#9a9a9a");
	protected static final Color COLOR_ENFASIS_FOSC = Color.decode("#0371b5");
	protected static final Color COLOR_TEXT_FOSC = Color.decode("#ffffff");

	protected static Color colorFons = COLOR_FONS_CLAR;
	protected static Color colorBoto = COLOR_BOTO_CLAR;
	protected static Color colorEnfasis = COLOR_ENFASIS_CLAR;
	protected static Color colorText = COLOR_TEXT_CLAR;

	// Mètode per actualitzar els colors de la interfície.
	protected static void actualitzarColors(Finestra finestra) {
		// Actualitzar el color del frame.
		finestra.frame.setBackground(colorFons);

		// Actualitzar el color del menú.
		finestra.menu_barra.setBackground(colorFons);
		finestra.menu_barra.setForeground(colorText);

		// Actualitzar els colors dels menús.
		for (JMenu menu : finestra.menu_menus) {
			actualitzarColorsMenu(menu);
		}

		// Actualitzar el color de les pestanyes.
		finestra.pestanyes.setBackground(colorBoto);
		finestra.pestanyes.setForeground(colorText);

		// Actualitzar els colors de les etiquetes.
		for (JLabel label : finestra.labels) {
			label.setForeground(colorText);
		}

		// Actualitzar els colors dels camps de text..
		for (JTextField field : finestra.fields) {
			field.setBorder(BorderFactory.createLineBorder(colorText, 1));
			field.setBackground(COLOR_FONS_CLAR);
			field.setForeground(COLOR_TEXT_CLAR);
		}

		// Actualitzar els colors dels botons.
		for (JButton button : finestra.botons) {
			button.setBackground(colorEnfasis);
			button.setForeground(COLOR_TEXT_FOSC);
		}

		// Actualitzar els colors del grup de botons.
		Enumeration<AbstractButton> buttons = finestra.grup_botons_alumne.getElements();
		while (buttons.hasMoreElements()) {
			AbstractButton button = buttons.nextElement();
			button.setForeground(colorText);
			button.setBackground(colorFons);
		}

		// Actualitzar els colors del menú.
		JMenuBar menuBar = finestra.frame.getJMenuBar();
		if (menuBar != null) {
			for (int i = 0; i < menuBar.getMenuCount(); i++) {
				JMenu menu = menuBar.getMenu(i);
				actualitzarColorsMenu(menu);
			}
		}

		// Actualitzar els colors dels panells.
		for (JPanel panel : finestra.panels) {
			panel.setBackground(colorFons);
		}
	}

	// Mètode per actualitzar els colors dels menús i submenús.
	private static void actualitzarColorsMenu(JMenu menu) {
		menu.setBackground(colorFons);
		menu.setForeground(colorText);

		for (int j = 0; j < menu.getItemCount(); j++) {
			JMenuItem menuItem = menu.getItem(j);
			if (menuItem != null) {
				menuItem.setBackground(colorFons);
				menuItem.setForeground(colorText);

				if (menuItem instanceof JMenu) {
					actualitzarColorsMenu((JMenu) menuItem);
				}
			}
		}
	}

}
