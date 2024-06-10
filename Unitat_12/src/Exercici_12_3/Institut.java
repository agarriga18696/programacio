package Exercici_12_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Institut extends JFrame {

	private static final long serialVersionUID = 1L;
	private ControladorBD controladorBD;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JTextField textField_dni_alumne;
	private JTextField textField_nom_alumne;
	private JTextField textField_edat_alumne;
	private JTextField textField_dni_professor;
	private JTextField textField_nom_professor;
	private JTextField textField_edat_professor;
	private final ButtonGroup buttonGroupAlumne = new ButtonGroup();
	private final ButtonGroup buttonGroupProfessor = new ButtonGroup();
	private JTable table_persones;
	private JTable table_alumnes;
	private JTable table_professors;

	public Institut(ControladorBD controladorBD) {
		this.controladorBD = controladorBD;

		crearFrame();

		panelAlumne();
		panelProfessor();
		panelVeurePersones();
		panelVeureAlumnes();
		panelVeureProfessors();

		configurarFinestra();
	}

	// Mètode per configurar la finestra.
	private void configurarFinestra() {
		setTitle("Institut");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(700, 500));
		setMinimumSize(new Dimension(700, 500));
		setLocationRelativeTo(null);
		pack();
	}

	// Crear el frame principal.
	private void crearFrame() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	// Mètode per netejar els camps després de crear una nova persona.
	private void netejarCamps() {
		textField_dni_alumne.setText("");
		textField_nom_alumne.setText("");
		textField_edat_alumne.setText("");
		buttonGroupAlumne.clearSelection();

		textField_dni_professor.setText("");
		textField_nom_professor.setText("");
		textField_edat_professor.setText("");
		buttonGroupProfessor.clearSelection();
	}

	// Panel de l'alumne.
	private void panelAlumne() {
		JPanel panel_alumne = new JPanel();
		tabbedPane.addTab("Crear Alumne", null, panel_alumne, null);
		panel_alumne.setLayout(new BorderLayout(0, 0));

		JPanel panel_alumne_contenidor = new JPanel();
		panel_alumne_contenidor.setBackground(Color.WHITE);
		panel_alumne_contenidor.setBorder(new EmptyBorder(10,10,10,10));
		panel_alumne.add(panel_alumne_contenidor, BorderLayout.CENTER);
		panel_alumne_contenidor.setLayout(new BorderLayout(0, 0));

		JPanel panel_alumne_dades = new JPanel();
		panel_alumne_dades.setBackground(Color.WHITE);
		panel_alumne_contenidor.add(panel_alumne_dades, BorderLayout.NORTH);
		panel_alumne_dades.setLayout(new GridLayout(4, 1, 0, 10));

		JLabel lbl_alumne = new JLabel("Nou Alumne");
		lbl_alumne.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_alumne_dades.add(lbl_alumne);

		textField_dni_alumne = new JTextField();
		textField_dni_alumne.setBorder(new TitledBorder(null, "DNI", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_alumne_dades.add(textField_dni_alumne);
		textField_dni_alumne.setColumns(10);

		textField_nom_alumne = new JTextField();
		textField_nom_alumne.setBorder(new TitledBorder(null, "Nom", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_alumne_dades.add(textField_nom_alumne);
		textField_nom_alumne.setColumns(10);

		textField_edat_alumne = new JTextField();
		textField_edat_alumne.setBorder(new TitledBorder(null, "Edat", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_alumne_dades.add(textField_edat_alumne);
		textField_edat_alumne.setColumns(10);

		JPanel panel_nivell = new JPanel();
		panel_nivell.setBackground(Color.WHITE);
		panel_nivell.setBorder(new TitledBorder(null, "Nivell", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_alumne_contenidor.add(panel_nivell, BorderLayout.CENTER);
		panel_nivell.setLayout(new BoxLayout(panel_nivell, BoxLayout.Y_AXIS));

		JRadioButton rdbtn_eso = new JRadioButton("ESO");
		rdbtn_eso.setBackground(Color.WHITE);
		buttonGroupAlumne.add(rdbtn_eso);
		panel_nivell.add(rdbtn_eso);

		JRadioButton rdbtn_batxiller = new JRadioButton("Batxiller");
		rdbtn_batxiller.setBackground(Color.WHITE);
		buttonGroupAlumne.add(rdbtn_batxiller);
		panel_nivell.add(rdbtn_batxiller);

		JRadioButton rdbtn_grauMitja = new JRadioButton("Grau Mitjà");
		rdbtn_grauMitja.setBackground(Color.WHITE);
		buttonGroupAlumne.add(rdbtn_grauMitja);
		panel_nivell.add(rdbtn_grauMitja);

		JRadioButton rdbtn_grauSuperior = new JRadioButton("Grau Superior");
		rdbtn_grauSuperior.setBackground(Color.WHITE);
		buttonGroupAlumne.add(rdbtn_grauSuperior);
		panel_nivell.add(rdbtn_grauSuperior);

		JButton btn_crearAlumne = new JButton("Crear");
		btn_crearAlumne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorBD.crearAlumne(
						textField_dni_alumne.getText(), 
						textField_nom_alumne.getText(),
						textField_edat_alumne.getText(),
						buttonGroupAlumne);

				netejarCamps();
			}
		});
		panel_alumne_contenidor.add(btn_crearAlumne, BorderLayout.SOUTH);
	}

	// Panel del professor.
	private void panelProfessor() {
		JPanel panel_professor = new JPanel();
		tabbedPane.addTab("Crear Professor", null, panel_professor, null);
		panel_professor.setLayout(new BorderLayout(0, 0));

		JPanel panel_professor_contenidor = new JPanel();
		panel_professor_contenidor.setBackground(Color.WHITE);
		panel_professor_contenidor.setBorder(new EmptyBorder(10,10,10,10));
		panel_professor.add(panel_professor_contenidor, BorderLayout.CENTER);
		panel_professor_contenidor.setLayout(new BorderLayout(0, 0));

		JPanel panel_professor_dades = new JPanel();
		panel_professor_dades.setBackground(Color.WHITE);
		panel_professor_contenidor.add(panel_professor_dades, BorderLayout.NORTH);
		panel_professor_dades.setLayout(new GridLayout(4, 1, 0, 10));

		JLabel lbl_professor = new JLabel("Nou Professor");
		lbl_professor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_professor_dades.add(lbl_professor);

		textField_dni_professor = new JTextField();
		textField_dni_professor.setBorder(new TitledBorder(null, "DNI", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_professor_dades.add(textField_dni_professor);
		textField_dni_professor.setColumns(10);

		textField_nom_professor = new JTextField();
		textField_nom_professor.setBorder(new TitledBorder(null, "Nom", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_professor_dades.add(textField_nom_professor);
		textField_nom_professor.setColumns(10);

		textField_edat_professor = new JTextField();
		textField_edat_professor.setBorder(new TitledBorder(null, "Edat", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_professor_dades.add(textField_edat_professor);
		textField_edat_professor.setColumns(10);

		JPanel panel_assignatura = new JPanel();
		panel_assignatura.setBackground(Color.WHITE);
		panel_assignatura.setBorder(new TitledBorder(null, "Assignatura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_professor_contenidor.add(panel_assignatura, BorderLayout.CENTER);
		panel_assignatura.setLayout(new BoxLayout(panel_assignatura, BoxLayout.Y_AXIS));

		JRadioButton rdbtn_programacio = new JRadioButton("Programació");
		rdbtn_programacio.setBackground(Color.WHITE);
		buttonGroupProfessor.add(rdbtn_programacio);
		panel_assignatura.add(rdbtn_programacio);

		JRadioButton rdbtn_bd = new JRadioButton("Bases de dades");
		rdbtn_bd.setBackground(Color.WHITE);
		buttonGroupProfessor.add(rdbtn_bd);
		panel_assignatura.add(rdbtn_bd);

		JRadioButton rdbtn_marques = new JRadioButton("Marques");
		rdbtn_marques.setBackground(Color.WHITE);
		buttonGroupProfessor.add(rdbtn_marques);
		panel_assignatura.add(rdbtn_marques);

		JRadioButton rdbtn_sistemes = new JRadioButton("Sistemes");
		rdbtn_sistemes.setBackground(Color.WHITE);
		buttonGroupProfessor.add(rdbtn_sistemes);
		panel_assignatura.add(rdbtn_sistemes);

		JButton btn_crearProfessor = new JButton("Crear");
		btn_crearProfessor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorBD.crearProfessor(
						textField_dni_professor.getText(), 
						textField_nom_professor.getText(),
						textField_edat_professor.getText(),
						buttonGroupProfessor);

				netejarCamps();
			}
		});
		panel_professor_contenidor.add(btn_crearProfessor, BorderLayout.SOUTH);
	}

	// Panel per veure totes les persones.
	private void panelVeurePersones() {
		JPanel panel_veurePersones = new JPanel();
		tabbedPane.addTab("Veure Persones", null, panel_veurePersones, null);
		panel_veurePersones.setLayout(new BorderLayout(0, 0));

		JPanel panel_veurePersones_contenidor = new JPanel();
		panel_veurePersones_contenidor.setBackground(Color.WHITE);
		panel_veurePersones_contenidor.setBorder(new EmptyBorder(10,10,10,10));
		panel_veurePersones.add(panel_veurePersones_contenidor, BorderLayout.CENTER);
		panel_veurePersones_contenidor.setLayout(new BorderLayout(0, 0));

		JPanel panel_veurePersones_dades = new JPanel();
		panel_veurePersones_dades.setBackground(Color.WHITE);
		panel_veurePersones_contenidor.add(panel_veurePersones_dades, BorderLayout.NORTH);
		panel_veurePersones_dades.setLayout(new GridLayout(2, 1, 0, 10));

		JLabel lbl_persones = new JLabel("Llistat de Persones");
		lbl_persones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_veurePersones_dades.add(lbl_persones);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Persones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_veurePersones_contenidor.add(scrollPane, BorderLayout.CENTER);

		// Crear la taula de persones.
		table_persones = crearTaula(
				new String[] {"DNI", "Nom", "Edat", "Tipus"}, 
				null
				);
		scrollPane.setViewportView(table_persones);

		JPanel panel_botons = new JPanel();
		panel_botons.setBackground(Color.WHITE);
		panel_botons.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_veurePersones_contenidor.add(panel_botons, BorderLayout.SOUTH);
		panel_botons.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton btn_actualitzar = new JButton("Actualitzar dades");
		btn_actualitzar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorBD.actualitzarTaulaPersones(table_persones);
			}
		});
		panel_botons.add(btn_actualitzar);
	}

	// Panel per veure tots els alumnes.
	private void panelVeureAlumnes() {
		JPanel panel_veureAlumnes = new JPanel();
		tabbedPane.addTab("Veure Alumnes", null, panel_veureAlumnes, null);
		panel_veureAlumnes.setLayout(new BorderLayout(0, 0));

		JPanel panel_veureAlumnes_contenidor = new JPanel();
		panel_veureAlumnes_contenidor.setBackground(Color.WHITE);
		panel_veureAlumnes_contenidor.setBorder(new EmptyBorder(10,10,10,10));
		panel_veureAlumnes.add(panel_veureAlumnes_contenidor, BorderLayout.CENTER);
		panel_veureAlumnes_contenidor.setLayout(new BorderLayout(0, 0));

		JPanel panel_veureAlumnes_dades = new JPanel();
		panel_veureAlumnes_dades.setBackground(Color.WHITE);
		panel_veureAlumnes_contenidor.add(panel_veureAlumnes_dades, BorderLayout.NORTH);
		panel_veureAlumnes_dades.setLayout(new GridLayout(2, 1, 0, 10));

		JLabel lbl_alumnes = new JLabel("Llistat d'Alumnes");
		lbl_alumnes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_veureAlumnes_dades.add(lbl_alumnes);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Alumnes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_veureAlumnes_contenidor.add(scrollPane, BorderLayout.CENTER);

		// Crear la taula de persones.
		table_alumnes = crearTaula(
				new String[] {"DNI", "Nom", "Edat", "Nivell"}, 
				null
				);
		scrollPane.setViewportView(table_alumnes);

		JPanel panel_botons = new JPanel();
		panel_botons.setBackground(Color.WHITE);
		panel_botons.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_veureAlumnes_contenidor.add(panel_botons, BorderLayout.SOUTH);
		panel_botons.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton btn_actualitzar = new JButton("Actualitzar dades");
		btn_actualitzar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorBD.actualitzarTaulaAlumnes(table_alumnes);
			}
		});
		panel_botons.add(btn_actualitzar);
	}

	// Panel per veure tots els professors.
	private void panelVeureProfessors() {
		JPanel panel_veureProfessors = new JPanel();
		tabbedPane.addTab("Veure Professors", null, panel_veureProfessors, null);
		panel_veureProfessors.setLayout(new BorderLayout(0, 0));

		JPanel panel_veureProfessors_contenidor = new JPanel();
		panel_veureProfessors_contenidor.setBackground(Color.WHITE);
		panel_veureProfessors_contenidor.setBorder(new EmptyBorder(10,10,10,10));
		panel_veureProfessors.add(panel_veureProfessors_contenidor, BorderLayout.CENTER);
		panel_veureProfessors_contenidor.setLayout(new BorderLayout(0, 0));

		JPanel panel_veureProfessors_dades = new JPanel();
		panel_veureProfessors_dades.setBackground(Color.WHITE);
		panel_veureProfessors_contenidor.add(panel_veureProfessors_dades, BorderLayout.NORTH);
		panel_veureProfessors_dades.setLayout(new GridLayout(2, 1, 0, 10));

		JLabel lbl_professors = new JLabel("Llistat de Professors");
		lbl_professors.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_veureProfessors_dades.add(lbl_professors);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Professors", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_veureProfessors_contenidor.add(scrollPane, BorderLayout.CENTER);

		// Crear la taula de persones.
		table_professors = crearTaula(
				new String[] {"DNI", "Nom", "Edat", "Assignatura"}, 
				null
				);
		scrollPane.setViewportView(table_professors);

		JPanel panel_botons = new JPanel();
		panel_botons.setBackground(Color.WHITE);
		panel_botons.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_veureProfessors_contenidor.add(panel_botons, BorderLayout.SOUTH);
		panel_botons.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton btn_actualitzar = new JButton("Actualitzar dades");
		btn_actualitzar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorBD.actualitzarTaulaProfessors(table_professors);
			}
		});
		panel_botons.add(btn_actualitzar);
	}

	// Mètode per crear una taula personalitzada.
	private JTable crearTaula(String[] columnNames, Object[][] data) {
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// Evitar que les cel·les siguin editables.
				return false;
			}
		};

		// Crear la taula.
		JTable taula = new JTable(model);

		// Crear un sorter per filtrar les dades de la taula.
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(taula.getModel());
		taula.setRowSorter(sorter);

		// Configurar l'aparença de la taula.
		taula.setFillsViewportHeight(true);
		taula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		taula.setShowGrid(true);
		taula.getTableHeader().setResizingAllowed(false);
		taula.getTableHeader().setReorderingAllowed(false);

		// Configurar renderitzadors per a les cel·les.
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < taula.getColumnCount(); i++) {
			taula.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		return taula;		
	}

}
