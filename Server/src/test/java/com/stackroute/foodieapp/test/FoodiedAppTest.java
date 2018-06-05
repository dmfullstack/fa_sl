package com.stackroute.foodieapp.test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.client.RestTemplate;

import com.stackroute.foodieapp.dao.service.FoodieAppService;
import com.stackroute.foodieapp.entity.RestaurantComment;
import com.stackroute.foodieapp.entity.RestaurantsResponse;
import com.stackroute.foodieapp.entity.favourites.FavouriteRestaurant;
import com.stackroute.foodieapp.entity.favourites.FavouriteRestaurantDetail;
import com.stackroute.foodieapp.service.FoodieAppServices;

import junit.framework.Assert;

@RunWith(PowerMockRunner.class)
public class FoodiedAppTest {

	@Mock
	RestTemplate restTemplate;

	@Mock
	FoodieAppService fodieAppSer;

	@InjectMocks
	FoodieAppServices foodieAppService;

	@Before
	public void initMethod() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveFavouriteRestaurantTest() {
		doNothing().when(fodieAppSer).saveResId(anyInt(),anyString());
	}

	@Test
	public void saveRestaurantCommentsTest() {
		doNothing().when(fodieAppSer).saveComments(new RestaurantComment(12345, "comments"));
	}

	@Test
	public void deleteRestaurantCommentsTest() {
		doNothing().when(fodieAppSer).deleteResFromFavourite(anyInt());
	}

	/*@Test
	public void testGetRestaurantDetails() {
		RestaurantsResponse restaurantsResponse = foodieAppService.getRestaurantList("Kochi");
		Assert.assertEquals("1504", restaurantsResponse.getResults_found());
	}*/

	@Test
	public void testGetUserReview() {
		FavouriteRestaurant favouriteRestaurant = foodieAppService.getUserReview("900524");
		Assert.assertEquals("Cafe 17", favouriteRestaurant.getName());
	}

	@Test
	public void testGetCuisneId() {
		String cuisneId = foodieAppService.getCusineId("Mumbai", "Kerala");
		Assert.assertEquals("62", cuisneId);
	}

	@Test
	public void testGetResByCusine() {
		RestaurantsResponse restaurantResponse = foodieAppService.getResByCusine("Kerala");
		Assert.assertEquals(restaurantResponse.getRestaurants().size() > 0,
				restaurantResponse.getRestaurants().size() > 0);
	}

	@Test
	public void testFetchFavResDetail() {
		FavouriteRestaurantDetail favResDetails = foodieAppService.fetchFavResDetail();
		Assert.assertEquals(favResDetails.getFavouritRestaurantList().size() > 0,
				favResDetails.getFavouritRestaurantList().size() > 0);

	}

	@Test
	public void testGetResDetailById() {
		FavouriteRestaurant favouriteRestaurant = foodieAppService.getResDetailById(900533);
		Assert.assertEquals("Paragon", favouriteRestaurant.getName());
	}
	

}
