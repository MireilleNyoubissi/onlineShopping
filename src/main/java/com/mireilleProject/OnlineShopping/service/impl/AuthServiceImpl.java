package com.mireilleProject.OnlineShopping.service.impl;

import com.mireilleProject.OnlineShopping.dto.LoginDto;
import com.mireilleProject.OnlineShopping.dto.RegisterDto;
import com.mireilleProject.OnlineShopping.dto.UserDto;
import com.mireilleProject.OnlineShopping.entities.User;
import com.mireilleProject.OnlineShopping.repository.RoleRepository;
import com.mireilleProject.OnlineShopping.repository.UserRepository;
import com.mireilleProject.OnlineShopping.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDto registerDto) {

        //Check if username exist in database
        if (userRepository.existsByEmail(registerDto.getEmail())) {

            throw new RuntimeException("Email already exist in database");
        }

        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User has logged-in successfully";
    }


    //Convert entity into dto
    private UserDto mapToDto(User user) {
        UserDto userDto = mapper.map(user, UserDto.class);
        return userDto;
    }

    //Convert dto to entity
    private User mapToEntity(UserDto userDto) {
        User user = mapper.map(userDto, User.class);
        return user;
    }


}
