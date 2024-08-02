package com.mireilleProject.OnlineShopping.repository;

import com.mireilleProject.OnlineShopping.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
