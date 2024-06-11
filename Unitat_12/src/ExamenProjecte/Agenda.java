package ExamenProjecte;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Agenda extends JFrame {

	private static final long serialVersionUID = 1L;

	private ControladorBD controladorBD;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelContactes;
	private JPanel panelCites;

	public Agenda(ControladorBD controladorBD) {
		this.controladorBD = controladorBD;

		crearFrame();

		panelContactes();
		panelCites();

		configurarFinestra();
	}

	// Crear el frame principal.
	private void crearFrame() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	// Mètode per configurar la finestra.
	private void configurarFinestra() {
		setTitle("Agenda Personal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setMinimumSize(new Dimension(800, 600));
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// Panel dels contactes.
	private void panelContactes() {
		panelContactes = new JPanel(new BorderLayout());

		JScrollPane scrollPane = new JScrollPane();
		panelContactes.add(scrollPane, BorderLayout.CENTER);

		// Crear la taula de contactes.
		JTable tableContactes = crearTaula(
				new String[] {"Id", "Nom", "Telèfon", "Email"},
				null
				);
		// No mostrar la columna Id.
		TableColumnModel columnModel = tableContactes.getColumnModel();
		TableColumn column = columnModel.getColumn(0);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
		column.setResizable(false);
		//tableContactes.removeColumn(tableContactes.getColumnModel().getColumn(0));
		scrollPane.setViewportView(tableContactes);

		JPanel panelBotonsContactes = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton btnAfegirContacte = new JButton("Afegir Contacte");
		JButton btnEliminarContacte = new JButton("Eliminar Contacte");
		JButton btnActualitzarContactes = new JButton("Actualitzar");
		panelBotonsContactes.add(btnAfegirContacte);
		panelBotonsContactes.add(btnEliminarContacte);
		panelBotonsContactes.add(btnActualitzarContactes);

		btnAfegirContacte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CrearContacteForm form = new CrearContacteForm(controladorBD, tableContactes);
			}
		});

		btnEliminarContacte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableContactes.getSelectedRow();

				if(selectedRow != -1) {
					int modelRow = tableContactes.convertRowIndexToModel(selectedRow);
					int id = (int) tableContactes.getModel().getValueAt(modelRow, 0);

					// Mostrar missatge de confirmació per eliminar el contacte.
					int opcio = Missatge.opcions(
							Agenda.this, 
							"Eliminar contacte", 
							"S'eliminarà el contacte seleccionat. Aquesta operació no es pot desfer, ¿vols continuar?", 
							JOptionPane.WARNING_MESSAGE);

					if(opcio == JOptionPane.YES_OPTION) {
						controladorBD.eliminarContacte(id);
						controladorBD.actualitzarTaulaContactes(tableContactes);
					}

				} else {
					Missatge.error(Agenda.this, "Selecciona un contacte per eliminar.");
				}
			}
		});

		btnActualitzarContactes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorBD.actualitzarTaulaContactes(tableContactes);
			}
		});

		panelContactes.add(panelBotonsContactes, BorderLayout.SOUTH);
		tabbedPane.addTab("Contactes", panelContactes);
	}

	// Panel de les cites.
	private void panelCites() {
		panelCites = new JPanel(new BorderLayout());

		JScrollPane scrollPane = new JScrollPane();
		panelCites.add(scrollPane, BorderLayout.CENTER);

		// Crear la taula de cites.
		JTable tableCites = crearTaula(
				new String[] {"Id", "Data", "Hora", "Descripció", "Contacte"},
				null
				);
		// No mostrar la columna Id.
		TableColumnModel columnModel = tableCites.getColumnModel();
		TableColumn column = columnModel.getColumn(0);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
		column.setResizable(false);
		//tableCites.removeColumn(tableCites.getColumnModel().getColumn(0));
		scrollPane.setViewportView(tableCites);

		JPanel panelBotonsCites = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton btnAfegirCita = new JButton("Afegir Cita");
		JButton btnEliminarCita = new JButton("Eliminar Cita");
		JButton btnActualitzarCites = new JButton("Actualitzar");
		panelBotonsCites.add(btnAfegirCita);
		panelBotonsCites.add(btnEliminarCita);
		panelBotonsCites.add(btnActualitzarCites);

		btnAfegirCita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> nomsContactes = controladorBD.obtenirNomsContactes();
				CrearCitaForm form = new CrearCitaForm(controladorBD, tableCites, nomsContactes);
			}
		});

		btnEliminarCita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableCites.getSelectedRow();

				if (selectedRow != -1) {
					int modelRow = tableCites.convertRowIndexToModel(selectedRow);
					int idCita = (int) tableCites.getValueAt(modelRow, 0);

					// Mostrar un missatge de confirmació abans de eliminar la cita
					int opcio = Missatge.opcions(
							Agenda.this,
							"Eliminar cita",
							"S'eliminarà la cita seleccionada. Aquesta operació no es pot desfer, vols continuar?",
							JOptionPane.WARNING_MESSAGE
							);

					if (opcio == JOptionPane.YES_OPTION) {
						controladorBD.eliminarCita(idCita);
						controladorBD.actualitzarTaulaCites(tableCites);
					}

				} else {
					Missatge.error(Agenda.this, "Selecciona una cita per eliminar.");
				}
			}
		});

		btnActualitzarCites.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorBD.actualitzarTaulaCites(tableCites);
			}
		});

		panelCites.add(panelBotonsCites, BorderLayout.SOUTH);
		tabbedPane.addTab("Cites", panelCites);
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
		taula.getTableHeader().setResizingAllowed(true);
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

