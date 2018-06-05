// Generated using typescript-generator version 2.0.400 on 2018-04-17 04:51:49.

export class RestaurantsResponse {
    results_start: string;
    results_found: string;
    restaurants: Restaurants[];
    restaurant: Restaurant;
}

export class Restaurants {
    restaurant: Restaurant;
}

export class Restaurant {
    cuisines: string;
    photos_url: string;
    location: Location;
    featured_image: string;
    menu_url: string;
    url: string;
    apikey: string;
    id: string;
    name: string;
    has_Online_Delivery: string;
    is_delivering_now: string;
    price_range: string;
    average_cost_for_two: string;
    user_rating: UserRating;
    addedAsFav: boolean;
}

export class Location {
    city_id: string;
    location_verbose: string;
    country_id: string;
    address: string;
    zipcode: string;
    locality: string;
    longitude: string;
    latitude: string;
    city: string;
}

export class UserRating {
    rating_text: string;
    rating_color: string;
    votes: string;
    aggregate_rating: string;
}

