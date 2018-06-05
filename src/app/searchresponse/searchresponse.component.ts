import { Component, OnInit } from '@angular/core';
import { RestaurantSerachService } from '../restaurantsearch-service';
import { RestaurantsResponse } from '../restaurantsearch';
import { Restaurants, Restaurant } from '../restaurantsearch';
import { Router } from '@angular/router';


@Component({
  selector: 'app-searchresponse',
  templateUrl: './searchresponse.component.html',
  styleUrls: ['./searchresponse.component.css'],
  providers: [RestaurantSerachService]
})
export class SearchresponseComponent implements OnInit {


  name: string;
  cusine: string;
  resId: String;
  resultset: RestaurantsResponse;

  constructor(private searchservice: RestaurantSerachService, private p_route: Router) { }

  onCardClick(restaurant: Restaurants) {
    this.p_route.navigate(['resdetail/' + restaurant.restaurant.id]);
  }

  searchforrestaurants() {
    console.log('City Name : ' + this.name);
    this.searchservice.search(this.name, this.cusine).subscribe(data => this.resultset = data);
  }

  addFavourite(restaurant: Restaurants) {
    restaurant.restaurant.addedAsFav = true;
    this.searchservice.addFavourite(restaurant.restaurant);
  }


  removeFavourite(restaurant: Restaurants) {
    this.resId = restaurant.restaurant.id;
    restaurant.restaurant.addedAsFav = false;
    this.searchservice.deleteFavourite(this.resId);
  }


  ngOnInit() {
    this.searchservice.search('Bangalore','Chinese').subscribe(data => this.resultset = data);
  }

}
