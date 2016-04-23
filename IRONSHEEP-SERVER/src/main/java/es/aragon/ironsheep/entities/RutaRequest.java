package es.aragon.ironsheep.entities;

public class RutaRequest {

	private String phoneNumber;

	private int animals;

	private String latOrigin;
	private String lngOrigin;

	private String latDestination;
	private String lngDestination;

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

	public String getLatOrigin() {
		return latOrigin;
	}

	public void setLatOrigin(String latOrigin) {
		this.latOrigin = latOrigin;
	}

	public String getLngOrigin() {
		return lngOrigin;
	}

	public void setLngOrigin(String lngOrigin) {
		this.lngOrigin = lngOrigin;
	}

	public String getLatDestination() {
		return latDestination;
	}

	public void setLatDestination(String latDestination) {
		this.latDestination = latDestination;
	}

	public String getLngDestination() {
		return lngDestination;
	}

	public void setLngDestination(String lngDestination) {
		this.lngDestination = lngDestination;
	}

}
