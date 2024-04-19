package Exercici_10_02;

import java.io.File;
import java.io.FilenameFilter;

public class Principal {

	public static void main(String[] args) {
		File f = new File("src/Exercici_10_02");

		String[] llistat;

		llistat = f.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".png") || name.endsWith(".jpg")) {
					return true;
				}
				return false;
			}
		});

		// Mostrar llistat.
		Msg.simple("Imatges PNG o JPG trobades:");
		for(String s : llistat) {
			if(s.toLowerCase().contains(".png")) {
				Msg.simple("PNG: " + s);

			} else if(s.toLowerCase().contains(".jpg")) {
				Msg.simple("JPG: " + s);
			}
		}
	}

}
