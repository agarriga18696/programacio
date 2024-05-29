package exercici_11_9.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import exercici_11_9.controlador.Controlador;
import exercici_11_9.model.Persona;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class Finestra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_alumne_nom;
	private JTextField textField_alumne_dni;
	private JTextField textField_alumne_edat;
	private final ButtonGroup buttonGroup_alumne = new ButtonGroup();
	private JTextField textField_professor_nom;
	private JTextField textField_professor_dni;
	private JTextField textField_professor_edat;
	private JTextField textField_professor_assignatura;
	private Controlador controlador = new Controlador();

	public Finestra() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mn_arxiu = new JMenu("Arxiu");
		menuBar.add(mn_arxiu);

		JMenu mn_nou = new JMenu("Nou");
		mn_arxiu.add(mn_nou);

		JMenuItem mntmAlumne = new JMenuItem("Alumne");
		mn_nou.add(mntmAlumne);
		mntmAlumne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "panelAlumne");
			}
		});

		JMenuItem mntmProfessor = new JMenuItem("Professor");
		mn_nou.add(mntmProfessor);
		mntmProfessor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "panelProfessor");
			}
		});

		mn_arxiu.addSeparator();

		JMenuItem mntm_obrirFitxer = new JMenuItem("Obrir Fitxer");
		mn_arxiu.add(mntm_obrirFitxer);
		mntm_obrirFitxer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);

				if(returnValue == JFileChooser.APPROVE_OPTION) {
					try {
						controlador.carregarDades(fileChooser.getSelectedFile().getPath());
						Msg.exit("Dades carregades correctament.");

					} catch (ClassNotFoundException | IOException ex) {
						Msg.error("Error al carregar dades: " + ex.getMessage());
					}
				}
			}
		});

		JMenuItem mntm_guardarFitxer = new JMenuItem("Guardar Fitxer");
		mn_arxiu.add(mntm_guardarFitxer);
		mntm_guardarFitxer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showSaveDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					try {
						controlador.guardarDades(fileChooser.getSelectedFile().getPath());
						Msg.exit("Dades guardades correctament.");

					} catch (IOException ex) {
						Msg.error("Error al guardar dades: " + ex.getMessage());
					}
				}
			}
		});

		mn_arxiu.addSeparator();

		JMenuItem mntm_tancar = new JMenuItem("Tancar");
		mn_arxiu.add(mntm_tancar);
		mntm_tancar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "panelPrincipal");
			}
		});

		JMenu mn_dades = new JMenu("Dades");
		menuBar.add(mn_dades);

		JMenuItem mntm_mostrarLlistat = new JMenuItem("Mostrar Llistat");
		mn_dades.add(mntm_mostrarLlistat);
		mntm_mostrarLlistat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mostrarLlistat("Llistat de Persones", controlador.getPersones());

				} catch(NullPointerException ex) {
					Msg.advertencia("No s'ha registrat cap persona.");
				}

			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel_principal = new JPanel();
		contentPane.add(panel_principal, "panelPrincipal");
		GroupLayout gl_panel_principal = new GroupLayout(panel_principal);
		gl_panel_principal.setHorizontalGroup(
				gl_panel_principal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 580, Short.MAX_VALUE)
				);
		gl_panel_principal.setVerticalGroup(
				gl_panel_principal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 337, Short.MAX_VALUE)
				);
		panel_principal.setLayout(gl_panel_principal);

		JPanel panel_alumne = new JPanel();
		contentPane.add(panel_alumne, "panelAlumne");
		panel_alumne.setLayout(new BorderLayout(0, 0));

		JPanel panel_alumne_superior = new JPanel();
		panel_alumne.add(panel_alumne_superior, BorderLayout.NORTH);

		JLabel lblNouAlumne = new JLabel("NOU ALUMNE");
		panel_alumne_superior.add(lblNouAlumne);

		JPanel panel_alumne_central = new JPanel();
		panel_alumne.add(panel_alumne_central, BorderLayout.CENTER);
		GridBagLayout gbl_panel_alumne_central = new GridBagLayout();
		gbl_panel_alumne_central.columnWidths = new int[]{580, 0};
		gbl_panel_alumne_central.rowHeights = new int[]{42, 0, 0, 0, 0};
		gbl_panel_alumne_central.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_alumne_central.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_alumne_central.setLayout(gbl_panel_alumne_central);

		textField_alumne_nom = new JTextField();
		textField_alumne_nom.setColumns(20);
		textField_alumne_nom.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Nom", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textField_alumne_nom = new GridBagConstraints();
		gbc_textField_alumne_nom.insets = new Insets(0, 0, 5, 0);
		gbc_textField_alumne_nom.anchor = GridBagConstraints.NORTH;
		gbc_textField_alumne_nom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_alumne_nom.gridx = 0;
		gbc_textField_alumne_nom.gridy = 0;
		panel_alumne_central.add(textField_alumne_nom, gbc_textField_alumne_nom);

		textField_alumne_dni = new JTextField();
		textField_alumne_dni.setColumns(20);
		textField_alumne_dni.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "DNI", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textField_alumne_dni = new GridBagConstraints();
		gbc_textField_alumne_dni.insets = new Insets(0, 0, 5, 0);
		gbc_textField_alumne_dni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_alumne_dni.gridx = 0;
		gbc_textField_alumne_dni.gridy = 1;
		panel_alumne_central.add(textField_alumne_dni, gbc_textField_alumne_dni);

		textField_alumne_edat = new JTextField();
		textField_alumne_edat.setColumns(20);
		textField_alumne_edat.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Edat", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textField_alumne_edat = new GridBagConstraints();
		gbc_textField_alumne_edat.insets = new Insets(0, 0, 5, 0);
		gbc_textField_alumne_edat.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_alumne_edat.gridx = 0;
		gbc_textField_alumne_edat.gridy = 2;
		panel_alumne_central.add(textField_alumne_edat, gbc_textField_alumne_edat);

		JPanel panel_alumne_nivell = new JPanel();
		GridBagConstraints gbc_panel_alumne_nivell = new GridBagConstraints();
		gbc_panel_alumne_nivell.fill = GridBagConstraints.BOTH;
		gbc_panel_alumne_nivell.gridx = 0;
		gbc_panel_alumne_nivell.gridy = 3;
		panel_alumne_central.add(panel_alumne_nivell, gbc_panel_alumne_nivell);
		GridBagLayout gbl_panel_alumne_nivell = new GridBagLayout();
		gbl_panel_alumne_nivell.columnWidths = new int[]{36, 49, 76, 0};
		gbl_panel_alumne_nivell.rowHeights = new int[]{25, 0, 0, 0, 0};
		gbl_panel_alumne_nivell.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_alumne_nivell.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_alumne_nivell.setLayout(gbl_panel_alumne_nivell);

		JLabel lblNewLabel = new JLabel("Nivell");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_alumne_nivell.add(lblNewLabel, gbc_lblNewLabel);

		JRadioButton rdbtn_eso = new JRadioButton("ESO");
		buttonGroup_alumne.add(rdbtn_eso);
		GridBagConstraints gbc_rdbtn_eso = new GridBagConstraints();
		gbc_rdbtn_eso.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtn_eso.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn_eso.gridx = 1;
		gbc_rdbtn_eso.gridy = 0;
		panel_alumne_nivell.add(rdbtn_eso, gbc_rdbtn_eso);

		JRadioButton rdbtn_batxiller = new JRadioButton("Batxiller");
		buttonGroup_alumne.add(rdbtn_batxiller);
		GridBagConstraints gbc_rdbtn_batxiller = new GridBagConstraints();
		gbc_rdbtn_batxiller.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn_batxiller.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtn_batxiller.gridx = 1;
		gbc_rdbtn_batxiller.gridy = 1;
		panel_alumne_nivell.add(rdbtn_batxiller, gbc_rdbtn_batxiller);

		JRadioButton rdbtn_graumitja = new JRadioButton("Grau Mitjà");
		buttonGroup_alumne.add(rdbtn_graumitja);
		GridBagConstraints gbc_rdbtn_graumitja = new GridBagConstraints();
		gbc_rdbtn_graumitja.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtn_graumitja.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtn_graumitja.gridx = 1;
		gbc_rdbtn_graumitja.gridy = 2;
		panel_alumne_nivell.add(rdbtn_graumitja, gbc_rdbtn_graumitja);

		JRadioButton rdbtn_grausuperior = new JRadioButton("Grau Superior");
		buttonGroup_alumne.add(rdbtn_grausuperior);
		GridBagConstraints gbc_rdbtn_grausuperior = new GridBagConstraints();
		gbc_rdbtn_grausuperior.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtn_grausuperior.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtn_grausuperior.gridx = 1;
		gbc_rdbtn_grausuperior.gridy = 3;
		panel_alumne_nivell.add(rdbtn_grausuperior, gbc_rdbtn_grausuperior);

		JPanel panel_alumne_inferior = new JPanel();
		FlowLayout flowLayout_alumne = (FlowLayout) panel_alumne_inferior.getLayout();
		flowLayout_alumne.setAlignment(FlowLayout.RIGHT);
		panel_alumne.add(panel_alumne_inferior, BorderLayout.SOUTH);

		JButton btn_alumne_crear = new JButton("Crear");
		panel_alumne_inferior.add(btn_alumne_crear);
		btn_alumne_crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crearAlumne();
			}
		});

		JPanel panel_professor = new JPanel();
		contentPane.add(panel_professor, "panelProfessor");
		panel_professor.setLayout(new BorderLayout(0, 0));

		JPanel panel_professor_superior = new JPanel();
		panel_professor.add(panel_professor_superior, BorderLayout.NORTH);

		JLabel lblNouProfessor = new JLabel("NOU PROFESSOR");
		panel_professor_superior.add(lblNouProfessor);

		JPanel panel_professor_central = new JPanel();
		panel_professor.add(panel_professor_central, BorderLayout.CENTER);
		GridBagLayout gbl_panel_professor_central = new GridBagLayout();
		gbl_panel_professor_central.columnWidths = new int[]{580, 0};
		gbl_panel_professor_central.rowHeights = new int[]{42, 0, 0, 0, 0};
		gbl_panel_professor_central.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_professor_central.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_professor_central.setLayout(gbl_panel_professor_central);

		textField_professor_nom = new JTextField();
		textField_professor_nom.setColumns(20);
		textField_professor_nom.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Nom", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textField_professor_nom = new GridBagConstraints();
		gbc_textField_professor_nom.insets = new Insets(0, 0, 5, 0);
		gbc_textField_professor_nom.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_professor_nom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_professor_nom.gridx = 0;
		gbc_textField_professor_nom.gridy = 0;
		panel_professor_central.add(textField_professor_nom, gbc_textField_professor_nom);

		textField_professor_dni = new JTextField();
		textField_professor_dni.setColumns(20);
		textField_professor_dni.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "DNI", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textField_professor_dni = new GridBagConstraints();
		gbc_textField_professor_dni.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_professor_dni.insets = new Insets(0, 0, 5, 0);
		gbc_textField_professor_dni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_professor_dni.gridx = 0;
		gbc_textField_professor_dni.gridy = 1;
		panel_professor_central.add(textField_professor_dni, gbc_textField_professor_dni);

		textField_professor_edat = new JTextField();
		textField_professor_edat.setColumns(20);
		textField_professor_edat.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Edat", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textField_professor_edat = new GridBagConstraints();
		gbc_textField_professor_edat.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_professor_edat.insets = new Insets(0, 0, 5, 0);
		gbc_textField_professor_edat.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_professor_edat.gridx = 0;
		gbc_textField_professor_edat.gridy = 2;
		panel_professor_central.add(textField_professor_edat, gbc_textField_professor_edat);

		textField_professor_assignatura = new JTextField();
		textField_professor_assignatura.setColumns(20);
		textField_professor_assignatura.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Assignatura", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_textField_professor_assignatura = new GridBagConstraints();
		gbc_textField_professor_assignatura.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_professor_assignatura.insets = new Insets(0, 0, 5, 0);
		gbc_textField_professor_assignatura.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_professor_assignatura.gridx = 0;
		gbc_textField_professor_assignatura.gridy = 3;
		panel_professor_central.add(textField_professor_assignatura, gbc_textField_professor_assignatura);

		JPanel panel_professor_inferior = new JPanel();
		FlowLayout flowLayout_professor = (FlowLayout) panel_professor_inferior.getLayout();
		flowLayout_professor.setAlignment(FlowLayout.RIGHT);
		panel_professor.add(panel_professor_inferior, BorderLayout.SOUTH);

		JButton btn_professor_crear = new JButton("Crear");
		panel_professor_inferior.add(btn_professor_crear);
		panel_professor_inferior.add(btn_professor_crear);
		btn_professor_crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crearProfessor();
			}
		});

		setTitle("Base de Dades Institut");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 600, 400);
		pack();
		setMinimumSize(new Dimension(600, 400));
		setLocationRelativeTo(null); 
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	private void crearAlumne() {
		String nom = textField_alumne_nom.getText();
		String dni = textField_alumne_dni.getText();
		String edatText = textField_alumne_edat.getText();
		String nivell = getSelectedButtonText(buttonGroup_alumne);

		StringBuilder campsBuits = new StringBuilder();

		if (nom.isEmpty()) {
			campsBuits.append("\n- Nom");
		}
		if (dni.isEmpty()) {
			campsBuits.append("\n- DNI");
		}
		if (edatText.isEmpty()) {
			campsBuits.append("\n- Edat");
		}
		if (nivell == null) {
			campsBuits.append("\n- Nivell");
		}

		if (campsBuits.length() > 0) {
			Msg.error("Falten els següents camps: " + campsBuits.toString());
			return;
		}

		try {
			int edat = Integer.parseInt(edatText);
			if (controlador != null) {
				controlador.crearAlumne(nom, dni, edat, nivell);
				Msg.exit("Alumne creat correctament.");
				restaurarCampsAlumne();
			}
		} catch (NumberFormatException e) {
			Msg.error("Format d'edat incorrecte.");
		}
	}

	private void crearProfessor() {
		String nom = textField_professor_nom.getText();
		String dni = textField_professor_dni.getText();
		String edatText = textField_professor_edat.getText();
		String assignatura = textField_professor_assignatura.getText();

		StringBuilder campsBuits = new StringBuilder();

		if (nom.isEmpty()) {
			campsBuits.append("\n- Nom");
		}
		if (dni.isEmpty()) {
			campsBuits.append("\n- DNI");
		}
		if (edatText.isEmpty()) {
			campsBuits.append("\n- Edat");
		}
		if (assignatura.isEmpty()) {
			campsBuits.append("\n- Assignatura");
		}

		if (campsBuits.length() > 0) {
			Msg.error("Falten els següents camps: " + campsBuits.toString());
			return;
		}

		try {
			int edat = Integer.parseInt(edatText);
			if (controlador != null) {
				controlador.crearProfessor(nom, dni, edat, assignatura);
				Msg.exit("Professor creat correctament.");
				restaurarCampsProfessor();
			}
		} catch (NumberFormatException e) {
			Msg.error("Format d'edat incorrecte.");
		}
	}

	private void restaurarCampsAlumne() {
		textField_alumne_nom.setText("");
		textField_alumne_dni.setText("");
		textField_alumne_edat.setText("");
		buttonGroup_alumne.clearSelection();
	}

	private void restaurarCampsProfessor() {
		textField_professor_nom.setText("");
		textField_professor_dni.setText("");
		textField_professor_edat.setText("");
		textField_professor_assignatura.setText("");
	}

	private void mostrarLlistat(String titol, List<Persona> persones) {
		StringBuilder sb = new StringBuilder();

		for (Persona persona : persones) {
			sb.append(persona.toString()).append("\n");
		}

		Msg.simple(titol, sb.toString());
	}

	private String getSelectedButtonText(ButtonGroup buttonGroup_alumne) {
		for (AbstractButton button : Collections.list(buttonGroup_alumne.getElements())) {
			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}
}
