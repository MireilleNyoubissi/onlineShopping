package com.mireilleProject.OnlineShopping.repository;

import com.mireilleProject.OnlineShopping.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
