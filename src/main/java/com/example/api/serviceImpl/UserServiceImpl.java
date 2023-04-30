package com.example.api.serviceImpl;

import com.example.api.filter.UserFilter;
import com.example.api.dto.CreateUserDto;
import com.example.api.dto.UpdateUserDto;
import com.example.api.dto.UserDto;
import com.example.api.mapper.UserMapStruct;
import com.example.api.mapper.UserMapper;
import com.example.api.model.User;
import com.example.api.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
@Component
@Slf4j
public class UserServiceImpl implements UserService {
 private final UserMapper userMapper;
 private final UserMapStruct userMapStruct;
    @Override
    public UserDto createNewUser(CreateUserDto createUserDto) {
       User user=userMapStruct.fromCreateUserDtoToUser(createUserDto);
       userMapper.insert(user);
       log.info("User={}"+user.getId());
        return this.getById(user.getId());
    }
    @Override
    public UserDto getById(Integer id) {
        User userId=userMapper.slectById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with %d is not found",id)));
        return userMapStruct.userToUserDto(userId);
    }

    @Override
    public Integer deleteUserById(Integer id) {
      // UserDto idUser= getById(id);
       boolean isFound=userMapper.existById(id);
        if(isFound){
            userMapper.deleteUserById(id);
            return id;
        }
        throw  new ResponseStatusException(HttpStatus.NOT_FOUND,String
                .format("User with %d not found"+id));
    }

    @Override
    public Integer updateIsDeletedStatus(Integer id ,boolean status) {
        boolean isExisted=userMapper.existById(id);
        if(isExisted){
            userMapper.updateisDeletedById(id,status);
            return  id;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND
                ,String.format("User with %d is not found",id));
    }

    @Override
    public PageInfo<UserDto> pages(int page, int limit) {
      PageInfo<User>userPageInfo=PageHelper.startPage(page,limit)
                .doSelectPageInfo(userMapper::select);
        //call repository
      //  userMapper.select();
        return userMapStruct.userPageInfotoUserDtoPageInfo(userPageInfo);
    }

    @Override
    public UserDto updateUserById(Integer id, UpdateUserDto userDto) {
//        User userId=userMapper.slectById(id).orElseThrow(()->
//                new ResponseStatusException(HttpStatus.NOT_FOUND,
//                        String.format("User with %d is not found",id)));
//        user1=userMapStruct.updateDtoToUser(userDto);
//        userMapper.updateById(id);
        if(userMapper.existById(id)){
            userMapStruct.updateDtoToUser(userDto);
        }
        return null;
    }

    @Override
    public List<User> searchByName(UserFilter userFilter) {
        return userMapper.search(userFilter);
    }

    @Override
    public User toSearchName(String name) {

        return userMapper.searchUser(name);
    }


}
