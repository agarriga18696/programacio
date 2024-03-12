package Examen_7_8;

import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utilitat {

	// Random.
	protected static Random random = new Random();

	// Formatar la data i hora.
	protected static DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	protected static DateTimeFormatter horaFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
	
}
