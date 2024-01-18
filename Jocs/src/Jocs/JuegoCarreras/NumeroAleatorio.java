package Jocs.JuegoCarreras;

import java.util.Random;

public class NumeroAleatorio {
    private static final Random random = new Random();

    // Función para generar un número Int aleatorio.
    public static int generarNumeroIntAleatorio(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    // Función para generar un número Double aleatorio.
    public static double generarNumeroDoubleAleatorio(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }
}
