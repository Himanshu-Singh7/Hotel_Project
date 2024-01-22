package com.user.service.service;
import com.user.service.Entites.User;
import com.user.service.Exception.ResourceNotFoundException;
import com.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        String randomUserId =  UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserByUserId(String userId) {
        return this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User id is not found!!" + userId));
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
