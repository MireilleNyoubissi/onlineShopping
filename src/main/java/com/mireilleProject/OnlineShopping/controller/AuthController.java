package com.mireilleProject.OnlineShopping.controller;

import com.mireilleProject.OnlineShopping.dto.registerDto;
import com.mireilleProject.OnlineShopping.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class AdminController {

    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody registerDto registerDto) {
        String response = adminService.registerAdmin(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody registerDto registerDto){
        String response = adminService.loginAdmin(registerDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
