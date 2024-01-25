package Exercicis.Exercici_6_10;

public class Rectangle extends FiguraGeometrica {

	private double costatA;
	private double costatB;
	private static int idRectangle;

	public Rectangle(String nom, double x, double y, double costatA, double costatB) {
		super(nom, x, y);
		
		this.costatA = costatA;
		this.costatB = costatB;
		this.idFigura = idRectangle++;

	}

	@Override
	public double perimetre() {
		// Fórmula:
		// P = cB * cA

		return costatB * costatA;
	}

	@Override
	public double area() {
		// Fórmula:
		// A = 2 * cA + cB

		return 2 * (costatA + costatB);
	}
	
	@Override
	public void mostrarInfoFigura() {
		
		System.out.println(" ID:		" + idFigura);
		System.out.println(" Nom:		" + nom);
		System.out.println(" X:		" + x);
		System.out.println(" Y:		" + y);
		System.out.println(" CostatA:	" + costatA);
		System.out.println(" CostatB:	" + costatB);
		System.out.println(" Perímetre:	" + perimetre());
		System.out.println(" Àrea:		" + area());
		
	}

}
