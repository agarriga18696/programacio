package Exercicis.Exercici_6_6;

public class Satelit extends ObjecteAstronomic {
	
	// Atributs.
	private String orbita;
	private boolean atmosfera;
	
	// Constructor.
	public Satelit(String nom, String orbita, boolean atmosfera) {
		super(nom);
		this.orbita = orbita;
		this.atmosfera = atmosfera;
	}
	
	// Funció per mostrar les dades.
	public void mostrarDades() {
		System.out.println("Nom:			" + this.getNom());
		System.out.println("Òrbita:			" + this.getOrbita());
		System.out.println("Atmosfera:		" + (this.getAtmosfera() ? "SI" : "NO"));
		System.out.println("-----------------------------------------------------");
	}

	public String getOrbita() {
		return orbita;
	}

	public void setOrbita(String orbita) {
		this.orbita = orbita;
	}

	public boolean getAtmosfera() {
		return atmosfera;
	}

	public void setAtmosfera(boolean atmosfera) {
		this.atmosfera = atmosfera;
	}
}
