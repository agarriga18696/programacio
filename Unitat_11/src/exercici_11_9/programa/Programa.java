package exercici_11_9.programa;

import java.awt.EventQueue;

import exercici_11_9.vista.Finestra;

public class Programa {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finestra frame = new Finestra();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
