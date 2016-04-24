package es.aragon.ironsheep.service.entities;

public class RutaRequest {

	private String phoneNumber;

	private int animals;

	private double latOrigin;
	private double lngOrigin;

	private double latDestination;
	private double lngDestination;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAnimals() {
		return animals;
	}

	public void setAnimals(int animals) {
		this.animals = animals;
	}

	public double getLatOrigin() {
		return latOrigin;
	}

	public void setLatOrigin(double latOrigin) {
		this.latOrigin = latOrigin;
	}

	public double getLngOrigin() {
		return lngOrigin;
	}

	public void setLngOrigin(double lngOrigin) {
		this.lngOrigin = lngOrigin;
	}

	public double getLatDestination() {
		return latDestination;
	}

	public void setLatDestination(double latDestination) {
		this.latDestination = latDestination;
	}

	public double getLngDestination() {
		return lngDestination;
	}

	public void setLngDestination(double lngDestination) {
		this.lngDestination = lngDestination;
	}

}
