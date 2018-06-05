package com.stackroute.foodieapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fav_Res_Details", schema = "foodieapp")
public class FavoriteEntity {

	@Id
	@Column(name = "restaurant_id")
	private Integer restaurantId;
	@Column(name = "restaurant_Name")
	private String restaurantName;

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public FavoriteEntity(int restaurantId, String resName) {
		this.restaurantId = restaurantId;
		this.restaurantName = resName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public FavoriteEntity() {
		// TODO Auto-generated constructor stub
	}

}
