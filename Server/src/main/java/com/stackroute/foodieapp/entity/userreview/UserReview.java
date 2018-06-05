package com.stackroute.foodieapp.entity.userreview;

public class UserReview {
	
	 private String reviews_shown;

	    private String reviews_start;

	    private String reviews_count;

	    private User_reviews[] user_reviews;

	   

	    public String getReviews_shown ()
	    {
	        return reviews_shown;
	    }

	    public void setReviews_shown (String reviews_shown)
	    {
	        this.reviews_shown = reviews_shown;
	    }

	    public String getReviews_start ()
	    {
	        return reviews_start;
	    }

	    public void setReviews_start (String reviews_start)
	    {
	        this.reviews_start = reviews_start;
	    }

	    public String getReviews_count ()
	    {
	        return reviews_count;
	    }

	    public void setReviews_count (String reviews_count)
	    {
	        this.reviews_count = reviews_count;
	    }

	    public User_reviews[] getUser_reviews ()
	    {
	        return user_reviews;
	    }

	    public void setUser_reviews (User_reviews[] user_reviews)
	    {
	        this.user_reviews = user_reviews;
	    }

	    
	    @Override
	    public String toString()
	    {
	        return "ClassPojo [reviews_shown = "+reviews_shown+", reviews_start = "+reviews_start+", reviews_count = "+reviews_count+", user_reviews = "+user_reviews+"]";
	    }

}
