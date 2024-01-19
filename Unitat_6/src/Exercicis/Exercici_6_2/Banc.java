package Exercicis.Exercici_6_2;

import java.util.Scanner;

public class Banc {

	private static Scanner in = new Scanner(System.in);
	private static CompteBancari[] comptes = new CompteBancari[30];
	private static int numComptes = 0;
	private static String dniActual = null;

	public static void main(String[] args) {
		int opcioMenu = 0;

		do {
			// Opcions del menú.
			System.out.println("BANC");
			System.out.println("(1) Crear nou compte.");
			System.out.println("(2) Iniciar sessió.");
			System.out.println("(3) Sortir.");
			System.out.print("Introdueix una opció: ");

			if(in.hasNextInt()) {
				opcioMenu = in.nextInt();
				in.nextLine();

				switch(opcioMenu) {
				case 1:
					nouCompte();
					break;
				case 2:
					if(numComptes == 0) {
						System.out.println("No s'ha trobat cap compte al sistema.");
						System.out.println("Has de crear un compte abans de realitzar una operació.\n");
					} else {
						iniciSessió();
					}
					break;
				case 3: // Sortir.
					System.out.println("Sortint del programa...");
					break;
				default:
					System.out.println("Opció no vàlida.\n");
					break;
				}
			} else {
				System.out.println("Valor no vàlid.\n");
				in.nextLine();
			}

		} while(opcioMenu != 3);

	}

	// Mètode per mostrar segon menú al entrar al compte.
	private static void iniciSessió() {
		String dni = null;
		int opcioMenu = 0;
		boolean dniValid = false;

		// Demanar DNI.
		dni = demanarDni();
		dniActual = dni;

		for(int i = 0; i < numComptes; i++) {
			if(dni.equals(comptes[i].getDniTitular())){
				dniValid = true;
				break;
			}
		}

		if(dniValid) {
			do {
				// Opcions del menú.
				System.out.println();
				System.out.println("Benvingut/da " + dniActual + " al sistema.");
				System.out.println("(1) Ingressar diners.");
				System.out.println("(2) Treure diners.");
				System.out.println("(3) Veure saldo.");
				System.out.println("(4) Tancar sessió.");
				System.out.print("Introdueix una opció: ");

				if(in.hasNextInt()) {
					opcioMenu = in.nextInt();
					in.nextLine();

					switch(opcioMenu) {
					case 1:
						if(numComptes == 0) {
							System.out.println("Has de crear un compte abans de realitzar una operació.\n");
						} else {
							ingressar();
						}
						break;
					case 2:
						if(numComptes == 0) {
							System.out.println("Has de crear un compte abans de realitzar una operació.\n");
						} else {
							reintegrar();
						}
						break;
					case 3:
						if(numComptes == 0) {
							System.out.println("Has de crear un compte abans de realitzar una operació.\n");
						} else {
							veureSaldo();
						}
						break;
					case 4:
						System.out.println();
						// Sortir.
						break;
					default:
						System.out.println("Opció no vàlida.\n");
						break;
					}
				} else {
					System.out.println("Valor no vàlid.\n");
					in.nextLine();
				}

			} while(opcioMenu != 4);
		} else {
			System.out.println("El compte introduït no es troba al sistema.\n");
		}

	}

	// Mètode per demanar DNI.
	private static String demanarDni() {
		String dni = null;
		boolean dniValid = false;

		while(!dniValid) {
			// Demanar DNI.
			System.out.print("Introdueixi el DNI del titular: ");
			dni = in.nextLine().toUpperCase().trim();

			// Validar DNI.
			dniValid = validarDni(dni);

			if(dniValid) {
				break;
			}

		}

		return dni;
	}

	// Mètode per validar el Dni.
	private static boolean validarDni(String dni) {
		if(dni.length() != 9 || !Character.isLetter(dni.charAt(8))) {
			System.out.println("DNI no vàlid.");
			return false;
		}

		return true;
	}

	// Mètode per crear un nou compte.
	private static void nouCompte() {
		String dni = null, nom = null;
		double saldo = 0;

		dni = demanarDni();

		// Demanar NOM.
		System.out.print("Introdueixi el NOM del titular: ");
		nom = in.nextLine().toUpperCase().trim();

		// Demanar SALDO.
		System.out.print("Introdueixi el SALDO: ");
		saldo = in.nextDouble();

		comptes[numComptes] = new CompteBancari(dni, nom, saldo);
		numComptes++;

		System.out.println("Operació realitzada amb èxit.\n");

	}

	// Mètode per ingressar diners al compte.
	private static void ingressar() {
		double quantitat = 0;

		// Demanar QUANTITAT a ingressar.
		System.out.print("Introdueix la quantitat a ingressar: ");
		quantitat = in.nextDouble();

		for(int i = 0; i < numComptes; i++) {
			comptes[i].setSaldo(comptes[i].getSaldo() + quantitat);
		}

		System.out.println("Operació realitzada amb èxit.\n");

	}

	// Mètode per treure diners del compte.
	private static void reintegrar() {
		double quantitat = 0;

		// Demanar QUANTITAT a retirar.
		System.out.print("Introdueix la quantitat a retirar: ");
		quantitat = in.nextDouble();

		for(int i = 0; i < numComptes; i++) {
			if((comptes[i].getSaldo() - quantitat) < comptes[i].getSaldo()) {
				System.out.println("No s'ha pogut realitzar l'operació. Saldo insuficient.");
			} else {
				comptes[i].setSaldo(comptes[i].getSaldo() - quantitat);
				System.out.println("Operació realitzada amb èxit.\n");
			}
		}

	}

	// Mètode per veure el saldo del compte.
	private static void veureSaldo() {
		
		// Mostrar saldo del compte actual.
		for(int i = 0; i < numComptes; i++) {
			// Al iniciar sessió es guarda el DNI a una variable global, de la qual es fa la següent comprovació.
			if(comptes[i].getDniTitular().equals(dniActual)) {
				System.err.println("Saldo disponible: " + comptes[i].getSaldo() + "€");
				if(comptes[i].getSaldo() <= 0) {
					System.err.println("ALERTA! Compte en nombres vermells!");
				}
				break;
			}
		}

		// Salt de línea.
		System.out.println();

	}

}
