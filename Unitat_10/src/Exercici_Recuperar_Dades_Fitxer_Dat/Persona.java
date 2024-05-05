package Exercici_Recuperar_Dades_Fitxer_Dat;

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
	
	// Constructor.
	public Persona(String nom, String dni, int edat) {
		this.nom = nom;
		this.dni = dni;
		this.edat = edat;
	}
	
	public Persona() {
		
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}
	
	@Override
    public String toString() {
        return "\nNom: " + nom + "\nDni: " + dni + "\nEdat: " + edat + "\n";
    }

}
