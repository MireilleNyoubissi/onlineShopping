package com.mireilleProject.OnlineShopping.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ADMINS")
@PrimaryKeyJoinColumn(name = "id")
public class Admin extends User {


}
