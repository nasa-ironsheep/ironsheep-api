package es.aragon.ironsheep.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

import es.aragon.ironsheep.data.entities.GreenZone;

/**
 * Obtains the percent of green zones for a point
 * 
 * @author ARTURO
 *
 */
public class GreenZoneService {
	/**
	 * URL where is placed the GreenZones Service
	 */
	public String SERVICE_URL = "http://localhost:5000";

	/**
	 * Obtains the statistics of GreenZone for a point
	 * 
	 * @param lng
	 *            Longitude of the point
	 * @param lat
	 *            Latitude of the point
	 * @return Object with the point statistic's
	 */
	public GreenZone getGreenZone(double lng, double lat) {
		String response = callRequest(lng, lat);

		// Provisional log TODO add log4j
		System.out.println("GREEN ZONES:");
		System.out.println(response);

		// Parse the String response to JSON
		JSONObject jsonObj = new JSONObject(response);

		GreenZone greenZone = new GreenZone(jsonObj);

		return greenZone;

	}

	/**
	 * Call the rest service who obtains the point statistic's
	 * 
	 * @param lng
	 *            Longitude of the point
	 * @param lat
	 *            Latitude of the point
	 * @return String returned in the rest service
	 */
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
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

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
