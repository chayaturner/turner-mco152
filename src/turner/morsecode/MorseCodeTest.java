package turner.morsecode;

import org.junit.Test;
import org.junit.Assert;

public class MorseCodeTest {

	@Test
	public void TestDecode() {
		MorseCode morsecode = new MorseCode();
		String decoded = morsecode.decode("..-. .. -. .- .-.. .-.. -.--");
		Assert.assertEquals("finally", decoded);
	}

	@Test
	public void TestEncode() {
		MorseCode morsecode = new MorseCode();
		String encoded = morsecode.encode("working");
		Assert.assertEquals(".-- --- .-. -.- .. -. --. ", encoded);
	}

}
