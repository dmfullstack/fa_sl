package com.stackroute.foodieapp.entity;

public class Cuisines {
	
	private Cuisine cuisine;

    public Cuisines(Cuisine cuisine) {
		super();
		this.cuisine = cuisine;
	}

	public Cuisine getCuisine ()
    {
        return cuisine;
    }

    public void setCuisine (Cuisine cuisine)
    {
        this.cuisine = cuisine;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cuisine = "+cuisine+"]";
    }

	public Cuisines() {
		// TODO Auto-generated constructor stub
	}

}
