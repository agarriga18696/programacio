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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Agenda extends JFrame {

	private static final long serialVersionUID = 1L;

	private ControladorBD controladorBD;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelContactes;
	private JPanel panelCites;
	private JLabel lblData;
	private JLabel lblHora;
	private JTable tableContactes;
	private JTable tableCites;
	private VerificarCita verificarCita;

	public Agenda(ControladorBD controladorBD) {
		this.controladorBD = controladorBD;

		crearFrame();
		panelSuperior();
		panelContactes();
		panelCites();
		configurarFinestra();

		actualitzarDadesTaules();
		
		inicialitzarRellotge();
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

	// Panel superior.
	private void panelSuperior() {
		JPanel panelSuperior = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSuperior.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panelSuperior, BorderLayout.NORTH);

		JPanel panelData = new JPanel();
		panelSuperior.add(panelData);
		panelData.setLayout(new BoxLayout(panelData, BoxLayout.X_AXIS));

		lblData = new JLabel("Data:");
		panelData.add(lblData);

		Component horizontalStrut = Box.createHorizontalStrut(15);
		panelSuperior.add(horizontalStrut);

		JPanel panelHora = new JPanel();
		panelSuperior.add(panelHora);
		panelHora.setLayout(new BoxLayout(panelHora, BoxLayout.X_AXIS));

		lblHora = new JLabel();
		panelHora.add(lblHora);
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

		JScrollPane scrollPaneContactes = new JScrollPane();
		panelContactes.add(scrollPaneContactes, BorderLayout.CENTER);

		// Crear la taula de contactes.
		tableContactes = new JTable();
		configurarTaula(tableContactes, new String[] {"Id", "Nom", "Telèfon", "Email"}, null);
		// No mostrar la columna Id.
		ocultarColumna(tableContactes, 0);
		scrollPaneContactes.setViewportView(tableContactes);

		JPanel panelBotonsContactes = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton btnAfegirContacte = new JButton("Afegir Contacte");
		JButton btnEliminarContacte = new JButton("Eliminar Contacte");
		JButton btnActualitzarContactes = new JButton("Actualitzar");
		panelBotonsContactes.add(btnAfegirContacte);
		panelBotonsContactes.add(btnEliminarContacte);
		panelBotonsContactes.add(btnActualitzarContactes);

		btnAfegirContacte.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
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
							JOptionPane.WARNING_MESSAGE
							);

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

		JScrollPane scrollPaneCites = new JScrollPane();
		panelCites.add(scrollPaneCites, BorderLayout.CENTER);

		// Crear la taula de cites.
		tableCites = new JTable();
		configurarTaula(tableCites, new String[] {"Id", "Data", "Hora", "Descripció", "Contacte"}, null);
		// No mostrar la columna Id.
		ocultarColumna(tableCites, 0);
		scrollPaneCites.setViewportView(tableCites);

		JPanel panelBotonsCites = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton btnAfegirCita = new JButton("Afegir Cita");
		JButton btnEliminarCita = new JButton("Eliminar Cita");
		JButton btnActualitzarCites = new JButton("Actualitzar");
		panelBotonsCites.add(btnAfegirCita);
		panelBotonsCites.add(btnEliminarCita);
		panelBotonsCites.add(btnActualitzarCites);

		btnAfegirCita.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
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

				if(selectedRow != -1) {
					int modelRow = tableCites.convertRowIndexToModel(selectedRow);
					int idCita = (int) tableCites.getValueAt(modelRow, 0);

					// Mostrar un missatge de confirmació abans de eliminar la cita
					int opcio = Missatge.opcions(
							Agenda.this,
							"Eliminar cita",
							"S'eliminarà la cita seleccionada. Aquesta operació no es pot desfer, vols continuar?",
							JOptionPane.WARNING_MESSAGE
							);

					if(opcio == JOptionPane.YES_OPTION) {
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
	private void configurarTaula(JTable taula, String[] columnNames, Object[][] data) {
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// Evitar que les cel·les siguin editables.
				return false;
			}
		};

		// Assignar el model a la taula.
		taula.setModel(model);

		// Crear un sorter per filtrar les dades de la taula.
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(taula.getModel());
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
		for(int i = 0; i < taula.getColumnCount(); i++) {
			taula.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
	}

	// Mètode per ocultar una columna específica en una JTable.
	private void ocultarColumna(JTable taula, int columnaIndex) {
		TableColumnModel columnModel = taula.getColumnModel();
		TableColumn column = columnModel.getColumn(columnaIndex);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
		column.setResizable(false);
	}

	// Mètode per inicialitzar el rellotge.
	private void inicialitzarRellotge() {
		// Crear un temporitzador per actualitzar l'hora cada segon.
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualitzarDataIHora();
				verificarCitesPendents();
			}
		});
		timer.start(); // Iniciar el temporitzador.

		actualitzarDataIHora(); // Actualizar la data i l'hora immediatament.
		verificarCitesPendents(); // Verificar les cites pendents immediatament.
	}

	// Mètode per actualitzar l'hora.
	private void actualizarHora() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String horaFormatejada = sdf.format(new Date());
		lblHora.setText("Hora: " + horaFormatejada);
	}

	// Mètode per actualitzar la data.
	private void actualizarData() {
		SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatejada = sdfData.format(new Date());
		lblData.setText("Data: " + dataFormatejada);
	}

	// Método para actualizar la hora y la fecha.
	private void actualitzarDataIHora() {
		actualizarData();
		actualizarHora();
	}

	// Mètode per verificar les cites pendents.
	private void verificarCitesPendents() {
		if(verificarCita == null || !verificarCita.isAlive()) {
			verificarCita = new VerificarCita(tableCites);
			verificarCita.start();
		}
	}
	
	// Mètode per actualitzar les dades de les taules.
	private void actualitzarDadesTaules() {
		controladorBD.actualitzarTaulaContactes(tableContactes);
		controladorBD.actualitzarTaulaCites(tableCites);
	}

}
