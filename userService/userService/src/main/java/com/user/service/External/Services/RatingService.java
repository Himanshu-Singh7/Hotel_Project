package com.user.service.External.Services;
import com.user.service.Entites.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name ="RATING-SERVICE")
public interface RatingService {

    // get
    //Post
    @PostMapping("/ratings/saveRating")
    Rating createRating(Rating values);
    // Put

    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating values);

    // delete

    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable("ratingId") String ratingId);
}
