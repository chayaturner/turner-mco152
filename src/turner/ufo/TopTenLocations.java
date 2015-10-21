package turner.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class TopTenLocations {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader(
				"./ufo_awesome.json"));
		final Gson gson = new Gson();
		// return list of UFO sightings
		final UFOSightingList list = gson.fromJson(in, UFOSightingList.class);

		// create a map to keep track of occurrences
		Map<String, Integer> map = new HashMap<>();

		for (UFOSighting i : list) {
			if (map.containsKey(i.getLocation())) {
				int count = map.get(i.getLocation()); // get count
				map.put(i.getLocation(), count + 1); // increment count
			} else {
				map.put(i.getLocation(), 1); // add new word with count of 1
			}
		}

		ArrayList<Integer> values = new ArrayList<Integer>(map.values());
		Collections.sort(values);
		Collections.reverse(values);

		int count = 0;
		for (Integer i : values) {
			if (count < 10) {
				System.out.print(i);
				for (String j : map.keySet()) {
					if (map.get(j).equals(i)) {
						System.out.println(j);
					}
				}
				count++;
			}
		}
		in.close();
	}
}
