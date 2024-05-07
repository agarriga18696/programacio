package Examen_UD10;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class Format {

	protected static DateTimeFormatter data = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	// Mètode per donar format a un double amb els decimals indicats.
	protected static String decimal(double num) {

		return new DecimalFormat("#.00").format(num);
	}
}
