package Exercici_10_03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Principal {

	private static File f_original = new File("src/Exercici_10_03/f_origen.pdf");
	private static File f_copia = new File("src/Exercici_10_03/f_copia.pdf");

	public static void main(String[] args) {
		copiar(f_original, f_copia);
	}

	// Mètode per copiar el contingut d'un fitxer a un altre.
	private static void copiar(File f_origen, File f_copia) {
		FileInputStream input = null;
		FileOutputStream output = null;

		try {
			input = new FileInputStream(f_origen);
			output = new FileOutputStream(f_copia);

			byte[] dades = new byte[(int) f_origen.length()];
			int llegits = 0;

			while(-1 != (llegits = input.read(dades))) {
				output.write(dades, 0, llegits);
			}

			output.close();
			input.close();

		} catch(Exception e) {
			e.printStackTrace();

		} finally {
			if(comprovar(f_origen, f_copia)) {
				Msg.exit("El fitxer s'ha copiat correctament.");
			} else {
				Msg.error("El fitxer no s'ha copiat correctament.");
			}
		}

		Msg.simple("Bytes original: " + f_original.length());
		Msg.simple("Bytes còpia: " + f_copia.length());
	}

	// Mètode per verificar la còpia dels fitxers.
	private static boolean comprovar(File f_origen, File f_copia) {
		// Verifica que tinguin la mateixa mida.
		// No comprova que els continguts siguin idèntics.
		if(f_origen.length() == f_copia.length()) {
			return true;
		}

		return false;
	}

}
