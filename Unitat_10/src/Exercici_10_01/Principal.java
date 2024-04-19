package Exercici_10_01;

import java.io.File;

public class Principal {

	public static void main(String[] args) {
		// Directori.
		File f = new File("src");
		
		// Array per guardar el llistat.
		String[] llista = f.list();
		
		// Mostrar el contingut de l'array.
		for(String e : llista) {
			Msg.simple(e);
		}
	}

}
