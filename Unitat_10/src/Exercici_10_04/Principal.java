package Exercici_10_04;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Principal {

	private static Reader f_origen = null;
	private static Writer f_copia = null;

	public static void main(String[] args) throws Exception {
		f_origen = new FileReader("src/Exercici_10_04/fitxer_1.txt");
		f_copia = new FileWriter("src/Exercici_10_04/fitxer_2.txt");

		copiar(f_origen, f_copia);
	}

	private static void copiar(Reader in, Writer out) {
		try {
			char[] dades = new char[100];
			int llegits = 0;

			while(-1 != (llegits = in.read(dades))) {
				out.write(dades, 0, llegits);
			}
			
			// Afegir aquesta línia al final del contingut del fitxer.
			String str = " (còpia)";
			out.write(str);

			out.close();
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			Msg.exit("El fitxer s'ha copiat correctament.");
		}
	}

}
