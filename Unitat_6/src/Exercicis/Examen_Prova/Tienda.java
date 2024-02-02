package Exercicis.Examen_Prova;

import java.util.Random;
import java.util.Scanner;

public class Tienda {

	private static Electrodomestico[][] inventario = new Electrodomestico[2][30];
	private static int[][] contE = new int[2][1];
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		menu();

	}

	// Método para mostrar el menú principal.
	private static void menu() {
		int opcion = 0;

		while(opcion != 10) {

			System.out.println(System.lineSeparator());
			System.out.println(" TIENDA DE ELECTRODOMÉSTICOS\n");
			System.out.println(" (1) Nuevo electrodoméstico");
			System.out.println(" (2) Mostrar electrodoméstico");
			System.out.println(" (3) Enviar un electrodoméstico a reparar");
			System.out.println(" (4) Salir");

			opcion = validarInt("Opción");

			switch(opcion) {
			case 1:
				nuevoElectrodomestico();
				break;
			case 2:
				mostrarElectrodomestico();
				break;
			case 3:
				repararElectrodomestico();
				break;
			case 4:
				salir();
				break;
			}

		}

	}

	// Método para crear electrodoméstico según tipo.
	public static void nuevoElectrodomestico() {

		System.out.println(System.lineSeparator());
		System.out.println(" NUEVO ELECTRODOMÉSTICO");

		boolean eValido = false;

		while(!eValido) {
			String tipo = validarString("Nevera / Lavadora").toLowerCase();

			String modelo = null;
			int consumo = 0;
			double precio = 0;

			switch(tipo) {
			case "nevera":
				System.out.println("\n NUEVA NEVERA");

				// Asignar atributos.
				modelo = validarString("Modelo");
				consumo = validarInt("Consumo");
				boolean congelador = validarBoolean("Congelador (true/false)");
				precio = validarDouble("Precio");

				// Añadir objeto a la lista.
				inventario[0][contE[0][0]] = new Nevera(modelo, consumo, congelador, precio);
				contE[0][0]++;

				System.out.println("\n Nevera añadida correctamente");
				eValido = true;
				break;
			case "lavadora":
				System.out.println("\n NUEVA LAVADORA");

				// Asignar atributos.
				modelo = validarString("Modelo");
				consumo = validarInt("Consumo");
				int capacidadT = validarInt("Capacidad tambor");
				precio = validarDouble("Precio");

				// Añadir objeto a la lista.
				inventario[1][contE[1][0]] = new Lavadora(modelo, consumo, capacidadT, precio);
				contE[1][0]++;

				System.out.println("\n Lavadora añadida correctamente");
				eValido = true;
				break;
			default:
				System.err.println("\n No reconozco el electrodoméstico '" + tipo + "'.");
				break;
			}
		}

	}

	// Método para mostrar todos los electrodomésticos.
	public static void mostrarElectrodomestico() {

		System.out.println(System.lineSeparator());
		System.out.println(" MOSTRAR ELECTRODOMÉSTICO");

		boolean eValido = false;

		while(!eValido) {
			String tipo = validarString("Nevera / Lavadora / Todos").toLowerCase();

			switch(tipo) {
			case "nevera":
				eValido = true;
				mostrarNeveras();
				break;
			case "lavadora":
				eValido = true;
				mostrarLavadoras();
				break;
			case "todos":
				eValido = true;
				mostrarTodosElectrodomesticos();
				break;
			default:
				System.err.println("\n No reconozco el electrodoméstico '" + tipo + "'.");
				break;
			}
		}

	}

	// Método para mostrar todas las neveras.
	public static void mostrarNeveras() {
		System.out.println(System.lineSeparator());
		System.out.println(" NEVERAS [" + contE[0][0] + "]");

		if(contE[0][0] <= 0) {
			System.out.println("\n No hay ninguna nevera para mostrar.");

		} else {

			double precioT = 0;

			for(int i = 0; i < contE[0][0]; i++) {
				Electrodomestico nevera = inventario[0][i];
				precioT += nevera.getPrecio();

				System.out.println(nevera.toString());
			}

			System.out.println("\n\n PRECIO TOTAL NEVERAS [" + precioT + " €]");

		}
	}

	// Método para mostrar todas las lavadoras.
	public static void mostrarLavadoras() {
		System.out.println(System.lineSeparator());
		System.out.println(" LAVADORAS [" + contE[1][0] + "]");

		if(contE[1][0] <= 0) {
			System.out.println("\n No hay ninguna lavadora para mostrar.");

		} else {
			double precioT = 0;

			for(int i = 0; i < contE[1][0]; i++) {
				Electrodomestico lavadora = inventario[1][i];
				precioT += lavadora.getPrecio();

				System.out.println(lavadora.toString());
			}

			System.out.println("\n\n PRECIO TOTAL LAVADORAS [" + precioT + " €]");

		}
	}

	// Método para mostrar todos los electrodomésticos.
	public static void mostrarTodosElectrodomesticos() {
		System.out.println(System.lineSeparator());
		System.out.println(" TOTAL ELECTRODOMÉSTICOS [" + (contE[0][0] + contE[1][0]) + "]");

		mostrarNeveras();
		mostrarLavadoras();

		double precioT = 0;

		if(contE[0][0] > 0) {
			for(int i = 0; i < contE[0][0]; i++) {
				Electrodomestico n = inventario[0][i];

				// Verificar que no sea null para evitar errores de ejecución.
				if(n != null) {
					precioT += n.getPrecio();
				}
			}
		}

		if(contE[1][0] > 0) {
			for(int i = 0; i < contE[1][0]; i++) {
				Electrodomestico l = inventario[1][i];

				// Verificar que no sea null para evitar errores de ejecución.
				if(l != null) {
					precioT += l.getPrecio();
				}
			}
		}

		if(contE[0][0] > 0 || contE[1][0] > 0) {
			System.out.println("\n\n PRECIO TOTAL ELECTRODOMÉSTICOS [" + precioT + " €]");
		}

	}

	// Método para enviar a un electrodoméstico a reparar.
	private static void repararElectrodomestico() {

		System.out.println(System.lineSeparator());
		System.out.println(" REPARAR ELECTRODOMÉSTICO");

		Electrodomestico eReparar = null;
		boolean eValido = false;
		String modelo = null;
		double pReparacion = 0; // precio de la reparación.
		int tReparacion = new Random().nextInt(10) + 1; // Generar tiempo de reparación aleatorio entre 1 y 10.
		int idElectrodomestico = 0;

		while(!eValido && contE[0][0] > 0 || !eValido && contE[1][0] > 0) {
			modelo = validarString("Modelo");

			// Comprobar si es una nevera.
			if(modelo != null && !modelo.isBlank() && contE[0][0] > 0) {
				for(int i = 0; i < contE[0][0]; i++) {
					Electrodomestico n = inventario[0][i];
					if(modelo.equalsIgnoreCase(n.getModelo())) {
						eReparar = n;
						pReparacion = ((Nevera)eReparar).reparar(5);
						idElectrodomestico = i;
						eValido = true;
						break; // salir del bucle for.
					}
				}
				break; // salir del bucle while.
				
			} else if(modelo != null && !modelo.isBlank() && contE[1][0] > 0) {
				// Comprobar si es una lavadora.
				for(int i = 0; i < contE[1][0]; i++) {
					Electrodomestico l = inventario[1][i];
					if(modelo.equalsIgnoreCase(l.getModelo())) {
						eReparar = l;
						pReparacion = ((Lavadora)eReparar).reparar(5);
						idElectrodomestico = i;
						eValido = true;
						break; // salir del bucle for.
					}
				}
			}
			
			if(!eValido) {
				System.out.println("\n No se ha encontrado el electrodoméstico '" + modelo + "'.");
				continue; // repetir bucle while.
			}
		}
		
		if(!eValido) {
			System.out.println("\n No se ha encontrado ningún electrodoméstico para reparar.");
			
		} else {
			System.out.println("\n Se ha enviado a reparar el electrodoméstico nº " + idElectrodomestico + " durante " + tReparacion + "h y ha costado " + pReparacion + " €.");
		}

	}

	// Método para salir del programa.
	private static void salir() {
		System.out.println(System.lineSeparator());
		System.out.println(" ¡Hasta pronto!");
		System.exit(0);
	}

	// Método para validar un int.
	private static int validarInt(String m) {
		int n = 0;
		boolean valorValido = false;

		while(!valorValido) {
			System.out.print("\n " + m + ": ");

			if(in.hasNextInt()) {
				n = in.nextInt();
				in.nextLine();
				valorValido = true;
				break;

			} else {
				System.err.println("\n Valor 'int' no válido.");
				in.nextLine();
			}
		}

		return n;
	}

	// Método para validar un double.
	private static double validarDouble(String m) {
		double d = 0;
		boolean valorValido = false;

		while(!valorValido) {
			System.out.print("\n " + m + ": ");

			if(in.hasNextDouble()) {
				d = in.nextDouble();
				in.nextLine();
				valorValido = true;
				break;

			} else {
				System.err.println("\n Valor 'double' no válido.");
				in.nextLine();
			}
		}

		return d;
	}

	// Método para validar un String.
	private static String validarString(String m) {
		String s = null;
		boolean valorValido = false;

		while(!valorValido) {
			System.out.print("\n " + m + ": ");

			if(in.hasNextLine()) {
				s = in.nextLine().trim();
				valorValido = true;
				break;

			} else {
				System.err.println("\n Valor 'String' no válido.");
				in.nextLine();
			}
		}

		return s;
	}

	// Método para validar un boolean.
	private static boolean validarBoolean(String m) {
		boolean b = false;
		boolean valorValido = false;

		while(!valorValido) {
			System.out.print("\n " + m + ": ");

			if(in.hasNextBoolean()) {
				b = in.nextBoolean();
				in.nextLine();
				valorValido = true;
				break;

			} else {
				System.err.println("\n Valor 'boolean' no válido.");
				in.nextLine();
			}
		}

		return b;
	}


}
