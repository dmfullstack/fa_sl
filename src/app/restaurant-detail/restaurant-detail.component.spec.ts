// import { async, ComponentFixture, TestBed } from '@angular/core/testing';
// import { Router } from '@angular/router';
// import { RestaurantDetailComponent } from './restaurant-detail.component';
// import { Http } from '@angular/http';
// import { NgModule } from '@angular/core';
// import { FormsModule } from '@angular/forms';
// import { Observable } from 'rxjs/Observable';
// import 'rxjs/add/observable/of';
// import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
// import { RestaurantSerachService } from '../restaurantsearch-service';
// import { FavouriteRestaurantDetail, FavouriteRestaurant, Location, UserRating } from '../favourite-restaurant-detail';
// import { ActivatedRoute } from '@angular/router';

// describe('RestaurantDetailComponent', () => {
//   let component: RestaurantDetailComponent;
//   let fixture: ComponentFixture<RestaurantDetailComponent>;
//   let resId;


//   const router = {
//     params: Observable.of({ id: 123 })
//   };


//   class MockRestaurantresponseService {
//     authenticated = false;
//     getUserReviewById(resId) {
//       const favouriteRestaurant = new FavouriteRestaurant();
//       favouriteRestaurant.id = '900533';
//       favouriteRestaurant.name = 'Paragon';
//       favouriteRestaurant.featured_image =
//         'https://b.zmtcdn.com/data/res_imagery/901830_RESTAURANT_92f403912757b7f446ca6b3766494b8a.jpg';
//       const location = new Location();
//       location.city = 'ernakulam';
//       favouriteRestaurant.location = location;


//       const user_rating = new UserRating();
//       user_rating.aggregate_rating = 'good';
//       user_rating.votes = '100';
//       user_rating.aggregate_rating = '100';
//       user_rating.rating_text = 'good';
//       favouriteRestaurant.user_rating = user_rating;
//       return Observable.of(favouriteRestaurant);
//     }

//     addFavourite(restaurant) {
//       console.log('restaurant.id + 'Res Fav Value Set As :' + restaurant.addedAsFav);
//     }

//     deleteFavourite(resId) {
//       console.log('DELETE Request is successful With Res Id :', resId);
//     }

//   }

//   beforeEach(async(() => {
//     TestBed.configureTestingModule({
//       imports: [FormsModule],
//       declarations: [RestaurantDetailComponent], providers: [RestaurantSerachService,
//         { provide: HttpClient, useValue: {} },
//         { provide: ActivatedRoute, useValue: { params: Observable.of({ id: 'pinocho' }) } }
//       ]
//     })
//       .compileComponents();
//   }));

//   beforeEach(() => {
//     this.testaurantSearchService = new MockRestaurantresponseService();
//     component = new RestaurantDetailComponent(this.testaurantSearchService, this.router);

//   });

//   it('should be created', () => {
//     console.log('done');
//     expect(component).toBeTruthy();
//   });



// });
