import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { Router } from '@angular/router';
import { HomeComponent } from './home.component';
import { Http } from '@angular/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { RestaurantSerachService } from '../restaurantsearch-service';
import { RestaurantsResponse, Restaurants, Restaurant, Location, UserRating } from '../restaurantsearch';

describe('HomeComponent', () => {
  let component: HomeComponent;
  let testaurantSearchService: RestaurantSerachService;
  const newRestaurant = new Restaurant();
  newRestaurant.id = '5689';


  const restaurantsList = new Restaurants();
  restaurantsList.restaurant = newRestaurant;

  const router = {
    navigate: jasmine.createSpy('viewRestaurant')
  };

  class MockRestaurantresponseService {
    authenticated = false;
    search() {
      const searchRestaurantsResponse = new RestaurantsResponse();
      const restaurant = new Restaurant();

      restaurant.name = 'test';
      restaurant.id = '123';
      restaurant.featured_image =
        'https://b.zmtcdn.com/data/res_imagery/901830_RESTAURANT_92f403912757b7f446ca6b3766494b8a.jpg';
      const location = new Location();
      location.address = 'test';
      restaurant.location = location;


      const user_rating = new UserRating();
      user_rating.aggregate_rating = 'good';
      user_rating.votes = '100';
      user_rating.aggregate_rating = '100';
      user_rating.rating_text = 'good';
      restaurant.user_rating = user_rating;

      const restaurants = new Restaurants();
      restaurants.restaurant = restaurant;
      searchRestaurantsResponse.restaurants = [restaurants];
      return Observable.of(searchRestaurantsResponse);
    }

    addFavourite(restaurant) {
      console.log('POST Request For Add Favourite is successful With Res Id :', restaurant.id);
    }

    deleteFavourite(resId) {
      console.log('DELETE Request is successful With Res Id :', resId);
    }

  }

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [FormsModule],
      declarations: [HomeComponent], providers: [RestaurantSerachService,
        { provide: HttpClient, useValue: {} },
        { provide: Router, useValue: router }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    this.testaurantSearchService = new MockRestaurantresponseService();
    component = new HomeComponent(this.testaurantSearchService, this.router);

  });

  it('should be created', () => {
    console.log('done');
    expect(component).toBeTruthy();
  });

  it('should be able to call API to get Restaurants', () => {
    component.ngOnInit();
    expect(component.resultset.restaurants.length).not.toBe(0);
    console.log('Test for search restaurants');
  }
  );

  it('This should Add Restuarant To Favourite', () => {
    const restaurantsNew = new Restaurants();
    const restaurantData = new Restaurant();
    restaurantData.id = '900533';
    restaurantsNew.restaurant = restaurantData;
    component.addFavourite(restaurantsNew);
    console.log('Add Restaurant To Favourite');
  }
  );

  it('This should Delete Restuarant From Favourite', () => {
    const restaurantsNew = new Restaurants();
    const restaurantData = new Restaurant();
    restaurantData.id = '900533';
    restaurantsNew.restaurant = restaurantData;
    component.removeFavourite(restaurantsNew);
    console.log('Delete Restaurant From Favourite List');
  }
  );

});
