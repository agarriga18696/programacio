package Exercicis.Exercici_6_10;

public class Rombe extends FiguraGeometrica {

	private double costat;
	private double diagonalA;
	private double diagonalB;
	private static int idRombe;

	public Rombe(String nom, double x, double y, double costat, double diagonalA, double diagonalB) {
		super(nom, x, y);

		this.costat = costat;
		this.diagonalA = diagonalA;
		this.diagonalB = diagonalB;
		this.idFigura = idRombe++;

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
		// A = dA * dB / 2

		return (diagonalA * diagonalB) / 2;
	}

	@Override
	public void mostrarInfoFigura() {

		System.out.println(" ID:		" + idFigura);
		System.out.println(" Nom:		" + nom);
		System.out.println(" X:		" + x);
		System.out.println(" Y:		" + y);
		System.out.println(" Costat:	" + costat);
		System.out.println(" DiagonalA:	" + diagonalA);
		System.out.println(" DiagonalB:	" + diagonalB);
		System.out.println(" Perímetre:	" + perimetre());
		System.out.println(" Àrea:		" + area());

	}

}
