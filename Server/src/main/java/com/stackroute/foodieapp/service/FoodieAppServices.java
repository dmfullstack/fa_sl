package com.stackroute.foodieapp.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.stackroute.foodieapp.dao.service.FoodieAppService;
import com.stackroute.foodieapp.entity.Cuisines;
import com.stackroute.foodieapp.entity.CusineResponse;
import com.stackroute.foodieapp.entity.FavoriteEntity;
import com.stackroute.foodieapp.entity.RestaurantComment;
import com.stackroute.foodieapp.entity.Restaurants;
import com.stackroute.foodieapp.entity.RestaurantsResponse;
import com.stackroute.foodieapp.entity.favourites.FavouriteRestaurant;
import com.stackroute.foodieapp.entity.favourites.FavouriteRestaurantDetail;
import com.stackroute.foodieapp.entity.userreview.UserReview;
import com.stackroute.foodieapp.helper.FoodieAppUtil;

@Component
public class FoodieAppServices {

	@Autowired
	FoodieAppService appService;

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

	public void saveFavouriteRestaurant(Integer restuarntId,String resName) {
		appService.saveResId(restuarntId,resName);
	}

	public void saveRestaurantComments(final FavouriteRestaurant restaurant) {
		RestaurantComment restaurantComment = new RestaurantComment(Integer.parseInt(restaurant.getId()),
				restaurant.getComments());
		appService.saveComments(restaurantComment);
	}

	public void removeFavRestaurant(final String resId) {
		/*List<FavoriteEntity> favEntityList = appService.findById(id)
		Integer resIds = Integer.parseInt(resId);
		int entityId = 0;*/
		/*for (FavoriteEntity favoriteEntity : favEntityList) {
			if (resIds.equals(favoriteEntity.getRestaurantId())) {
				entityId = favoriteEntity.getId();
			}

		}*/

		appService.deleteResFromFavourite(Integer.parseInt(resId));
	}

	public RestaurantsResponse getRestaurantList(final String city) {
		setEntityDetails(city);
		return populateRestaurantList(entityId, entityType);
	}

	private void setEntityDetails(final String city) {
		HttpEntity<String> entity = new HttpEntity<>(FoodieAppUtil.populateHeader());
		StringBuilder serviceEndPointUrl = new StringBuilder(FoodieAppUtil.getEndPoint());
		serviceEndPointUrl.append("locations?query=");
		serviceEndPointUrl.append(city);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> category = restTemplate.exchange(serviceEndPointUrl.toString(), HttpMethod.GET, entity,
				String.class);
		JSONObject object = new JSONObject(category.getBody());
		JSONObject locations = (JSONObject) object.getJSONArray("location_suggestions").get(0);
		setEntityType(locations.getString("entity_type"));
		setEntityId(locations.getInt("entity_id"));
	}

	private RestaurantsResponse populateRestaurantList(final int entityId, final String entityType) {

		HttpEntity<String> entity = new HttpEntity<>(FoodieAppUtil.populateHeader());

		StringBuilder serviceEndPointUrl = new StringBuilder(FoodieAppUtil.getEndPoint());
		serviceEndPointUrl.append("search?entity_id=");

		serviceEndPointUrl.append(entityId);
		if (null != entityType && !"".equalsIgnoreCase(entityType)) {
			serviceEndPointUrl.append("&entity_type=").append(entityType);
		}

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<RestaurantsResponse> restaurantResponse = restTemplate.exchange(serviceEndPointUrl.toString(),
				HttpMethod.GET, entity, RestaurantsResponse.class);

		return restaurantResponse.getBody();

	}

	public FavouriteRestaurantDetail fetchFavResDetail() {
		List<FavouriteRestaurant> favResList = new ArrayList<>();

		List<FavoriteEntity> favEntityList = appService.fetchAllRecords();
		for (FavoriteEntity favoriteEntity : favEntityList) {
			FavouriteRestaurant favouriteRestaurant = null;
				favouriteRestaurant = getResDetailById(favoriteEntity.getRestaurantId());
			if (null != favouriteRestaurant) {
				favResList.add(favouriteRestaurant);
			}

		}

		FavouriteRestaurantDetail favouriteRestaurantDetail = new FavouriteRestaurantDetail();
		favouriteRestaurantDetail.setFavouritRestaurantList(favResList);
		return favouriteRestaurantDetail;
	}

	public FavouriteRestaurant getResDetailById(final int resId)  {
		
		ResponseEntity<FavouriteRestaurant> restuarntDetail = null;

			HttpEntity<String> entity = new HttpEntity<>(FoodieAppUtil.populateHeader());
			StringBuilder serviceEndPointUrl = new StringBuilder(FoodieAppUtil.getEndPoint()).append("restaurant?res_id=").append(resId);
			RestTemplate restTemplate = new RestTemplate();
			restuarntDetail = restTemplate.exchange(serviceEndPointUrl.toString(), HttpMethod.GET, entity,
					FavouriteRestaurant.class);

		return restuarntDetail.getBody();

	}

	public FavouriteRestaurant getUserReview(final String resId) {

		FavouriteRestaurant favouriteRestaurant = null;
			favouriteRestaurant = getResDetailById(Integer.parseInt(resId));
		List<RestaurantComment> restCommentList = appService.fetchResComments();
		List<String> commentsList = new ArrayList<String>();
		for(RestaurantComment comment : restCommentList){
			if(comment.getRestaurantId() == Integer.parseInt(resId)){
				commentsList.add(comment.getComments());
			}
		}
		
		favouriteRestaurant.setUserComments(commentsList);

		HttpEntity<String> entity = new HttpEntity<>(FoodieAppUtil.populateHeader());
		StringBuilder serviceEndPointUrl = new StringBuilder(FoodieAppUtil.getEndPoint());
		serviceEndPointUrl.append("reviews?res_id=");
		serviceEndPointUrl.append(resId);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserReview> restuarntDetail = restTemplate.exchange(serviceEndPointUrl.toString(),
				HttpMethod.GET, entity, UserReview.class);

		UserReview userReview = restuarntDetail.getBody();

		favouriteRestaurant.setUser_reviews(userReview.getUser_reviews());

		return favouriteRestaurant;
	}

	public RestaurantsResponse checkAddedToFav(RestaurantsResponse restaurantsResponse) {

		List<FavoriteEntity> favEntityList = appService.fetchAllRecords();
		List<String> resIdList = new ArrayList<String>();
		for (FavoriteEntity favoriteEntity : favEntityList) {
			resIdList.add(Integer.toString(favoriteEntity.getRestaurantId()));
		}

		if (null != resIdList) {
			for (Restaurants restaurant : restaurantsResponse.getRestaurants()) {
				if (resIdList.contains(restaurant.getRestaurant().getId())) {
					restaurant.getRestaurant().setAddedAsFav(true);
				}
			}
		}

		return restaurantsResponse;

	}

	public String getCusineId(final String city, final String cuisine) {

		HttpEntity<String> entity = new HttpEntity<>(FoodieAppUtil.populateHeader());
		setEntityDetails(city);
		StringBuilder serviceEndPointUrl = new StringBuilder(
				"https://developers.zomato.com/api/v2.1/cuisines?city_id=");
		serviceEndPointUrl.append(entityId);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CusineResponse> cusine = restTemplate.exchange(serviceEndPointUrl.toString(), HttpMethod.GET,
				entity, CusineResponse.class);

		String cuisineId = null;

		for (Cuisines cusines : cusine.getBody().getCuisines()) {
			if (cusines.getCuisine().getCuisine_name().equalsIgnoreCase(cuisine)) {
				cuisineId = cusines.getCuisine().getCuisine_id();
			}
		}

		return cuisineId;
	}

	public RestaurantsResponse getResByCusine(final String cuisine) {

		HttpEntity<String> entity = new HttpEntity<>(FoodieAppUtil.populateHeader());
		StringBuilder serviceEndPointUrl = new StringBuilder(FoodieAppUtil.getEndPoint()).append("search?entity_id=").append(entityId);
		if (null != entityType && !"".equalsIgnoreCase(entityType)) {
			serviceEndPointUrl.append("&entity_type=").append(entityType);
		}

		if (null != cuisine && !"".equalsIgnoreCase(cuisine)) {
			serviceEndPointUrl.append("&q=").append(cuisine);
		}

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<RestaurantsResponse> category = restTemplate.exchange(serviceEndPointUrl.toString(),
				HttpMethod.GET, entity, RestaurantsResponse.class);
		return category.getBody();

	}

	public FoodieAppServices() {
		super();
	}

}
