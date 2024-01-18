package Jocs.JuegoCarreras;

import java.util.concurrent.TimeUnit;

class Tiempo {
	private double tiempo;

	public Tiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void incrementarTiempo(double incremento) {
		tiempo += incremento;
	}

	// Función para esperar 'x' tiempo.
    public static void esperarTiempo(long milisegundos) {
        long tiempoEspera = TimeUnit.MILLISECONDS.toNanos(milisegundos);

        long tiempoActual = System.nanoTime();
        while (System.nanoTime() - tiempoActual < tiempoEspera) {
            // Esperar hasta que se cumpla el tiempo deseado.
        }
    }
	
}