package Jocs.JuegoCarreras;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Vehiculo extends Thread {
	private static final Object lockImpresion = new Object();

	// Distancia mínima que deberá recorrer el vehículo antes de que se le apliquen las penalizaciones y bonificaciones (arranque).
	private static final double DISTANCIA_INICIAL_SIN_PENALIZACION = 70.0;

	// Atributos.
	private String tipo;
	private String color;
	private String nombreCompleto;
	private String icono;
	// Estadísticas.
	private double velocidad;
	private double aceleracion;
	private double peso;
	private double manejo;
	private double agarre;
	private double turbo;
	// Penalizaciones.
	private double penalizacionViento;
	private double penalizacionLluvia;
	private double penalizacionAgarre;
	private double penalizacionDerrape;
	private double penalizacionTormentaElectrica;
	private double penalizacionNiebla;
	// Bonificaciones
	private double bonificacionTurbo;
	// Otros.
	private String tipoJugador;
	private boolean esIA;
	private double distanciaRecorridaInicial;
	private double distanciaRecorridaFinal;
	private boolean meta;
	private boolean derrape;

	private ScheduledExecutorService executorService;

	private Circuito circuito;
	private Clima clima;

	// Constructor.
	public Vehiculo(Circuito circuito, Clima clima, boolean esIA) {
		this.circuito = circuito;
		this.clima = clima;
		this.executorService = Executors.newScheduledThreadPool(1);
		this.esIA = esIA;
		this.tipo = generarTipoAleatorio();
		this.color = generarColorAleatorio();
		this.nombreCompleto = tipo + " " + color;
		this.tipoJugador = esIA ? ElementosIU.TEXTO_NEGRITA + "IA" + ElementosIU.RESET : ElementosIU.TEXTO_NEGRITA + "Jugador" + ElementosIU.RESET;
		this.icono = esIA ? ElementosIU.TEXTO_NEGRITA + ElementosIU.CIAN + "🤖" + ElementosIU.RESET : ElementosIU.TEXTO_NEGRITA + ElementosIU.CIAN_CLARO + "👤" + ElementosIU.RESET;
		generarTipoVehiculo();
	}

	// Getters y setters.
	public Circuito getCircuito() {
		return circuito;
	}

	public String getTipo() {
		return tipo;
	}

	public String getColor() {
		return color;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public double getAceleracion() {
		return aceleracion;
	}

	public double getPeso() {
		return peso;
	}

	public double getManejo() {
		return manejo;
	}

	public double getAgarre() {
		return agarre;
	}

	public double getTurbo() {
		return turbo;
	}

	public boolean getEsIA() {
		return esIA;
	}

	public String getTipoJugador() {
		return tipoJugador;
	}

	public double getDistanciaRecorridaInicial() {
		return distanciaRecorridaInicial;
	}

	public double getDistanciaRecorridaFinal() {
		return distanciaRecorridaFinal;
	}
	
	public boolean isMeta() {
		return meta;
	}

	public double getPenalizacionViento() {
		return penalizacionViento;
	}

	public double getPenalizacionLluvia() {
		return penalizacionLluvia;
	}

	public double getPenalizacionAgarre() {
		return penalizacionAgarre;
	}

	public double getPenalizacionDerrape() {
		return penalizacionDerrape;
	}
	
	public double getPenalizacionNiebla() {
		return penalizacionNiebla;
	}

	public boolean isDerrape() {
		return derrape;
	}

	public void setDerrape(boolean derrape) {
		this.derrape = derrape;
	}

	public double getBonificacionTurbo() {
		return bonificacionTurbo;
	}

	// Lista enumerada de los tipos de vehiculo.
	private enum TipoVehiculo {
		DEPORTIVO("Deportivo"), 
		RALLY("Rally"), 
		DRIFT("Drift"), 
		TODOTERRENO("Todoterreno"), 
		COMPACTO("Compacto"),
		MICROCAR("Microcar"), 
		FORMULA_1("Fórmula 1"), 
		MOTO("Moto"), 
		QUAD("Quad"), 
		KART("Kart"), 
		BATMOVIL("Batmóvil"),
		LEGO("Lego"), 
		TRACTOR("Tractor"),

		PLAYMOBIL("Playmobil"),
		HOTWHEELS("Hotwheels"),
		SCOOTER("Scooter"),
		BICI("Bici"),
		CAMION("Camión"),
		LIMUSINA("Limusina"),
		MONSTER_TRUCK("Monster Truck"),
		BUGGY("Buggy"),
		AUTOBUS("Autobús");

		private final String tipoVehiculoString;

		TipoVehiculo(String tipoVehiculoString) {
			this.tipoVehiculoString = tipoVehiculoString;
		}

		private String obtenerTipoVehiculo() {
			return tipoVehiculoString;
		}
	}

	// Lista enumerada de los colores del vehiculo.
	private enum ColorVehiculo {
		ROJO(ElementosIU.ROJO_CLARO + "Rojo" + ElementosIU.RESET),
		VERDE(ElementosIU.VERDE_CLARO + "Verde" + ElementosIU.RESET),
		AZUL(ElementosIU.AZUL_CLARO + "Azul" + ElementosIU.RESET), 
		AMARILLO(ElementosIU.AMARILLO_CLARO + "Amarillo" + ElementosIU.RESET),
		MORADO(ElementosIU.MORADO_CLARO + "Morado" + ElementosIU.RESET),
		CELESTE(ElementosIU.CIAN_CLARO + "Celeste" + ElementosIU.RESET),
		GRANATE(ElementosIU.ROJO + "Granate" + ElementosIU.RESET),

		DORADO(ElementosIU.AMARILLO + "Dorado" + ElementosIU.RESET),
		ARCOIRIS(
				ElementosIU.ROJO + "A" + 
						ElementosIU.ROJO_CLARO + "r" + 
						ElementosIU.AMARILLO + "c" + 
						ElementosIU.VERDE + "o" +
						ElementosIU.VERDE_CLARO + "i" + 
						ElementosIU.AZUL_CLARO + "r" +
						ElementosIU.CIAN + "i" +
						ElementosIU.MORADO_CLARO + "s" +
						ElementosIU.RESET);

		private final String tipoColorString;

		ColorVehiculo(String tipoColorString) {
			this.tipoColorString = tipoColorString;
		}

		private String obtenerColorVehiculo() {
			return tipoColorString;
		}

	}

	private String generarTipoAleatorio() {
		TipoVehiculo[] tiposVehiculos = TipoVehiculo.values();
		TipoVehiculo tipoVehiculo = tiposVehiculos[NumeroAleatorio.generarNumeroIntAleatorio(0,
				tiposVehiculos.length - 1)];
		return tipoVehiculo.obtenerTipoVehiculo();
	}

	private String generarColorAleatorio() {
		ColorVehiculo[] coloresVehiculos = ColorVehiculo.values();
		ColorVehiculo colorVehiculo = coloresVehiculos[NumeroAleatorio.generarNumeroIntAleatorio(0,
				coloresVehiculos.length - 1)];
		return colorVehiculo.obtenerColorVehiculo();
	}

	// Función para determinar los valores de los atributos del vehículo.
	private void generarTipoVehiculo() {

		switch (tipo) {
		case "Fórmula 1":
			generarAtributosVehiculo(9.00, 8.50, 4.50, 4.00, 3.50, 2.00);
			break;
		case "Batmóvil":
			generarAtributosVehiculo(8.50, 8.00, 5.00, 3.50, 4.00, 2.00);
			break;
		case "Deportivo":
			generarAtributosVehiculo(7.50, 7.00, 5.00, 5.00, 4.00, 4.00);
			break;
		case "Moto":
			generarAtributosVehiculo(7.00, 6.00, 3.50, 7.50, 4.00, 5.00);
			break;
		case "Hotwheels":
			generarAtributosVehiculo(7.50, 9.00, 2.00, 7.00, 5.00, 5.00);
			break;
		case "Todoterreno":
			generarAtributosVehiculo(6.00, 5.50, 6.50, 3.00, 7.50, 4.00);
			break;
		case "Compacto":
			generarAtributosVehiculo(5.50, 8.00, 5.50, 4.00, 7.00, 6.00);
			break;
		case "Kart":
			generarAtributosVehiculo(6.00, 8.00, 4.00, 7.00, 6.00, 8.50);
			break;
		case "Monster Truck":
			generarAtributosVehiculo(6.00, 4.00, 8.00, 3.50, 8.00, 3.00);
			break;
		case "Playmobil":
			generarAtributosVehiculo(5.50, 7.50, 4.00, 6.00, 5.00, 8.00);
			break;
		case "Rally":
			generarAtributosVehiculo(6.00, 5.00, 5.50, 8.00, 9.00, 5.50);
			break;
		case "Quad":
			generarAtributosVehiculo(5.50, 7.00, 4.50, 8.50, 7.50, 5.00);
			break;
		case "Camión":
			generarAtributosVehiculo(5.00, 4.00, 8.00, 3.00, 7.50, 6.00);
			break;
		case "Drift":
			generarAtributosVehiculo(5.00, 8.00, 5.50, 9.00, 4.00, 7.50);
			break;
		case "Lego":
			generarAtributosVehiculo(4.50, 6.50, 2.00, 8.00, 4.00, 7.00);
			break;
		case "Buggy":
			generarAtributosVehiculo(5.00, 8.00, 4.00, 6.50, 7.00, 6.00);
			break;
		case "Limusina":
			generarAtributosVehiculo(6.00, 3.50, 7.00, 3.00, 7.00, 5.00);
			break;
		case "Autobús":
			generarAtributosVehiculo(5.50, 3.50, 9.00, 2.00, 6.50, 6.50);
			break;
		case "Microcar":
			generarAtributosVehiculo(5.00, 7.00, 4.00, 8.00, 4.00, 7.50);
			break;
		case "Scooter":
			generarAtributosVehiculo(4.50, 6.50, 3.00, 8.50, 5.00, 7.00);
			break;
		case "Tractor":
			generarAtributosVehiculo(3.00, 8.50, 8.50, 2.00, 9.00, 3.00);
			break;
		case "Bici":
			generarAtributosVehiculo(4.00, 6.50, 2.50, 9.00, 5.00, 8.50);
			break;
		default:
			generarAtributosVehiculo(5.00, 5.00, 5.00, 5.00, 5.00, 5.00);
			break;
		}
	}

	// Función para asignar los atributos del vehículo.
	private void generarAtributosVehiculo(double velocidad, double aceleracion, double peso, double manejo, double agarre, double turbo) {

		this.velocidad = FormatearNumero.formatearNumero(velocidad);
		this.aceleracion = FormatearNumero.formatearNumero(aceleracion);
		this.peso = FormatearNumero.formatearNumero(peso);
		this.manejo = FormatearNumero.formatearNumero(manejo);
		this.agarre = FormatearNumero.formatearNumero(agarre);
		this.turbo = FormatearNumero.formatearNumero(turbo);

	}

	// MECÁNICAS DE MOVIMIENTO
	// Función para calcular la distancia que recorren los vehículos.
	private double distanciaRecorridaVehiculo(double tiempo) {
		// Calcular la distancia recorrida con la fórmula de la cinemática.
		//double distanciaRecorridaInicial = tiempo + 0.5 * (this.getVelocidad() * this.getAceleracion()) * Math.pow(tiempo, 2) * 0.1;
		double distanciaRecorridaInicial = this.velocidad * tiempo + 0.5 * (this.velocidad * this.aceleracion * this.manejo * this.agarre) * Math.pow(tiempo, 2) * 0.012;

		// Actualizar atributo.
		this.distanciaRecorridaInicial = distanciaRecorridaInicial;

		return distanciaRecorridaInicial;
	}

	// Función para calcular el avance del vehículo.
	private double avanceVehiculo(double tiempo) {
		double distanciaRecorrida = distanciaRecorridaVehiculo(tiempo);

		if(distanciaRecorrida > DISTANCIA_INICIAL_SIN_PENALIZACION) {
			double penalizacionViento = calcularPenalizacionViento();
			double penalizacionAgarre = calcularPenalizacionAgarre(distanciaRecorrida);
			double penalizacionLluvia = calcularPenalizacionLluvia();
			double penalizacionDerrape = penalizacionDerrape(distanciaRecorrida);
			double penalizacionTormentaElectrica = penalizacionTormentaElectrica();
			double penalizacionNiebla = penalizacionNiebla();
			double bonificacionTurbo = bonificacionTurbo();
			double distanciaFinal;

			// Actualizar atributos penalizaciones.	
			this.penalizacionViento = penalizacionViento;
			this.penalizacionAgarre = penalizacionAgarre;
			this.penalizacionLluvia = penalizacionLluvia;
			this.penalizacionDerrape = penalizacionDerrape;
			this.penalizacionNiebla = penalizacionNiebla;
			
			this.penalizacionViento *= penalizacionTormentaElectrica;
			this.penalizacionAgarre *= penalizacionTormentaElectrica;
			this.penalizacionLluvia *= penalizacionTormentaElectrica;
			this.penalizacionDerrape *= penalizacionTormentaElectrica;

			// Aplicar penalizaciones.
			penalizacionViento *= penalizacionTormentaElectrica;
			penalizacionAgarre *= penalizacionTormentaElectrica;
			penalizacionLluvia *= penalizacionTormentaElectrica;
			penalizacionDerrape *= penalizacionTormentaElectrica;

			distanciaFinal = distanciaRecorrida;
			distanciaFinal -= penalizacionViento;
			distanciaFinal -= penalizacionAgarre;
			distanciaFinal -= penalizacionLluvia;
			distanciaFinal -= penalizacionDerrape;
			distanciaFinal -= penalizacionNiebla;

			// Sumar la bonificación de 'turbo'.
			distanciaFinal += bonificacionTurbo;

			// Asegurar que la distancia final no sea negativa.
			distanciaFinal = Math.max(0, distanciaFinal);

			// Actualiza la distancia recorrida en el vehículo.
			this.distanciaRecorridaFinal = distanciaFinal;

			return distanciaFinal;

		}

		return distanciaRecorrida; // Si la distancia es menor que la 'DISTANCIA_INICIAL_SIN_PENALIZACION', no hay penalizaciones aplicadas.
	}

	// PENALIZACIÓN VIENTO
	// Función para calcular la penalización de movimiento por viento.
	private double calcularPenalizacionViento() {
		double ajustePenalizacion = 0.5;
		double velocidadViento = this.clima.getVelocidadViento();
		double penalizacion = 0;

		// Aplicar penalización por viento solo en caso de viento 'Fuerte' o 'Muy Fuerte'. 
		if(this.clima.getTipoViento().equals("Muy Fuerte") || this.clima.getTipoViento().equals("Fuerte")) {
			// Calcular la penalización de movimiento por viento y aerodinámica.
			penalizacion = ajustePenalizacion / this.peso * velocidadViento;
		}

		// Actualizar el atributo.
		this.penalizacionViento = penalizacion;

		return penalizacion;
	}

	// PENALIZACIÓN LLUVIA
	// Función para calcular la penalización de movimiento por agarre.
	private double calcularPenalizacionLluvia() {
		double ajustePenalizacion = 0.1;
		double penalizacion = 0;

		// Según tipo de Lluvia.
		if (clima.getClima().equals("Lluvia")) {
			penalizacion = Math.pow(2, 10 - this.manejo) * ajustePenalizacion;

		} else if (clima.getClima().equals("Lluvia Intensa")) {
			penalizacion = Math.pow(2.1, 10 - this.manejo) * ajustePenalizacion;
		}

		// Actualizar el atributo.
		this.penalizacionLluvia = penalizacion;

		return penalizacion;
	}

	// PENALIZACIÓN AGARRE
	// Función para calcular la penalización de movimiento por agarre.
	private double calcularPenalizacionAgarre(double distanciaRecorrida) {
		double ajustePenalizacion = 0.1;
		double penalizacion = 0;

		// Según tipo de pavimento (Tierra o Grava).
		if (circuito.getPavimento().equals("Tierra")) {
			// Dificulta el avance.
			penalizacion = Math.pow(2, 10 - this.agarre) * ajustePenalizacion;
		} else if (circuito.getPavimento().equals("Grava")) {
			// Dificulta el avance y probabilidad de derrape.
			penalizacion = Math.pow(2.1, 10 - this.agarre) * ajustePenalizacion;
		}

		// Actualizar el atributo.
		this.penalizacionAgarre = penalizacion;

		return penalizacion;
	}

	// PENALIZACIÓN DERRAPE
	// Función para controlar el derrape.
	private double penalizacionDerrape(double distanciaRecorrida) {
		// La probabilidad de derrapar depende del atributo agarre del vehículo.
		double probabilidadDerrape = this.getAgarre() / 15;
		double factorDerrape = Math.pow(2, 10 - this.agarre) * 0.1;
		double penalizacion = 0;

		if (circuito.getPavimento().equals("Grava") && Math.random() < probabilidadDerrape) {
			penalizacion = NumeroAleatorio.generarNumeroDoubleAleatorio(factorDerrape * 0.5, factorDerrape * 1.5);

			if(penalizacion > 0) {
				this.setDerrape(true);
			} else {
				this.setDerrape(false);
			}
		}

		this.penalizacionDerrape = penalizacion;

		return penalizacion;
	}

	// PENALIZACIÓN TORMENTA ELÉCTRICA.
	// Función para determinar la aleatoriedad de la penalización por Tormenta Eléctrica.
	private boolean penalizacionTormentaElectricaActiva() {
		return Math.random() < 0.4; // 40% de probabilidad.
	}

	private double penalizacionTormentaElectrica() {
		// La Tormenta Eléctrica generará fallos electrónicos en los vehículos de manera aleatoria.
		double penalizacion = 1.0;

		// Se activa solamente cuando hay Tormenta Eléctrica.
		if (clima.getClima().equals("Tormenta Eléctrica") && penalizacionTormentaElectricaActiva()) {
			// Establecer probabilidad de los fallos.
			penalizacion = NumeroAleatorio.generarNumeroDoubleAleatorio(2, 5);
		}

		this.penalizacionTormentaElectrica = FormatearNumero.formatearNumero(penalizacion);

		return penalizacion;
	}
	
	// Función para calcular la penalización por Niebla.
	private double penalizacionNiebla() {
		double ajustePenalizacion = 0.1;
		double multiplicador = NumeroAleatorio.generarNumeroDoubleAleatorio(1, 3);
		double penalizacion = 0;
		
		if(clima.getClima().equals("Niebla")) {
			penalizacion = Math.pow(multiplicador, 10 - this.velocidad) * ajustePenalizacion;
		}
		
		// Actualizar atributo.
		this.penalizacionNiebla = penalizacion;
		
		return penalizacion;
		
	}

	// BONIFICACIÓN TURBO
	// Función para activar el turbo.
	private boolean turboActivado() {
		// La probabilidad de usar el turbo es del 60%.
		return Math.random() < 0.6;
	}

	// Función para calcular la bonificación del turbo.
	private double bonificacionTurbo() {
		double factorTurbo = this.turbo * 3;
		double bonificacion = 0;

		if (turboActivado()) {
			// La probabilidad de usar el turbo depende del atributo turbo del vehículo.
			if (Math.random() < this.turbo) {
				bonificacion = NumeroAleatorio.generarNumeroDoubleAleatorio(factorTurbo, factorTurbo * 2);
			}
		}

		this.bonificacionTurbo = bonificacion;

		return bonificacion;
	}

	// TIEMPO ITERACIONES
	// Calcular el tiempo de espera entre cada iteración (Recorrido).
	private long calcularTiempoEspera() {
		// Calcular el tiempo con la velocidad y aceleración.
		double tiempoEspera = (long) (2 * 600 / ((11 - this.aceleracion) + this.velocidad)) + 2300;

		// Controlar que el tiempo de espera mínimo sea de 1 segundo (1000 milisegundos).
		tiempoEspera = Math.max(tiempoEspera, 1000);

		return (long) tiempoEspera;
	}

	// AVANCE
	// Gestionar el avance del vehículo.
	private void gestionarAvance(Tiempo tiempoTranscurrido) {
		double distanciaAvance = avanceVehiculo(tiempoTranscurrido.getTiempo());
		this.distanciaRecorridaFinal = distanciaAvance;

		synchronized (lockImpresion) {
			if(distanciaRecorridaFinal > 0) {
				mostrarMensajeAvance();
			} else {
				mostrarMensajeArranque();
			}
		}
	}

	// Mensaje cuando el vehículo avanza.
	private void mostrarMensajeAvance() {
		String unidadDistancia = (this.distanciaRecorridaFinal < 1000) ? "mts" : "kms";
		double distancia = (this.distanciaRecorridaFinal < 1000) ? this.getDistanciaRecorridaFinal() : this.getDistanciaRecorridaFinal() / 1000;

		System.out.println(System.lineSeparator());
		// Mostrar emoji de 'IA' o 'Jugador'.
		System.out.println(" " + this.icono + " " + this.getTipoJugador() + ": " + this.getNombreCompleto());

		// Mostrar avance inicial (sin penalizaciones).
		System.out.println("\n ➡️ Avance: " + FormatearNumero.formatearNumero(this.getDistanciaRecorridaInicial()) + " mts");

		// Mostramos penalizaciones.
		mostrarMensajePenalizaciones();

		// Mostrar mensaje de turbo.
		mostrarMensajeTurbo();

		// Mostrar avance con penalizaciones aplicadas.
		System.out.println("\n ⏭️ Total recorrido: " + ElementosIU.TEXTO_NEGRITA + FormatearNumero.formatearNumero(distancia) + ElementosIU.RESET + " " + unidadDistancia);
		System.out.println(System.lineSeparator());
		ElementosIU.mostrarSeparador2();

	}

	// Función para mostrar el mensaje de penalizaciones.
	private void mostrarMensajePenalizaciones() {
		if(penalizacionTormentaElectrica > 1 && penalizacionTormentaElectricaActiva()) {
			System.out.println(" 🌩️ Descarga: " + ElementosIU.ROJO_CLARO + "x" + penalizacionTormentaElectrica + ElementosIU.RESET + " !");
		}
		if (this.penalizacionViento > 0 && clima.getTipoViento().equals("Muy Fuerte") || this.penalizacionViento > 0 && clima.getTipoViento().equals("Fuerte")) {
			System.out.println(" 🌬️ Viento: " + ElementosIU.ROJO_CLARO + "-" + FormatearNumero.formatearNumero(this.getPenalizacionViento()) + ElementosIU.RESET + " mts");
		}
		if (this.penalizacionAgarre > 0) {
			System.out.println(" 🛞 Agarre: " + ElementosIU.ROJO_CLARO + "-" + FormatearNumero.formatearNumero(this.getPenalizacionAgarre()) + ElementosIU.RESET + " mts");
		}
		if(this.penalizacionDerrape > 0 && this.isDerrape()) {
			System.out.println(" 🔄 Derrape: " + ElementosIU.ROJO_CLARO + "-" + FormatearNumero.formatearNumero(this.getPenalizacionDerrape()) + ElementosIU.RESET + " mts");
		}
		if (this.penalizacionLluvia > 0) {
			System.out.println(" 🌧️ Lluvia: " + ElementosIU.ROJO_CLARO + "-" + FormatearNumero.formatearNumero(this.getPenalizacionLluvia()) + ElementosIU.RESET + " mts");
		}
		if(this.penalizacionNiebla > 0 && clima.getClima().equals("Niebla")) {
			System.out.println(" 🌫️ Niebla: " + ElementosIU.ROJO_CLARO + "-" + FormatearNumero.formatearNumero(this.getPenalizacionNiebla()) + ElementosIU.RESET + " mts");
		}
	}

	// Mostrar mensaje de turbo.
	private void mostrarMensajeTurbo() {
		if (this.bonificacionTurbo > 0 && turboActivado()) {
			System.out.println(" 🚀 Turbo: " + ElementosIU.VERDE_CLARO + "+" + FormatearNumero.formatearNumero(this.getBonificacionTurbo()) + ElementosIU.RESET + " mts");
		}
	}

	// Mensaje cuando el vehiculo está arrancando.
	private void mostrarMensajeArranque() {
		System.out.println("\n 💨 Arrancando: (" + this.getTipoJugador() + ") ¡" + this.getNombreCompleto() + " está arrancando!");
	}

	// Comprobar si el vehículo ha cruzado la meta.
	private boolean comprobarCruceMeta(double distanciaMeta) {
		if (this.distanciaRecorridaFinal >= distanciaMeta) {
			// Actualizar atributo.
			this.meta = true;
			
			System.out.println(System.lineSeparator());
			System.out.println(" 🏁 Meta: (" + this.getTipoJugador() + ") " + this.getNombreCompleto() + " ha cruzado la meta.");
			System.out.println(System.lineSeparator());
			ElementosIU.mostrarSeparador();
			ElementosIU.mostrarSaltoLinea();
			System.out.println(ElementosIU.TEXTO_NEGRITA + " CARRERA FINALIZADA\n" + ElementosIU.RESET + "\n");
			System.out.println(ElementosIU.TEXTO_NEGRITA + ElementosIU.AMARILLO + " 🏆 Ganador: " + ElementosIU.RESET + "(" + this.getTipoJugador() + ") ¡" + this.getNombreCompleto() + "!");
			System.out.println(System.lineSeparator());
			executorService.shutdown();
			return true;
		}

		return false;
	}

	// CARRERA
	@Override
	public void run() {
		Tiempo tiempoTranscurrido = new Tiempo(0);
		long tiempoEspera = calcularTiempoEspera();

		while (this.getDistanciaRecorridaFinal() < circuito.getDistanciaMeta()) {

			this.distanciaRecorridaFinal = this.avanceVehiculo(tiempoTranscurrido.getTiempo());

			// Esperar tiempo entre cada iteración.
			try {
				Thread.sleep(tiempoEspera); // milisegundos.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Sincronizar el acceso al método gestionarAvance.
			synchronized (lockImpresion) {
				// Avance del vehículo.
				gestionarAvance(tiempoTranscurrido);
			}

			// Verificar si el vehículo ha cruzado la meta.
			if (comprobarCruceMeta(circuito.getDistanciaMeta())) {
				System.exit(0);
				break;
			}

			// Incrementar el tiempo transcurrido.
			tiempoTranscurrido.incrementarTiempo(1); // 1 segundo.

		}

	}

	// Función para mostrar la información del vehículo.
	public void mostrarInformacion() {
		System.out.println(" Tipo:			" + this.getTipo());
		System.out.println(" Color:			" + this.getColor());
		System.out.println(" Velocidad:		" + this.getVelocidad());
		System.out.println(" Aceleración:		" + this.getAceleracion());
		System.out.println(" Peso:			" + this.getPeso());
		System.out.println(" Manejo:		" + this.getManejo());
		System.out.println(" Agarre:		" + this.getAgarre());
		System.out.println(" Turbo:			" + this.getTurbo());
	}

}
