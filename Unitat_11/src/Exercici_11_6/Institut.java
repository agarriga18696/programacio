package Exercici_11_6;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Institut extends JFrame {

    private final String FONT = "Arial";

    public Institut() {
        super("Dades de l'Alumne i Professor");

        // Crear el frame principal
        JFrame frame = new JFrame("Dades de l'alumne i professor");
        frame.setLayout(new BorderLayout(10, 10));

        // Crear el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Crear la pestanya "Alumne"
        JPanel alumnePanel = new JPanel(new BorderLayout(10, 10));

        // Afegir la etiqueta de títol a la pestanya "Alumne"
        JLabel titleLabelAlumne = new JLabel("DADES DE L'ALUMNE", JLabel.CENTER);
        titleLabelAlumne.setFont(new Font(FONT, Font.BOLD, 24));
        alumnePanel.add(titleLabelAlumne, BorderLayout.NORTH);

        // Crear el panell central amb GridBagLayout per a la pestanya "Alumne"
        JPanel centerPanelAlumne = new JPanel(new GridBagLayout());
        GridBagConstraints gbcAlumne = new GridBagConstraints();
        gbcAlumne.insets = new Insets(5, 5, 5, 5);
        gbcAlumne.fill = GridBagConstraints.HORIZONTAL;

        // Afegir camp de DNI a la pestanya "Alumne"
        gbcAlumne.gridx = 0;
        gbcAlumne.gridy = 0;
        gbcAlumne.anchor = GridBagConstraints.EAST;
        JLabel dniLabel = new JLabel("DNI:");
        dniLabel.setFont(new Font(FONT, Font.BOLD, 16));
        centerPanelAlumne.add(dniLabel, gbcAlumne);

        gbcAlumne.gridx = 1;
        gbcAlumne.anchor = GridBagConstraints.WEST;
        JTextField dniField = new JTextField(15);
        centerPanelAlumne.add(dniField, gbcAlumne);

        // Afegir camp de NOM a la pestanya "Alumne"
        gbcAlumne.gridx = 0;
        gbcAlumne.gridy = 1;
        gbcAlumne.anchor = GridBagConstraints.EAST;
        JLabel nomLabel = new JLabel("NOM:");
        nomLabel.setFont(new Font(FONT, Font.BOLD, 16));
        centerPanelAlumne.add(nomLabel, gbcAlumne);

        gbcAlumne.gridx = 1;
        gbcAlumne.anchor = GridBagConstraints.WEST;
        JTextField nomField = new JTextField(15);
        centerPanelAlumne.add(nomField, gbcAlumne);

        // Afegir camp de EDAT a la pestanya "Alumne"
        gbcAlumne.gridx = 0;
        gbcAlumne.gridy = 2;
        gbcAlumne.anchor = GridBagConstraints.EAST;
        JLabel edatLabel = new JLabel("EDAT:");
        edatLabel.setFont(new Font(FONT, Font.BOLD, 16));
        centerPanelAlumne.add(edatLabel, gbcAlumne);

        gbcAlumne.gridx = 1;
        gbcAlumne.anchor = GridBagConstraints.WEST;
        JTextField edatField = new JTextField(15);
        centerPanelAlumne.add(edatField, gbcAlumne);

        // Afegir selecció de NIVELL a la pestanya "Alumne"
        gbcAlumne.gridx = 0;
        gbcAlumne.gridy = 3;
        gbcAlumne.anchor = GridBagConstraints.EAST;
        JLabel nivellLabel = new JLabel("NIVELL:");
        nivellLabel.setFont(new Font(FONT, Font.BOLD, 16));
        centerPanelAlumne.add(nivellLabel, gbcAlumne);

        JPanel nivellPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcNivell = new GridBagConstraints();
        gbcNivell.insets = new Insets(2, 2, 2, 2);
        gbcNivell.anchor = GridBagConstraints.WEST;
        ButtonGroup nivellGroup = new ButtonGroup();

        gbcNivell.gridy = 0;
        JRadioButton esoButton = new JRadioButton("ESO");
        esoButton.setFont(new Font(FONT, Font.BOLD, 16));
        nivellGroup.add(esoButton);
        nivellPanel.add(esoButton, gbcNivell);

        gbcNivell.gridy = 1;
        JRadioButton batxilleratButton = new JRadioButton("Batxillerat");
        batxilleratButton.setFont(new Font(FONT, Font.BOLD, 16));
        nivellGroup.add(batxilleratButton);
        nivellPanel.add(batxilleratButton, gbcNivell);

        gbcNivell.gridy = 2;
        JRadioButton grauMitjaButton = new JRadioButton("Grau mitjà");
        grauMitjaButton.setFont(new Font(FONT, Font.BOLD, 16));
        nivellGroup.add(grauMitjaButton);
        nivellPanel.add(grauMitjaButton, gbcNivell);

        gbcNivell.gridy = 3;
        JRadioButton grauSuperiorButton = new JRadioButton("Grau Superior");
        grauSuperiorButton.setFont(new Font(FONT, Font.BOLD, 16));
        nivellGroup.add(grauSuperiorButton);
        nivellPanel.add(grauSuperiorButton, gbcNivell);

        gbcAlumne.gridx = 1;
        gbcAlumne.gridy = 3;
        gbcAlumne.anchor = GridBagConstraints.WEST;
        centerPanelAlumne.add(nivellPanel, gbcAlumne);

        // Afegir el panell central al panell "Alumne"
        alumnePanel.add(centerPanelAlumne, BorderLayout.CENTER);

        // Afegir botó d'ACCEPTAR a la part inferior dreta de la pestanya "Alumne"
        JPanel buttonPanelAlumne = new JPanel(new BorderLayout());
        JButton acceptButtonAlumne = new JButton("ACCEPTAR");
        acceptButtonAlumne.setFont(new Font(FONT, Font.BOLD, 16));
        buttonPanelAlumne.add(acceptButtonAlumne, BorderLayout.EAST);
        alumnePanel.add(buttonPanelAlumne, BorderLayout.SOUTH);

        // Afegir la pestanya "Alumne" al JTabbedPane
        tabbedPane.addTab("Alumne", alumnePanel);

        // Crear la pestanya "Professor" (similar a la pestanya "Alumne")
        JPanel professorPanel = new JPanel(new BorderLayout(10, 10));

        // Afegir la etiqueta de títol a la pestanya "Professor"
        JLabel titleLabelProfessor = new JLabel("DADES DEL PROFESSOR", JLabel.CENTER);
        titleLabelProfessor.setFont(new Font(FONT, Font.BOLD, 24));
        professorPanel.add(titleLabelProfessor, BorderLayout.NORTH);

        // Crear el panell central amb GridBagLayout per a la pestanya "Professor"
        JPanel centerPanelProfessor = new JPanel(new GridBagLayout());
        GridBagConstraints gbcProfessor = new GridBagConstraints();
        gbcProfessor.insets = new Insets(5, 5, 5, 5);
        gbcProfessor.fill = GridBagConstraints.HORIZONTAL;

        // Afegir camp de DNI a la pestanya "Professor"
        gbcProfessor.gridx = 0;
        gbcProfessor.gridy = 0;
        gbcProfessor.anchor = GridBagConstraints.EAST;
        JLabel dniLabelProfessor = new JLabel("DNI:");
        dniLabelProfessor.setFont(new Font(FONT, Font.BOLD, 16));
        centerPanelProfessor.add(dniLabelProfessor, gbcProfessor);

        gbcProfessor.gridx = 1;
        gbcProfessor.anchor = GridBagConstraints.WEST;
        JTextField dniFieldProfessor = new JTextField(15);
        centerPanelProfessor.add(dniFieldProfessor, gbcProfessor);

        // Afegir camp de NOM a la pestanya "Professor"
        gbcProfessor.gridx = 0;
        gbcProfessor.gridy = 1;
        gbcProfessor.anchor = GridBagConstraints.EAST;
        JLabel nomLabelProfessor = new JLabel("NOM:");
        nomLabelProfessor.setFont(new Font(FONT, Font.BOLD, 16));
        centerPanelProfessor.add(nomLabelProfessor, gbcProfessor);

        gbcProfessor.gridx = 1;
        gbcProfessor.anchor = GridBagConstraints.WEST;
        JTextField nomFieldProfessor = new JTextField(15);
        centerPanelProfessor.add(nomFieldProfessor, gbcProfessor);

        // Afegir camp de EDAT a la pestanya "Professor"
        gbcProfessor.gridx = 0;
        gbcProfessor.gridy = 2;
        gbcProfessor.anchor = GridBagConstraints.EAST;
        JLabel edatLabelProfessor = new JLabel("EDAT:");
        edatLabelProfessor.setFont(new Font(FONT, Font.BOLD, 16));
        centerPanelProfessor.add(edatLabelProfessor, gbcProfessor);

        gbcProfessor.gridx = 1;
        gbcProfessor.anchor = GridBagConstraints.WEST;
        JTextField edatFieldProfessor = new JTextField(15);
        centerPanelProfessor.add(edatFieldProfessor, gbcProfessor);

        // Afegir camp de DEPARTAMENT a la pestanya "Professor"
        gbcProfessor.gridx = 0;
        gbcProfessor.gridy = 3;
        gbcProfessor.anchor = GridBagConstraints.EAST;
        JLabel deptLabel = new JLabel("ASSIGNATURA:");
        deptLabel.setFont(new Font(FONT, Font.BOLD, 16));
        centerPanelProfessor.add(deptLabel, gbcProfessor);

        gbcProfessor.gridx = 1;
        gbcProfessor.anchor = GridBagConstraints.WEST;
        JTextField deptField = new JTextField(15);
        centerPanelProfessor.add(deptField, gbcProfessor);

        // Afegir el panell central al panell "Professor"
        professorPanel.add(centerPanelProfessor, BorderLayout.CENTER);

        // Afegir botó d'ACCEPTAR a la part inferior dreta de la pestanya "Professor"
        JPanel buttonPanelProfessor = new JPanel(new BorderLayout());
        JButton acceptButtonProfessor = new JButton("ACCEPTAR");
        acceptButtonProfessor.setFont(new Font(FONT, Font.BOLD, 16));
        buttonPanelProfessor.add(acceptButtonProfessor, BorderLayout.EAST);
        professorPanel.add(buttonPanelProfessor, BorderLayout.SOUTH);

        // Afegir la pestanya "Professor" al JTabbedPane
        tabbedPane.addTab("Professor", professorPanel);
        
        tabbedPane.setFont(new Font(FONT, Font.BOLD, 16));

        // Afegir el JTabbedPane al frame principal
        frame.add(tabbedPane, BorderLayout.CENTER);

        // Configurar el frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Institut();
    }
}
