package com.mireilleProject.OnlineShopping.repositories;

import com.mireilleProject.OnlineShopping.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
