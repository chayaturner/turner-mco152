package turner.math;

public class QuadraticEquation {

	private double a;
	private double b;
	private double c;
	private double posX;
	private double negX;
	private double disc = b * b - 4 * a * c;

	public QuadraticEquation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getPositiveX() throws InvalidDataException {

		if (disc < 0) {
			throw new InvalidDataException();
		} else {
			this.posX = (-b + Math.sqrt(disc)) / (2 * a);
			return posX;
		}
	}

	public double getNegativeX() throws InvalidDataException {

		if (disc < 0) {
			throw new InvalidDataException();
		} else {
			this.negX = (-b - Math.sqrt(disc)) / (2 * a);
			return negX;
		}

	}
}
