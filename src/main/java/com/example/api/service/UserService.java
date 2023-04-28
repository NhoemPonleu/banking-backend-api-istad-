package com.example.api.service;

import com.example.api.dto.CreateUserDto;
import com.example.api.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto createNewUser(CreateUserDto createUserDto);
   // List<UserDto> getAllUser();
    UserDto getById(Integer id);
    Integer deleteUserById(Integer id);
    Integer updateIsDeletedStatus(Integer id, boolean status);

}
