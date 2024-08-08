package com.mireilleProject.OnlineShopping.service;

import com.mireilleProject.OnlineShopping.dto.LoginDto;
import com.mireilleProject.OnlineShopping.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
