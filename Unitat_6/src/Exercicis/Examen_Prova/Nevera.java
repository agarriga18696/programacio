package Exercicis.Examen_Prova;

public class Nevera extends Electrodomestico implements enReparacion {
	
	// Atributo.
	private boolean tieneCongelador;
	private String congelador;

	// Constructor con parámetros.
	public Nevera(String modelo, int consumo, boolean tieneCongelador, double precio) {
		super(modelo, consumo, precio);
		
		this.setTipo("Nevera");
		this.tieneCongelador = tieneCongelador;
		this.congelador = tieneCongelador ? "Si" : "No";
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
		return "\n Modelo: " + this.getModelo() + " | Consumo: " + this.getConsumo() + " kWh | Congelador: " + this.congelador + " | Precio: " + this.getPrecio() + " €";
	}

	@Override
	public double reparar(int horas) {
		
		return horas * precio_hora;
	}
	
	
}
