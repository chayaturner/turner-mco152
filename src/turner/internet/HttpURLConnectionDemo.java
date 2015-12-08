package turner.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionDemo {

	public static void main(String[] args) throws IOException {
		
		//executes a url request on its own
		URL url = new URL("http://google.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //cast it
		
		//request
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(in));
		String s;
		while((s = reader.readLine()) != null){
			System.out.println(s);
		}
	}

}
