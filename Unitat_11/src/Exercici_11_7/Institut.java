package Exercici_11_7;

import javax.swing.SwingUtilities;

public class Institut {

	protected static Finestra finestra;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				finestra = new Finestra();
			}
		});
	}

}
