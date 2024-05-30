package Exercici_11_02;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Exercici {

	public static void main(String[] args) {
		// FRAME
		JFrame frame = new JFrame("Swing Counter with RadioButton & ComboBox");
		
		// PANELL PRINCIPAL
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new FlowLayout());
		
		// COUNTER
		JLabel counterLabel = new JLabel("Counter:");
		JTextField counterText = new JTextField("0", 8);
		counterText.setHorizontalAlignment(SwingConstants.RIGHT);
		counterText.setEditable(false);
		
		// GRUP BOTONS
		ButtonGroup grupBotons = new ButtonGroup();
		JRadioButton radio1 = new JRadioButton("Up");
		JRadioButton radio2 = new JRadioButton("Down");
		radio1.setSelected(true);
		grupBotons.add(radio1);
		grupBotons.add(radio2);
		
		// COMBO BOX
		String[] opcionsCombo = {"1", "2", "3", "4"};
		JComboBox<String> comboBox = new JComboBox<>(opcionsCombo);
		comboBox.setPreferredSize(new Dimension(60, 20));
		JLabel comboText = new JLabel("Step:");
		JButton comboBoto = new JButton("Count");
		
		// Afegir elements al panel.
		panel.add(counterLabel);
		panel.add(counterText);
		
		panel.add(radio1);
		panel.add(radio2);
		
		panel.add(comboText);
		panel.add(comboBox);
		panel.add(comboBoto);
		
		// Configurar frame.
		frame.pack();
		frame.setSize(500,100);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	
}
