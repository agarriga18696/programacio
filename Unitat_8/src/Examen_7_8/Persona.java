package Examen_7_8;

import java.time.LocalDate;
import java.time.LocalTime;

public class Persona {

	// Atributs.
	private String dni;
	private String nom;
	private int edat;
	private LocalDate dataAtencio;
	private LocalTime horaAtencio;
	private boolean atesCorrectament;

	// Constructor.
	public Persona(String dni, String nom, int edat) {
		this.dni = dni;
		this.nom = nom;
		this.edat = edat;
		this.atesCorrectament = false;
	}

	// Getters i setters.
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

	public boolean isAtesCorrectament() {
		return atesCorrectament;
	}

	// Mètode toString.
	public String toString() {
		StringBuffer persona = new StringBuffer();

		persona.append(IU.llista(false, 
				"DNI: " + this.getDni(),
				"Nom: " + this.getNom(),
				"Edat: " + this.getEdat(),
				"Data: " + Utilitat.dataFormat.format(dataAtencio),
				"Hora: " + Utilitat.horaFormat.format(horaAtencio),
				"Atenció correcta: " + (atesCorrectament ? "Si" : "No")));

		return persona.toString();
	}

	// Mètode Antendre.
	protected void atendre() {
		this.dataAtencio = LocalDate.now();
		this.horaAtencio = LocalTime.now();
		this.atesCorrectament = Utilitat.random.nextBoolean();
	}


}
