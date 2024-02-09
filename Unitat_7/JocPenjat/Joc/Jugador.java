package Joc;

public class Jugador {

	private int vides;
	private int punts;
	
	public Jugador(int vides) {
		this.vides = vides;
		this.punts = 0;
	}

	public int getVides() {
		return vides;
	}

	public void setVides(int vides) {
		this.vides = vides;
	}

	public int getPunts() {
		return punts;
	}

	public void setPunts(int punts) {
		this.punts = punts;
	}
	
	public void sumarPunts() {
		punts++;
	}
	
	public void restarVides() {
		vides--;
	}
	
}
