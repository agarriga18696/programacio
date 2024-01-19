package Exercicis.Exercici_6_9;

public abstract class Empleat {

	// Atributs.
	private String Nom;
	private String Cognoms;
	private double Sou_base;
	private String DNI;
	
	// Constructor
	public Empleat(String nom, String cognoms, double souBase, String dni) {

		this.Nom = nom;
		this.Cognoms = cognoms;
		this.Sou_base = souBase;
		this.DNI = dni;

	}
	
	// Getters.
	public String getNom() {
		return Nom;
	}

	public String getCognoms() {
		return Cognoms;
	}

	public double getSou_base() {
		return Sou_base;
	}

	public String getDNI() {
		return DNI;
	}
	
	// Funció toString.
	public String toString() {
		return Nom + " | " + Cognoms + " | " + Sou_base + " | " + DNI;
	}

}
