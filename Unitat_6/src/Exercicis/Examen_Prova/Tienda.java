package Exercicis.Examen_Prova;

import java.util.Scanner;

public class Tienda {

	private static Electrodomestico[][] electrodomesticos = new Electrodomestico[2][30];
	private static int[][] contE = new int[2][1];
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("TIENDA DE ELECTRODOMÉSTICOS\n");
		System.out.println("(1) Nuevo electrodoméstico");
		System.out.println("(2) Mostrar todas las neveras");
		System.out.println("(3) Mostrar todas las lavadoras");
		System.out.println("(4) Mostrar todos los electrodomésticos");
		System.out.println("(5) Mostrar cuántos electrodomésticos hay de cada tipo y el número total de"
				+ "electrodomésticos");
		System.out.println("(6) Mostrar el precio sumado de todas las neveras");
		System.out.println("(7) Mostrar el precio sumado de todas las lavadoras");
		System.out.println("(8) Mostrar el precio sumado de todos los electrodomésticos");
		System.out.println("(9) Enviar un electrodoméstico a reparar");
		System.out.println("(10) Salir");
		
	}
	
	private static void menu() {
		
		int opcion = 0;
		
		while(opcion != 10) {
			
			switch(opcion) {
			case 1:
				nuevoElectrodomestico();
				break;
			case 2:
				break;
			case 3:
				mostrarListado();
				break;
			}
			
		}
		
	}

	// Método para crear electrodoméstico según tipo.
	public static void nuevoElectrodomestico() {

		System.out.println("\nNUEVO ELECTRODOMÉSTICO\n");
		System.out.print("Nevera o lavadora: ");
		String tipo = in.nextLine().toLowerCase().trim();

		Nevera nevera = null;
		Lavadora lavadora = null;

		String marca = null;
		int consumo = 0;
		double precio = 0;

		switch(tipo) {
		case "nevera":
			
			// Asignar atributos.
			System.out.print("\nMarca: ");
			marca = in.nextLine().trim();

			System.out.print("\nConsumo: ");
			consumo = in.nextInt();
			in.nextLine();

			System.out.print("\nCongelador (true / false): ");
			boolean congelador = in.nextBoolean();
			in.nextLine();

			System.out.print("\nPrecio: ");
			precio = in.nextDouble();
			in.nextLine();

			// Añadir objeto a la lista.
			electrodomesticos[0][contE[0][0]] = new Nevera(marca, consumo, congelador, precio);
			contE[0][0]++;
			
			System.out.println("Nevera añadida correctamente");
			break;
		case "lavadora":
			
			// Asignar atributos.
			System.out.print("\nMarca: ");
			marca = in.nextLine().trim();

			System.out.print("\nConsumo: ");
			consumo = in.nextInt();
			in.nextLine();

			System.out.print("\nCapacidad tambor: ");
			int capacidadT = in.nextInt();
			in.nextLine();

			System.out.print("\nPrecio: ");
			precio = in.nextDouble();
			in.nextLine();

			// Añadir objeto a la lista.
			electrodomesticos[1][contE[1][0]] = new Lavadora(marca, consumo, capacidadT, precio);
			contE[1][0]++;
			
			System.out.println("Lavadora añadida correctamente");
			break;
		default:
			System.out.println("No reconozco el electrodoméstico '" + tipo + "'.");
			break;
		}

	}

	public static void mostrarListado() {

		// Mostrar neveras.
		System.out.println("\nNEVERAS [" + contE[0][0] + "]:");
		for(int i = 0; i < contE[0][0]; i++) {
			Electrodomestico nevera = electrodomesticos[0][i];

			System.out.println(nevera.toString());
		}

		// Mostrar lavadoras.
		System.out.println("\nLAVADORAS [" + contE[1][0] + "]:");
		for(int i = 0; i < contE[1][0]; i++) {
			Electrodomestico lavadora = electrodomesticos[1][i];

			System.out.println(lavadora.toString());
		}

		System.out.println("\nTOTAL ELECTRODOMÉSTICOS [" + (contE[0][0] + contE[1][0]) + "]");

	}


}
