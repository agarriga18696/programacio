package Jocs.JuegoCarreras;

public class Alertas {

	// Función para mostrar alertas de las penalizaciones.
	public static String alertasPenalizaciones(Circuito circuito, Clima clima) {
		StringBuilder alerta = new StringBuilder();

		// Mostrar alerta de viento.
		if(clima.getTipoViento().equals("Muy Fuerte") || clima.getTipoViento().equals("Fuerte")) {
			alerta.append(ElementosIU.TEXTO_NEGRITA + ElementosIU.AMARILLO_CLARO + " ⚠️ Alerta: " + ElementosIU.RESET + ElementosIU.AMARILLO_CLARO + "Viento " + clima.getTipoViento() + " (penalización a la aerodinámica)\n\n" + ElementosIU.RESET);
		}

		// Mostrar alerta de clima.
		if(clima.getClima().equals("Lluvia")) {
			alerta.append(ElementosIU.TEXTO_NEGRITA + ElementosIU.AMARILLO_CLARO + " ⚠️ Alerta: " + ElementosIU.RESET + ElementosIU.AMARILLO_CLARO + clima.getClima() + " (penalización al manejo)\n\n" + ElementosIU.RESET );
		} else if(clima.getClima().equals("Lluvia Intensa")) {
			alerta.append(ElementosIU.TEXTO_NEGRITA + ElementosIU.AMARILLO_CLARO + " ⚠️ Alerta: " + ElementosIU.RESET + ElementosIU.AMARILLO_CLARO + clima.getClima() + " (penalización al manejo y el agarre)\n\n" + ElementosIU.RESET);
		} else if(clima.getClima().equals("Tormenta Eléctrica")) {
			alerta.append(ElementosIU.TEXTO_NEGRITA + ElementosIU.AMARILLO_CLARO + " ⚠️ Alerta: " + ElementosIU.RESET + ElementosIU.AMARILLO_CLARO + clima.getClima() + " (multiplicador a todas las penalizaciones)\n\n" + ElementosIU.RESET);
		} else if(clima.getClima().equals("Niebla")) {
			alerta.append(ElementosIU.TEXTO_NEGRITA + ElementosIU.AMARILLO_CLARO + " ⚠️ Alerta: " + ElementosIU.RESET + ElementosIU.AMARILLO_CLARO + clima.getClima() + " (penalización a la velocidad)\n\n" + ElementosIU.RESET);
		}

		// Mostrar alerta por tipo de pavimento.
		if(circuito.getPavimento().equals("Tierra")) {
			alerta.append(ElementosIU.TEXTO_NEGRITA + ElementosIU.AMARILLO_CLARO + " ⚠️ Alerta: " + ElementosIU.RESET + ElementosIU.AMARILLO_CLARO + "Pavimento de " + circuito.getPavimento() + " (penalización al agarre)\n\n" + ElementosIU.RESET);
		} else if(circuito.getPavimento().equals("Grava")) {
			alerta.append(ElementosIU.TEXTO_NEGRITA + ElementosIU.AMARILLO_CLARO + " ⚠️ Alerta: " + ElementosIU.RESET + ElementosIU.AMARILLO_CLARO + "Pavimento de " + circuito.getPavimento() + " (penalización al agarre y probabilidad de derrape)\n\n" + ElementosIU.RESET);
		}

		return alerta.toString();
	}

}