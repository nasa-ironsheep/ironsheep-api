package es.aragon.ironsheep.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import es.aragon.ironsheep.data.entities.Weather;

/**
 * Obtains the current weather of a point
 * 
 * @author ARTURO
 *
 */
public class WeatherService {

	/**
	 * URL where is placed the Weather Service
	 */
	public String SERVICE_URL = "http://api.openweathermap.org/data/2.5/weather?";

	/**
	 * APPID for query the weather values
	 */
	public String APPID = "46a273184ac8214d9bb11edd7125e38f";

	/**
	 * Obtains the statistics of Weather for a point
	 * 
	 * @param lng
	 *            Longitude of the point
	 * @param lat
	 *            Latitude of the point
	 * @return Object with the point statistic's
	 */
	public Weather getCurrentWeather(double lng, double lat) {
		String response = callRequest(lng, lat);

		// Provisional log TODO add log4j
		System.out.println("WEATHER:");
		System.out.println(response);

		// Parse the String response to JSON
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject(response);
		} catch (JSONException e) {
			System.out.println("Error generating JSONObject");
		}

		Weather weather = new Weather(jsonObj);
		return weather;
	}

	/**
	 * Call the service who obtains the point statistic's
	 * 
	 * @param lng
	 *            Longitude of the point
	 * @param lat
	 *            Latitude of the point
	 * @return String returned in the service
	 */
	private String callRequest(double lng, double lat) {
		String response = "";
		try {
			String urlParam = SERVICE_URL;
			urlParam += "lon=" + lng;
			urlParam += "&lat=" + lat;
			urlParam += "&APPID=" + APPID;

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
