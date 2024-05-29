package examen_2023.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Finestra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Finestra() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_superior = new JPanel();
		panel_superior.setBorder(new EmptyBorder(10, 0, 10, 0));
		contentPane.add(panel_superior, BorderLayout.NORTH);
		panel_superior.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbl_titol = new JLabel("CÁLCULO DE MAYORÍAS");
		lbl_titol.setHorizontalAlignment(SwingConstants.CENTER);
		panel_superior.add(lbl_titol);
		
		JPanel panel_inferior = new JPanel();
		contentPane.add(panel_inferior, BorderLayout.SOUTH);
		panel_inferior.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
		
		JButton btnNewButton = new JButton("Comprovar");
		panel_inferior.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Netejar");
		panel_inferior.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Guardar i tancar");
		panel_inferior.add(btnNewButton_2);
		
		JPanel panel_central = new JPanel();
		panel_central.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel_central, BorderLayout.CENTER);
		GridBagLayout gbl_panel_central = new GridBagLayout();
		gbl_panel_central.columnWidths = new int[]{771, 0};
		gbl_panel_central.rowHeights = new int[] {0, 250, 50};
		gbl_panel_central.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_central.rowWeights = new double[]{0.0, 1.0, 1.0};
		panel_central.setLayout(gbl_panel_central);
		
		JPanel panel_central_superior = new JPanel();
		panel_central_superior.setBorder(new EmptyBorder(10, 0, 10, 0));
		GridBagConstraints gbc_panel_central_superior = new GridBagConstraints();
		gbc_panel_central_superior.insets = new Insets(0, 0, 5, 0);
		gbc_panel_central_superior.fill = GridBagConstraints.BOTH;
		gbc_panel_central_superior.gridx = 0;
		gbc_panel_central_superior.gridy = 0;
		panel_central.add(panel_central_superior, gbc_panel_central_superior);
		panel_central_superior.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Consellers necessaris per tenir majoria absoluta");
		panel_central_superior.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		panel_central_superior.add(spinner);
		
		JPanel panel_central_central = new JPanel();
		GridBagConstraints gbc_panel_central_central = new GridBagConstraints();
		gbc_panel_central_central.insets = new Insets(0, 0, 5, 0);
		gbc_panel_central_central.fill = GridBagConstraints.BOTH;
		gbc_panel_central_central.gridx = 0;
		gbc_panel_central_central.gridy = 1;
		panel_central.add(panel_central_central, gbc_panel_central_central);
		panel_central_central.setLayout(new GridLayout(3, 6, 40, 100));
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		panel_central_central.add(lblNewLabel_7);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("PP");
		panel_central_central.add(chckbxNewCheckBox);
		
		JSpinner spinner_1 = new JSpinner();
		panel_central_central.add(spinner_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_central_central.add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("VOX");
		panel_central_central.add(chckbxNewCheckBox_3);
		
		JSpinner spinner_2 = new JSpinner();
		panel_central_central.add(spinner_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_central_central.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("PSOE");
		panel_central_central.add(chckbxNewCheckBox_1);
		
		JSpinner spinner_3 = new JSpinner();
		panel_central_central.add(spinner_3);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_central_central.add(lblNewLabel_3);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Podemos");
		panel_central_central.add(chckbxNewCheckBox_5);
		
		JSpinner spinner_4 = new JSpinner();
		panel_central_central.add(spinner_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_central_central.add(lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("MxME");
		panel_central_central.add(chckbxNewCheckBox_4);
		
		JSpinner spinner_6 = new JSpinner();
		panel_central_central.add(spinner_6);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_central_central.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Ciudadanos");
		panel_central_central.add(chckbxNewCheckBox_2);
		
		JSpinner spinner_5 = new JSpinner();
		panel_central_central.add(spinner_5);
		
		JPanel panel_central_inferior = new JPanel();
		GridBagConstraints gbc_panel_central_inferior = new GridBagConstraints();
		gbc_panel_central_inferior.fill = GridBagConstraints.BOTH;
		gbc_panel_central_inferior.gridx = 0;
		gbc_panel_central_inferior.gridy = 2;
		panel_central.add(panel_central_inferior, gbc_panel_central_inferior);
		panel_central_inferior.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel_central_inferior.add(lblNewLabel_6);
		
		setTitle("Càlcul de majories");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(798, 505));
		setLocationRelativeTo(null);
	}
}
