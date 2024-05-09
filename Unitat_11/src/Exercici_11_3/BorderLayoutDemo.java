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
		JPanel panel_principal = (JPanel) frame.getContentPane();
		panel_principal.setLayout(new BorderLayout());

		// PANELL SUPERIOR
		JPanel panel_superior = new JPanel();
		JButton boto1 = new JButton("Button 1 (PAGE_START)");
		panel_superior.add(boto1);

		// PANELL CENTRAL
		// -> 3 columnes (gridlayout)
		JPanel panel_central = new JPanel();
		JButton boto3 = new JButton("Button 3 (LINE_START)");
		JButton boto5 = new JButton("5 (LINE_END)");

		// PANELL CENTRAL VERTICAL
		JPanel panel_central_vertical = new JPanel();
		List<JButton> llistaBotons = crearBotons(5);
		panel_central_vertical = afegirBotons(panel_central_vertical, llistaBotons);

		panel_central.add(boto3, BorderLayout.WEST);
		panel_central.add(panel_central_vertical, BorderLayout.CENTER);
		panel_central.add(boto5, BorderLayout.EAST);
		
		// Afegir contingut al panell principal.
		panel_principal.add(panel_superior, BorderLayout.NORTH);
		panel_principal.add(panel_central, BorderLayout.CENTER);
		
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
