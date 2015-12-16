package turner.weatherforecast16day;

import java.io.IOException;

import javax.swing.JLabel;

public class ForecastThread extends Thread {

	private String city;
	private JLabel[] forecastLabels;

	ForecastThread(String city, JLabel[] forecastLabels) {
		this.forecastLabels = forecastLabels;
		this.city = city;
	}

	@Override
	public void run() {
		try {
			ForecastConnection connection = new ForecastConnection();
			ForecastInfo info = connection.createConnection(city);

			int day = 1;

			// set labels with each day's weather.
			for (int i = 0; i <= 15; i++) {
				forecastLabels[i].setText("Day " + day + " Weather: " + info.getTemp(day));
				day++;
			}

		} catch (IOException e) {

		}

	}
}
