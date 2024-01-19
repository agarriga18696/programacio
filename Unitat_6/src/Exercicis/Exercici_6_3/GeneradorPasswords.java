package Exercicis.Exercici_6_3;

import java.util.Scanner;

public class GeneradorPasswords {

	private static Scanner in = new Scanner(System.in);
	private static int longitudPersonalitzada = 0;

	public static void main(String[] args) {
		quantitatPasswords();
	}

	// Mètode per demanar a l'usuari la quantitat de passwords.
	public static void quantitatPasswords() {
		int quantitatPasswords = 0;

		// Anirà demanant la quantitat de contrassenyes a l'usuari mentre el valor sigui negatiu.
		// Quan sigui positiu, sortirà del bucle.
		do {
			System.out.print("Quantes contrassenyes necessites? ");
			// Validar que introdueixi un valor int i que no sigui negatiu.
			if(in.hasNextInt()) {
				quantitatPasswords = in.nextInt();
				in.nextLine();
				if(quantitatPasswords < 0) {
					System.out.println("No s'admeten valors negatius.");
				} else if(quantitatPasswords == 0) {
					System.out.println("No s'ha creat cap contrassenya.");
					System.out.println("\nFi del programa.");
					break;
				} else { 
					// Has introduït un nombre positiu.
					// Cridar al mètode per generar les contrassenyes.
					generarPasswords(quantitatPasswords);
					break;
				}
			} else {
				System.out.println("\nValor no vàlid.\n");
				in.nextLine();
			}

		} while(quantitatPasswords < 0 || !Character.isDigit(quantitatPasswords));

	}

	// Mètode per generar les contrassenyes.
	public static void generarPasswords(int quantitatPasswords) {
		// Demanar tipus de password (de mida 8 o de mida personalitzada).
		int opcioSwitch = 0;

		do {
			// Bucle for per anar repetint la petició de contrassenya fins el valor màxim introduït per l'usuari.
			for(int i = 1; i <= quantitatPasswords; i++) {
				System.out.println("\n[Password " + i + " de " + quantitatPasswords + "]");
				System.out.println("Quin tipus de contrassenya vols? ");
				System.out.println("(1) Password de mida 8.");
				System.out.println("(2) Password de mida personalitzada.");
				System.out.print("    Opció: ");

				// Validar que introdueixi un valor int i que no sigui negatiu.
				if(in.hasNextInt()) {
					opcioSwitch = in.nextInt();
					in.nextLine();
					if(opcioSwitch < 0) {
						System.out.println("No s'admeten valors negatius.");
					} else {
						// Switch per controlar les opcions de l'usuari.
						switch(opcioSwitch) {
						case 1:
							// Crear nou password de longitud 8.
							Password pass8 = new Password();
							System.out.println("\nPassword " + i + ": " + pass8.getPassword());
							// Comprovar que la contrassenya sigui robusta.
							pass8.esRobust();
							break;
						case 2:
							do {
								System.out.print("De quina mida vols la contrassenya? ");
								// Validar que introdueixi un valor int i que no sigui negatiu.
								if(in.hasNextInt()) {
									longitudPersonalitzada = in.nextInt();
									in.nextLine();
									if(longitudPersonalitzada < 0) {
										System.out.println("No s'admeten valors negatius.");
									} else {
										// Sortir del bucle do-while.
										break;
									}
								} else {
									System.out.println("\nValor no vàlid.");
									in.nextLine();
								}
							} while(longitudPersonalitzada < 0 || !Character.isDigit(longitudPersonalitzada));
							// Crear nou password de longitud N.
							Password passN = new Password(longitudPersonalitzada);
							System.out.println("\nPassword " + i + ": " + passN.getPassword());
							// Comprovar que la contrassenya sigui robusta.
							passN.esRobust();
							break;
						default:
							System.out.println("\nOpció no vàlida.\n");
							break;
						}
					}
				} else {
					System.out.println("\nValor no vàlid.\n");
					in.nextLine();
				}

			}
			// Sortir del bucle for.
			break;

		} while(opcioSwitch < 0 || !Character.isDigit(opcioSwitch));

		System.out.println("\nFi del programa.");
	}

}
