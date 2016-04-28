package es.aragon.ironsheep.data.entities;

import org.json.JSONObject;

/**
 * POJO for storage an GreenZone Object
 * 
 * @author ARTURO
 */
public class GreenZone {

	private double grass;
	private double erro;
	private String date;

	/**
	 * Basic constructor
	 */
	public GreenZone() {
	}

	/**
	 * Constructor based on a JSONObject
	 * 
	 * @param json
	 *            JSON with GreenZone values
	 */
	public GreenZone(JSONObject json) {
		try {
			this.grass = json.getDouble("grass");

			if (!json.isNull("erro")) {
				this.erro = json.getDouble("erro");
			}

			this.date = json.getString("date");

		} catch (Exception e) {
			System.out.println("Green Zone not found");
			e.printStackTrace();
		}

	}

	public double getGrass() {
		return grass;
	}

	public void setGrass(double grass) {
		this.grass = grass;
	}

	public double getErro() {
		return erro;
	}

	public void setErro(double erro) {
		this.erro = erro;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
