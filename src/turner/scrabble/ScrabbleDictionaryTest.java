package turner.scrabble;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.Assert;

public class ScrabbleDictionaryTest {

	@Test
	public void TestContains() throws FileNotFoundException {

		ScrabbleDictionary testTrue = new ScrabbleDictionary();
		boolean contains = testTrue.contains("rigmarole");
		Assert.assertTrue(contains);

		ScrabbleDictionary testFalse = new ScrabbleDictionary();
		contains = testFalse.contains("supercalafrajalisticexpialadocious");
		Assert.assertFalse(contains);
	}

}
