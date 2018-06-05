package com.stackroute.foodieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stackroute.foodieapp.dao.service.FoodieAppService;
import com.stackroute.foodieapp.entity.Restaurant;
import com.stackroute.foodieapp.entity.RestaurantsResponse;
import com.stackroute.foodieapp.entity.favourites.FavouriteRestaurant;
import com.stackroute.foodieapp.entity.favourites.FavouriteRestaurantDetail;
import com.stackroute.foodieapp.service.FoodieAppServices;

/**
 * COnnnn
 * 
 * @author ubuntu
 *
 */
@RestController
@RequestMapping("/foodieApp")
@CrossOrigin("*")
public class FoodieAppController {


	@Autowired
	FoodieAppService appService;

	@Autowired
	FoodieAppServices foodieAppManager;

	RestTemplate restTemplate = new RestTemplate();

	private String entityType;

	private int entityId;

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	@RequestMapping("/restaurant")
	public RestaurantsResponse welcome(@RequestParam("city") final String city) {
		RestaurantsResponse restaurantsResponse = foodieAppManager.getRestaurantList(city);
		return foodieAppManager.checkAddedToFav(restaurantsResponse);
	}


	public FoodieAppController() {
		super();
	}
	@RequestMapping(value = "/addFavResToList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void restaurantDetail(@RequestBody final Restaurant restaurant) {
		foodieAppManager.saveFavouriteRestaurant(Integer.parseInt(restaurant.getId()),restaurant.getName());
	}

	@RequestMapping(value = "/updateResComments", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateResComments(@RequestBody final FavouriteRestaurant restaurant) {
		foodieAppManager.saveRestaurantComments(restaurant);
	}

	@RequestMapping(value = "/removeFromFav", method = RequestMethod.DELETE)
	public String removeRestaurantDetailFromList(@RequestParam("resId") final String resId) {
		foodieAppManager.removeFavRestaurant(resId);
		return "Success";
	}

	@RequestMapping("/favouriteList")
	public FavouriteRestaurantDetail fetchFavList() {
		return foodieAppManager.fetchFavResDetail();
	}

	@RequestMapping(value = "/getRestaurantDetailsById", method = RequestMethod.GET)
	public FavouriteRestaurant getRestaurantDetailById(@RequestParam("resId") final String resId) throws Exception{
		return foodieAppManager.getResDetailById(Integer.parseInt(resId));

	}

	@RequestMapping(value = "/getUserReview", method = RequestMethod.GET)
	public FavouriteRestaurant getUserReviews(@RequestParam("resId") String resId) {
		return foodieAppManager.getUserReview(resId);
	}

	@RequestMapping("/restaurantWithCusi")
	public RestaurantsResponse restaurantHavingCuisne(@RequestParam("city") String city,
			@RequestParam("cusine") String cuisine) {

		String cuisineId = foodieAppManager.getCusineId(city, cuisine);
		RestaurantsResponse restaurantsResponse = foodieAppManager.getResByCusine(cuisine);
		return foodieAppManager.checkAddedToFav(restaurantsResponse);

	}

}
