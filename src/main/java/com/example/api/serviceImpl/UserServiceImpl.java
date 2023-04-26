package com.example.api.serviceImpl;

import com.example.api.dto.CreateUserDto;
import com.example.api.dto.UserDto;
import com.example.api.mapper.UserMapStruct;
import com.example.api.mapper.UserMapper;
import com.example.api.model.User;
import com.example.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Component
public class UserServiceImpl implements UserService {
 private final UserMapper userMapper;
 private final UserMapStruct userMapStruct;
    @Override
    public UserDto createNewUser(CreateUserDto createUserDto) {
       User user=userMapStruct.fromCreateUserDtoToUser(createUserDto);
       userMapper.insert(user);
        return userMapStruct.userToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User>list=userMapper.selectAllUser();
        List<UserDto>acc=list.stream()
                .map(list1->new UserDto(list1.getName(),list1.getGender(),list1.getStudentCardId(),list1.getIsDeleted()))
                .toList();
        return acc;
    }

}
