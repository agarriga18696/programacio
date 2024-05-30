package exercici_11_09.model;

import java.io.Serializable;

public abstract class Persona implements Serializable {

	// Atributs.
	private static final long serialVersionUID = 1L;
	private String nom;
	private String dni;
	private int edat;

	// Constructor.
	public Persona(String nom, String dni, int edat) {
		this.nom = nom;
		this.dni = dni;
		this.edat = edat;
	}

	// Getters i setters.
	public String getNom() {
		return nom;
	}

	public String getDni() {
		return dni;
	}

	public int getEdat() {
		return edat;
	}

	@Override
	public String toString() {
		return nom + " - " + dni + " - " + edat;
	}

}
