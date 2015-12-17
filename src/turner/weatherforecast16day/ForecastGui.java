package turner.weatherforecast16day;

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

public class ForecastGui extends JFrame {

	private static final long serialVersionUID = 1L;

	private final JLabel label;
	private final JPanel forecastsPanel;
	private final JLabel[] forecastLabels;
	private final JTextField cityName;
	private final JButton getForecast;
	private String cityString;

	public ForecastGui() {
		setTitle("16 Day Weather Forecast");
		setSize(600, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		final Container container = getContentPane();
		setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(4, 1));

		label = new JLabel("Enter City:");
		panel.add(label);
		cityName = new JTextField("New York");
		panel.add(cityName);
		forecastsPanel = new JPanel(new GridLayout(5, 5));
		forecastLabels = new JLabel[16];
		getForecast = new JButton("Get weather forecast for the next 16 days!");
		panel.add(getForecast);

		// Initialize and add labels
		for (int i = 0; i <= 15; i++) {
			forecastLabels[i] = new JLabel();
		}

		for (int i = 0; i <= 15; i++) {
			forecastsPanel.add(forecastLabels[i]);
		}

		panel.add(forecastsPanel);

		container.add(panel);

		getForecast.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L; // default

			@Override
			public void actionPerformed(ActionEvent e) {

				cityString = cityName.getText().trim();

				// get rid of spaces for url
				for (int i = 1; i < cityString.length(); i++) {
					if (cityString.charAt(i) == ' ') {
						cityString = cityString.replace(" ", "%20");
					}
				}

				ForecastThread thread = new ForecastThread(cityString, forecastLabels);
				thread.start();
			}

		});

	}

	public static void main(String[] args) {
		new ForecastGui().setVisible(true);

	}

}
