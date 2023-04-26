package com.example.api.service;

import com.example.api.dto.CreateUserDto;
import com.example.api.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto createNewUser(CreateUserDto createUserDto);
    List<UserDto> getAllUser();
}
