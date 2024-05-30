package examen_2024.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import examen_2024.modelo.Combinacion;
import examen_2024.modelo.Logica;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class vistaLoteria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JList<String> list;
	private List<JSpinner> camposUsuario = new ArrayList<>();
	private List<JSpinner> camposCombinacion = new ArrayList<>();
	private JButton btn_generarComb;

	public vistaLoteria() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mn_menu = new JMenu("Menú");
		menuBar.add(mn_menu);

		JMenuItem mntm_limpiar = new JMenuItem("Limpiar");
		mn_menu.add(mntm_limpiar);
		mntm_limpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
				limpiarLista();
			}

		});

		JMenuItem mntm_salir = new JMenuItem("Salir");
		mn_menu.add(mntm_salir);
		mntm_salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JPanel panel_superior = new JPanel();

		JPanel panel_inferior = new JPanel();

		JPanel panel_central = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_superior, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
				.addComponent(panel_central, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
				.addComponent(panel_inferior, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel_superior, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_central, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_inferior, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
				);
		panel_inferior.setLayout(null);

		list = new JList<>();
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 10, 679, 164);
		panel_inferior.add(scrollPane, BorderLayout.CENTER);

		JLabel lbl_numUsuario = new JLabel("Números usuario");
		lbl_numUsuario.setBounds(10, 10, 192, 34);
		lbl_numUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));

		JPanel panel_numUsuario = new JPanel();
		panel_numUsuario.setBounds(212, 10, 477, 34);
		panel_central.setLayout(null);
		panel_central.add(lbl_numUsuario);
		panel_central.add(panel_numUsuario);
		panel_numUsuario.setLayout(new GridLayout(0, 6, 10, 0));

		for (int i = 0; i < 6; i++) {
			JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 49, 1));
			panel_numUsuario.add(spinner);
			camposUsuario.add(spinner);
			spinner.addChangeListener(e -> validarCamposUsuario());
		}

		JPanel panel_numUsuario_1 = new JPanel();
		panel_numUsuario_1.setBounds(212, 65, 477, 34);
		panel_central.add(panel_numUsuario_1);
		panel_numUsuario_1.setLayout(new GridLayout(0, 6, 10, 0));

		JLabel lbl_numUsuario_1 = new JLabel("Combinación ganadora");
		lbl_numUsuario_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_numUsuario_1.setBounds(10, 65, 192, 34);
		panel_central.add(lbl_numUsuario_1);

		for (int i = 0; i < 6; i++) {
			JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 49, 1));
			panel_numUsuario_1.add(spinner);
			camposCombinacion.add(spinner);
		}

		btn_generarComb = new JButton("Generar combinación");
		btn_generarComb.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_generarComb.setBounds(455, 132, 234, 46);
		btn_generarComb.setEnabled(false);
		btn_generarComb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Combinacion combinacionSecreta = generarCombinacion();
				Combinacion combinacionUsuario = combUsuario();
				Logica.agregarCombinacion(combinacionSecreta);
				actualizarLista(Logica.lista_combinaciones, combinacionUsuario);
			}

		});

		panel_central.add(btn_generarComb);
		panel_superior.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("Simulador de lotería");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_superior.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);

		// Configurar ventana.
		setTitle("Lotería");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setMinimumSize(new Dimension(723, 520));
		setResizable(false);
		setLocationRelativeTo(null); 
	}

	private void validarCamposUsuario() {
		boolean habilitar = camposUsuario.stream().allMatch(spinner -> (int) spinner.getValue() > 0);
		btn_generarComb.setEnabled(habilitar);
	}

	private Combinacion combUsuario() {
		Combinacion comb = new Combinacion();
		int[] combUs = new int[6];

		for(int i = 0; i < 6; i++) {
			JSpinner spinner = camposUsuario.get(i);
			combUs[i] = (int) spinner.getValue();
		}

		comb.setCombinacion(combUs);

		return comb;
	}

	// Método para limpiar los campos.
	private void limpiarCampos() {
		for(JSpinner spinner : camposUsuario) {
			spinner.setValue(0);
		}

		for(JSpinner spinner : camposCombinacion) {
			spinner.setValue(0);
		}
	}

	// Método para limpiar la lista.
	private void limpiarLista() {
		Logica.lista_combinaciones.clear();
		actualizarLista(Logica.lista_combinaciones, null);
	}

	private Combinacion generarCombinacion() {
		Combinacion combinacion = new Combinacion();

		for(int i = 0; i < 6; i++) {
			JSpinner spinner = camposCombinacion.get(i);
			spinner.setValue(combinacion.getCombinacion()[i]);
		}

		return combinacion; 
	}

	// Método para actualizar la lista.
	private void actualizarLista(List<Combinacion> combinaciones,  Combinacion combUsuario) {
		DefaultListModel<String> dlm = new DefaultListModel<>();

		for (Combinacion comb : combinaciones) {
			int aciertos = Logica.compararResultado(combUsuario, comb);
			String resultado = String.format("La combinación %s tiene %d aciertos.", comb, aciertos);
			dlm.addElement(resultado);
		}

		list.setModel(dlm);
	}
}
