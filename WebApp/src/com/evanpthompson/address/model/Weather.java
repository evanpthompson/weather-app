package com.evanpthompson.address.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javafx.scene.image.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Weather {
	
	private static Integer currentTemp;
	private static String currentOutlook;
	private static ImageView currentConditionIcon;
	private static String firstOutlook;
	private static String firstOutlookTitle;
	private static String secondOutlook;
	private static String secondOutlookTitle;
	private static String thirdOutlook;
	private static String thirdOutlookTitle;
	public static Weather weatherObj;
	

	public Weather() {
		try {
			goData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public Weather(Integer currentTemp, String currentOutlook,
			ImageView currentConditionIcon, String firstOutlook,
			String firstOutlookTitle, String secondOutlook,
			String secondOutlookTitle, String thirdOutlook,
			String thirdOutlookTitle) {
		super();
		this.currentTemp = currentTemp;
		this.currentOutlook = currentOutlook;
		this.currentConditionIcon = currentConditionIcon;
		this.firstOutlook = firstOutlook;
		this.firstOutlookTitle = firstOutlookTitle;
		this.secondOutlook = secondOutlook;
		this.secondOutlookTitle = secondOutlookTitle;
		this.thirdOutlook = thirdOutlook;
		this.thirdOutlookTitle = thirdOutlookTitle;
	}



	public Integer getcurrentTemp() {
		return currentTemp;
	}


	public String getcurrentOutlook() {
		return currentOutlook;
	}


	public ImageView getCurrentConditionIcon() {
		return currentConditionIcon;
	}


	public String getFirstOutlook() {
		return firstOutlook;
	}


	public String getFirstOutlookTitle() {
		return firstOutlookTitle;
	}


	public String getSecondOutlook() {
		return secondOutlook;
	}


	public String getSecondOutlookTitle() {
		return secondOutlookTitle;
	}


	public String getThirdOutlook() {
		return thirdOutlook;
	}


	public String getThirdOutlookTitle() {
		return thirdOutlookTitle;
	}


	private void setcurrentTemp(Integer currentTemp) {
		this.currentTemp = currentTemp;
	}


	private void setcurrentOutlook(String currentOutlook) {
		this.currentOutlook = currentOutlook;
	}


	private void setCurrentConditionIcon(ImageView currentConditionIcon) {
		this.currentConditionIcon = currentConditionIcon;
	}


	private void setFirstOutlook(String firstOutlook) {
		this.firstOutlook = firstOutlook;
	}


	private void setFirstOutlookTitle(String firstOutlookTitle) {
		this.firstOutlookTitle = firstOutlookTitle;
	}


	private void setSecondOutlook(String secondOutlook) {
		this.secondOutlook = secondOutlook;
	}


	private void setSecondOutlookTitle(String secondOutlookTitle) {
		this.secondOutlookTitle = secondOutlookTitle;
	}


	private void setThirdOutlook(String thirdOutlook) {
		this.thirdOutlook = thirdOutlook;
	}


	private void setThirdOutlookTitle(String thirdOutlookTitle) {
		this.thirdOutlookTitle = thirdOutlookTitle;
	}

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
			int tempCurrentTempText =(int) rootobj.get("current_observation").getAsJsonObject().get("temp_f").getAsDouble();
			//System.out.println(temp_f + " F");

			String tempcurrentOutlook = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
					.get("forecastday").getAsJsonArray().get(0).getAsJsonObject().get("fcttext").getAsString();
			//System.out.println(currentConditionForecast);

			String tempFirstOutlook = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
					.get("forecastday").getAsJsonArray().get(1).getAsJsonObject().get("fcttext").getAsString();

			String tempFirstOutlookTitle = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
					.get("forecastday").getAsJsonArray().get(1).getAsJsonObject().get("title").getAsString();

			String tempSecondOutlook = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
					.get("forecastday").getAsJsonArray().get(2).getAsJsonObject().get("fcttext").getAsString();

			String tempSecondOutlookTitle = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
					.get("forecastday").getAsJsonArray().get(2).getAsJsonObject().get("title").getAsString();

			String tempThirdOutlook = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
					.get("forecastday").getAsJsonArray().get(4).getAsJsonObject().get("fcttext").getAsString();

			String tempThirdOutlookTitle = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
					.get("forecastday").getAsJsonArray().get(4).getAsJsonObject().get("title").getAsString();


			String tempCondition = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject()
					.get("forecastday").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString();
			

			
			String file = "file:/home/silver/Documents/projects/WebApp/png/" + retrieveIcon(tempCondition);
			
			Image image = new Image(file);
			ImageView tempCurrentConditionIcon = new ImageView(image);
			
			/*BufferedImage image = null;
			try {
				image = ImageIO.read(new File(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
			 

			

			//add the weather icon to the Image Viewer
			ImageIcon tempCurrentConditionIcon = new WeatherIcon(image, 55, 55, 55).createIcon();
			*/
			//retrieve weather info and assign to object
			
			weatherObj = new Weather(tempCurrentTempText, tempcurrentOutlook, tempCurrentConditionIcon, tempFirstOutlook, tempFirstOutlookTitle, tempSecondOutlook, tempSecondOutlookTitle, tempThirdOutlook, tempThirdOutlookTitle);
		
			
		
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
	

	@Override
	public String toString() {
		return "Weather [currentTemp=" + currentTemp
				+ ", currentOutlook=" + currentOutlook
				+ ", currentConditionIcon=" + currentConditionIcon
				+ ", firstOutlook=" + firstOutlook + ", firstOutlookTitle="
				+ firstOutlookTitle + ", secondOutlook=" + secondOutlook
				+ ", secondOutlookTitle=" + secondOutlookTitle
				+ ", thirdOutlook=" + thirdOutlook + ", thirdOutlookTitle="
				+ thirdOutlookTitle + "]";
	}


	
	
	
	

}
