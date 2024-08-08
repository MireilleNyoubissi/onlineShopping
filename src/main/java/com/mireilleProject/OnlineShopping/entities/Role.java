package com.mireilleProject.OnlineShopping.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users;

    public Role(String name){
        this.name = name;
    }

}
