package turner.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDictionary {

	public ScrabbleDictionary() {

	}

	/**
	 * @return true if the dictionary contains the word, otherwise false.
	 * @throws FileNotFoundException
	 */

	public boolean contains(String word) throws FileNotFoundException {
		boolean contains;

		Scanner in = new Scanner(new File("dictionary.txt"));
		ArrayList<String> dictionary = new ArrayList<String>();
		while (in.hasNext()) {
			dictionary.add(in.next());
		}

		if (dictionary.contains(word.toLowerCase())) {
			contains = true;
		} else {
			contains = false;

		}

		in.close();
		return contains;

	}

}
