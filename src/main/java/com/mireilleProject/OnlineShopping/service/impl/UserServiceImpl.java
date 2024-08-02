package com.mireilleProject.OnlineShopping.service.impl;

import com.mireilleProject.OnlineShopping.dto.UserDto;
import com.mireilleProject.OnlineShopping.entities.User;
import com.mireilleProject.OnlineShopping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper mapper;

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
