package com.example.MovieReservationSystem.Services;

import com.example.MovieReservationSystem.Models.User;
import com.example.MovieReservationSystem.Repositories.UserRepository;
import org.hibernate.boot.model.process.internal.UserTypeResolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<User> createUser(User newUser){
            User user = userRepository.save(newUser);
            return ResponseEntity.ok(user);

    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserByID(String id){
        return userRepository.findById(id);
    }

    public ResponseEntity<User> updateUser(User updatedUser) {
        Optional<User> user = userRepository.findById(updatedUser.getId());
        if(user.isPresent()){
            User updated =  userRepository.save(updatedUser);
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();

    }

    public ResponseEntity<Optional<User>> deleteUserById(String id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
}
