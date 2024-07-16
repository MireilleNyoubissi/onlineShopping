package com.mireilleProject.OnlineShopping.service;

import com.mireilleProject.OnlineShopping.dto.LoginDto;
import com.mireilleProject.OnlineShopping.dto.RegisterDto;
import com.mireilleProject.OnlineShopping.entity.Admin;

import java.util.Optional;


public interface AuthService {

    Optional<Admin> findAdminByEmail(String email);

    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);

}
