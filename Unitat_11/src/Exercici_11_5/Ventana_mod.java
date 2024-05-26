package Exercici_11_5;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana_mod extends JFrame {

	// Atributos.
	private static final long serialVersionUID = 1L;

	// Constructor Ventana.
	public Ventana_mod() {
		super("GridBagLayoutDemo");
		this.getContentPane().setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		
		JTextField campoTexto = new JTextField("Campo texto");
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.weightx = 2.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.getContentPane().add(campoTexto, constraints);

        JButton boton1 = new JButton("Boton 1");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.0;
        constraints.weighty = 0.0;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.getContentPane().add(boton1, constraints);

        JButton boton2 = new JButton("Boton 2");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 0.5;
        constraints.anchor = GridBagConstraints.CENTER;
        this.getContentPane().add(boton2, constraints);

        JButton boton3 = new JButton("Boton 3");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weighty = 0.0;
        constraints.anchor = GridBagConstraints.SOUTH;
        this.getContentPane().add(boton3, constraints);

        JButton boton4 = new JButton("Boton 4");
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.NORTHEAST;
        constraints.fill = GridBagConstraints.NONE;
        this.getContentPane().add(boton4, constraints);

        JTextArea cajaTexto = new JTextArea("Area texto");
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 3;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        this.getContentPane().add(cajaTexto, constraints);

		// Ajustes de la ventana
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// Método main.
	public static void main(String[] args) {

		new Ventana_mod();

	}

}
