package es.aragon.ironsheep.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import es.aragon.ironsheep.entities.RutaRequest;
import es.aragon.ironsheep.entities.RutaResponse;

@Path("ruta")
public class RutaService {
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public RutaResponse getRuta(RutaRequest request){
		RutaResponse response = new RutaResponse();
		response.setNombre(request.getPhoneNumber());
		
		
		return response;
	}
	

}
