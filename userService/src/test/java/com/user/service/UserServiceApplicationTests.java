package com.user.service;

import com.user.service.Entites.Rating;
import com.user.service.External.Services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	private RatingService ratingService;
	// Test that the services
//	@Test
//	void createRating(){
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("this is creating using feign client").build();
//
//		Rating saveRating = ratingService.createRating(rating);
//
//		System.out.println("new rating created successfully" + saveRating.toString());
//	}
}
