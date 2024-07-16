package com.mireilleProject.OnlineShopping.repositories;

import com.mireilleProject.OnlineShopping.entity.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin, Long> {

    Optional<Admin> findAdminByEmail(String email);
    Boolean existsByEmail(String email);
}
