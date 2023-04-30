package com.example.api.controller;

import com.example.api.base.BaseRest;
import com.example.api.filter.UserFilter;
import com.example.api.dto.CreateUserDto;
import com.example.api.dto.IsDeletedDto;
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
    @GetMapping("/{id}")
    public BaseRest<?>findById(@PathVariable Integer id){
       UserDto findId=userService.getById(id);
        return  BaseRest.builder()
                .code(200).status(true)
                .message("User Has Been Found")
                .data(findId)
                .build();
    }
@DeleteMapping("/{id}")
    public BaseRest<?>deletUserById(@PathVariable Integer id){
       Integer deleteId= userService.deleteUserById(id);
    return  BaseRest.builder()
            .code(200).status(true)
            .message("User Has Been Deleted")
            .data(deleteId)
            .build();
}
    @PutMapping("/{id}")
    public BaseRest<?>updateUserByStatus(@PathVariable Integer id , @RequestBody IsDeletedDto isDeletedDto){
        Integer deleteId= userService.updateIsDeletedStatus(id, isDeletedDto.status());
        return  BaseRest.builder()
                .code(200).status(true)
                .message("User Has Been Deleted")
                .data(deleteId)
                .build();
    }
    @GetMapping
    public BaseRest<?>findAllUser(@RequestParam(name="page",required = false,defaultValue ="1") int page,
                                  @RequestParam(name="limit",required = false,defaultValue = "20") int limit){

        return BaseRest.builder()
                .code(200).status(true)
                .message("Page Has Been Found")
                .data(userService.pages(page,limit))
                .build();
    }
    @GetMapping("/search/{name}")
    public BaseRest<?>searchUser(@RequestParam UserFilter userFilter){
        return BaseRest.builder()
                .code(200).status(true)
                .message("Page Has Been Found")
                .data( userService.searchByName(userFilter))
                .build();
    }
        @GetMapping("/searchByName/{name}")
    public BaseRest<?>searchUserByname(@PathVariable String name){
        return BaseRest.builder()
                .code(200).status(true)
                .message("Page Has Been Found")
                .data( userService.toSearchName(name))
                .build();
    }



}
