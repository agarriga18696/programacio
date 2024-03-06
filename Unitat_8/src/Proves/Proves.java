package Proves;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Proves {

	public static void main(String[] args) {
		
		gestioFitxers();

	}
	
	public static void gestioFitxers() /*throws FileNotFoundException*/ {
		boolean fitxer_backup_creat = false;
		
		try {
			FileInputStream in = new FileInputStream("fitxer.txt");
		} catch (FileNotFoundException e) {
			/* Possibles solucions si no es troba el fitxer:
			 * 1 -> crear-ne un de nou per substituir l'antic.
			 * 2 -> crear una còpia de seguretat del fitxer a un lloc on no es pugui perdre.
			 * 3 -> guardar les dades del fitxer en format binari dins d'una variable.
			*/
			
			// 1 - Crear un fitxer nou.
			File fitxer_backup = new File("src/Proves/fitxer.txt");
			fitxer_backup.getParentFile().mkdirs();
			
			try {
				fitxer_backup.createNewFile();
				System.out.println("El fitxer no s'ha trobat i se'n crearà un de nou.");
				fitxer_backup_creat = true;
			} catch (IOException e1) {
				System.out.println("No s'ha pogut crear el nou fitxer.");
				fitxer_backup_creat = false;
			}
			
		} finally {
			if(fitxer_backup_creat) {
				System.out.println("El fitxer nou s'ha creat correctament.");
			}
		}
		
	}

}
