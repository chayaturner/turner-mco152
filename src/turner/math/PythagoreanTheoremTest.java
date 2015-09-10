package turner.math;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {

	PythagoreanTheorem pythagoreanTheorem = new PythagoreanTheorem(3, 4, 5);

	@Test
	public void testSetAB() {

		pythagoreanTheorem.setAB(3, 4);
		double c = pythagoreanTheorem.getC();
		Assert.assertEquals(5, c, 0.01);
	}

	@Test
	public void testSetAC() {

		pythagoreanTheorem.setAC(3, 5);
		double b = pythagoreanTheorem.getB();
		Assert.assertEquals(4, b, 0.01);
	}

	@Test
	public void testSetBC() {

		pythagoreanTheorem.setBC(4, 5);
		double a = pythagoreanTheorem.getA();
		Assert.assertEquals(3, a, 0.01);

	}
}
