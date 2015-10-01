package turner.scrabble;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testContains() throws IOException {

		ScrabbleDictionary testTrue = new ScrabbleDictionary();
		boolean contains = testTrue.contains("rigmarole");
		Assert.assertTrue(contains);

		ScrabbleDictionary testFalse = new ScrabbleDictionary();
		contains = testFalse.contains("supercalafrajalisticexpialadocious");
		Assert.assertFalse(contains);
	}

}
