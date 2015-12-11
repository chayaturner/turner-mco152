package turner.weather;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
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
		setSize(550, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container container = getContentPane();
		setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(2, 4));

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
				GetWeatherThread thread = new GetWeatherThread(panel, zip, city, temperature, description, weatherIcon,
						zipInput, iconString);
				thread.run();
			}
		});
	}

	public static void main(String[] args) {
		WeatherGui weatherGui = new WeatherGui();
		weatherGui.setVisible(true);
	}
}
