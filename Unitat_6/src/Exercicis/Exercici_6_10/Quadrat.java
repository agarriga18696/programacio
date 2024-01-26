package Exercicis.Exercici_6_10;

public class Quadrat extends FiguraGeometrica {

	private double costat;
	private static int idQuadrat;

	public Quadrat(String nom, double x, double y, double costat) {
		super(nom, x, y);
		
		this.costat = costat;
		this.idFigura = idQuadrat++;
	}

	@Override
	public double perimetre() {
		// Fórmula:
		// P = 4 * c

		return 4 * costat;
	}

	@Override
	public double area() {
		// Fórmula:
		// A = c2

		return Math.pow(2, costat);
	}

	@Override
	public void mostrarInfoFigura() {

		System.out.println(System.lineSeparator());
		System.out.println(" ID:		" + idFigura);
		System.out.println(" Nom:		" + nom);
		System.out.println(" X:		" + x);
		System.out.println(" Y:		" + y);
		System.out.println(" Costat:	" + costat);
		System.out.println(" Perímetre:	" + perimetre());
		System.out.println(" Àrea:		" + area());

	}

}
