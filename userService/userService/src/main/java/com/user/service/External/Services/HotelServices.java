package com.user.service.External.Services;
import com.user.service.Entites.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name ="HOTEL-SERVICE")
public interface HotelServices {

    @RequestMapping(method = RequestMethod.GET, value = "/hotels/{hotelId}")
    ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") String hotelId);
}
 