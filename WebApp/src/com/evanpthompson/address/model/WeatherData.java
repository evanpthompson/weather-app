package com.evanpthompson.address.model;

import java.net.*;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import com.google.gson.*;

/*
 * 	Class unused
 */
	
		
public class WeatherData extends Weather {
	
	public static Weather weatherObj; 
	
	
	
	// class reads JSON data from the weather underground conditions forecast api and stores to strings
	public static void goData() throws IOException {


		String key = "ba8443246355bb06";
		// http://api.wunderground.com/api/ba8443246355bb06/conditions/forecast/q/KS/Olathe.json


		String sURL = "http://api.wunderground.com/api/" + key + "/conditions/forecast/q/KS/Olathe.json";

		// Connect to the URL
		URL url = new URL(sURL);


		// http://api.wunderground.com/api/  website
		// ba8443246355bb06                  api access key
		// /conditions/q/CA/San_Francisco.json    requested info and location

		// address
		// Connect to the URL
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		request.connect();

		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser();
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		JsonObject rootobj = root.getAsJsonObject(); // may be Json Array if it's an array, or other type if a primitive

		// Get some data elements and print them
		int currentTempText =(int) rootobj.get("current_observation").getAsJsonObject().get("temp_f").getAsDouble();
		//System.out.println(temp_f + " F");

		String currentOutlookText = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
				.get("forecastday").getAsJsonArray().get(0).getAsJsonObject().get("fcttext").getAsString();
		//System.out.println(currentConditionForecast);

		String firstOutlook = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
				.get("forecastday").getAsJsonArray().get(1).getAsJsonObject().get("fcttext").getAsString();

		String firstOutlookTitle = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
				.get("forecastday").getAsJsonArray().get(1).getAsJsonObject().get("title").getAsString();

		String secondOutlook = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
				.get("forecastday").getAsJsonArray().get(2).getAsJsonObject().get("fcttext").getAsString();

		String secondOutlookTitle = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
				.get("forecastday").getAsJsonArray().get(2).getAsJsonObject().get("title").getAsString();

		String thirdOutlook = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
				.get("forecastday").getAsJsonArray().get(4).getAsJsonObject().get("fcttext").getAsString();

		String thirdOutlookTitle = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
				.get("forecastday").getAsJsonArray().get(4).getAsJsonObject().get("title").getAsString();


		String condition = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
				.get("forecastday").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString();
		

		
		String file = "/home/silver/Documents/projects/WebApp/png/" + retrieveIcon(condition);
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 

		

		//add the weather icon to the Image Viewer
		ImageIcon currentConditionIcon = new WeatherIcon(image, 55, 55, 55).createIcon();

		//retrieve weather info and assign to object
		//weatherObj = new Weather(currentTempText, currentOutlookText, currentConditionIcon, firstOutlook, firstOutlookTitle, secondOutlook, secondOutlookTitle, thirdOutlook, thirdOutlookTitle);
		
		

	} 
		
	    

	public static String retrieveIcon(String condition) {
		String temp = "";
		
		String[] conditionsArray = {"clear","partlycloudy","chanceflurries","chancerain","chancesleet","chancesnow","chancetstorms"
				,"cloudy","flurries","fog","hazy","mostlycloudy","mostlysunny","partlysunny","sleet","rain","snow","sunny","tstorms"};
		String[] conditionsIconsArray = {"clear3.png","cloudy1.png","winter1.png","cloud35.png","winter1.png","winter1.png","cloud30.png","clouds2.png","water9.png","cloud31.png","cloud31.png","cloud34.png","hidden2.png","cloudy1.png","water9.png","drop4.png","snow3.png","sun5.png","lightning.png"};

		
		
		switch (condition) {
			case "clear": temp = conditionsIconsArray[0]; break;
			case "partlycloudy": temp = conditionsIconsArray[1]; break;
			case "chanceflurries": temp = conditionsIconsArray[2]; break;
			case "chancerain": temp = conditionsIconsArray[3]; break;
			case "chancesleet": temp = conditionsIconsArray[4]; break;
			case "chancesnow": temp = conditionsIconsArray[5]; break;
			case "chancetstorms": temp = conditionsIconsArray[6]; break;
			case "cloudy": temp = conditionsIconsArray[7]; break;
			case "flurries": temp = conditionsIconsArray[8]; break;
			case "fog": temp = conditionsIconsArray[9]; break;
			case "hazy": temp = conditionsIconsArray[10]; break;
			case "mostlycloudy": temp = conditionsIconsArray[0]; break;
			case "mostlysunny": temp = conditionsIconsArray[0]; break;
			case "partlysunny": temp = conditionsIconsArray[0]; break;
			case "sleet": temp = conditionsIconsArray[0]; break;
			case "rain": temp = conditionsIconsArray[0]; break;
			case "snow": temp = conditionsIconsArray[0]; break;
			case "sunny": temp = conditionsIconsArray[0]; break;
			case "tstorms": temp = conditionsIconsArray[0]; break;
		}
		return temp;
	}


	
	
	
	
}

