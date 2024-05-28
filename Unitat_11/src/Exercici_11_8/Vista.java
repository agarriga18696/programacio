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
	private JLabel label_input;
	private JLabel label_output;
	private JTextField textfield_input;
	private JTextField textfield_output;
	private JButton button_calcular;

	// Estils
	private final Color COLOR_PRIMARI = new Color(254, 254, 254);
	private final Color COLOR_SECUNDARI = new Color(64, 64, 64);
	private final Color COLOR_ENFASI = new Color(8, 96, 242);
	private final int PADDING = 10;
	private final String FONT = "Helvetica";
	private final Font FONT_NEGRETA = new Font(FONT, Font.BOLD, 16);
	private final Font FONT_CURSIVA = new Font(FONT, Font.ITALIC, 16);

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

		// TEXT FIELD INPUT
		JPanel panel_input = new JPanel(new BorderLayout());
		panel_input.setBackground(COLOR_PRIMARI);
		textfield_input = new JTextField();
		textfield_input.setHorizontalAlignment(SwingConstants.CENTER);
		textfield_input.setBackground(COLOR_PRIMARI);
		textfield_input.setForeground(COLOR_ENFASI);
		textfield_input.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(COLOR_SECUNDARI), TEXT_C, TitledBorder.CENTER, TitledBorder.TOP, null, COLOR_ENFASI), new EmptyBorder(PADDING, PADDING, PADDING * 2, PADDING)));
		textfield_input.setFont(FONT_NEGRETA);
		textfield_input.setPreferredSize(new Dimension(100, textfield_input.getPreferredSize().height));

		panel_input.add(textfield_input, BorderLayout.CENTER);

		// LABEL INPUT
		label_input = new JLabel(SIMBOL_C);
		label_input.setForeground(COLOR_SECUNDARI);
		label_input.setFont(FONT_NEGRETA);
		textfield_input.setLayout(new BorderLayout());
		textfield_input.add(label_input, BorderLayout.EAST);
		panel_intern.add(panel_input);

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

		// TEXT FIELD OUTPUT
		JPanel panel_output = new JPanel(new BorderLayout());
		panel_output.setBackground(COLOR_SECUNDARI);
		textfield_output = new JTextField();
		textfield_output.setHorizontalAlignment(SwingConstants.CENTER);
		textfield_output.setBackground(COLOR_PRIMARI);
		textfield_output.setForeground(COLOR_ENFASI);
		textfield_output.setFont(FONT_NEGRETA);    
		textfield_output.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(COLOR_SECUNDARI), TEXT_F, TitledBorder.CENTER, TitledBorder.TOP, null, COLOR_ENFASI), new EmptyBorder(PADDING, PADDING, PADDING * 2, PADDING)));
		textfield_output.setPreferredSize(new Dimension(100, textfield_input.getPreferredSize().height));
		textfield_output.setEditable(false);

		panel_output.add(textfield_output, BorderLayout.CENTER);

		// LABEL OUTPUT
		label_output = new JLabel(SIMBOL_F);
		label_output.setForeground(COLOR_SECUNDARI);
		label_output.setFont(FONT_NEGRETA);
		textfield_output.setLayout(new BorderLayout());
		textfield_output.add(label_output, BorderLayout.EAST);

		panel_intern.add(panel_output);

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
		return Double.parseDouble(textfield_input.getText().replace(",", "."));
	}

	public double getFahrenheit() throws NumberFormatException {
		return Double.parseDouble(textfield_output.getText().replace(",", "."));
	}

	public void setConversionResult(double result) {
		textfield_output.setText(String.format("%.2f", result).replace(".", ","));
	}

	public void showError(String message) {
		textfield_output.setText(message);
	}

	public void addConvertListener(ActionListener listenForConvertButton) {
		button_calcular.addActionListener(listenForConvertButton);
	}

	public void actualitzarTextBoto(boolean isCelsiusToFahrenheit) {
		if(isCelsiusToFahrenheit) {
			label_formula.setText("Fórmula ⇒ " + FORMULA_C_F);
			label_input.setText(SIMBOL_C);
			label_output.setText(SIMBOL_F);
			textfield_input.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(COLOR_SECUNDARI), TEXT_C, TitledBorder.CENTER, TitledBorder.TOP, null, COLOR_ENFASI), new EmptyBorder(PADDING, PADDING, PADDING * 2, PADDING)));
			textfield_output.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(COLOR_SECUNDARI), TEXT_F, TitledBorder.CENTER, TitledBorder.TOP, null, COLOR_ENFASI), new EmptyBorder(PADDING, PADDING, PADDING * 2, PADDING)));
			textfield_input.setText("0");
			textfield_output.setText("32,00");

		} else {
			label_formula.setText("Fórmula ⇒ " + FORMULA_F_C);
			label_input.setText(SIMBOL_F);
			label_output.setText(SIMBOL_C);
			textfield_input.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(COLOR_SECUNDARI), TEXT_F, TitledBorder.CENTER, TitledBorder.TOP, null, COLOR_ENFASI), new EmptyBorder(PADDING, PADDING, PADDING * 2, PADDING)));
			textfield_output.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(COLOR_SECUNDARI), TEXT_C, TitledBorder.CENTER, TitledBorder.TOP, null, COLOR_ENFASI), new EmptyBorder(PADDING, PADDING, PADDING * 2, PADDING)));
			textfield_input.setText("0");
			textfield_output.setText("-17,78");
		}

	}

}
