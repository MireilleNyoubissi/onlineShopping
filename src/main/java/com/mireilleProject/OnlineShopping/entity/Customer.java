package com.mireilleProject.OnlineShopping.entity;

import com.mireilleProject.OnlineShopping.models.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "CUSTOMER")
public class Customer extends User {

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Subscriptions> subscriptions;
}
