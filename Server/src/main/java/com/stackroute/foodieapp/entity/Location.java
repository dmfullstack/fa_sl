package com.stackroute.foodieapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
	
	@JsonProperty("city_id")
	private String cityId;
	@JsonProperty("location_verbose")
	private String locationVerbose;
	@JsonProperty("country_id")
	private String countryId;
	private String address;
	private String zipcode;
	private String locality;
	private String longitude;
	private String latitude;
	private String  city;
	public String getCityId() {
	return cityId;
	}
	public void setCityId(String cityId) {
	this.cityId = cityId;
	}
	public String getLocationVerbose() {
	return locationVerbose;
	}
	public void setLocationVerbose(String locationVerbose) {
	this.locationVerbose = locationVerbose;
	}
	public String getCountryId() {
	return countryId;
	}
	public void setCountryId(String countryId) {
	this.countryId = countryId;
	}
	public String getAddress() {
	return address;
	}
	public void setAddress(String address) {
	this.address = address;
	}
	public String getZipcode() {
	return zipcode;
	}
	public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
	}
	public String getLocality() {
	return locality;
	}
	public void setLocality(String locality) {
	this.locality = locality;
	}
	public String getLongitude() {
	return longitude;
	}
	public void setLongitude(String longitude) {
	this.longitude = longitude;
	}
	public String getLatitude() {
	return latitude;
	}
	public void setLatitude(String latitude) {
	this.latitude = latitude;
	}
	public String getCity() {
	return city;
	}
	public void setCity(String city) {
	this.city = city;
	}
	public Location() {
		super();
	}


}
