package Exercicis.Exercici_6_6;

public class Planeta extends ObjecteAstronomic {
	
	// Atributs.
	private String orbita;
	private String tipus;
	private int nombreLlunes;
	private boolean habitable;
	private boolean anells;
	
	// Constructor.
	public Planeta(String nom, String orbita, String tipus, int nombreLlunes, boolean habitable, boolean anells) {
		super(nom);
		this.orbita = orbita;
		this.tipus = tipus;
		this.nombreLlunes = nombreLlunes;
		this.habitable = habitable;
		this.anells = anells;
	}
	
	// Funció per mostrar les dades.
	public void mostrarDades() {
		System.out.println("Nom:			" + this.getNom());
		System.out.println("Tipus:			" + this.getTipus());
		System.out.println("Òrbita:			" + this.getOrbita());
		System.out.println("Núm. llunes:		" + this.getNombreLlunes());
		System.out.println("Habitable:		" + (this.getHabitable() ? "SI" : "NO"));
		System.out.println("Anells:			" + (this.getAnells() ? "SI" : "NO"));
		System.out.println("-----------------------------------------------------");
	}

	public String getOrbita() {
		return orbita;
	}

	public void setOrbita(String orbita) {
		this.orbita = orbita;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public int getNombreLlunes() {
		return nombreLlunes;
	}

	public void setNombreLlunes(int nombreLlunes) {
		this.nombreLlunes = nombreLlunes;
	}

	public boolean getHabitable() {
		return habitable;
	}

	public void setHabitable(boolean habitable) {
		this.habitable = habitable;
	}

	public boolean getAnells() {
		return anells;
	}

	public void setAnells(boolean anells) {
		this.anells = anells;
	}
}
