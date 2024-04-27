package Exercici_10_08;

import java.io.*;
import java.util.ArrayList;

public class Principal {

	private static ArrayList<Persona> persones = new ArrayList<>();

	public static void main(String[] args) {
		// Inicialitzar alguns alumnes i professors per defecte.
		inicialitzarAlumnes();
		inicialitzarProfessors();

		// Serialitzar la llista de persones.
		serialitzarPersones();

		// Recuperar la llista de persones serialitzades.
		ArrayList<Persona> personesRecuperades = deserialitzarPersones();

		// Mostrar la llista de persones recuperades.
		mostrarLlista(personesRecuperades);
	}

	// Mètode per inicialitzar alumnes per defecte.
	private static void inicialitzarAlumnes() {
		Alumne alumne1 = new Alumne("Adrià", "12345678A", 17, "1r de Batxiller");
		Alumne alumne2 = new Alumne("Ainhoa", "87654321B", 18, "2n de Batxiller");
		persones.add(alumne1);
		persones.add(alumne2);
	}

	// Mètode per inicialitzar profes per defecte.
	private static void inicialitzarProfessors() {
		Professor professor1 = new Professor("Biel", "98765432C", 58, "Mates");
		Professor professor2 = new Professor("Verònica", "23456789D", 37, "Anglès");
		persones.add(professor1);
		persones.add(professor2);
	}

	// Mètode per serialitzar la llista de persones.
	private static void serialitzarPersones() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Exercici_10_08/persones.dat"))) {
			oos.writeObject(persones);
			Msg.exit("La llista de persones s'ha serialitzat correctament.");
		} catch(IOException e) {
			Msg.error("Llista de persones serialitzada incorrectament: " + e.getMessage());
		}
	}

	// Mètode per deserialitzar la llista de persones.
	@SuppressWarnings("unchecked")
	private static ArrayList<Persona> deserialitzarPersones() {
		ArrayList<Persona> personesRecuperades = new ArrayList<>();

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Exercici_10_08/persones.dat"))) {
			personesRecuperades = (ArrayList<Persona>) ois.readObject();
			Msg.exit("La llista de persones s'ha deserialitzat correctament.");
		} catch(IOException | ClassNotFoundException e) {
			System.err.println("Llista de persones deserialitzada incorrectament: " + e.getMessage());
		}

		return personesRecuperades;
	}

	// Mètode per mostrar la llista de persones recuperades.
	private static void mostrarLlista(ArrayList<Persona> personesRecuperades) {
		Msg.simple("Persones recuperades:");

		for(Persona persona : personesRecuperades) {
			if(persona instanceof Alumne) {
				Msg.simple("ALUMNE");
				((Alumne) persona).mostrarDades();
			} else if(persona instanceof Professor) {
				Msg.simple("PROFESSOR");
				((Professor) persona).mostrarDades();
			}
		}
	}
}
