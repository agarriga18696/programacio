package Exercici_11_08;

import java.awt.EventQueue;

public class Programa {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					Model model = new Model();
					Controlador controlador = new Controlador(model, frame);
					frame.setControlador(controlador);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
