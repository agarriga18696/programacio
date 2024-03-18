package Exercici_8_1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlErrors {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		IU.titol("Joc de les Excepcions", "Part I");
		Entrada.premerTecla("començar la partida");
		excepcio_1();
		Entrada.premerTecla("poder passar a la següent excepció");
		excepcio_2();
		Entrada.premerTecla("poder passar a la següent excepció");
		excepcio_3();
		Entrada.premerTecla("acabar la partida");
		fiJoc();

	}

	// Excepció 1: InputMismatchException
	private static void excepcio_1() {
		IU.titol("Excepció 1", "InputMismatchException");
		Missatge.simple("En aquest exemple tenim una variable 'N' de tipus int (enter)");
		Missatge.simple("Prova a introduir un valor no numèric per veure l'excepció");

		boolean esNombre = true;
		do {
			try {
				Missatge.entrada("Entrada");
				if(!in.hasNextInt()) {
					int n = in.nextInt();
					esNombre = true;

				} else {
					Missatge.fall("Prova a introduir un valor no numèric");
				}

			} catch(InputMismatchException e) {
				Missatge.exit("Al introduir un valor no vàlid pel tipus de variable es llençaria un error");
				esNombre = false;
			}

			in.nextLine();

		} while(esNombre);

		IU.saltLinia();

	}

	// Excepció 2: IndexOutOfBoundsException.
	private static void excepcio_2() {
		int[] array = {0, 1, 2, 3, 4, 5};
		int i = 0;

		IU.titol("Excepció 2", "IndexOutOfBoundsException");
		Missatge.simple("Tenim un array d'enters de llargaria " + array.length + ": " + Arrays.toString(array));
		Missatge.simple("Prova a seleccionar un índex que estigui fora de l'array");
		
		do {
			try {
				Missatge.entrada("Entrada");
				i = in.nextInt();

				Missatge.simple("Has seleccionat: " + array[i]);

				if(i >= 0 && i <= array.length - 1) {
					Missatge.fall("Prova a seleccionar un índex que es trobi fora dels límits");
				}

			} catch(IndexOutOfBoundsException e) {
				Missatge.exit("El programa, al sortir-se dels límits de l'array llençaria un error");
			}

			in.nextLine();

		} while(i >= 0 && i <= array.length - 1);

		IU.saltLinia();

	}

	// Excepció 3: ArithmeticException.
	private static void excepcio_3() {
		int n = 0, r = 0;

		IU.titol("Excepció 3", "ArithmeticException");
		Missatge.simple("Hem de dividir el nombre 10, però necessitem que el divisor sigui zero");
		Missatge.simple("Creus que sortirà un error al intentar dividir per zero? Saps perquè?");

		do {
			try {
				Missatge.entrada("Entrada");
				n = in.nextInt();
				r = 10 / n;
				
				if(n != 0) {
					Missatge.fall("Intenta dividir per zero");
				}

			} catch(ArithmeticException e) {
				Missatge.exit("Al intentar dividir per zero es produeix un error conegut com 'divisió per zero'");
				Missatge.simple("La divisió per zero no té cap sentit matemàticament, ja que no hi ha cap nombre que,"
						+ "\n multiplicat per zero, doni com a resultat un nombre diferent a zero");
				Missatge.simple("Per això als programes informàtics, com les calculadores, no està permès dividir per zero");
			}

			in.nextLine();

		} while(n != 0);

		IU.saltLinia();

	}
	
	private static void fiJoc() {
		IU.titol("Fi del joc", null);
		Missatge.simple("Has arribat al final del joc! Enhorabona!");
		IU.saltLinia();
		System.exit(0);
	}

}
