package turner.weather;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetWeatherThread extends Thread {

	private JPanel panel;
	private JLabel zip, city, temperature, description, weatherIcon;
	private JTextField zipInput;
	private String iconString;

	public GetWeatherThread(JPanel panel, JLabel zip, JLabel city, JLabel temperature, JLabel description,
			JLabel weatherIcon, JTextField zipInput, String iconString) {
		this.panel = panel;
		this.zip = zip;
		this.city = city;
		this.temperature = temperature;
		this.description = description;
		this.weatherIcon = weatherIcon;
		this.zipInput = zipInput;
		this.iconString = iconString;

	}

	@Override
	public void run() {
		try {
			WeatherConnection weatherConnection = new WeatherConnection();
			CurrentWeather weather = weatherConnection.createWeatherConnection(zipInput.getText().trim());
			if (weather.getName() == null) { // entered invalid zip.
												// Reset
				zipInput.setText("Invalid. Reenter Zip Code");
				temperature.setText("  Temperature:");
				description.setText("  Description:");
				weatherIcon.setIcon(new ImageIcon());
			}
			city.setText("  City: " + weather.getName());
			temperature.setText("  Temperature: " + weather.getMain().getTemp().toString() + " F");
			iconString = weather.getWeather().getIcon();
			URL url = new URL("http://openweathermap.org/img/w/" + iconString + ".png");
			BufferedImage image = ImageIO.read(url);
			weatherIcon.setIcon(new ImageIcon(image));
			panel.add(weatherIcon);
			description.setText("  Description: " + weather.getWeather().getDescription());

		} catch (IOException ex2) {
			zip.setText("  Enter Zip Code:");
			zipInput.setText("");
		}
	}
}