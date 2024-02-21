package Exercici_7_1_Penjat;

public class Paraula {

	private String paraula;
	private int id;
	private static int contadorId = 0; 
	
	// Constructor
	public Paraula(String paraula) {
		this.paraula = paraula;

		// Incrementar el comptador de ID.
		this.id = contadorId++;
	}

	public String getParaula() {
		return paraula;
	}

	public void setParaula(String paraula) {
		this.paraula = paraula;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		return paraula;
	}
	
}
