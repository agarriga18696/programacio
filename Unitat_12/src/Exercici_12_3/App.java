package Exercici_12_3;

import java.awt.EventQueue;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Crear controlador per la interacció amb la base de dades.
					ControladorBD controladorBD = new ControladorBD();
					Institut frame = new Institut(controladorBD);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
