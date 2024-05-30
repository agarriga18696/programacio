package exercici_11_09.controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import exercici_11_09.model.Alumne;
import exercici_11_09.model.Persona;
import exercici_11_09.model.Professor;

public class Controlador {

	// Atributs.
	private List<Persona> persones;

	// Constructor.
	public Controlador() {
		this.persones = new ArrayList<>();
	}

	// Mètode per crear un nou alumne.
	public void crearAlumne(String nom, String dni, int edat, String nivell) {
		persones.add(new Alumne(nom, dni, edat, nivell));
	}

	// Mètode per crear un nou professor.
	public void crearProfessor(String nom, String dni, int edat, String assignatura) {
		persones.add(new Professor(nom, dni, edat, assignatura));
	}

	// Mètode per guardar les dades a un fitxer.
	public void guardarDades(String path) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			oos.writeObject(persones);
		}
	}

	// Mètode per carregar les dades des d'un fitxer.
	@SuppressWarnings("unchecked")
	public void carregarDades(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
			persones = (List<Persona>) ois.readObject();
		} 
	}

	public List<Persona> getPersones() {
		return persones;
	}

}
