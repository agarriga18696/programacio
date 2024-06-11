package ExamenProjecte;

import java.awt.EventQueue;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControladorBD controladorBD = new ControladorBD();
					Agenda frame = new Agenda(controladorBD);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
