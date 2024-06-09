package principal;

import java.awt.EventQueue;

import controlador.ControladorUsuario;
import modelo.Sonido;
import vista.Mensaje;
import vista.VentanaLogin;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Cargar los sonidos del juego.
					Sonido.cargarTodosLosSonidos();

					ControladorUsuario controladorUsuario = new ControladorUsuario();
					VentanaLogin frame = new VentanaLogin(controladorUsuario);
					frame.setVisible(true);

				} catch (Exception e) {
					Mensaje.error(null, "Ha ocurrido un error:\n" + e);
				}
			}
		});
	}

}