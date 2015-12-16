package turner.weatherforecast16day;

public class ForecastInfo {

	private List[] list;

	public ForecastInfo() {
		list = new List[16];
	}

	public List[] getList() {
		return list;
	}

	public double getTemp(int day) {
		return list[day - 1].getTemp();
	}

}
