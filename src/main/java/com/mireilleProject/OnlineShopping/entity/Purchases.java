package com.mireilleProject.OnlineShopping.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "PURCHASES")
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Double amount;

    @Column
    private Date purchaseDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
