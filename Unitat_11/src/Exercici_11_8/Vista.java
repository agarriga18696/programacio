package Exercici_11_8;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class Vista extends JFrame {

	// Atributs
	private static final long serialVersionUID = 1L;
	private Controlador controlador;
	private JPanel contentPane;
	private JLabel label_formula;
	private JLabel label_celsius;
	private JLabel label_fahrenheit;
	private JTextField textfield_celsius;
	private JTextField textfield_fahrenheit;
	private JButton button_calcular;

	// Estils
	private final Color COLOR_PRIMARI = new Color(254, 254, 254);
	private final Color COLOR_SECUNDARI = new Color(64, 64, 64);
	private final Color COLOR_ENFASI = new Color(8, 96, 242);
	private final int PADDING = 10;
	private final String FONT = "Helvetica";
	private final Font FONT_NEGRETA = new Font("Helvetica", Font.BOLD, 16);
	private final Font FONT_CURSIVA = new Font("Helvetica", Font.ITALIC, 16);

	// Fórmules
	private final String FORMULA_C_F = "(°C × 9/5) + 32 = °F";
	private final String FORMULA_F_C = "(°F - 32) × 5/9 = °C";
	private final String SIMBOL_C = "ºC";
	private final String SIMBOL_F = "ºF";
	private final String TEXT_C = "Celsius";
	private final String TEXT_F = "Fahrenheit";

	// Constructor
	public Vista() {
		super("Calculadora Conversió Temperatura");
		// FRAME
		contentPane = new JPanel();
		contentPane.setBackground(COLOR_PRIMARI);
		contentPane.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// PANEL SUPERIOR
		JPanel panel_superior = new JPanel();
		panel_superior.setForeground(COLOR_SECUNDARI);
		panel_superior.setBackground(COLOR_PRIMARI);
		panel_superior.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
		contentPane.add(panel_superior, BorderLayout.NORTH);
		panel_superior.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING), new EmptyBorder(0, 0, PADDING, 0)));

		// LABEL FÓRMULA
		label_formula = new JLabel("Fórmula ⇒ " + FORMULA_C_F);
		label_formula.setForeground(COLOR_SECUNDARI);
		label_formula.setFont(FONT_CURSIVA);
		panel_superior.add(label_formula);

		// PANEL CENTRAL
		JPanel panel_central = new JPanel();
		panel_central.setBackground(COLOR_PRIMARI);
		panel_central.setForeground(COLOR_SECUNDARI);
		contentPane.add(panel_central, BorderLayout.CENTER);
		BorderLayout bl_panel_central = new BorderLayout();
		panel_central.setLayout(bl_panel_central);

		// PANEL INTERN
		JPanel panel_intern = new JPanel();
		panel_intern.setBackground(COLOR_PRIMARI);
		panel_central.add(panel_intern, BorderLayout.CENTER);
		panel_intern.setLayout(new BoxLayout(panel_intern, BoxLayout.Y_AXIS));

		// TEXT FIELD CELSIUS
		JPanel panel_celsius = new JPanel(new BorderLayout());
		panel_celsius.setBackground(COLOR_PRIMARI);
		textfield_celsius = new JTextField();
		textfield_celsius.setHorizontalAlignment(SwingConstants.CENTER);
		textfield_celsius.setBackground(COLOR_PRIMARI);
		textfield_celsius.setForeground(COLOR_ENFASI);
		textfield_celsius.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(COLOR_SECUNDARI), TEXT_C, TitledBorder.CENTER, TitledBorder.TOP, null, COLOR_ENFASI), new EmptyBorder(PADDING, PADDING, PADDING * 2, PADDING)));
		textfield_celsius.setFont(FONT_NEGRETA);
		textfield_celsius.setPreferredSize(new Dimension(100, textfield_celsius.getPreferredSize().height));

		panel_celsius.add(textfield_celsius, BorderLayout.CENTER);

		// LABEL CELSIUS
		label_celsius = new JLabel(SIMBOL_C);
		label_celsius.setForeground(COLOR_SECUNDARI);
		label_celsius.setFont(FONT_NEGRETA);
		textfield_celsius.setLayout(new BorderLayout());
		textfield_celsius.add(label_celsius, BorderLayout.EAST);
		panel_intern.add(panel_celsius);

		// PANEL BOTO CENTRAL
		JPanel panel_button_central = new JPanel();
		panel_button_central.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_button_central.setOpaque(false);
		panel_intern.add(panel_button_central);

		// BUTTON CENTRAL
		JButton button_central = new JButton("⇅");
		button_central.setBackground(COLOR_PRIMARI);
		button_central.setForeground(COLOR_SECUNDARI);
		button_central.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
		button_central.setFont(new Font(FONT, Font.PLAIN, 20));
		panel_button_central.add(button_central);

		// ActionListener per canviar la conversió.
		button_central.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.canviarConversio();
			}
		});

		// TEXT FIELD FARENHEIT
		JPanel panel_fahrenheit = new JPanel(new BorderLayout());
		panel_fahrenheit.setBackground(COLOR_SECUNDARI);
		textfield_fahrenheit = new JTextField();
		textfield_fahrenheit.setHorizontalAlignment(SwingConstants.CENTER);
		textfield_fahrenheit.setBackground(COLOR_PRIMARI);
		textfield_fahrenheit.setForeground(COLOR_ENFASI);
		textfield_fahrenheit.setFont(FONT_NEGRETA);    
		textfield_fahrenheit.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(COLOR_SECUNDARI), TEXT_F, TitledBorder.CENTER, TitledBorder.TOP, null, COLOR_ENFASI), new EmptyBorder(PADDING, PADDING, PADDING * 2, PADDING)));
		textfield_fahrenheit.setPreferredSize(new Dimension(100, textfield_celsius.getPreferredSize().height));
		textfield_fahrenheit.setEditable(false);

		panel_fahrenheit.add(textfield_fahrenheit, BorderLayout.CENTER);

		// LABEL FARENHEIT
		label_fahrenheit = new JLabel(SIMBOL_F);
		label_fahrenheit.setForeground(COLOR_SECUNDARI);
		label_fahrenheit.setFont(FONT_NEGRETA);
		textfield_fahrenheit.setLayout(new BorderLayout());
		textfield_fahrenheit.add(label_fahrenheit, BorderLayout.EAST);

		panel_intern.add(panel_fahrenheit);

		// PANEL INFERIOR
		JPanel panel_inferior = new JPanel();
		panel_inferior.setForeground(COLOR_SECUNDARI);
		panel_inferior.setBackground(COLOR_PRIMARI);
		panel_inferior.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
		contentPane.add(panel_inferior, BorderLayout.SOUTH);
		panel_inferior.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING), new EmptyBorder(PADDING * 2, 0, 0, 0)));

		// BUTTON CALCULAR
		button_calcular = new JButton("Calcular");
		button_calcular.setForeground(COLOR_PRIMARI);
		button_calcular.setBackground(COLOR_ENFASI);
		button_calcular.setBorder(new EmptyBorder(10, 20, 10, 20));
		button_calcular.setFont(FONT_NEGRETA);
		panel_inferior.add(button_calcular);

		// CONFIGURAR FRAME
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setMinimumSize(new Dimension(500, 450));
		setLocationRelativeTo(null); // Centrar a la pantalla.

	}

	// Mètodes
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public double getCelsius() throws NumberFormatException {
		return Double.parseDouble(textfield_celsius.getText().replace(",", "."));
	}

	public void setFahrenheit(double fahrenheit) {
		textfield_fahrenheit.setText(String.format("%.2f", fahrenheit).replace(".", ","));
	}

	public double getFahrenheit() throws NumberFormatException {
		return Double.parseDouble(textfield_fahrenheit.getText().replace(",", "."));
	}

	public void setConversionResult(double result) {
		textfield_fahrenheit.setText(String.format("%.2f", result).replace(".", ","));
	}

	public void showError(String message) {
		textfield_fahrenheit.setText(message);
	}

	public void addConvertListener(ActionListener listenForConvertButton) {
		button_calcular.addActionListener(listenForConvertButton);
	}

	public void actualizarTextoBoton(boolean isCelsiusToFahrenheit) {
		// Resetejar els textos dels TextField.
		textfield_celsius.setText("0");
		textfield_fahrenheit.setText("0");
		
		if(isCelsiusToFahrenheit) {
			label_formula.setText("Fórmula ⇒ " + FORMULA_C_F);
			label_celsius.setText(SIMBOL_C);
			label_fahrenheit.setText(SIMBOL_F);
			textfield_celsius.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(COLOR_SECUNDARI), TEXT_C, TitledBorder.CENTER, TitledBorder.TOP, null, COLOR_ENFASI), new EmptyBorder(PADDING, PADDING, PADDING * 2, PADDING)));
			textfield_fahrenheit.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(COLOR_SECUNDARI), TEXT_F, TitledBorder.CENTER, TitledBorder.TOP, null, COLOR_ENFASI), new EmptyBorder(PADDING, PADDING, PADDING * 2, PADDING)));

		} else {
			label_formula.setText("Fórmula ⇒ " + FORMULA_F_C);
			label_celsius.setText(SIMBOL_F);
			label_fahrenheit.setText(SIMBOL_C);
			textfield_celsius.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(COLOR_SECUNDARI), TEXT_F, TitledBorder.CENTER, TitledBorder.TOP, null, COLOR_ENFASI), new EmptyBorder(PADDING, PADDING, PADDING * 2, PADDING)));
			textfield_fahrenheit.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(COLOR_SECUNDARI), TEXT_C, TitledBorder.CENTER, TitledBorder.TOP, null, COLOR_ENFASI), new EmptyBorder(PADDING, PADDING, PADDING * 2, PADDING)));
		}

	}

}
