package com.rating.service.Controller;
import com.rating.service.Entity.Rating;
import com.rating.service.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/saveRating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
      Rating rating1 =  this.ratingService.createRating(rating);
      return new ResponseEntity<>(rating1, HttpStatus.CREATED);
    }

    @GetMapping("/getAllRatings")
    public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.ok(this.ratingService.getAllRating());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") String userId){

        return ResponseEntity.ok(this.ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("hotelId") String hotelId) {
        return ResponseEntity.ok(this.ratingService.getRatingByHotelId(hotelId));
    }
}
