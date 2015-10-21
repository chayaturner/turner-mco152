package turner.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class UFOSightingMain {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader(
				"./ufo_awesome.json"));

		final Gson gson = new Gson();

		// return list of UFO sightings
		final UFOSightingList list = gson.fromJson(in, UFOSightingList.class);
		// or
		// final UFOSighting array[] = gson.fromJson(in, UFOSighting[].class);
		System.out.println(list.size());
		in.close();

	}
}
