package es.aragon.ironsheep.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import es.aragon.ironsheep.data.GreenZoneService;
import es.aragon.ironsheep.data.WeatherService;
import es.aragon.ironsheep.service.entities.RutaRequest;
import es.aragon.ironsheep.service.entities.RutaResponse;

@Path("ruta")
public class RutaService {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public RutaResponse getRuta(RutaRequest request) {
		RutaResponse response = new RutaResponse();

		WeatherService weatherService = new WeatherService();
		GreenZoneService greenZoneService = new GreenZoneService();

		response.setGreenZone(greenZoneService.getGreenZone(request.getLngDestination(), request.getLatDestination()));

		response.setWeather(weatherService.getCurrentWeather(request.getLngDestination(), request.getLatDestination()));

		return response;
	}

}
