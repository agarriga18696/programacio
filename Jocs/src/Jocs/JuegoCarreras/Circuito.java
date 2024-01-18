package Jocs.JuegoCarreras;

public class Circuito {

	private double distancia;
	private double distanciaMeta;
	private String tipoCircuito;
	private String pavimento;

	public Circuito() {
		this.distancia = generarDistanciaCircuito();
		this.distanciaMeta = this.distancia * 1000;
		this.tipoCircuito = generarTipoCircuito();
		this.pavimento = generarPavimentoCircuito();
	}

	public double getDistancia() {
		return distancia;
	}
	
	public double getDistanciaMeta() {
		return distanciaMeta;
	}

	public String getTipoCircuito() {
		return tipoCircuito;
	}

	public String getPavimento() {
		return pavimento;
	}

	// Lista enumerada de los tipos de circuito.
	public enum TipoCircuito {
		PERMANENTE("Permanente"),
		CALLEJERO("Callejero");

		private final String tipoCircuitoString;

		TipoCircuito(String tipoCircuitoString) {
			this.tipoCircuitoString = tipoCircuitoString;
		}

		public String obtenerTipoCircuito() {
			return tipoCircuitoString;
		}
	}

	// Lista enumerada de los tipos de pavimento.
	public enum TipoPavimento {
		ASFALTO("Asfalto"),
		TIERRA("Tierra"),
		GRAVA("Grava");

		private final String tipoPavimentoString;

		TipoPavimento(String tipoPavimentoString) {
			this.tipoPavimentoString = tipoPavimentoString;
		}

		public String obtenerTipoPavimento() {
			return tipoPavimentoString;
		}
	}

	// Función para generar la distancia del circuito.
	private double generarDistanciaCircuito() {
		return FormatearNumero.formatearNumero(NumeroAleatorio.generarNumeroDoubleAleatorio(2.0, 6.0));
	}

	// Función para generar el tipo de circuito.
	private String generarTipoCircuito() {
		TipoCircuito[] tiposCircuitos = TipoCircuito.values();
		TipoCircuito tipoCircuito = tiposCircuitos[NumeroAleatorio.generarNumeroIntAleatorio(0, tiposCircuitos.length - 1)];
		return tipoCircuito.obtenerTipoCircuito();
	}

	// Función para generar el pavimento del circuito.
	private String generarPavimentoCircuito() {
		TipoPavimento[] tiposPavimentos = TipoPavimento.values();
		TipoPavimento tipoPavimento = tiposPavimentos[NumeroAleatorio.generarNumeroIntAleatorio(0, tiposPavimentos.length - 1)];
		return tipoPavimento.obtenerTipoPavimento();
	}

	// Información del Circuito
	public void mostrarInformacionCircuito() {
		ElementosIU.mostrarSeparador2();
		ElementosIU.mostrarSaltoLinea();
		System.out.println(ElementosIU.TEXTO_NEGRITA + " CIRCUITO\n" + ElementosIU.RESET);
		System.out.println(" Tipo:         " + getTipoCircuito());
		System.out.println(" Pavimento:    " + getPavimento());
		System.out.println(" Distancia:    " + distancia + " km\n");
	}

}
