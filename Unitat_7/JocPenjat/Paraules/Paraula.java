package Paraules;

public class Paraula {

	private String paraula;
	private boolean encertada;
	private int id;
	private static int contadorId = 0; 
	
	// Constructor
	public Paraula(String paraula) {
		this.paraula = paraula;
		this.encertada = false;
		
		Paraules.llistaParaules.add(this);
		
		// Incrementar el comptador de ID.
		this.id = contadorId++;
	}

	public String getParaula() {
		return paraula;
	}

	public void setParaula(String paraula) {
		this.paraula = paraula;
	}

	public boolean isEncertada() {
		return encertada;
	}

	public void setEncertada(boolean encertada) {
		this.encertada = encertada;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		return paraula;
	}
	
}
