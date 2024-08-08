package com.mireilleProject.OnlineShopping.config;

import com.mireilleProject.OnlineShopping.entities.Role;
import com.mireilleProject.OnlineShopping.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role("CUSTOMER"));
            roleRepository.save(new Role("ADMIN"));

        }
    }
}
