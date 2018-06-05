import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { Router } from '@angular/router';
import { FavouritesComponent } from './favourites.component';
import { Http } from '@angular/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { RestaurantSerachService } from '../restaurantsearch-service';
import { FavouriteRestaurantDetail, FavouriteRestaurant, Location, UserRating } from '../favourite-restaurant-detail';
import { constants } from 'fs';

describe('FavouritesComponent', () => {
  let component: FavouritesComponent;
  let testaurantSearchService: RestaurantSerachService;

  const router = {
    navigate: jasmine.createSpy('viewRestaurant')
  };

  class MockRestaurantresponseService {
    authenticated = false;
    getFavResDetail() {

      const favouriteRestaurantDetail = new FavouriteRestaurantDetail();
      const favouriteRestaurant = new FavouriteRestaurant();
      favouriteRestaurant.id = '900533';
      favouriteRestaurant.name = 'Paragon';
      favouriteRestaurant.featured_image =
        'https://b.zmtcdn.com/data/res_imagery/901830_RESTAURANT_92f403912757b7f446ca6b3766494b8a.jpg';
      const location = new Location();
      location.city = 'ernakulam';
      favouriteRestaurant.location = location;


      const user_rating = new UserRating();
      user_rating.aggregate_rating = 'good';
      user_rating.votes = '100';
      user_rating.aggregate_rating = '100';
      user_rating.rating_text = 'good';
      favouriteRestaurant.user_rating = user_rating;
      favouriteRestaurantDetail.favouritRestaurantList = [favouriteRestaurant];
      return Observable.of(favouriteRestaurantDetail);
    }

    addFavourite(restaurant) {
      console.log('Add Favourite is successful With Res Id :', restaurant.id + 'Res Fav Value Set As :' + restaurant.addedAsFav);
    }

    deleteFavourite(resId) {
      console.log('DELETE Request is successful With Res Id :', resId);
    }

  }

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [FormsModule],
      declarations: [FavouritesComponent], providers: [RestaurantSerachService,
        { provide: HttpClient, useValue: {} },
        { provide: Router, useValue: router }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    this.testaurantSearchService = new MockRestaurantresponseService();
    component = new FavouritesComponent(this.testaurantSearchService, this.router);

  });

  it('should be created', () => {
    console.log('done');
    expect(component).toBeTruthy();
  });

  it('should be able to call API to get Restaurants', () => {
    component.ngOnInit();
    expect(component.resultset.favouritRestaurantList.length).not.toBe(0);
    console.log('Test for search restaurants');
  }
  );

  it('This should Remove Restuarant From Favourite', () => {
    const favouriteRes = new FavouriteRestaurant();
    favouriteRes.id = '900533';
    component.removeFavourite(favouriteRes);
    console.log('Remove Restaurant From Favourite');
  }
  );



});

