import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RestaurantSerachService } from '../restaurantsearch-service';
import { FavouriteRestaurant } from '../favourite-restaurant-detail';
import { Restaurants, Restaurant } from '../restaurantsearch';
import { UserReview } from '../userreview';

@Component({
  selector: 'app-restaurant-detail',
  templateUrl: './restaurant-detail.component.html',
  styleUrls: ['./restaurant-detail.component.css'],
  providers: [RestaurantSerachService]
})
export class RestaurantDetailComponent implements OnInit {

  resultset: FavouriteRestaurant;
  restuarant: Restaurant;
  userreview: UserReview;

  public resId: string;
  name: String;



  public constructor(private route: ActivatedRoute, private searchservice: RestaurantSerachService) {
    this.route.params.subscribe((params) => {
      this.resId = params['id'];
    });
    this.name = name;
  }





  checkforAdd(favRestaurant: FavouriteRestaurant, name) {
    console.log(favRestaurant.name);
    console.log(name);
    favRestaurant.comments = name;
    this.searchservice.addComments(favRestaurant);
    this.searchservice.getUserReviewById(this.resId).subscribe(data => this.resultset = data);
  }




  ngOnInit() {
    this.searchservice.getUserReviewById(this.resId).subscribe(data => this.resultset = data);
  }

}

