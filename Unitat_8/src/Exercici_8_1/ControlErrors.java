package Exercici_8_1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlErrors {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		IU.Titol("Joc dels Errors", null);
		Error_1();
		Error_2();
		Error_3();
		FiDeJoc();

	}

	// Error 1: InputMismatchException
	private static void Error_1() {
		boolean esNombre = true;

		IU.Titol("Error 1", "InputMismatchException");
		IU.Missatge("En aquest exemple tenim una variable 'N' de tipus int (enter)");
		IU.Missatge("Prova a introduir un valor no numèric per veure l'excepció");

		do {
			try {
				IU.MissatgeEntrada("Entrada");
				if(!in.hasNextInt()) {
					int n = in.nextInt();
					esNombre = true;

				} else {
					IU.MissatgeFall("Prova a introduir un valor no numèric");
				}

			} catch(InputMismatchException e) {
				IU.MissatgeExit("Al introduir un valor no vàlid pel tipus de variable es llençaria un error");
				esNombre = false;
			}

			in.nextLine();

		} while(esNombre);

		IU.SaltLinia();

	}

	// Error 2: IndexOutOfBoundsException.
	private static void Error_2() {
		int[] array = {0, 1, 2, 3, 4, 5};
		int i = 0;

		IU.Titol("Error 2", "IndexOutOfBoundsException");
		IU.Missatge("Tenim un array d'enters de llargaria " + array.length + ": " + Arrays.toString(array));
		IU.Missatge("Prova a seleccionar un índex que estigui fora de l'array");
		
		do {
			try {
				IU.MissatgeEntrada("Entrada");
				i = in.nextInt();

				IU.Missatge("Has seleccionat: " + array[i]);

				if(i >= 0 && i <= array.length - 1) {
					IU.MissatgeFall("Prova a seleccionar un índex que es trobi fora dels límits");
				}

			} catch(IndexOutOfBoundsException e) {
				IU.MissatgeExit("El programa, al sortir-se dels límits de l'array llençaria un error");
			}

			in.nextLine();

		} while(i >= 0 && i <= array.length - 1);

		IU.SaltLinia();

	}

	// Error 3: ArithmeticException.
	private static void Error_3() {
		int n = 0, r = 0;

		IU.Titol("Error 3", "ArithmeticException");
		IU.Missatge("Hem de dividir el nombre 10, però necessitem que el divisor sigui zero");
		IU.Missatge("Creus que sortirà un error al intentar dividir per zero? Saps perquè?");

		do {
			try {
				IU.MissatgeEntrada("Entrada");
				n = in.nextInt();
				r = 10 / n;
				
				if(n != 0) {
					IU.MissatgeFall("Intenta dividir per zero");
				}

			} catch(ArithmeticException e) {
				IU.MissatgeExit("Al intentar dividir per zero es produeix un error conegut com 'divisió per zero'");
				IU.Missatge("La divisió per zero no té cap sentit matemàticament, ja que no hi ha cap nombre que,"
						+ "\n multiplicat per zero, doni com a resultat un nombre diferent a zero");
				IU.Missatge("Per això als programes informàtics, com les calculadores, no està permès dividir per zero");
			}

			in.nextLine();

		} while(n != 0);

		IU.SaltLinia();

	}
	
	private static void FiDeJoc() {
		IU.Titol("Fi del joc", null);
		IU.Missatge("Has arribat al final del joc! Enhorabona!");
		IU.SaltLinia();
		System.exit(0);
	}

}
