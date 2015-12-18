package turner.contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class ContactConnection {

	public Contact[] createConnection() throws IOException {

		URL url = new URL("http://jsonplaceholder.typicode.com/users");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		Contact[] contacts = gson.fromJson(reader, Contact[].class);
		return contacts;
	}
}
