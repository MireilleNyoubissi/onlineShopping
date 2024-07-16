package com.mireilleProject.OnlineShopping.service.impl;

import com.mireilleProject.OnlineShopping.dto.LoginDto;
import com.mireilleProject.OnlineShopping.dto.RegisterDto;
import com.mireilleProject.OnlineShopping.entity.Admin;
import com.mireilleProject.OnlineShopping.entity.Role;
import com.mireilleProject.OnlineShopping.repositories.AdminRepository;
import com.mireilleProject.OnlineShopping.repositories.RoleRepository;
import com.mireilleProject.OnlineShopping.service.AuthService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

//@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private AdminRepository adminRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private ModelMapper mapper;
    private AuthenticationManager authenticationManager;


    public AuthServiceImpl(AdminRepository adminRepository,
                             RoleRepository roleRepository,
                             PasswordEncoder passwordEncoder,
                             ModelMapper mapper,
                             AuthenticationManager authenticationManager) {

        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
        this.authenticationManager = authenticationManager;

    }

    @Override
    public Optional<Admin> findAdminByEmail(String email) {
        return adminRepository.findAdminByEmail(email);
    }

    @Override
    public String register(RegisterDto registerDto) {

        //Checks if email already exist in database

        if(adminRepository.existsByEmail(registerDto.getEmail())) {
            throw new EntityNotFoundException("Email already exists");
        }

        Admin admin = new Admin();
        admin.setFirstName(registerDto.getFirstName());
        admin.setLastName(registerDto.getLastName());
        admin.setEmail(registerDto.getEmail());
        admin.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role adminRole = roleRepository.findByName("ADMIN");
        roles.add(adminRole);
        admin.setRoles(roles);


        adminRepository.save(admin);

        return "Admin user has been registered successfully";
    }

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "Admin user has logged-in successfully";
    }




    private RegisterDto mapToDTO(Admin admin) {

        RegisterDto registerDto = mapper.map(admin, RegisterDto.class);
        return registerDto;
    }


    private Admin mapToEntity(RegisterDto registerDto) {

        Admin admin = mapper.map(registerDto, Admin.class);
        return admin;
    }

}
