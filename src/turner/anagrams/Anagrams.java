package turner.anagrams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	private BufferedReader dictionary;
	private String line;

	public Anagrams() throws FileNotFoundException {
		this.dictionary = new BufferedReader(new FileReader("US.dic"));
	}

	public ArrayList<ArrayList<String>> getAnagrams() throws IOException {

		Map<String, ArrayList<String>> tempListOfAnagrams = new HashMap<String, ArrayList<String>>();
		ArrayList<String> listOfWords = new ArrayList<String>();

		while ((line = dictionary.readLine()) != null) {
			listOfWords.add(line);
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
