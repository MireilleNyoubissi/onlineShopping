package com.mireilleProject.OnlineShopping.entity;


import com.mireilleProject.OnlineShopping.models.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ADMIN")
public class Admin extends User {
}
