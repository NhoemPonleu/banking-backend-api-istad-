package com.example.api.controller;

import com.example.api.base.BaseRest;
import com.example.api.dto.CreateUserDto;
import com.example.api.dto.UserDto;
import com.example.api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public BaseRest<?>create(@RequestBody @Valid CreateUserDto createUserDto){
      UserDto userDto= userService.createNewUser(createUserDto);
        System.out.println(userDto);
        return  BaseRest.builder()
                .code(200).status(true)
                .data(userDto)
                .build();
    }
    @GetMapping
    public BaseRest<?>getAll(){
        var getAllUser=userService.getAllUser();
        return BaseRest.builder()
                .status(true)
                .message("sucess")
                .data(getAllUser)
                .build();
    }

}
