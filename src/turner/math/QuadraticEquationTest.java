package turner.math;

import org.junit.Assert;

import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetPositiveX() {
		QuadraticEquation quadraticEquation = new QuadraticEquation(1, 5, 6);
		double posX = quadraticEquation.getPositiveX();
		Assert.assertEquals(-2, posX, 0.01);
	}

	@Test
	public void testGetNegativeX() throws InvalidDataException {
		QuadraticEquation quadraticEquation = new QuadraticEquation(1, 5, 6);
		double negX = quadraticEquation.getNegativeX();
		Assert.assertEquals(-3, negX, 0.01);
	}
}
