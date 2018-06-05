package com.stackroute.foodieapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cuisine {

	
	@JsonProperty("cuisine_name")
	private String cuisineName;

	@JsonProperty("cuisine_id")
    private String cuisineId;

    public String getCuisine_name ()
    {
        return cuisineName;
    }

    public void setCuisine_name (String cuisine_name)
    {
        this.cuisineName = cuisine_name;
    }

    public String getCuisine_id ()
    {
        return cuisineId;
    }

    public void setCuisine_id (String cuisine_id)
    {
        this.cuisineId = cuisine_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cuisine_name = "+cuisineName+", cuisine_id = "+cuisineId+"]";
    }
	public Cuisine() {
		// TODO Auto-generated constructor stub
	}
	
	public Cuisine(String cuisine_name, String cuisine_id) {
		super();
		this.cuisineName = cuisine_name;
		this.cuisineId = cuisine_id;
	}

}
