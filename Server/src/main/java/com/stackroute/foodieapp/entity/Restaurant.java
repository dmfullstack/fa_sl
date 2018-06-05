package com.stackroute.foodieapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Restaurant {
	
	private String cuisines;
	@JsonProperty("photos_url")
	private String photosUrl;
	@JsonProperty("has_Online_Delivery")
	private String hasOnlineDelivery;
	private Location location;
	@JsonProperty("featured_image")
	private String featuredImage;
	@JsonProperty("menu_url")
	private String menuUrl;
	@JsonProperty("is_delivering_now")
	private String isDeliveringNow;
	private String url;
	private String apikey;
	private String id;
	@JsonProperty("price_range")
	private String priceRange;
	private String name;
	@JsonProperty("average_cost_for_two")
	private String averageCostForTwo;
	@JsonProperty("user_rating")
	private UserRating userRating;
	
	private boolean addedAsFav;

	
	
	

	public String getCuisines() {
		return cuisines;
	}

	public void setCuisines(String cuisines) {
		this.cuisines = cuisines;
	}

	public String getPhotosUrl() {
	return photosUrl;
	}

	public void setPhotosUrl(String photosUrl) {
	this.photosUrl = photosUrl;
	}

	public String getHasOnlineDelivery() {
	return hasOnlineDelivery;
	}

	public void setHasOnlineDelivery(String hasOnlineDelivery) {
	this.hasOnlineDelivery = hasOnlineDelivery;
	}

	public Location getLocation() {
	return location;
	}

	public void setLocation(Location location) {
	this.location = location;
	}

	public String getFeaturedImage() {
	return featuredImage;
	}

	public void setFeaturedImage(String featuredImage) {
	this.featuredImage = featuredImage;
	}

	public String getMenuUrl() {
	return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
	this.menuUrl = menuUrl;
	}

	public String getIsDeliveringNow() {
	return isDeliveringNow;
	}

	public void setIsDeliveringNow(String isDeliveringNow) {
	this.isDeliveringNow = isDeliveringNow;
	}

	public String getUrl() {
	return url;
	}

	public void setUrl(String url) {
	this.url = url;
	}

	public String getApikey() {
	return apikey;
	}

	public void setApikey(String apikey) {
	this.apikey = apikey;
	}

	public String getId() {
	return id;
	}

	public void setId(String id) {
	this.id = id;
	}

	public String getPriceRange() {
	return priceRange;
	}

	public void setPriceRange(String priceRange) {
	this.priceRange = priceRange;
	}

	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public String getAverageCostForTwo() {
	return averageCostForTwo;
	}

	public void setAverageCostForTwo(String averageCostForTwo) {
	this.averageCostForTwo = averageCostForTwo;
	}

	public UserRating getUserRating() {
	return userRating;
	}

	public void setUserRating(UserRating userRating) {
	this.userRating = userRating;
	}

	public boolean isAddedAsFav() {
		return addedAsFav;
	}

	public void setAddedAsFav(boolean addedAsFav) {
		this.addedAsFav = addedAsFav;
	}

	public Restaurant() {
		super();
	}
	
	

}
