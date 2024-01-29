package com.user.service.service;

import com.user.service.Entites.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //Operation methods
    //Create User
    User saveUser(User user);

    // Get all users

    List<User> getAllUsers();

    //get single user of given userId
    User getUserByUserId(String userId);

  // update user
    User updateUser(User user ,String userId);

    // Delete User

    void deleteUser(String userId);

}
