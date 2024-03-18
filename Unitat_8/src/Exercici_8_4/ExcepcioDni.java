package Exercici_8_4;

public class ExcepcioDni extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExcepcioDni(String missatge) {
		super(missatge);
	}
	
	public static ExcepcioDni dniIncorrecte() {
        return new ExcepcioDni("El format de DNI no és vàlid. Assegura't que els primers 8 caracters siguin numèrics i que el darrer sigui una lletra.");
    }
	
}
