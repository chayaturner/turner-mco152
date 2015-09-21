package turner.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {

	private Scanner dictionary;

	public Anagrams() throws FileNotFoundException {
		this.dictionary = new Scanner(new File("dictionary.txt"));
	}

	public ArrayList<ArrayList<String>> getAnagrams() throws IOException {

		Map<String, ArrayList<String>> tempListOfAnagrams = new HashMap<String, ArrayList<String>>();
		ArrayList<String> listOfWords = new ArrayList<String>();
		while (dictionary.hasNext()) {
			listOfWords.add(dictionary.next());
		}

		for (String s : listOfWords) {
			char[] c = s.toUpperCase().toCharArray();
			Arrays.sort(c);
			ArrayList<String> list = tempListOfAnagrams.get(String.valueOf(c));
			if (list == null) {
				list = new ArrayList<String>();
			}
			list.add(s);
			tempListOfAnagrams.put(String.valueOf(c), list);
		}
		ArrayList<ArrayList<String>> anagrams = new ArrayList<ArrayList<String>>();
		for (Map.Entry<String, ArrayList<String>> e : tempListOfAnagrams
				.entrySet()) {
			if (e.getValue().size() > 1) {
				anagrams.add(e.getValue());
			}
		}
		dictionary.close();
		return anagrams;
	}
}
