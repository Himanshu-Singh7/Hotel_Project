package com.user.service.Controller;
import com.user.service.Entites.User;
import com.user.service.payload.ApiResponse;
import com.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    // http://localhost:8081/users/saveUser
    @PostMapping("/saveUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
     User saveUser = this.userService.saveUser(user);
     return new ResponseEntity<>(saveUser , HttpStatus.OK);
    }

    //Get Single User
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
       User user = this.userService.getUserByUserId(userId);
        return new ResponseEntity<>(user ,HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    // Update user
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user , @PathVariable("userId") String userId){
      User updateUser =  this.userService.updateUser(user, userId);
      return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    // Delete User

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") String userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted successfully ",true, HttpStatus.OK),  HttpStatus.OK);
    }


}
