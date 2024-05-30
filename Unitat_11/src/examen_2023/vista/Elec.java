package examen_2023.vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Elec extends JFrame {

	// Examen 2023
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JSpinner spinnerPP;
	private static JSpinner spinnerPSOE;
	JCheckBox chckbxPP;
	JCheckBox chckbxPSOE;
	int totalConcejales;
	JLabel lblMensaje;
	private JLabel lblMayoria;
	private static JSpinner spinnerMayoria;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private static JSpinner spinnerMes;
	private JLabel lblNewLabel_3;
	private static JSpinner spinnerVox;
	private JLabel lblNewLabel_4;
	private JCheckBox chckbxPodemos;
	private static JSpinner spinnerPodemos;
	private JLabel lblNewLabel_5;
	private JCheckBox chckbxCiudadanos;
	private static JSpinner spinnerCiudadanos;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Elec frame = new Elec();
					frame.setVisible(true);
					llegirDades();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private void llegirDades() {
				File file = new File("concejales.dat");
				if (file.exists()){
					ObjectInputStream ois;
					try {
						ois = new ObjectInputStream (new FileInputStream("concejales.dat"));
						@SuppressWarnings("unchecked")
						ArrayList<Integer> data = (ArrayList<Integer>)ois.readObject();
						ois.close();
						spinnerMayoria.setValue(data.get(0));
						spinnerPP.setValue(data.get(1));
						spinnerPSOE.setValue(data.get(2));
						spinnerMes.setValue(data.get(3));
						spinnerVox.setValue(data.get(4));
						spinnerPodemos.setValue(data.get(5));
						spinnerCiudadanos.setValue(data.get(6));

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Elec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		chckbxPP = new JCheckBox("PP");
		chckbxPP.setBounds(98, 86, 77, 23);


		chckbxPSOE = new JCheckBox("PSOE");
		chckbxPSOE.setBounds(98, 120, 77, 23);

		lblMensaje = new JLabel("              ");
		lblMensaje.setBounds(46, 233, 536, 14);

		spinnerPP = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		spinnerPP.setBounds(181, 89, 38, 20);

		spinnerPSOE = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		spinnerPSOE.setBounds(181, 123, 38, 20);



		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(46, 300, 99, 23);


		lblMayoria = new JLabel("Consellers / Concejales necesarios para tener mayor\u00EDa");
		lblMayoria.setBounds(46, 37, 325, 14);

		spinnerMayoria = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		spinnerMayoria.setBounds(381, 34, 40, 20);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(46, 83, 56, 26);
		lblNewLabel.setIcon(new ImageIcon(Elec.class.getResource("/examen_2023/img/PP40.png")));

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(46, 112, 42, 31);
		lblNewLabel_1.setIcon(new ImageIcon(Elec.class.getResource("/examen_2023/img/psoe40.png")));

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(46, 150, 40, 32);
		lblNewLabel_2.setIcon(new ImageIcon(Elec.class.getResource("/examen_2023/img/mes40.jpg")));

		spinnerMes = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		spinnerMes.setBounds(181, 162, 38, 20);

		JCheckBox chckbxMes = new JCheckBox("MxME");
		chckbxMes.setBounds(98, 159, 77, 23);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(280, 88, 49, 21);
		lblNewLabel_3.setIcon(new ImageIcon(Elec.class.getResource("/examen_2023/img/VOX40.png")));

		JCheckBox chckbxVox = new JCheckBox("VOX");
		chckbxVox.setBounds(372, 88, 80, 23);

		spinnerVox = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		spinnerVox.setBounds(480, 89, 38, 20);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(chckbxVox);
		contentPane.add(spinnerVox);
		contentPane.add(btnComprobar);
		contentPane.add(lblMensaje);
		contentPane.add(chckbxMes);
		contentPane.add(spinnerMes);
		contentPane.add(chckbxPSOE);
		contentPane.add(spinnerPSOE);
		contentPane.add(lblMayoria);
		contentPane.add(chckbxPP);
		contentPane.add(spinnerMayoria);
		contentPane.add(spinnerPP);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Elec.class.getResource("/examen_2023/img/podemos40.png")));
		lblNewLabel_4.setBounds(280, 117, 86, 26);
		contentPane.add(lblNewLabel_4);

		chckbxPodemos = new JCheckBox("Podemos");
		chckbxPodemos.setBounds(372, 120, 102, 23);
		contentPane.add(chckbxPodemos);

		spinnerPodemos = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		spinnerPodemos.setBounds(480, 123, 38, 20);
		contentPane.add(spinnerPodemos);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Elec.class.getResource("/examen_2023/img/ciudadanos40.png")));
		lblNewLabel_5.setBounds(280, 156, 54, 26);
		contentPane.add(lblNewLabel_5);

		chckbxCiudadanos = new JCheckBox("Ciudadanos");
		chckbxCiudadanos.setBounds(372, 159, 102, 23);
		contentPane.add(chckbxCiudadanos);

		spinnerCiudadanos = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		spinnerCiudadanos.setBounds(480, 162, 38, 20);
		contentPane.add(spinnerCiudadanos);

		JLabel lblNewLabel_6 = new JLabel("C\u00C1LCULO DE MAYOR\u00CDAS");
		lblNewLabel_6.setBounds(224, 11, 233, 14);
		contentPane.add(lblNewLabel_6);

		JButton btnNewButton = new JButton("Guardar y cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> data = new ArrayList<>();

				data.add((Integer) spinnerMayoria.getValue());
				data.add((Integer) spinnerPP.getValue());
				data.add((Integer) spinnerPSOE.getValue());
				data.add((Integer) spinnerMes.getValue());
				data.add((Integer) spinnerVox.getValue());
				data.add((Integer) spinnerPodemos.getValue());
				data.add((Integer) spinnerCiudadanos.getValue());

				try {
					ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream("concejales.dat"));
					oos.writeObject(data);
					oos.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);

			}
		});
		btnNewButton.setBounds(376, 300, 142, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Resetejar els valors dels JSpinner.
				spinnerMayoria.setValue(0);
				spinnerPP.setValue(0);
				spinnerPSOE.setValue(0);
				spinnerMes.setValue(0);
				spinnerVox.setValue(0);
				spinnerPodemos.setValue(0);
				spinnerCiudadanos.setValue(0);

				// Desmarcar tots els Checkbox.
				chckbxPP.setSelected(false);
				chckbxPSOE.setSelected(false);
				chckbxMes.setSelected(false);
				chckbxVox.setSelected(false);
				chckbxPodemos.setSelected(false);
				chckbxCiudadanos.setSelected(false);
			}
		});
		btnNewButton_1.setBounds(224, 300, 89, 23);
		contentPane.add(btnNewButton_1);

		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mayoria = (int) spinnerMayoria.getValue();
				int sumatodos = 0;
				String seleccionados = "";
				int cPP = (int) spinnerPP.getValue();
				int cPSOE = (int) spinnerPSOE.getValue();
				int cMes = (int) spinnerMes.getValue();
				int cVox = (int) spinnerVox.getValue();
				int cPodemos = (int) spinnerPodemos.getValue();
				int cCiudadanos = (int) spinnerCiudadanos.getValue();


				if (chckbxPP.isSelected()) {
					seleccionados += "+ PP ";
					sumatodos += cPP;
				}
				if (chckbxPSOE.isSelected()) {
					seleccionados += "+ PSOE ";
					sumatodos += cPSOE;
				}
				if (chckbxMes.isSelected()) {
					seleccionados += "+ MxME ";
					sumatodos += cMes;
				}
				if (chckbxVox.isSelected()) {
					seleccionados += "+ Vox ";
					sumatodos += cVox;
				}
				if (chckbxPodemos.isSelected()) {
					seleccionados += "+ Podemos ";
					sumatodos += cPodemos;
				}
				if (chckbxCiudadanos.isSelected()) {
					seleccionados += "+ Ciudadanos ";
					sumatodos += cCiudadanos;
				}

				if (sumatodos>=mayoria) {
					lblMensaje.setText(seleccionados.substring(1,seleccionados.length()-1) + " SI tienen mayoría absoluta");

				}else {
					lblMensaje.setText(seleccionados.substring(1,seleccionados.length()-1) + " NO tienen mayoría absoluta");
				}
			}
		});
	}
}
