package turner.weather;

public class CurrentWeather {

	private Weather[] weather;
	private Main main;
	private String name;

	public Weather getWeather() {
		return weather[0];
	}

	public Main getMain() {
		return main;
	}

	public String getName() {
		return name;
	}

}
