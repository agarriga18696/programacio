package Jocs.JuegoCarreras;

import java.util.Scanner;

// Elementos de la Interfaz de Usuario.
public class ElementosIU {

	// Colores ANSI.
	public static final String RESET = "\u001B[0m";
	public static final String NEGRO = "\u001B[30m";
	public static final String ROJO = "\u001B[31m";
	public static final String VERDE = "\u001B[32m";
	public static final String AMARILLO = "\u001B[33m";
	public static final String AZUL = "\u001B[34m";
	public static final String MORADO = "\u001B[35m";
	public static final String CIAN = "\u001B[36m";
	public static final String BLANCO = "\u001B[37m";

	// Colores claros.
	public static final String ROJO_CLARO = "\u001B[91m";
	public static final String VERDE_CLARO = "\u001B[92m";
	public static final String AZUL_CLARO = "\u001B[94m";
	public static final String CIAN_CLARO = "\u001B[96m";
	public static final String AMARILLO_CLARO = "\u001B[93m";
	public static final String MORADO_CLARO = "\u001B[95m";
	public static final String BLANCO_CLARO = "\u001B[97m";

	// Estilos de texto.
	public static final String TEXTO_NEGRITA = "\u001B[1m";
	public static final String TEXTO_SUBRAYADO = "\u001B[4m";

	// Separador para opciones de menú y secuencias principales.
	public static void mostrarSeparador() {
		System.out.println("=============================================================================");
	}

	// Separador para opciones y secuencias secundarias.
	public static void mostrarSeparador2() {
		System.out.println("-----------------------------------------------------------------------------");
	}

	public static void mostrarSaltoLinea() {
		System.out.println();
	}

	// Función para tener que pulsar una tecla para continuar.
	public static void esperarTecla(String mensaje, Scanner cin) {
		mostrarSeparador2();
		System.out.print("\n 🕹️ Pulsa " + TEXTO_NEGRITA + "Enter" + RESET + " para " + mensaje + ".\n");
	    // Esperar a que el usuario pulse Enter.
	    cin.nextLine();
	}

	// Función para generar frases aleatorias durante una espera.
	public static String generarFraseEspera(String tipo) {
		String frase = ""; // no inicializar como null para que no muestre 'null' por pantalla si se da el caso.

		// Frases para 'vehiculo'.
		String frasesVehiculo[] = {
				"eligiendo el modelo",
				"seleccionando el color",
				"comprobando la presión de los neumáticos",
				"calibrando los frenos",
				"comprobando la suspensión",
				"ajustando los espejos",
				"ajustando la dirección",
				"calibrando el panel de instrumentos",
				"eligiendo la tapicería",
				"últimos retoques"
		};

		// Frases para 'circuito'.
		String frasesCircuito[] = {
				"estableciendo la mejor ruta",
				"comprobando el terreno",
				"midiendo la distancia",
				"instalando protecciones en las curvas",
				"limpiando la pista"
		};

		// Frases para 'clima'.
		String frasesClima[] = {
				"calculando la presión atmosférica",
				"midiendo la velocidad del viento",
				"comprobando el nivel de humedad",
				"comprobando la previsión meteorológica",
				"ajustando el pararrayos",
		};

		switch(tipo) {
		case "vehiculo":
			frase = frasesVehiculo[NumeroAleatorio.generarNumeroIntAleatorio(0, frasesVehiculo.length - 1)];
			break;
		case "circuito":
			frase = frasesCircuito[NumeroAleatorio.generarNumeroIntAleatorio(0, frasesCircuito.length - 1)];
			break;
		case "clima":
			frase = frasesClima[NumeroAleatorio.generarNumeroIntAleatorio(0, frasesClima.length - 1)];
			break;
		default:
			frase = "preparándolo todo";
		}

		return frase + "...";

	}

}
