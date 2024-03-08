package Examen_7_8;

public class Persona {

	private String dni;
	private String nom;
	private int edat;

	public Persona(String dni, String nom, int edat) {
		this.dni = dni;
		this.nom = nom;
		this.edat = edat;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}


}
