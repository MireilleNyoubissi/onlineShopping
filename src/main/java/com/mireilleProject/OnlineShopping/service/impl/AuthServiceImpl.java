package com.mireilleProject.OnlineShopping.service.impl;

import com.mireilleProject.OnlineShopping.dto.AdminDto;
import com.mireilleProject.OnlineShopping.entity.Admin;
import com.mireilleProject.OnlineShopping.repositories.AdminRepository;
import com.mireilleProject.OnlineShopping.service.AdminService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AdminImpl implements AdminService, UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    private PasswordEncoder passwordEncoder;

    private ModelMapper mapper;

    private AuthenticationManager authenticationManager;

    public AdminImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public AdminImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }



    @Override
    public Admin findAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }



    @Override
    public String registerAdmin(AdminDto adminDto) {

        //Checks if email already exist in database

        if(adminRepository.findByEmail(adminDto.getEmail()) != null) {
            throw new EntityNotFoundException("Admin user not found");
        }

        Admin admin = new Admin();
        admin.setPassword(passwordEncoder.encode(adminDto.getPassword()));
        admin.setEmail(adminDto.getEmail());
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(admin.getLastName());
        adminRepository.save(admin);

        return "Admin user registered successfully";
    }

    @Override
    public String loginAdmin(AdminDto adminDto) {

        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(adminDto.getEmail(), adminDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "Admin user has logged in successfully";
    }




    private AdminDto mapToDTO(Admin admin) {

        AdminDto adminDto = mapper.map(admin, AdminDto.class);
        return adminDto;
    }


    private Admin mapToEntity(AdminDto adminDto) {

        Admin admin = mapper.map(adminDto, Admin.class);
        return admin;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
