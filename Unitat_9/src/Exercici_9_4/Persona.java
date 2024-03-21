package Exercici_9_4;

public class Persona {

	private String nom;
	private String dni;
	private int edat;
	
	public Persona(String nom, String dni, int edat) {
		this.nom = nom;
		this.dni = dni;
		this.edat = edat;
	}

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
	
	// Mètode toString.
	@Override
	public String toString() {
		StringBuffer p = new StringBuffer();

		p.append(IU.llistaOrdenada(false, 
				"Nom: " + this.getNom(), 
				"DNI: " + this.getDni(), 
				"Edat: " + this.getEdat()));

		return p.toString();
	}
	
}
