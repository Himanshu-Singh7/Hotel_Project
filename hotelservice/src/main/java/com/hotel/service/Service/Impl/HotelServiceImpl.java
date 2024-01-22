package com.hotel.service.Service.Impl;
import com.hotel.service.Entites.Hotel;
import com.hotel.service.Exception.ResourceNotFoundException;
import com.hotel.service.Repository.HotelRepository;
import com.hotel.service.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
       String randomHotelId = UUID.randomUUID().toString();
       hotel.setId(randomHotelId);
        return this.hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getHotelList() {
        return this.hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        Hotel hotel = this.hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("hotel given id is not found" + id));
        return hotel;

    }
}
