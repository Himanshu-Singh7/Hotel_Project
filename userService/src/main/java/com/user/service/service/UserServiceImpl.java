package com.user.service.service;

import com.user.service.Entites.Hotel;
import com.user.service.Entites.Rating;
import com.user.service.Entites.User;
import com.user.service.Exception.ResourceNotFoundException;
import com.user.service.External.Services.HotelServices;
import com.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServices hotelServices;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {
        String randomUserId =  UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        // Implementation RATING Service Call : Using REST template
      //  ArrayList<Rating> forObj =  restTemplate.getForObject("http://localhost:8081/users/getAllUsers", ArrayList.class);
 //       logger.info(" {} ", forObj);
        List<User> alluser = this.userRepository.findAll();
//        for(Rating r: forObj) {
//            for (User u : alluser) {
//               if (r.getUserId() == u.getUserId()) {
//                    u.setRating(forObj);
//                }
//           }
//       }

        return alluser;
    }


    // Get Single User
    @Override
    public User getUserByUserId(String userId) {
        // Get User from database and help wth userRepository
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User id is not found!!" + userId));
        // fetch rating of the user from Rating service
        // http://localhost:8083/ratings/users/2a0188e8-aa10-43eb-8215-a6e217887f12
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{}",ratingsOfUser);

             List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

             List<Rating> ratingList = ratings.stream().map(rating -> {
  //           ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" +rating.getHotelId(), Hotel.class);
                 ResponseEntity<Hotel> hotelResponse = hotelServices.getHotel(rating.getHotelId());
                 logger.info("status code ", hotelResponse.getStatusCode());

                 Hotel hotel = hotelResponse.getBody();
             //set the hotel to rating
            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());


        user.setRating(ratingList);
        return user;
    }

    @Override
    public User updateUser(User user, String userId) {
        User user1 = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User id is not found!!" + userId));
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAbout(user.getAbout());
        return this.userRepository.save(user1);
    }

    @Override
    public void deleteUser(String userId) {
       User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user is not present!!" + userId));
       this.userRepository.delete(user);
    }

}
