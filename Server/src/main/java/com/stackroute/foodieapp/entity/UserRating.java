package com.stackroute.foodieapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRating {
	
	@JsonProperty("rating_text")
	private String ratingText;
	@JsonProperty("rating_color")
	private String ratingCcolor;
	@JsonProperty("votes")
	private String votes;
	@JsonProperty("aggregate_rating")
	private String aggregateRating;

	

	public String getVotes() {
	return votes;
	}

	public void setVotes(String votes) {
	this.votes = votes;
	}

	public String getAggregate_rating() {
	return aggregateRating;
	}

	public void setAggregate_rating(String aggregate_rating) {
	this.aggregateRating = aggregate_rating;
	}

	public UserRating() {
		super();
	}

}
