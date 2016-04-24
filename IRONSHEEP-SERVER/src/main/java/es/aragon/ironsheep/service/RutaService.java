package es.aragon.ironsheep.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import es.aragon.ironsheep.data.GreenZoneService;
import es.aragon.ironsheep.data.WeatherService;
import es.aragon.ironsheep.data.entities.GreenZone;
import es.aragon.ironsheep.data.entities.Weather;
import es.aragon.ironsheep.service.entities.RutaRequest;
import es.aragon.ironsheep.service.entities.RutaResponse;

@Path("ruta")
public class RutaService {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public RutaResponse getRuta(List<RutaRequest> request) {
		RutaResponse response = new RutaResponse();

		WeatherService weatherService = new WeatherService();
		GreenZoneService greenZoneService = new GreenZoneService();

		List<Weather> weathers = new ArrayList<Weather>();
		List<GreenZone> greenZones = new ArrayList<GreenZone>();

		for (RutaRequest point : request) {
			greenZones.add(greenZoneService.getGreenZone(point.getLng(), point.getLat()));
			weathers.add(weatherService.getCurrentWeather(point.getLng(), point.getLat()));
		}

		response = getAverage(weathers, greenZones);

		return response;
	}

	private RutaResponse getAverage(List<Weather> weathers, List<GreenZone> greenZones) {
		RutaResponse average = new RutaResponse();

		// WEATHER
		double tempAverage = 0;
		double pressureAverage = 0;
		double humidityAverage = 0;
		double windSpeedAverage = 0;

		for (Weather weather : weathers) {
			tempAverage += weather.getTemp();
			pressureAverage += weather.getPressure();
			humidityAverage += weather.getHumidity();
			windSpeedAverage += weather.getWindSpeed();

		}

		Weather weatherAverage = new Weather();
		weatherAverage.setMain(weathers.get(0).getMain());
		weatherAverage.setTemp((tempAverage / weathers.size()) - 273.15);
		weatherAverage.setPressure(pressureAverage / weathers.size());
		weatherAverage.setHumidity(humidityAverage / weathers.size());
		weatherAverage.setWindSpeed(windSpeedAverage / weathers.size());

		average.setWeather(weatherAverage);

		// GREEEN ZONE
		double grassAverage = 0;
		double erroAverage = 0;

		for (GreenZone greenZone : greenZones) {
			grassAverage += greenZone.getGrass();
			erroAverage += greenZone.getErro();
		}

		GreenZone greenZoneAverage = new GreenZone();
		greenZoneAverage.setGrass(grassAverage / greenZones.size());
		greenZoneAverage.setErro(erroAverage / greenZones.size());
		greenZoneAverage.setDate(greenZones.get(0).getDate());

		average.setGreenZone(greenZoneAverage);

		return average;
	}

}
