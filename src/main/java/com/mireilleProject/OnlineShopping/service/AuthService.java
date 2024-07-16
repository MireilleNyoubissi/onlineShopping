package com.mireilleProject.OnlineShopping.service;

import com.mireilleProject.OnlineShopping.dto.AdminDto;
import com.mireilleProject.OnlineShopping.entity.Admin;
import com.mireilleProject.OnlineShopping.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    Admin findAdminByEmail(String email);

    String registerAdmin(AdminDto adminDto);

    String loginAdmin(AdminDto adminDto);

}
