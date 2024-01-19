package Exercicis.Exercici_6_3;

import java.util.Random;
import java.util.random.*;

public class Password {

	// Atributs del password.
	private StringBuilder password = new StringBuilder();
	private long longitud = 8;

	// Caracters per generar el password.
	// Utilitzant un array de 2 dimensions puc controlar millor el tipus de caracter ASCII a utilitzar.
	// [0][n] -> lletres en minúscula.
	// [1][n] -> lletres en majúscula.
	// [2][n] -> nombres.
	// [3][n] -> símbols.
	// D'aquesta manera, puc implementar més fàcilment un codi que, per exemple, pugui generar passwords mesclant de 
	// manera controlada i desitjada el tipus de caracter.
	char[][] caractersPassword = {
			{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'},
			{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
			{'1','2','3','4','5','6','7','8','9','0'},
			{33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,58,59,60,61,62,63,64,91,92,93,94,95,96,123,124,125,126,168}
	};

	// Nombre random.
	Random rand = new Random();

	// Constructor sense paràmetres (longitud 8).
	public Password() {

		for(int i = 0; i < longitud; i++) {
			int fila = rand.nextInt(caractersPassword.length);
			int columna = rand.nextInt(caractersPassword[fila].length);
			
			password.append(caractersPassword[fila][columna]);
		}

	}

	// Constructor amb paràmetres (longitud personalitzada).
	public Password(long longitudPersonalitzada) {

		for(int i = 0; i < longitudPersonalitzada; i++) {
			int fila = rand.nextInt(caractersPassword.length);
			int columna = rand.nextInt(caractersPassword[fila].length);
			
			password.append(caractersPassword[fila][columna]);
		}


	}

	// Mètode per comprovar si la contrassenya és robusta.
	public void esRobust() {
		boolean passIsUpperCase = false, passIsLowerCase = false, passIsDigit = false, passIsSymbol = false;
		// Mínim 1 majúscula, 1 minúscula, 1 número i 1 simbol.
		for(int i = 0; i < password.length(); i++) {
			char caracter = password.charAt(i);
			
			if(Character.isUpperCase(caracter)) {
				passIsUpperCase = true;
			} else if(Character.isLowerCase(caracter)) {
				passIsLowerCase = true;
			} else if(Character.isDigit(caracter)) {
				passIsDigit = true;
			} else {
				passIsSymbol = true;
			}
		}
		
		if(passIsUpperCase == true && passIsLowerCase == true && passIsLowerCase == true && passIsSymbol == true ) {
			System.out.println("La contrassenya és robusta.");
		} else {
			System.out.println("La contrassenya NO és robusta.");
		}

	}

	// Getters i Setters.
	public String getPassword() {
		return password.toString();
	}

	public void setPassword(StringBuilder password) {
		this.password = password;
	}

	public long getLongitud() {
		return longitud;
	}

	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}



}
