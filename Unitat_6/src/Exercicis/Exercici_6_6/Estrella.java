package Exercicis.Exercici_6_6;

public class Estrella extends ObjecteAstronomic {
	
	// Atributs.
	private String etapa;
	private int temperatura;
	private String ubicacioGalactica;
	
	// Constructor.
	public Estrella(String nom, String etapa, int temperatura, String ubicacioGalactica) {
		super(nom);
		this.etapa = etapa;
		this.temperatura = temperatura;
		this.ubicacioGalactica = ubicacioGalactica;
	}
	
	// Funció per mostrar les dades.
	public void mostrarDades() {
		System.out.println("Nom:			" + this.getNom());
		System.out.println("Etapa:			" + this.getEtapa());
		System.out.println("Temperatura:		" + this.getTemperatura() + "ºC");
		System.out.println("Ub. Galàctica:		" + this.getUbicacioGalactica());
		System.out.println("-----------------------------------------------------");
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public String getUbicacioGalactica() {
		return ubicacioGalactica;
	}

	public void setUbicacioGalactica(String ubicacioGalactica) {
		this.ubicacioGalactica = ubicacioGalactica;
	}
}
