package turner.weatherforecast16day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class ForecastConnection {

	// connect online
	public ForecastInfo createConnection(String city) throws IOException {
		String cityName = city;

		URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=" + cityName
				+ "&mode=json&units=imperial&cnt=16&appid=452e567fa974f7581b8838a26e375947");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// request info
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		// create weather and return
		Gson gson = new Gson();
		ForecastInfo current = gson.fromJson(reader, ForecastInfo.class);
		return current;
	}

}
