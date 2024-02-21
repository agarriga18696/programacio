package Exercici_7_1_Penjat;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Normalitzar {

	public static String llevarAccents(String paraula) {
		String comandoNormalizado = Normalizer.normalize(paraula, Normalizer.Form.NFD);
		Pattern patron = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return patron.matcher(comandoNormalizado).replaceAll("");
	}
	
}
