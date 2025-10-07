package com.example.MovieReservationSystem.Controllers;

import com.example.MovieReservationSystem.Models.User;
import com.example.MovieReservationSystem.Services.UserService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public ResponseEntity<User> getAllUsers(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserByID(@PathVariable String id){
        return userService.getUserByID(id);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User updatedUser){
        updatedUser.setId(id);
        return userService.updateUser(updatedUser);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Optional<User>> deleteUser(@PathVariable String id){
        return userService.deleteUserById(id);
    }
}
