package Exercicis.Examen_Prova;

public abstract class Electrodomestico {

	// Atributs.
	private String tipo;
	private String modelo;
	private int consumo;
	private double precio;

	// Constructor con parámetros.
	public Electrodomestico(String modelo,int consumo, double precio) {
		this.modelo = modelo;
		this.consumo = consumo;
		this.precio = precio;
	}

	// Constructor sin parámetros.
	public Electrodomestico() {}

	// Getters y setters.
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	// Método toString()
	public abstract String toString();

}
