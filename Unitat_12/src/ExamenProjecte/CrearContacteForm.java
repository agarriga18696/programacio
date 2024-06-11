package ExamenProjecte;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearContacteForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNom;
	private JTextField txtTelefon;
	private JTextField txtEmail;
	private JButton btnAfegir;
	private JTable taula;

	private ControladorBD controladorBD;

	public CrearContacteForm(ControladorBD controladorBD, JTable taula) {
		this.controladorBD = controladorBD;
		this.taula = taula;

		formulari();
		configurarFinestra();
	}

	private void formulari() {
		setTitle("Crear Contacte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel panelFormulari = new JPanel(new GridLayout(3, 2));
		panelFormulari.setBorder(new EmptyBorder(10, 10, 10, 10));

		JLabel lblNom = new JLabel("Nom:");
		txtNom = new JTextField(20);
		JLabel lblTelefon = new JLabel("Telèfon:");
		txtTelefon = new JTextField(20);
		JLabel lblEmail = new JLabel("Email:");
		txtEmail = new JTextField(20);

		panelFormulari.add(lblNom);
		panelFormulari.add(txtNom);
		panelFormulari.add(lblTelefon);
		panelFormulari.add(txtTelefon);
		panelFormulari.add(lblEmail);
		panelFormulari.add(txtEmail);

		add(panelFormulari, BorderLayout.CENTER);

		btnAfegir = new JButton("Afegir");
		btnAfegir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = txtNom.getText().trim();
				String telefon = txtTelefon.getText().trim();
				String email = txtEmail.getText().trim();

				boolean dadesCorrectes = comprovarDades(nom, telefon, email);

				if(dadesCorrectes) {
					// Afegir contacte a la base de dades.
					controladorBD.crearContacte(nom, telefon, email);
					// Actualitzar la taula de contactes.
					controladorBD.actualitzarTaulaContactes(taula);

					dispose(); // Tancar el formulari després d'afegir el contacte.

				} else {
					Missatge.error(null, "Per favor, no deixis cap camp buit.");
					return;
				}

			}
		});

		add(btnAfegir, BorderLayout.SOUTH);
	}

	private boolean comprovarDades(String nom, String telefon, String email) {
		// Verificar que no s'hagi deixat cap camp buit.
		return !nom.isEmpty() && !telefon.isEmpty() && !email.isEmpty();
	}

	private void configurarFinestra() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
