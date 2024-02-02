package Exercicis.Examen_Prova;

public class Nevera extends Electrodomestico implements enReparacion {
	
	// Atributo.
	private boolean tieneCongelador;

	// Constructor con parámetros.
	public Nevera(String marca, int consumo, boolean tieneCongelador, double precio) {
		super(marca, consumo, precio);
		
		this.setTipo("Nevera");
		this.tieneCongelador = tieneCongelador;
	}
	
	// Constructor sin parámetros.
	public Nevera() {}
	
	// Getters y setters.
	public boolean isTieneCongelador() {
		return tieneCongelador;
	}

	public void setTieneCongelador(boolean tieneCongelador) {
		this.tieneCongelador = tieneCongelador;
	}

	// Métodos.
	@Override
	public String toString() {
		return this.getMarca() + " | " + this.getConsumo() + " | " + this.tieneCongelador;
	}

	@Override
	public double reparar(int horas) {
		
		return horas * precio_hora;
	}
	
	
}
