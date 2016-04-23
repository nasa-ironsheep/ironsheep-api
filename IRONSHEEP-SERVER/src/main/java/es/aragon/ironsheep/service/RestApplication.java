package es.aragon.ironsheep.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/services")
public class RestApplication extends Application{
	
	private Set<Object> services;

	public RestApplication() {
		services = new HashSet<Object>();
		services.add(new RutaService());
	}

	@Override
	public Set<Object> getSingletons() {
		return services;
	}

}
