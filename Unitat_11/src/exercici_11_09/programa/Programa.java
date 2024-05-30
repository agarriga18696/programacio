package exercici_11_09.programa;

import java.awt.EventQueue;

import exercici_11_09.vista.Finestra;

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
