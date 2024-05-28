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
		this.vista.actualitzarTextBoto(isCelsiusToFahrenheit);
	}

	class ConvertListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				// Obtenir el valor del TextField segons el tipus de conversió.
				double input = 0.0;
				
				if (isCelsiusToFahrenheit) {
					input = vista.getCelsius();
					
				} else {
					input = vista.getFahrenheit();
				}

				// Realitzar la conversió segons el tipus.
				double output = 0.0;
				
				if (isCelsiusToFahrenheit) {
					output = model.conversioCelsiusAFahrenheit(input);
					
				} else {
					output = model.conversioFahrenheitACelsius(input);
				}

				// Actualitzar el TextField de sortida.
				vista.setConversionResult(output);

			} catch (NumberFormatException ex) {
				vista.showError("Introdueix un número vàlid.");
			}
		}
	}

	public void canviarConversio() {
		isCelsiusToFahrenheit = !isCelsiusToFahrenheit;
		vista.actualitzarTextBoto(isCelsiusToFahrenheit);
	}

}
