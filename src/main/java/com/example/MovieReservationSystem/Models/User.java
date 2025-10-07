package com.example.MovieReservationSystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;
    private String username;
    private String email;
    public User(){
        this.id = UUID.randomUUID().toString();
    }

}
