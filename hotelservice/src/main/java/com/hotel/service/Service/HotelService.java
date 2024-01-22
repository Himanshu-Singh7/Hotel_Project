package com.hotel.service.Service;

import com.hotel.service.Entites.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    //create Hotel

    Hotel createHotel(Hotel hotel);

    // get all hotel

    List<Hotel> getHotelList();
    //get single hotel

    Hotel getHotel(String id);
}
