package es.aragon.ironsheep.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

import es.aragon.ironsheep.data.entities.Weather;

public class WeatherService {

	public String SERVICE_URL = "http://api.openweathermap.org/data/2.5/weather?";
	public String APPID = "46a273184ac8214d9bb11edd7125e38f";

	public Weather getCurrentWeather(double lng, double lat) {
		
		String response = callRequest(lng, lat);
		System.out.println("WEATHER:");
		System.out.println(response);
		JSONObject jsonObj = new JSONObject(response);
		
		Weather weather = new Weather(jsonObj);
		return weather;
	}

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
