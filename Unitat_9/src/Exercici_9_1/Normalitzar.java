package Exercici_9_1;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Normalitzar {

	protected static String llevarAccents(String paraula) {
		String comandoNormalizado = Normalizer.normalize(paraula, Normalizer.Form.NFD);
		Pattern patron = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return patron.matcher(comandoNormalizado).replaceAll("");
	}
	
}
