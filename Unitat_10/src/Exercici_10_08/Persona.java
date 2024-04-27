package Exercici_10_08;

import java.io.Serializable;

public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributs.
	private String nom;
	private String dni;
	private int edat;

	// Definir els atributs de la persona.
	public Persona(String nom, String dni, int edat) {
		this.nom = nom;
		this.dni = dni;
		this.edat = edat;
	}

	// Getters i setters.
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdat() {
		return edat;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}

}
