package com.mireilleProject.OnlineShopping.entities;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "role")
    private User user;
}
