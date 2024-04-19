package Proves;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Proves {

	public static void main(String[] args) {

		escriure();

	}
	
	// Escriure fitxer OutputStream Write.
	private static void escriure() {
		File f = new File("C:\\Users\\ciclesgs.EAAULA211W-007\\eclipse-workspace\\Unitat_10\\src\\Proves\\escriure.txt");
		
		byte[] escritura = {1,2,3,4,5,6,7,8,9};
		
		try {
			FileOutputStream output = new FileOutputStream(f);
			output.write(escritura);
			// Tancar el fluxe.
			output.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	// Llegir fitxer InputStream Read.
	private static void llegir() {
		File f = new File("C:\\Users\\ciclesgs.EAAULA211W-007\\eclipse-workspace\\Unitat_10\\src\\Proves\\llegir.dat");
		
		byte[] lectura = new byte[100];
		
		FileInputStream input;
		try {
			input = new FileInputStream(f);
			int c = input.read(lectura, 30, 20);
			while(c != -1) {
				System.out.println(Arrays.toString(lectura));
				System.out.println("Quantitat de bytes llegits: " + c);
				c = input.read(lectura, 30, 20);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void llistatRuta() {
		// Indicar la ruta.
		File f = new File("C:\\Users\\ciclesgs.EAAULA211W-007\\eclipse-workspace\\Unitat_10\\src\\Proves\\llistat.dat");

		String[] llistat;

		// Indicar el tipus de fitxer a filtrar.
		llistat = f.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {

				if(name.endsWith(".dat")) return true;

				return false;
			}

		});

		// Mostrar llistat de fitxers.
		for(String s : llistat) {
			Msg.simple(s);
		}
	}

}
