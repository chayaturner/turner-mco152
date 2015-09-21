package turner.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {

	private Scanner dictionary;
	private ArrayList<String> arrayList;
	private HashSet<String> set;

	public ScrabbleDictionary() throws FileNotFoundException {
		this.dictionary = new Scanner(new File("dictionary.txt"));
		this.arrayList = new ArrayList<String>();
		this.set = new HashSet<String>();
		while (dictionary.hasNext()) {
			arrayList.add(dictionary.next());
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