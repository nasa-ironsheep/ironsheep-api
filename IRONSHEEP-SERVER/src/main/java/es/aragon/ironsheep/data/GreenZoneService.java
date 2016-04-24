package es.aragon.ironsheep.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

import es.aragon.ironsheep.data.entities.GreenZone;

public class GreenZoneService {
	public String SERVICE_URL = "http://localhost:5000";

	public GreenZone getGreenZone(double lng, double lat) {

		String response = callRequest(lng, lat);
		System.out.println("GREEN ZONES:");
		System.out.println(response);

		JSONObject jsonObj = new JSONObject(response);

		GreenZone greenZone = new GreenZone(jsonObj);

		return greenZone;

	}

	private String callRequest(double lng, double lat) {
		String response = "";
		try {
			String urlParam = SERVICE_URL;
			urlParam += "/" + lng;
			urlParam += "/" + lat;

			System.out.println(urlParam);

			URL url = new URL(urlParam);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				response += output;
			}
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

}
