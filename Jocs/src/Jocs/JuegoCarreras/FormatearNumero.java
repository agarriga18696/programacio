package Jocs.JuegoCarreras;

import java.util.Locale;

public class FormatearNumero {

    // Función para formatear un número decimal.
    public static double formatearNumero(double numero) {
        // Formatear para que muestre 1 decimal.
        return Double.parseDouble(String.format(Locale.US, "%.2f", numero));
    }
}
