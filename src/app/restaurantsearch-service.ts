import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { RestaurantsResponse } from './restaurantsearch';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Restaurants, Restaurant } from './restaurantsearch';
import { FavouriteRestaurantDetail, FavouriteRestaurant } from './favourite-restaurant-detail';
import { environment } from '../environments/environment';
import { UserReview } from './userreview';


const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
    },
    )
};

@Injectable()
export class RestaurantSerachService {

    headers: Headers;
    getrestaurants: string;
    restaurant: Restaurant;
    user: UserReview;
    favRestaurant: FavouriteRestaurant;
    private _restaurant: Restaurant;
    private globalVal: string;




    constructor(private http: HttpClient) {

    }

    search(name, cusine): Observable<RestaurantsResponse> {
        if (cusine === '') {
            this.getrestaurants = environment.serviceUrl + 'restaurant?city=' + name;
        } else {
            this.getrestaurants = environment.serviceUrl + 'restaurantWithCusi?city=' + name + '&cusine=' + cusine;
        }



        console.log(this.getrestaurants);
        return this.http.get<RestaurantsResponse>(this.getrestaurants);

    }

    getFavResDetail(): Observable<FavouriteRestaurantDetail> {
        this.getrestaurants = environment.serviceUrl + 'favouriteList';
        return this.http.get<FavouriteRestaurantDetail>(this.getrestaurants);

    }

    getRestaurantDetailsById(resId): Observable<FavouriteRestaurant> {
        this.getrestaurants = environment.serviceUrl + 'getRestaurantDetailsById?resId=' + resId;
        return this.http.get<FavouriteRestaurant>(this.getrestaurants);

    }

    getUserReviewById(resId): Observable<FavouriteRestaurant> {
        this.getrestaurants = environment.serviceUrl + 'getUserReview?resId=' + resId;
        return this.http.get<FavouriteRestaurant>(this.getrestaurants);

    }

    addFavourite(restaurant) {
        const restaurantbody = JSON.stringify(restaurant);
        this.http.post('http://localhost:8080/foodieApp/addFavResToList',
            restaurantbody, httpOptions)
            .subscribe(
            data => {
                console.log('POST Request is successful ', data);
            },
            error => {
                console.log('Error', error);
            }
            );

    }

    addComments(favRestaurant) {
        const restaurantbody = JSON.stringify(favRestaurant);
        this.http.post('http://localhost:8080/foodieApp/updateResComments',
            restaurantbody, httpOptions)
            .subscribe(
            data => {
                console.log('POST Request is successful', data);
            },
            error => {
                console.log('Error', error);
            }
            );

    }

    deleteFavourite(resId) {
        this.getrestaurants = environment.serviceUrl + 'removeFromFav?resId=' + resId;
        this.http.delete(this.getrestaurants, httpOptions)
            .subscribe(
            data => {
                console.log('POST Request is successful', data);
            },
            error => {
                console.log('Error', error);
            }
            );

    }
}
