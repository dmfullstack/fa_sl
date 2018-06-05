import { Component, OnInit } from '@angular/core';
import { RestaurantSerachService } from './restaurantsearch-service';
import { RestaurantsResponse } from './restaurantsearch';
import { Restaurants } from './restaurantsearch';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [RestaurantSerachService]

})
export class AppComponent implements OnInit {

  title = 'Welcome To My FoodieApp..............Find Your Favourite Hotels Here';
  private resultset: RestaurantsResponse;

  constructor(private searchservice: RestaurantSerachService) { }

  ngOnInit() {
    this.searchservice.search('Bangalore', 'Chinese').subscribe(data => this.resultset = data);
  }

}
