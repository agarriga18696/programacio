package Exercici_Recuperar_Dades_Fitxer_Dat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dades implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Mètode per guardar les dades al fitxer.
	protected static void guardarDades(List<Persona> dades, File fitxer) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fitxer))) {
			out.writeObject(dades);
			System.out.println("Dades guardades correctament a " + fitxer);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Mètode per carregar les dades del fitxer.
	protected static List<Persona> carregarDades(String nombreArchivo) {
        List<Persona> listaPersonas = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            listaPersonas = (List<Persona>) in.readObject();
            
            System.out.println("Dades carregades correctament des de: " + nombreArchivo);
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listaPersonas;
    }

}
