package com.stackroute.foodieapp.entity;

import java.util.List;

public class RestaurantsResponse {
	
	private String results_start;
	private String results_found;
	private List<Restaurants> restaurants;
	private Restaurant  restaurant;

	public Restaurant getRestaurant() {
	return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
	}
	
	public String getResults_start() {
	return results_start;
	}
	public void setResults_start(String results_start) {
	this.results_start = results_start;
	}
	public String getResults_found() {
	return results_found;
	}
	public void setResults_found(String results_found) {
	this.results_found = results_found;
	}
	public List<Restaurants> getRestaurants() {
	return restaurants;
	}
	public void setRestaurants(List<Restaurants> restaurants) {
	this.restaurants = restaurants;
	}

	public RestaurantsResponse() {
		super();
	}
	
	

}
