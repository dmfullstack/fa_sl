package com.stackroute.foodieapp.helper;

import org.springframework.http.HttpHeaders;

public class FoodieAppUtil {

	public FoodieAppUtil() {
		// TODO Auto-generated constructor stub
	}

	public static String getEndPoint(){
		String url = "https://developers.zomato.com/api/v2.1/";
		return url;
	}
	
	public static HttpHeaders populateHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-key", "10ae6968ff73a315cd11efc17c88485d");
		return headers;
	}

}
