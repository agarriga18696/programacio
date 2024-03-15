package Exercici_8_4;

public class Excepcio extends Exception {

	private String message;
	
	public Excepcio(String message) {
		super(message);
	}
	
	public String toString() {
		return IU.Excepcio("DNI no vàlid", "El DNI introduït no és vàlid.");
	}
	
}
