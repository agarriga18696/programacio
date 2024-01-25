package Exercicis.Exercici_6_10;

public abstract class FiguraGeometrica {

	// Atributs.
	protected String nom;
	protected double x;
	protected double y;
	protected int idFigura;

	// Constructor.
	public FiguraGeometrica(String nom, double x, double y) {
		
		this.nom = nom;
		this.x = x;
		this.y = y;
	}

	// Mètode per calcular el perímetre.
	public abstract double perimetre();

	// Mètode per calcula l'àrea.
	public abstract double area();
	
	public abstract void mostrarInfoFigura();

}
