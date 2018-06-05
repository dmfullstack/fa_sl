import { Component, OnInit } from '@angular/core';
import { RestaurantSerachService } from '../restaurantsearch-service';
import { RestaurantsResponse } from '../restaurantsearch';
import { Restaurants, Restaurant } from '../restaurantsearch';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [RestaurantSerachService]
})
export class HomeComponent implements OnInit {

  name: string;
  cusine: string;
  resId: String;
  resultset: RestaurantsResponse;


  constructor(private searchservice: RestaurantSerachService, private p_route: Router) { }

  onCardClick(restaurant: Restaurants) {
    console.log('On Card Click');
    this.p_route.navigate(['resdetail/' + restaurant.restaurant.id]);
  }
  ngOnInit() {

   this.searchservice.search('Bangalore','Chinese').subscribe(data => this.resultset = data);
  }


  addFavourite(restaurant: Restaurants) {
    console.log('Restaurants : ' + restaurant);
    restaurant.restaurant.addedAsFav = true;
    this.searchservice.addFavourite(restaurant.restaurant);
  }


  removeFavourite(restaurant: Restaurants) {
    this.resId = restaurant.restaurant.id;
    restaurant.restaurant.addedAsFav = false;
    this.searchservice.deleteFavourite(this.resId);
  }


}
