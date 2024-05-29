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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Elec extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textFieldPP;
	private static JTextField textFieldPSOE;
	JCheckBox chckbxPP;
	JCheckBox chckbxPSOE;
	int totalConcejales;
	JLabel lblMensaje;
	private JLabel lblMayoria;
	private static JTextField textFieldMayoria;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private static JTextField textFieldMes;
	private JLabel lblNewLabel_3;
	private static JTextField textFieldVox;
	private JLabel lblNewLabel_4;
	private JCheckBox chckbxPodemos;
	private static JTextField textFieldPodemos;
	private JLabel lblNewLabel_5;
	private JCheckBox chckbxCiudadanos;
	private static JTextField textFieldCiudadanos;
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
						ArrayList<String> data = (ArrayList<String>)ois.readObject();
						ois.close();
						textFieldMayoria.setText(data.get(0));
						textFieldPP.setText(data.get(1));
						textFieldPSOE.setText(data.get(2));
						textFieldMes.setText(data.get(3));
						textFieldVox.setText(data.get(4));
						textFieldPodemos.setText(data.get(5));
						textFieldCiudadanos.setText(data.get(6));

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


		textFieldPP = new JTextField("0");
		textFieldPP.setBounds(181, 89, 38, 20);
		textFieldPP.setColumns(10);

		textFieldPSOE = new JTextField("0");
		textFieldPSOE.setBounds(181, 123, 38, 20);
		textFieldPSOE.setColumns(10);



		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(46, 300, 99, 23);


		lblMayoria = new JLabel("Consellers / Concejales necesarios para tener mayor\u00EDa");
		lblMayoria.setBounds(46, 37, 325, 14);

		textFieldMayoria = new JTextField();
		textFieldMayoria.setBounds(381, 34, 40, 20);
		textFieldMayoria.setText("0");
		textFieldMayoria.setColumns(10);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(46, 83, 56, 26);
		lblNewLabel.setIcon(new ImageIcon(Elec.class.getResource("/examen_2023/img/PP40.png")));

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(46, 112, 42, 31);
		lblNewLabel_1.setIcon(new ImageIcon(Elec.class.getResource("/examen_2023/img/psoe40.png")));

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(46, 150, 40, 32);
		lblNewLabel_2.setIcon(new ImageIcon(Elec.class.getResource("/examen_2023/img/mes40.jpg")));

		textFieldMes = new JTextField();
		textFieldMes.setBounds(181, 162, 38, 20);
		textFieldMes.setText("0");
		textFieldMes.setColumns(10);

		JCheckBox chckbxMXME = new JCheckBox("MxME");
		chckbxMXME.setBounds(98, 159, 77, 23);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(280, 88, 49, 21);
		lblNewLabel_3.setIcon(new ImageIcon(Elec.class.getResource("/examen_2023/img/VOX40.png")));

		JCheckBox chckbxVox = new JCheckBox("VOX");
		chckbxVox.setBounds(372, 88, 80, 23);

		textFieldVox = new JTextField();
		textFieldVox.setText("0");
		textFieldVox.setBounds(480, 89, 38, 20);
		textFieldVox.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(chckbxVox);
		contentPane.add(textFieldVox);
		contentPane.add(btnComprobar);
		contentPane.add(lblMensaje);
		contentPane.add(chckbxMXME);
		contentPane.add(textFieldMes);
		contentPane.add(chckbxPSOE);
		contentPane.add(textFieldPSOE);
		contentPane.add(lblMayoria);
		contentPane.add(chckbxPP);
		contentPane.add(textFieldMayoria);
		contentPane.add(textFieldPP);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Elec.class.getResource("/examen_2023/img/podemos40.png")));
		lblNewLabel_4.setBounds(280, 117, 86, 26);
		contentPane.add(lblNewLabel_4);

		chckbxPodemos = new JCheckBox("Podemos");
		chckbxPodemos.setBounds(372, 120, 102, 23);
		contentPane.add(chckbxPodemos);

		textFieldPodemos = new JTextField();
		textFieldPodemos.setText("0");
		textFieldPodemos.setBounds(480, 123, 38, 20);
		contentPane.add(textFieldPodemos);
		textFieldPodemos.setColumns(10);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Elec.class.getResource("/examen_2023/img/ciudadanos40.png")));
		lblNewLabel_5.setBounds(280, 156, 54, 26);
		contentPane.add(lblNewLabel_5);

		chckbxCiudadanos = new JCheckBox("Ciudadanos");
		chckbxCiudadanos.setBounds(372, 159, 102, 23);
		contentPane.add(chckbxCiudadanos);

		textFieldCiudadanos = new JTextField();
		textFieldCiudadanos.setText("0");
		textFieldCiudadanos.setBounds(480, 162, 38, 20);
		contentPane.add(textFieldCiudadanos);
		textFieldCiudadanos.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("C\u00C1LCULO DE MAYOR\u00CDAS");
		lblNewLabel_6.setBounds(224, 11, 233, 14);
		contentPane.add(lblNewLabel_6);

		JButton btnNewButton = new JButton("Guardar y cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> data = new ArrayList<String>();

				data.add(textFieldMayoria.getText());
				data.add(textFieldPP.getText());
				data.add(textFieldPSOE.getText());
				data.add(textFieldMes.getText());
				data.add(textFieldVox.getText());
				data.add(textFieldPodemos.getText());
				data.add(textFieldCiudadanos.getText());

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
				textFieldMayoria.setText("0");
				textFieldPP.setText("0");
				textFieldPSOE.setText("0");
				textFieldMes.setText("0");
				textFieldVox.setText("0");
				textFieldPodemos.setText("0");
				textFieldCiudadanos.setText("0");

			}
		});
		btnNewButton_1.setBounds(224, 300, 89, 23);
		contentPane.add(btnNewButton_1);

		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mayoria = Integer.parseInt(textFieldMayoria.getText());
				int sumatodos = 0;
				String seleccionados = "";
				int cPP = Integer.parseInt(textFieldPP.getText());
				int cPSOE = Integer.parseInt(textFieldPSOE.getText());
				int cMes = Integer.parseInt(textFieldMes.getText());
				int cVox = Integer.parseInt(textFieldVox.getText());
				int cPodemos = Integer.parseInt(textFieldPodemos.getText());
				int cCiudadanos = Integer.parseInt(textFieldCiudadanos.getText());


				if (chckbxPP.isSelected()) {
					seleccionados += "+ PP ";
					sumatodos += cPP;
				}
				if (chckbxPSOE.isSelected()) {
					seleccionados += "+ PSOE ";
					sumatodos += cPSOE;
				}
				if (chckbxMXME.isSelected()) {
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
