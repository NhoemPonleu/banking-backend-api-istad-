package com.example.api.service;

import com.example.api.dto.SearchUserDto;
import com.example.api.filter.UserFilter;
import com.example.api.dto.CreateUserDto;
import com.example.api.dto.UpdateUserDto;
import com.example.api.dto.UserDto;
import com.example.api.model.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto createNewUser(CreateUserDto createUserDto);
   // List<UserDto> getAllUser();
    UserDto getById(Integer id);
    Integer deleteUserById(Integer id);
    Integer updateIsDeletedStatus(Integer id, boolean status);
    PageInfo<UserDto>pages(int page,int limit);
    UserDto updateUserById(Integer id, UpdateUserDto userDto);
    List<User> searchByName(UserFilter userFilter);
    User toSearchName(String name);
    List<UserDto>search(SearchUserDto userDto);
}
