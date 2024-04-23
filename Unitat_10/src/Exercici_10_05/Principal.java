package Exercici_10_05;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Principal {

	private static Reader f_origen = null;
	private static ByteArrayOutputStream f_copia = null;

	public static void main(String[] args) throws Exception {
		f_origen = new FileReader("src/Exercici_10_05/fitxer_1.txt");

		copiar(f_origen);
		mostrar(f_copia);
	}

	private static void copiar(Reader in) {
		try {
			f_copia = new ByteArrayOutputStream();

			char[] buffer = new char[1024];
			int llegits = 0;

			while((llegits = in.read(buffer)) != -1) {
				for(int i = 0; i < llegits; ++i) {
					f_copia.write(buffer[i]);
				}
			}

			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void mostrar(ByteArrayOutputStream b_out) {
		byte[] dades = b_out.toByteArray();

		for(byte b : dades) {
			System.out.print("" + (char) b);
		}
	}

}
