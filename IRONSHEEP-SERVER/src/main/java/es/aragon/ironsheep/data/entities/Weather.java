package es.aragon.ironsheep.data.entities;

import org.json.JSONObject;

public class Weather {
	private String main;
	private double temp;
	private double pressure;
	private double humidity;
	private double windSpeed;

	public Weather() {
	}

	public Weather(JSONObject json) {
		try {
			this.main = json.getJSONArray("weather").getJSONObject(0).getString("main");
			this.temp = json.getJSONObject("main").getDouble("temp");
			this.pressure = json.getJSONObject("main").getDouble("pressure");
			this.humidity = json.getJSONObject("main").getDouble("humidity");
			this.windSpeed = json.getJSONObject("wind").getDouble("speed");
		} catch (Exception e) {
			System.out.println("Weather not found");
		}

	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

}
