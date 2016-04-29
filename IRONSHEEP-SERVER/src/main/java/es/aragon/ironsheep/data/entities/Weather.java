package es.aragon.ironsheep.data.entities;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.json.JSONObject;

/**
 * POJO for storage an Weather Object
 * 
 * @author ARTURO
 *
 */
public class Weather {
	@JsonIgnore
	private boolean find = false;

	private String main;
	private double temp;
	private double pressure;
	private double humidity;
	private double windSpeed;

	/**
	 * Basic constructor
	 */
	public Weather() {
	}

	/**
	 * Constructor based on a JSONObject
	 * 
	 * @param json
	 *            JSON with Weather values
	 */
	public Weather(JSONObject json) {
		if (json != null) {
			try {
				this.main = json.getJSONArray("weather").getJSONObject(0)
						.getString("main");
				// parse to celsius
				this.temp = json.getJSONObject("main").getDouble("temp") - 273.15;
				this.pressure = json.getJSONObject("main")
						.getDouble("pressure");
				this.humidity = json.getJSONObject("main")
						.getDouble("humidity");
				this.windSpeed = json.getJSONObject("wind").getDouble("speed");
				this.find = true;
			} catch (Exception e) {
				System.out.println("Weather not found");
			}
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

	public boolean isFind() {
		return find;
	}

	public void setFind(boolean find) {
		this.find = find;
	}

}
