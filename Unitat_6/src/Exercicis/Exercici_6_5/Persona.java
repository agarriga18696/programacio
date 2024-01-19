package Exercicis.Exercici_6_5;

public class Persona {

	// Atributs.
	private String Nom;
	private String DNI;
	private byte Edat;

	// Definir els atributs de la persona.
	public Persona(String nomPersona, String DNIPersona, byte edatPersona) {
		this.Nom = nomPersona;
		this.DNI = DNIPersona;
		this.Edat = edatPersona;
	}

	// Getters i setters.
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public byte getEdat() {
		return Edat;
	}
	public void setEdat(byte edat) {
		Edat = edat;
	}

}
