package com.stackroute.foodieapp.entity;

import java.util.List;

public class CusineResponse {

	private List<Cuisines> cuisines;

    
    public List<Cuisines> getCuisines() {
		return cuisines;
	}
	public void setCuisines(List<Cuisines> cuisines) {
		this.cuisines = cuisines;
	}
	@Override
    public String toString()
    {
        return "ClassPojo [cuisines = "+cuisines+"]";
    }
	public CusineResponse() {
		// TODO Auto-generated constructor stub
	}
	

	
	public CusineResponse(List<Cuisines> cuisines) {
		super();
		this.cuisines = cuisines;
	}

}
