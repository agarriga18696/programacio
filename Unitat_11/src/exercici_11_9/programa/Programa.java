package exercici_11_9.programa;

import java.awt.EventQueue;

import exercici_11_9.vista.Finestra;
import exercici_11_9.controlador.Controlador;

public class Programa {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finestra frame = new Finestra();
					Controlador controlador = new Controlador(frame);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
