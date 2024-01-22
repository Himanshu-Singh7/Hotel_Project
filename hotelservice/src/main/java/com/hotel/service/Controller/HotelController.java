package com.hotel.service.Controller;
import com.hotel.service.Entites.Hotel;
import com.hotel.service.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @PostMapping("/saveHotels")
    public ResponseEntity<Hotel>  createHotel(@RequestBody Hotel hotel){
       Hotel hotel1 = this.hotelService.createHotel(hotel);
       return new ResponseEntity<>(hotel1 , HttpStatus.CREATED);
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<List<Hotel>> getAllHotels(){

        return ResponseEntity.ok(this.hotelService.getHotelList());
    }

    @GetMapping("{id}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable ("id") String id){
        return ResponseEntity.ok(this.hotelService.getHotel(id));
    }

}
