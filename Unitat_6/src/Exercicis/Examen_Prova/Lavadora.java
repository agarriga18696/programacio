package Exercicis.Examen_Prova;

public class Lavadora extends Electrodomestico implements enReparacion {

	// Atributo.
	private int capacidadTambor;
	
	// Constructor con parámetros.
	public Lavadora(String marca, int consumo, int capacidadTambor, double precio) {
		super(marca, consumo, precio);

		this.setTipo("Lavadora");
		this.capacidadTambor = capacidadTambor;
	}

	// Constructor sin parámetros.
	public Lavadora() {}
	
	// Getters y setters.
	public int getCapacidadTambor() {
		return capacidadTambor;
	}

	public void setCapacidadTambor(int capacidadTambor) {
		this.capacidadTambor = capacidadTambor;
	}

	// Métodos.
	@Override
	public String toString() {
		return this.getMarca() + " | " + this.getConsumo() + " | " + this.capacidadTambor;
	}
	
	@Override
	public double reparar(int horas) {
		
		return horas * precio_hora;
	}

}
