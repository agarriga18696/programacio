package Exercicis.Exercici_6_2;

public class CompteBancari {

	// Atributs.
	private String dniTitular;
	private String nomTitular;
	private double saldo;

	// Getters i Setters.
	public String getDniTitular() {
		return dniTitular;
	}

	public void setDniTitular(String dniTitular) {
		this.dniTitular = dniTitular;
	}

	public String getNomTitular() {
		return nomTitular;
	}

	public void setNomTitular(String nomTitular) {
		this.nomTitular = nomTitular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	// Definir el constructor del compte bancari.
	public CompteBancari() {
		
	}
	
	// Definir els atributs del compte bancari.
	public CompteBancari(String dniTitular, String nomTitular, double saldo) {
		this.dniTitular = dniTitular;
		this.nomTitular = nomTitular;
		this.saldo = saldo;
	}
	
	// Operacions.
	public void ingressar() {
		
	}
	
	public void reintegrar() {
		
	}
	
	public void mostrarSaldo() {
		
	}

}
