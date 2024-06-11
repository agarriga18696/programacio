package ExamenProjecte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;

public class VerificarCita extends Thread {

	private JTable tableCites;
	private ArrayList<Integer> citesVerificades;

	public VerificarCita(JTable tableCites) {
		this.tableCites = tableCites;
		this.citesVerificades = new ArrayList<>();
	}

	@Override
	public void run() {
		while(true) {
			// Obtenir la data i hora actual.
			Date fechaHoraActual = new Date();

			// Verificar si alguna cita coincideix amb la data i hora actual.
			verificarCitaActual(fechaHoraActual);

			try {
				// Dormir el fil durant un segon abans de realizar la pròxima verificació.
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Missatge.error(null, "Ha sorgit un error: " + e.getMessage());
			}
		}
	}

	// Mètode per verificar la cita actual.
	private void verificarCitaActual(Date dataHoraActual) {
		// Recórrer totes les cites de la taula.
		for(int i = 0; i < tableCites.getRowCount(); i++) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Date dataHoraCita = sdf.parse((String) tableCites.getValueAt(i, 1) + " " + (String) tableCites.getValueAt(i, 2));

				// T'avisarà de la pròxima cita pendent amb 1 minut de marge.
				long rang = 60 * 1000; // 1 minut en mil·lisegons.

				// Verificar si la data i hora de la cita està dins del rang permès al voltant de la data i hora actual.
				if(Math.abs(dataHoraCita.getTime() - dataHoraActual.getTime()) <= rang) {
					// Si la cita no ha estat ja verificada, mostrar el missatge d'avís i marcar-la com a verificada.
					if(!citesVerificades.contains(i)) {
						Missatge.personalitzat(null, "Recordatori", "Tens una cita d'aquí 1 minut!");
						citesVerificades.add(i);
					}
				} else {
					// Si la cita està fora del marge d'avís, eliminar-la de la llista de cites verificades.
					citesVerificades.remove(Integer.valueOf(i));
				}

			} catch (ParseException e) {
				Missatge.error(null, "Ha sorgit un error: " + e.getMessage());
			}
		}
	}

}
