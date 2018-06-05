package com.stackroute.foodieapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_comments", schema = "foodieapp")
public class RestaurantComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "restaurant_id")
	private Integer restaurantId;
	
	public RestaurantComment(Integer restaurantId, String comments) {
		super();
		this.restaurantId = restaurantId;
		this.comments = comments;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "res_comments")
	private String comments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public RestaurantComment(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public RestaurantComment() {
		// TODO Auto-generated constructor stub
	}

}
