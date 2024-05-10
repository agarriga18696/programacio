package Exercici_11_3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutDemo {

	public static void main(String[] args) {
		// FRAME
		JFrame frame = new JFrame("BorderLayoutDemo");
		
		// PANELL PRINCIPAL
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new BorderLayout());

		// CONTINGUT SUPERIOR
		JButton boto_superior = new JButton("Button 1 (PAGE_START)");

		// CONTINGUT CENTRAL
		// -> 3 columnes (gridlayout)
		JButton boto_esquerra = new JButton("Button 3 (LINE_START)");
		JButton boto_dreta = new JButton("5 (LINE_END)");

		// BOTONS CENTRALS EN VERTICAL
		int numBotons = 5;
		JPanel botons_vertical = new JPanel(new GridLayout(numBotons, 0));
		List<JButton> llistaBotons = crearBotons(numBotons);
		botons_vertical = afegirBotons(botons_vertical, llistaBotons);
		
		
		// CONTINGUT INFERIOR
		JButton boto_inferior = new JButton("Long-Named Button 4 (PAGE_END)");
		
		// Afegir contingut al panell principal.
		panel.add(boto_superior, BorderLayout.PAGE_START);
		panel.add(boto_esquerra, BorderLayout.LINE_START);
		panel.add(botons_vertical, BorderLayout.CENTER);
		panel.add(boto_dreta, BorderLayout.LINE_END);
		panel.add(boto_inferior, BorderLayout.PAGE_END);
		
		// Configurar frame.
		frame.pack();
		frame.setVisible(true);
	}

	// Mètode per crear botons personalitzats.
	private static List<JButton> crearBotons(int numBotons) {
		List<JButton> botons = new ArrayList<>();

		for(int i = 0; i < numBotons; i++) {
			JButton boto = new JButton("Central " + (i+1));
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

}
