package com.mireilleProject.OnlineShopping.models;


import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

}