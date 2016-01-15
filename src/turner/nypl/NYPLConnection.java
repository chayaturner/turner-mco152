package turner.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class NYPLConnection {

	public RequestAPI createConnection(String search) throws IOException {

		URL url = new URL("http://api.repo.nypl.org/api/v1/items/search?q=" + search + "&publicDomainOnly=true");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Authorization", "Token token = \"5jipilzvjg5yhdmq\"");

		// request
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		// NYPLApi request = gson.fromJson(reader, NYPLApi.class);
		RequestAPI request = gson.fromJson(reader, RequestAPI.class);
		return request;
	}
}
