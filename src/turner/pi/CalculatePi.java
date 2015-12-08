package turner.pi;

public class CalculatePi {

	public static void main(String[] args) {
		//System.out.println(Math.PI);
		PiCalculator calc = new PiCalculator();
		System.out.println(calc.calculate(500000));
	}

}
