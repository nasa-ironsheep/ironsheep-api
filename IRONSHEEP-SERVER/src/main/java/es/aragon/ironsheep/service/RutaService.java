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

	/**
	 * Get the average statistics of several point
	 * 
	 * @param request
	 *            JSON Array with several points
	 * @return JSON with average statistics
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public RutaResponse getRuta(List<RutaRequest> request) {
		RutaResponse response = new RutaResponse();

		WeatherService weatherService = new WeatherService();
		GreenZoneService greenZoneService = new GreenZoneService();

		List<Weather> weathers = new ArrayList<Weather>();
		List<GreenZone> greenZones = new ArrayList<GreenZone>();

		// Query the statistics for each point TODO add threads
		for (RutaRequest point : request) {
			greenZones.add(greenZoneService.getGreenZone(point.getLng(),
					point.getLat()));
			weathers.add(weatherService.getCurrentWeather(point.getLng(),
					point.getLat()));
		}

		// Calculate the average statistics of points
		response = getAverage(weathers, greenZones);

		return response;
	}

	/**
	 * Calculate the averages statistics of several points.
	 * 
	 * @param weathers
	 *            List of Weathers for calculate the average
	 * @param greenZones
	 *            List of GreenZones for calculate the average
	 * @return Return an response for the rest service
	 * 
	 */
	private RutaResponse getAverage(List<Weather> weathers,
			List<GreenZone> greenZones) {
		RutaResponse average = new RutaResponse();

		// WEATHER
		double tempAverage = 0;
		double pressureAverage = 0;
		double humidityAverage = 0;
		double windSpeedAverage = 0;

		// Iterate weathers for calculate the SUM of this
		for (Weather weather : weathers) {
			tempAverage += weather.getTemp();
			pressureAverage += weather.getPressure();
			humidityAverage += weather.getHumidity();
			windSpeedAverage += weather.getWindSpeed();

		}

		// New Weather with averages values
		Weather weatherAverage = new Weather();
		weatherAverage.setMain(weathers.get(0).getMain());
		weatherAverage.setTemp((tempAverage / weathers.size()));
		weatherAverage.setPressure(pressureAverage / weathers.size());
		weatherAverage.setHumidity(humidityAverage / weathers.size());
		weatherAverage.setWindSpeed(windSpeedAverage / weathers.size());

		average.setWeather(weatherAverage);

		// GREEEN ZONE
		double grassAverage = 0;
		double erroAverage = 0;

		// Iterate green zones for calculate the SUM of this
		for (GreenZone greenZone : greenZones) {
			grassAverage += greenZone.getGrass();
			erroAverage += greenZone.getErro();
		}

		// New GreenZone with averages values
		GreenZone greenZoneAverage = new GreenZone();
		greenZoneAverage.setGrass(grassAverage / greenZones.size());
		greenZoneAverage.setErro(erroAverage / greenZones.size());
		greenZoneAverage.setDate(greenZones.get(0).getDate());

		average.setGreenZone(greenZoneAverage);

		return average;
	}

}
