package Examen_UD10;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributs.
	private LocalDate data;
	private double total; // total : linia x quantitat x preu unitari.
	private ArrayList<LiniaDeFactura> linies;

	// Constructor.
	public Factura(double total, ArrayList<LiniaDeFactura> linies) {
		this.data = LocalDate.now();
		this.total = total;
		this.linies = new ArrayList<>(linies);
	}

	// Mètode toString.
	public String toString() {
		StringBuffer resultat = new StringBuffer();

		resultat.append("\n Data: " + Format.data.format(data))
		.append("\n\n Total: " + Format.decimal(total) + " €")
		.append("\n\n Línies de factura:\n")
		.append("\n\tDESCRIPCIÓ\t\t\t\t\t\t      UNITATS\t       PREU U")
		.append("\n\t__________________________________________________________________________________________\n");

		for(LiniaDeFactura ldf : linies) {
			resultat.append(ldf);
		}

		return resultat.toString();

	}
}
