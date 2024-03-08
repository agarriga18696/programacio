package Examen_7_8;

import java.util.ArrayList;
import java.util.List;

public class Oficina {

	private static List<Torn> llistaTorns = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Persona p = new Persona("41609299A", "Andreu", 25);
		
		Torn t = new Torn(p, true);
		
		llistaTorns.add(t);
		
		System.out.println(t.toString());
		
	}
	
	
	
}
