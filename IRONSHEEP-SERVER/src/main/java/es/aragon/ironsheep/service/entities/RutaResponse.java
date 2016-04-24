package es.aragon.ironsheep.service.entities;

import es.aragon.ironsheep.data.entities.GreenZone;
import es.aragon.ironsheep.data.entities.Weather;

public class RutaResponse {
	private GreenZone greenZone;
	private Weather weather;

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public GreenZone getGreenZone() {
		return greenZone;
	}

	public void setGreenZone(GreenZone greenZone) {
		this.greenZone = greenZone;
	}

}
