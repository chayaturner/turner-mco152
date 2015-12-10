package turner.weather;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeatherGui extends JFrame {

	private static final long serialVersionUID = 1L; // default

	private JLabel zip, city, temperature, description, weatherIcon;
	private JButton getWeather;
	private JTextField zipInput;
	private String iconString;

	public WeatherGui() {
		setTitle("Weather");
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container container = getContentPane();
		setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(2, 4));

		WeatherConnection weatherConnection = new WeatherConnection();
		zip = new JLabel("  Enter Zip Code:");
		zipInput = new JTextField(" ");
		city = new JLabel("  City:");
		temperature = new JLabel("  Temperature:");
		description = new JLabel("  Description:");
		getWeather = new JButton("  Get Weather");
		weatherIcon = new JLabel("");
		JPanel zipPanel = new JPanel();
		zipPanel.setLayout(new GridLayout(2, 1));
		zipPanel.add(zip);
		zipPanel.add(zipInput);
		panel.add(zipPanel);
		panel.add(getWeather);
		panel.add(city);
		panel.add(temperature);
		panel.add(description);
		panel.add(weatherIcon);
		container.add(panel);

		getWeather.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

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
		});

	}

	public static void main(String[] args) {
		WeatherGui weatherGui = new WeatherGui();
		weatherGui.setVisible(true);
	}
}
