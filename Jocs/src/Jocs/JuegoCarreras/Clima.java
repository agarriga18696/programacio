package Jocs.JuegoCarreras;

public class Clima {

	private String clima;
	private String tipoViento;
	private double velocidadViento;

	public Clima() {
		this.clima = generarClima();
		this.velocidadViento = generarViento();
	}

	public double getVelocidadViento() {
		return velocidadViento;
	}

	public String getTipoViento() {
		return tipoViento;
	}

	public String getClima() {
		return clima;
	}

	// Lista enumerada de los tipos de clima.
	private enum TipoClima {
		//SOLEADO("Soleado"),
		//LLUVIA("Lluvia"),
		//LLUVIA_INTENSA("Lluvia Intensa"),
		TORMENTA_ELECTRICA("Tormenta Eléctrica");

		private final String tipoClimaString;

		TipoClima(String tipoClimaString) {
			this.tipoClimaString = tipoClimaString;
		}

		public String obtenerTipoClima() {
			return tipoClimaString;
		}
	}

	// Lista enumerada de los tipos de viento.
	private enum TipoViento {
		MUY_FUERTE("Muy Fuerte"),
		FUERTE("Fuerte"),
		MODERADO("Moderado"),
		BRISA("Brisa"),
		CALMA("Calma");

		private final String tipoVientoString;

		TipoViento(String tipoVientoString) {
			this.tipoVientoString = tipoVientoString;
		}

		public String obtenerTipoViento() {
			return tipoVientoString;
		}
	}

	// Función para generar el clima del circuito.
	private String generarClima() {
		TipoClima[] tiposClimas = TipoClima.values();
		TipoClima tipoClima;

		// Establecer un rango entre 0 y 9.
		int indiceClima = NumeroAleatorio.generarNumeroIntAleatorio(0, 9);
		
		if (indiceClima >= 8) { // menos posibilidades de que toque 'Tormenta Eléctrica'.
			return tiposClimas[3].obtenerTipoClima();
		} else {
			tipoClima = tiposClimas[NumeroAleatorio.generarNumeroIntAleatorio(0, tiposClimas.length - 1)];
			return tipoClima.obtenerTipoClima();
		}
	}

	// Función para generar la intensidad del viento del circuito.
	private double generarViento() {
		TipoViento[] tiposVientos = TipoViento.values();
		TipoViento tipoViento = tiposVientos[NumeroAleatorio.generarNumeroIntAleatorio(0, tiposVientos.length - 1)];
		double velocidadViento = 0;

		switch (tipoViento) {
		case MUY_FUERTE:
			velocidadViento = NumeroAleatorio.generarNumeroDoubleAleatorio(50, 60);
			break;
		case FUERTE:
			velocidadViento = NumeroAleatorio.generarNumeroDoubleAleatorio(30, 49.9);
			break;
		case MODERADO:
			velocidadViento = NumeroAleatorio.generarNumeroDoubleAleatorio(20, 29.9);
			break;
		case BRISA:
			velocidadViento = NumeroAleatorio.generarNumeroDoubleAleatorio(2, 19.9);
			break;
		case CALMA:
			velocidadViento = NumeroAleatorio.generarNumeroDoubleAleatorio(0, 1.9);
			break;
		default:
			velocidadViento = 0;
			break;
		}

		this.tipoViento = tipoViento.obtenerTipoViento();
		return FormatearNumero.formatearNumero(velocidadViento);
	}

	// Información del Clima
	public void mostrarInformacionClima() {
		// Información del Tiempo
		ElementosIU.mostrarSeparador2();
		ElementosIU.mostrarSaltoLinea();
		System.out.println(ElementosIU.TEXTO_NEGRITA + " CLIMA" + ElementosIU.RESET);
		System.out.println();
		System.out.println(" Clima:        " + getClima());
		System.out.println(" Viento:       " + getVelocidadViento() + " km/h (" + getTipoViento() + ")\n");
	}

}
