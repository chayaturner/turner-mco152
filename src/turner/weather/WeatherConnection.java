package turner.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class WeatherConnection {

	public CurrentWeather createWeatherConnection(String zipCode) throws IOException {

		String zip = zipCode;

		// connect to weather online
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + zip
				+ ",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// request
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		CurrentWeather currentWeather = gson.fromJson(reader, CurrentWeather.class);
		return currentWeather;
	}
}
