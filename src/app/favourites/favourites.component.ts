import { Component, OnInit } from '@angular/core';
import { RestaurantSerachService } from '../restaurantsearch-service';
import { FavouriteRestaurantDetail, FavouriteRestaurant } from '../favourite-restaurant-detail';
import { Router } from '@angular/router';

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css'],
  providers: [RestaurantSerachService]
})
export class FavouritesComponent implements OnInit {

  resultset: FavouriteRestaurantDetail;
  favouriteRestaurant: FavouriteRestaurant;
  resId: string;

  constructor(private searchservice: RestaurantSerachService, private p_route: Router) { }

  ngOnInit() {
    this.searchservice.getFavResDetail().subscribe(data => this.resultset = data);
  }

  onCardClick(restaurant: FavouriteRestaurant) {
    this.p_route.navigate(['resdetail/' + restaurant.id]);
  }

  removeFavourite(restaurant: FavouriteRestaurant) {
    console.log(restaurant.name);
    this.resId = restaurant.id;
    restaurant.addedAsFav = false;
    this.searchservice.deleteFavourite(this.resId);
    this.searchservice.getFavResDetail().subscribe(data => this.resultset = data);

  }

}
