package Prova_Examen;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.Color;

public class NouAlumne extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_nom;
	private JTextField textField_dni;
	private JTextField textField_edat;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */

	static ArrayList<Persona> persones = new ArrayList<>();
	private JTextField textField_msgerror;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NouAlumne frame = new NouAlumne();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NouAlumne() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lbl_titol = new JLabel("NOU ALUMNE");
		lbl_titol.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbl_nom = new JLabel("Nom");

		JLabel lbl_dni = new JLabel("Dni");

		JLabel lbl_edat = new JLabel("Edat");

		textField_nom = new JTextField();
		textField_nom.setColumns(10);

		textField_dni = new JTextField();
		textField_dni.setColumns(10);

		textField_edat = new JTextField();
		textField_edat.setColumns(10);

		JLabel lbl_nivell = new JLabel("Nivell");

		JButton btn_crear = new JButton("Crear");
		btn_crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nom;
					String dni;
					int edat;
					String nivell;

					nom = textField_nom.getText().trim();
					dni = textField_dni.getText().trim();
					edat = Integer.parseInt(textField_edat.getText().trim());
					nivell = buttonGroup.getSelection().getActionCommand();

					if(nom.isEmpty() || dni.isEmpty() || nivell.isEmpty()) {
						textField_msgerror.setText("Error: no es pot deixar cap camp buit.");

					} else {
						persones.add(new Alumne(nom, dni, edat, nivell));
					}

				} catch(NumberFormatException ex) {
					textField_msgerror.setText("Error: format d'edat incorrecte.");

				} catch(NullPointerException ex) {
					textField_msgerror.setText("Error: has de seleccionar un nivell d'estudis.");
				}
			}
		});

		JRadioButton rdbtn_eso = new JRadioButton("ESO");
		rdbtn_eso.setActionCommand(rdbtn_eso.getText());
		buttonGroup.add(rdbtn_eso);

		JRadioButton rdbtn_batxillerat = new JRadioButton("Batxillerat");
		rdbtn_batxillerat.setActionCommand(rdbtn_batxillerat.getText());
		buttonGroup.add(rdbtn_batxillerat);

		JRadioButton rdbtn_graumitja = new JRadioButton("Grau Mitjà");
		rdbtn_graumitja.setActionCommand(rdbtn_graumitja.getText());
		buttonGroup.add(rdbtn_graumitja);

		JRadioButton rdbtn_grausuperior = new JRadioButton("Grau Superior");
		rdbtn_grausuperior.setActionCommand(rdbtn_grausuperior.getText());
		buttonGroup.add(rdbtn_grausuperior);

		textField_msgerror = new JTextField();
		textField_msgerror.setColumns(10);
		textField_msgerror.setBackground(null);
		textField_msgerror.setForeground(new Color(255, 0, 0));
		textField_msgerror.setBorder(null);
		textField_msgerror.setEditable(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lbl_titol, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lbl_nom, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_nom, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lbl_dni, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
												.addComponent(lbl_edat, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
												.addComponent(lbl_nivell, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(rdbtn_batxillerat, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
												.addComponent(rdbtn_eso, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_dni, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
												.addComponent(textField_edat, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
												.addComponent(rdbtn_grausuperior, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
												.addComponent(rdbtn_graumitja, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textField_msgerror, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btn_crear)))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(lbl_titol)
						.addGap(22)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_nom)
								.addComponent(textField_nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_dni)
								.addComponent(textField_dni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl_edat)
								.addComponent(textField_edat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(36)
										.addComponent(lbl_nivell))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(18)
										.addComponent(rdbtn_eso)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(rdbtn_batxillerat)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(rdbtn_graumitja)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(rdbtn_grausuperior)
						.addGap(10)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btn_crear, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_msgerror, Alignment.LEADING))
						.addGap(8))
				);
		contentPane.setLayout(gl_contentPane);

		pack();
		setMinimumSize(new Dimension(500, 320));
	}
}
