package com.rating.service.Service;

import com.rating.service.Entity.Rating;

import java.util.List;

public interface RatingService {

    //Create a rating

    Rating createRating(Rating rating);

    // get all ratings
    List<Rating> getAllRating();
    // get all by userId

    List<Rating> getRatingByUserId(String userId);


    // get all by hotel

    List<Rating> getRatingByHotelId(String hotelId);

}
