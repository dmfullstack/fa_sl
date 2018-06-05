// Generated using typescript-generator version 1.25.322 on 2018-04-24 09:56:50.

export interface UserReview {
    reviews_shown: string;
    reviews_start: string;
    reviews_count: string;
    user_reviews: User_reviews[];
}

export interface User_reviews {
    review: Review;
}

export interface Review {
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

export interface User {
    profile_url: string;
    profile_image: string;
    profile_deeplink: string;
    name: string;
    foodie_level: string;
    foodie_color: string;
    foodie_level_num: string;
}
