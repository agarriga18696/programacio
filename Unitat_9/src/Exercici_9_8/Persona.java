package Exercici_9_8;

public class Persona {
	
	private String nom;
	private int posicio;
	
	// Constructor.
	public Persona(String nom) {
		this.nom = nom;
	}
	
	// Getters i setters.
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getPosicio() {
		return posicio;
	}
	
	public void setPosicio(int posicio) {
		this.posicio = posicio;
	}
	
	// Mostrar persona.
	public String mostrar() {
		return " [" + this.posicio + "] " + this.nom;
	}
	
	// Eliminar persona.
	public Persona eliminar() {
		return null;
	}

}
