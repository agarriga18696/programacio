package examen_2024.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen_2024.modelo.Combinacion;
import examen_2024.modelo.Logica;
import exercici_11_09.model.Alumne;

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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class vistaLoteria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JList<Combinacion> list;
	private List<JSpinner> camposUsuario = new ArrayList<>();
	private List<JSpinner> camposCombinacion = new ArrayList<>();

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
		list.setBounds(10, 10, 679, 136);
		panel_inferior.add(list);

		JLabel lbl_numUsuario = new JLabel("Números usuario");
		lbl_numUsuario.setBounds(10, 10, 192, 34);
		lbl_numUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));

		JPanel panel_numUsuario = new JPanel();
		panel_numUsuario.setBounds(212, 10, 477, 34);
		panel_central.setLayout(null);
		panel_central.add(lbl_numUsuario);
		panel_central.add(panel_numUsuario);
		panel_numUsuario.setLayout(new GridLayout(0, 6, 10, 0));

		JSpinner spinner_1_1 = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		panel_numUsuario.add(spinner_1_1);
		camposUsuario.add(spinner_1_1);

		JSpinner spinner_1_2 = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		panel_numUsuario.add(spinner_1_2);
		camposUsuario.add(spinner_1_2);

		JSpinner spinner_1_3 = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		panel_numUsuario.add(spinner_1_3);
		camposUsuario.add(spinner_1_3);

		JSpinner spinner_1_4 = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		panel_numUsuario.add(spinner_1_4);
		camposUsuario.add(spinner_1_4);

		JSpinner spinner_1_5 = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		panel_numUsuario.add(spinner_1_5);
		camposUsuario.add(spinner_1_5);

		JSpinner spinner_1_6 = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		panel_numUsuario.add(spinner_1_6);
		camposUsuario.add(spinner_1_6);

		JPanel panel_numUsuario_1 = new JPanel();
		panel_numUsuario_1.setBounds(212, 65, 477, 34);
		panel_central.add(panel_numUsuario_1);
		panel_numUsuario_1.setLayout(new GridLayout(0, 6, 10, 0));

		JSpinner spinner_2_1 = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		panel_numUsuario_1.add(spinner_2_1);
		camposCombinacion.add(spinner_2_1);

		JSpinner spinner_2_2 = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		panel_numUsuario_1.add(spinner_2_2);
		camposCombinacion.add(spinner_2_2);

		JSpinner spinner_2_3 = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		panel_numUsuario_1.add(spinner_2_3);
		camposCombinacion.add(spinner_2_3);

		JSpinner spinner_2_4 = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		panel_numUsuario_1.add(spinner_2_4);
		camposCombinacion.add(spinner_2_4);

		JSpinner spinner_2_5 = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		panel_numUsuario_1.add(spinner_2_5);
		camposCombinacion.add(spinner_2_5);

		JSpinner spinner_2_6 = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		panel_numUsuario_1.add(spinner_2_6);
		camposCombinacion.add(spinner_2_6);

		JLabel lbl_numUsuario_1 = new JLabel("Combinación ganadora");
		lbl_numUsuario_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_numUsuario_1.setBounds(10, 65, 192, 34);
		panel_central.add(lbl_numUsuario_1);

		JButton btn_generarComb = new JButton("Generar combinación");
		btn_generarComb.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_generarComb.setBounds(455, 122, 234, 46);
		//btn_generarComb.setEnabled(sePuedeClicar());

		btn_generarComb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Combinacion combinacionSecreta = generarCombinacion();
				Combinacion combinacionUsuario = combUsuario();
				
				Logica.compararResultado(combinacionUsuario, combinacionSecreta);
				Logica.agregarCombinacion(combinacionSecreta);
				actualizarLista(Logica.lista_combinaciones);
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
		setMinimumSize(new Dimension(723, 490));
		setResizable(false);
		setLocationRelativeTo(null); 
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
		list.removeAll();
		actualizarLista(Logica.lista_combinaciones);
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
	private void actualizarLista(List<Combinacion> combinaciones) {
		DefaultListModel<Combinacion> dlm = new DefaultListModel<>();
		
		for(Combinacion comb : combinaciones) {
			dlm.addElement(comb);
		}
		
		list.setModel(dlm);
	}
}
