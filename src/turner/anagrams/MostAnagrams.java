package turner.anagrams;

import java.io.IOException;
import java.util.ArrayList;

public class MostAnagrams {

	public static void main(String[] args) throws IOException {

		Anagrams anagrams = new Anagrams();

		ArrayList<ArrayList<String>> anagramsLists = anagrams.getAnagrams();

		// largest anagram group size
		int greatestAmnt = anagramsLists.get(0).size();
		for (ArrayList<String> a : anagramsLists) {
			if (a.size() > greatestAmnt) {
				greatestAmnt = a.size();
			}
		}

		// display anagram groups with largest group size
		for (ArrayList<String> b : anagramsLists) {
			if (b.size() == greatestAmnt) {
				System.out.println(b);
			}
		}
	}
}