package com.example.api.mapper;

import com.example.api.dto.CreateUserDto;
import com.example.api.dto.UpdateUserDto;
import com.example.api.dto.UserDto;
import com.example.api.model.User;
import com.github.pagehelper.PageInfo;
import lombok.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User fromCreateUserDtoToUser(CreateUserDto createUserDto);
    UserDto userToUserDto(User user);
  //  User userDtoToUser(UserDto userDto);
    PageInfo<UserDto>userPageInfotoUserDtoPageInfo(PageInfo<User>pageInfo);
    User updateDtoToUser(UpdateUserDto userDto);
}
