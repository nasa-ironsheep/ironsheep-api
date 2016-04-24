package es.aragon.ironsheep.data.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

public class GreenZone {

	private double grass;
	private double erro;
	private Date date;

	public GreenZone(JSONObject json) {
		try {
			this.grass = json.getDouble("grass");

			if (!json.isNull("erro")) {
				this.erro = json.getDouble("erro");
			}

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			this.date = df.parse(json.getString("date"));

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
