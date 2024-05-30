package Exercici_11_08;

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
		this.vista.actualitzarGUI(isCelsiusToFahrenheit);
	}

	class ConvertListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				// Obtenir el valor a convertir del TextField Input.
				double input = vista.getInput();
				
				// Aplicar fórmula segons el tipus de conversió.
				double output = 0.0;
				if (isCelsiusToFahrenheit) {
					output = model.conversioCelsiusAFahrenheit(input);
				} else {
					output = model.conversioFahrenheitACelsius(input);
				}

				// Mostrar el resultat al TextField Output.
				vista.setResultat(output);

			} catch (NumberFormatException ex) {
				vista.mostrarError("Introdueix un número vàlid.");
			}
		}
	}

	public void canviarConversio() {
		isCelsiusToFahrenheit = !isCelsiusToFahrenheit;
		vista.actualitzarGUI(isCelsiusToFahrenheit);
	}

}
