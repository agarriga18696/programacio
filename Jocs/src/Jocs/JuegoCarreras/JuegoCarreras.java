package Jocs.JuegoCarreras;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JuegoCarreras {
	private static Scanner cin = new Scanner(System.in);
	// Variable para esperar un tiempo (pausa).
	private static long esperarTiempo = 1200; // milisegundos.
	// Generar circuito.
	private static Circuito circuito = new Circuito();
	// Generar clima.
	private static Clima clima = new Clima();
	// Número máximo de vehículos IA permitidos.
	private final static int MAX_VEHICULOS_IA = 4;

	// Función Main.
	public static void main(String[] args) {
		boolean salir = false;

		do {
			salir = menuPrincipal();
		} while(!salir);

	}

	// Función para mostrar el menú principal.
	private static boolean menuPrincipal() {
		int opcion;

		ElementosIU.mostrarSeparador();
		ElementosIU.mostrarSaltoLinea();
		System.out.println(ElementosIU.TEXTO_NEGRITA + " MENÚ PRINCIPAL\n" + ElementosIU.RESET);
		System.out.println(" (1) Jugar");
		System.out.println(" (2) Taller");
		System.out.println(" (3) Logros");
		System.out.println(" (4) Ayuda");
		System.out.println(" (5) Salir");
		System.out.print("\n Opción: ");

		opcion = opcionMenu(" Opción: ");

		switch(opcion) {
		case 1:
			modoJugar();
			break;
		case 4:
			ManualUsuario.modoManual();
			break;
		case 5:
			System.out.println("\n ¡Hasta la próxima!\n");
			return true;
		default:
			System.err.println(ElementosIU.TEXTO_NEGRITA + "\n 🚫 Error: " + ElementosIU.RESET + "Opción no válida.\n");
			break;
		}

		return false;
	}

	// Función para controlar las opciones de los menús.
	public static int opcionMenu(String mensajeError) {
		int opcion;

		do {
			if(cin.hasNextInt()) {
				opcion = cin.nextInt();
				cin.nextLine();
				return opcion;
			} else {
				ElementosIU.mostrarSaltoLinea();
				ElementosIU.mostrarSeparador2();
				System.err.println(ElementosIU.TEXTO_NEGRITA + "\n 🚫 Error: " + ElementosIU.RESET + "Opción no válida.\n");
				System.out.print(mensajeError);
				cin.nextLine();
			}
		} while(true);
	}

	// Función de modo Un Jugador.
	public static void modoJugar() {
		int opcion = 0;

		ElementosIU.mostrarSaltoLinea();
		ElementosIU.mostrarSeparador();
		ElementosIU.mostrarSaltoLinea();
		System.out.println(ElementosIU.TEXTO_NEGRITA + " NUEVA CARRERA\n" + ElementosIU.RESET);

		Vehiculo[] jugadoresIA = new Vehiculo[0];
		Vehiculo jugador = null;

		do {
			Tiempo.esperarTiempo(10);
			System.out.print(" Número de vehículos IA (máx. " + MAX_VEHICULOS_IA + "): ");
			
			try {
				opcion = opcionMenu(" Número de vehículos IA (máx. " + MAX_VEHICULOS_IA + "): ");
				// Array para guardar a los jugadores IA.
				jugadoresIA = nuevoVehiculoIA(opcion);
				// Crear vehículo del jugador y verificar duplicados.
				jugador = nuevoVehiculoJugador();
				
			} catch (IllegalArgumentException e) {
				System.err.println(ElementosIU.TEXTO_NEGRITA + "\n 🚫 Error: " + ElementosIU.RESET + e.getMessage());
				
				continue;  // Reiniciar el bucle si hay un error.
			}
		} while (opcion <= 0 || opcion > MAX_VEHICULOS_IA || vehiculoRepetido(jugador, jugadoresIA));

		// Mostrar información de los vehículos IA y del jugador.
		mostrarInformacionVehiculosIA(jugadoresIA);
		mostrarInformacionVehiculoJugador(jugador);

		ElementosIU.esperarTecla("generar el circuito", cin);
		// Mostrar info del circuito.
		mostrarInformacionCircuito();
		ElementosIU.esperarTecla("generar el clima", cin);
		// Mostrar info del circuito.
		mostrarInformacionClima();
		ElementosIU.esperarTecla("mostrar la parrilla de salida", cin);
		mostrarParrillaSalida(jugadoresIA, jugador);
	}

	// Función para generar el vehículo del jugador.
	private static Vehiculo nuevoVehiculoJugador() {
		Vehiculo jugador = new Vehiculo(circuito, clima, false);

		return jugador;
	}

	// Función para generar los vehículos de la IA.
	private static Vehiculo[] nuevoVehiculoIA(int numJugadoresIA) {
		if (numJugadoresIA < 1) {
			throw new IllegalArgumentException("Tienes que competir contra al menos 1 Jugador IA.\n");
		} else if (numJugadoresIA > MAX_VEHICULOS_IA) {
			throw new IllegalArgumentException("El número de Jugadores IA sobrepasa el límite.\n");
		}

		Vehiculo[] jugadoresIA = new Vehiculo[numJugadoresIA];

		// Utilizar un conjunto para almacenar combinaciones únicas de tipo y color y evitar tener
		// vehículos repetidos.
		Set<String> combinacionesUnicas = new HashSet<>();

		for (int i = 0; i < numJugadoresIA; i++) {

			Vehiculo jugadorIA = null;

			do {

				// Crear un nuevo vehículo.
				jugadorIA = new Vehiculo(circuito, clima, true);

				// Crear una cadena única que represente la combinación de tipo y color.
				String combinacion = jugadorIA.getTipo() + jugadorIA.getColor();

				// Comprobar si la combinación ya existe en el conjunto.
				if (!combinacionesUnicas.contains(combinacion)) {
					combinacionesUnicas.add(combinacion);
					break; // Salir del bucle si la combinación es única.
				}
				// Si la combinación ya existe, generar un nuevo vehículo.
			} while (true);

			jugadoresIA[i] = jugadorIA;
		}

		return jugadoresIA;
	}

	// Función para verificar si el vehículo del jugador se repite con alguno de la IA.
	private static boolean vehiculoRepetido(Vehiculo jugador, Vehiculo[] jugadoresIA) {
		
		try {
			for (Vehiculo vehiculoIA : jugadoresIA) {
				if (jugador.equals(vehiculoIA)) {
					System.err.println(ElementosIU.TEXTO_NEGRITA + "\n 🚫 Error: " + ElementosIU.RESET + "El vehículo del Jugador se repite con un vehículo de la IA.\n");
					ElementosIU.mostrarSaltoLinea();
					
					System.out.println(" ⏳ Generando de nuevo... " + ElementosIU.generarFraseEspera("vehiculo") + "\n");
					
					return true;
				}
			}
		} catch(NullPointerException e) {
			System.err.println(ElementosIU.TEXTO_NEGRITA + "\n 🚫 Error: " + ElementosIU.RESET + e.getMessage() + ".\n");
		}
		
		return false;
	}

	// Función para mostrar los vehículos de la IA.
	private static void mostrarInformacionVehiculoJugador(Vehiculo jugador) {

		// Mostrar información del Vehículo del Jugador.
		ElementosIU.esperarTecla("generar el vehículo del jugador", cin);
		ElementosIU.mostrarSaltoLinea();
		System.out.println(" ⏳ Generando vehículo del Jugador... " + ElementosIU.generarFraseEspera("vehiculo") + "\n");
		Tiempo.esperarTiempo(esperarTiempo);
		ElementosIU.mostrarSeparador2();
		ElementosIU.mostrarSaltoLinea();
		System.out.println(ElementosIU.TEXTO_NEGRITA + " VEHÍCULO JUGADOR\n" + ElementosIU.RESET);
		jugador.mostrarInformacion();
		ElementosIU.mostrarSaltoLinea();
	}

	// Función para mostrar los vehículos de la IA.
	private static void mostrarInformacionVehiculosIA(Vehiculo[] jugadores) {

		ElementosIU.mostrarSaltoLinea();

		// Mostrar información de los Vehículos IA.
		for (int i = 0; i < jugadores.length; i++) {
			ElementosIU.mostrarSaltoLinea();
			System.out.println(" ⏳ Generando vehículo de IA (" + (i+1) +")... " + ElementosIU.generarFraseEspera("vehiculo") + "\n");
			Tiempo.esperarTiempo(esperarTiempo);
			ElementosIU.mostrarSeparador2();
			ElementosIU.mostrarSaltoLinea();
			System.out.println(ElementosIU.TEXTO_NEGRITA + " VEHÍCULO IA (" + (i+1) + ")\n" + ElementosIU.RESET);
			jugadores[i].mostrarInformacion();
			ElementosIU.mostrarSaltoLinea();
		}
	}

	// Función para mostrar la información del circuito.
	private static void mostrarInformacionCircuito() {

		// Mostrar información del circuito.
		ElementosIU.mostrarSaltoLinea();
		System.out.println(" ⏳ Generando circuito... " + ElementosIU.generarFraseEspera("circuito") + "\n");
		Tiempo.esperarTiempo(esperarTiempo);
		circuito.mostrarInformacionCircuito();
	}

	// Función para mostrar la información del clima.
	private static void mostrarInformacionClima() {

		// Mostrar información del clima.
		ElementosIU.mostrarSaltoLinea();
		System.out.println(" ⏳ Generando clima... " + ElementosIU.generarFraseEspera("clima") + "\n");
		Tiempo.esperarTiempo(esperarTiempo);
		clima.mostrarInformacionClima();
	}

	// Función para mostrar un resumen de los datos de la partida (antes de la carrera).
	private static void mostrarParrillaSalida(Vehiculo[] jugadoresIA, Vehiculo jugador) {
		Vehiculo[] jugadoresTotal = new Vehiculo[jugadoresIA.length + 1];

		for(int i = 0; i < jugadoresIA.length; i++) {
			jugadoresTotal[i] = jugadoresIA[i];
		}

		jugadoresTotal[jugadoresIA.length] = jugador; // último índice.

		ElementosIU.mostrarSeparador2();
		ElementosIU.mostrarSaltoLinea();
		System.out.println(ElementosIU.TEXTO_NEGRITA + " PARRILLA DE SALIDA\n" + ElementosIU.RESET);
		for(int i = 0; i < jugadoresTotal.length; i++) {
			System.out.println(" [" + (i+1) + "] " + jugadoresTotal[i].getNombreCompleto() + " (" + jugadoresTotal[i].getTipoJugador() + ")");
			Tiempo.esperarTiempo(esperarTiempo / 2);
		}

		ElementosIU.mostrarSaltoLinea();
		ElementosIU.esperarTecla("para iniciar la carrera", cin);
		iniciarCarrera(jugadoresTotal);

	}

	// Función para iniciar la carrera.
	private static void iniciarCarrera(Vehiculo[] jugadoresTotal) {

		ElementosIU.mostrarSaltoLinea();
		ElementosIU.mostrarSeparador();
		ElementosIU.mostrarSaltoLinea();
		System.out.println(ElementosIU.TEXTO_NEGRITA + " INICIO CARRERA\n" + ElementosIU.RESET);

		System.out.println(Alertas.alertasPenalizaciones(circuito, clima));

		System.out.println(" 🚥 Arrancando motores...\n");

		// Iniciar la carrera.
		for(Vehiculo jugador : jugadoresTotal) {
			jugador.start();
		}

		// Esperar a que todos los jugadores hayan terminado la carrera.
		try {
			for(Vehiculo jugador : jugadoresTotal) {
				jugador.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
