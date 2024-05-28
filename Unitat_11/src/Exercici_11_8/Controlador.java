package Exercici_11_8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {

	private Model model;
	private Vista vista;
	private boolean isCelsiusToFahrenheit = true;

	public Controlador(Model model, Vista vista) {
		this.model = model;
		this.vista = vista;
		this.vista.addConvertListener(new ConvertListener());
		this.vista.actualizarTextoBoton(isCelsiusToFahrenheit);
	}

	class ConvertListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double input = 0.0;

			try {
				// Obtener el valor del TextField según el tipo de conversión
				if (isCelsiusToFahrenheit) {
					input = vista.getCelsius();
				} else {
					input = vista.getFahrenheit();
				}

				// Realizar la conversión según el tipo
				double output;
				if (isCelsiusToFahrenheit) {
					output = model.conversioCelsiusAFahrenheit(input);
				} else {
					output = model.conversioFahrenheitACelsius(input);
				}

				// Actualizar el TextField de salida
				vista.setConversionResult(output);

			} catch (NumberFormatException ex) {
				vista.showError("Introdueix un número vàlid.");
			}
		}
	}

	public void canviarConversio() {
		isCelsiusToFahrenheit = !isCelsiusToFahrenheit;
		vista.actualizarTextoBoton(isCelsiusToFahrenheit);
	}

}
