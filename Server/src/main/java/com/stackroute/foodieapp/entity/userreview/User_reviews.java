package com.stackroute.foodieapp.entity.userreview;

public class User_reviews {
	
	 private Review review;

	    public Review getReview ()
	    {
	        return review;
	    }

	    public void setReview (Review review)
	    {
	        this.review = review;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [review = "+review+"]";
	    }

}
