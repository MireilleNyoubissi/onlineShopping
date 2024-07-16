package com.mireilleProject.OnlineShopping.repositories;

import com.mireilleProject.OnlineShopping.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
