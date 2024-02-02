package Exercicis.Examen_Prova;

public abstract class Electrodomestico {

	// Atributs.
	private String tipo;
	private String marca;
	private int consumo;
	private double precio;

	// Constructor con parámetros.
	public Electrodomestico(String marca,int consumo, double precio) {
		this.marca = marca;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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
