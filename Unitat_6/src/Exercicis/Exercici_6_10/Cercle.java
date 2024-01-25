package Exercicis.Exercici_6_10;

public class Cercle extends FiguraGeometrica {

	private double centre;
	private double radi;
	private double diametre;
	private static int idCercle;

	public Cercle(String nom, double x, double y, double centre, double radi, double diametre) {
		super(nom, x, y);

		this.centre = centre;
		this.radi = radi;
		this.diametre = diametre;
		this.idFigura = idCercle++;

	}

	@Override
	public double perimetre() {
		// Fórmula:
		// P = 2 * π * r

		return 2 * Math.PI * radi;
	}

	@Override
	public double area() {
		// Fórmula:
		// A = π * r2

		return Math.PI * Math.pow(2, radi);
	}

	@Override
	public void mostrarInfoFigura() {

		System.out.println(" ID:		" + idFigura);
		System.out.println(" Nom:		" + nom);
		System.out.println(" X:		" + x);
		System.out.println(" Y:		" + y);
		System.out.println(" Centre:	" + centre);
		System.out.println(" Radi:		" + radi);
		System.out.println(" Diàmetre:	" + diametre);
		System.out.println(" Perímetre:	" + perimetre());
		System.out.println(" Àrea:		" + area());

	}

}
