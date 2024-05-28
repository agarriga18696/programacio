package Exercici_11_7;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Finestra extends JFrame {

	private static final long serialVersionUID = 1L;
	private int padding = 10;
	private int resolucio_X = 600;
	private int resolucio_Y = 500;

	// Atributs.
	protected JFrame frame;
	protected JTabbedPane pestanyes;
	protected ButtonGroup grup_botons_alumne;
	protected JMenuBar menu_barra;
	protected List<JPanel> panels = new ArrayList<>();
	protected List<JLabel> labels = new ArrayList<>();
	protected List<JTextField> fields = new ArrayList<>();
	protected List<JButton> botons = new ArrayList<>();
	protected List<JMenu> menu_menus = new ArrayList<>();
	protected List<JMenuItem> menu_items = new ArrayList<>();

	// Constructor.
	public Finestra() {
		super("Base de dades Institut");

		// FRAME.
		frame = new JFrame("Base de dades Institut");
		frame.setLayout(new BorderLayout(10, 10));

		// BARRA DE MENÚ.
		menu();

		// PESTANYES.
		pestanyes = new JTabbedPane();

		// Crear la pestanya "Alumne"
		JPanel panel_alumne = new JPanel(new BorderLayout(10, 10));
		panel_alumne.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));

		// Afegir la etiqueta de títol a la pestanya "Alumne"
		JLabel label_titol_alumne = new JLabel("DADES DE L'ALUMNE", JLabel.CENTER);
		label_titol_alumne.setFont(new Font(IU.FONT, Font.BOLD, IU.MIDA_TEXT_TITOL));
		panel_alumne.add(label_titol_alumne, BorderLayout.NORTH);

		// Crear el panell central amb GridBagLayout per a la pestanya "Alumne"
		JPanel panel_alumne_central = new JPanel(new GridBagLayout());
		GridBagConstraints gbcAlumne = new GridBagConstraints();
		gbcAlumne.insets = new Insets(padding, padding, padding, padding);
		gbcAlumne.fill = GridBagConstraints.HORIZONTAL;

		// Afegir camp de DNI a la pestanya "Alumne"
		gbcAlumne.gridx = 0;
		gbcAlumne.gridy = 0;
		gbcAlumne.anchor = GridBagConstraints.EAST;
		JLabel label_alumne_dni = new JLabel("DNI");
		label_alumne_dni.setFont(new Font(IU.FONT, Font.BOLD, IU.MIDA_TEXT_NORMAL));
		panel_alumne_central.add(label_alumne_dni, gbcAlumne);

		gbcAlumne.gridx = 1;
		gbcAlumne.anchor = GridBagConstraints.WEST;
		JTextField field_alumne_dni = new JTextField(15);
		panel_alumne_central.add(field_alumne_dni, gbcAlumne);

		// Afegir camp de NOM a la pestanya "Alumne"
		gbcAlumne.gridx = 0;
		gbcAlumne.gridy = 1;
		gbcAlumne.anchor = GridBagConstraints.EAST;
		JLabel label_alumne_nom = new JLabel("NOM");
		label_alumne_nom.setFont(new Font(IU.FONT, Font.BOLD, IU.MIDA_TEXT_NORMAL));
		panel_alumne_central.add(label_alumne_nom, gbcAlumne);

		gbcAlumne.gridx = 1;
		gbcAlumne.anchor = GridBagConstraints.WEST;
		JTextField field_alumne_nom = new JTextField(15);
		panel_alumne_central.add(field_alumne_nom, gbcAlumne);

		// Afegir camp de EDAT a la pestanya "Alumne"
		gbcAlumne.gridx = 0;
		gbcAlumne.gridy = 2;
		gbcAlumne.anchor = GridBagConstraints.EAST;
		JLabel label_alumne_edat = new JLabel("EDAT");
		label_alumne_edat.setFont(new Font(IU.FONT, Font.BOLD, IU.MIDA_TEXT_NORMAL));
		panel_alumne_central.add(label_alumne_edat, gbcAlumne);

		gbcAlumne.gridx = 1;
		gbcAlumne.anchor = GridBagConstraints.WEST;
		JTextField field_alumne_edat = new JTextField(15);
		panel_alumne_central.add(field_alumne_edat, gbcAlumne);

		// Afegir selecció de NIVELL a la pestanya "Alumne"
		gbcAlumne.gridx = 0;
		gbcAlumne.gridy = 3;
		gbcAlumne.anchor = GridBagConstraints.EAST;
		JLabel label_alumne_nivell = new JLabel("NIVELL");
		label_alumne_nivell.setFont(new Font(IU.FONT, Font.BOLD, IU.MIDA_TEXT_NORMAL));
		panel_alumne_central.add(label_alumne_nivell, gbcAlumne);

		JPanel panel_alumne_nivell = new JPanel(new GridBagLayout());
		GridBagConstraints gbcNivell = new GridBagConstraints();
		gbcNivell.insets = new Insets(2, 2, 2, 2);
		gbcNivell.anchor = GridBagConstraints.WEST;

		grup_botons_alumne = new ButtonGroup();

		gbcNivell.gridy = 0;
		JRadioButton button_eso = new JRadioButton("ESO");
		button_eso.setFont(new Font(IU.FONT, Font.PLAIN, IU.MIDA_TEXT_NORMAL));
		grup_botons_alumne.add(button_eso);
		panel_alumne_nivell.add(button_eso, gbcNivell);

		gbcNivell.gridy = 1;
		JRadioButton button_batxillerat = new JRadioButton("Batxillerat");
		button_batxillerat.setFont(new Font(IU.FONT, Font.PLAIN, IU.MIDA_TEXT_NORMAL));
		grup_botons_alumne.add(button_batxillerat);
		panel_alumne_nivell.add(button_batxillerat, gbcNivell);

		gbcNivell.gridy = 2;
		JRadioButton button_graumitja = new JRadioButton("Grau mitjà");
		button_graumitja.setFont(new Font(IU.FONT, Font.PLAIN, IU.MIDA_TEXT_NORMAL));
		grup_botons_alumne.add(button_graumitja);
		panel_alumne_nivell.add(button_graumitja, gbcNivell);

		gbcNivell.gridy = 3;
		JRadioButton button_grausuperior = new JRadioButton("Grau Superior");
		button_grausuperior.setFont(new Font(IU.FONT, Font.PLAIN, IU.MIDA_TEXT_NORMAL));
		grup_botons_alumne.add(button_grausuperior);
		panel_alumne_nivell.add(button_grausuperior, gbcNivell);

		gbcAlumne.gridx = 1;
		gbcAlumne.gridy = 3;
		gbcAlumne.anchor = GridBagConstraints.WEST;
		panel_alumne_central.add(panel_alumne_nivell, gbcAlumne);

		// Afegir el panell central al panell "Alumne"
		panel_alumne.add(panel_alumne_central, BorderLayout.CENTER);

		// Afegir botó d'ACCEPTAR a la part inferior dreta de la pestanya "Alumne"
		JPanel panel_alumne_botons = new JPanel(new BorderLayout());
		JButton button_alumne_acceptar = new JButton("ACCEPTAR");
		button_alumne_acceptar.setFont(new Font(IU.FONT, Font.BOLD, IU.MIDA_TEXT_NORMAL));
		panel_alumne_botons.add(button_alumne_acceptar, BorderLayout.SOUTH);
		panel_alumne.add(panel_alumne_botons, BorderLayout.SOUTH);

		// Afegir la pestanya "Alumne" al JTabbedPane
		pestanyes.addTab("Alumne", panel_alumne);


		// Crear la pestanya "Professor" (similar a la pestanya "Alumne")
		JPanel panel_professor = new JPanel(new BorderLayout(10, 10));
		panel_professor.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));

		// Afegir la etiqueta de títol a la pestanya "Professor"
		JLabel label_titol_professor = new JLabel("DADES DEL PROFESSOR", JLabel.CENTER);
		label_titol_professor.setFont(new Font(IU.FONT, Font.BOLD, IU.MIDA_TEXT_TITOL));
		panel_professor.add(label_titol_professor, BorderLayout.NORTH);

		// Crear el panell central amb GridBagLayout per a la pestanya "Professor"
		JPanel panel_professor_central = new JPanel(new GridBagLayout());
		GridBagConstraints gbcProfessor = new GridBagConstraints();
		gbcProfessor.insets = new Insets(padding, padding, padding, padding);
		gbcProfessor.fill = GridBagConstraints.HORIZONTAL;

		// Afegir camp de DNI a la pestanya "Professor"
		gbcProfessor.gridx = 0;
		gbcProfessor.gridy = 0;
		gbcProfessor.anchor = GridBagConstraints.EAST;
		JLabel label_professor_dni = new JLabel("DNI");
		label_professor_dni.setFont(new Font(IU.FONT, Font.BOLD, IU.MIDA_TEXT_NORMAL));
		panel_professor_central.add(label_professor_dni, gbcProfessor);

		gbcProfessor.gridx = 1;
		gbcProfessor.anchor = GridBagConstraints.WEST;
		JTextField field_professor_dni = new JTextField(15);
		panel_professor_central.add(field_professor_dni, gbcProfessor);

		// Afegir camp de NOM a la pestanya "Professor"
		gbcProfessor.gridx = 0;
		gbcProfessor.gridy = 1;
		gbcProfessor.anchor = GridBagConstraints.EAST;
		JLabel label_professor_nom = new JLabel("NOM");
		label_professor_nom.setFont(new Font(IU.FONT, Font.BOLD, IU.MIDA_TEXT_NORMAL));
		panel_professor_central.add(label_professor_nom, gbcProfessor);

		gbcProfessor.gridx = 1;
		gbcProfessor.anchor = GridBagConstraints.WEST;
		JTextField field_professor_nom = new JTextField(15);
		panel_professor_central.add(field_professor_nom, gbcProfessor);

		// Afegir camp de EDAT a la pestanya "Professor"
		gbcProfessor.gridx = 0;
		gbcProfessor.gridy = 2;
		gbcProfessor.anchor = GridBagConstraints.EAST;
		JLabel label_professor_edat = new JLabel("EDAT");
		label_professor_edat.setFont(new Font(IU.FONT, Font.BOLD, IU.MIDA_TEXT_NORMAL));
		panel_professor_central.add(label_professor_edat, gbcProfessor);

		gbcProfessor.gridx = 1;
		gbcProfessor.anchor = GridBagConstraints.WEST;
		JTextField field_professor_edat = new JTextField(15);
		panel_professor_central.add(field_professor_edat, gbcProfessor);

		// Afegir camp de DEPARTAMENT a la pestanya "Professor"
		gbcProfessor.gridx = 0;
		gbcProfessor.gridy = 3;
		gbcProfessor.anchor = GridBagConstraints.EAST;
		JLabel label_professor_assignatura = new JLabel("ASSIGNATURA");
		label_professor_assignatura.setFont(new Font(IU.FONT, Font.BOLD, IU.MIDA_TEXT_NORMAL));
		panel_professor_central.add(label_professor_assignatura, gbcProfessor);

		gbcProfessor.gridx = 1;
		gbcProfessor.anchor = GridBagConstraints.WEST;
		JTextField field_professor_assignatura = new JTextField(15);
		panel_professor_central.add(field_professor_assignatura, gbcProfessor);

		// Afegir el panell central al panell "Professor"
		panel_professor.add(panel_professor_central, BorderLayout.CENTER);

		// Afegir botó d'ACCEPTAR a la part inferior dreta de la pestanya "Professor"
		JPanel panel_professor_botons = new JPanel(new BorderLayout());
		JButton button_professor_acceptar = new JButton("ACCEPTAR");
		button_professor_acceptar.setFont(new Font(IU.FONT, Font.BOLD, IU.MIDA_TEXT_NORMAL));
		panel_professor_botons.add(button_professor_acceptar, BorderLayout.SOUTH);
		panel_professor.add(panel_professor_botons, BorderLayout.SOUTH);

		// Afegir la pestanya "Professor" al JTabbedPane
		pestanyes.addTab("Professor", panel_professor);

		pestanyes.setFont(new Font(IU.FONT, Font.PLAIN, IU.MIDA_TEXT_NORMAL));

		// Afegir el JTabbedPane al frame principal
		frame.add(pestanyes, BorderLayout.CENTER);

		// Afegir elements a les llistes globals.
		panels.add(panel_alumne);
		panels.add(panel_alumne_central);
		panels.add(panel_alumne_botons);
		panels.add(panel_alumne_nivell);
		panels.add(panel_professor);
		panels.add(panel_professor_central);
		panels.add(panel_professor_botons);

		labels.add(label_titol_alumne);
		labels.add(label_alumne_dni);
		labels.add(label_alumne_nom);
		labels.add(label_alumne_edat);
		labels.add(label_alumne_nivell);
		labels.add(label_titol_professor);
		labels.add(label_professor_dni);
		labels.add(label_professor_nom);
		labels.add(label_professor_edat);
		labels.add(label_professor_assignatura);

		fields.add(field_alumne_dni);
		fields.add(field_alumne_nom);
		fields.add(field_alumne_edat);
		fields.add(field_professor_dni);
		fields.add(field_professor_nom);
		fields.add(field_professor_edat);
		fields.add(field_professor_assignatura);

		botons.add(button_alumne_acceptar);
		botons.add(button_professor_acceptar);

		// ESTIL I COLOR
		IU.actualitzarColors(this);

		// CONFIGURAR EL FRAME
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(resolucio_X, resolucio_Y);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// Mètode per crear la barra de menú.
	private void menu() {
		menu_barra = new JMenuBar();
		JMenu menu = new JMenu("Menú");
		menu.setFont(new Font(IU.FONT, Font.PLAIN, IU.MIDA_TEXT_NORMAL));

		JMenu submenu_tema = new JMenu("Color del tema");
		submenu_tema.setFont(new Font(IU.FONT, Font.PLAIN, IU.MIDA_TEXT_NORMAL));
		List<JMenuItem> submenu_tema_elements = crearElementsMenu("Tema Fosc", "Tema Clar");
		submenu_tema = afegirElementsMenu(submenu_tema, submenu_tema_elements);

		menu.add(submenu_tema);
		menu.addSeparator();

		JMenuItem item_versio = new JMenuItem("Versió");
		item_versio.setFont(new Font(IU.FONT, Font.PLAIN, IU.MIDA_TEXT_NORMAL));
		menu.add(item_versio);

		menu_barra.add(menu);
		frame.setJMenuBar(menu_barra);

		// Afegir elements a les llistes.
		menu_menus.add(menu);
		menu_menus.add(submenu_tema);

		for(JMenuItem menuItem : submenu_tema_elements) {
			menu_items.add(menuItem);
		}
		menu_items.add(item_versio);
	}

	// Mètode per crear elements del menú.
	private List<JMenuItem> crearElementsMenu(String... elements) {
		List<JMenuItem> llista_elements = new ArrayList<>();

		for (int i = 0; i < elements.length; i++) {
			JMenuItem element = new JMenuItem(elements[i]);
			element.setFont(new Font(IU.FONT, Font.PLAIN, IU.MIDA_TEXT_NORMAL));
			element.setBackground(IU.colorFons);
			element.setForeground(IU.colorText);

			// Afegir un action listener a cada botó per poder canviar el tema.
			element.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (element.getText().equalsIgnoreCase("Tema Fosc")) {
						IU.colorFons = IU.COLOR_FONS_FOSC;
						IU.colorBoto = IU.COLOR_BOTO_FOSC;
						IU.colorEnfasis = IU.COLOR_ENFASIS_FOSC;
						IU.colorText = IU.COLOR_TEXT_FOSC;

					} else { // Tema Clar
						IU.colorFons = IU.COLOR_FONS_CLAR;
						IU.colorBoto = IU.COLOR_BOTO_CLAR;
						IU.colorEnfasis = IU.COLOR_ENFASIS_CLAR;
						IU.colorText = IU.COLOR_TEXT_CLAR;
					}
					IU.actualitzarColors(Finestra.this);
				}
			});

			llista_elements.add(element);
		}

		return llista_elements;
	}

	// Mètode per afegir els elements al menú.
	private static JMenu afegirElementsMenu(JMenu menu, List<JMenuItem> elements) {
		for (JMenuItem element : elements) {
			menu.add(element);
		}

		return menu;
	}

}
