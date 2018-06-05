// Generated using typescript-generator version 1.25.322 on 2018-04-25 04:50:38.

export class FavouriteRestaurantDetail {
    favouritRestaurantList: FavouriteRestaurant[];
}

export class FavouriteRestaurant {
    cuisines: string;
    photos_url: string;
    has_online_delivery: string;
    location: Location;
    featured_image: string;
    offers: string[];
    menu_url: string;
    is_delivering_now: string;
    url: string;
    switch_to_order_menu: string;
    user_rating: UserRating;
    apikey: string;
    currency: string;
    id: string;
    price_range: string;
    name: string;
    deeplink: string;
    events_url: string;
    average_cost_for_two: string;
    thumb: string;
    has_table_booking: string;
    comments: string;
    userReview: string;
    user_reviews: User_reviews[];
    addedAsFav: boolean;
    r: R;
    userComments: string[];
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

export class User_reviews {
    review: Review;
}

export class R {
    res_id: string;
}

export class Review {
    timestamp: string;
    rating_text: string;
    id: string;
    comments_count: string;
    rating_color: string;
    likes: string;
    rating: string;
    user: User;
    review_text: string;
    review_time_friendly: string;
}

export class User {
    profile_url: string;
    profile_image: string;
    profile_deeplink: string;
    name: string;
    foodie_level: string;
    foodie_color: string;
    foodie_level_num: string;
}
