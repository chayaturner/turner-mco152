package turner.scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class ScrabbleDictionary {

	private BufferedReader dictionary;
	private ArrayList<String> arrayList;
	private HashSet<String> set;
	private String line;

	public ScrabbleDictionary() throws IOException {
		this.dictionary = new BufferedReader(new FileReader("US.dic"));
		this.arrayList = new ArrayList<String>();
		this.set = new HashSet<String>();

		while ((line = dictionary.readLine()) != null) {
			arrayList.add(line);
		}
		set.addAll(arrayList);
		dictionary.close();
	}

	/**
	 * @return true if the dictionary contains the word, otherwise false.
	 */

	public boolean contains(String word) {
		return set.contains(word);
	}
}