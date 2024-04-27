package Exercici_10_06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Principal {

	private static final String RUTA_F = "src/Exercici_10_06/fitxer.txt";
	private static final String RUTA_GZIP = "src/Exercici_10_06/fitxer.txt.gz";

	public static void main(String[] args) throws Exception {
		Msg.titol("Compressió de fitxers", null);
		comprimir();
	}

	private static void comprimir() {
		try {
			FileInputStream in = new FileInputStream(RUTA_F);
			FileOutputStream out = new FileOutputStream(RUTA_GZIP);
			GZIPOutputStream gzip = new GZIPOutputStream(out);

			byte[] dades = new byte[1024];
			int llegits = 0;

			while(-1 != (llegits = in.read(dades))) {
				gzip.write(dades, 0, llegits);
			}

			gzip.close();
			out.close();
			in.close();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			Msg.exit("Arxiu comprimit correctament!");
		}
	}
}
