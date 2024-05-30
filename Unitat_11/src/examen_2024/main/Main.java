package examen_2024.main;

import java.awt.EventQueue;

import examen_2024.vista.vistaLoteria;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaLoteria frame = new vistaLoteria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
