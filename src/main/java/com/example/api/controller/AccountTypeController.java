package com.example.api.controller;

import com.example.api.base.BaseRest;
import com.example.api.dto.AccountTypeDto;
import com.example.api.dto.UpdateAccountDto;
import com.example.api.model.AccountType;
import com.example.api.service.AccountTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account-type")
public class AccountTypeController {
    private final AccountTypeService accountTypeService;
    @GetMapping
    public BaseRest<?>selectAllAccount(){
        var accountTypeDtoList=accountTypeService.findAllAccount();
        System.out.println(accountTypeDtoList);
        return BaseRest.builder().status(true).code(200).message("Account have benn found")
                .data(accountTypeDtoList).timestamp(LocalDateTime.now()).build();
    }
    @PostMapping
    public BaseRest<?>create(@RequestBody @Valid AccountTypeDto accountTypeDto){
        AccountTypeDto userDto= accountTypeService.insertAccount(accountTypeDto);
        System.out.println(userDto);
        return  BaseRest.builder()
                .code(200).status(true)
                .data(userDto)
                .message("Account type has been created")
                .timestamp(LocalDateTime.now())
                .build();
    }
    @GetMapping("/{id}")
    public BaseRest<?>findById(@PathVariable Integer id){
        AccountTypeDto findId=accountTypeService.getAccountById(id);
        return  BaseRest.builder()
                .code(200).status(true)
                .message("Account Has Been Found")
                .timestamp(LocalDateTime.now())
                .data(findId)
                .build();
    }
    @PutMapping("/{id}")
    public BaseRest<?>updateAccount(@PathVariable Integer id , @RequestBody UpdateAccountDto accountTypeDto){

        AccountType deleteId= accountTypeService.updateAccount(id,accountTypeDto);
        return  BaseRest.builder()
                .code(200).status(true)
                .message("Account Has Been Updated")
                .data(deleteId)
                .build();
    }
    @DeleteMapping("/{id}")
    public BaseRest<?>deleteAccountById(@PathVariable Integer id){
        Integer deleteId= accountTypeService.deleteAccountTypeById(id);
        return  BaseRest.builder()
                .code(200).status(true)
                .message("Account Has Been Deleted")
                .data(deleteId)
                .build();
    }

}
