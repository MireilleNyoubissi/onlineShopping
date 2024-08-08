package com.mireilleProject.OnlineShopping.repository;

import com.mireilleProject.OnlineShopping.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
