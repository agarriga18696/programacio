package exercici_11_9.controlador;

import java.util.ArrayList;
import java.util.List;

import exercici_11_9.model.Alumne;
import exercici_11_9.model.Persona;
import exercici_11_9.model.Professor;
import exercici_11_9.vista.Finestra;

public class Controlador {

	private Finestra finestra;
	private List<Persona> persones;

	public Controlador(Finestra finestra) {
		this.finestra = finestra;
		this.finestra.setControlador(this);
		this.persones = new ArrayList<>();
	}

	public void crearAlumne(String nom, String dni, int edat, String nivell) {
		persones.add(new Alumne(nom, dni, edat, nivell));
	}

	public void crearProfessor(String nom, String dni, int edat, String assignatura) {
		persones.add(new Professor(nom, dni, edat, assignatura));
	}

}
