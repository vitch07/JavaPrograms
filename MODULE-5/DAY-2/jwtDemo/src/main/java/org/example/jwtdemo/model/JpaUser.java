package org.example.jwtdemo.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class JpaUser {
    @Id
    @GeneratedValue
    @Column(name = "Primary_key_id")
    private Long id;
    private String username;
    private String password;
    private String roles;

}